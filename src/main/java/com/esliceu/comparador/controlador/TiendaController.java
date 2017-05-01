package com.esliceu.comparador.controlador;

import com.esliceu.comparador.bean.TiendaBean;
import com.esliceu.comparador.model.Marca;
import com.esliceu.comparador.model.Tienda;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

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

   /* @RequestMapping("/ObtenerMarcaPorNombre")
    public Marca obtenerMarcaPorNombre(@RequestParam(required = true) String nombre){
        return getMarcaDao().findByNombre(nombre);
    }
    */
}
