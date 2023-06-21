package com.VincenzoDePascale.schedePG.list;

import java.util.HashMap;
import java.util.Map;

import com.fasterxml.jackson.annotation.JsonValue;

public enum PrivilegiSpeciali {
	
	//PRIVILEGIO_SPECIALE(Classi., Specializzazioni., liv, "nome", "descrizione");
	
	//BARBARO + CAMMINO_DEL_BERSERKER
	FRENESIA(Classi.BARBARO, Specializzazioni.CAMMINO_DEL_BERSERKER, 3, "Frenesia", "A partire da quando sceglie questo cammino al 3° livello, il barbaro può entrare in frenesia quando entra in ira. Se lo fa, per la durata della sua ira può effettuare un singolo attacco con un'arma da mischia come azione bonus in ognuno dei suoi turni successivi dopo di questo. Quando la sua ira termina, il barbaro subisce un livello di indebolimento."),
	IRA_INCONTENIBILE(Classi.BARBARO, Specializzazioni.CAMMINO_DEL_BERSERKER, 6, "ira incontenibile", "A partire dal 6° livello, il barbaro non può essere affascinato o spaventato mentre è in ira. Se è affascinato o spaventato quando entra in ira, quell'effetto è sospeso per tutta la durata dell'ira."),
	PRESENZA_INTIMIDATORIA(Classi.BARBARO, Specializzazioni.CAMMINO_DEL_BERSERKER, 10, "presenza intimidatoria", "A partire dal 10° livello, il barbaro può usare la sua azione per spaventare qualcuno con la sua presenza minacciosa. Quando lo fa, sceglie una creatura che egli sia in grado di vedere entro 9 metri. Se la creatura può vedere o sentire il barbaro, deve superare un TS di Saggezza (CD pari a 8 + il bonus di competenza del barbaro + il modificatore di Carisma del Barbaro), altrimenti sarà spaventata dal barbaro fino alla fine del turno successivo di quest'ultimo. Nei turni successivi, il barbaro può usare la sua azione per estendere la durata di questo effetto sulla creatura spaventata fino alla fine del proprio turno successivo. Questo effetto si esaurisce se la creatura termina il suo turno fuori dalla linea di vista o oltre 18 metri di distanza dal barbaro.\r\n"
			+ "Se la creatura riesce il suo tiro salvezza, il barbaro non può più usare questo privilegio su quella creatura per 24 ore."),
	RITORSIONE(Classi.BARBARO, Specializzazioni.CAMMINO_DEL_BERSERKER, 14, "ritorsione", "A partire dal 14° livello, quando il barbaro subisce danni da una creatura che si trova entro 1,5 metri da lui, può usare la sua reazione per effettuare un attacco con un'arma da mischia contro quella creatura."),
	
	//BARBARO + CAMMINO DEL COMBATTENTE TOTEMICO
	CERCATORE_DI_SPIRITI(Classi.BARBARO, Specializzazioni.CAMMINO_DEL_COMBATTENTE_TOTEMICO, 3, "cercatore di spiriti", "Il tuo percorso cerca una sintonia con il mondo animale, permettendoti di stringere un rapporto di fratellanza con le bestie. Al 3° livello, quando adotti questo percorso, ottieni l’abilità di eseguire gli incantesimi senso della bestia e amicizia con gli animali ma solo come rituali, come descritto nel capitolo 10 delle Regole Base"),
	SPIRITO_TOTEMICO(Classi.BARBARO, Specializzazioni.CAMMINO_DEL_COMBATTENTE_TOTEMICO, 3, "spirito totemico", "Al 3° livello, quando adotti questo percorso, scegli uno\r\n"
			+ "spirito totemico e ottieni un privilegio legato ad esso. Per farlo, devi creare o acquisire un oggetto totemico fisico – un amuleto o simile ornamento – che incorpori pelo o piume, artigli, denti o ossa dell’animale totemico. A tua discrezione, ottieni anche un attributo fisico minore reminiscente del tuo spirito totemico. Ad esempio, se il tuo spirito totemico è l’orso, potresti essere particolarmente peloso o avere la pelle spessa, se il tuo totem è l’aquila, i tuoi occhi potrebbero diventare di un giallo intenso. Il tuo animale totemico potrebbe essere collegato a quelli riportati di seguito, magari più appropriato al tuo territorio natio. Ad esempio, potresti scegliere un falco o un avvoltoio al posto dell’aquila.\r\n"
			+ "Alce. Mentre sei in ira e non stai indossando armature pesanti, la tua velocità di passeggio aumenta di 4,5 metri.\r\n"
			+ "Aquila. Mentre sei in ira, e non stai indossando un’armatura pesante, le altre creature hanno svantaggio ai tiri di attacco degli attacchi di opportunità contro di te, e inoltre puoi usare l’azione Scattare come azione bonus durante il tuo turno.\r\n"
			+ "Lupo. Mentre sei in ira, i tuoi amici hanno vantaggio ai tiri di attacco da mischia contro qualsiasi creatura entro 1,5 metri da te e che ti sia ostile.\r\n"
			+ "Orso. Mentre sei in ira, hai resistenza a tutti i danni salvo i danni psichici.\r\n"
			+ "Tigre. Mentre sei in ira, puoi aggiungere 3 metri alla tua distanza di salto in lungo e 90 centimetri alla tua distanza di salto in alto."),
	ASPETTI_DA_BESTIA(Classi.BARBARO, Specializzazioni.CAMMINO_DEL_COMBATTENTE_TOTEMICO, 6, "aspetti da bestia", "Al 6° livello, ottieni un beneficio magico basato sull’animale totemico di tua scelta. Puoi scegliere lo stesso animale che hai scelto al 3° livello od uno diverso.\r\n"
			+ "Alce. Che tu sia in sella o appiedato, e non sia inabile, la tua andatura di viaggio viene raddoppiata, così come quella di un massimo di dieci tuoi compagni che si trovino entro 18 metri da te.\r\n"
			+ "Aquila. Puoi vedere fino a 1,5 chilometri di distanza senza difficoltà, discernendo anche i dettagli più minuti, come se stessi osservando qualcosa non più lontano di 30 metri da te. Inoltre, la luce fioca non impone uno svantaggio alle tue prove di Saggezza (Percezione).\r\n"
			+ "Lupo. Puoi seguire le tracce di altre creature mentre viaggi ad andatura rapida, e ti puoi muovere furtivamente mentre viaggi ad andatura normale (vedi il capitolo 8 delle Regole Base per le regole sull’andatura di viaggio).\r\n"
			+ "Orso. La tua capacità di carico (compreso il carico massimo) è raddoppiata, e hai vantaggio alle prove di Forza effettuate per spingere, tirare, sollevare o spezzare oggetti.\r\n"
			+ "Tigre. Ottieni la competenza in due qualifiche scelte tra la lista seguente: Acrobazia, Atletica, Furtività e Sopravvivenza."),
	COMPAGNO_DEGLI_SPIRITI(Classi.BARBARO, Specializzazioni.CAMMINO_DEL_COMBATTENTE_TOTEMICO, 10, "compagno degli spiriti", "Al 10° livello, puoi eseguire l’incantesimo comunione con la natura, ma solo come rituale. Quando lo fai, una versione spirituale di uno degli animali scelti per Spirito Totemico o Aspetto della Bestia ti appare per comunicarti le informazioni che cerchi"),
	SINTONIA_TOTEMICA(Classi.BARBARO, Specializzazioni.CAMMINO_DEL_COMBATTENTE_TOTEMICO, 14, "sintonia totemica", "A partire dal 14° livello, ottieni un beneficio magico basato su di un animale totemico di tua scelta. Puoi scegliere lo stesso animale che hai scelto in precedenza od uno diverso.\r\n"
			+ "Alce. Mentre sei in ira, puoi usare un’azione bonus durante il tuo movimento per oltrepassare lo spazio di una creatura di taglia Grande o inferiore. La creatura deve riuscire un tiro salvezza di Forza (CD 8 + il tuo modificatore di Forza + il tuo bonus di competenza) o cadere prona e subire 1d12 + il tuo modificatore di Forza danni contundenti.\r\n"
			+ "Aquila. Mentre sei in ira, hai una velocità di volo pari alla tua attuale velocità di passeggio. Questo beneficio funziona solo per brevi scatti; se termini il tuo turno in aria, cadrai, se non hai nient’altro che ti tenga sollevato.\r\n"
			+ "Lupo. Mentre sei in ira, puoi usare un’azione bonus durante il tuo turno per gettare prona una creatura di taglia Grande o inferiore dopo che sei riuscita a colpirla con un attacco con arma da mischia.\r\n"
			+ "Orso. Mentre sei in ira, qualsiasi creatura entro 1,5 metri da te e che ti sia ostile ha svantaggio ai tiri di attacco contro i bersagli diversi da te o un altro personaggio con questo privilegio. Un nemico è immune a questo effetto se non può vederti o udirti o se non può essere spaventato.\r\n"
			+ "Tigre. Mentre sei in ira, se ti muovi di almeno 6 metri in linea retta verso un bersaglio di taglia Grande o inferiore subito prima di effettuare un attacco con arma da mischia contro di esso, puoi usare un’azione bonus per effettuare contri di esso un attacco con arma da mischia aggiuntivo"),
	
	//BARDO + COLLEGGIO DELLA SAPIENZA
	COMPETENZA_BONUS(Classi.BARDO, Specializzazioni.COLLEGIO_DELLA_SAPIENZA, 3, "competenze bonus", "Quando un bardo si unisce al Collegio della Sapienza al 3° livello, ottiene competenza in tre abilità a sua scelta."),
	PAROLE_TAGLIENTI(Classi.BARDO, Specializzazioni.COLLEGIO_DELLA_SAPIENZA, 3, "parole taglienti", "Sempre al 3° livello, il bardo impara anche a fare buon uso del suo ingegno per distrarre, confondere e fiaccare la determinazione e la competenza altrui. Quando una creatura situata entro 18 metri e che il bardo sia in grado di vedere effettua un tiro per colpire, una prova di caratteristica o un tiro per i danni, il bardo può usare la sua reazione per spendere uno dei suoi utilizzi di Ispirazione Bardica, tirare un dado di Ispirazione Bardica e sottrarre il numero ottenuto dal tiro della creatura. Può scegliere di utilizzare questo privilegio dopo che la creatura ha effettuato il suo tiro, ma prima che il DM dichiari se il tiro per colpire o la prova di caratteristica abbia avuto successo o meno, o prima che la creatura infligga i danni. La creatura è immune se non è in grado di sentire il bardo o se non può essere affascinata."),
	SEGRETI_MAGICI_AGGIUNTIVI(Classi.BARDO, Specializzazioni.COLLEGIO_DELLA_SAPIENZA, 6, "segreti magici aggiuntivi", "Al 6° livello, un bardo impara due incantesimi a sua scelta da qualsiasi classe. Ogni incantesimo scelto deve essere di un livello che il bardo sia in grado di lanciare, come indicato dalla tabella, oppure deve essere un trucchetto. Gli incantesimi scelti contano come incantesimi da bardo, ma non contano al fine di determinare il numero di incantesimi da bardo conosciuti."),
	ABILITA_IMPAREGGIABILE(Classi.BARDO, Specializzazioni.COLLEGIO_DELLA_SAPIENZA, 14, "abilità impareggiabile", "A partire dal 14° livello, quando un bardo effettua una prova di caratteristica, può spendere un utilizzo di Ispirazione Bardica. Se lo fa, tira un dado di Ispirazione Bardica e aggiunge il risultato ottenuto alla sua prova di caratteristica. Può scegliere di farlo dopo avere tirato il dado per la prova di caratteristica, ma prima che il DM dichiari se la prova abbia avuto successo o meno."),
	
	//BARDO + COLLEGGIO DEL VALORE
	
	
	//PUNTO
	PRIVILEGIO(Classi.BARDO, Specializzazioni.COLLEGIO_DELLA_SAPIENZA, 0, "", "");
	
	private Classi classe;
	private Specializzazioni specializzazione;
	private int livello;
	private String nome;
	private String descrizione;
	
	private PrivilegiSpeciali(Classi classe, Specializzazioni specializzazione, int livello, String nome, String descrizione) {
		this.classe = classe;
		this.specializzazione = specializzazione;
		this.livello = livello;
		this.nome = nome;
		this.descrizione = descrizione;
	}

    @JsonValue
    public Map<String, Object> getEquipaggiamento() {
        Map<String, Object> result = new HashMap<>();
        result.put("classe", classe);
        result.put("specializzazione", specializzazione);
        result.put("livello", livello);
        result.put("nome", nome);
        result.put("descrizione", descrizione);
        return result;
    }

	public Classi getClasse() {
		return classe;
	}

	public Specializzazioni getSpecializzazione() {
		return specializzazione;
	}

	public int getLivello() {
		return livello;
	}

	public String getNome() {
		return nome;
	}

	public String getDescrizione() {
		return descrizione;
	}

}
