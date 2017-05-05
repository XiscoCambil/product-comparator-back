package com.esliceu.comparador.controlador;

import com.esliceu.comparador.bean.ProductoBean;
import com.esliceu.comparador.dao.TiendaDao;
import com.esliceu.comparador.model.Producto;
import com.esliceu.comparador.model.ProductoTienda;
import com.esliceu.comparador.model.Tienda;
import com.esliceu.comparador.model.Usuario;
import com.esliceu.comparador.util.JWT;
import com.esliceu.comparador.util.Token;
import org.springframework.beans.factory.annotation.Autowired;
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

    @RequestMapping("/ObtenerTodosProductos")
    public Token obtenerTodosProductos() throws UnsupportedEncodingException {
        return null;
        //return (List<Producto>) getProductoDao().findAll();
    }

    @RequestMapping("/producto/obtenerProductosPorLocalidad")
    public List<Producto> obtenerProductosPorLocalidad(
            @RequestParam(required=true) int id_localidad){
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
        return productos;
    }

   /* @RequestMapping("/ObtenerMarcaPorNombre")
    public Marca obtenerMarcaPorNombre(@RequestParam(required = true) String nombre){
        return getMarcaDao().findByNombre(nombre);
    }
    */
}
