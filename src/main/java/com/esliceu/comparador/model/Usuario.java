package com.esliceu.comparador.model;

import javax.persistence.*;
import java.util.List;

/**
 * Created by blackwidow on 24/04/17.
 */
@Entity
@Table(name = "fct_usuario")
public class Usuario extends BaseModel{

    private String nombre;

    private String apellidos;

    private Long telefono;

    private String email;

    private String password;

    @Column(name = "id_localidad")
    private int IdLocalidad;

    @OneToMany(mappedBy = "idUsuario")
    private List<Carro> carros;

    @OneToMany(mappedBy = "idUsuario")
    private List<SeguimientoProducto> seguimientoProductos;

    public Usuario(String nombre, String apellidos, Long telefono, String email, String password, int id_localidad) {
        this.nombre = nombre;
        this.apellidos = apellidos;
        this.telefono = telefono;
        this.email = email;
        this.password = password;
        this.IdLocalidad = id_localidad;
    }

    public Usuario(){}

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getApellidos() {
        return apellidos;
    }

    public void setApellidos(String apellidos) {
        this.apellidos = apellidos;
    }

    public Long getTelefono() {
        return telefono;
    }

    public void setTelefono(Long telefono) {
        this.telefono = telefono;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public int getIdLocalidad() {
        return IdLocalidad;
    }

    public void setIdLocalidad(int idlocalidad) {
        IdLocalidad = idlocalidad;
    }

    public List<Carro> getCarros() {
        return carros;
    }

    public void setCarros(List<Carro> carros) {
        this.carros = carros;
    }

    public List<SeguimientoProducto> getSeguimientoProductos() {
        return seguimientoProductos;
    }

    public void setSeguimientoProductos(List<SeguimientoProducto> seguimientoProductos) {
        this.seguimientoProductos = seguimientoProductos;
    }
}
