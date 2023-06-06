package com.VincenzoDePascale.schedePG.list;

import java.util.HashMap;
import java.util.Map;

import com.fasterxml.jackson.annotation.JsonValue;

public enum Allineamenti {

	LEGALE_BUONO("legale buono"),
	LEGALE_NEUTRALE("legale neutrale"),
	LEGALE_MALVAGIO("legale malvagio"),
	NEUTRALE_BUONO("neutrale buono"),
	NEUTRALE("neutrale"),
	NEUTRALE_MALVAGIO("neutrale buono"),
	CAOTICO_BUONO("caotico buono"),
	CAOTICO_NEUTRALE("caotico neutrale"),
	CAOTICO_MALVAGIO("caotico malvagio");
	
	private String tipo;
	
	Allineamenti(String tipo){
		this.tipo = tipo;
	}
	
	public static Allineamenti getEnumByTipo(String tipo) {
        for (Allineamenti allineamento : Allineamenti.values()) {
            if (allineamento.getTipo().equalsIgnoreCase(tipo)) {
                return allineamento;
            }
        }
        throw new IllegalArgumentException("Nessun enum trovato per il tipo: " + tipo);
    }
	
	@JsonValue
    public Map<String, Object> getAllineamenti() {
		 Map<String, Object> result = new HashMap<>();
		 result.put("tipo", tipo);
		 return result;
	}

	public String getTipo() {
		return tipo;
	}
	
	
}
