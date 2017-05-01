package com.esliceu.comparador.controlador;

import com.esliceu.comparador.bean.ProductoValoracionBean;
import com.esliceu.comparador.model.ProductoValoracion;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * Created by blackwidow on 26/04/17.
 */
@RestController
public class ProductoValoracionController extends ProductoValoracionBean {

    @RequestMapping("/productos/obtenerValoracionesProducto")
    public List<ProductoValoracion> obtenerTodosProductoValoracion(){
        return (List<ProductoValoracion>) getProductoValoracionDao().findAll();
    }
}
