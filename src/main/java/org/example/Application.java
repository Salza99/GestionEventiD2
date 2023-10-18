package org.example;

import org.example.entities.Location;
import org.example.entities.classDao.EventoDao;
import org.example.entities.classDao.LocationDao;
import org.example.entities.classDao.PartecipazioneDao;
import org.example.entities.classDao.PersonaDao;
import org.example.utils.JpaUtil;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;

public class Application {

    public static void main(String[] args) {
        EntityManagerFactory emf = JpaUtil.getEntityManagerFactory();
        EntityManager em = emf.createEntityManager();
        EventoDao ed = new EventoDao(em);
        PersonaDao ped = new PersonaDao(em);
        PartecipazioneDao pd = new PartecipazioneDao(em);
        LocationDao ld = new LocationDao(em);

        
        em.close();
        emf.close();
    }
}
