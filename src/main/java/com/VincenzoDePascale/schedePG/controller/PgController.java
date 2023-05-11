package com.VincenzoDePascale.schedePG.controller;

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

import com.VincenzoDePascale.schedePG.list.Allineamenti;
import com.VincenzoDePascale.schedePG.list.Classi;
import com.VincenzoDePascale.schedePG.list.Razze;
import com.VincenzoDePascale.schedePG.model.Pg;
import com.VincenzoDePascale.schedePG.service.PgService;

@CrossOrigin(origins = "*", maxAge = 360000)
@RestController
@RequestMapping("/api/pg")
public class PgController {

	@Autowired
	PgService pgService;

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

	@GetMapping("/giocatore/{username}")
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

	@PostMapping
	@PreAuthorize("isAuthenticated()")
	public ResponseEntity<?> savePg(@RequestBody Pg pg) {
		return new ResponseEntity<>(pgService.savePg(pg), HttpStatus.CREATED);
	}

	// PUT - modifica

	@PutMapping
	@PreAuthorize("isAuthenticated()")
	public ResponseEntity<?> updatePg(@RequestBody Pg pg) {
		return new ResponseEntity<>(pgService.updatePg(pg), HttpStatus.CREATED);
	}

	// è sempre un put
	@DeleteMapping("/{id}")
	@PreAuthorize("isAuthenticated()")
	public ResponseEntity<?> delatePg(@PathVariable Long id) {
		return new ResponseEntity<String>(pgService.deletePG(id), HttpStatus.CREATED);
	}

}
