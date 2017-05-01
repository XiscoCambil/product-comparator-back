package com.esliceu.comparador.bean;

import com.esliceu.comparador.dao.HistorialProductoDao;
import org.springframework.beans.factory.annotation.Autowired;

/**
 * Created by blackwidow on 26/04/17.
 */
public class HistorialProductoBean extends BaseBean {

    @Autowired
    private HistorialProductoDao historialProductoDao;

    public HistorialProductoDao getHistorialProductoDao() {
        return historialProductoDao;
    }

    public void setHistorialProductoDao(HistorialProductoDao historialProductoDao) {
        this.historialProductoDao = historialProductoDao;
    }
}
