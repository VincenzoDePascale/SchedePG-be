package com.VincenzoDePascale.schedePG.service;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.VincenzoDePascale.schedePG.auth.repository.UserRepository;
import com.VincenzoDePascale.schedePG.list.Allineamenti;
import com.VincenzoDePascale.schedePG.list.Classi;
import com.VincenzoDePascale.schedePG.list.Razze;
import com.VincenzoDePascale.schedePG.model.Pg;
import com.VincenzoDePascale.schedePG.repository.PgRepository;

import jakarta.persistence.EntityNotFoundException;

@Service
public class PgService {

	@Autowired
	private PgRepository pgRepo;
	
	@Autowired
	private UserRepository userRepo;

	// SAVE

	public Pg savePg(Pg pg) {
		return pgRepo.save(pg);
	}
	
	// SEARCH

	public List<Pg> findAllPg() {
		return (List<Pg>) pgRepo.findAll();
	}

	public Pg findById(Long id) {
		if (!pgRepo.existsById(id)) {
			throw new EntityNotFoundException("Personaggio non trovato con ID: " + id);
		}
		return pgRepo.findById(id).get();
	}

	public List<Pg> searchPgBygiocatoreUsername(String username) {
		if (!userRepo.existsByUsername(username)) {
			throw new EntityNotFoundException("questo giocatore non ha personaggi: " + username);
		}
		return pgRepo.searchPgBygiocatoreUsername(username);
	}

	//ricerca per nome COMPLETO
//	public List<Pg> findByNomePG(String nomePG) {
//		if (!pgRepo.existsByNomePG(nomePG)) {
//			throw new EntityNotFoundException("Non ci sono personaggi con questo nome: " + nomePG);
//		}
//		return pgRepo.findByNomePG(nomePG);
//	}
	
	//ricerca per parte del nome
	public List<Pg> findByNomePG(String nomePG) {
		return (List<Pg>) pgRepo.searchByPartNomePg(nomePG);
	}

	public List<Pg> findByRazza(Razze razza) {
		if (!pgRepo.existsByRazza(razza)) {
			throw new EntityNotFoundException("Non ci sono personaggi con questa razza: " + razza);
		}
		return pgRepo.findByRazza(razza);
	}

	public List<Pg> findByClasse(Classi classe) {
		if (!pgRepo.existsByClasse(classe)) {
			throw new EntityNotFoundException("Non ci sono personaggi con questa classe: " + classe);
		}
		return pgRepo.findByClasse(classe);
	}

	public List<Pg> findByAllineamento(Allineamenti allineamento) {
		if (!pgRepo.existsByAllineamento(allineamento)) {
			throw new EntityNotFoundException("Non ci sono personaggi con questo allineamento: " + allineamento);
		}
		return pgRepo.findByAllineamento(allineamento);
	}

	public List<Pg> findByLivello(int livello) {
		if (!pgRepo.existsByLivello(livello)) {
			throw new EntityNotFoundException("non ci sono personaggi con questo allineamento: " + livello);
		}
		return pgRepo.findByLivello(livello);
	}

	//UPDATE
	
	public Pg updatePg(Pg pg) {
		if (!pgRepo.existsById(pg.getId())) {
			throw new EntityNotFoundException("Giocatore non trovato con ID: " + pg.getId());
		}
		pgRepo.save(pg);
		return pg;
	}
	
	// DELATE

	public String deletePG(Long id) {
		if (!pgRepo.existsById(id)) {
			throw new EntityNotFoundException("PG non trovato con ID: " + id);
		}
		pgRepo.deleteById(id);
		return "PG eliminato";
	}

}
