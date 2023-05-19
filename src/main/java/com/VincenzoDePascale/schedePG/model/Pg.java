package com.VincenzoDePascale.schedePG.model;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import com.VincenzoDePascale.schedePG.auth.entity.User;
import com.VincenzoDePascale.schedePG.list.Abilita;
import com.VincenzoDePascale.schedePG.list.Allineamenti;
import com.VincenzoDePascale.schedePG.list.Classi;
import com.VincenzoDePascale.schedePG.list.Dadi;
import com.VincenzoDePascale.schedePG.list.Linguaggi;
import com.VincenzoDePascale.schedePG.list.Razze;
import com.VincenzoDePascale.schedePG.list.TipoStatistica;
import com.VincenzoDePascale.schedePG.list.TiriSalvezza;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.FetchType;
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
	
//	@ManyToMany(fetch = FetchType.EAGER, cascade = CascadeType.MERGE)
//    @JoinTable(name = "pg_stat",
//            joinColumns = @JoinColumn(name = "personaggi_id", referencedColumnName = "id"),
//            inverseJoinColumns = @JoinColumn(name = "statistiche_id", referencedColumnName = "id")
//    )
//	private Set<Statistica> statistiche = new HashSet<>();

	// ABILITÀ--------------------------------------------------------

	@Column(nullable = false)
	private Boolean ispizazione;

	@Column
	private Integer bonusCompetenza;

	// TS
	// Come attivare il modificatore?

	//da cambiare in base a come farò constatistiche
	@Enumerated(EnumType.STRING)
	@Column(nullable = false)
	private List<TiriSalvezza> tirisalvezza;

	//da cambiare in base a come farò constatistiche
	@Enumerated(EnumType.STRING)
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

	@Enumerated(EnumType.STRING)
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
	public Pg(User giocatore, String nomePG, Razze razza, Classi classe, Allineamenti allineamento, Integer livello,
			String background, Integer puntiExp, int forza, int destrezza, int costituzione, int intelligenza,
			int saggezza, int carisma, /*Set<Statistica> statistiche,*/ Boolean ispizazione, Integer bonusCompetenza, List<TiriSalvezza> tirisalvezza,
			List<Abilita> abilita, List<Linguaggi> linguaggi, Integer classe_armatura, Integer iniziativa,
			double velocita, Integer pF_max, Integer pF, Integer pF_temporanei, Dadi dado_vita, Integer dado_vita_num,
			Integer tS_morte, Integer monete_rame, Integer monete_argento, Integer monete_oro, Integer monete_platino,
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
		this.forza = forza;
		this.destrezza = destrezza;
		this.costituzione = costituzione;
		this.intelligenza = intelligenza;
		this.saggezza = saggezza;
		this.carisma = carisma;
//		this.statistiche = statistiche;
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

	// costruttori con calcoli interni
	public Pg(User giocatore, String nomePG, int forza, int destrezza, int costituzione, int intelligenza, int saggezza,
			int carisma, Razze razza, Classi classe, int livello) {
		super();
		
		Razze rz = razza;
		Classi cl = classe;
		int liv = livello;
		
		/*Set<Statistica> listaStat = new HashSet<>();
		Statistica statFor = new Statistica(TipoStatistica.FORZA, forza);
		Statistica statDes = new Statistica(TipoStatistica.DESTREZZA, destrezza);
		Statistica statCos = new Statistica(TipoStatistica.COSTITUZIONE, costituzione);
		Statistica statInt = new Statistica(TipoStatistica.INTELLIGENZA, intelligenza);
		Statistica statSag = new Statistica(TipoStatistica.SAGGEZZA, saggezza);
		Statistica statCar = new Statistica(TipoStatistica.CARISMA, carisma);*/
		
		int statFor = forza;
		int statDes = destrezza;
		int statCos = costituzione;
		int statInt = intelligenza;
		int statSag = saggezza;
		int statCar = carisma;
		
		List<TiriSalvezza> listaTS = new ArrayList<>();

		listaTS.add(TiriSalvezza.TS_forza);
		listaTS.add(TiriSalvezza.TS_destrezza);
		listaTS.add(TiriSalvezza.TS_costituzione);
		listaTS.add(TiriSalvezza.TS_intelligenza);
		listaTS.add(TiriSalvezza.TS_saggezza);
		listaTS.add(TiriSalvezza.TS_carisma);

		List<Abilita> listaAbilita = new ArrayList<>();
		List<Linguaggi> listaLinguaggi = new ArrayList<>();
		listaLinguaggi.add(Linguaggi.COMUNE);

		listaAbilita.add(Abilita.acrobazia);
		listaAbilita.add(Abilita.addestrare_animali);
		listaAbilita.add(Abilita.arcano);
		listaAbilita.add(Abilita.atletica);
		listaAbilita.add(Abilita.furtivita);
		listaAbilita.add(Abilita.indagare);
		listaAbilita.add(Abilita.inganno);
		listaAbilita.add(Abilita.intimidire);
		listaAbilita.add(Abilita.intrattenere);
		listaAbilita.add(Abilita.intuizione);
		listaAbilita.add(Abilita.medicina);
		listaAbilita.add(Abilita.natura);
		listaAbilita.add(Abilita.percezione);
		listaAbilita.add(Abilita.percezione_passiva);
		listaAbilita.add(Abilita.persuazione);
		listaAbilita.add(Abilita.rapidita_di_mano);
		listaAbilita.add(Abilita.religione);
		listaAbilita.add(Abilita.sopravvivenza);
		listaAbilita.add(Abilita.storia);

		switch (rz) {
		case ELFO:
			this.velocita = 9;
			//statDes.setModificaPunteggio(2);
			statDes+=2;
			listaLinguaggi.add(Linguaggi.ELFICO);
			break;
		case HALFLING:
			this.velocita = 7.5;
			//statDes.setModificaPunteggio(2);
			statDes+=2;
			listaLinguaggi.add(Linguaggi.HALFLING);
			break;
		case NANO:
			this.velocita = 7.5;		
			//statCos.setModificaPunteggio(2);
			statCos+=2;
			listaLinguaggi.add(Linguaggi.NANICO);
			break;
		case UMANO:
			this.velocita = 9;
			//statFor.setModificaPunteggio(1);
			statFor+=1;
			//statDes.setModificaPunteggio(1);
			statDes+=1;
			//statCos.setModificaPunteggio(1);
			statCos+=1;
			//statInt.setModificaPunteggio(1);
			statInt+=1;
			//statSag.setModificaPunteggio(1);
			statSag+=1;
			//statCar.setModificaPunteggio(1);
			statCar+=1;
			break;
		case DRACONIDE:
			this.velocita = 9;
			//statFor.setModificaPunteggio(2);
			statFor+=2;
			//statCar.setModificaPunteggio(1);
			statCar+=1;
			listaLinguaggi.add(Linguaggi.DRACONICO);
			break;
		case GNOMO:
			this.velocita = 7.5;
			//statInt.setModificaPunteggio(2);
			statInt+=2;
			listaLinguaggi.add(Linguaggi.GNOMESCO);
			break;
		case MEZZELFO:
			this.velocita = 9;
			//statCar.setModificaPunteggio(2);
			statCar+=2;
			// altri due aumentano di 1 a scelta del giocatore
			listaLinguaggi.add(Linguaggi.ELFICO);
			// listaLinguaggi.add(un altro a scelta);
			break;
		case MEZZORCO:
			this.velocita = 9;
			//statFor.setModificaPunteggio(2);
			statFor+=2;
			//statCos.setModificaPunteggio(1);
			statCos+=1;
			listaLinguaggi.add(Linguaggi.ORCHESCO);
			break;
		case TIEFLING:
			this.velocita = 9;
			//statInt.setModificaPunteggio(1);
			statInt+=1;
			//statCar.setModificaPunteggio(2);
			statCar+=2;
			listaLinguaggi.add(Linguaggi.INFERNALE);
			break;
		default:
			break;
		}

		switch (cl) {
		case BARBARO:
			this.dado_vita = Dadi.D12;
			TiriSalvezza.TS_forza.setAttivo("TS_forza", true);
			TiriSalvezza.TS_costituzione.setAttivo("TS_costituzione", true);
			break;
		case BARDO:
			this.dado_vita = Dadi.D8;
			TiriSalvezza.TS_destrezza.setAttivo("TS_destrezza", true);
			TiriSalvezza.TS_carisma.setAttivo("TS_carisma", true);
			break;
		case CHIERICO:
			this.dado_vita = Dadi.D8;
			TiriSalvezza.TS_saggezza.setAttivo("TS_saggezza", true);
			TiriSalvezza.TS_carisma.setAttivo("TS_carisma", true);
			break;
		case DRUIDO:
			this.dado_vita = Dadi.D8;
			TiriSalvezza.TS_intelligenza.setAttivo("TS_intelligenza", true);
			TiriSalvezza.TS_saggezza.setAttivo("TS_saggezza", true);
			break;
		case GUERRIERO:
			this.dado_vita = Dadi.D10;
			TiriSalvezza.TS_forza.setAttivo("TS_forza", true);
			TiriSalvezza.TS_costituzione.setAttivo("TS_costituzione", true);
			break;
		case LADRO:
			this.dado_vita = Dadi.D8;
			TiriSalvezza.TS_destrezza.setAttivo("TS_destrezza", true);
			TiriSalvezza.TS_intelligenza.setAttivo("TS_intelligenza", true);
			break;
		case MAGO:
			this.dado_vita = Dadi.D6;
			TiriSalvezza.TS_intelligenza.setAttivo("TS_intelligenza", true);
			TiriSalvezza.TS_saggezza.setAttivo("TS_saggezza", true);
			break;
		case MONACO:
			this.dado_vita = Dadi.D8;
			TiriSalvezza.TS_forza.setAttivo("TS_forza", true);
			TiriSalvezza.TS_destrezza.setAttivo("TS_destrezza", true);
			break;
		case PALADINO:
			this.dado_vita = Dadi.D10;
			TiriSalvezza.TS_saggezza.setAttivo("TS_saggezza", true);
			TiriSalvezza.TS_carisma.setAttivo("TS_carisma", true);
			break;
		case RANGER:
			this.dado_vita = Dadi.D10;
			TiriSalvezza.TS_forza.setAttivo("TS_forza", true);
			TiriSalvezza.TS_destrezza.setAttivo("TS_destrezza", true);
			break;
		case STREGONE:
			this.dado_vita = Dadi.D6;
			TiriSalvezza.TS_costituzione.setAttivo("TS_costituzione", true);
			TiriSalvezza.TS_carisma.setAttivo("TS_carisma", true);
			break;
		case WARLOCK:
			this.dado_vita = Dadi.D8;
			TiriSalvezza.TS_saggezza.setAttivo("TS_saggezza", true);
			TiriSalvezza.TS_carisma.setAttivo("TS_carisma", true);
			break;
		default:
			break;

		}

		switch (liv) {
		case 1:
		case 2:
		case 3:
		case 4:
			this.bonusCompetenza = 2;
			break;
		case 5:
		case 6:
		case 7:
		case 8:
			this.bonusCompetenza = 3;
			break;
		case 9:
		case 10:
		case 11:
		case 12:
			this.bonusCompetenza = 4;
			break;
		case 13:
		case 14:
		case 15:
		case 16:
			this.bonusCompetenza = 5;
			break;
		case 17:
		case 18:
		case 19:
		case 20:
			this.bonusCompetenza = 6;
			break;
		default:
			break;
		}

		/*listaStat.add(statFor);
		listaStat.add(statDes);
		listaStat.add(statCos);
		listaStat.add(statInt);
		listaStat.add(statSag);
		listaStat.add(statCar);*/

		this.giocatore = giocatore;
		this.nomePG = nomePG;
		this.razza = rz;
		this.classe = cl;
		this.allineamento = Allineamenti.NEUTRALE;
		this.livello = liv;
		this.background = "la tua storia";
		this.puntiExp = 0;
		this.forza = statFor;
		this.destrezza = statDes;
		this.costituzione = statCos;
		this.intelligenza = statInt;
		this.saggezza = statSag;
		this.carisma = statCar;
//		this.statistiche = listaStat;
		this.ispizazione = false;
		this.tirisalvezza = listaTS;
		this.abilita = listaAbilita;
		this.linguaggi = listaLinguaggi;
		this.classe_armatura = 0;
		this.iniziativa = 0;
		this.PF_max = 1;
		this.PF = 1;
		this.PF_temporanei = 0;
		this.dado_vita_num = liv;
		this.TS_morte = 0;
		this.monete_rame = 0;
		this.monete_argento = 0;
		this.monete_oro = 0;
		this.monete_platino = 0;
		this.tratti_caratteriali = "tratti caratteriali";
		this.ideali = "ideali";
		this.legami = "legami";
		this.difetti = "difetti";
	}

}