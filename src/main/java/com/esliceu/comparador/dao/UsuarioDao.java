package com.esliceu.comparador.dao;

import com.esliceu.comparador.model.Usuario;
import org.springframework.data.repository.CrudRepository;

/**
 * Created by blackwidow on 24/04/17.
 */
public interface UsuarioDao extends CrudRepository<Usuario,Long> {
}
