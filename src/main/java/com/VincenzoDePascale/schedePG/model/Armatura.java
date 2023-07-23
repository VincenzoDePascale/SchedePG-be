package com.VincenzoDePascale.schedePG.model;

import com.VincenzoDePascale.schedePG.list.Moneta;
import com.VincenzoDePascale.schedePG.list.TipiEquip;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Table;

@Entity
@Table(name = "armature")
public class Armatura extends Equipaggiamento{
	
	@Column
	private int classeArmatura;
	
	@Column
	private boolean furtivita;
	
	public Armatura(String nome, String descrizione,
			TipiEquip tipo, Moneta monete, int costo, double peso,
			int classeArmatura, boolean furtivita) {
		super(nome, descrizione, tipo, monete, costo, peso);
		this.classeArmatura = classeArmatura;
		this.furtivita = furtivita;
	}

}
