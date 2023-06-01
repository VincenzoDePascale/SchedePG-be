package com.VincenzoDePascale.schedePG;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;

import com.VincenzoDePascale.schedePG.auth.entity.ERole;
import com.VincenzoDePascale.schedePG.auth.entity.Role;
import com.VincenzoDePascale.schedePG.auth.entity.User;
import com.VincenzoDePascale.schedePG.auth.repository.RoleRepository;
import com.VincenzoDePascale.schedePG.list.Allineamenti;
import com.VincenzoDePascale.schedePG.list.Classi;
import com.VincenzoDePascale.schedePG.list.Dadi;
import com.VincenzoDePascale.schedePG.list.Linguaggi;
import com.VincenzoDePascale.schedePG.list.Razze;
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
	public void testBonusCompetenzaPg() {
		assertEquals(0, pg.getBonusCompetenza());
	}

	@Test
	public void testLinguaggiPg() {

		List<Linguaggi> listaLinguaggi2 = new ArrayList<>();

		listaLinguaggi2.add(Linguaggi.COMUNE);

		assertEquals(listaLinguaggi2, pg.getLinguaggi());
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
