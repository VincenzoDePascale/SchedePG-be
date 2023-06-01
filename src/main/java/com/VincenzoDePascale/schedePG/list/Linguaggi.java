package com.VincenzoDePascale.schedePG.list;

import java.util.HashMap;
import java.util.Map;

import com.fasterxml.jackson.annotation.JsonValue;

public enum Linguaggi {
	
	COMUNE("comune"),
	ELFICO("elfico"),
	GIGANTE("gigante"),
	GNOMESCO("gnomesco"),
	GOBLIN("golblin"),
	HALFLING("halfling"),
	NANICO("nanico"),
	ORCHESCO("orchesco"),
	ABISSALE("abissale"),
	CELESTIALE("celestiale"),
	DRACONICO("draconico"),
	GERGO_DELLE_PROFONDITA("gergo delle profondità"),
	INFERNALE("infernale"),
	PRIMORDIALE("primordiale"),
	SILVANO("silvano"),
	SOTTOCOMUNE("sottocomune");
	
	private String lingua;
	
	Linguaggi(String lingua){
		this.lingua = lingua;
	}
	
	@JsonValue
    public Map<String, Object> getDadi() {
		 Map<String, Object> result = new HashMap<>();
		 result.put("lingua", lingua);
	     
		 return result;
	}
	
	public String getLingua() {
		return lingua;
	}
	
	public static Linguaggi getEnumByLingua(String lingua) {
        for (Linguaggi data : Linguaggi.values()) {
            if (data.getLingua().equalsIgnoreCase(lingua)) {
                return data;
            }
        }
        throw new IllegalArgumentException("Nessun linguaggio si chiama in questo modo: " + lingua);
    }

	
}
