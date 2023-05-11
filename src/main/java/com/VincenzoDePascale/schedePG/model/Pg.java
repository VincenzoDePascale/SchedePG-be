package com.VincenzoDePascale.schedePG.model;

import java.util.List;

import com.VincenzoDePascale.schedePG.auth.entity.User;
import com.VincenzoDePascale.schedePG.list.Abilita;
import com.VincenzoDePascale.schedePG.list.Allineamenti;
import com.VincenzoDePascale.schedePG.list.Classi;
import com.VincenzoDePascale.schedePG.list.Dadi;
import com.VincenzoDePascale.schedePG.list.Linguaggi;
import com.VincenzoDePascale.schedePG.list.Razze;
import com.VincenzoDePascale.schedePG.list.Statistiche;
import com.VincenzoDePascale.schedePG.list.TiriSalvezza;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
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
public class Pg{

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;

	@ManyToOne(optional = false, cascade = CascadeType.MERGE)
	@JoinColumn(name = "giocatore_id", referencedColumnName = "id")
	@JsonIgnoreProperties({"pg"})
	private User giocatore;

	// INFO GENERALI-----------------------------------------

	@Column
	private String nomePG;

	@Enumerated(EnumType.STRING)
	private Razze razza;

	@Enumerated(EnumType.STRING)
	private Classi classe;

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
	private List<Statistiche> statistiche;

	// ABILITÀ--------------------------------------------------------

	@Column(nullable = false)
	private Boolean ispizazione;

	@Column
	private Integer bonusCompetenza;

	// TS
	// Come attivare il modificatore?

	@Column(nullable = false)
	private List<TiriSalvezza> tirisalvezza;

	// lista abilità
	// Come attivare il modificatore?

	@Column(nullable = false)
	private List<Abilita> abilita;

	@Column
	private List<Linguaggi> linguaggi;

	// STATISTICHE BASE

	@Builder.Default
	@Column
	private Integer classe_armatura = 0;

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

	@Column(nullable = false)
	private Dadi dado_vita;

	@Column(nullable = false)
	private Integer dado_vita_num;

	@Column(nullable = false)
	private Integer TS_morte;

	// EQUIPAGGIAMENTO----------------------------------

//	@Enumerated(EnumType.STRING)
//	private List<Object> Object;

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
	public Pg(User giocatore, String nomePG,
			Razze razza, Classi classe,	Allineamenti allineamento,
			Integer livello, String background, Integer puntiExp,
			List<Statistiche> statistiche, Boolean ispizazione, Integer bonusCompetenza,
			List<TiriSalvezza> tirisalvezza, List<Abilita> abilita, List<Linguaggi> linguaggi,
			Integer classe_armatura, Integer iniziativa, double velocita,
			Integer pF_max,	Integer pF, Integer pF_temporanei,
			Dadi dado_vita, Integer dado_vita_num, Integer tS_morte,
			Integer monete_rame, Integer monete_argento, Integer monete_oro, Integer monete_platino,
			String tratti_caratteriali, String ideali, String legami, String difetti) {
		super();
		this.giocatore = giocatore;
		this.nomePG = nomePG;
		this.razza = razza;
		this.classe = classe;
		this.allineamento = allineamento;
		this.livello = livello;
		this.background = background;
		this.puntiExp = puntiExp;
		this.statistiche = statistiche;
		this.ispizazione = ispizazione;
		this.bonusCompetenza = bonusCompetenza;
		this.tirisalvezza = tirisalvezza;
		this.abilita = abilita;
		this.linguaggi = linguaggi;
		this.classe_armatura = classe_armatura;
		this.iniziativa = iniziativa;
		this.velocita = velocita;
		this.PF_max = pF_max;
		this.PF = pF;
		this.PF_temporanei = pF_temporanei;
		this.dado_vita = dado_vita;
		this.dado_vita_num = dado_vita_num;
		this.TS_morte = tS_morte;
		this.monete_rame = monete_rame;
		this.monete_argento = monete_argento;
		this.monete_oro = monete_oro;
		this.monete_platino = monete_platino;
		this.tratti_caratteriali = tratti_caratteriali;
		this.ideali = ideali;
		this.legami = legami;
		this.difetti = difetti;
	}

	//costruttori con calcoli interni
//	public Pg(Giocatore giocatore, String nomePG, Razze razza, Classi classe,
//			Allineamenti allineamento, Integer livello, String background) {
//		super();
//		
//		//calcoli
//		List<Statistiche> listaStat = new ArrayList<>();
//		List<TiriSalvezza> listaTS = new ArrayList<>();
//		List<Abilita> listaAbilita = new ArrayList<>();
//		List<Linguaggi> listaLinguaggi = new ArrayList<>();
//		listaLinguaggi.add(Linguaggi.COMUNE);
//		int forza = 10;
//		int destrezza = 10;
//		int costituzione = 10;
//		int intelligenza = 10;
//		int saggezza = 10;
//		int carisma = 10;
//		int modFor_razza = 0;
//		int modDes_razza = 0;
//		int modCos_razza = 0;
//		int modInt_razza = 0;
//		int modSag_razza = 0;
//		int modCar_razza = 0;
//		double vel = 0;
//		int competenza = 0;
//		Dadi dVita = Dadi.D4;
//		
//		listaAbilita.add(Abilita.acrobazia);
//		listaAbilita.add(Abilita.addestrare_animali);
//		listaAbilita.add(Abilita.arcano);
//		listaAbilita.add(Abilita.atletica);
//		listaAbilita.add(Abilita.furtivita);
//		listaAbilita.add(Abilita.indagare);
//		listaAbilita.add(Abilita.inganno);
//		listaAbilita.add(Abilita.intimidire);
//		listaAbilita.add(Abilita.intrattenere);
//		listaAbilita.add(Abilita.intuizione);
//		listaAbilita.add(Abilita.medicina);
//		listaAbilita.add(Abilita.natura);
//		listaAbilita.add(Abilita.percezione);
//		listaAbilita.add(Abilita.percezione_passiva);
//		listaAbilita.add(Abilita.persuazione);
//		listaAbilita.add(Abilita.rapidita_di_mano);
//		listaAbilita.add(Abilita.religione);
//		listaAbilita.add(Abilita.sopravvivenza);
//		listaAbilita.add(Abilita.storia);
//						
//		switch(razza) {
//		case ELFO:
//			modDes_razza = 2;
//			listaLinguaggi.add(Linguaggi.ELFICO);
//			vel = 9;
//			break;
//		case HALFLING:
//			modDes_razza = 2;
//			listaLinguaggi.add(Linguaggi.HALFLING);
//			vel = 7.5;
//			break;
//		case NANO:
//			modCos_razza = 2;
//			listaLinguaggi.add(Linguaggi.NANICO);
//			vel = 7.5;
//			break;
//		case UMANO:
//			modFor_razza = 1;
//			modDes_razza = 1;
//			modCos_razza = 1;
//			modInt_razza = 1;
//			modSag_razza = 1;
//			modCar_razza = 1;
//			// listaLinguaggi.add(un altro a scelta);
//			vel = 9;
//			break;
//		case DRACONIDE:
//			modFor_razza = 2;
//			modCar_razza = 1;
//			listaLinguaggi.add(Linguaggi.DRACONICO);
//			vel = 9;
//			break;
//		case GNOMO:
//			modInt_razza = 2;
//			listaLinguaggi.add(Linguaggi.GNOMESCO);
//			vel = 7.5;
//			break;
//		case MEZZELFO:
//			modCar_razza = 2;
//			// altri due aumentano di 1 a scelta del giocatore
//			listaLinguaggi.add(Linguaggi.ELFICO);
//			// listaLinguaggi.add(un altro a scelta);
//			vel = 9;
//			break;
//		case MEZZORCO:
//			modFor_razza = 2;
//			modCos_razza = 1;
//			listaLinguaggi.add(Linguaggi.ORCHESCO);
//			vel = 9;
//			break;
//		case TIEFLING:
//			modInt_razza = 1;
//			modCar_razza = 2;
//			listaLinguaggi.add(Linguaggi.INFERNALE);
//			vel = 9;
//			break;
//		default:
//			break;
//			
//		}
//		
//		Statistiche.FORZA.setPunteggio("FORZA", forza + modFor_razza);
//		Statistiche.DESTREZZA.setPunteggio("DESTREZZA", destrezza + modDes_razza);
//		Statistiche.COSTITUZIONE.setPunteggio("COSTITUZIONE", costituzione + modCos_razza);
//		Statistiche.INTELLIGENZA.setPunteggio("INTELLIGENZA", intelligenza + modInt_razza);
//		Statistiche.SAGGEZZA.setPunteggio("SAGGEZZA", saggezza + modSag_razza);
//		Statistiche.CARISMA.setPunteggio("CARISMA", carisma + modCar_razza);
//
//		listaStat.add(Statistiche.FORZA);
//		listaStat.add(Statistiche.DESTREZZA);
//		listaStat.add(Statistiche.COSTITUZIONE);
//		listaStat.add(Statistiche.INTELLIGENZA);
//		listaStat.add(Statistiche.SAGGEZZA);
//		listaStat.add(Statistiche.CARISMA);
//		
//		switch (livello) {
//		case 1:
//		case 2:
//		case 3:
//		case 4:
//			competenza = 2;
//			break;
//		case 5:
//		case 6:
//		case 7:
//		case 8:
//			competenza = 3;
//			break;
//		case 9:
//		case 10:
//		case 11:
//		case 12:
//			competenza = 4;
//			break;
//		case 13:
//		case 14:
//		case 15:
//		case 16:
//			competenza = 5;
//			break;
//		case 17:
//		case 18:
//		case 19:
//		case 20:
//			competenza = 6;
//			break;
//		}
//		
//		listaTS.add(TiriSalvezza.TS_forza);
//		listaTS.add(TiriSalvezza.TS_destrezza);
//		listaTS.add(TiriSalvezza.TS_costituzione);
//		listaTS.add(TiriSalvezza.TS_intelligenza);
//		listaTS.add(TiriSalvezza.TS_sagezza);
//		listaTS.add(TiriSalvezza.TS_carisma);
//		
//		switch (this.classe) {
//		case BARBARO:
//			dVita = Dadi.D12;
//			TiriSalvezza.TS_forza.setAttivo(TiriSalvezza.TS_forza, true);
//			TiriSalvezza.TS_costituzione.setAttivo(TiriSalvezza.TS_costituzione, true);
//			break;
//		case BARDO:
//			dVita = Dadi.D8;
//			TiriSalvezza.TS_destrezza.setAttivo(TiriSalvezza.TS_destrezza, true);
//			TiriSalvezza.TS_carisma.setAttivo(TiriSalvezza.TS_carisma, true);
//			break;
//		case CHIERICO:
//			dVita = Dadi.D8;
//			TiriSalvezza.TS_sagezza.setAttivo(TiriSalvezza.TS_sagezza, true);
//			TiriSalvezza.TS_carisma.setAttivo(TiriSalvezza.TS_carisma, true);
//			break;
//		case DRUIDO:
//			dVita = Dadi.D8;
//			TiriSalvezza.TS_intelligenza.setAttivo(TiriSalvezza.TS_intelligenza, true);
//			TiriSalvezza.TS_sagezza.setAttivo(TiriSalvezza.TS_sagezza, true);
//			break;
//		case GUERRIERO:
//			dVita = Dadi.D10;
//			TiriSalvezza.TS_forza.setAttivo(TiriSalvezza.TS_forza, true);
//			TiriSalvezza.TS_costituzione.setAttivo(TiriSalvezza.TS_costituzione, true);
//			break;
//		case LADRO:
//			dVita = Dadi.D8;
//			TiriSalvezza.TS_destrezza.setAttivo(TiriSalvezza.TS_destrezza, true);
//			TiriSalvezza.TS_intelligenza.setAttivo(TiriSalvezza.TS_intelligenza, true);
//			break;
//		case MAGO:
//			dVita = Dadi.D6;
//			TiriSalvezza.TS_intelligenza.setAttivo(TiriSalvezza.TS_intelligenza, true);
//			TiriSalvezza.TS_sagezza.setAttivo(TiriSalvezza.TS_sagezza, true);
//			break;
//		case MONACO:
//			dVita = Dadi.D8;
//			TiriSalvezza.TS_forza.setAttivo(TiriSalvezza.TS_forza, true);
//			TiriSalvezza.TS_destrezza.setAttivo(TiriSalvezza.TS_destrezza, true);
//			break;
//		case PALADINO:
//			dVita = Dadi.D10;
//			TiriSalvezza.TS_forza.setAttivo(TiriSalvezza.TS_forza, true);
//			TiriSalvezza.TS_carisma.setAttivo(TiriSalvezza.TS_carisma, true);
//			break;
//		case RANGER:
//			dVita = Dadi.D10;
//			TiriSalvezza.TS_forza.setAttivo(TiriSalvezza.TS_forza, true);
//			TiriSalvezza.TS_destrezza.setAttivo(TiriSalvezza.TS_destrezza, true);
//			break;
//		case STREGONE:
//			dVita = Dadi.D6;
//			TiriSalvezza.TS_costituzione.setAttivo(TiriSalvezza.TS_costituzione, true);
//			TiriSalvezza.TS_carisma.setAttivo(TiriSalvezza.TS_carisma, true);
//			break;
//		case WARLOCK:
//			dVita = Dadi.D8;
//			TiriSalvezza.TS_sagezza.setAttivo(TiriSalvezza.TS_sagezza, true);
//			TiriSalvezza.TS_carisma.setAttivo(TiriSalvezza.TS_carisma, true);
//			break;
//		}
//		
//		//creazione
//		this.giocatore = giocatore;
//		this.nomeGiocatore = giocatore.getUsername();
//		this.nomePG = nomePG;
//		this.razza = razza;
//		this.classe = classe;
//		this.allineamento = allineamento;
//		this.livello = livello;
//		this.background = background;
//		this.puntiExp = 0;
//		this.statistiche = listaStat;
//		this.ispizazione = false;
//		this.bonusCompetenza = competenza;
//		this.tirisalvezza = listaTS;
//		this.abilita = listaAbilita;
//		this.linguaggi = listaLinguaggi;
//		this.classe_armatura = 0;
//		this.iniziativa = 0;
//		this.velocita = vel;
//		this.PF_max = 0;
//		this.PF = 0;
//		this.PF_temporanei = 0;
//		this.dado_vita = dVita;
//		this.dado_vita_num = this.livello;
//		this.TS_morte = 0;
//		this.monete_rame = 0;
//		this.monete_argento = 0;
//		this.monete_oro = 0;
//		this.monete_platino = 0;
//		this.tratti_caratteriali = "";
//		this.ideali = "";
//		this.legami = "";
//		this.difetti = "";
//	}

	
}