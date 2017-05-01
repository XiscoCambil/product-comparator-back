package com.esliceu.comparador.bean;

import com.esliceu.comparador.dao.ProductoDao;
import org.springframework.beans.factory.annotation.Autowired;

/**
 * Created by blackwidow on 24/04/17.
 */
public class ProductoBean extends BaseBean {

    @Autowired
    private ProductoDao productoDao;

    public ProductoDao getProductoDao() {
        return productoDao;
    }

    public void setProductoDao(ProductoDao productoDao) {
        this.productoDao = productoDao;
    }
}
