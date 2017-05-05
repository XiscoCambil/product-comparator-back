package com.esliceu.comparador.util;
import java.util.Date;


/**
 * Created by blackwidow on 1/05/17.
 */
public class Token {

    private int id;

    private String email;

    private Date fecha;

    private int id_localidad;

    private Date fechaExp;

    public Token(){

    }

    public Token(int id, String email, Date fecha, int id_localidad,Date fechaExp) {
        this.id = id;
        this.email = email;
        this.fecha = fecha;
        this.id_localidad = id_localidad;
        this.fechaExp = fechaExp;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public Date getFecha() {
        return fecha;
    }

    public void setFecha(Date fecha) {
        this.fecha = fecha;
    }

    public int getId_localidad() {
        return id_localidad;
    }

    public void setId_localidad(int id_localidad) {
        this.id_localidad = id_localidad;
    }

    public Date getFechaExp() {
        return fechaExp;
    }

    public void setFechaExp(Date fechaExp) {
        this.fechaExp = fechaExp;
    }
}
