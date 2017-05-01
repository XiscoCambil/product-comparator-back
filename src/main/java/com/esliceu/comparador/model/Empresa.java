package com.esliceu.comparador.model;

import javax.persistence.*;
import java.util.List;

/**
 * Created by blackwidow on 21/04/17.
 */
@Entity
@Table(name="fct_empresa")
public class Empresa extends BaseModel {

    private String nombre;

    @OneToMany(mappedBy = "idEmpresa")
    private List<Marca> marcas;

    @OneToMany(mappedBy = "idEmpresa")
    private List<Tienda> tiendas;

    public Empresa(String nombre) {
        this.nombre = nombre;
    }

    public Empresa(){}

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public List<Marca> getMarcas() {
        return marcas;
    }

    public void setMarcas(List<Marca> marcas) {
        this.marcas = marcas;
    }

    public List<Tienda> getTiendas() {
        return tiendas;
    }

    public void setTiendas(List<Tienda> tiendas) {
        this.tiendas = tiendas;
    }
}
