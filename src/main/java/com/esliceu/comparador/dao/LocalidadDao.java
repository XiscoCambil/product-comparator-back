package com.esliceu.comparador.dao;

import com.esliceu.comparador.model.Localidad;
import org.springframework.data.repository.CrudRepository;

/**
 * Created by blackwidow on 21/04/17.
 */
public interface LocalidadDao extends CrudRepository<Localidad,Long> {
    Localidad findByNombre(String nombre);
    Localidad findById(long id);
}
