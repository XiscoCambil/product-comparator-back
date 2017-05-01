package com.esliceu.comparador.model;

import javax.persistence.*;
import java.util.List;

/**
 * Created by blackwidow on 22/04/17.
 */
@Entity
@Table(name = "fct_categoria")
public class Categoria extends BaseModel {

    private String nombre;

    @ManyToOne
    @JoinColumn(columnDefinition="integer",name = "id_padre")
    private Categoria padre;

    @OneToMany(mappedBy = "idCategoria")
    private List<Producto> productos;

    public Categoria(String nombre) {
        this.nombre = nombre;
    }

    public Categoria(){}

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public Categoria getPadre() {
        return padre;
    }

    public void setPadre(Categoria padre) {
        this.padre = padre;
    }

    public List<Producto> getProductos() {
        return productos;
    }

    public void setProductos(List<Producto> productos) {
        this.productos = productos;
    }
}
