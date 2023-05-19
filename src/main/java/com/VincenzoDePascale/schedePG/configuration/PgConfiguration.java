package com.VincenzoDePascale.schedePG.configuration;

//import java.util.ArrayList;
//import java.util.List;
//
//import org.springframework.context.annotation.Bean;
//import org.springframework.context.annotation.Configuration;
//import org.springframework.context.annotation.PropertySource;
//import org.springframework.context.annotation.Scope;
//
//import com.VincenzoDePascale.schedePG.auth.entity.User;
//import com.VincenzoDePascale.schedePG.list.Abilita;
//import com.VincenzoDePascale.schedePG.list.Linguaggi;
//import com.VincenzoDePascale.schedePG.list.Razze;
//import com.VincenzoDePascale.schedePG.list.Statistiche;
//import com.VincenzoDePascale.schedePG.list.TiriSalvezza;
//import com.VincenzoDePascale.schedePG.model.Pg;
//
//@Configuration
//@PropertySource("classpath:application.properties")
public class PgConfiguration {

//	@Bean
//	@Scope("prototype")
//	public Pg pgStandard(User giocatore, String nomePG, Razze razza) {
//		
//		List<Statistiche> listaStat = new ArrayList<>();
//
//		Statistiche.FORZA.setPunteggio("FORZA", 10);
//		Statistiche.DESTREZZA.setPunteggio("DESTREZZA", 10);
//		Statistiche.COSTITUZIONE.setPunteggio("COSTITUZIONE", 10);
//		Statistiche.INTELLIGENZA.setPunteggio("INTELLIGENZA", 10);
//		Statistiche.SAGGEZZA.setPunteggio("SAGGEZZA", 10);
//		Statistiche.CARISMA.setPunteggio("CARISMA", 10);
//
//		listaStat.add(Statistiche.FORZA);
//		listaStat.add(Statistiche.DESTREZZA);
//		listaStat.add(Statistiche.COSTITUZIONE);
//		listaStat.add(Statistiche.INTELLIGENZA);
//		listaStat.add(Statistiche.SAGGEZZA);
//		listaStat.add(Statistiche.CARISMA);
//		
//		List<TiriSalvezza> listaTS = new ArrayList<>();
//
//		listaTS.add(TiriSalvezza.TS_forza);
//		listaTS.add(TiriSalvezza.TS_destrezza);
//		listaTS.add(TiriSalvezza.TS_costituzione);
//		listaTS.add(TiriSalvezza.TS_intelligenza);
//		listaTS.add(TiriSalvezza.TS_saggezza);
//		listaTS.add(TiriSalvezza.TS_carisma);
//		
//		List<Abilita> listaAbilita = new ArrayList<>();
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
//		List<Linguaggi> listaLinguaggi = new ArrayList<>();
//		listaLinguaggi.add(Linguaggi.COMUNE);
//		
//		return Pg.builder()
//				.giocatore(giocatore)
//				.nomePG(nomePG)
//				.razza(Razze.UMANO)
//				.classe(null)
//				.allineamento(null)
//				.livello(1)
//				.background(null)
//				.puntiExp(0)
//				.statistiche(listaStat)
//				.ispizazione(false)
//				.bonusCompetenza(0)
//				.tirisalvezza(listaTS)
//				.abilita(listaAbilita)
//				.linguaggi(listaLinguaggi)
//				.classe_armatura(0)
//				.iniziativa(0)
//				.velocita(9)
//				.PF_max(0)
//				.PF(0)
//				.PF_temporanei(0)
//				.dado_vita(null)
//				.dado_vita_num(null)
//				.TS_morte(0)
//				.monete_rame(0)
//				.monete_argento(0)
//				.monete_oro(0)
//				.monete_platino(0)
//				.tratti_caratteriali(null)
//				.ideali(null)
//				.legami(null)
//				.difetti(null)
//				.build();
//	}
}
