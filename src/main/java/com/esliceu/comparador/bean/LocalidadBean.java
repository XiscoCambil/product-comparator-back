package com.esliceu.comparador.bean;

import com.esliceu.comparador.dao.LocalidadDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;

/**
 * Created by blackwidow on 24/04/17.
 */

public class LocalidadBean extends BaseBean {


    @Autowired
    private LocalidadDao localidadDao;

    public LocalidadDao getLocalidadDao() {
        return localidadDao;
    }

    public void setLocalidadDao(LocalidadDao localidadDao) {
        this.localidadDao = localidadDao;
    }

}
