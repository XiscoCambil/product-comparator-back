package com.esliceu.comparador.bean;

import com.esliceu.comparador.dao.ProductoTiendaDao;
import org.springframework.beans.factory.annotation.Autowired;

/**
 * Created by blackwidow on 24/04/17.
 */
public class ProductoTiendaBean extends BaseBean {

    @Autowired
    private ProductoTiendaDao productoTiendaDao;

    public ProductoTiendaDao getProductoTiendaDao() {
        return productoTiendaDao;
    }

    public void setProductoTiendaDao(ProductoTiendaDao productoTiendaDao) {
        this.productoTiendaDao = productoTiendaDao;
    }
}
