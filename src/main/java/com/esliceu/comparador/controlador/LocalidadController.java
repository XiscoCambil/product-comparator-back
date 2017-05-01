package com.esliceu.comparador.controlador;

import com.esliceu.comparador.bean.LocalidadBean;
import com.esliceu.comparador.model.Localidad;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * Created by blackwidow on 21/04/17.
 */
@RestController
public class LocalidadController extends LocalidadBean {

    @RequestMapping("/ObtenerTodasLocalidades")
    public List<Localidad> obtenerTodasLocalidades(){
        return (List<Localidad>) getLocalidadDao().findAll();
    }

    @RequestMapping("/ObtenerLocalidadPorNombre")
    public Localidad obtenerLocalidadPorNombre(@RequestParam(required = true) String nombre){
        return getLocalidadDao().findByNombre(nombre);
    }

    @RequestMapping("/ObtenerLocalidadPorId")
    public Localidad obtenerLocalidadPorId(@RequestParam(required = true) long id){
        return getLocalidadDao().findById(id);
    }



}
