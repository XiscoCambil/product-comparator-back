package com.esliceu.comparador.bean;

import com.esliceu.comparador.dao.SeguimientoProductoDao;
import com.esliceu.comparador.model.SeguimientoProducto;
import org.springframework.beans.factory.annotation.Autowired;

/**
 * Created by blackwidow on 26/04/17.
 */
public class SeguimientoProductoBean extends BaseBean {

    @Autowired
    private SeguimientoProductoDao seguimientoProductoDao;

    public SeguimientoProductoDao getSeguimientoProductoDao() {
        return seguimientoProductoDao;
    }

    public void setSeguimientoProductoDao(SeguimientoProductoDao seguimientoProductoDao) {
        this.seguimientoProductoDao = seguimientoProductoDao;
    }
}
