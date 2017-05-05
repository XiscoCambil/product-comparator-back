package com.esliceu.comparador.dao;

import com.esliceu.comparador.model.ProductoTienda;
import com.esliceu.comparador.model.Tienda;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

/**
 * Created by blackwidow on 24/04/17.
 */
public interface ProductoTiendaDao extends CrudRepository<ProductoTienda,Long> {
     ProductoTienda findById(Long id);
     List<ProductoTienda> findByIdProducto(Long id_producto);
}