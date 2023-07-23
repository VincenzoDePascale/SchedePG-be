package com.VincenzoDePascale.schedePG.model;

import com.VincenzoDePascale.schedePG.list.Dadi;
import com.VincenzoDePascale.schedePG.list.Moneta;
import com.VincenzoDePascale.schedePG.list.TipiEquip;
import com.VincenzoDePascale.schedePG.list.TipoDanno;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Table;

@Entity
@Table(name = "armi")
public class Arma extends Equipaggiamento{
	
	@Column
	private int numeroDadi;
	
	@Column
	private Dadi dado;
	
	@Column
	private TipoDanno tipoDanno;
	
	@Column
	private String proprieta;
	
	public Arma(String nome, String descrizione,
			TipiEquip tipo, Moneta monete, int costo, double peso,
			int numeroDadi, Dadi dado, TipoDanno tipoDanno, String proprieta) {
		super(nome, descrizione, tipo, monete, costo, peso);
		this.numeroDadi = numeroDadi;
		this.dado = dado;
		this.tipoDanno = tipoDanno;
		this.proprieta = proprieta;
	}

}
