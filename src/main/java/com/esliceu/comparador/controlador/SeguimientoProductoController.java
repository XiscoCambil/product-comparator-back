package com.esliceu.comparador.controlador;

import com.esliceu.comparador.bean.SeguimientoProductoBean;
import com.esliceu.comparador.model.SeguimientoProducto;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;

/**
 * Created by blackwidow on 26/04/17.
 */
@RestController
public class SeguimientoProductoController extends SeguimientoProductoBean {

    @RequestMapping(value = "/usuario/seguimiento/ObtenerTodosLosSeguimientos",method = RequestMethod.POST)
    public @ResponseBody  List<SeguimientoProducto> obtenerTodosLosSeguimientos(@RequestBody Map<String,Object> json){
        return  getSeguimientoProductoDao().findByIdUsuario((long)json.get("idUsuario"));
    }
}
