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

    @RequestMapping("/tienda/obtenerTiendasPorIds")
    public List<Tienda> obtenerTiendasPorIds(
            @RequestParam  List<Long> id_tiendas
    )
    {
        List<Tienda> tiendas = getTiendaDao().findByIdIn(id_tiendas);
        return tiendas;
    }

}
