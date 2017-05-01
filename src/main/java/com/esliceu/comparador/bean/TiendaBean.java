package com.esliceu.comparador.bean;

import com.esliceu.comparador.dao.TiendaDao;
import org.springframework.beans.factory.annotation.Autowired;

/**
 * Created by blackwidow on 24/04/17.
 */
public class TiendaBean extends BaseBean{

    @Autowired
    TiendaDao tiendaDao;

    public TiendaDao getTiendaDao() {
        return tiendaDao;
    }

    public void setTiendaDao(TiendaDao tiendaDao) {
        this.tiendaDao = tiendaDao;
    }
}
