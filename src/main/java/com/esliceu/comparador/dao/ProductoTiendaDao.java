package com.esliceu.comparador.dao;

import com.esliceu.comparador.model.ProductoTienda;
import com.esliceu.comparador.model.Tienda;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

/**
 * Created by blackwidow on 24/04/17.
 */
public interface ProductoTiendaDao extends CrudRepository<ProductoTienda,Long> {
     List<ProductoTienda> findByIdProducto(Long id_producto);
     List<ProductoTienda> findByIdTienda(Long id_tienda);
     List<ProductoTienda> findByIdIn(List<Long> id_productos);
     List<ProductoTienda> findByidTiendaIn(List<Tienda> id_tiendas);

}