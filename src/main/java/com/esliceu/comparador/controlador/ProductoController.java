package com.esliceu.comparador.controlador;

import com.esliceu.comparador.bean.ProductoBean;
import com.esliceu.comparador.dao.ProductoTiendaDao;
import com.esliceu.comparador.dao.ProductoValoracionDao;
import com.esliceu.comparador.dao.TiendaDao;
import com.esliceu.comparador.model.*;
import com.esliceu.comparador.util.AccesToken;
import jdk.nashorn.internal.scripts.JO;
import org.hibernate.Filter;
import org.hibernate.Session;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.web.bind.annotation.*;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;
import javax.persistence.criteria.*;
import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.util.*;


/**
 * Created by blackwidow on 24/04/17.
 */
@RestController
public class ProductoController extends ProductoBean {

    @Autowired
    private TiendaDao tiendaDao;

    @Autowired
    private ProductoValoracionDao productoValoracionDao;

    @Autowired
    private ProductoTiendaDao productoTiendaDao;

    @Qualifier("categoria")
    private Categoria categoria;

    @PersistenceContext
    private EntityManager em;

    @RequestMapping("/producto/obtenerTodosProductos")
    public List<Producto> obtenerTodosProductos() throws UnsupportedEncodingException {
        return (List<Producto>) getProductoDao().findAll();
    }

    @RequestMapping("/producto/obtenerProducto")
    public Producto obtenerProducto(@RequestParam long id_producto) throws IOException {
        try {
            return getProductoDao().findOne(id_producto);
        }catch (Exception e){
            httpServletResponse.sendError(300);
            return null;
        }
    }


    @RequestMapping("/producto/obtenerProductosPorLocalidad")
    public @ResponseBody List<Producto> obtenerProductosPorLocalidad(
            @RequestBody Map<String,Object> json) throws IOException {

        AccesToken accesToken = validarToken(json);
        try{
            long categoriaGeneral,subcategoria,categoriaProducto,calorias;
            double hidratos,grasas,proteinas;
            int localidad;

            int maxResult = 20;
            int page = 0;
            if(accesToken != null){
                categoriaGeneral = Long.parseLong(String.valueOf(json.get("categoriaGeneral")));
                subcategoria = Long.parseLong(String.valueOf(json.get("subcategoria")));
                categoriaProducto = Long.parseLong(String.valueOf(json.get("categoriaProductos")));
                calorias = Long.parseLong(String.valueOf(json.get("calorias")));
                proteinas = Double.parseDouble(String.valueOf(json.get("proteinas")));
                grasas = Double.parseDouble(String.valueOf(json.get("grasas")));
                hidratos = Double.parseDouble(String.valueOf(json.get("hidratos")));
                localidad = Integer.parseInt(String.valueOf(json.get("localidad")));

                List<Producto> productos = new ArrayList<>();
                CriteriaBuilder builder = em.getCriteriaBuilder();
                CriteriaQuery query  = builder.createQuery(Producto.class);
                Root<Producto> from = query.from(Producto.class);
                List<Predicate> predicates = new ArrayList<>();
                predicates.add(builder.lt(from.get("valorEnergetico"),calorias));
                predicates.add(builder.lt(from.get("carbohidratos"),hidratos));
                predicates.add(builder.lt(from.get("grasas"),grasas));
                predicates.add(builder.lt(from.get("proteinas"),proteinas));

                if(categoriaGeneral == 0 && subcategoria == 0 && categoriaProducto == 0){
                   if(localidad != 0){
                       query.select(from).where(predicates.toArray(new Predicate[]{}));
                       em.createQuery(query).setMaxResults(maxResult).setFirstResult(page).getResultList();
                       return productoEnLocalidad(
                               localidad,
                               em.createQuery(query).setMaxResults(maxResult).setFirstResult(page).getResultList()
                       );
                   }else{
                       return em.createQuery(query).setMaxResults(maxResult).setFirstResult(page).getResultList();
                   }
                }else{
                    if(categoriaProducto != 0){
                       predicates.add(builder.equal(from.get("idCategoria"),categoriaProducto));
                    }
                }
                query.select(from).where(predicates.toArray(new Predicate[]{}));
                productos = em.createQuery(query).setMaxResults(maxResult).setFirstResult(page).getResultList();
                if(localidad != 0){
                    return productoEnLocalidad(localidad,productos);
                }
            }else{
                throw new Exception();
            }
        }catch (Exception e) {
            httpServletResponse.sendError(300);
        }
        return null;
    }

    @RequestMapping("/productos/obtenerValoracionesProducto")
    public List<ProductoValoracion> obtenerTodosProductoValoracion(){
        return (List<ProductoValoracion>) productoValoracionDao.findAll();
    }


    private boolean productoEnCategoria(Producto producto,Long id_categoria) throws IOException {
        boolean productoEnCategoria = false;
        boolean categoriaConHijos = false;
        CategoriaController categoriaController = new CategoriaController();
        categoria = getCategoriaDao().findById(producto.getIdCategoria());
        List<Categoria> categoriasHijas = categoriaController.ObtenerHijosDeCategoriaPadre(categoria.getId());
        for(Categoria categoriaHija : categoriasHijas){
            if(categoriaHija.getId() == id_categoria){
                productoEnCategoria = true;
                break;
            }else{
                List<Categoria> categoriasHijas2 = categoriaController.ObtenerHijosDeCategoriaPadre(categoriaHija.getId());
                if(categoriasHijas2 != null){
                    productoEnCategoria(producto,categoriaHija.getId());
                }
                return false;
            }
        }
        if(productoEnCategoria){
            return true;
        }
        return false;
        }

        private List<Producto> productoEnLocalidad(int id_localidad,List<Producto> productos){
            boolean match = false;
            if(id_localidad == 0){
                return productos;
            }else{
                List<Producto> productosFiltrados = new ArrayList<>();
                List<Tienda> tiendas = tiendaDao.findByIdLocalidad(id_localidad);
                for (Producto producto: productos){
                    if(producto.getProductoTiendas().size() > 0){
                        for (ProductoTienda productoTienda : producto.getProductoTiendas()){
                            for(Tienda tienda : tiendas){
                                if(productoTienda.getIdTienda() == tienda.getId()){
                                    productosFiltrados.add(producto);
                                    match = true;
                                    break;
                                }
                            }
                            if(match){
                                match = false;
                                break;
                            }
                        }
                    }
                }
                return productosFiltrados;
            }

        }
}
