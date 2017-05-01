package com.esliceu.comparador.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;
import java.util.Date;

/**
 * Created by blackwidow on 26/04/17.
 */
@Entity
@Table(name = "fct_historial_producto_tienda")
public class HistorialProductoTienda extends BaseModel {

    @Column(name = "id_producto_tienda")
    private Long idProductoTienda;

    private Date fecha;

    private Double precio;

    public HistorialProductoTienda(Long idProductoTienda, Date fecha, Double precio) {
        this.idProductoTienda = idProductoTienda;
        this.fecha = fecha;
        this.precio = precio;
    }

    public HistorialProductoTienda(){}

    public Long getIdProductoTienda() {
        return idProductoTienda;
    }

    public void setIdProductoTienda(Long idProductoTienda) {
        this.idProductoTienda = idProductoTienda;
    }

    public Date getFecha() {
        return fecha;
    }

    public void setFecha(Date fecha) {
        this.fecha = fecha;
    }

    public Double getPrecio() {
        return precio;
    }

    public void setPrecio(Double precio) {
        this.precio = precio;
    }
}

