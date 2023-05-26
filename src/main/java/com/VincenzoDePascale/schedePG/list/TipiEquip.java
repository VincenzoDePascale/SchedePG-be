package com.VincenzoDePascale.schedePG.list;

import java.util.HashMap;
import java.util.Map;

import com.fasterxml.jackson.annotation.JsonValue;

public enum TipiEquip {
	//tipologia equipaggiamento
	BASE("base"),
	FOCUS_ARCANO("focus arcano"),
	FOCUS_DRUIDICO("focus druidico"),
	SIMBOLO_SACRO("simbolo sacro"),
	ARMATURA_LEGGERA("armatura leggera"),
	ARMATURA_MEDIA("armatura media"),
	ARMATURA_PESANTE("armatura pesante"),
	SCUDO("scrudo"),
	POZIONE("pozione"),
	GIOCO("gioco"),
	STRUMENTO("strumento"),
	STRUMENTO_MUSICALE("strumento musicale"),
	STRUMENTO_DA_ARTIGIANO("strumento da artigiano"),
	ARMA_DA_MISCHIA_SEMPLICE("arma da mischia semplice"),
	ARMA_A_DISTANZA_SEMPLICE("arma a distanza semplice"),
	ARMA_DA_MISCHIA_DA_GUERRA("arma da mischia da guerra"),
	ARMA_A_DISTANZA_DA_GUERRA("arma a distanza da guerra"),
	BALESTRA_A_MANO("balestra a mano"),
	BALESTRA_LEGGERA("balestra leggera"),
	BALESTRA_PESANTE("balestra pesante"),
	
	//tipologia armi per competenza
	SPADA_CORTA("spada corta"),
	SPADA_LUNGA("spada lunga"),
	STOCCO("stocco"),
	BASTONE_FERRATO("bastone ferrato"),
	DARDO("dardo"),
	FALCETTO("falcetto"),
	FIONDA("fionda"),
	GIAVELLOTTO("giavellotto"),
	LANCIA("lancia"),
	MAZZA("mazza"),
	PUGNALE("pugnale"),
	RANDELLO("randello"),
	SCIMITARRA("scimitarra");

	private String nome;

	TipiEquip(String nome) {
		this.nome = nome;
	}
	
	@JsonValue
    public Map<String, Object> getDadi() {
		 Map<String, Object> result = new HashMap<>();
		 result.put("nome", nome);
	     
		 return result;
	}

	public String getNome() {
		return nome;
	}
}
