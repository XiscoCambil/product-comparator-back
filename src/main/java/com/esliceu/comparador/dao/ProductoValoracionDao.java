package com.esliceu.comparador.dao;

import com.esliceu.comparador.model.ProductoValoracion;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

/**
 * Created by blackwidow on 26/04/17.
 */
public interface ProductoValoracionDao extends CrudRepository<ProductoValoracion,Long> {
    List<ProductoValoracion> findByIdUsuario(int id_usuario);
}
