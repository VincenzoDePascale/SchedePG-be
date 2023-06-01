package com.VincenzoDePascale.schedePG.list;

import java.util.HashMap;
import java.util.Map;

import com.fasterxml.jackson.annotation.JsonValue;

public enum Armature {

	IMBOTTITA("armatura imbottita", TipiEquip.ARMATURA_LEGGERA,
			"Un'armatura imbottita è costituita da vari strati trapuntati di stoffa e imbottitura.", 5, Moneta.MO, 11,
			true, 4),
	CUOIO("armatura cuoio", TipiEquip.ARMATURA_LEGGERA,
			"Il pettorale e le spalline che compongono questa armatura sono fatti di cuoio indurito e bollito nell'olio. Il resto dell'armatura è fatto di materiali più morbidi e flessibili.",
			10, Moneta.MO, 11, false, 5),
	CUOIO_BORCHIATO("cuoio borchiato", TipiEquip.ARMATURA_LEGGERA,
			"Un'armatura di cuoio borchiato è fatta di cuoio resistente ma flessibile, rinforzato con borchie o spuntoni di metallo.",
			45, Moneta.MO, 12, false, 6.5),

	PELLE("armatura di pelle", TipiEquip.ARMATURA_MEDIA,
			"Questa rozza armatura è composta da un fitto strato di pelle o pelliccia. Solitamente è indossata dai membri delle tribù barbariche, umanoidi malvagi e altri individui che non possono accedere agli strumenti e ai materiali necessari per fabbricare armature migliori.",
			10, Moneta.MO, 12, false, 6.5),
	GIACO_DI_MAGLIA("giaco di maglia", TipiEquip.ARMATURA_MEDIA,
			"Un giaco di maglia, composto da anelli di metallo interconnessi, si indossa tra due strati di stoffa o di cuoio. Questa armatura offre una minima protezione alla parte superiore del corpo e smorza il rumore degli anelli di metallo soffocandolo tra i due strati esterni.",
			50, Moneta.MO, 13, false, 10),
	CORAZZA_DI_SCAGLIE("corazza di scaglie", TipiEquip.ARMATURA_MEDIA,
			"Questa armatura è composta da un corpetto e da gambali (e forse da una gonna separata) di cuoio ed è ricoperta di pezzi di metallo leggermente sovrapposti, proprio come le scaglie di un pesce. Include anche due guanti d'arme.",
			50, Moneta.MO, 14, true, 22.5),
	CORAZZA_DI_PIASTRE("corazza di piastre", TipiEquip.ARMATURA_MEDIA,
			"Questa armatura è composta da un pettorale di metallo montato su uno strato di cuoio flessibile. Anche se lascia le gambe e le braccia relativamente scoperte, fornisce una buona protezione degli organi vitali del portatore, lasciandolo anche relativamente privo di ingombro.",
			400, Moneta.MO, 14, false, 10),
	MEZZA_ARMATURA("mezza armatura", TipiEquip.ARMATURA_MEDIA,
			"Una mezza armatura è composta da una serie di piastre di metallo modellate che coprono la maggior parte del corpo. Non include una protezione per le gambe, al di là di due semplici gambiere fissate da alcune cinghie di cuoio.",
			750, Moneta.MO, 15, true, 20),

	CORAZZA_AD_ANELLI("corazza ad anelli", TipiEquip.ARMATURA_PESANTE,
			"E' un'armatura di cuoio su cui sono stati cuciti dei pesanti anelli di metallo. Gli anelli rinforzano l'armatura contro i colpi di spada e ascia. Una corazza ad anelli è inferiore a una cotta di maglia e solitamente è indossata soltanto da coloro che non possono permettersi un'armatura migliore.",
			30, Moneta.MO, 14, true, 20),
	COTTA_DI_MAGLIA("cotta di maglia", TipiEquip.ARMATURA_PESANTE,
			"Una cotta di maglia, composta da anelli di metallo interconnessi, include uno strato di tessuto trapuntato da indossare sotto la cotta per evitare l'attrito e per attutire l'impatto dei colpi. Questa armatura include anche dei guanti d'arme. Questa armatura riduce la velocità del portatore di 3 metri, a meno che il portatore non possieda un punteggio di Forza pari o superiore a 13.",
			75, Moneta.MO, 16, true, 27.5),
	CORAZZA_A_STRISCE("corazza a strisce", TipiEquip.ARMATURA_PESANTE,
			"Questa armatura è fatta di strette strisce verticali di metallo imbullonate su uno strato di cuoio da indossare su un'imbottitura di stoffa. Le giunture sono protette da uno strato flessibile di anelli di maglia. Questa armatura riduce la velocità del portatore di 3 metri, a meno che il portatore non possieda un punteggio di Forza pari o superiore a 15.",
			200, Moneta.MO, 17, true, 30),
	ARMATURA_COMPLETA("armatura completa", TipiEquip.ARMATURA_PESANTE,
			"Un'armatura completa è composta da piastre di metallo modellate e interconnesse che coprono tutto il corpo. Un'armatura completa include guanti d'arme, pesanti stivali di cuoio, un elmo con visiera e uno spesso strato di imbottitura sotto l'armatura. Una serie di fibbie e di cinghie consente di distribuire il peso su tutto il corpo. Questa armatura riduce la velocità del portatore di 3 metri, a meno che il portatore non possieda un punteggio di Forza pari o superiore a 15.",
			1500, Moneta.MO, 18, true, 32.5);

	private String nome;
	private TipiEquip tipo;
	private String descrizione;
	private int costo;
	private Moneta moneta;
	private int classeArmatura;
	private boolean furtivita;
	private double peso;

	private Armature(String nome, TipiEquip tipo, String descrizione, int costo, Moneta moneta, int classeArmatura,
			boolean furtivita, double peso) {
		this.nome = nome;
		this.tipo = tipo;
		this.descrizione = descrizione;
		this.costo = costo;
		this.moneta = moneta;
		this.classeArmatura = classeArmatura;
		this.furtivita = furtivita;
		this.peso = peso;
	}

	public String getNome() {
		return nome;
	}

	public TipiEquip getTipo() {
		return tipo;
	}

	public String getDescrizione() {
		return descrizione;
	}

	public int getCosto() {
		return costo;
	}

	public Moneta getMoneta() {
		return moneta;
	}

	public int getClasseArmatura() {
		return classeArmatura;
	}

	public boolean isFurtività() {
		return furtivita;
	}

	public double getPeso() {
		return peso;
	}

	@JsonValue
	public Map<String, Object> getEquipaggiamento() {
		Map<String, Object> result = new HashMap<>();
		result.put("nome", nome);
		result.put("tipo", tipo);
		result.put("descrizione", descrizione);
		result.put("costo", costo);
		result.put("moneta", moneta);
		result.put("classeArmatura", classeArmatura);
		result.put("furtivita", furtivita);
		result.put("peso", peso);
		return result;
	}
	
	public static Armature getEnumByNome(String nome) {
        for (Armature data : Armature.values()) {
            if (data.getNome().equalsIgnoreCase(nome)) {
                return data;
            }
        }
        throw new IllegalArgumentException("Nessuna armatura con questo nome: " + nome);
    }
	
}
