package com.esliceu.comparador.model;

import javax.persistence.*;
import java.util.List;

/**
 * Created by blackwidow on 24/04/17.
 */
@Entity
@Table(name = "fct_tienda")
public class Tienda extends BaseModel {

    private String cif;

    private Double latitud;

    private Double longitud;

    private String direccion;

    private Long telefono;
/*
    @Column(name = "id_empresa")
    private long idEmpresa;

*/
    @Column(name = "id_localidad")
    private int idLocalidad;

    @OneToMany(mappedBy = "idTienda")
    private List<ProductoTienda> productosTienda;

    @ManyToOne
    @JoinColumn(columnDefinition = "integer",name = "id_empresa")
    private Empresa empresa;


    public Tienda(String cif, Double latitud, Double longitud, String direccion, Long telefono) {
        this.cif = cif;
        this.latitud = latitud;
        this.longitud = longitud;
        this.direccion = direccion;
        this.telefono = telefono;
    }

    public Tienda(){}

    public String getCif() {
        return cif;
    }

    public void setCif(String cif) {
        this.cif = cif;
    }

    public Double getLatitud() {
        return latitud;
    }

    public void setLatitud(Double latitud) {
        this.latitud = latitud;
    }

    public Double getLongitud() {
        return longitud;
    }

    public void setLongitud(Double longitud) {
        this.longitud = longitud;
    }

    public String getDireccion() {
        return direccion;
    }

    public void setDireccion(String direccion) {
        this.direccion = direccion;
    }

    public Long getTelefono() {
        return telefono;
    }

    public void setTelefono(Long telefono) {
        this.telefono = telefono;
    }

    /*
    public long getIdEmpresa() {
        return idEmpresa;
    }

    public void setIdEmpresa(long idEmpresa) {
        this.idEmpresa = idEmpresa;
    }

*/
    public int getIdLocalidad() {
        return idLocalidad;
    }

    public void setIdLocalidad(int idLocalidad) {
        this.idLocalidad = idLocalidad;
    }

    public List<ProductoTienda> getProductosTienda() {
        return productosTienda;
    }

    public void setProductosTienda(List<ProductoTienda> productosTienda) {
        this.productosTienda = productosTienda;
    }

    public Empresa getEmpresa() {
        return empresa;
    }

    public void setEmpresa(Empresa empresa) {
        this.empresa = empresa;
    }
}

