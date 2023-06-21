package com.VincenzoDePascale.schedePG.list;

import java.util.HashMap;
import java.util.Map;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonValue;

@JsonFormat(shape = JsonFormat.Shape.OBJECT)
public enum ClassiIncantesimo {
	
	ABIURAZIONE("abiurazione", "Riguarda incantesimi di natura protettiva, sebbene ne contenga anche alcuni dall’uso aggressivo. Questi incantesimi creano barriere magiche, negano effetti dannosi, danneggiano i violatori, o bandiscono le creature in altri piani di esistenza."),
	AMMALIAMENTO("ammaliamento", "Riguarda incantesimi che agiscono sulla mente altrui, influenzandone o controllandone il comportamento. Questi incantesimi possono far sì che i nemici considerino l’incantatore un amico, forzare creature a effettuare determinate azioni, o addirittura controllare un’altra creatura come fosse una marionetta."),
	DIVINAZIONE("divinazione", "Riguarda incantesimi che rivelano informazioni nella forma di segreti da tempo dimenticati, visioni del futuro, la posizione di oggetti nascosti, la verità dietro le illusioni o immagini di persone e luoghi lontani."),
	EVOCAZIONE("evocazione", "Riguarda incantesimi che trasportano oggetti e creature da un luogo all’altro. Alcuni incantesimi richiamano creature o oggetti al fianco dell’incantatore, mentre altri permettono all’incantatore di teletrasportarsi da un luogo a un altro. Alcune evocazioni creano oggetti o effetti dal nulla."),
	ILLUSIONE("illusione", "Riguarda incantesimi che ingannano i sensi e la mente altrui. Fanno vedere alle persone cose che non esistono, non gli fanno notare le cose che esistono, fanno udire rumori fasulli o ricordare cose che non sono mai accadute. Alcune illusioni creano immagini spettrali che chiunque può vedere, ma le illusioni più insidiose impiantano un’immagine direttamente nella mente di una creatura."),
	INVOCAZIONE("invocazione", "Riguarda incantesimi che manipolano l’energia magica per produrre un effetto desiderato. Alcuni creano esplosioni di fuoco o fulmini, altri incanalano l’energia positiva per curare le ferite."),
	NECROMANZIA("necromanzia", "Riguarda incantesimi che manipolano le energie della vita e della morte. Questi incantesimi possono conferire una riserva aggiuntiva di forza vitale, risucchiare l’energia vitale da un’altra creatura, creare non morti o addirittura riportare in vita i morti.\r\n"
			+ "Creare non morti tramite l’uso di incantesimi di necromanzia come animare morti non è un’azione buona, e solo gli incantatori malvagi fanno frequentemente uso di questo incantesimo."),
	TRASMUTAZIONE("trasmutazione", "Riguarda incantesimi che cambiano le proprietà di una creatura, oggetto o ambiente. Possono trasformare un nemico in una creatura innocua, aumentare la forza di un alleato, far spostare un oggetto agli ordini dell’incantatore o potenziare le capacità di guarigione innate di una creatura per farle recuperare più in fretta da una ferita.");
	
	private String nome;
	private String descrizione;
	
	ClassiIncantesimo(String nome, String descrizione){
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
    
    public static ClassiIncantesimo getEnumByNome(String tipo) {
        for (ClassiIncantesimo data : ClassiIncantesimo.values()) {
            if (data.getNome().equalsIgnoreCase(tipo)) {
                return data;
            }
        }
        throw new IllegalArgumentException("Nessun eqipaggiamento trovato con questo nome: " + tipo);
    }

}
