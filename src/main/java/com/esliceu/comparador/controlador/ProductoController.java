package com.esliceu.comparador.controlador;

import com.esliceu.comparador.bean.ProductoBean;
import com.esliceu.comparador.model.Producto;
import com.esliceu.comparador.model.Usuario;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * Created by blackwidow on 24/04/17.
 */
@RestController
public class ProductoController extends ProductoBean {

    @RequestMapping("/ObtenerTodosProductos")
    public List<Producto> obtenerTodosProductos(){
        return (List<Producto>) getProductoDao().findAll();
    }

   /* @RequestMapping("/ObtenerMarcaPorNombre")
    public Marca obtenerMarcaPorNombre(@RequestParam(required = true) String nombre){
        return getMarcaDao().findByNombre(nombre);
    }
    */
}
