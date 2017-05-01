package com.esliceu.comparador.controlador;

import com.esliceu.comparador.bean.MarcaBean;
import com.esliceu.comparador.model.Marca;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * Created by blackwidow on 22/04/17.
 */
@RestController
public class MarcaController extends MarcaBean {

    @RequestMapping("/ObtenerTodasMarcas")
    public List<Marca> obtenerTodasMarcas(){
        return (List<Marca>) getMarcaDao().findAll();
    }

    @RequestMapping("/ObtenerMarcaPorNombre")
    public Marca obtenerMarcaPorNombre(@RequestParam(required = true) String nombre){
        return getMarcaDao().findByNombre(nombre);
    }

    @RequestMapping("/ObtenerMarcaPorId")
    public Marca obtenerMarcaPorId(@RequestParam(required = true) long id){
        return getMarcaDao().findById(id);
    }

    @RequestMapping("/ObtenerMarcaPorEmpresa")
    public List<Marca> obtenerMarcaPorEmpresa(@RequestParam(required = true) long id){
        return getMarcaDao().findByIdEmpresa(id);
    }
}
