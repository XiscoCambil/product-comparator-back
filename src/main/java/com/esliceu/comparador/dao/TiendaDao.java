package com.esliceu.comparador.dao;

import com.esliceu.comparador.model.Tienda;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

/**
 * Created by blackwidow on 24/04/17.
 */
public interface TiendaDao extends CrudRepository<Tienda,Long> {
    public List<Tienda> findByIdIn(List<Long> id_tiendas);
    public List<Tienda> findByIdLocalidad(int id_localidad);

}
