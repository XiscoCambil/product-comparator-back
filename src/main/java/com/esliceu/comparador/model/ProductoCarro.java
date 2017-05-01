package com.esliceu.comparador.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;

/**
 * Created by blackwidow on 26/04/17.
 */
@Entity
@Table(name = "fct_producto_carro")
public class ProductoCarro extends BaseModel {

    @Column(name = "id_producto_tienda")
    private Long idProductoTienda;

    @Column(name = "id_carro")
    private Long idCarro;

    public ProductoCarro(Long idProductoTienda, Long idCarro) {
        this.idProductoTienda = idProductoTienda;
        this.idCarro = idCarro;
    }

    public ProductoCarro(){}

    public Long getIdProductoTienda() {
        return idProductoTienda;
    }

    public void setIdProductoTienda(Long idProductoTienda) {
        this.idProductoTienda = idProductoTienda;
    }

    public Long getIdCarro() {
        return idCarro;
    }

    public void setIdCarro(Long idCarro) {
        this.idCarro = idCarro;
    }
}
