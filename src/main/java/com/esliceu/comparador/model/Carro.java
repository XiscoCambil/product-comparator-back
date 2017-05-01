package com.esliceu.comparador.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import java.util.List;

/**
 * Created by blackwidow on 26/04/17.
 */
@Entity
@Table(name = "fct_carro")
public class Carro extends BaseModel {

    @Column(name = "id_usuario")
    private Long idUsuario;

    @OneToMany(mappedBy = "idCarro")
    private List<ProductoCarro> productos;

    public Carro(Long idUsuario) {
        this.idUsuario = idUsuario;
    }

    public Carro(){}

    public Long getIdUsuario() {
        return idUsuario;
    }

    public void setIdUsuario(Long idUsuario) {
        this.idUsuario = idUsuario;
    }

    public List<ProductoCarro> getProductos() {
        return productos;
    }

    public void setProductos(List<ProductoCarro> productos) {
        this.productos = productos;
    }
}
