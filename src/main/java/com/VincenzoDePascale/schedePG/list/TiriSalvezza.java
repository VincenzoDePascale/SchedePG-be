package com.VincenzoDePascale.schedePG.list;

import java.util.HashMap;
import java.util.Map;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonValue;

@JsonFormat(shape = JsonFormat.Shape.OBJECT)
public enum TiriSalvezza {
	TS_forza("TS su forza", Statistiche.FORZA, 0, false),
	TS_destrezza("TS su destrezza",Statistiche.DESTREZZA, 0, false),
	TS_costituzione("TS su costituzione",Statistiche.COSTITUZIONE, 0, false),
	TS_intelligenza("TS su intelligenza", Statistiche.INTELLIGENZA, 0, false),
	TS_sagezza("TS su saggezza", Statistiche.SAGGEZZA,0, false),
	TS_carisma("TS su carisma", Statistiche.CARISMA,0, false);
	
	private String nomeTS;
	private Statistiche statistica;
	private int punteggio;
	private boolean attivo;
	
	TiriSalvezza(String nomeTS, Statistiche statistica,int punteggio, boolean attivo) {
		this.nomeTS = nomeTS;
		this.statistica = statistica;
		this.punteggio = punteggio;
		this.attivo = attivo;
		
	}
	
	public void setPunteggio(String nome, int valore) {
		for(TiriSalvezza TS : TiriSalvezza.values()) {
			if(TS.name().equalsIgnoreCase(nome)) {
				this.punteggio = valore;
				break;
			}
		}
	}
	
	public void setAttivo(String nome, boolean valore) {
		for(TiriSalvezza TS : TiriSalvezza.values()) {
			if(TS.name().equalsIgnoreCase(nome)) {
				this.attivo = valore;
				break;
			}
		}
	}
	
	@JsonValue
	public Map<String, Object> getTiriSalvezza() {
		Map<String, Object> result = new HashMap<>();
		result.put("nomeTS", nomeTS);
        result.put("statistica", statistica);
        result.put("punteggio", punteggio);
        result.put("attivo", attivo);
		return result;
	}
}
