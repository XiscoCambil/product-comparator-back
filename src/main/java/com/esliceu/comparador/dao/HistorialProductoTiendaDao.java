package com.esliceu.comparador.dao;

import com.esliceu.comparador.model.HistorialProductoTienda;
import com.esliceu.comparador.model.ProductoTienda;
import org.springframework.data.repository.CrudRepository;
import java.util.Date;
import java.util.List;

/**
 * Created by blackwidow on 26/04/17.
 */
public interface HistorialProductoTiendaDao extends CrudRepository<HistorialProductoTienda,Long>{
    HistorialProductoTienda findById(Long id);
    List<HistorialProductoTienda> findByIdProductoTienda(Long id_producto_tienda);
    List<HistorialProductoTienda> findByPrecio(Double precio);
    List<HistorialProductoTienda> findByFecha(Date date);
}
