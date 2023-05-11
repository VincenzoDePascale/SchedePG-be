package com.VincenzoDePascale.schedePG.service;

import java.util.List;

import org.springframework.beans.factory.ObjectProvider;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import com.VincenzoDePascale.schedePG.auth.entity.User;
import com.VincenzoDePascale.schedePG.auth.repository.UserRepository;

import jakarta.persistence.EntityExistsException;
import jakarta.persistence.EntityNotFoundException;

@Service
public class GiocatoreService {

	@Autowired
	private UserRepository giocatoreRepo;

	@Autowired
	@Qualifier("fakeGiocatore")
	private ObjectProvider<User> fakeEmployeeProvider;

	@Autowired
	@Qualifier("GiocatoreRandom")
	private ObjectProvider<User> randomGiocatoreProvider;

	// SAVE

	public User saveGiocatore(User u) {
		if (giocatoreRepo.existsByEmail(u.getEmail()) || giocatoreRepo.existsByUsername(u.getUsername())) {
			throw new EntityExistsException("email o username già presente");
		}
		giocatoreRepo.save(u);
		return u;
	}

	public void saveFakeGiocatore() {
		saveGiocatore(fakeEmployeeProvider.getObject());
	}

	// SEARCH standard

	public List<User> findAllGiocatore() {
		return (List<User>) giocatoreRepo.findAll();
	}
	
	public Page<User> findAllGiocatorePageable(Pageable pageable) {
		return (Page<User>) giocatoreRepo.findAll(pageable);
	}
	
	public User findById(Long id) {
		if (!giocatoreRepo.existsById(id)) {
			throw new EntityNotFoundException("Giocatore non trovato con ID: " + id);
		}
		return giocatoreRepo.findById(id).get();
	}

	//ricerca per email COMPLETA
//	public Giocatore findByEmail(String email) {
//		if (!giocatoreRepo.existsByEmail(email)) {
//			throw new EntityNotFoundException("Email non trovata: " + email);
//		}
//		return giocatoreRepo.findByEmail(email);
//	}
	
	//ricerca per parte dell'email
	public List<User> findByPartEmail(String email) {
		return (List<User>) giocatoreRepo.searchByPartEmail(email);
	}

	//ricerca per nome COMPLETO
//	public Giocatore findByUsername(String username) {
//		if (!giocatoreRepo.existsByUsername(username)) {
//			throw new EntityNotFoundException("Username non trovato: " + username);
//		}
//		return giocatoreRepo.findByUsername(username);
//	}
	
	//ricerca per parte del nome
		public List<User> findByPartUsername(String username) {
			return (List<User>) giocatoreRepo.searchByPartUsername(username);
		}

	
	
	//random
//	public User findGiocatoreRandom() {
//		return giocatoreRepo.findGiocatoreRandom();
//	}

	// UPDATE

	public User updateGiocatore(User giocatore) {
		if (!giocatoreRepo.existsById(giocatore.getId())) {
			throw new EntityNotFoundException("Giocatore non trovato con ID: " + giocatore.getId());
		}
		giocatoreRepo.save(giocatore);
		return giocatore;
	}

	// DELETE

	public String removeGiocatore(Long id) {
		if (!giocatoreRepo.existsById(id)) {
			throw new EntityNotFoundException("Giocatore non trovato con ID: " + id);
		}
		giocatoreRepo.deleteById(id);
		return "Giocatore eliminato";
	}

}
