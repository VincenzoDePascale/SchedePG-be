package com.VincenzoDePascale.schedePG.list;

import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonValue;

@JsonFormat(shape = JsonFormat.Shape.OBJECT)
public enum Incantesimi {
	
	//esempio
	//INCANTESIMO(/*nome*/"nome", /*classe incantesimo*/ClassiIncantesimo.AMMALIAMENTO, /*classi pg compatibili*/Arrays.asList(Classi.BARDO), /*livello*/0, /*tempo di lancio*/"tempo di lancio", /*gittata*/"gittata", /*componente verbale*/false, /*componente somatica*/true, /*componente materiale*/"componente materiale", /*durata*/"durata", /*tiro salvezza*/null, /*rituale*/false, /*concentrazione*/false, /*descrizione*/"descrizione" );
	
	//trucchetti
	BEFFA_CRUDELE("beffa crudele", ClassiIncantesimo.AMMALIAMENTO, Arrays.asList(Classi.BARDO), 0, "1 azione", "18 metri", true, false, "", "istantanea", null, false, false, "L'incantatore pronuncia una sequenza di insulti mescolati a sottili ammaliamenti contro una creatura entro gittata e che egli sia in grado di vedere. Se il bersaglio è in grado di sentirlo (non è necessario che lo capisca), deve superare un tiro salvezza su Saggezza, altrimenti subisce 1d4 danni psichici e svantaggio al tiro per colpire successivo che effettua prima della fine del suo turno successivo.\r\n"
			+ "I danni di questo incantesimo aumentano di 1d4 quando l'incantatore arriva al 5° livello (2d4), 11° livello (3d4) e 17° livello (4d4)." );
	
	
	private String nome;
	//private TipiMagia tipoMagia;
	private ClassiIncantesimo classeIncantesimo;
	private List<Classi> classiPG;
	private int livello;
	private String tempoDiLancio;
	private String gittata;
	private boolean componenteVerbale;
	private boolean componenteSomatica;
	private String componenteMateriale;
	private String durata;
	private Statistiche tiroSalvezza;
	private boolean rituale;
	private boolean concentrazione;
	private String descrizione;

	Incantesimi(String nome, ClassiIncantesimo classeIncantesimo, List<Classi> classiPG, int livello,
			String tempoDiLancio, String gittata,
			boolean componenteVerbale, boolean componenteSomatica,
			String componenteMateriale,
			String durata, Statistiche tiroSalvezza, boolean rituale,
			boolean concentrazione, String descrizione){
		this.nome = nome;
		this.classeIncantesimo = classeIncantesimo;
		this.classiPG = classiPG;
		this.livello = livello;
		this.tempoDiLancio = tempoDiLancio;
		this.gittata = gittata;
		this.componenteVerbale = componenteVerbale;
		this.componenteSomatica = componenteSomatica;
		this.componenteMateriale = componenteMateriale;
		this.durata = durata;
		this.tiroSalvezza = tiroSalvezza;
		this.rituale = rituale;
		this.concentrazione = concentrazione;
		this.descrizione = descrizione;
	}
	
	public String getNome() {
		return nome;
	}

	public ClassiIncantesimo getClasseIncantesimo() {
		return classeIncantesimo;
	}

	public List<Classi> getClassiPG() {
		return classiPG;
	}

	public int getLivello() {
		return livello;
	}

	public String getTempoDiLancio() {
		return tempoDiLancio;
	}

	public String getGittata() {
		return gittata;
	}

	public boolean isComponenteVerbale() {
		return componenteVerbale;
	}

	public boolean isComponenteSomatica() {
		return componenteSomatica;
	}

	public String getComponenteMateriale() {
		return componenteMateriale;
	}

	public String getDurata() {
		return durata;
	}

	public Statistiche getTiroSalvezza() {
		return tiroSalvezza;
	}

	public boolean isRituale() {
		return rituale;
	}

	public boolean isConcentrazione() {
		return concentrazione;
	}

	public String getDescrizione() {
		return descrizione;
	}

	@JsonValue
    public Map<String, Object> getEquipaggiamento() {
        Map<String, Object> result = new HashMap<>();
        result.put("nome", nome);
        result.put("classeIncantesimo", classeIncantesimo);
        result.put("classiPG", classiPG);
        result.put("livello", livello);
        result.put("tempoDiLancio", tempoDiLancio);
        result.put("gittata", gittata);
        result.put("componenteVerbale", componenteVerbale);
        result.put("componenteSomatica", componenteSomatica);
        result.put("componenteMateriale", componenteMateriale);
        result.put("durata", durata);
        result.put("tiroSalvezza", tiroSalvezza);
        result.put("rituale", rituale);
        result.put("concentrazione", concentrazione);
        result.put("descrizione", descrizione);
        return result;
    }
	
	public static Incantesimi getEnumByNome(String tipo) {
        for (Incantesimi data : Incantesimi.values()) {
            if (data.getNome().equalsIgnoreCase(tipo)) {
                return data;
            }
        }
        throw new IllegalArgumentException("Nessun eqipaggiamento trovato con questo nome: " + tipo);
    }

}
