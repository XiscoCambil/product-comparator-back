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
    @JoinColumn(name = "id_padre")
    private Categoria padre;

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
}
