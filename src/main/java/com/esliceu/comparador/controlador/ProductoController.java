package com.esliceu.comparador.controlador;

import com.esliceu.comparador.bean.ProductoBean;
import com.esliceu.comparador.dao.ProductoValoracionDao;
import com.esliceu.comparador.dao.TiendaDao;
import com.esliceu.comparador.model.*;
import com.esliceu.comparador.util.JWT;
import com.esliceu.comparador.util.Token;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.data.convert.Jsr310Converters;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.io.UnsupportedEncodingException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Date;
import java.util.List;

/**
 * Created by blackwidow on 24/04/17.
 */
@RestController
public class ProductoController extends ProductoBean {

    @Autowired
    private TiendaDao tiendaDao;

    @Autowired
    private ProductoValoracionDao productoValoracionDao;

    @Qualifier("categoria")
    Categoria categoria;

    @RequestMapping("/producto/obtenerTodosProductos")
    public List<Producto> obtenerTodosProductos() throws UnsupportedEncodingException {
        return (List<Producto>) getProductoDao().findAll();
    }

    @RequestMapping("/producto/obtenerProductosPorLocalidad")
    public List<Producto> obtenerProductosPorLocalidad(
            @RequestParam int id_localidad,Long id_categoria){

        List<Tienda> tiendas = tiendaDao.findByIdLocalidad(id_localidad);
        List<Producto> productos = new ArrayList<>();
        boolean productoEnLista = false;
        for(Tienda tienda: tiendas){
            for(ProductoTienda pt: tienda.getProductosTienda()){
                if(productos.size() > 0){
                    for(Producto producto : productos){
                        if(producto.getId() == pt.getIdProducto()){
                            productoEnLista = true;
                            break;
                        }else{
                            productoEnLista = false;
                        }
                    }
                    if(!productoEnLista){
                        productos.add(getProductoDao().findOne(pt.getIdProducto()));
                    }
                }else{
                    productos.add(getProductoDao().findOne(pt.getIdProducto()));
                }
            }
        }

        return null;

    }

    @RequestMapping("/productos/obtenerValoracionesProducto")
    public List<ProductoValoracion> obtenerTodosProductoValoracion(){
        return (List<ProductoValoracion>) productoValoracionDao.findAll();
    }



    private boolean productoEnCategoria(Producto producto,Long id_categoria){
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


   /* @RequestMapping("/ObtenerMarcaPorNombre")
    public Marca obtenerMarcaPorNombre(@RequestParam(required = true) String nombre){
        return getMarcaDao().findByNombre(nombre);
    }
    */
}
