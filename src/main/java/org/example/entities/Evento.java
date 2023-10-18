package org.example.entities;

import org.example.entities.enumeratori.Type;

import javax.persistence.*;
import java.time.LocalDate;

@Entity
@Table(name = "evento")
public class Evento {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;
    private String titolo;
    private String descrizione;
    @Column(name = "data_evento")
    private LocalDate dataEvento;
    @Column(name = "tipo_evento")
    @Enumerated(EnumType.STRING)
    private Type tipoEvento;
    @Column(name = "numero_max_partecipanti")
    private Integer numeroMassimoPartecipanti;

    //costruttori


    public Evento() {
    }

    public Evento(String titolo, String descrizione, LocalDate dataEvento, Type tipoEvento, Integer numeroMassimoPartecipanti) {
        this.titolo = titolo;
        this.descrizione= descrizione;
        this.dataEvento = dataEvento;
        this.tipoEvento = tipoEvento;
        this.numeroMassimoPartecipanti = numeroMassimoPartecipanti;
    }

    //getter e setter

    public String getTitolo() {
        return titolo;
    }

    public void setTitolo(String titolo) {
        this.titolo = titolo;
    }

    public String getDescrizione() {
        return descrizione;
    }

    public void setDescrizione(String descrizione) {
        this.descrizione = descrizione;
    }

    public LocalDate getDataEvento() {
        return dataEvento;
    }

    public void setDataEvento(LocalDate dataEvento) {
        this.dataEvento = dataEvento;
    }

    public Type getTipoEvento() {
        return tipoEvento;
    }

    public void setTipoEvento(Type tipoEvento) {
        this.tipoEvento = tipoEvento;
    }

    public Integer getNumeroMassimoPartecipanti() {
        return numeroMassimoPartecipanti;
    }

    public void setNumeroMassimoPartecipanti(Integer numeroMassimoPartecipanti) {
        this.numeroMassimoPartecipanti = numeroMassimoPartecipanti;
    }
    //override

}