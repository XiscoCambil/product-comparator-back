package com.esliceu.comparador.controlador;

import com.esliceu.comparador.bean.HistorialProductoBean;
import com.esliceu.comparador.model.HistorialProductoTienda;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * Created by blackwidow on 26/04/17.
 */
@RestController
public class HistorialProductoCategoria extends HistorialProductoBean {


    @RequestMapping("/obtenerTodosLosHistoriales")
    public List<HistorialProductoTienda> obtenerTodosLosHistoriales(){
        return (List<HistorialProductoTienda>) getHistorialProductoDao().findAll();
    }
}
