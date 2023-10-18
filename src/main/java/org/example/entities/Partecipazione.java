package org.example.entities;

import org.example.entities.enumeratori.Stato;

import javax.persistence.*;

@Entity
public class Partecipazione {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;
    @ManyToOne
    @JoinColumn(name = "persona_id")
    private Persona persona;
    @OneToOne
    @JoinColumn(name = "evento_id", nullable = false)
    private Evento evento;
    private Stato stato;
}
