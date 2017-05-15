package com.esliceu.comparador.controlador;

import com.esliceu.comparador.bean.EmpresaBean;
import com.esliceu.comparador.model.Empresa;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * Created by blackwidow on 21/04/17.
 */
@RestController
public class EmpresaController extends EmpresaBean{

    @RequestMapping("/ObtenerTodasEmpresas")
    public List<Empresa> obtenerTodasEmpresas(){
        return (List<Empresa>) getEmpresaDao().findAll();
    }

    @RequestMapping("/empresa/obtenerEmpresaPorId")
    public Empresa obtenerEmpresaPorId(@RequestParam(required = true) long id){
        return getEmpresaDao().findById(id);
    }


}
