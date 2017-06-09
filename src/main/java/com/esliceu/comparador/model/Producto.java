package com.esliceu.comparador.model;

import org.hibernate.annotations.Filter;
import org.hibernate.annotations.FilterDef;
import org.hibernate.annotations.Filters;
import org.hibernate.annotations.ParamDef;

import javax.persistence.*;
import java.util.List;

/**
 * Created by blackwidow on 24/04/17.
 */
@Entity
@Table(name="fct_producto")
public class Producto extends BaseModel{

    private String nombre;

    @Column(name = "codigo_de_barras")
    private String codigoBarras;

    @Column(name = "valor_energetico")
    private int valorEnergetico;

    private Double proteinas;

    private Double carbohidratos;

    private Double grasas;

   /* @Column(name = "id_marca")
    private long idMarca;
*/
    @Column(name = "id_categoria")
    private long idCategoria;

    @OneToMany(mappedBy = "idProducto")
    private List<ProductoValoracion> productoValoracion;

    @OneToMany(mappedBy = "idProducto")
    private List<ProductoTienda> productoTiendas;

    @ManyToOne
    @JoinColumn(columnDefinition = "integer",name = "idMarca")
    private Marca marca;

    public Producto(String nombre, String codigoBarras, int valorEnergetico, Double proteinas, Double carbohidratos, Double grasas /*long id_marca*/, long id_categoria) {
        this.nombre = nombre;
        this.codigoBarras = codigoBarras;
        this.valorEnergetico = valorEnergetico;
        this.proteinas = proteinas;
        this.carbohidratos = carbohidratos;
        this.grasas = grasas;
       // this.idMarca = id_marca;
        this.idCategoria = id_categoria;
    }

    public Producto(){}

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getCodigoBarras() {
        return codigoBarras;
    }

    public void setCodigoBarras(String codigoBarras) {
        this.codigoBarras = codigoBarras;
    }

    public int getValorEnergetico() {
        return valorEnergetico;
    }

    public void setValorEnergetico(int valorEnergetico) {
        this.valorEnergetico = valorEnergetico;
    }

    public Double getProteinas() {
        return proteinas;
    }

    public void setProteinas(Double proteinas) {
        this.proteinas = proteinas;
    }

    public Double getCarbohidratos() {
        return carbohidratos;
    }

    public void setCarbohidratos(Double carbohidratos) {
        this.carbohidratos = carbohidratos;
    }

    public Double getGrasas() {
        return grasas;
    }

    public void setGrasas(Double grasas) {
        this.grasas = grasas;
    }

/*
    public long getIdMarca() {
        return idMarca;
    }

    public void setIdMarca(long idMarca) {
        this.idMarca = idMarca;
    }
    */

    public List<ProductoValoracion> getProductoValoracion() {
        return productoValoracion;
    }

    public void setProductoValoracion(List<ProductoValoracion> productoValoracion) {
        this.productoValoracion = productoValoracion;
    }

    public List<ProductoTienda> getProductoTiendas() {
        return productoTiendas;
    }

    public void setProductoTiendas(List<ProductoTienda> productoTiendas) {
        this.productoTiendas = productoTiendas;
    }

    public long getIdCategoria() {
        return idCategoria;
    }

    public void setIdCategoria(long idCategoria) {
        this.idCategoria = idCategoria;
    }

    public Marca getMarca() {
        return marca;
    }

    public void setMarca(Marca marca) {
        this.marca = marca;
    }
}
