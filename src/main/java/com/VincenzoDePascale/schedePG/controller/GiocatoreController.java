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

import com.VincenzoDePascale.schedePG.auth.entity.User;
import com.VincenzoDePascale.schedePG.service.GiocatoreService;

@CrossOrigin(origins = "http://localhost:3000", maxAge = 360000, allowCredentials = "true")
@RestController
@RequestMapping("/api/giocatori")
public class GiocatoreController {
	
	@Autowired
	GiocatoreService giocatoreService;
	
	//GET - ricerca
	
	@GetMapping
	@PreAuthorize("isAuthenticated()")
	public ResponseEntity<?> getAll() {
		return new ResponseEntity<List<User>>(giocatoreService.findAllGiocatore(), HttpStatus.OK);
	}
	
	@GetMapping("/id/{id}")
	@PreAuthorize("isAuthenticated()")
	public ResponseEntity<?> findById(@PathVariable("id") Long id) {
		return new ResponseEntity<>(giocatoreService.findById(id), HttpStatus.OK);
	}
	
	@GetMapping("/email/{email}")
	@PreAuthorize("isAuthenticated()")
	public ResponseEntity<?> findByPartEmail(@PathVariable("email") String email) {
		return new ResponseEntity<>(giocatoreService.findByPartEmail(email), HttpStatus.OK);
	}
	
	@GetMapping("/username/{username}")
	@PreAuthorize("isAuthenticated()")
	public ResponseEntity<?> findByPartUsername(@PathVariable("username") String username) {
		return new ResponseEntity<>(giocatoreService.findByPartUsername(username), HttpStatus.OK);
	}
	
	//PUT - modifica
	
//	@PutMapping("/update/___")
//	@PreAuthorize("isAuthenticated()")
//	public ResponseEntity<?> updateGiocatore(@RequestBody User giocatore) {
//		return new ResponseEntity <User>(giocatoreService.updateGiocatore(giocatore), HttpStatus.CREATED);
//	}
	
	//è sempre un put
	@DeleteMapping("/delete/{id}")
	@PreAuthorize("isAuthenticated()")
	public ResponseEntity<?> delateGiocatore(@PathVariable Long id) {
		return new ResponseEntity <String>(giocatoreService.removeGiocatore(id), HttpStatus.CREATED);
	}
	

}
