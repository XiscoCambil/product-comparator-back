package com.esliceu.comparador.controlador;

import com.esliceu.comparador.bean.ProductoTiendaBean;
import com.esliceu.comparador.dao.ProductoDao;
import com.esliceu.comparador.dao.TiendaDao;
import com.esliceu.comparador.model.Producto;
import com.esliceu.comparador.model.ProductoTienda;
import com.esliceu.comparador.model.Tienda;
import com.esliceu.comparador.util.AccesToken;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

/**
 * Created by blackwidow on 24/04/17.
 */
@RestController
public class ProductoTiendaController extends ProductoTiendaBean{

    @Autowired
    private TiendaDao tiendaDao;

    @Autowired
    private ProductoDao productoDao;

    @Autowired
    private ProductoTienda productoTienda;


    @RequestMapping("/productoTienda/obtenerTodosProductoTienda")
    public List<ProductoTienda> obtenerTodosProductoTienda(){
        return (List<ProductoTienda>) getProductoTiendaDao().findAll();
    }

    @RequestMapping("/productoTienda/obtenerProductoTiendaPorId")
    public ProductoTienda obtenerProductoTiendaPorId(@RequestParam long id){
        return getProductoTiendaDao().findOne(id);
    }

    @RequestMapping("/productoTienda/obtenerListaProductoTiendasPorId")
    public List<ProductoTienda> obtenerListaProductoTiendasPorId(@RequestParam List<Long> id_productosTiendas) throws IOException {
        try{
            return getProductoTiendaDao().findByIdIn(id_productosTiendas);
        }catch (Exception e){
            httpServletResponse.sendError(300);
        }
        return null;
    }





}
