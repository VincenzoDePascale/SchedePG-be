package com.VincenzoDePascale.schedePG.repository;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.VincenzoDePascale.schedePG.auth.entity.User;
import com.VincenzoDePascale.schedePG.list.Allineamenti;
import com.VincenzoDePascale.schedePG.list.Classi;
import com.VincenzoDePascale.schedePG.list.Dadi;
import com.VincenzoDePascale.schedePG.list.Razze;
import com.VincenzoDePascale.schedePG.model.Pg;

@Repository
public interface PgRepository extends CrudRepository<Pg, Long> {

	//id
	public Optional<Pg> findById(Long Id);
	boolean existsById(Long Id);

	//giocatore
	boolean existsByGiocatore(User giocatore);
	List<Pg> findByGiocatore(User giocatore);

	//nomepg
	boolean existsByNomePG(String nomePG);
	List<Pg> findByNomePG(String nomePG);
	
	@Query(value= "Select pg FROM Pg pg WHERE LOWER(pg.nomePG) Like LOWER('%' || :nomePG || '%')")
    public List<Pg> searchByPartNomePg(String nomePG);
	
	//razza
	boolean existsByRazza(Razze razza);
	List<Pg> findByRazza(Razze razza);

	//classe
	boolean existsByClasse(Classi classe);
	List<Pg> findByClasse(Classi classe);

	//allineamento
	boolean existsByAllineamento(Allineamenti allineamento);
	
	//@Query(value = "Select pg FROM Pg pg WHERE LOWER(pg.allineamento) Like LOWER('%' || :allineamento || '%')")
	List<Pg> findByAllineamento(Allineamenti allineamento);

	//livello
	boolean existsByLivello(int livello);
	List<Pg> findByLivello(int livello);	
	
	@Query(value= "Select pg FROM Pg pg WHERE pg.giocatore.username= :username")
    public List<Pg> searchPgBygiocatoreUsername(String username);
		
}
