package com.esliceu.comparador.dao;

import com.esliceu.comparador.model.Empresa;
import org.springframework.data.repository.CrudRepository;

/**
 * Created by blackwidow on 21/04/17.
 */
public interface EmpresaDao extends CrudRepository<Empresa,Long> {
    Empresa findById(long id);
    Empresa findByNombre(String nombre);

}
