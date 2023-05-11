package com.VincenzoDePascale.schedePG.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.VincenzoDePascale.schedePG.auth.entity.ERole;
import com.VincenzoDePascale.schedePG.auth.entity.Role;
import com.VincenzoDePascale.schedePG.auth.repository.RoleRepository;

@Service
public class RoleService {
	@Autowired
	private RoleRepository rolerepo;

	public Role findByRoleName(ERole role) {
		return rolerepo.findByRoleName(role).get();

	}
}
