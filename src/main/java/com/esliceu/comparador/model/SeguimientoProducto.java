package com.esliceu.comparador.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;

/**
 * Created by blackwidow on 26/04/17.
 */
@Entity
@Table(name = "fct_seguimiento_producto")
public class SeguimientoProducto extends BaseModel{

    @Column(name = "id_producto")
    private long idProducto;

    @Column(name = "id_usuario")
    private long idUsuario;

    public SeguimientoProducto(long idProducto, long idUsuario) {
        this.idProducto = idProducto;
        this.idUsuario = idUsuario;
    }

    public SeguimientoProducto(){}

    public long getIdProducto() {
        return idProducto;
    }

    public void setIdProducto(long idProducto) {
        this.idProducto = idProducto;
    }

    public long getIdUsuario() {
        return idUsuario;
    }

    public void setIdUsuario(long idUsuario) {
        this.idUsuario = idUsuario;
    }
}
