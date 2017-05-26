package com.esliceu.comparador.dao;

import com.esliceu.comparador.model.Carro;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

/**
 * Created by blackwidow on 26/04/17.
 */
public interface CarroDao extends CrudRepository<Carro,Long> {
     Carro findById(Long id);
     List<Carro> findByIdUsuario(Long id_usuario);
     List<Carro> findByIdIn(List<Long> id_productos);
}
