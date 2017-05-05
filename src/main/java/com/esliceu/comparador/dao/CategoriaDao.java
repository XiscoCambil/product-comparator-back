package com.esliceu.comparador.dao;

import com.esliceu.comparador.model.Categoria;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

/**
 * Created by blackwidow on 22/04/17.
 */
public interface CategoriaDao extends CrudRepository<Categoria, Long> {
    Categoria findById(Long id);

    Categoria findByNombre(String nombre);

    List<Categoria> findByPadre(Categoria categoria);
}
