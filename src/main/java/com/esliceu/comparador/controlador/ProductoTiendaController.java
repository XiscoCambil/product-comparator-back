package com.esliceu.comparador.controlador;

import com.esliceu.comparador.bean.ProductoTiendaBean;
import com.esliceu.comparador.model.ProductoTienda;
import com.esliceu.comparador.model.Tienda;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * Created by blackwidow on 24/04/17.
 */
@RestController
public class ProductoTiendaController extends ProductoTiendaBean{

    @RequestMapping("/ObtenerTodosProductoTienda")
    public List<ProductoTienda> obtenerTodosProductoTienda(){
        return (List<ProductoTienda>) getProductoTiendaDao().findAll();
    }

   /* @RequestMapping("/ObtenerMarcaPorNombre")
    public Marca obtenerMarcaPorNombre(@RequestParam(required = true) String nombre){
        return getMarcaDao().findByNombre(nombre);
    }
    */

}
