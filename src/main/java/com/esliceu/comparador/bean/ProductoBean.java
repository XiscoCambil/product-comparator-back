package com.esliceu.comparador.bean;

import com.esliceu.comparador.controlador.CategoriaController;
import com.esliceu.comparador.dao.CategoriaDao;
import com.esliceu.comparador.dao.ProductoDao;
import com.esliceu.comparador.model.Categoria;
import com.esliceu.comparador.model.Producto;
import org.springframework.beans.factory.annotation.Autowired;

/**
 * Created by blackwidow on 24/04/17.
 */
public class ProductoBean extends BaseBean {

    @Autowired
    private ProductoDao productoDao;

    @Autowired
    private CategoriaDao categoriaDao;


    public ProductoDao getProductoDao() {
        return productoDao;
    }

    public void setProductoDao(ProductoDao productoDao) {
        this.productoDao = productoDao;
    }

    public CategoriaDao getCategoriaDao() {
        return categoriaDao;
    }

    public void setCategoriaDao(CategoriaDao categoriaDao) {
        this.categoriaDao = categoriaDao;
    }
}
