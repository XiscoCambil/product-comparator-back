package com.esliceu.comparador.model;

import javax.persistence.*;
import java.util.List;

/**
 * Created by blackwidow on 21/04/17.
 */
@Entity
@Table(name = "fct_localidad")
public class Localidad extends BaseModel {

    private String nombre;

    @OneToMany(mappedBy = "idLocalidad")
    private List<Tienda> tiendas;

    /*
    @OneToMany(mappedBy = "idLocalidad")
    private List<Usuario> usuarios;

*/
    public Localidad(String nombre) {
        this.nombre = nombre;
    }

    public Localidad(){}

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public List<Tienda> getTiendas() {
        return tiendas;
    }

    public void setTiendas(List<Tienda> tiendas) {
        this.tiendas = tiendas;
    }

/*
    public List<Usuario> getUsuarios() {
        return usuarios;
    }

    public void setUsuarios(List<Usuario> usuarios) {
        this.usuarios = usuarios;
    }
*/

}
