package com.esliceu.comparador.dao;

import com.esliceu.comparador.model.Producto;
import org.springframework.data.repository.CrudRepository;

/**
 * Created by blackwidow on 24/04/17.
 */
public interface ProductoDao extends CrudRepository<Producto,Long> {
}
