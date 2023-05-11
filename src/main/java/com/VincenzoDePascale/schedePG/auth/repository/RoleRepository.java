package com.VincenzoDePascale.schedePG.auth.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.VincenzoDePascale.schedePG.auth.entity.ERole;
import com.VincenzoDePascale.schedePG.auth.entity.Role;

import java.util.Optional;

@Repository
public interface RoleRepository extends JpaRepository<Role, Long> {
    
	Optional<Role> findByRoleName(ERole roleName);

}
