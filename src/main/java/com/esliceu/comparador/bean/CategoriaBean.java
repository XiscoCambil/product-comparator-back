package com.esliceu.comparador.bean;

import com.esliceu.comparador.dao.CategoriaDao;
import com.esliceu.comparador.model.Categoria;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;

/**
 * Created by blackwidow on 24/04/17.
 */
public class CategoriaBean extends BaseBean {

    @Autowired
    private CategoriaDao categoriaDao;

    @Qualifier("categoria")
    private Categoria categoria;


    public CategoriaDao getCategoriaDao() {
        return categoriaDao;
    }

    public void setCategoriaDao(CategoriaDao categoriaDao) {
        this.categoriaDao = categoriaDao;
    }

    public Categoria getCategoria() {
        return categoria;
    }

    public void setCategoria(Categoria categoria) {
        this.categoria = categoria;
    }
}
