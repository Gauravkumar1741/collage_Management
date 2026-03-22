package com.college.util;

import jakarta.persistence.*;

public class JPAUtil {

    private static final EntityManagerFactory emf =
        Persistence.createEntityManagerFactory("collegePU");

    public static EntityManager getEntityManager() {
        return emf.createEntityManager();
    }
}