package org.example;

import org.example.entities.Evento;
import org.example.entities.Location;
import org.example.entities.Persona;
import org.example.entities.classDao.EventoDao;
import org.example.entities.classDao.LocationDao;
import org.example.entities.classDao.PartecipazioneDao;
import org.example.entities.classDao.PersonaDao;
import org.example.entities.enumeratori.Type;
import org.example.utils.JpaUtil;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import java.time.LocalDate;

public class Application {

    public static void main(String[] args) {
        EntityManagerFactory emf = JpaUtil.getEntityManagerFactory();
        EntityManager em = emf.createEntityManager();
        EventoDao ed = new EventoDao(em);
        PersonaDao ped = new PersonaDao(em);
        PartecipazioneDao pd = new PartecipazioneDao(em);
        LocationDao ld = new LocationDao(em);

        // inserisco delle persone a db
        /*Persona aP = new Persona("Davide", "Salzani","Davidesalzani99@gmail.com", LocalDate.of(1999, 4, 22), "M");
        Persona bP = new Persona("Marco", "Giorgi","MarcoGiorgi99@gmail.com", LocalDate.of(1999, 6, 12), "M");
        Persona cP = new Persona("Francesca", "Castelli","FraCaste97@gmail.com", LocalDate.of(1997, 12, 6), "F");
        ped.saveNewPerson(aP);
        ped.saveNewPerson(bP);
        ped.saveNewPerson(cP);*/
        //aggiungo delle Location
        /*Location aL = new Location("Teatro alla scala", "Milano");
        Location bL = new Location("Arena", "Verona");
        ld.saveNewLoc(aL);
        ld.saveNewLoc(bL);*/
        //Aggiungo degli eventi
        try {
            Location foundA = ld.searchById(1);
            Location foundB = ld.searchById(2);
            System.out.println(foundA);
            System.out.println(foundB);
            Evento aE = new Evento("Opera", "Lirica a teatro", LocalDate.of(2023, 9, 21), Type.PUBBLICO, 500, foundA);
            Evento bE = new Evento("Opera", "Spettacolo comico", LocalDate.of(2023, 10, 1), Type.PUBBLICO, 400, foundB);
            ed.saveNewEvent(aE);
            ed.saveNewEvent(bE);
        }catch (Exception ex) {
            System.out.println(ex.getMessage());
        }finally {
            em.close();
            emf.close();
        }



    }
}
