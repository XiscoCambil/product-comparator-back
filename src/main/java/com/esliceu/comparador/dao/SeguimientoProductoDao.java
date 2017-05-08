package com.esliceu.comparador.dao;

import com.esliceu.comparador.model.SeguimientoProducto;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

/**
 * Created by blackwidow on 26/04/17.
 */
public interface SeguimientoProductoDao extends CrudRepository<SeguimientoProducto,Long> {
    List<SeguimientoProducto> findByIdUsuario(Long id_usuario);
}
