package com.esliceu.comparador.model;

import org.apache.catalina.LifecycleState;

import javax.persistence.*;
import java.util.List;

/**
 * Created by blackwidow on 22/04/17.
 */
@Entity
@Table(name = "fct_marca")
public class Marca extends BaseModel {

    private String nombre;

    @Column(name = "id_empresa")
    private long idEmpresa;

    /*
    @OneToMany(mappedBy = "idMarca")
    private List<Producto> productos;

*/
    public Marca(String nombre, long idEmpresa) {
        this.nombre = nombre;
        this.idEmpresa = idEmpresa;
    }

    public Marca(){}

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public long getIdEmpresa() {

        return idEmpresa;
    }

    public void setIdEmpresa(long idEmpresa) {
        this.idEmpresa = idEmpresa;
    }

/*
    public List<Producto> getProductos() {
        return productos;
    }

    public void setProductos(List<Producto> productos) {
        this.productos = productos;
    }
    */
}
