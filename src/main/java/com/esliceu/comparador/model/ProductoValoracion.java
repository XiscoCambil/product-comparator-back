package com.esliceu.comparador.model;

import javax.persistence.*;

/**
 * Created by blackwidow on 26/04/17.
 */
@Entity
@Table(name = "fct_producto_valoracion")
public class ProductoValoracion extends BaseModel {


    private int valoracion;

    @Column(name = "id_producto")
    private int idProducto;

    @Column(name = "id_usuario")
    private int idUsuario;

    public ProductoValoracion(int valoracion, int idProducto,int id_usuario) {
        this.valoracion = valoracion;
        this.idProducto = idProducto;
        this.idUsuario = id_usuario;
    }

    public ProductoValoracion(){}

    public int getValoracion() {
        return valoracion;
    }

    public void setValoracion(int valoracion) {
        this.valoracion = valoracion;
    }

    public int getIdProducto() {
        return idProducto;
    }

    public void setIdProducto(int idProducto) {
        this.idProducto = idProducto;
    }

    public int getIdUsuario() {
        return idUsuario;
    }

    public void setIdUsuario(int idUsuario) {
        this.idUsuario = idUsuario;
    }
}
