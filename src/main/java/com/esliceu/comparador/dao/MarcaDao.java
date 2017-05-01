package com.esliceu.comparador.dao;

import com.esliceu.comparador.model.Marca;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

/**
 * Created by blackwidow on 22/04/17.
 */
public interface MarcaDao extends CrudRepository<Marca,Long> {

    Marca findById(long id);
    Marca findByNombre(String nombre);
    List<Marca> findByIdEmpresa(long id);
}
