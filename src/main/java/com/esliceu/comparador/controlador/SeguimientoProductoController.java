package com.esliceu.comparador.controlador;

import com.esliceu.comparador.bean.SeguimientoProductoBean;
import com.esliceu.comparador.model.SeguimientoProducto;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * Created by blackwidow on 26/04/17.
 */
@RestController
public class SeguimientoProductoController extends SeguimientoProductoBean {

    @RequestMapping("/usuario/seguimiento/ObtenerTodosLosSeguimientos")
    public @ResponseBody  List<SeguimientoProducto> obtenerTodosLosSeguimientos(){
        return (List<SeguimientoProducto>) getSeguimientoProductoDao().findAll();
    }
}
