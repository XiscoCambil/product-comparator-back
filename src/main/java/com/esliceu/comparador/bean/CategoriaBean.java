package com.esliceu.comparador.bean;

import com.esliceu.comparador.dao.CategoriaDao;
import org.springframework.beans.factory.annotation.Autowired;

/**
 * Created by blackwidow on 24/04/17.
 */
public class CategoriaBean extends BaseBean {

    @Autowired
    private CategoriaDao categoriaDao;

    public CategoriaDao getCategoriaDao() {
        return categoriaDao;
    }

    public void setCategoriaDao(CategoriaDao categoriaDao) {
        this.categoriaDao = categoriaDao;
    }
}
