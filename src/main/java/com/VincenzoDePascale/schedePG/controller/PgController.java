package com.VincenzoDePascale.schedePG.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.VincenzoDePascale.schedePG.auth.entity.User;
import com.VincenzoDePascale.schedePG.auth.repository.UserRepository;
import com.VincenzoDePascale.schedePG.list.Allineamenti;
import com.VincenzoDePascale.schedePG.list.Armature;
import com.VincenzoDePascale.schedePG.list.Classi;
import com.VincenzoDePascale.schedePG.list.Linguaggi;
import com.VincenzoDePascale.schedePG.list.Razze;
import com.VincenzoDePascale.schedePG.list.Scudi;
import com.VincenzoDePascale.schedePG.list.Statistiche;
import com.VincenzoDePascale.schedePG.list.TipiEquip;
import com.VincenzoDePascale.schedePG.model.Pg;
import com.VincenzoDePascale.schedePG.payload.PgDto;
import com.VincenzoDePascale.schedePG.payload.updateAbilitaPgDto;
import com.VincenzoDePascale.schedePG.payload.updateArmaturaPgDto;
import com.VincenzoDePascale.schedePG.payload.updateCompetenzePgDto;
import com.VincenzoDePascale.schedePG.payload.updateIspirazionePgDto;
import com.VincenzoDePascale.schedePG.payload.updateLinguaggiPgDto;
import com.VincenzoDePascale.schedePG.payload.updateNotePgDto;
import com.VincenzoDePascale.schedePG.payload.updateRicchezzaPgDto;
import com.VincenzoDePascale.schedePG.payload.updateStatistichePgDto;
import com.VincenzoDePascale.schedePG.payload.updateTsPgDto;
import com.VincenzoDePascale.schedePG.payload.updateVitaPgDto;
import com.VincenzoDePascale.schedePG.repository.PgRepository;
import com.VincenzoDePascale.schedePG.service.PgService;

@CrossOrigin(origins = "http://localhost:3000", maxAge = 360000, allowCredentials = "true")
@RestController
@RequestMapping("/api/pg")
public class PgController {

	@Autowired
	PgService pgService;
	@Autowired
	private PgRepository pgRepo;

	@Autowired
	UserRepository userRepo;

	// GET - ricerca

	@GetMapping
	@PreAuthorize("isAuthenticated()")
	public ResponseEntity<?> getAll() {
		return new ResponseEntity<List<Pg>>(pgService.findAllPg(), HttpStatus.OK);
	}

	@GetMapping("/id/{id}")
	@PreAuthorize("isAuthenticated()")
	public ResponseEntity<?> findById(@PathVariable("id") Long id) {
		return new ResponseEntity<>(pgService.findById(id), HttpStatus.OK);
	}

	@GetMapping("/username/{username}")
	@PreAuthorize("isAuthenticated()")
	public ResponseEntity<?> searchPgBygiocatoreUsername(@PathVariable("username") String username) {
		return new ResponseEntity<>(pgService.searchPgBygiocatoreUsername(username), HttpStatus.OK);
	}

	@GetMapping("/nomepg/{nomepg}")
	@PreAuthorize("isAuthenticated()")
	public ResponseEntity<?> findByNomePG(@PathVariable("nomepg") String nomepg) {
		return new ResponseEntity<>(pgService.findByNomePG(nomepg), HttpStatus.OK);
	}

	@GetMapping("/razza/{razza}")
	@PreAuthorize("isAuthenticated()")
	public ResponseEntity<?> findByRazza(@PathVariable("razza") Razze razza) {
		return new ResponseEntity<>(pgService.findByRazza(razza), HttpStatus.OK);
	}

	@GetMapping("/classe/{classe}")
	@PreAuthorize("isAuthenticated()")
	public ResponseEntity<?> findByClasse(@PathVariable("classe") Classi classe) {
		return new ResponseEntity<>(pgService.findByClasse(classe), HttpStatus.OK);
	}

	@GetMapping("/allineamento/{allineamento}")
	@PreAuthorize("isAuthenticated()")
	public ResponseEntity<?> findByAllineamento(@PathVariable("allineamento") Allineamenti allineamento) {
		return new ResponseEntity<>(pgService.findByAllineamento(allineamento), HttpStatus.OK);
	}

	@GetMapping("/livello/{livello}")
	@PreAuthorize("isAuthenticated()")
	public ResponseEntity<?> findByLivello(@PathVariable("livello") int livello) {
		return new ResponseEntity<>(pgService.findByLivello(livello), HttpStatus.OK);
	}

	// POST - salvataggio

	@PostMapping("/save")
	@PreAuthorize("isAuthenticated()")
	public ResponseEntity<?> savePg(@RequestBody PgDto data) {
		User u = userRepo.findByUsername(data.getNomeUtente()).get();
		Pg pg = new Pg(u, data.getNomePersonaggio(), Allineamenti.getEnumByTipo(data.getAllineamento()),
				data.getForza(), data.getDestrezza(), data.getCostituzione(), data.getIntelligenza(),
				data.getSaggezza(), data.getCarisma(), Razze.getEnumByTipo(data.getRazza()),
				Classi.getEnumByTipo(data.getClasse()), data.getAbilitaAttive(), data.getLivello(),
				data.getBackground(), data.getTratti_caratteriali(), data.getIdeali(), data.getLegami(),
				data.getDifetti());
		return new ResponseEntity<>(pgService.savePg(pg), HttpStatus.CREATED);
	}

	// PUT - modifica

	@PreAuthorize("isAuthenticated()")
	@PutMapping(value = "/upgradeIspirazione")
	public ResponseEntity<?> updateIspirazionePg(@RequestBody updateIspirazionePgDto data) {

		Pg pg = pgRepo.findById(data.getIdPg()).orElse(null);

		if (pg == null) {
			return new ResponseEntity<>("PG non trovato", HttpStatus.NOT_FOUND);
		}

		if (data.getIspirazione() != true) {
			pg.setIspirazione(true);
		} else {
			pg.setIspirazione(false);
		}

		Pg savedPg = pgService.savePg(pg);
		return new ResponseEntity<>(savedPg, HttpStatus.OK);
	}
	
	@PreAuthorize("isAuthenticated()")
	@PutMapping(value = "/upgradeStatistiche")
	public ResponseEntity<?> updateMonetePg(@RequestBody updateStatistichePgDto data) {

		Pg pg = pgRepo.findById(data.getIdPg()).get();

		if (pg == null) {
			return new ResponseEntity<>("PG non trovato", HttpStatus.NOT_FOUND);
		}

		pg.setForza(data.getForza());

		pg.setDestrezza(data.getDestrezza());

		pg.setCostituzione(data.getCostituzione());

		pg.setIntelligenza(data.getIntelligenza());
		
		pg.setSaggezza(data.getSaggezza());
		
		pg.setCarisma(data.getCarisma());

		return new ResponseEntity<>(pgService.savePg(pg), HttpStatus.OK);
	}

	@PreAuthorize("isAuthenticated()")
	@PutMapping(value = "/upgradeTS")
	public ResponseEntity<?> updateTiriSalvezzaPg(@RequestBody updateTsPgDto data) {

		Pg pg = pgRepo.findById(data.getIdPg()).orElse(null);

		if (pg == null) {
			return new ResponseEntity<>("PG non trovato", HttpStatus.NOT_FOUND);
		}

		if (data.getTiriSalvezza() != null) {
			List<Statistiche> newTs = new ArrayList<>();
			for (String statistica : data.getTiriSalvezza()) {
				Statistiche enumTS = Statistiche.getEnumByStatistica(statistica);
				if (enumTS != null) {
					newTs.add(enumTS);
				}
			}
			pg.setTSattivi(newTs);
		}

		Pg savedPg = pgService.savePg(pg);
		return new ResponseEntity<>(savedPg, HttpStatus.OK);
	}

	@PreAuthorize("isAuthenticated()")
	@PutMapping(value = "/upgradeAbilita")
	public ResponseEntity<?> updateAbilitaPg(@RequestBody updateAbilitaPgDto data) {

		Pg pg = pgRepo.findById(data.getIdPg()).orElse(null);

		if (pg == null) {
			return new ResponseEntity<>("PG non trovato", HttpStatus.NOT_FOUND);
		}

		if (data.getAbilita() != null && data.getAbilita() != pg.getAbilitaAttive()) {
			pg.setAbilitaAttive(data.getAbilita());
		}

		Pg savedPg = pgService.savePg(pg);
		return new ResponseEntity<>(savedPg, HttpStatus.OK);
	}

	@PreAuthorize("isAuthenticated()")
	@PutMapping(value = "/upgradeLingue")
	public ResponseEntity<?> updateLinguaggiPg(@RequestBody updateLinguaggiPgDto data) {

		Pg pg = pgRepo.findById(data.getIdPg()).orElse(null);

		if (pg == null) {
			return new ResponseEntity<>("PG non trovato", HttpStatus.NOT_FOUND);
		}

		if (data.getLinguaggi() != null) {
			List<Linguaggi> newLinguaggi = new ArrayList<>();
			for (String linguaggio : data.getLinguaggi()) {
				Linguaggi enumLinguaggio = Linguaggi.getEnumByLingua(linguaggio);
				if (enumLinguaggio != null) {
					newLinguaggi.add(enumLinguaggio);
				}
			}
			pg.setLinguaggi(newLinguaggi);
		}

		Pg savedPg = pgService.savePg(pg);
		return new ResponseEntity<>(savedPg, HttpStatus.OK);
	}

	@PreAuthorize("isAuthenticated()")
	@PutMapping(value = "/upgradeCompetenze")
	public ResponseEntity<?> updateCompetenzePg(@RequestBody updateCompetenzePgDto data) {

		Pg pg = pgRepo.findById(data.getIdPg()).orElse(null);

		if (pg == null) {
			return new ResponseEntity<>("PG non trovato", HttpStatus.NOT_FOUND);
		}

		if (data.getCompetenze() != null) {
			List<TipiEquip> newCompetenze = new ArrayList<>();
			for (String competenza : data.getCompetenze()) {
				TipiEquip enumCompetenza = TipiEquip.getEnumByNome(competenza);
				if (enumCompetenza != null) {
					newCompetenze.add(enumCompetenza);
				}
			}
			pg.setCompetenze(newCompetenze);
		}

		Pg savedPg = pgService.savePg(pg);
		return new ResponseEntity<>(savedPg, HttpStatus.OK);
	}

	@PreAuthorize("isAuthenticated()")
	@PutMapping(value = "/upgradeArmor")
	public ResponseEntity<?> updateArmorPg(@RequestBody updateArmaturaPgDto data) {

		Pg pg = pgRepo.findById(data.getIdPg()).get();

		if (pg == null) {
			return new ResponseEntity<>("PG non trovato", HttpStatus.NOT_FOUND);
		}

		if (data.getArmatura() != "" && data.getArmatura() != null) {
			pg.setArmatura(Armature.getEnumByNome(data.getArmatura()));
		} else {
			pg.setArmatura(null);
		}

		if (data.getScudo() != "" && data.getScudo() != null) {
			pg.setScudo(Scudi.getEnumByNome(data.getScudo()));
		} else {
			pg.setScudo(null);
		}

		return new ResponseEntity<>(pgService.savePg(pg), HttpStatus.OK);
	}

	@PreAuthorize("isAuthenticated()")
	@PutMapping(value = "/upgradeVita")
	public ResponseEntity<?> updateVitaPg(@RequestBody updateVitaPgDto data) {

		Pg pg = pgRepo.findById(data.getIdPg()).get();

		if (pg == null) {
			return new ResponseEntity<>("PG non trovato", HttpStatus.NOT_FOUND);
		}

		if(data.getPfAttuali() > pg.getPF_max()) {
			pg.setPF(pg.getPF_max());
		}else {
			pg.setPF(data.getPfAttuali());
		}

		if(data.getPfMassimi() != pg.getPF_max()) {
			pg.setPF_max(data.getPfMassimi());
		}
		
		if(data.getPfTemporanei() > pg.getPF_max()) {
			pg.setPF_temporanei(pg.getPF_max());
		}else {
			pg.setPF_temporanei(data.getPfTemporanei());
		}

		return new ResponseEntity<>(pgService.savePg(pg), HttpStatus.OK);
	}

	@PreAuthorize("isAuthenticated()")
	@PutMapping(value = "/upgradeMonete")
	public ResponseEntity<?> updateMonetePg(@RequestBody updateRicchezzaPgDto data) {

		Pg pg = pgRepo.findById(data.getIdPg()).get();

		if (pg == null) {
			return new ResponseEntity<>("PG non trovato", HttpStatus.NOT_FOUND);
		}

		pg.setMonete_rame(data.getMoneteRame());

		pg.setMonete_argento(data.getMoneteArgento());

		pg.setMonete_oro(data.getMoneteOro());

		pg.setMonete_platino(data.getMonetePlatino());

		return new ResponseEntity<>(pgService.savePg(pg), HttpStatus.OK);
	}

	@PreAuthorize("isAuthenticated()")
	@PutMapping(value = "/upgradeNote")
	public ResponseEntity<?> updateNotePg(@RequestBody updateNotePgDto data) {

		Pg pg = pgRepo.findById(data.getIdPg()).get();

		if (pg == null) {
			return new ResponseEntity<>("PG non trovato", HttpStatus.NOT_FOUND);
		}

		if (data.getBackground() != null) {
			pg.setBackground(data.getBackground());
		}

		if (data.getTratti_caratteriali() != null) {
			pg.setTratti_caratteriali(data.getTratti_caratteriali());
		}

		if (data.getIdeali() != null) {
			pg.setIdeali(data.getIdeali());
		}

		if (data.getLegami() != null) {
			pg.setLegami(data.getLegami());
		}

		if (data.getDifetti() != null) {
			pg.setDifetti(data.getDifetti());
		}

		return new ResponseEntity<>(pgService.savePg(pg), HttpStatus.OK);
	}

	// DELETE

	@DeleteMapping("/delete/{id}")
	@PreAuthorize("isAuthenticated()")
	public ResponseEntity<?> delatePg(@PathVariable Long id) {
		return new ResponseEntity<String>(pgService.deletePG(id), HttpStatus.CREATED);
	}

}
