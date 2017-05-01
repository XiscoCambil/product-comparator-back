package com.esliceu.comparador.dao;

import com.esliceu.comparador.model.Tienda;
import org.springframework.data.repository.CrudRepository;

/**
 * Created by blackwidow on 24/04/17.
 */
public interface TiendaDao extends CrudRepository<Tienda,Long> {
}
