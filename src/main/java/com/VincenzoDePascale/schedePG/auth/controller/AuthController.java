package com.VincenzoDePascale.schedePG.auth.controller;

import com.VincenzoDePascale.schedePG.auth.entity.User;
import com.VincenzoDePascale.schedePG.auth.payload.JWTAuthResponse;
import com.VincenzoDePascale.schedePG.auth.payload.LoginDto;
import com.VincenzoDePascale.schedePG.auth.payload.RegisterDto;
import com.VincenzoDePascale.schedePG.auth.repository.UserRepository;
import com.VincenzoDePascale.schedePG.auth.service.AuthService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

//@CrossOrigin(origins =  "*", maxAge = 360000)
@CrossOrigin
@RestController
@RequestMapping("/api/auth")
public class AuthController {

    private AuthService authService;
    @Autowired
    UserRepository userRepo;

    public AuthController(AuthService authService) {
        this.authService = authService;
    }

    // Build Login REST API
    @PostMapping(value = {"/login", "/signin"})
    public ResponseEntity<JWTAuthResponse> login(@RequestBody LoginDto loginDto){
           	
    	String token = authService.login(loginDto);
    	User u = userRepo.findByUsername(loginDto.getUsername()).get();
    	
        JWTAuthResponse jwtAuthResponse = new JWTAuthResponse();
        jwtAuthResponse.setUsername(loginDto.getUsername());
        jwtAuthResponse.setEmail(u.getEmail());
        jwtAuthResponse.setAccessToken(token);
        jwtAuthResponse.setRoles(u.getRoles());
        jwtAuthResponse.setListaPG(u.getPersonaggi());
        //aggiungi roba dell utente alla risposta da userRepository

        return ResponseEntity.ok(jwtAuthResponse);
    }

    // Build Register REST API
    @CrossOrigin
    @PostMapping(value = {"/register", "/signup"})
    public ResponseEntity<String> register(@RequestBody RegisterDto registerDto){
        String response = authService.register(registerDto);
        return new ResponseEntity<>(response, HttpStatus.CREATED);
    }
}
