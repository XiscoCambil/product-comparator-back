package com.esliceu.comparador.model;

import javax.persistence.*;
import java.util.List;


/**
 * Created by blackwidow on 24/04/17.
 */
@Entity
@Table(name = "fct_producto_tienda")
public class ProductoTienda extends BaseModel {

    @Column(name = "id_tienda")
    private Long idTienda;

    @Column(name = "id_producto")
    private Long idProducto;


    @OneToMany(mappedBy = "idProductoTienda")
    @OrderBy("fecha DESC")
    private List<HistorialProductoTienda> historialPrecio;

    @OneToMany(mappedBy = "idProductoTienda")
    private List<ProductoCarro> carros;

    public ProductoTienda(Long id_producto, Long id_tienda) {
        idProducto = id_producto;
        idTienda = id_tienda;
    }

    public ProductoTienda(){}

    public Long getIdTienda() {
        return idTienda;
    }

    public void setIdTienda(Long idTienda) {
        this.idTienda = idTienda;
    }

    public Long getIdProducto() {
        return idProducto;
    }

    public void setIdProducto(Long idProducto) {
        this.idProducto = idProducto;
    }

    public List<HistorialProductoTienda> getHistorialPrecio() {
        return historialPrecio;
    }

    public void setHistorialPrecio(List<HistorialProductoTienda> historialPrecio) {
        this.historialPrecio = historialPrecio;
    }

    public List<ProductoCarro> getCarros() {
        return carros;
    }

    public void setCarros(List<ProductoCarro> carros) {
        this.carros = carros;
    }

}
