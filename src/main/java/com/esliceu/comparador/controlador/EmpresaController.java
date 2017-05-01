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

    @RequestMapping("/ObtenerEmpresaPorNombre")
    public Empresa obtenerEmpresaPorNombre(@RequestParam(required = true) String nombre){
        return  getEmpresaDao().findByNombre(nombre);
    }

    @RequestMapping("/ObtenerEmpresaPorId")
    public Empresa obtenerEmpresaPorId(@RequestParam(required = true) long id){
        return getEmpresaDao().findById(id);
    }
}
