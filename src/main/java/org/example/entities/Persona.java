package org.example.entities;

import javax.persistence.*;
import java.time.LocalDate;
import java.util.List;

@Entity
@Table(name = "persona")
public class Persona {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;
    @Column(length = 15)
    private String nome;
    @Column(length = 15)
    private String cognome;
    private String email;
    @Column(name = "data_di_nascità")
    private LocalDate dataDiNascita;
    @Column(length = 1)
    private String sesso;
    @OneToMany(mappedBy = "persona")
    @Column(name = "lista_partecipazioni")
    private List<Partecipazione> listaPartecipazioni;


    //costruttori
    public Persona() {
    }

    public Persona(String nome, String cognome, String email, LocalDate dataDiNascita, String sesso) {
        this.nome = nome;
        this.cognome = cognome;
        this.email = email;
        this.dataDiNascita = dataDiNascita;
        this.sesso = sesso;
    }
}
