package com.esliceu.comparador.model;

import javax.persistence.*;
import java.util.List;

/**
 * Created by blackwidow on 24/04/17.
 */
@Entity
@Table(name="fct_producto")
public class Producto extends BaseModel {

    private String nombre;

    @Column(name = "codigo_de_barras")
    private String codigoBarras;

    @Column(name = "valor_energetico")
    private String valorEnergetico;

    private String proteinas;

    private String carbohidratos;

    private String grasas;

    @Column(name = "id_marca")
    private long idMarca;

    @Column(name = "id_categoria")
    private long idCategoria;

    @OneToMany(mappedBy = "idProducto")
    private List<ProductoValoracion> productoValoracion;

    @OneToMany(mappedBy = "idProducto")
    private List<ProductoTienda> productoTiendas;

    public Producto(String nombre, String codigoBarras, String valorEnergetico, String proteinas, String carbohidratos, String grasas, long id_marca, long id_categoria) {
        this.nombre = nombre;
        this.codigoBarras = codigoBarras;
        this.valorEnergetico = valorEnergetico;
        this.proteinas = proteinas;
        this.carbohidratos = carbohidratos;
        this.grasas = grasas;
        this.idMarca = id_marca;
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

    public String getValorEnergetico() {
        return valorEnergetico;
    }

    public void setValorEnergetico(String valorEnergetico) {
        this.valorEnergetico = valorEnergetico;
    }

    public String getProteinas() {
        return proteinas;
    }

    public void setProteinas(String proteinas) {
        this.proteinas = proteinas;
    }

    public String getCarbohidratos() {
        return carbohidratos;
    }

    public void setCarbohidratos(String carbohidratos) {
        this.carbohidratos = carbohidratos;
    }

    public String getGrasas() {
        return grasas;
    }

    public void setGrasas(String grasas) {
        this.grasas = grasas;
    }


    public long getIdMarca() {
        return idMarca;
    }

    public void setIdMarca(long idMarca) {
        this.idMarca = idMarca;
    }

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
}
