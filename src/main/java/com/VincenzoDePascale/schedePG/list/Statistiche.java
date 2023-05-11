package com.VincenzoDePascale.schedePG.list;

import java.util.HashMap;
import java.util.Map;
import java.util.Arrays;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonValue;


@JsonFormat(shape = JsonFormat.Shape.OBJECT)
public enum Statistiche {
	FORZA("forza", 10, 0), DESTREZZA("destrezza", 10, 0), COSTITUZIONE("coscostituzione", 10, 0), INTELLIGENZA("intelligenza", 10, 0),
	SAGGEZZA("saggezza", 10, 0), CARISMA("carisma", 10, 0);

	private String statistica;
	private int punteggio;
	private int modificatore;

	Statistiche(String stat, int punteggio, int modificatore) {
		this.statistica = stat;
		this.punteggio = punteggio;
		this.modificatore = modificatore;
	}

	public void setPunteggio(String nome, int valore) {
		for (Statistiche statistica : Statistiche.values()) {
			if (statistica.name().equalsIgnoreCase(nome)) {
				statistica.punteggio = valore;
				int mod = (int) Math.floor((punteggio - 10) / 2.0);
	            statistica.modificatore = mod;
			}
		}
	}
	
	@JsonValue
	public Map<String, Object> getStatistiche() {
		Map<String, Object> result = new HashMap<>();
		result.put("statistica", statistica);
		result.put("punteggio", punteggio);
		result.put("modificatore", modificatore);
		return result;
	}

	public static int getPunteggioForEnumName(String enumName) {
		try {
			Statistiche stat = Statistiche.valueOf(enumName);
			System.out.println("Modificatore per " + enumName + ": " + stat.modificatore);
			return stat.punteggio;
		} catch (IllegalArgumentException e) {
			throw new IllegalArgumentException("Enum non valido: " + enumName + ". I valori validi sono: " + Arrays.toString(Statistiche.values()));
		}
	}
	
}
