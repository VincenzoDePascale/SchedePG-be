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
import com.VincenzoDePascale.schedePG.model.*;
import com.VincenzoDePascale.schedePG.list.Incantesimi;
import com.VincenzoDePascale.schedePG.list.Linguaggi;
import com.VincenzoDePascale.schedePG.list.Privilegi;
import com.VincenzoDePascale.schedePG.list.PrivilegiSpeciali;
import com.VincenzoDePascale.schedePG.list.Razze;
import com.VincenzoDePascale.schedePG.list.Scudi;
import com.VincenzoDePascale.schedePG.list.Specializzazioni;
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
import jakarta.persistence.JoinTable;
import jakarta.persistence.ManyToMany;
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
	private Specializzazioni specializzazione;

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
	
	@Column
	@Enumerated(EnumType.STRING)
	private List<PrivilegiSpeciali> privilegiSpeciali;

	// ABILITÀ--------------------------------------------------------

	@Column(nullable = false)
	private boolean ispirazione;

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

//	@Column
//	@Enumerated(EnumType.STRING)
//	private List<Equipaggiamento> equipaggiamentoBase;
	
	@ManyToMany
    @JoinTable(
        name = "pg_equipaggiamento",
        joinColumns = @JoinColumn(name = "pg_id"),
        inverseJoinColumns = @JoinColumn(name = "equipaggiamento_id")
    )
    private List<Equipaggiamento> equipaggiamentoBase;

	@Column
	@Enumerated(EnumType.STRING)
	private Armature armatura;

	@Column
	@Enumerated(EnumType.STRING)
	private Scudi scudo;

	@Column
	@Enumerated(EnumType.STRING)
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

	@Column
	@Enumerated(EnumType.STRING)
	private List<Incantesimi> incantesimi;
	// ---------------------------------------------------------------------------------
	
	// COSTRUTTORI

	// costruttore SENZA ID
	public Pg(User giocatore, String nomePG, Razze razza, Classi classe, Specializzazioni specializzazione, Allineamenti allineamento, Integer livello,
			String background, Integer puntiExp, int forza, int destrezza, int costituzione, int intelligenza,
			int saggezza, int carisma, List<Statistiche> TSattivi, List<String> abilitaAttive, List<TipiEquip> competenze, List<Privilegi> privilegi, List<PrivilegiSpeciali> privilegiSpeciali,
			Boolean ispizazione, Integer bonusCompetenza, List<Linguaggi> linguaggi,
			Integer iniziativa, double velocita, Integer pF_max, Integer pF, Integer pF_temporanei, Dadi dado_vita,
			Integer dado_vita_num, Integer tS_morte, List<Equipaggiamento> equipaggiamentoBase, Armature armatura,
			Scudi scudo, List<Armi> armi, List<Incantesimi> incantesimi, Integer monete_rame, Integer monete_argento, Integer monete_oro,
			Integer monete_platino, String tratti_caratteriali, String ideali, String legami, String difetti) {
		super();
		this.giocatore = giocatore;
		this.nomePG = nomePG;
		this.razza = razza;
		this.classe = classe;
		this.specializzazione = specializzazione;
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
		this.privilegiSpeciali = privilegiSpeciali;
		this.ispirazione = ispizazione;
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
		this.incantesimi = incantesimi;
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
			int intelligenza, int saggezza, int carisma, Razze razza, Classi classe, Specializzazioni specializzazione, List<String> abilitaAttive, int livello, String background,
			String tratti_caratteriali, String ideali, String legami, String difetti) {
		super();

		Razze rz = razza;
		Classi cl = classe;
		Specializzazioni special = specializzazione;

		int statFor = forza;
		int statDes = destrezza;
		int statCos = costituzione;
		int statInt = intelligenza;
		int statSag = saggezza;
		int statCar = carisma;

		List<Linguaggi> listaLinguaggi = new ArrayList<>();
		listaLinguaggi.add(Linguaggi.COMUNE);
		
		List<Incantesimi> listaIncantesimi = new ArrayList<>();

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
		int modCos = ((int) Math.floor((statCos - 10) / 2.0));

		switch (cl) {
		case BARBARO:
			this.dado_vita = Dadi.D12;
			
			if (liv == 1) {
			    vitaMassima = Dadi.D12.getValore() + modCos;
			} else {
			    int sum = Dadi.D12.getValore() + modCos;
			    for (int i = 1; i < liv; i++) {
			        sum += (Dadi.D12.getValore() / 2 + 1) + modCos;
			    }
			    vitaMassima = sum;
			}
			
			//un'ascia bipenne o qualsiasi arma da guerra da mischia +
			//due asce o una qualsiasi arma semplice
			addToList(listArmi,
					Armi.ASCIA_BIPENNE,
					Armi.ASCIA,
					Armi.ASCIA);
//			--DA RIFARE--
//			Una dotazione da esploratore e quattro giavellotti
//			addToList(equip,
//					Equipaggiamento.ZAINO,
//					Equipaggiamento.GIACIGLIO,
//					Equipaggiamento.GAVETTA,
//					Equipaggiamento.ACCIARINO_E_PIETRA_FOCAIA,
//					Equipaggiamento.CORDA_DI_CANAPA,
//					Equipaggiamento.OTRE);
//			for(int i = 0; i<10; i++) {
//				addToList(equip,
//						Equipaggiamento.TORCIA,
//						Equipaggiamento.RAZIONE);
//			}
			
			for(int i = 0; i<4; i++) {
				listArmi.add(Armi.GIAVELLOTTO);
			}
			this.scudo = null;
			//tiri salvezza
			addToList(listTSattivi, Statistiche.FORZA, Statistiche.COSTITUZIONE);
			//competenze
			addToList(listaCompetenze,
					TipiEquip.ARMATURA_LEGGERA,
					TipiEquip.ARMATURA_MEDIA,
					TipiEquip.SCUDO,
					TipiEquip.ARMA_DA_MISCHIA_SEMPLICE,
					TipiEquip.ARMA_A_DISTANZA_SEMPLICE,
					TipiEquip.ARMA_DA_MISCHIA_DA_GUERRA,
					TipiEquip.ARMA_A_DISTANZA_DA_GUERRA);
			break;
		case BARDO:
			this.dado_vita = Dadi.D8;
			
			if (liv == 1) {
			    vitaMassima = Dadi.D8.getValore() + modCos;
			} else {
			    int sum = Dadi.D8.getValore() + modCos;
			    for (int i = 1; i < liv; i++) {
			        sum += (Dadi.D8.getValore() / 2 + 1) + modCos;
			    }
			    vitaMassima = sum;
			}
			//uno stocco, una spada lunga o una qualsiasi arma semplice
			addToList(listArmi,
					Armi.STOCCO,
					Armi.PUGNALE);
			//Un'armatura di cuoio e un pugnale
			this.armatura= Armature.CUOIO;
			this.scudo = null;
//			--DA RIFARE--
//			una dotazione da diplomatico o una dotazione da intrattenitore [diplomatico]
//			addToList(equip,
//					Equipaggiamento.FORZIERE,
//					Equipaggiamento.ABITO_PR,
//					Equipaggiamento.INCHIOSTRO,
//					Equipaggiamento.PENNINO,
//					Equipaggiamento.LAMPADA,
//					Equipaggiamento.PROFUMO,
//					Equipaggiamento.CERA_PER_SIGILLO,
//					Equipaggiamento.SAPONE,
//					//un liuto o (b) un qualsiasi altro strumento musicale [ora solo liuto]
//					Equipaggiamento.LIUTO);
//
//			for(int i = 0; i<2; i++) {
//				equip.add(Equipaggiamento.CUSTODIA_PER_MAPPE_O_PERGAMENE);
//				equip.add(Equipaggiamento.AMPOLLA);
//			}
//			for(int i = 0; i<5; i++) {
//				equip.add(Equipaggiamento.CARTA);
//			}

			//tiri salvezza
			addToList(listTSattivi, Statistiche.DESTREZZA, Statistiche.CARISMA);
			//competenze
			addToList(listaCompetenze,
					TipiEquip.ARMATURA_LEGGERA,
					TipiEquip.ARMA_DA_MISCHIA_SEMPLICE,
					TipiEquip.BALESTRA_A_MANO,
					TipiEquip.SPADA_CORTA,
					TipiEquip.SPADA_LUNGA,
					TipiEquip.STOCCO);
			break;
		case CHIERICO:
			this.dado_vita = Dadi.D8;
			
			if (liv == 1) {
			    vitaMassima = Dadi.D8.getValore() + modCos;
			} else {
			    int sum = Dadi.D8.getValore() + modCos;
			    for (int i = 1; i < liv; i++) {
			        sum += (Dadi.D8.getValore() / 2 + 1) + modCos;
			    }
			    vitaMassima = sum;
			}
			//una mazza o un martello da guerra (se ha competenza)
			//una balestra leggera e 20 quadrelli o una qualsiasi arma semplice
			addToList(listArmi, Armi.BALESTRA_LEGGERA, Armi.MAZZA);
			//una corazza di scaglie, (b) un'armatura di cuoio o (c) una cotta di maglia (Se ha competenza)
			this.armatura= Armature.CORAZZA_DI_SCAGLIE;
			
//			--DA RIFARE--
//			una dotazione da sacerdote o (b) una dotazione da esploratore [ora solo sacerdote]
//			addToList(equip,
//					Equipaggiamento.ZAINO,
//					Equipaggiamento.COPERTA,
//					Equipaggiamento.ACCIARINO_E_PIETRA_FOCAIA,
//					Equipaggiamento.CASSETTA_PER_LE_OFFERTE,
//					Equipaggiamento.INCENSIERE,
//					Equipaggiamento.VESTE,
//					Equipaggiamento.OTRE,
//					Equipaggiamento.EMBLEMA);
//			for(int i = 0; i<10; i++) {
//				equip.add(Equipaggiamento.CANDELA);
//			}
//			for(int i = 0; i<2; i++) {
//				equip.add(Equipaggiamento.INCENSO);
//			}
//			for(int i = 0; i<10; i++) {
//				equip.add(Equipaggiamento.RAZIONE);
//			}
			
			//Uno scudo e un simbolo sacro
			
			this.scudo = Scudi.SCUDO;
			//tiri salvezza
			addToList(listTSattivi, Statistiche.SAGGEZZA, Statistiche.CARISMA);
			//competenze
			addToList(listaCompetenze,
					TipiEquip.ARMATURA_LEGGERA,
					TipiEquip.ARMATURA_MEDIA,
					TipiEquip.SCUDO,
					TipiEquip.ARMA_DA_MISCHIA_SEMPLICE);
			break;
		case DRUIDO:
			this.dado_vita = Dadi.D8;
			
			if (liv == 1) {
			    vitaMassima = Dadi.D8.getValore() + modCos;
			} else {
			    int sum = Dadi.D8.getValore() + modCos;
			    for (int i = 1; i < liv; i++) {
			        sum += (Dadi.D8.getValore() / 2 + 1) + modCos;
			    }
			    vitaMassima = sum;
			}
			// uno scudo di legno o una qualsiasi arma semplice.
			this.scudo = Scudi.SCUDO;
			//una scimitarra o una qualsiasi arma semplice da mischia.
			listArmi.add(Armi.SCIMITARRA);
			//Un'armatura di cuoio
			this.armatura= Armature.CUOIO;
			
//			--DA RIFARE--
//			una dotazione da esploratore
//			addToList(equip,
//					Equipaggiamento.ZAINO,
//					Equipaggiamento.GIACIGLIO,
//					Equipaggiamento.GAVETTA,
//					Equipaggiamento.ACCIARINO_E_PIETRA_FOCAIA,
//					Equipaggiamento.CORDA_DI_CANAPA,
//					Equipaggiamento.OTRE);
//			
//			for(int i = 0; i<10; i++) {
//				addToList(equip, Equipaggiamento.TORCIA, Equipaggiamento.RAZIONE);
//			}
//			//un focus druidico
//			addToList(equip,
//					Equipaggiamento.TOTEM);
			//tiri salvezza
			addToList(listTSattivi,
					Statistiche.INTELLIGENZA,
					Statistiche.SAGGEZZA);
			//competenze
			addToList(listaCompetenze,
					TipiEquip.ARMATURA_LEGGERA,
					TipiEquip.ARMATURA_MEDIA,
					TipiEquip.SCUDO,
					TipiEquip.BASTONE_FERRATO,
					TipiEquip.DARDO,
					TipiEquip.FALCETTO,
					TipiEquip.GIAVELLOTTO,
					TipiEquip.LANCIA,
					TipiEquip.MAZZA,
					TipiEquip.PUGNALE,
					TipiEquip.RANDELLO,
					TipiEquip.SCIMITARRA,
					TipiEquip.FIONDA);
			break;
		case GUERRIERO:
			this.dado_vita = Dadi.D10;
			
			if (liv == 1) {
			    vitaMassima = Dadi.D10.getValore() + modCos;
			} else {
			    int sum = Dadi.D10.getValore() + modCos;
			    for (int i = 1; i < liv; i++) {
			        sum += (Dadi.D10.getValore() / 2 + 1) + modCos;
			    }
			    vitaMassima = sum;
			}
			
			//cotta di maglia o (b) armatura di cuoio, arco lungo e 20 frecce
			this.armatura= Armature.COTTA_DI_MAGLIA;
			//un’arma da guerra e uno scudo o (b) due armi da guerra
			//una balestra leggera e 20 quadrelli o (b) due asce
			this.scudo = Scudi.SCUDO;
			addToList(listArmi, Armi.SPADONE, Armi.BALESTRA_LEGGERA);
			//uno zaino da speleologo o (b) uno zaino da esploratore
			//tiri salvezza
			addToList(listTSattivi, Statistiche.FORZA, Statistiche.COSTITUZIONE);
			//competenze
			addToList(listaCompetenze,
					TipiEquip.ARMATURA_LEGGERA,
					TipiEquip.ARMATURA_MEDIA,
					TipiEquip.ARMATURA_PESANTE,
					TipiEquip.SCUDO,
					TipiEquip.ARMA_A_DISTANZA_DA_GUERRA,
					TipiEquip.ARMA_A_DISTANZA_SEMPLICE,
					TipiEquip.ARMA_DA_MISCHIA_DA_GUERRA,
					TipiEquip.ARMA_DA_MISCHIA_SEMPLICE);
			break;
		case LADRO:
			this.dado_vita = Dadi.D8;
			
			if (liv == 1) {
			    vitaMassima = Dadi.D8.getValore() + modCos;
			} else {
			    int sum = Dadi.D8.getValore() + modCos;
			    for (int i = 1; i < liv; i++) {
			        sum += (Dadi.D8.getValore() / 2 + 1) + modCos;
			    }
			    vitaMassima = sum;
			}
			//uno stocco o una spada corta
			//un arco corto e una faretra con 20 frecce o una spada corta
			//Armatura di cuoio, due pugnali, e attrezzi da ladro
			addToList(listArmi,
					Armi.STOCCO,
					Armi.ARCO_CORTO,
					Armi.PUGNALE,
					Armi.PUGNALE);
			this.armatura= Armature.CUOIO;
			this.scudo = null;
			
//			--DA RIFARE--
//			uno zaino da rapinatore, uno zaino da speleologo o uno zaino da esploratore
//			addToList(equip,
//					Equipaggiamento.FARETRA,
//					Equipaggiamento.ARNESI_DA_SCASSO);
			
			//tiri salvezza
			addToList(listTSattivi,
					Statistiche.DESTREZZA,
					Statistiche.INTELLIGENZA);
			//competenze
			addToList(listaCompetenze,
					TipiEquip.ARMATURA_LEGGERA,
					TipiEquip.ARMA_DA_MISCHIA_SEMPLICE,
					TipiEquip.BALESTRA_A_MANO,
					TipiEquip.SPADA_CORTA,
					TipiEquip.SPADA_LUNGA,
					TipiEquip.STOCCO);
			break;
		case MAGO:
			this.dado_vita = Dadi.D6;
			
			if (liv == 1) {
			    vitaMassima = Dadi.D6.getValore() + modCos;
			} else {
			    int sum = Dadi.D6.getValore() + modCos;
			    for (int i = 1; i < liv; i++) {
			        sum += (Dadi.D6.getValore() / 2 + 1) + modCos;
			    }
			    vitaMassima = sum;
			}
			//un bastone ferrato o un pugnale
			addToList(listArmi,
					Armi.BASTONE_FERRATO);
			
//			--DA RIFARE--
//			una borsa per componenti o un focus arcano
//			una dotazione da studioso o (b) una dotazione da esploratore [studioso]
//			Un libro degli incantesimi
//			addToList(equip,
//					Equipaggiamento.BACCHETTA,
//					Equipaggiamento.ZAINO,
//					Equipaggiamento.LIBRO,
//					Equipaggiamento.INCHIOSTRO,
//					Equipaggiamento.PENNINO,
//					Equipaggiamento.BACCHETTA,
//					Equipaggiamento.SACCHETTO_DI_SABBIA,
//					Equipaggiamento.COLTELLINO,
//					Equipaggiamento.LIBRO_DEGLI_INCANTESIMI);
//			
//			for(int i = 0; i<10; i++) {
//				equip.add(Equipaggiamento.PERGAMENA);
//			}
			
			
			//tiri salvezza
			addToList(listTSattivi,
					Statistiche.INTELLIGENZA,
					Statistiche.SAGGEZZA);
			//competenze
			addToList(listaCompetenze,
					TipiEquip.BALESTRA_A_MANO,
					TipiEquip.BASTONE_FERRATO,
					TipiEquip.DARDO,
					TipiEquip.FIONDA,
					TipiEquip.PUGNALE);
			break;
		case MONACO:
			this.dado_vita = Dadi.D8;
			
			if (liv == 1) {
			    vitaMassima = Dadi.D8.getValore() + modCos;
			} else {
			    int sum = Dadi.D8.getValore() + modCos;
			    for (int i = 1; i < liv; i++) {
			        sum += (Dadi.D8.getValore() / 2 + 1) + modCos;
			    }
			    vitaMassima = sum;
			}
			//una spada corta o qualsiasi arma semplice
			addToList(listArmi,
					Armi.SPADA_CORTA);
			
//			--DA RIFARE--
//			uno zaino da speleologo o uno zaino da esploratore
//			addToList(equip, Equipaggiamento.ZAINO_DA_ESPLORATORE);
			
			//10 dardi
			for(int i = 0; i<10; i++) {
				addToList(listArmi, Armi.DARDO);
			}
			this.scudo = null;
			//tiri salvezza
			addToList(listTSattivi,
					Statistiche.DESTREZZA,
					Statistiche.SAGGEZZA);
			//competenze
			addToList(listaCompetenze,
					TipiEquip.ARMA_DA_MISCHIA_SEMPLICE,
					TipiEquip.SPADA_CORTA);
			break;
		case PALADINO:
			this.dado_vita = Dadi.D10;
			if (liv == 1) {
			    vitaMassima = Dadi.D10.getValore() + modCos;
			} else {
			    int sum = Dadi.D10.getValore() + modCos;
			    for (int i = 1; i < liv; i++) {
			        sum += (Dadi.D10.getValore() / 2 + 1) + modCos;
			    }
			    vitaMassima = sum;
			}
			//un’arma da guerra e uno scudo o due armi da guerra
			addToList(listArmi, Armi.MORNING_STAR);
			this.scudo = Scudi.SCUDO;
			//cinque giavellotti o qualsiasi arma semplice da mischia
			for(int i = 0; i<5; i++) {
				addToList(listArmi, Armi.GIAVELLOTTO);
			}
			
//			--DA RIFARE--
//			uno zaino da sacerdote o uno zaino da esploratore
//			addToList(equip, Equipaggiamento.ZAINO_DA_SACERDOTE);
//			addToList(equip, Equipaggiamento.EMBLEMA);
			
			//Cotta di maglia e un simbolo sacro
			this.armatura = Armature.COTTA_DI_MAGLIA;
			//tiri salvezza
			addToList(listTSattivi,
					Statistiche.SAGGEZZA,
					Statistiche.CARISMA);
			//competenze
			addToList(listaCompetenze,
					TipiEquip.ARMATURA_LEGGERA,
					TipiEquip.ARMATURA_MEDIA,
					TipiEquip.ARMATURA_PESANTE,
					TipiEquip.SCUDO,
					TipiEquip.ARMA_A_DISTANZA_DA_GUERRA,
					TipiEquip.ARMA_A_DISTANZA_SEMPLICE,
					TipiEquip.ARMA_DA_MISCHIA_DA_GUERRA,
					TipiEquip.ARMA_DA_MISCHIA_SEMPLICE);
			break;
		case RANGER:
			this.dado_vita = Dadi.D10;
			
			if (liv == 1) {
			    vitaMassima = Dadi.D10.getValore() + modCos;
			} else {
			    int sum = Dadi.D10.getValore() + modCos;
			    for (int i = 1; i < liv; i++) {
			        sum += (Dadi.D10.getValore() / 2 + 1) + modCos;
			    }
			    vitaMassima = sum;
			}
			
			//armatura a scaglie o armatura di cuoio
			this.armatura= Armature.CORAZZA_DI_SCAGLIE;
			//due spade corte o due armi semplici
			addToList(listArmi,
					Armi.SPADA_CORTA,
					Armi.SPADA_CORTA);
			//uno zaino da speleologo o uno zaino da esploratore
			
//			--DA RIFARE--
//			addToList(equip, Equipaggiamento.ZAINO_DA_ESPLORATORE);
			
			this.scudo = null;
			//tiri salvezza
			addToList(listTSattivi,
					Statistiche.FORZA,
					Statistiche.DESTREZZA);
			//competenze
			addToList(listaCompetenze,
					TipiEquip.ARMATURA_LEGGERA,
					TipiEquip.ARMATURA_MEDIA,
					TipiEquip.SCUDO,
					TipiEquip.ARMA_A_DISTANZA_DA_GUERRA,
					TipiEquip.ARMA_A_DISTANZA_SEMPLICE,
					TipiEquip.ARMA_DA_MISCHIA_DA_GUERRA,
					TipiEquip.ARMA_DA_MISCHIA_SEMPLICE);
			break;
		case STREGONE:
			this.dado_vita = Dadi.D6;
			
			if (liv == 1) {
			    vitaMassima = Dadi.D6.getValore() + modCos;
			} else {
			    int sum = Dadi.D6.getValore() + modCos;
			    for (int i = 1; i < liv; i++) {
			        sum += (Dadi.D6.getValore() / 2 + 1) + modCos;
			    }
			    vitaMassima = sum;
			}
			//una balestra leggera e 20 quadrelli o una qualsiasi arma semplice
			addToList(listArmi,
					Armi.BALESTRA_LEGGERA);
			
//			--DA RIFARE--
//			una borsa per componenti o (b) un focus arcano
//			addToList(equip, Equipaggiamento.BORSA_PER_COMPONENTI);
//			una dotazione da avventuriero o (b) una dotazione da esploratore [ora avventuriero]
//			addToList(equip,
//					Equipaggiamento.BASTONE,
//					Equipaggiamento.ZAINO,
//					Equipaggiamento.PIEDE_DI_PORCO,
//					Equipaggiamento.MARTELLO,
//					Equipaggiamento.ACCIARINO_E_PIETRA_FOCAIA,
//					Equipaggiamento.OTRE);
//			
//			for(int i = 0; i<10; i++) {
//				addToList(equip,
//						Equipaggiamento.CHIODO_DA_ROCCIATORE,
//						Equipaggiamento.RAZIONE,
//						Equipaggiamento.TORCIA);
//			}
			
			//Due pugnali
			addToList(listArmi, Armi.PUGNALE, Armi.PUGNALE);
			this.scudo = null;
			//tiri salvezza
			addToList(listTSattivi,
					Statistiche.COSTITUZIONE,
					Statistiche.CARISMA);
			//competenze
			addToList(listaCompetenze,
					TipiEquip.BALESTRA_LEGGERA,
					TipiEquip.BASTONE_FERRATO,
					TipiEquip.DARDO,
					TipiEquip.FIONDA,
					TipiEquip.PUGNALE);
			break;
		case WARLOCK:
			this.dado_vita = Dadi.D8;
			
			if (liv == 1) {
			    vitaMassima = Dadi.D8.getValore() + modCos;
			} else {
			    int sum = Dadi.D8.getValore() + modCos;
			    for (int i = 1; i < liv; i++) {
			        sum += (Dadi.D8.getValore() / 2 + 1) + modCos;
			    }
			    vitaMassima = sum;
			}
			// una balestra leggera e 20 quadrelli o una qualsiasi arma semplice.
			addToList(listArmi, Armi.BALESTRA_LEGGERA);
			//una borsa per componenti o (b) un focus arcano.
			
//			--DA RIFARE--
//			addToList(equip,
//					//una dotazione da studioso o (b) una dotazione da avventuriero. [ora solo avventuriero]
//					Equipaggiamento.CRISTALLO,
//					Equipaggiamento.ZAINO,
//					Equipaggiamento.PIEDE_DI_PORCO,
//					Equipaggiamento.MARTELLO,
//					Equipaggiamento.ACCIARINO_E_PIETRA_FOCAIA,
//					Equipaggiamento.OTRE);
//			for(int i = 0; i<10; i++) {
//				addToList(equip,
//						Equipaggiamento.CHIODO_DA_ROCCIATORE,
//						Equipaggiamento.RAZIONE,
//						Equipaggiamento.TORCIA);
//			}
			
			//Un'armatura di cuoio, una qualsiasi arma semplice e due pugnali.
			this.armatura= Armature.CUOIO;
			this.scudo = null;
			//tiri salvezza
			addToList(listTSattivi,
					Statistiche.SAGGEZZA,
					Statistiche.CARISMA);
			//competenze
			addToList(listaCompetenze,
					TipiEquip.ARMATURA_LEGGERA,
					TipiEquip.ARMA_DA_MISCHIA_SEMPLICE,
					TipiEquip.ARMA_A_DISTANZA_SEMPLICE);
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
		
		List<PrivilegiSpeciali> listaPrivilegiSpeciali = new ArrayList<>();
		
		for (PrivilegiSpeciali priSpec : PrivilegiSpeciali.values()) {
			if(cl == priSpec.getClasse() && special == priSpec.getSpecializzazione() && liv >= priSpec.getLivello()) {
				listaPrivilegiSpeciali.add(priSpec);
			}
		}

		this.giocatore = giocatore;
		this.nomePG = nomePG;
		this.razza = rz;
		this.classe = cl;
		this.specializzazione = specializzazione;
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
		this.privilegiSpeciali = listaPrivilegiSpeciali;
		this.ispirazione = false;
		this.linguaggi = listaLinguaggi;
		this.iniziativa = 0;
		this.PF_max = (int) vitaMassima;
		this.PF = vitaMassima;
		this.PF_temporanei = 0;
		this.TS_morte = 0;
		this.equipaggiamentoBase = equip;
		this.armi = listArmi;
		this.incantesimi = listaIncantesimi;
		this.monete_rame = 0;
		this.monete_argento = 0;
		this.monete_oro = 0;
		this.monete_platino = 0;
		this.tratti_caratteriali = tratti_caratteriali;
		this.ideali = ideali;
		this.legami = legami;
		this.difetti = difetti;
	}

	public static <T extends Enum<T>> void addToList(List<T> list, T... elementi) {
	    for (T elemento : elementi) {
	        list.add(elemento);
	    }
	}
}