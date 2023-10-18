package org.example.entities;

import javax.persistence.*;
import java.time.LocalDate;

@Entity
@Table(name = "evento")
public class Evento {
    @Id
    @GeneratedValue
    private long id;
    private String titolo;
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

    public Evento(String titolo, LocalDate dataEvento, Type tipoEvento, Integer numeroMassimoPartecipanti) {
        this.titolo = titolo;
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