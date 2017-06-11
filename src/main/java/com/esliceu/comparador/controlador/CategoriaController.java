package com.esliceu.comparador.controlador;

import com.esliceu.comparador.bean.CategoriaBean;
import com.esliceu.comparador.model.Categoria;
import com.esliceu.comparador.util.Keys;
import io.jsonwebtoken.lang.Assert;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.io.IOException;
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

    @RequestMapping("/categoria/obtenerCategoriaPorId")
    public Categoria obtenerCategoriaPorNombre(Long id_categoria) {
        return getCategoriaDao().findById(id_categoria);
    }

    @RequestMapping("/categoria/ObtenerHijosDeCategoriaPadre")
    public List<Categoria> ObtenerHijosDeCategoriaPadre(@RequestParam Long id_padre) throws IOException {
        try {
            List<Categoria> categorias = getCategoriaDao().findByPadre(getCategoriaDao().findById(id_padre));
            if (categorias != null && categorias.size() > 0) {
                return categorias;
            }
        }catch (Exception e){
            httpServletResponse.sendError(300);
        }
        return null;
    }



    @RequestMapping("/categoria/obtenerCategoriasTop")
    public List<Categoria> obtenerCategoriasTop() {
      return getCategoriaDao().findByPadre(null);
    }

    @RequestMapping("/categoria/obtenerTodasCategoriasPorPadre")
    public List<Categoria> obtenerTodasCategoriasPorPadre(@RequestParam boolean esSubCategoria) {
        List<Categoria> categorias = getCategoriaDao().findByPadre(null);
        List<Categoria> subcategorias = getCategoriaDao().findByPadreIn(categorias);
        if(!esSubCategoria) {
            return getCategoriaDao().findByPadreIn(subcategorias);
        }
        return subcategorias;
    }


    /*
    @RequestMapping("/categoria/obtenerPaco")
    public Page<Categoria> paco() {
        Categoria categoria = getCategoriaDao().findById((long)2);
        Pageable topTen = new PageRequest(0, 1);
        Page<Categoria> result = getCategoriaDao().findByPadre(categoria, topTen);
        return result;
    }
*/
}
