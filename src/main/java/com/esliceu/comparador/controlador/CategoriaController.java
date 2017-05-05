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
public class CategoriaController extends CategoriaBean {

    @RequestMapping("/ObtenerTodasCategorias")
    public List<Categoria> obtenerTodasCategorias() {
        return (List<Categoria>) getCategoriaDao().findAll();
    }

    @RequestMapping("/categoria/ObtenerCategoriaPorNombre")
    public Categoria obtenerCategoriaPorNombre(@RequestParam(required = true) String nombre) {
        return getCategoriaDao().findByNombre(nombre);
    }

    @RequestMapping("/categoria/ObtenerHijosDeCategoriaPadre")
    public List<Categoria> ObtenerHijosDeCategoriaPadre(@RequestParam(required = true) Long id_padre) {
        List<Categoria> hijos;
        setCategoria(getCategoriaDao().findById(id_padre));
        if (getCategoria() != null) {
            hijos = getCategoriaDao().findByPadre(getCategoria());
            if(hijos.size() == 0){
                return null;
            }
            return hijos;
        }
        return null;
    }

}
