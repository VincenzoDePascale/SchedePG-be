package com.VincenzoDePascale.schedePG.list;

import java.util.HashMap;
import java.util.Map;

import com.fasterxml.jackson.annotation.JsonValue;

public enum Specializzazioni {
	
	CAMMINO_DEL_BERSERKER("cammino del berserker", "Per alcuni barbari, l’ira è un mezzo per raggiungere un fine – e quel fine è la violenza. Il Cammino del Berserker è un cammino di furia indiscriminata, grondante di sangue. Quando un barbaro entra nell'ira del berserker, si esalta nel caos della battaglia, ignorando la propria salute e la propria incolumità."),
	CAMMINO_DEL_COMBATTENTE_TOTEMICO("cammino del combattente totemico", "Il Percorso del Combattente Totemico è un viaggio spirituale, in cui il barbaro accetta uno spirito animale come guida, protettore e ispirazione. In battaglia, il tuo totem spirituale ti infonde di potenza soprannaturale, alimentando di magia la tua ira barbarica.\r\n"
			+ "È raro che un individuo abbia più di uno spirito animale totemico, ma esistono alcune eccezioni."),
	COLLEGIO_DELLA_SAPIENZA("collegio della sapienza", "I bardi del Collegio della Sapienza hanno conoscenze su qualsiasi argomento e raccolgono informazioni dalle fonti più disparate, che possono variare dai tomi accademici ai racconti dei contadini. Che si tratti di intonare ballate popolari da taverna o di poemi nelle corti reali, questi bardi usano sempre i loro doni per ammaliare il pubblico. Quando gli applausi si spengono, il pubblico si ritrova a dubitare di tutto ciò che fino ad allora aveva dato per certo, dalla sua fede nel sacerdozio locale alla sua lealtà al re. Questi bardi sono votati innanzitutto alla ricerca della bellezza e della verità, e non a un monarca o ai precetti di una divinità. Un nobile che tiene presso di sé un bardo del genere come araldo o consigliere farà bene a sapere che tale bardo tende a essere più onesto che diplomatico. I membri di questo collegio si radunano nelle biblioteche e a volte in alcuni collegi veri e propri, con tanto di aule e di dormitori, dove condividono liberamente le conoscenze recuperate. Si incontrano anche in occasione di feste popolari e ricevimenti di stato, dove possono denunciare casi di corruzione, smascherare bugie e farsi beffe dei più pomposi esponenti delle autorità."),
	COLLEGIO_DEL_VALORE("collagio del valore", ""),
	DOMINIO_DELLA_CONOSCENZA("dominio della conoscenza", ""),
	DOMINIO_DELLA_GUERRA("dominio della guerra", ""),
	DOMINIO_DEL_INGANNO("dominio dell'inganno", ""),
	DOMINIO_DELLA_LUCE("dominio della luce", ""),
	DOMINIO_DELLA_NATURA("dominio della natura", ""),
	DOMINIO_DELLA_TEMPESTA("dominio della tempesta", ""),
	DOMINIO_DELLA_VITA("dominio della vita", ""),
	CIRDOLO_DELLA_TERRA_ARTICO("circolo della terra (artico)", ""),
	CIRDOLO_DELLA_TERRA_COSTA("circolo della terra (costa)", ""),
	CIRDOLO_DELLA_TERRA_DESERTO("circolo della terra (deserto)", ""),
	CIRDOLO_DELLA_TERRA_FORESTA("circolo della terra (foresta)", ""),
	CIRDOLO_DELLA_TERRA_MONTAGNA("circolo della terra (montagna)", ""),
	CIRDOLO_DELLA_TERRA_PALUDE("circolo della terra (palude)", ""),
	CIRDOLO_DELLA_TERRA_PRATERIA("circolo della terra (prateria)", ""),
	CIRDOLO_DELLA_TERRA_UNDERDARK("circolo della terra (underdark)", ""),
	CIRCOLO_DELLA_LUNA("circolo della luce", ""),
	CAMPIONE("campione", ""),
	MAESTRO_DI_BATTAGLIA("maestro di battaglia", ""),
	CAVALIERE_MISTICO("cavaliere mistico", ""),
	FURFANTE("furfante", ""),
	ASSASSINO("assassino", ""),
	MISTIFICATORE_ARCANO("mistificatore arcano", ""),
	SCUOLA_DI_ABIURAZIONE("scuola di abiurazione", ""),
	SCUOLA_DI_AMMALIAMENTO("scuola di ammaliamento", ""),
	SCUOLA_DI_DIVINAZIONE("scuola di divinazione", ""),
	SCUOLA_DI_EVOCAZIONE("scuola di ecovazione", ""),
	SCUOLA_DI_ILLUSIONE("scuola di illusione", ""),
	SCUOLA_DI_INVOCAZIONE("scuola di invocazione", ""),
	SCUOLA_DI_NECROMANZIA("scuola di necromanzia", ""),
	SCUOLA_DI_TRASMUTAZIONE("scuola di trasmutazione", ""),
	VIA_DELLA_MANO_APERTA("via della mano aperta", ""),
	VIA_DELL_OMBRA("via dell'ombra", ""),
	VIA_DEI_QUATTRO_ELEMENTI("via dei quattro elementi", ""),
	GIURAMENTO_DI_DEVOZIONE("giuramento di devozione", ""),
	GIURAMENTO_DEGLI_ANTICHI("giuramento degli antichi", ""),
	GIURAMENTO_DI_VENDETTA("giuramento di vendetta", ""),
	CACCIATORE("cacciatore", ""),
	SIGNORE_DELLE_BESTIE("signore delle bestie", ""),
	DISCENDENZA_DRACONICA("discendenza draconica", ""),
	MAGIA_SELVAGGIA("magia selvaggia", ""),
	SIGNORE_FATATO("il signore fatato", ""),
	IMMONDO("l'immondo", ""),
	GRANDE_ANTICO("il grande antico", "");

	private String tipo;
	private String descrizione;

	Specializzazioni(String tipo, String descrizione){
		this.tipo = tipo;
		this.descrizione = descrizione;
	}

    public static Specializzazioni getEnumByTipo(String tipo) {
        for (Specializzazioni specializzazione : Specializzazioni.values()) {
            if (specializzazione.getTipo().equalsIgnoreCase(tipo)) {
                return specializzazione;
            }
        }
        throw new IllegalArgumentException("Nessuna specializzazione trovata per il tipo: " + tipo);
    }

	@JsonValue
    public Map<String, Object> getClassi() {
		 Map<String, Object> result = new HashMap<>();
		 result.put("specializzazione", tipo);
		 result.put("descrizione", descrizione);
	     
		 return result;
	}

	public String getTipo() {
		return tipo;
	}

	public String getDescrizione() {
		return descrizione;
	}

}
