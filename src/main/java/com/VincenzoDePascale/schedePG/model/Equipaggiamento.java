package com.VincenzoDePascale.schedePG.model;

import java.util.List;

import com.VincenzoDePascale.schedePG.list.Moneta;
import com.VincenzoDePascale.schedePG.list.TipiEquip;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Inheritance;
import jakarta.persistence.InheritanceType;
import jakarta.persistence.ManyToMany;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table(name = "equipaggiamenti")
@Inheritance(strategy = InheritanceType.JOINED)
@NoArgsConstructor
@AllArgsConstructor
@Data
@Builder
public class Equipaggiamento {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	@ManyToMany(mappedBy = "equipaggiamenti")
    private List<Pg> personaggi;
	
	@Column
	private String nome;
	
	@Column
	private String descrizione;
	
	@Column
	@Enumerated(EnumType.STRING)
	private TipiEquip tipo;
	
	@Column
	@Enumerated(EnumType.STRING)
	private Moneta monete;
	
	@Column
	private int costo;
	
	@Column
	private double peso;
	
	//costruttore senza id
	public Equipaggiamento(String nome, String descrizione,
			TipiEquip tipo, Moneta monete, int costo, double peso) {
		this.nome = nome;
		this.descrizione = descrizione;
		this.tipo = tipo;
		this.monete = monete;
		this.costo = costo;
		this.peso = peso;
	}

}
