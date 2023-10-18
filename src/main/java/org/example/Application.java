package org.example;

import org.example.entities.classDao.EventoDao;
import org.example.utils.JpaUtil;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;

public class Application {

    public static void main(String[] args) {
        EntityManagerFactory emf = JpaUtil.getEntityManagerFactory();
        EntityManager em = emf.createEntityManager();
        EventoDao ed = new EventoDao(em);
    }
}
