package com.esliceu.comparador.bean;

import com.esliceu.comparador.dao.ProductoValoracionDao;
import org.springframework.beans.factory.annotation.Autowired;

/**
 * Created by blackwidow on 26/04/17.
 */
public class ProductoValoracionBean extends BaseBean {

    @Autowired
    private ProductoValoracionDao productoValoracionDao;

    public ProductoValoracionDao getProductoValoracionDao() {
        return productoValoracionDao;
    }

    public void setProductoValoracionDao(ProductoValoracionDao productoValoracionDao) {
        this.productoValoracionDao = productoValoracionDao;
    }


}
