package com.VincenzoDePascale.schedePG;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;

import com.VincenzoDePascale.schedePG.auth.entity.ERole;
import com.VincenzoDePascale.schedePG.auth.entity.Role;
import com.VincenzoDePascale.schedePG.auth.entity.User;
import com.VincenzoDePascale.schedePG.auth.repository.RoleRepository;
import com.VincenzoDePascale.schedePG.list.Abilita;
import com.VincenzoDePascale.schedePG.list.Allineamenti;
import com.VincenzoDePascale.schedePG.list.Classi;
import com.VincenzoDePascale.schedePG.list.Dadi;
import com.VincenzoDePascale.schedePG.list.Linguaggi;
import com.VincenzoDePascale.schedePG.list.Razze;
import com.VincenzoDePascale.schedePG.list.TipoStatistica;
import com.VincenzoDePascale.schedePG.list.TiriSalvezza;
import com.VincenzoDePascale.schedePG.model.Pg;

public class Testing {
	
	@Autowired
	static RoleRepository roleRepo;

	static Pg pg;
	static User giocatore;

	@BeforeAll
	public static void beforeAllTestGiocatore() {
		
		Set<Role> roles = new HashSet<>();
		
		roles.add(roleRepo.findByRoleName(ERole.ROLE_USER).get());

		giocatore = new User(0l, "email_giocatore@example.it", "username_Giocatore", "password_giocatore", null, roles);

		List<TipoStatistica> listaStat = new ArrayList<>();

//		TipoStatistica.FORZA.setPunteggio("FORZA", 15);
//		TipoStatistica.DESTREZZA.setPunteggio("DESTREZZA", 15);
//		TipoStatistica.COSTITUZIONE.setPunteggio("COSTITUZIONE", 15);
//		TipoStatistica.INTELLIGENZA.setPunteggio("INTELLIGENZA", 15);
//		TipoStatistica.SAGGEZZA.setPunteggio("SAGGEZZA", 15);
//		TipoStatistica.CARISMA.setPunteggio("CARISMA", 15);

		listaStat.add(TipoStatistica.FORZA);
		listaStat.add(TipoStatistica.DESTREZZA);
		listaStat.add(TipoStatistica.COSTITUZIONE);
		listaStat.add(TipoStatistica.INTELLIGENZA);
		listaStat.add(TipoStatistica.SAGGEZZA);
		listaStat.add(TipoStatistica.CARISMA);

		List<TiriSalvezza> listaTS = new ArrayList<>();

		//TiriSalvezza.TS_forza.setAttivo("TS su forza");
		
		listaTS.add(TiriSalvezza.TS_forza);
		listaTS.add(TiriSalvezza.TS_destrezza);
		listaTS.add(TiriSalvezza.TS_costituzione);
		listaTS.add(TiriSalvezza.TS_intelligenza);
		listaTS.add(TiriSalvezza.TS_saggezza);
		listaTS.add(TiriSalvezza.TS_carisma);

		List<Abilita> listaAbilita = new ArrayList<>();

		Abilita.acrobazia.setAttivo("acrobazia", true);

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

		List<Linguaggi> listaLinguaggi = new ArrayList<>();
		listaLinguaggi.add(Linguaggi.COMUNE);

//		pg = new Pg(12l, giocatore, "nomePG", Razze.ELFO, Classi.BARBARO,
//				Allineamenti.CAOTICO_MALVAGIO, 1, "background prova", 55, listaStat, true, 0, listaTS, listaAbilita,
//				listaLinguaggi, 0, 0, 7.5, 10, 10, 10, Dadi.D10, 1, 0, 1000, 1000, 1000, 1000, "tratto caratteriale",
//				"ideale", "legame", "difetto");
	}

	@Test
	public void testIdGiocatore() {
		assertEquals(0l, giocatore.getId());
	}

	@Test
	public void testUsernameGiocatore() {
		assertEquals("username_Giocatore", giocatore.getUsername());
	}

	@Test
	public void testEmailGiocatore() {
		assertEquals("email_giocatore@example.it", giocatore.getEmail());
	}

	@Test
	public void testPasswordGiocatore() {
		assertEquals("password_giocatore", giocatore.getPassword());
	}

	@Test
	public void testIdPg() {
		assertEquals(12l, pg.getId());
	}

	@Test
	public void testGiocatorePg() {
		assertEquals(giocatore, pg.getGiocatore());
	}

	@Test
	public void testnomePgPg() {
		assertEquals("nomePG", pg.getNomePG());
	}

	@Test
	public void testRazzaPg() {
		assertEquals(Razze.ELFO, pg.getRazza());
	}

	@Test
	public void testClassePg() {
		assertEquals(Classi.BARBARO, pg.getClasse());
	}

	@Test
	public void testAllineamentoPg() {
		assertEquals(Allineamenti.CAOTICO_MALVAGIO, pg.getAllineamento());
	}

	@Test
	public void testLivelloPg() {
		assertEquals(1, pg.getLivello());
	}

	@Test
	public void testBackgroundPg() {
		assertEquals("background prova", pg.getBackground());
	}

	@Test
	public void testPuntiExpPg() {
		assertEquals(55, pg.getPuntiExp());
	}

	@Test
	public void testStatPg() {

		List<TipoStatistica> listaStat2 = new ArrayList<>();

//		TipoStatistica.FORZA.setPunteggio("FORZA", 15);
//		TipoStatistica.DESTREZZA.setPunteggio("DESTREZZA", 15);
//		TipoStatistica.COSTITUZIONE.setPunteggio("COSTITUZIONE", 15);
//		TipoStatistica.INTELLIGENZA.setPunteggio("INTELLIGENZA", 15);
//		TipoStatistica.SAGGEZZA.setPunteggio("SAGGEZZA", 15);
//		TipoStatistica.CARISMA.setPunteggio("CARISMA", 15);

		listaStat2.add(TipoStatistica.FORZA);
		listaStat2.add(TipoStatistica.DESTREZZA);
		listaStat2.add(TipoStatistica.COSTITUZIONE);
		listaStat2.add(TipoStatistica.INTELLIGENZA);
		listaStat2.add(TipoStatistica.SAGGEZZA);
		listaStat2.add(TipoStatistica.CARISMA);

		//assertEquals(listaStat2, pg.getStatistiche());
	}

	@Test
	public void testIspirazionePg() {
		assertEquals(true, pg.getIspizazione());
	}

	@Test
	public void testBonusCompetenzaPg() {
		assertEquals(0, pg.getBonusCompetenza());
	}

	@Test
	public void testTiriSalvezzaPg() {

		List<TiriSalvezza> listaTS2 = new ArrayList<>();

		//TiriSalvezza.TS_forza.setAttivo("TS su forza");

		listaTS2.add(TiriSalvezza.TS_forza);
		listaTS2.add(TiriSalvezza.TS_destrezza);
		listaTS2.add(TiriSalvezza.TS_costituzione);
		listaTS2.add(TiriSalvezza.TS_intelligenza);
		listaTS2.add(TiriSalvezza.TS_saggezza);
		listaTS2.add(TiriSalvezza.TS_carisma);

		assertEquals(listaTS2, pg.getTirisalvezza());
	}

	@Test
	public void testAbilitàPg() {

		List<Abilita> listaAbilita2 = new ArrayList<>();

		listaAbilita2.add(Abilita.acrobazia);
		listaAbilita2.add(Abilita.addestrare_animali);
		listaAbilita2.add(Abilita.arcano);
		listaAbilita2.add(Abilita.atletica);
		listaAbilita2.add(Abilita.furtivita);
		listaAbilita2.add(Abilita.indagare);
		listaAbilita2.add(Abilita.inganno);
		listaAbilita2.add(Abilita.intimidire);
		listaAbilita2.add(Abilita.intrattenere);
		listaAbilita2.add(Abilita.intuizione);
		listaAbilita2.add(Abilita.medicina);
		listaAbilita2.add(Abilita.natura);
		listaAbilita2.add(Abilita.percezione);
		listaAbilita2.add(Abilita.percezione_passiva);
		listaAbilita2.add(Abilita.persuazione);
		listaAbilita2.add(Abilita.rapidita_di_mano);
		listaAbilita2.add(Abilita.religione);
		listaAbilita2.add(Abilita.sopravvivenza);
		listaAbilita2.add(Abilita.storia);

		Abilita.acrobazia.setAttivo("acrobazia", true);

		assertEquals(listaAbilita2, pg.getAbilita());
	}

	@Test
	public void testLinguaggiPg() {

		List<Linguaggi> listaLinguaggi2 = new ArrayList<>();

		listaLinguaggi2.add(Linguaggi.COMUNE);

		assertEquals(listaLinguaggi2, pg.getLinguaggi());
	}

	@Test
	public void testClasseArmaturaPg() {
		assertEquals(0, pg.getClasse_armatura());
	}

	@Test
	public void testIniziativaPg() {
		assertEquals(0, pg.getIniziativa());
	}

	@Test
	public void testVelocitàPg() {
		assertEquals(7.5, pg.getVelocita());
	}

	@Test
	public void testPF_maxPg() {
		assertEquals(10, pg.getPF_max());
	}

	@Test
	public void testPFPg() {
		assertEquals(10, pg.getPF());
	}

	@Test
	public void testPF_temporaneiPg() {
		assertEquals(10, pg.getPF_temporanei());
	}

	@Test
	public void testDado_vitaPg() {
		assertEquals(Dadi.D10, pg.getDado_vita());
	}

	@Test
	public void testDado_vita_numPg() {
		assertEquals(1, pg.getDado_vita_num());
	}

	@Test
	public void testTS_mortePg() {
		assertEquals(0, pg.getTS_morte());
	}

	@Test
	public void testMonete_ramePg() {
		assertEquals(1000, pg.getMonete_rame());
	}

	@Test
	public void testMonete_argentoPg() {
		assertEquals(1000, pg.getMonete_argento());
	}

	@Test
	public void testMonete_oroPg() {
		assertEquals(1000, pg.getMonete_oro());
	}

	@Test
	public void testMonete_platinoPg() {
		assertEquals(1000, pg.getMonete_platino());
	}

	@Test
	public void testTratti_caratterialePg() {
		assertEquals("tratto caratteriale", pg.getTratti_caratteriali());
	}

	@Test
	public void testIdealiPg() {
		assertEquals("ideale", pg.getIdeali());
	}

	@Test
	public void testLegamiPg() {
		assertEquals("legame", pg.getLegami());
	}

	@Test
	public void testDifettiPg() {
		assertEquals("difetto", pg.getDifetti());
	}

}
