package com.VincenzoDePascale.schedePG.model;

import java.util.ArrayList;
import java.util.List;

import com.VincenzoDePascale.schedePG.auth.entity.User;
import com.VincenzoDePascale.schedePG.list.Abilita;
import com.VincenzoDePascale.schedePG.list.Allineamenti;
import com.VincenzoDePascale.schedePG.list.Armature;
import com.VincenzoDePascale.schedePG.list.Armi;
import com.VincenzoDePascale.schedePG.list.Classi;
import com.VincenzoDePascale.schedePG.list.Dadi;
import com.VincenzoDePascale.schedePG.list.Equipaggiamento;
import com.VincenzoDePascale.schedePG.list.Linguaggi;
import com.VincenzoDePascale.schedePG.list.Privilegi;
import com.VincenzoDePascale.schedePG.list.Razze;
import com.VincenzoDePascale.schedePG.list.Scudi;
import com.VincenzoDePascale.schedePG.list.Statistiche;
import com.VincenzoDePascale.schedePG.list.TipiEquip;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.ElementCollection;
import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table(name = "pg")
@NoArgsConstructor
@AllArgsConstructor
@Data
@Builder
public class Pg {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;

	@ManyToOne(optional = false, cascade = CascadeType.MERGE)
	@JoinColumn(name = "giocatore_id", referencedColumnName = "id")
	@JsonIgnoreProperties({ "personaggi" })
	private User giocatore;

	// INFO GENERALI-----------------------------------------

	@Column
	private String nomePG;

	@Column
	@Enumerated(EnumType.STRING)
	private Razze razza;

	@Column
	@Enumerated(EnumType.STRING)
	private Classi classe;

	@Column
	@Enumerated(EnumType.STRING)
	private Allineamenti allineamento;

	@Column(nullable = false)
	private Integer livello;

	// da settare con un enum, in base a razza e classe
	@Column
	private String background;

	@Column(nullable = false)
	private Integer puntiExp;

	// STATISTICHE DI BASE

	@Column(nullable = false)
	private int forza;
	@Column(nullable = false)
	private int destrezza;
	@Column(nullable = false)
	private int costituzione;
	@Column(nullable = false)
	private int intelligenza;
	@Column(nullable = false)
	private int saggezza;
	@Column(nullable = false)
	private int carisma;
	
	@Column
	private List<Statistiche> TSattivi;
	
	@Column
	@ElementCollection(targetClass = String.class)
	private List<String> abilitaAttive;
	
	@Column
	@Enumerated(EnumType.STRING)
	private List<TipiEquip> competenze;
	
	@Column
	@Enumerated(EnumType.STRING)
	private List<Privilegi> privilegi;

	// ABILITÀ--------------------------------------------------------

	@Column(nullable = false)
	private Boolean ispizazione;

	@Column
	private Integer bonusCompetenza;

	@Column
	private List<Linguaggi> linguaggi;

	@Builder.Default
	@Column(nullable = false)
	private Integer iniziativa = 0;

	@Builder.Default
	@Column(nullable = false)
	private double velocita = 0;

	@Column(nullable = false)
	private Integer PF_max;

	@Builder.Default
	@Column(nullable = false)
	private Integer PF = 0;

	@Builder.Default
	@Column
	private Integer PF_temporanei = 0;

	@Enumerated(EnumType.STRING)
	@Column(nullable = false)
	private Dadi dado_vita;

	@Column(nullable = false)
	private Integer dado_vita_num;

	@Column(nullable = false)
	private Integer TS_morte;

	// EQUIPAGGIAMENTO----------------------------------

	@Enumerated(EnumType.STRING)
	@Column
	private List<Equipaggiamento> equipaggiamentoBase;

	@Enumerated(EnumType.STRING)
	@Column
	private Armature armatura;
	
	@Enumerated(EnumType.STRING)
	@Column
	private Scudi scudo;

	@Enumerated(EnumType.STRING)
	@Column
	private List<Armi> armi;

	@Column
	private Integer monete_rame;

	@Column
	private Integer monete_argento;

	@Column
	private Integer monete_oro;

	@Column
	private Integer monete_platino;

	// TRATTI PERSONALI

	@Column
	private String tratti_caratteriali;

	@Column
	private String ideali;

	@Column
	private String legami;

	@Column
	private String difetti;

	// INCANTESIMI CHE NON CI SONO
	// ---------------------------------------------------------------------------------
	// FUNZIONI DI CALCOLO DATI PRIMA DI ESSERE SALVATI NEL DB

	// COSTRUTTORI

	// costruttore SENZA ID
	public Pg(User giocatore, String nomePG, Razze razza, Classi classe, Allineamenti allineamento, Integer livello,
			String background, Integer puntiExp, int forza, int destrezza, int costituzione, int intelligenza,
			int saggezza, int carisma, List<Statistiche> TSattivi, List<String> abilitaAttive, List<TipiEquip> competenze, List<Privilegi> privilegi, Boolean ispizazione, Integer bonusCompetenza, List<Linguaggi> linguaggi,
			Integer iniziativa, double velocita, Integer pF_max, Integer pF, Integer pF_temporanei, Dadi dado_vita,
			Integer dado_vita_num, Integer tS_morte, List<Equipaggiamento> equipaggiamentoBase, Armature armatura,
			Scudi scudo, List<Armi> armi, Integer monete_rame, Integer monete_argento, Integer monete_oro,
			Integer monete_platino, String tratti_caratteriali, String ideali, String legami, String difetti) {
		super();
		this.giocatore = giocatore;
		this.nomePG = nomePG;
		this.razza = razza;
		this.classe = classe;
		this.allineamento = allineamento;
		this.livello = livello;
		this.background = background;
		this.puntiExp = puntiExp;
		this.forza = forza;
		this.destrezza = destrezza;
		this.costituzione = costituzione;
		this.intelligenza = intelligenza;
		this.saggezza = saggezza;
		this.carisma = carisma;
		this.TSattivi = TSattivi;
		this.abilitaAttive = abilitaAttive;
		this.competenze = competenze;
		this.privilegi = privilegi;
		this.ispizazione = ispizazione;
		this.bonusCompetenza = bonusCompetenza;
		this.linguaggi = linguaggi;
		this.iniziativa = iniziativa;
		this.velocita = velocita;
		this.PF_max = pF_max;
		this.PF = pF;
		this.PF_temporanei = pF_temporanei;
		this.dado_vita = dado_vita;
		this.dado_vita_num = dado_vita_num;
		this.TS_morte = tS_morte;
		this.equipaggiamentoBase = equipaggiamentoBase;
		this.armatura = armatura;
		this.scudo = scudo;
		this.armi = armi;
		this.monete_rame = monete_rame;
		this.monete_argento = monete_argento;
		this.monete_oro = monete_oro;
		this.monete_platino = monete_platino;
		this.tratti_caratteriali = tratti_caratteriali;
		this.ideali = ideali;
		this.legami = legami;
		this.difetti = difetti;
	}

	// costruttori con calcoli interni
	public Pg(User giocatore, String nomePG, Allineamenti allineamento, int forza, int destrezza, int costituzione,
			int intelligenza, int saggezza, int carisma, Razze razza, Classi classe, List<String> abilitaAttive, int livello, String background,
			String tratti_caratteriali, String ideali, String legami, String difetti) {
		super();

		Razze rz = razza;
		Classi cl = classe;

		int statFor = forza;
		int statDes = destrezza;
		int statCos = costituzione;
		int statInt = intelligenza;
		int statSag = saggezza;
		int statCar = carisma;

		List<Linguaggi> listaLinguaggi = new ArrayList<>();
		listaLinguaggi.add(Linguaggi.COMUNE);

		switch (rz) {
		case ELFO:
			this.velocita = 9;
			statDes += 2;
			listaLinguaggi.add(Linguaggi.ELFICO);
			break;
		case HALFLING:
			this.velocita = 7.5;
			statDes += 2;
			listaLinguaggi.add(Linguaggi.HALFLING);
			break;
		case NANO:
			this.velocita = 7.5;
			statCos += 2;
			listaLinguaggi.add(Linguaggi.NANICO);
			break;
		case UMANO:
			this.velocita = 9;
			statFor += 1;
			statDes += 1;
			statCos += 1;
			statInt += 1;
			statSag += 1;
			statCar += 1;
			break;
		case DRACONIDE:
			this.velocita = 9;
			statFor += 2;
			statCar += 1;
			listaLinguaggi.add(Linguaggi.DRACONICO);
			break;
		case GNOMO:
			this.velocita = 7.5;
			statInt += 2;
			listaLinguaggi.add(Linguaggi.GNOMESCO);
			break;
		case MEZZELFO:
			this.velocita = 9;
			statCar += 2;
			// altri due aumentano di 1 a scelta del giocatore
			listaLinguaggi.add(Linguaggi.ELFICO);
			// listaLinguaggi.add(un altro a scelta);
			break;
		case MEZZORCO:
			this.velocita = 9;
			statFor += 2;
			statCos += 1;
			listaLinguaggi.add(Linguaggi.ORCHESCO);
			break;
		case TIEFLING:
			this.velocita = 9;
			statInt += 1;
			statCar += 2;
			listaLinguaggi.add(Linguaggi.INFERNALE);
			break;
		default:
			break;
		}

		int liv = livello;
		List<Statistiche> listTSattivi = new ArrayList<>();
		List<Equipaggiamento> equip = new ArrayList<>();
		List<Armi> listArmi = new ArrayList<>();
		List<TipiEquip> listaCompetenze = new ArrayList<>();
		int vitaMassima = 0;

		switch (cl) {
		case BARBARO:
			this.dado_vita = Dadi.D12;
			
//			if (liv == 1) {
//			    vitaMassima = Dadi.D12.getValore() + ((int) Math.floor((statCos - 10) / 2.0));
//			} else {
//			    int sum = Dadi.D12.getValore() + ((int) Math.floor((statCos - 10) / 2.0));
//			    for (int i = 1; i < liv; i++) {
//			        sum += (Dadi.rollDice(Dadi.D12) / 2 + 1) + ((int) Math.floor((statCos - 10) / 2.0));
//			    }
//			    vitaMassima = sum;
//			}
			
			if (liv == 1) {
			    vitaMassima = Dadi.D12.getValore() + statCos;
			} else {
			    int sum = Dadi.D12.getValore() + statCos;
			    for (int i = 1; i < liv; i++) {
			        sum += (Dadi.D12.getValore() / 2 + 1) + statCos;
			    }
			    vitaMassima = sum;
			}
			
			//un'ascia bipenne o qualsiasi arma da guerra da mischia
			listArmi.add(Armi.ASCIA_BIPENNE);
			//due asce o una qualsiasi arma semplice
			listArmi.add(Armi.ASCIA);
			listArmi.add(Armi.ASCIA);
			//Una dotazione da esploratore e quattro giavellotti
			equip.add(Equipaggiamento.ZAINO);
			equip.add(Equipaggiamento.GIACIGLIO);
			equip.add(Equipaggiamento.GAVETTA);
			equip.add(Equipaggiamento.ACCIARINO_E_PIETRA_FOCAIA);
			equip.add(Equipaggiamento.CORDA_DI_CANAPA);
			for(int i = 0; i<10; i++) {
				equip.add(Equipaggiamento.TORCIA);
				equip.add(Equipaggiamento.RAZIONE);
			}
			equip.add(Equipaggiamento.OTRE);
			
			for(int i = 0; i<4; i++) {
				listArmi.add(Armi.GIAVELLOTTO);
			}
			this.scudo = null;
			//tiri salvezza
			listTSattivi.add(Statistiche.FORZA);
			listTSattivi.add(Statistiche.COSTITUZIONE);
			//competenze
			listaCompetenze.add(TipiEquip.ARMATURA_LEGGERA);
			listaCompetenze.add(TipiEquip.ARMATURA_MEDIA);
			listaCompetenze.add(TipiEquip.SCUDO);
			listaCompetenze.add(TipiEquip.ARMA_DA_MISCHIA_SEMPLICE);
			listaCompetenze.add(TipiEquip.ARMA_A_DISTANZA_SEMPLICE);
			listaCompetenze.add(TipiEquip.ARMA_DA_MISCHIA_DA_GUERRA);
			listaCompetenze.add(TipiEquip.ARMA_A_DISTANZA_DA_GUERRA);
			break;
		case BARDO:
			this.dado_vita = Dadi.D8;
			
			if (liv == 1) {
			    vitaMassima = Dadi.D8.getValore() + statCos;
			} else {
			    int sum = Dadi.D8.getValore() + statCos;
			    for (int i = 1; i < liv; i++) {
			        sum += (Dadi.D8.getValore() / 2 + 1) + statCos;
			    }
			    vitaMassima = sum;
			}
			//uno stocco, una spada lunga o una qualsiasi arma semplice
			listArmi.add(Armi.STOCCO);
			//una dotazione da diplomatico o una dotazione da intrattenitore [diplomatico]
			equip.add(Equipaggiamento.FORZIERE);
			for(int i = 0; i<2; i++) {
				equip.add(Equipaggiamento.CUSTODIA_PER_MAPPE_O_PERGAMENE);
				equip.add(Equipaggiamento.AMPOLLA);
			}
			for(int i = 0; i<5; i++) {
				equip.add(Equipaggiamento.CARTA);
			}
			equip.add(Equipaggiamento.ABITO_PR);
			equip.add(Equipaggiamento.INCHIOSTRO);
			equip.add(Equipaggiamento.PENNINO);
			equip.add(Equipaggiamento.LAMPADA);
			equip.add(Equipaggiamento.PROFUMO);
			equip.add(Equipaggiamento.CERA_PER_SIGILLO);
			equip.add(Equipaggiamento.SAPONE);

			//un liuto o (b) un qualsiasi altro strumento musicale [ora solo liuto]
			equip.add(Equipaggiamento.LIUTO);
			
			//Un'armatura di cuoio e un pugnale
			this.armatura= Armature.CUOIO;
			listArmi.add(Armi.PUGNALE);
			this.scudo = null;

			//tiri salvezza
			listTSattivi.add(Statistiche.DESTREZZA);
			listTSattivi.add(Statistiche.CARISMA);
			//competenze
			listaCompetenze.add(TipiEquip.ARMATURA_LEGGERA);
			listaCompetenze.add(TipiEquip.ARMA_DA_MISCHIA_SEMPLICE);
			listaCompetenze.add(TipiEquip.BALESTRA_A_MANO);
			listaCompetenze.add(TipiEquip.SPADA_CORTA);
			listaCompetenze.add(TipiEquip.SPADA_LUNGA);
			listaCompetenze.add(TipiEquip.STOCCO);
			break;
		case CHIERICO:
			this.dado_vita = Dadi.D8;
			
			if (liv == 1) {
			    vitaMassima = Dadi.D8.getValore() + statCos;
			} else {
			    int sum = Dadi.D8.getValore() + statCos;
			    for (int i = 1; i < liv; i++) {
			        sum += (Dadi.D8.getValore() / 2 + 1) + statCos;
			    }
			    vitaMassima = sum;
			}
			//una mazza o un martello da guerra (se ha competenza)
			listArmi.add(Armi.MAZZA);
			//una corazza di scaglie, (b) un'armatura di cuoio o (c) una cotta di maglia (Se ha competenza)
			this.armatura= Armature.CORAZZA_DI_SCAGLIE;
			
			//una balestra leggera e 20 quadrelli o una qualsiasi arma semplice
			listArmi.add(Armi.BALESTRA_LEGGERA);
			//una dotazione da sacerdote o (b) una dotazione da esploratore [ora solo sacerdote]
			equip.add(Equipaggiamento.ZAINO);
			equip.add(Equipaggiamento.COPERTA);
			for(int i = 0; i<10; i++) {
				equip.add(Equipaggiamento.CANDELA);
			}
			equip.add(Equipaggiamento.ACCIARINO_E_PIETRA_FOCAIA);
			equip.add(Equipaggiamento.CASSETTA_PER_LE_OFFERTE);
			for(int i = 0; i<2; i++) {
				equip.add(Equipaggiamento.INCENSO);
			}
			equip.add(Equipaggiamento.INCENSIERE);
			equip.add(Equipaggiamento.VESTE);
			for(int i = 0; i<10; i++) {
				equip.add(Equipaggiamento.RAZIONE);
			}
			equip.add(Equipaggiamento.OTRE);
			
			//Uno scudo e un simbolo sacro
			equip.add(Equipaggiamento.EMBLEMA);
			this.scudo = Scudi.SCUDO;
			//tiri salvezza
			listTSattivi.add(Statistiche.SAGGEZZA);
			listTSattivi.add(Statistiche.CARISMA);
			//competenze
			listaCompetenze.add(TipiEquip.ARMATURA_LEGGERA);
			listaCompetenze.add(TipiEquip.ARMATURA_MEDIA);
			listaCompetenze.add(TipiEquip.SCUDO);
			listaCompetenze.add(TipiEquip.ARMA_DA_MISCHIA_SEMPLICE);
			break;
		case DRUIDO:
			this.dado_vita = Dadi.D8;
			
			if (liv == 1) {
			    vitaMassima = Dadi.D8.getValore() + statCos;
			} else {
			    int sum = Dadi.D8.getValore() + statCos;
			    for (int i = 1; i < liv; i++) {
			        sum += (Dadi.D8.getValore() / 2 + 1) + statCos;
			    }
			    vitaMassima = sum;
			}
			// uno scudo di legno o una qualsiasi arma semplice.
			this.scudo = Scudi.SCUDO;
			//una scimitarra o una qualsiasi arma semplice da mischia.
			listArmi.add(Armi.SCIMITARRA);
			//Un'armatura di cuoio
			this.armatura= Armature.CUOIO;
			//una dotazione da esploratore
			equip.add(Equipaggiamento.ZAINO);
			equip.add(Equipaggiamento.GIACIGLIO);
			equip.add(Equipaggiamento.GAVETTA);
			equip.add(Equipaggiamento.ACCIARINO_E_PIETRA_FOCAIA);
			equip.add(Equipaggiamento.CORDA_DI_CANAPA);
			for(int i = 0; i<10; i++) {
				equip.add(Equipaggiamento.TORCIA);
				equip.add(Equipaggiamento.RAZIONE);
			}
			equip.add(Equipaggiamento.OTRE);
			//un focus druidico
			equip.add(Equipaggiamento.TOTEM);
			//tiri salvezza
			listTSattivi.add(Statistiche.INTELLIGENZA);
			listTSattivi.add(Statistiche.SAGGEZZA);
			//competenze
			listaCompetenze.add(TipiEquip.ARMATURA_LEGGERA);
			listaCompetenze.add(TipiEquip.ARMATURA_MEDIA);
			listaCompetenze.add(TipiEquip.SCUDO);
			listaCompetenze.add(TipiEquip.BASTONE_FERRATO);
			listaCompetenze.add(TipiEquip.DARDO);
			listaCompetenze.add(TipiEquip.FALCETTO);
			listaCompetenze.add(TipiEquip.GIAVELLOTTO);
			listaCompetenze.add(TipiEquip.LANCIA);
			listaCompetenze.add(TipiEquip.MAZZA);
			listaCompetenze.add(TipiEquip.PUGNALE);
			listaCompetenze.add(TipiEquip.RANDELLO);
			listaCompetenze.add(TipiEquip.SCIMITARRA);
			listaCompetenze.add(TipiEquip.FIONDA);
			break;
		case GUERRIERO:
			this.dado_vita = Dadi.D10;
			
			if (liv == 1) {
			    vitaMassima = Dadi.D10.getValore() + statCos;
			} else {
			    int sum = Dadi.D10.getValore() + statCos;
			    for (int i = 1; i < liv; i++) {
			        sum += (Dadi.D10.getValore() / 2 + 1) + statCos;
			    }
			    vitaMassima = sum;
			}
			//cotta di maglia o (b) armatura di cuoio, arco lungo e 20 frecce
			this.armatura= Armature.COTTA_DI_MAGLIA;
			//un’arma da guerra e uno scudo o (b) due armi da guerra
			listArmi.add(Armi.SPADONE);
			this.scudo = Scudi.SCUDO;
			//una balestra leggera e 20 quadrelli o (b) due asce
			listArmi.add(Armi.BALESTRA_LEGGERA);
			//uno zaino da speleologo o (b) uno zaino da esploratore
			//tiri salvezza
			listTSattivi.add(Statistiche.FORZA);
			listTSattivi.add(Statistiche.COSTITUZIONE);
			//competenze
			listaCompetenze.add(TipiEquip.ARMATURA_LEGGERA);
			listaCompetenze.add(TipiEquip.ARMATURA_MEDIA);
			listaCompetenze.add(TipiEquip.ARMATURA_PESANTE);
			listaCompetenze.add(TipiEquip.SCUDO);
			listaCompetenze.add(TipiEquip.ARMA_A_DISTANZA_DA_GUERRA);
			listaCompetenze.add(TipiEquip.ARMA_A_DISTANZA_SEMPLICE);
			listaCompetenze.add(TipiEquip.ARMA_DA_MISCHIA_DA_GUERRA);
			listaCompetenze.add(TipiEquip.ARMA_DA_MISCHIA_SEMPLICE);
			break;
		case LADRO:
			this.dado_vita = Dadi.D8;
			
			if (liv == 1) {
			    vitaMassima = Dadi.D8.getValore() + statCos;
			} else {
			    int sum = Dadi.D8.getValore() + statCos;
			    for (int i = 1; i < liv; i++) {
			        sum += (Dadi.D8.getValore() / 2 + 1) + statCos;
			    }
			    vitaMassima = sum;
			}
			//uno stocco o una spada corta
			listArmi.add(Armi.STOCCO);
			//un arco corto e una faretra con 20 frecce o una spada corta
			listArmi.add(Armi.ARCO_CORTO);
			equip.add(Equipaggiamento.FARETRA);
			//uno zaino da rapinatore, uno zaino da speleologo o uno zaino da esploratore
			//Armatura di cuoio, due pugnali, e attrezzi da ladro
			this.armatura= Armature.CUOIO;
			listArmi.add(Armi.PUGNALE);
			listArmi.add(Armi.PUGNALE);
			equip.add(Equipaggiamento.ARNESI_DA_SCASSO);
			this.scudo = null;
			//tiri salvezza
			listTSattivi.add(Statistiche.DESTREZZA);
			listTSattivi.add(Statistiche.INTELLIGENZA);
			//competenze
			listaCompetenze.add(TipiEquip.ARMATURA_LEGGERA);
			listaCompetenze.add(TipiEquip.ARMA_DA_MISCHIA_SEMPLICE);
			listaCompetenze.add(TipiEquip.BALESTRA_A_MANO);
			listaCompetenze.add(TipiEquip.SPADA_CORTA);
			listaCompetenze.add(TipiEquip.SPADA_LUNGA);
			listaCompetenze.add(TipiEquip.STOCCO);
			break;
		case MAGO:
			this.dado_vita = Dadi.D6;
			
			if (liv == 1) {
			    vitaMassima = Dadi.D6.getValore() + statCos;
			} else {
			    int sum = Dadi.D6.getValore() + statCos;
			    for (int i = 1; i < liv; i++) {
			        sum += (Dadi.D6.getValore() / 2 + 1) + statCos;
			    }
			    vitaMassima = sum;
			}
			//un bastone ferrato o un pugnale
			listArmi.add(Armi.BASTONE_FERRATO);
			//una borsa per componenti o un focus arcano
			equip.add(Equipaggiamento.BACCHETTA);
			//una dotazione da studioso o (b) una dotazione da esploratore [studioso]
			equip.add(Equipaggiamento.ZAINO);
			equip.add(Equipaggiamento.LIBRO);
			equip.add(Equipaggiamento.INCHIOSTRO);
			equip.add(Equipaggiamento.PENNINO);
			equip.add(Equipaggiamento.BACCHETTA);
			for(int i = 0; i<10; i++) {
				equip.add(Equipaggiamento.PERGAMENA);
			}
			equip.add(Equipaggiamento.SACCHETTO_DI_SABBIA);
			equip.add(Equipaggiamento.COLTELLINO);
			
			//Un libro degli incantesimi
			equip.add(Equipaggiamento.LIBRO_DEGLI_INCANTESIMI);
			//tiri salvezza
			listTSattivi.add(Statistiche.INTELLIGENZA);
			listTSattivi.add(Statistiche.SAGGEZZA);
			//competenze
			listaCompetenze.add(TipiEquip.BALESTRA_A_MANO);
			listaCompetenze.add(TipiEquip.BASTONE_FERRATO);
			listaCompetenze.add(TipiEquip.DARDO);
			listaCompetenze.add(TipiEquip.FIONDA);
			listaCompetenze.add(TipiEquip.PUGNALE);
			break;
		case MONACO:
			this.dado_vita = Dadi.D8;
			
			if (liv == 1) {
			    vitaMassima = Dadi.D8.getValore() + statCos;
			} else {
			    int sum = Dadi.D8.getValore() + statCos;
			    for (int i = 1; i < liv; i++) {
			        sum += (Dadi.D8.getValore() / 2 + 1) + statCos;
			    }
			    vitaMassima = sum;
			}
			//una spada corta o qualsiasi arma semplice
			listArmi.add(Armi.SPADA_CORTA);
			//uno zaino da speleologo o uno zaino da esploratore
			//10 dardi
			for(int i = 0; i<10; i++) {
				listArmi.add(Armi.DARDO);
			}
			this.scudo = null;
			//tiri salvezza
			listTSattivi.add(Statistiche.DESTREZZA);
			listTSattivi.add(Statistiche.SAGGEZZA);
			//competenze
			listaCompetenze.add(TipiEquip.ARMA_DA_MISCHIA_SEMPLICE);
			listaCompetenze.add(TipiEquip.SPADA_CORTA);
			break;
		case PALADINO:
			this.dado_vita = Dadi.D10;
			if (liv == 1) {
			    vitaMassima = Dadi.D10.getValore() + statCos;
			} else {
			    int sum = Dadi.D10.getValore() + statCos;
			    for (int i = 1; i < liv; i++) {
			        sum += (Dadi.D10.getValore() / 2 + 1) + statCos;
			    }
			    vitaMassima = sum;
			}
			//un’arma da guerra e uno scudo o due armi da guerra
			listArmi.add(Armi.MORNING_STAR);
			this.scudo = Scudi.SCUDO;
			//cinque giavellotti o qualsiasi arma semplice da mischia
			for(int i = 0; i<5; i++) {
				listArmi.add(Armi.GIAVELLOTTO);
			}
			//uno zaino da sacerdote o uno zaino da esploratore
			//Cotta di maglia e un simbolo sacro
			this.armatura = Armature.COTTA_DI_MAGLIA;
			equip.add(Equipaggiamento.EMBLEMA);
			//tiri salvezza
			listTSattivi.add(Statistiche.SAGGEZZA);
			listTSattivi.add(Statistiche.CARISMA);
			//competenze
			listaCompetenze.add(TipiEquip.ARMATURA_LEGGERA);
			listaCompetenze.add(TipiEquip.ARMATURA_MEDIA);
			listaCompetenze.add(TipiEquip.ARMATURA_PESANTE);
			listaCompetenze.add(TipiEquip.SCUDO);
			listaCompetenze.add(TipiEquip.ARMA_A_DISTANZA_DA_GUERRA);
			listaCompetenze.add(TipiEquip.ARMA_A_DISTANZA_SEMPLICE);
			listaCompetenze.add(TipiEquip.ARMA_DA_MISCHIA_DA_GUERRA);
			listaCompetenze.add(TipiEquip.ARMA_DA_MISCHIA_SEMPLICE);
			break;
		case RANGER:
			this.dado_vita = Dadi.D10;
			
			if (liv == 1) {
			    vitaMassima = Dadi.D10.getValore() + statCos;
			} else {
			    int sum = Dadi.D10.getValore() + statCos;
			    for (int i = 1; i < liv; i++) {
			        sum += (Dadi.D10.getValore() / 2 + 1) + statCos;
			    }
			    vitaMassima = sum;
			}
			
			//armatura a scaglie o armatura di cuoio
			this.armatura= Armature.CORAZZA_DI_SCAGLIE;
			//due spade corte o due armi semplici
			listArmi.add(Armi.SPADA_CORTA);
			listArmi.add(Armi.SPADA_CORTA);
			//uno zaino da speleologo o uno zaino da esploratore
			this.scudo = null;
			//tiri salvezza
			listTSattivi.add(Statistiche.FORZA);
			listTSattivi.add(Statistiche.DESTREZZA);
			//competenze
			listaCompetenze.add(TipiEquip.ARMATURA_LEGGERA);
			listaCompetenze.add(TipiEquip.ARMATURA_MEDIA);
			listaCompetenze.add(TipiEquip.SCUDO);
			listaCompetenze.add(TipiEquip.ARMA_A_DISTANZA_DA_GUERRA);
			listaCompetenze.add(TipiEquip.ARMA_A_DISTANZA_SEMPLICE);
			listaCompetenze.add(TipiEquip.ARMA_DA_MISCHIA_DA_GUERRA);
			listaCompetenze.add(TipiEquip.ARMA_DA_MISCHIA_SEMPLICE);
			break;
		case STREGONE:
			this.dado_vita = Dadi.D6;
			
			if (liv == 1) {
			    vitaMassima = Dadi.D6.getValore() + statCos;
			} else {
			    int sum = Dadi.D6.getValore() + statCos;
			    for (int i = 1; i < liv; i++) {
			        sum += (Dadi.D6.getValore() / 2 + 1) + statCos;
			    }
			    vitaMassima = sum;
			}
			//una balestra leggera e 20 quadrelli o una qualsiasi arma semplice
			listArmi.add(Armi.BALESTRA_LEGGERA);
			//una borsa per componenti o (b) un focus arcano
			equip.add(Equipaggiamento.BASTONE);
			//una dotazione da avventuriero o (b) una dotazione da esploratore [ora avventuriero]
			equip.add(Equipaggiamento.ZAINO);
			equip.add(Equipaggiamento.PIEDE_DI_PORCO);
			equip.add(Equipaggiamento.MARTELLO);
			for(int i = 0; i<10; i++) {
			equip.add(Equipaggiamento.CHIODO_DA_ROCCIATORE);
			equip.add(Equipaggiamento.RAZIONE);
			equip.add(Equipaggiamento.TORCIA);
			}
			equip.add(Equipaggiamento.ACCIARINO_E_PIETRA_FOCAIA);
			equip.add(Equipaggiamento.OTRE);
			//Due pugnali
			this.scudo = null;
			//tiri salvezza
			listTSattivi.add(Statistiche.COSTITUZIONE);
			listTSattivi.add(Statistiche.CARISMA);
			//competenze
			listaCompetenze.add(TipiEquip.BALESTRA_LEGGERA);
			listaCompetenze.add(TipiEquip.BASTONE_FERRATO);
			listaCompetenze.add(TipiEquip.DARDO);
			listaCompetenze.add(TipiEquip.FIONDA);
			listaCompetenze.add(TipiEquip.PUGNALE);
			break;
		case WARLOCK:
			this.dado_vita = Dadi.D8;
			
			if (liv == 1) {
			    vitaMassima = Dadi.D8.getValore() + statCos;
			} else {
			    int sum = Dadi.D8.getValore() + statCos;
			    for (int i = 1; i < liv; i++) {
			        sum += (Dadi.D8.getValore() / 2 + 1) + statCos;
			    }
			    vitaMassima = sum;
			}
			// una balestra leggera e 20 quadrelli o una qualsiasi arma semplice.
			listArmi.add(Armi.BALESTRA_LEGGERA);
			//una borsa per componenti o (b) un focus arcano.
			equip.add(Equipaggiamento.CRISTALLO);
			//una dotazione da studioso o (b) una dotazione da avventuriero. [ora solo avventuriero]
			equip.add(Equipaggiamento.ZAINO);
			equip.add(Equipaggiamento.PIEDE_DI_PORCO);
			equip.add(Equipaggiamento.MARTELLO);
			for(int i = 0; i<10; i++) {
			equip.add(Equipaggiamento.CHIODO_DA_ROCCIATORE);
			equip.add(Equipaggiamento.RAZIONE);
			equip.add(Equipaggiamento.TORCIA);
			}
			equip.add(Equipaggiamento.ACCIARINO_E_PIETRA_FOCAIA);
			equip.add(Equipaggiamento.OTRE);
			//Un'armatura di cuoio, una qualsiasi arma semplice e due pugnali.
			this.armatura= Armature.CUOIO;
			this.scudo = null;
			//tiri salvezza
			listTSattivi.add(Statistiche.SAGGEZZA);
			listTSattivi.add(Statistiche.CARISMA);
			//competenze
			listaCompetenze.add(TipiEquip.ARMATURA_LEGGERA);
			listaCompetenze.add(TipiEquip.ARMA_DA_MISCHIA_SEMPLICE);
			listaCompetenze.add(TipiEquip.ARMA_A_DISTANZA_SEMPLICE);
			break;
		default:
			break;
		}

		switch (liv) {
		case 1:
			this.bonusCompetenza = 2;
			this.dado_vita_num = liv;
			break;
		case 2:
			this.bonusCompetenza = 2;
			this.dado_vita_num = liv;
			break;
		case 3:
			this.bonusCompetenza = 2;
			this.dado_vita_num = liv;
			break;
		case 4:
			this.bonusCompetenza = 2;
			this.dado_vita_num = liv;
			break;
		case 5:
			this.bonusCompetenza = 3;
			this.dado_vita_num = liv;
			break;
		case 6:
			this.bonusCompetenza = 3;
			this.dado_vita_num = liv;
			break;
		case 7:
			this.bonusCompetenza = 3;
			this.dado_vita_num = liv;
			break;
		case 8:
			this.bonusCompetenza = 3;
			this.dado_vita_num = liv;
			break;
		case 9:
			this.bonusCompetenza = 4;
			this.dado_vita_num = liv;
			break;
		case 10:
			this.bonusCompetenza = 4;
			this.dado_vita_num = liv;
			break;
		case 11:
			this.bonusCompetenza = 4;
			this.dado_vita_num = liv;
			break;
		case 12:
			this.bonusCompetenza = 4;
			this.dado_vita_num = liv;
			break;
		case 13:
			this.bonusCompetenza = 5;
			this.dado_vita_num = liv;
			break;
		case 14:
			this.bonusCompetenza = 5;
			this.dado_vita_num = liv;
			break;
		case 15:
			this.bonusCompetenza = 5;
			this.dado_vita_num = liv;
			break;
		case 16:
			this.bonusCompetenza = 5;
			this.dado_vita_num = liv;
			break;
		case 17:
			this.bonusCompetenza = 6;
			this.dado_vita_num = liv;
			break;
		case 18:
			this.bonusCompetenza = 6;
			this.dado_vita_num = liv;
			break;
		case 19:
			this.bonusCompetenza = 6;
			this.dado_vita_num = liv;
			break;
		case 20:
			this.bonusCompetenza = 6;
			this.dado_vita_num = liv;
			break;
		default:
			break;
		}
		

		List<Privilegi> listaPrivilegi = new ArrayList<>();
		
		for (Privilegi privilegio : Privilegi.values()) {
		    if (cl == privilegio.getClasse() && liv >= privilegio.getLivello()) {
		        listaPrivilegi.add(privilegio);
		    }
		}

		this.giocatore = giocatore;
		this.nomePG = nomePG;
		this.razza = rz;
		this.classe = cl;
		this.allineamento = allineamento;
		this.livello = liv;
		this.background = background;
		this.puntiExp = 0;
		this.forza = statFor;
		this.destrezza = statDes;
		this.costituzione = statCos;
		this.intelligenza = statInt;
		this.saggezza = statSag;
		this.carisma = statCar;
		this.TSattivi = listTSattivi;
		this.abilitaAttive = abilitaAttive;
		this.competenze = listaCompetenze;
		this.privilegi = listaPrivilegi;
		this.ispizazione = false;
		this.linguaggi = listaLinguaggi;
		this.iniziativa = 0;
		this.PF_max = (int) vitaMassima;
		this.PF = vitaMassima;
		this.PF_temporanei = 0;
		this.TS_morte = 0;
		this.equipaggiamentoBase = equip;
		this.armi = listArmi;
		this.monete_rame = 0;
		this.monete_argento = 0;
		this.monete_oro = 0;
		this.monete_platino = 0;
		this.tratti_caratteriali = tratti_caratteriali;
		this.ideali = ideali;
		this.legami = legami;
		this.difetti = difetti;
	}

	
	
}