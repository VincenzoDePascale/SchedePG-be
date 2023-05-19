package com.VincenzoDePascale.schedePG.auth.repository;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.stereotype.Repository;

import com.VincenzoDePascale.schedePG.auth.entity.User;

import java.util.List;
import java.util.Optional;

@Repository
public interface UserRepository extends JpaRepository<User, Long>, PagingAndSortingRepository<User, Long> {

	Optional<User> findByEmail(String email);

	Optional<User> findByUsernameOrEmail(String username, String email);

	Optional<User> findByUsername(String username);

	Boolean existsByUsername(String username);

	Boolean existsByEmail(String email);

	Page<User> findAll(Pageable pageable);

	@Query(value = "SELECT g FROM User g ORDER BY RANDOM() LIMIT 1")
	User findGiocatoreRandom();

	boolean existsById(Long Id);

	@Query(value = "Select g FROM User g WHERE LOWER(g.username) Like LOWER('%' || :username || '%')")
	public List<User> searchByPartUsername(String username);

	@Query(value = "Select g FROM User g WHERE LOWER(g.email) Like LOWER('%' || :email || '%')")
	public List<User> searchByPartEmail(String email);

}
