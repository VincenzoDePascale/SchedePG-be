package com.VincenzoDePascale.schedePG.model;

import com.VincenzoDePascale.schedePG.list.TipoStatistica;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "statistiche")
public class Statistica {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @JsonIgnoreProperties({ "personaggi", "giocatore" })
    private Long id;

    @Enumerated(EnumType.STRING)
    private TipoStatistica statistica;

    @Column(nullable = false)
    private int punteggio;

    @Column(nullable = false)
    private int modificatore;

    public Statistica(TipoStatistica statistica, int punteggio) {
        this.statistica = statistica;
        this.punteggio = punteggio;
        this.modificatore = (int) ((punteggio - 10) / 2.0);
    }

    public void setPunteggio(int punteggio) {
        this.punteggio = punteggio;
        this.modificatore = (int) ((punteggio - 10) / 2.0);
    }
    
    public void setModificaPunteggio(int modifica) {
        this.punteggio += modifica;
        this.modificatore = (int) ((this.punteggio - 10) / 2.0);
    }
}
