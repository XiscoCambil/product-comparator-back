package com.esliceu.comparador.dao;

import com.esliceu.comparador.model.ProductoValoracion;
import org.springframework.data.repository.CrudRepository;

/**
 * Created by blackwidow on 26/04/17.
 */
public interface ProductoValoracionDao extends CrudRepository<ProductoValoracion,Long> {
}
