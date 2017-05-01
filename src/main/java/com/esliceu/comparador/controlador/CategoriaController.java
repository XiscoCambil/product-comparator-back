package com.esliceu.comparador.controlador;

import com.esliceu.comparador.bean.CategoriaBean;
import com.esliceu.comparador.model.Categoria;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * Created by blackwidow on 22/04/17.
 */
@RestController
public class CategoriaController extends CategoriaBean{

    @RequestMapping("/ObtenerTodasCategorias")
    public List<Categoria> obtenerTodasCategorias(){
        return (List<Categoria>) getCategoriaDao().findAll();
    }

    @RequestMapping("/ObtenerCategoriaPorNombre")
    public Categoria obtenerCategoriaPorNombre(@RequestParam(required = true) String nombre){
        return  getCategoriaDao().findByNombre(nombre);
    }

    @RequestMapping("/ObtenerCategoriasPorPadre")
    public List<Categoria> obtenerCategoriasPorPadre(@RequestParam(required = true) Long padre){
        return  getCategoriaDao().findByPadre(padre);
    }
}
