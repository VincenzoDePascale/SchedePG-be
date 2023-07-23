package com.VincenzoDePascale.schedePG.list;

import java.util.HashMap;
import java.util.Map;

import com.fasterxml.jackson.annotation.JsonValue;


public enum Moneta {

    MR("MR", "moneta di rame", "monete di rame"),
    MA("MA", "moneta d'argento", "monete d'argento"),
    MO("MO", "moneta d'oro", "monete d'oro"),
    MP("MP", "moneta di platino", "moneta di platino");
	
	public String riduzione;
	public String singolare;
	public String plurale;
	
	Moneta(String riduzione, String singolare, String plurale) {
		this.riduzione = riduzione;
		this.singolare = singolare;
		this.plurale = plurale;
	}
	
	public String getRiduzione() {
		return riduzione;
	}
	
	public String getSingolare() {
		return singolare;
	}
	
	public String getPlurale() {
		return plurale;
	}
	
	@JsonValue
	public Map<String, Object> getMoneta() {
		Map<String, Object> result = new HashMap<>();
		result.put("riduzione", riduzione);
		result.put("singolare", singolare);
		result.put("plurale", plurale);
		
		return result;
	}
	
	public static Moneta getEnumByRiduzione(String riduzione) {
		for(Moneta data : Moneta.values()) {
			if(data.getRiduzione().equalsIgnoreCase(riduzione)) {
                return data;
            }
        }
        throw new IllegalArgumentException("nessuna moneta esistente con questo nome: " + riduzione);
    }
	    
}
