package com.esliceu.comparador.controlador;

import com.esliceu.comparador.bean.HistorialProductoTiendaBean;
import com.esliceu.comparador.model.HistorialProductoTienda;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * Created by blackwidow on 26/04/17.
 */
@RestController
public class HistorialProductoTiendaController extends HistorialProductoTiendaBean {

    @RequestMapping("/obtenerTodosLosHistoriales")
    public List<HistorialProductoTienda> obtenerTodosLosHistoriales(){
        return (List<HistorialProductoTienda>) getHistorialProductoTiendaDao().findAll();
    }

    @RequestMapping("/productoHistorial/obtenerHistorialDelProductoTienda")
    public List<HistorialProductoTienda> obtenerHistorialProductoDelProductoTienda(
            @RequestParam(required = true) Long id_producto_tienda){
        return  getHistorialProductoTiendaDao().findByIdProductoTienda(id_producto_tienda);
    }
}
