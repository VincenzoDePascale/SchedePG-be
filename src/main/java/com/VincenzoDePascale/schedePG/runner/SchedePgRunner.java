package com.VincenzoDePascale.schedePG.runner;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.stereotype.Component;

import com.VincenzoDePascale.schedePG.auth.entity.ERole;
import com.VincenzoDePascale.schedePG.auth.entity.Role;
import com.VincenzoDePascale.schedePG.auth.entity.User;
import com.VincenzoDePascale.schedePG.auth.repository.RoleRepository;
import com.VincenzoDePascale.schedePG.auth.repository.UserRepository;
import com.VincenzoDePascale.schedePG.list.Classi;
import com.VincenzoDePascale.schedePG.list.Dadi;
import com.VincenzoDePascale.schedePG.list.Linguaggi;
import com.VincenzoDePascale.schedePG.list.Razze;
import com.VincenzoDePascale.schedePG.list.Allineamenti;
import com.VincenzoDePascale.schedePG.model.Pg;
import com.VincenzoDePascale.schedePG.service.GiocatoreService;
import com.VincenzoDePascale.schedePG.service.PgService;
import com.VincenzoDePascale.schedePG.service.RoleService;



@Component
public class SchedePgRunner implements ApplicationRunner {

	@Autowired
	RoleService roleService;
	
	@Autowired
	GiocatoreService giocatoreService;

	@Autowired
	PgService pgService;

	@Override
	public void run(ApplicationArguments args) throws Exception {
		System.out.println("SchedePgRunner...START");

		System.out.println("SchedePgRunner...END");
	}

}
