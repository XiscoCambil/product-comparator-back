package com.esliceu.comparador;

import com.esliceu.comparador.dao.LocalidadDao;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import java.util.ArrayList;
import java.util.List;

@SpringBootApplication
public class Aplicacion {
    public static void main(String[] args) {
        SpringApplication.run(Aplicacion.class);
    }


    @Bean
    public CommandLineRunner demo(LocalidadDao localidadDao) {

        return (args) -> {

        };

    }
}