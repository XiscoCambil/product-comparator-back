package com.esliceu.comparador.controlador;

import com.esliceu.comparador.bean.ProductoCarroBean;
import com.esliceu.comparador.model.ProductoCarro;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * Created by blackwidow on 26/04/17.
 */
@RestController
public class ProductoCarroController extends ProductoCarroBean {

   @RequestMapping("/productoCarro/obtenerProductoCarroPorId")
    public List<ProductoCarro> obtenerProductoCarroPorId(@RequestParam Long id_carro){
       return (List<ProductoCarro>) getProductoCarro().findOne(id_carro);
   }

    @RequestMapping("/productoCarro/obtenerProductoCarroPorIdCarro")
    public List<ProductoCarro> obtenerProductoCarroPorIdCarro(@RequestParam Long id_carro){
        return (List<ProductoCarro>) getProductoCarro().findByIdCarro(id_carro);
    }


}
