package com.esliceu.comparador.controlador;

import com.esliceu.comparador.bean.ProductoCarroBean;
import com.esliceu.comparador.model.ProductoCarro;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * Created by blackwidow on 26/04/17.
 */
@RestController
public class ProductoCarroController extends ProductoCarroBean {

   @RequestMapping("/obtenerTodosLosCarros")
    public List<ProductoCarro> obtenerTodosLosCarros(){
       return (List<ProductoCarro>) getProductoCarro().findAll();
   }

}
