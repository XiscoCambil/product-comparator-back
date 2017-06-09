package com.esliceu.comparador.util;

import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

public class JpaUtil {
    private static final EntityManagerFactory emf;

    static {
        try {
            emf = Persistence.createEntityManagerFactory("MyPu");
        } catch (Throwable ex) {
            throw new ExceptionInInitializerError(ex);
        }
    }
}