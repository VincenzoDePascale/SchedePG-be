package com.VincenzoDePascale.schedePG.list;

import java.util.HashMap;
import java.util.Map;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonValue;

@JsonFormat(shape = JsonFormat.Shape.OBJECT)
public enum Abilita {
	acrobazia("acrobazia", 0, Statistiche.DESTREZZA, false),
	addestrare_animali("addestrare animali", 0, Statistiche.SAGGEZZA, false),
	arcano("arcano", 0, Statistiche.INTELLIGENZA, false),
	atletica("atletica", 0, Statistiche.FORZA, false),
	furtivita("furtività", 0, Statistiche.DESTREZZA, false),
	indagare("indagare", 0, Statistiche.INTELLIGENZA, false),
	inganno("inganno", 0, Statistiche.CARISMA, false),
	intimidire("intimidire", 0, Statistiche.CARISMA, false),
	intrattenere("intrattenere", 0, Statistiche.CARISMA, false),
	intuizione("intuizione", 0, Statistiche.SAGGEZZA, false),
	medicina("medicina", 0, Statistiche.SAGGEZZA, false),
	natura("natura", 0, Statistiche.INTELLIGENZA, false),
	percezione("percezione", 0, Statistiche.SAGGEZZA, false),
	persuazione("persuasione", 0, Statistiche.CARISMA, false),
	rapidita_di_mano("rapidità", 0, Statistiche.DESTREZZA, false),
	religione("religione", 0, Statistiche.INTELLIGENZA, false),
	sopravvivenza("sopravvivenza", 0, Statistiche.SAGGEZZA, false),
	storia("storia", 0, Statistiche.INTELLIGENZA, false),
	percezione_passiva("percezione", 0, Statistiche.SAGGEZZA, false);

	private String nomeAbilita;
	private Integer punteggio;
	private Statistiche statistica;
	private boolean attivo;
	
	Abilita(String nomeAbilita, int punteggio, Statistiche statistica, boolean attivo) {
		this.nomeAbilita = nomeAbilita;
		this.punteggio = punteggio;
		this.statistica = statistica;
		this.attivo = attivo;
	}
	
	public void setPunteggio(String nome, int valore) {
		for(Abilita abilita : Abilita.values()) {
			if(abilita.name().equalsIgnoreCase(nome)) {
				this.punteggio = valore;
				break;
			}
		}
		
	}
	
	public void setAttivo(String nome, boolean valore) {
		for(Abilita abilita : Abilita.values()) {
			if(abilita.name().equalsIgnoreCase(nome)) {
				this.attivo = valore;
				break;
			}
		}
		
	}
	
	@JsonValue
	public Map<String, Object> getAbilita() {
		Map<String, Object> result = new HashMap<>();
		result.put("abilità", nomeAbilita);
        result.put("statistica", statistica);
        result.put("punteggio", punteggio);
        result.put("attivo", attivo);
        return result;
	}
}