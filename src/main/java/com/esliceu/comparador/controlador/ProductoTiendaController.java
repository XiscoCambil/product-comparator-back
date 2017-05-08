package com.esliceu.comparador.controlador;

import com.esliceu.comparador.bean.ProductoTiendaBean;
import com.esliceu.comparador.dao.ProductoDao;
import com.esliceu.comparador.dao.TiendaDao;
import com.esliceu.comparador.model.Producto;
import com.esliceu.comparador.model.ProductoTienda;
import com.esliceu.comparador.model.Tienda;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by blackwidow on 24/04/17.
 */
@RestController
public class ProductoTiendaController extends ProductoTiendaBean{

    @Autowired
    private TiendaDao tiendaDao;

    @Autowired
    private ProductoDao productoDao;


    @RequestMapping("/obtenerTodosProductoTienda")
    public List<ProductoTienda> obtenerTodosProductoTienda(){
        return (List<ProductoTienda>) getProductoTiendaDao().findAll();
    }

    @RequestMapping("/productoTienda/obtenerProductoTiendaPorId")
    public ProductoTienda obtenerProductoTiendaPorId(@RequestParam long id){
        return getProductoTiendaDao().findById(id);
    }



}
