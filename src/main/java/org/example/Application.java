package org.example;

import org.example.entities.Evento;
import org.example.entities.Location;
import org.example.entities.Partecipazione;
import org.example.entities.Persona;
import org.example.entities.classDao.EventoDao;
import org.example.entities.classDao.LocationDao;
import org.example.entities.classDao.PartecipazioneDao;
import org.example.entities.classDao.PersonaDao;
import org.example.entities.enumeratori.Stato;
import org.example.entities.enumeratori.Type;
import org.example.utils.JpaUtil;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import java.time.LocalDate;
import java.util.List;
import java.util.Set;

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
            Location foundlA = ld.searchById(1);
            Location foundlB = ld.searchById(2);
            
            if (foundlA != null) {
                //Evento aE = new Evento("Opera", "Lirica a teatro", LocalDate.of(2023, 9, 21), Type.PUBBLICO, 500, foundlA);
                //ed.saveNewEvent(aE);
            }else {
                System.out.println("location non trovata");
            }
            if (foundlB != null) {
                //Evento bE = new Evento("Opera", "Spettacolo comico", LocalDate.of(2023, 10, 1), Type.PUBBLICO, 400, foundB);
                //ed.saveNewEvent(bE);
            }
            //Aggiungo infine le partecipazioni

            //trovo persone
            Persona foundpA = ped.searchById(1);
            Persona foundpB = ped.searchById(2);
            Persona foundpC = ped.searchById(3);
            //trovo eventi
            /*Evento foundeA = ed.searchById(1);
            Evento foundeB = ed.searchById(2);

            Partecipazione aP = new Partecipazione(foundpA, foundeA, Stato.CONFERMATO);
            Partecipazione bP = new Partecipazione(foundpA, foundeB, Stato.DA_CONFERMARE);
            Partecipazione cP = new Partecipazione(foundpB, foundeA, Stato.DA_CONFERMARE);
            Partecipazione dP = new Partecipazione(foundpB, foundeB, Stato.DA_CONFERMARE);
            Partecipazione eP = new Partecipazione(foundpC, foundeB, Stato.CONFERMATO);
            Partecipazione fP = new Partecipazione(foundpC, foundeA, Stato.CONFERMATO);

            pd.saveNewPartecipation(aP);
            pd.saveNewPartecipation(bP);
            pd.saveNewPartecipation(cP);
            pd.saveNewPartecipation(dP);
            pd.saveNewPartecipation(eP);
            pd.saveNewPartecipation(fP);*/
            List<Partecipazione> setPartA = foundpA.getListaPartecipazioni();
            System.out.println("lista partecipazioni utente " + foundpA.getNome());
            setPartA.forEach(System.out::println);
            List<Partecipazione> setPartB = foundpB.getListaPartecipazioni();
            System.out.println("-------------*--------------");
            System.out.println("lista partecipazioni utente " + foundpB.getNome());
            setPartB.forEach(System.out::println);
            System.out.println("-------------*--------------");
            List<Partecipazione> setPartC = foundpC.getListaPartecipazioni();
            System.out.println("lista partecipazioni utente " + foundpC.getNome());
            setPartC.forEach(System.out::println);
            System.out.println("-------------*--------------");
        }catch (Exception ex) {
            System.out.println(ex.getMessage());
        }finally {
            em.close();
            emf.close();
        }



    }
}
