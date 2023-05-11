package com.VincenzoDePascale.schedePG.list;

import java.util.HashMap;
import java.util.Map;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonValue;

@JsonFormat(shape = JsonFormat.Shape.OBJECT)
public enum Dadi {
	D4("D4", 4), D6("D6", 6), D8("D8", 8), D10("D10", 10), D12("D12", 12), D20("D20", 20);

	private String dado;
	private int valore;
	
	Dadi(String dado, int valore) {
		this.dado = dado;
		this.valore = valore;
	}
	
	@JsonValue
    public Map<String, Object> getDadi() {
		 Map<String, Object> result = new HashMap<>();
		 result.put("dado", dado);
	     result.put("valore", valore);
		 return result;
	}
	
}
