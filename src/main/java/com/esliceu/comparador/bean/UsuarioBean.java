package com.esliceu.comparador.bean;

import com.esliceu.comparador.dao.UsuarioDao;
import org.springframework.beans.factory.annotation.Autowired;

/**
 * Created by blackwidow on 24/04/17.
 */
public class UsuarioBean extends BaseBean{

    @Autowired
    private UsuarioDao usuarioDao;

    public UsuarioDao getUsuarioDao() {
        return usuarioDao;
    }

    public void setUsuarioDao(UsuarioDao usuarioDao) {
        this.usuarioDao = usuarioDao;
    }
}
