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

    @RequestMapping("/marca/obtenerTodasMarcas")
    public List<Marca> obtenerTodasMarcas(){
        return (List<Marca>) getMarcaDao().findAll();
    }

    @RequestMapping("/marca/obtenerMarcaPorNombre")
    public Marca obtenerMarcaPorNombre(@RequestParam String nombre){
        return getMarcaDao().findByNombre(nombre);
    }

    @RequestMapping("/marca/obtenerMarcaPorId")
    public Marca obtenerMarcaPorId(@RequestParam long id)
    {
        return getMarcaDao().findById(id);
    }

    @RequestMapping("/marca/obtenerMarcaPorEmpresa")
    public List<Marca> obtenerMarcaPorEmpresa(@RequestParam long id){
        return getMarcaDao().findByIdEmpresa(id);
    }
}
