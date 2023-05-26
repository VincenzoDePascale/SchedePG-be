package com.VincenzoDePascale.schedePG.list;

import java.util.HashMap;
import java.util.Map;

import com.fasterxml.jackson.annotation.JsonValue;

public enum Classi {
	BARBARO("barbaro"),
	BARDO("bardo"),
	CHIERICO("chierico"),
	DRUIDO("druido"),
	GUERRIERO("guerriero"),
	LADRO("ladro"),
	MAGO("mago"),
	MONACO("monaco"),
	PALADINO("paladino"),
	RANGER("ranger"),
	STREGONE("stragone"),
	WARLOCK("warlock");

	private String tipo;

	Classi(String tipo) {
		this.tipo = tipo;
	}

    public static Classi getEnumByTipo(String tipo) {
        for (Classi classe : Classi.values()) {
            if (classe.getTipo().equalsIgnoreCase(tipo)) {
                return classe;
            }
        }
        throw new IllegalArgumentException("Nessuna classe trovata per il tipo: " + tipo);
    }

	
	@JsonValue
    public Map<String, Object> getClassi() {
		 Map<String, Object> result = new HashMap<>();
		 result.put("classe", tipo);
	     
		 return result;
	}

	public String getTipo() {
		return tipo;
	}

}
