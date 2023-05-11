package com.VincenzoDePascale.schedePG.configuration;

import java.util.Locale;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;
import org.springframework.context.annotation.Scope;

import com.VincenzoDePascale.schedePG.auth.entity.User;
import com.github.javafaker.Faker;

@Configuration
@PropertySource("classpath:application.properties")
public class GiocatoreConfiguration {

	@Bean
	@Scope("prototype")
	public User GiocatoreStandard(String email, String username, String password) {
		return User.builder()
				.email(email)
				.username(username)
				.password(password)
				.Personaggi(null)
				.build();
	}
	
	@Bean
	@Scope("prototype")
	public User fakeGiocatore() {
		Faker fake = new Faker(new Locale("it-IT"));
		User u = new User();
		u.setUsername(fake.name().username());
		u.setEmail(u.getUsername() + "@example.com");
		u.setPassword("PW_" + u.getUsername());
		u.setPersonaggi(null);
		return u;
	}

}
