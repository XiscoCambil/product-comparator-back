package com.esliceu.comparador.dao;

import com.esliceu.comparador.model.HistorialProductoTienda;
import org.springframework.data.repository.CrudRepository;

/**
 * Created by blackwidow on 26/04/17.
 */
public interface HistorialProductoDao extends CrudRepository<HistorialProductoTienda,Long>{
}
