package com.esliceu.comparador.bean;

import com.esliceu.comparador.dao.MarcaDao;
import org.springframework.beans.factory.annotation.Autowired;

/**
 * Created by blackwidow on 24/04/17.
 */
public class MarcaBean extends BaseBean{

    @Autowired
    private MarcaDao marcaDao;

    public MarcaDao getMarcaDao() {
        return marcaDao;
    }

    public void setMarcaDao(MarcaDao marcaDao) {
        this.marcaDao = marcaDao;
    }
}
