package com.VincenzoDePascale.schedePG.runner;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.stereotype.Component;

import com.VincenzoDePascale.schedePG.auth.entity.ERole;
import com.VincenzoDePascale.schedePG.auth.entity.Role;
import com.VincenzoDePascale.schedePG.auth.entity.User;
import com.VincenzoDePascale.schedePG.auth.repository.RoleRepository;
import com.VincenzoDePascale.schedePG.auth.repository.UserRepository;
import com.VincenzoDePascale.schedePG.list.Classi;
import com.VincenzoDePascale.schedePG.list.Dadi;
import com.VincenzoDePascale.schedePG.list.Linguaggi;
import com.VincenzoDePascale.schedePG.list.Razze;
import com.VincenzoDePascale.schedePG.list.Statistiche;
import com.VincenzoDePascale.schedePG.list.TiriSalvezza;
import com.VincenzoDePascale.schedePG.list.Abilita;
import com.VincenzoDePascale.schedePG.list.Allineamenti;
import com.VincenzoDePascale.schedePG.model.Pg;
import com.VincenzoDePascale.schedePG.service.GiocatoreService;
import com.VincenzoDePascale.schedePG.service.PgService;
import com.VincenzoDePascale.schedePG.service.RoleService;



@Component
public class SchedePgRunner implements ApplicationRunner {

	@Autowired
	RoleService roleService;
	
	@Autowired
	GiocatoreService giocatoreService;

	@Autowired
	PgService pgService;

	@Override
	public void run(ApplicationArguments args) throws Exception {
		System.out.println("SchedePgRunner...START");

		User g = new User();
		g.setUsername("Prova_MOD:2.0");
		g.setEmail(g.getUsername() + "@example.it");
		g.setPassword("PW_" + g.getUsername());
		g.getRoles().add(roleService.findByRoleName(ERole.ROLE_USER));
		System.out.println(g);
//		giocatoreService.saveGiocatore(g);
		
		System.out.println("giocatore salvato");

		// pg creato con tutti i dati manualmente
		List<Statistiche> listaStat = new ArrayList<>();

		Statistiche.FORZA.setPunteggio("FORZA", 2);
		Statistiche.DESTREZZA.setPunteggio("DESTREZZA", 5);
		Statistiche.COSTITUZIONE.setPunteggio("COSTITUZIONE", 14);
		Statistiche.INTELLIGENZA.setPunteggio("INTELLIGENZA", 15);
		Statistiche.SAGGEZZA.setPunteggio("SAGGEZZA", 5);
		Statistiche.CARISMA.setPunteggio("CARISMA", 4);

		listaStat.add(Statistiche.FORZA);
		listaStat.add(Statistiche.DESTREZZA);
		listaStat.add(Statistiche.COSTITUZIONE);
		listaStat.add(Statistiche.INTELLIGENZA);
		listaStat.add(Statistiche.SAGGEZZA);
		listaStat.add(Statistiche.CARISMA);

		List<TiriSalvezza> listaTS = new ArrayList<>();

		listaTS.add(TiriSalvezza.TS_forza);
		listaTS.add(TiriSalvezza.TS_destrezza);
		listaTS.add(TiriSalvezza.TS_costituzione);
		listaTS.add(TiriSalvezza.TS_intelligenza);
		listaTS.add(TiriSalvezza.TS_sagezza);
		listaTS.add(TiriSalvezza.TS_carisma);

		TiriSalvezza.TS_forza.setAttivo("TS su forza", true);

		List<Abilita> listaAbilita = new ArrayList<>();

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

		Abilita.acrobazia.setAttivo("ACROBAZIA", true);

		List<Linguaggi> listaLinguaggi = new ArrayList<>();
		listaLinguaggi.add(Linguaggi.COMUNE);

		Pg pg = new Pg(g, "nomePG", Razze.ELFO, Classi.BARBARO, Allineamenti.CAOTICO_MALVAGIO, 1,
				"background prova", 55, listaStat, true, 0, listaTS, listaAbilita, listaLinguaggi, 0, 0, 7.5, 10, 10,
				10, Dadi.D10, 1, 0, 1000, 1000, 1000, 1000, "tratto caratteriale", "ideale", "legame", "difetto");
		
		
//		pgService.savePg(pg);
		
//		System.out.println("pg 1 salvato");
		
		
		int punteggio= pg.getStatistiche().get(0).getPunteggioForEnumName("FORZA");
		System.out.println("la forza è: " + punteggio);

		System.out.println("SchedePgRunner...END");
	}

}
