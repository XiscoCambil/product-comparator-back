package com.esliceu.comparador.controlador;

import com.esliceu.comparador.bean.TiendaBean;
import com.esliceu.comparador.model.ProductoTienda;
import com.esliceu.comparador.model.Tienda;
import com.esliceu.comparador.util.AccesToken;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by blackwidow on 24/04/17.
 */
@RestController
public class TiendaController extends TiendaBean{

    @RequestMapping("/ObtenerTodasTiendas")
    public List<Tienda> obtenerTodasTiendas(){
        return (List<Tienda>) getTiendaDao().findAll();
    }
/*
    @RequestMapping("/tienda/obtenerTiendasPorProductoYLocalidad")
    public List<Tienda> obtenerTiendasPorProducto(
            @RequestParam Long id_producto,
            @RequestParam int id_localidad){
        boolean existeProductoEnTienda = false;
        List<Tienda> tiendas = getTiendaDao().findByIdLocalidad(id_localidad);
        List<Tienda> tiendasConProducto = new ArrayList<>();
        for(Tienda tienda : tiendas){
            for(ProductoTienda pt : tienda.getProductosTienda()){
                if(pt.getIdProducto() == id_producto){
                    existeProductoEnTienda = true;
                    break;
                }else{
                    existeProductoEnTienda = false;
                }
            }
            if(existeProductoEnTienda){
                tiendasConProducto.add(tienda);
            }
        }
        return tiendasConProducto;
    }
*/
    @RequestMapping("/tienda/obtenerTiendasPorIds")
    public List<Tienda> obtenerTiendasPorProducto(
            @RequestParam List<Long> id_tiendas)
    {
        List<Tienda> tiendas = getTiendaDao().findByIdIn(id_tiendas);
        return tiendas;
    }

    @RequestMapping("/productoTienda/obtenerTiendasPorProductos")
    public  List<Tienda> obtenerTiendasPorProductos(@RequestParam List<Long> id_tiendas) throws IOException {
        try {
            return getTiendaDao().findByIdIn(id_tiendas);
        } catch (Exception e) {
            httpServletResponse.sendError(300);
            return null;
        }
    }

}
