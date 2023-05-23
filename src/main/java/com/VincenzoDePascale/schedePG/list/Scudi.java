package com.VincenzoDePascale.schedePG.list;

import java.util.HashMap;
import java.util.Map;

import com.fasterxml.jackson.annotation.JsonValue;

public enum Scudi {

	// scudi
	SCUDO("scudo", TipiEquip.SCUDO,
			"Uno scudo può essere fatto di legno o di metallo ed è impugnato a una mano. Uno scudo impugnato aumenta di 2 la Classe Armatura del personaggio. Un personaggio può beneficiare di un solo scudo alla volta.",
			10, Moneta.MO, 2, 3);

	private String nome;
	private TipiEquip tipo;
	private String descrizione;
	private int costo;
	private Moneta moneta;
	private int classeArmatura;
	private double peso;

	private Scudi(String nome, TipiEquip tipo, String descrizione, int costo, Moneta moneta, int classeArmatura, double peso) {
		this.nome = nome;
		this.tipo = tipo;
		this.descrizione = descrizione;
		this.costo = costo;
		this.moneta = moneta;
		this.classeArmatura = classeArmatura;
		this.peso = peso;
	}

	public String getNome() {
		return nome;
	}

	public TipiEquip getTipo() {
		return tipo;
	}

	public String getDescrizione() {
		return descrizione;
	}

	public int getCosto() {
		return costo;
	}

	public Moneta getMoneta() {
		return moneta;
	}

	public int getClasseArmatura() {
		return classeArmatura;
	}

	public double getPeso() {
		return peso;
	}

	@JsonValue
	public Map<String, Object> getEquipaggiamento() {
		Map<String, Object> result = new HashMap<>();
		result.put("nome", nome);
		result.put("tipo", tipo);
		result.put("descrizione", descrizione);
		result.put("costo", costo);
		result.put("moneta", moneta);
		result.put("classeArmatura", classeArmatura);
		result.put("peso", peso);
		return result;
	}

}
