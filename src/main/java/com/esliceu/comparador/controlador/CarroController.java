package com.esliceu.comparador.controlador;

import com.esliceu.comparador.bean.CarroBean;
import com.esliceu.comparador.model.Carro;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * Created by blackwidow on 26/04/17.
 */
@RestController
public class CarroController extends CarroBean {

    @RequestMapping("/obtenerCarros")
    public List<Carro> obtenerTodosCarros(){
        return (List<Carro>) getCarroDao().findAll();
    }
}
