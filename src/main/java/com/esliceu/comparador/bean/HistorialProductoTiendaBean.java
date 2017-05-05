package com.esliceu.comparador.bean;

import com.esliceu.comparador.dao.HistorialProductoTiendaDao;
import com.esliceu.comparador.dao.ProductoTiendaDao;
import com.esliceu.comparador.model.HistorialProductoTienda;
import com.esliceu.comparador.model.ProductoTienda;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;

/**
 * Created by blackwidow on 26/04/17.
 */
public class HistorialProductoTiendaBean extends BaseBean {

    @Autowired
    private HistorialProductoTiendaDao historialProductoTiendaDao;

    @Autowired
    private ProductoTiendaDao productoTiendaDao;

    @Qualifier("historialProductoTienda")
    private HistorialProductoTienda historialProductoTienda;

    @Qualifier("productoTienda")
    private ProductoTienda productoTienda;

    public HistorialProductoTiendaDao getHistorialProductoTiendaDao() {
        return historialProductoTiendaDao;
    }

    public void setHistorialProductoTiendaDao(HistorialProductoTiendaDao historialProductoTiendaDao) {
        this.historialProductoTiendaDao = historialProductoTiendaDao;
    }

    public HistorialProductoTienda getHistorialProductoTienda() {
        return historialProductoTienda;
    }

    public void setHistorialProductoTienda(HistorialProductoTienda historialProductoTienda) {
        this.historialProductoTienda = historialProductoTienda;
    }

    public ProductoTienda getProductoTienda() {
        return productoTienda;
    }

    public void setProductoTienda(ProductoTienda productoTienda) {
        this.productoTienda = productoTienda;
    }

    public ProductoTiendaDao getProductoTiendaDao() {
        return productoTiendaDao;
    }

    public void setProductoTiendaDao(ProductoTiendaDao productoTiendaDao) {
        this.productoTiendaDao = productoTiendaDao;
    }
}
