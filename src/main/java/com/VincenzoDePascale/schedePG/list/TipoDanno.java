package com.VincenzoDePascale.schedePG.list;

import java.util.HashMap;
import java.util.Map;

import com.fasterxml.jackson.annotation.JsonValue;

public enum TipoDanno {
		ACIDO("acido"), 
		CONTUNDENTE("contundente"),
		FORZA("forza"),
		FREDDO("freddo"),
		FULMINE("fulmine"),
		FUOCO("fuoco"),
		NECROTICO("necrotico"),
		PSICHICO("prichico"),
		PERFORANTE("perfonante"),
		RADIANTE("radiante"),
		TAGLEINTE("tagliente"),
		VELENO("veleno"),
		ASSENTE("assente");
	
	private String tipo;
	
	TipoDanno(String tipo){
		this.tipo = tipo;
	}
	
	@JsonValue
	public Map<String, Object> getEquipaggiamento() {
		Map<String, Object> result = new HashMap<>();
		result.put("tipo", tipo);
		return result;
	}
	
	public String getTipo() {
		return tipo;
	}
	
	public static TipoDanno getEnumByTipo(String tipo) {
        for (TipoDanno data : TipoDanno.values()) {
            if (data.getTipo().equalsIgnoreCase(tipo)) {
                return data;
            }
        }
        throw new IllegalArgumentException("Nessuna tipo di danno chiamato in questo modo: " + tipo);
    }
}
