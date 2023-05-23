package com.VincenzoDePascale.schedePG.list;

import java.util.HashMap;
import java.util.Map;

import com.fasterxml.jackson.annotation.JsonValue;

public enum Armi {
	
	//armi da mischia semplici
	ASCIA("ascia", TipiEquip.ARMA_DA_MISCHIA_SEMPLICE, 1, Dadi.D6, TipoDanno.TAGLEINTE, "Lancio (gittata 6/18), Leggera", 5, Moneta.MO, 1),
	BASTONE_FERRATO("bastone ferrato", TipiEquip.ARMA_DA_MISCHIA_SEMPLICE, 1, Dadi.D6, TipoDanno.CONTUNDENTE, "Versatile (1d8)", 2, Moneta.MO, 2),
	FALCETTO("falcetto", TipiEquip.ARMA_DA_MISCHIA_SEMPLICE, 1, Dadi.D4, TipoDanno.TAGLEINTE, "Leggera", 1, Moneta.MO, 1),
	GIAVELLOTTO("giavellotto", TipiEquip.ARMA_DA_MISCHIA_SEMPLICE, 1, Dadi.D6, TipoDanno.PERFORANTE, "Lancio (gittata 9/36)", 5, Moneta.MA, 1),
	LANCIA("lancia", TipiEquip.ARMA_DA_MISCHIA_SEMPLICE, 1, Dadi.D6, TipoDanno.PERFORANTE,  "Lancio (gittata 6/18), Versatile (1d8)", 1, Moneta.MO, 1.5),
	MARTELLO_LEGGERO("martello leggere", TipiEquip.ARMA_DA_MISCHIA_SEMPLICE, 1, Dadi.D4, TipoDanno.CONTUNDENTE, "Lancio (gittata 6/18), Leggera", 2, Moneta.MO, 1),
	MAZZA("mazza", TipiEquip.ARMA_DA_MISCHIA_SEMPLICE, 1, Dadi.D6, TipoDanno.CONTUNDENTE, "", 5, Moneta.MO, 2),
	PUGNALE("pugnale", TipiEquip.ARMA_DA_MISCHIA_SEMPLICE, 1, Dadi.D4, TipoDanno.PERFORANTE, "Accurata, Lancio (gittata 6/18), Leggera", 2, Moneta.MO, 0.5),
	RANDELLO_PESANTE("randello pesante", TipiEquip.ARMA_DA_MISCHIA_SEMPLICE, 1, Dadi.D8, TipoDanno.CONTUNDENTE, "Leggera", 2, Moneta.MA, 5),
	
	//armi a distanza semplici
	ARCO_CORTO("arco corto", TipiEquip.ARMA_A_DISTANZA_SEMPLICE, 1, Dadi.D6, TipoDanno.PERFORANTE, "Due Mani, Munizioni (gittata 24/96)", 25, Moneta.MO, 1),
	BALESTRA_LEGGERA("balestra leggera", TipiEquip.ARMA_A_DISTANZA_SEMPLICE, 1, Dadi.D8, TipoDanno.PERFORANTE,  "Due Mani, Munizioni (gittata 24/96), Ricarica", 25, Moneta.MO, 2.5),
	DARDO("dardo", TipiEquip.ARMA_A_DISTANZA_SEMPLICE, 1, Dadi.D4, TipoDanno.PERFORANTE, "Accurata, Lancio (gittata 6/18)", 5, Moneta.MR, 0.125),
	FIONDA("fionda", TipiEquip.ARMA_A_DISTANZA_SEMPLICE, 1, Dadi.D4, TipoDanno.CONTUNDENTE, "Munizioni (gittata 9/36)", 1, Moneta.MA, 0),
	
	//armi da mischia da guerra
	ALABARDA("alabarda", TipiEquip.ARMA_DA_MISCHIA_DA_GUERRA, 1, Dadi.D10, TipoDanno.TAGLEINTE, "Due Mani, Pesante, Portata", 20, Moneta.MO, 3),
	ASCIA_BIPENNE("ascia bipenne", TipiEquip.ARMA_DA_MISCHIA_DA_GUERRA, 1, Dadi.D12, TipoDanno.TAGLEINTE, "Due Mani, Pesante", 30, Moneta.MO, 3.5),
	ASCIA_DA_BATTAGLIA("asccia da battaglia", TipiEquip.ARMA_DA_MISCHIA_DA_GUERRA, 1, Dadi.D8, TipoDanno.TAGLEINTE, "Versatile (1d10)", 10, Moneta.MO, 2),
	FALCIONE("falcione", TipiEquip.ARMA_DA_MISCHIA_DA_GUERRA, 1, Dadi.D10, TipoDanno.TAGLEINTE, "Due Mani, Pesante, Portata", 20, Moneta.MO, 3),
	FRUSTA("frusta", TipiEquip.ARMA_DA_MISCHIA_DA_GUERRA, 1, Dadi.D4, TipoDanno.TAGLEINTE, "Accurata, Portata", 2, Moneta.MO, 1.5),
	LANCIA_DA_CAVALIERE("lancia da cavaliere", TipiEquip.ARMA_DA_MISCHIA_DA_GUERRA, 1, Dadi.D12, TipoDanno.PERFORANTE, "Portata, Speciale.\nIl personaggio subisce svantaggio quando usa una lancia da cavaliere per attaccare un bersaglio entro 1,5 metri da lui. Inoltre, una lancia da cavaliere deve essere impugnata a due mani quando il personaggio non è in sella.", 10, Moneta.MO, 3),
	MAGLIO("maglio", TipiEquip.ARMA_DA_MISCHIA_DA_GUERRA, 2, Dadi.D6, TipoDanno.CONTUNDENTE, "Due Mani, Pesante", 10, Moneta.MO, 5),
	MARTELLO_DA_GUERRA("martello da guerra", TipiEquip.ARMA_DA_MISCHIA_DA_GUERRA, 1, Dadi.D8, TipoDanno.CONTUNDENTE, "Versatile (1d10)", 15, Moneta.MO, 1),
	MAZZAFRUSTO("mazzafrusto", TipiEquip.ARMA_DA_MISCHIA_DA_GUERRA, 1, Dadi.D8, TipoDanno.CONTUNDENTE, "", 10, Moneta.MO, 1),
	MORNING_STAR("morning star", TipiEquip.ARMA_DA_MISCHIA_DA_GUERRA, 1, Dadi.D8, TipoDanno.PERFORANTE, "", 15, Moneta.MO, 2),
	PICCA("picca", TipiEquip.ARMA_DA_MISCHIA_DA_GUERRA, 1, Dadi.D10, TipoDanno.PERFORANTE, "Due Mani, Pesante, Portata", 5, Moneta.MO, 9),
	PICCONE_DA_GUERRA("piccone da guerra", TipiEquip.ARMA_DA_MISCHIA_DA_GUERRA, 1, Dadi.D8, TipoDanno.PERFORANTE, "", 5, Moneta.MO, 1),
	SCIMITARRA("scimitarra", TipiEquip.ARMA_DA_MISCHIA_DA_GUERRA, 1, Dadi.D6, TipoDanno.TAGLEINTE, "Accurata, Leggera", 25, Moneta.MO, 1.5),
	SPADA_CORTA("spada corta", TipiEquip.ARMA_DA_MISCHIA_DA_GUERRA, 1, Dadi.D6, TipoDanno.PERFORANTE, "Accurata, Leggera", 10, Moneta.MO, 1),
	SPADA_LUNGA("spada lunga", TipiEquip.ARMA_DA_MISCHIA_DA_GUERRA, 1, Dadi.D8, TipoDanno.TAGLEINTE, "Versatile (1d10)", 15, Moneta.MO, 1.5),
	SPADONE("spadone", TipiEquip.ARMA_DA_MISCHIA_DA_GUERRA, 2, Dadi.D6, TipoDanno.TAGLEINTE, "Due Mani, Pesante", 50, Moneta.MO, 3),
	STOCCO("stocco", TipiEquip.ARMA_DA_MISCHIA_DA_GUERRA, 1, Dadi.D8, TipoDanno.PERFORANTE, "Accurata", 25, Moneta.MO, 1),
	TRIDENTE("tridente", TipiEquip.ARMA_DA_MISCHIA_DA_GUERRA, 1, Dadi.D6, TipoDanno.PERFORANTE, "Lancio (gittata 6/18), Versatile (1d8)", 5, Moneta.MO, 2),
	
	//armi a distanza da guerra
	ARCO_LUNGO("arco lungo", TipiEquip.ARMA_A_DISTANZA_DA_GUERRA, 1, Dadi.D8, TipoDanno.PERFORANTE, "Due Mani, Munizioni (gittata 45/180), Pesante", 50, Moneta.MO, 1),
	BALESTRA_A_MANO("balestra a mano", TipiEquip.ARMA_A_DISTANZA_DA_GUERRA, 1, Dadi.D6, TipoDanno.PERFORANTE, "Leggera, Munizioni (gittata 9/36), Ricarica", 75, Moneta.MO, 1.5),
	BALESTRA_PESANTE("balestra pesante", TipiEquip.ARMA_A_DISTANZA_DA_GUERRA, 1, Dadi.D10, TipoDanno.PERFORANTE, "Due Mani, Munizioni (gittata 30/120), Pesante, Ricarica", 50, Moneta.MO, 9),
	CERBOTTANA("cerbottana", TipiEquip.ARMA_A_DISTANZA_DA_GUERRA, 1, Dadi.D1, TipoDanno.PERFORANTE, "Munizioni (gittata 7,5/30), Ricarica", 10, Moneta.MO, 0.5),
	RETE("rete", TipiEquip.ARMA_A_DISTANZA_DA_GUERRA, 0, Dadi.D0, TipoDanno.ASSENTE, "Lancio (gittata 1,5/4,5), Speciale.\nUna creatura di taglia Grande o inferiore che viene colpita da una rete è trattenuta finché non viene liberata. Una rete non ha effetto sulle creature prive di forma o le creature di taglia Enorme o superiore. Una creatura può usare la sua azione per effettuare una prova di Forza con CD 10, liberando sé stessa o un'altra creatura entro la sua portata in caso di successo. Anche infliggendo 5 danni taglienti alla rete (CA 10) si libera la creatura senza infliggerle danni, ponendo fine all'effetto e distruggendo la rete. Quando il personaggio usa un'azione, un'azione bonus o una reazione per attaccare con una rete, può effettuare un solo attacco, a prescindere dal numero di attacchi che potrebbero effettuare normalmente.", 1, Moneta.MO, 1.5);
	
	private String nome;
	private TipiEquip tipo;
	private Dadi danno;
	private TipoDanno tipoDanno;
	private int numeroDadi;
	private String descrizione;
    private double costo;
    private Moneta moneta;
    private double peso;
    
	Armi(String nome, TipiEquip tipo, int numeroDadi, Dadi danno, TipoDanno tipoDanno, String descrizione, double costo, Moneta moneta,
			double peso) {
		this.nome = nome;
		this.tipo = tipo;
		this.numeroDadi = numeroDadi;
		this.danno = danno;
		this.tipoDanno = tipoDanno;
		this.descrizione = descrizione;
		this.costo = costo;
		this.moneta = moneta;
		this.peso = peso;
	}

	public String getNome() {
		return nome;
	}

	public TipiEquip getTipo() {
		return tipo;
	}

	public Dadi getDanno() {
		return danno;
	}

	public TipoDanno getTipoDanno() {
		return tipoDanno;
	}

	public int getNumeroDadi() {
		return numeroDadi;
	}

	public String getDescrizione() {
		return descrizione;
	}

	public double getCosto() {
		return costo;
	}

	public Moneta getMoneta() {
		return moneta;
	}

	public double getPeso() {
		return peso;
	}
    
	@JsonValue
	public Map<String, Object> getEquipaggiamento() {
		Map<String, Object> result = new HashMap<>();
		result.put("nome", nome);
		result.put("tipo", tipo);
		result.put("numeroDadi", numeroDadi);
		result.put("danno", danno);
		result.put("tipoDanno", tipoDanno);
		result.put("descrizione", descrizione);
		result.put("costo", costo);
		result.put("moneta", moneta);
		result.put("peso", peso);
		return result;
	}
	

}
