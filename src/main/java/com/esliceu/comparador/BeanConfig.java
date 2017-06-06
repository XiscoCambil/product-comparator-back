package com.esliceu.comparador;

import com.esliceu.comparador.model.*;
import com.esliceu.comparador.util.*;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Scope;

import java.io.UnsupportedEncodingException;

/**
 * Created by xavi on 23/02/17.
 */
@Configuration
public class BeanConfig {

    @Bean
    @Scope(value = "prototype")
    public Localidad localidad(){
        return new Localidad();
    }

    @Bean
    @Scope(value = "prototype")
    public Empresa empresa(){
        return new Empresa();
    }

    @Bean
    @Scope(value = "prototype")
    public Marca marca(){
        return new Marca();
    }

    @Bean
    @Scope(value = "prototJWType")
    public Categoria categoria(){
        return new Categoria();
    }

    @Bean
    @Scope(value = "prototype")
    public Usuario usuario(){
        return new Usuario();
    }

    @Bean
    @Scope(value = "prototype")
    public Producto producto(){
        return new Producto();
    }

    @Bean
    @Scope(value = "prototype")
    public ProductoTienda productoTienda(){
        return new ProductoTienda();
    }

    @Bean
    @Scope(value = "prototype")
    public ProductoValoracion productoValoracion(){
        return new ProductoValoracion();
    }

    @Bean
    @Scope(value = "prototype")
    public SeguimientoProducto seguimientoProducto(){
        return new SeguimientoProducto();
    }

    @Bean
    @Scope(value = "prototype")
    public HistorialProductoTienda historialProductoTienda(){
        return new HistorialProductoTienda();
    }

    @Bean
    @Scope(value = "prototype")
    public Carro carro(){
        return new Carro();
    }

    @Bean
    @Scope(value = "prototype")
    public ProductoCarro productoCarro(){return new ProductoCarro();}

    @Bean
    @Scope(value = "prototype")
    public Token token() throws UnsupportedEncodingException {return new Token();}

    @Bean
    @Scope(value = "prototype")
    public RefreshToken refreshToken() throws UnsupportedEncodingException {return new RefreshToken();}

    @Bean
    @Scope(value = "prototype")
    public AccesToken accesToken() throws UnsupportedEncodingException {return new AccesToken();}


    @Bean
    @Scope(value = "prototype")
    public Sha512 sha512() throws UnsupportedEncodingException {return new Sha512();}

    @Bean
    @Scope(value = "prototype")
    public JWT jwt() throws UnsupportedEncodingException {return new JWT();}




}
