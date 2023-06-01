package com.VincenzoDePascale.schedePG.list;

import java.util.HashMap;
import java.util.Map;

import com.fasterxml.jackson.annotation.JsonValue;

public enum Abilita {
	ACROBAZIA("acrobazia", Statistiche.DESTREZZA),
	ADDESTRARE_ANIMALI("addestrare anumali", Statistiche.SAGGEZZA),
	ARCANO("arcano",Statistiche.INTELLIGENZA),
	ATLETICA("atletica", Statistiche.FORZA),
	FURTIVITA("furtività",Statistiche.DESTREZZA),
	INDAGARE("indagare",Statistiche.INTELLIGENZA),
	INGANNO("inganno", Statistiche.CARISMA),
	INTIMIDIRE("intimidire",Statistiche.CARISMA),
	INTRATTENERE("intrattenere",Statistiche.CARISMA),
	INTUIZIONE("intuizione",Statistiche.SAGGEZZA),
	MEDICINA("medicina",Statistiche.SAGGEZZA),
	NATURA("natura",Statistiche.INTELLIGENZA),
	PERCEZIONE("percezione",Statistiche.SAGGEZZA),
	PERSUASIONE("persuasione",Statistiche.SAGGEZZA),
	RAPIDITA_DI_MANO("rapidità di mano",Statistiche.DESTREZZA),
	RELIGIONE("religione",Statistiche.INTELLIGENZA),
	SOPRAVVIVENZA("sopravvivenza",Statistiche.SAGGEZZA),
	STORIA("storia", Statistiche.INTELLIGENZA);
	
	private String abilita;
	private Statistiche modificatore;
	
	Abilita(String abilita, Statistiche modificatore) {
		this.abilita = abilita;
		this.modificatore = modificatore;
	}
	
	@JsonValue
    public Map<String, Object> getDadi() {
		 Map<String, Object> result = new HashMap<>();
		 result.put("abilita", abilita);
	     result.put("modificatore", modificatore);
		 return result;
	}

	public String getAbilita() {
		return abilita;
	}

	public Statistiche getModificatore() {
		return modificatore;
	}
	
	public static Abilita getEnumByNome(String nome) {
        for (Abilita data : Abilita.values()) {
            if (data.getAbilita().equalsIgnoreCase(nome)) {
                return data;
            }
        }
        throw new IllegalArgumentException("Nessuna competenza trovata con questo nome: " + nome);
    }

}
