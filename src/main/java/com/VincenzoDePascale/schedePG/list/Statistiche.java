package com.VincenzoDePascale.schedePG.list;

import java.util.HashMap;
import java.util.Map;

import com.fasterxml.jackson.annotation.JsonValue;

public enum Statistiche {
	FORZA("forza", "for"),
	DESTREZZA("destrezza", "des"),
	COSTITUZIONE("costituzione", "cos"),
	INTELLIGENZA("intelligenza", "int"),
	SAGGEZZA("saggezza", "sag"),
	CARISMA("carisma", "car");
	
	private String statistica;
	private String modificatore;
	
	Statistiche(String statistica, String modificatore) {
		this.statistica = statistica;
		this.modificatore = modificatore;
	}
	
	@JsonValue
    public Map<String, Object> getDadi() {
		 Map<String, Object> result = new HashMap<>();
		 result.put("statistica", statistica);
	     result.put("modificatore", modificatore);
		 return result;
	}

	public String getStatistica() {
		return statistica;
	}

	public String getModificatore() {
		return modificatore;
	}

}
