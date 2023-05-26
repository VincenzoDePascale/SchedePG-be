package com.VincenzoDePascale.schedePG.list;

import java.util.HashMap;
import java.util.Map;

import com.fasterxml.jackson.annotation.JsonValue;

public enum Razze {
	DRACONIDE("draconide"),
	ELFO("elfo"),
	GNOMO("gnomo"),
	HALFLING("halfling"),
	MEZZELFO("mezzelfo"),
	MEZZORCO("mezzorco"),
	NANO("nano"),
	TIEFLING("tiefling"),
	UMANO("umano");

	private String tipo;

	Razze(String tipo) {
		this.tipo = tipo;
	}

    public static Razze getEnumByTipo(String tipo) {
        for (Razze razza : Razze.values()) {
            if (razza.getTipo().equalsIgnoreCase(tipo)) {
                return razza;
            }
        }
        throw new IllegalArgumentException("Nessuna razza trovata per il tipo: " + tipo);
    }
	
	@JsonValue
    public Map<String, Object> getRazze() {
		 Map<String, Object> result = new HashMap<>();
		 result.put("razza", tipo);
	     
		 return result;
	}

	public String getTipo() {
		return tipo;
	}
}
