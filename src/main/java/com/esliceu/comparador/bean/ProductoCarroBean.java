package com.esliceu.comparador.bean;

import com.esliceu.comparador.dao.ProductoCarroDao;
import org.springframework.beans.factory.annotation.Autowired;

/**
 * Created by blackwidow on 26/04/17.
 */
public class ProductoCarroBean extends BaseBean {

    @Autowired
    private ProductoCarroDao productoCarroDao;

    public ProductoCarroDao getProductoCarro() {
        return productoCarroDao;
    }

    public void setProductoCarro(ProductoCarroDao productoCarroDao) {
        this.productoCarroDao = productoCarroDao;
    }
}
