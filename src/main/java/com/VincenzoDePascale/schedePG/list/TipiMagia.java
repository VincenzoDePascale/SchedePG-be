package com.VincenzoDePascale.schedePG.list;

import java.util.HashMap;
import java.util.Map;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonValue;

@JsonFormat(shape = JsonFormat.Shape.OBJECT)
public enum TipiMagia {
	ARCANA("magia arcana", "desc"),
	DIVINA("magia divina", "desc");
	
	private String nome;
	private String descrizione;
	
	TipiMagia(String nome, String descrizione){
		this.nome = nome;
		this.descrizione = descrizione;
	}
	
	public String getNome() {
        return nome;
    }
	
	public String getDescrizione() {
        return descrizione;
    }

    @JsonValue
    public Map<String, Object> getEquipaggiamento() {
        Map<String, Object> result = new HashMap<>();
        result.put("nome", nome);
        result.put("descrizione", descrizione);
        return result;
    }
    
    public static TipiMagia getEnumByNome(String tipo) {
        for (TipiMagia data : TipiMagia.values()) {
            if (data.getNome().equalsIgnoreCase(tipo)) {
                return data;
            }
        }
        throw new IllegalArgumentException("Nessun eqipaggiamento trovato con questo nome: " + tipo);
    }

}
