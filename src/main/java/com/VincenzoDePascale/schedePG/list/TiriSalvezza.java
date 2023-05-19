package com.VincenzoDePascale.schedePG.list;

import java.util.HashMap;
import java.util.Map;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonValue;

@JsonFormat(shape = JsonFormat.Shape.OBJECT)
public enum TiriSalvezza {
	TS_forza("TS su forza", TipoStatistica.FORZA, 0, false),
	TS_destrezza("TS su destrezza",TipoStatistica.DESTREZZA, 0, false),
	TS_costituzione("TS su costituzione",TipoStatistica.COSTITUZIONE, 0, false),
	TS_intelligenza("TS su intelligenza", TipoStatistica.INTELLIGENZA, 0, false),
	TS_saggezza("TS su saggezza", TipoStatistica.SAGGEZZA,0, false),
	TS_carisma("TS su carisma", TipoStatistica.CARISMA,0, false);
	
	private String nomeTS;
	private TipoStatistica statistica;
	private int punteggio;
	private boolean attivo;
	
	TiriSalvezza(String nomeTS, TipoStatistica statistica,int punteggio, boolean attivo) {
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
