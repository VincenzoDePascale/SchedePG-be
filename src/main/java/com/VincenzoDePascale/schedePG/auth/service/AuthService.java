package com.VincenzoDePascale.schedePG.auth.service;

import com.VincenzoDePascale.schedePG.auth.payload.LoginDto;
import com.VincenzoDePascale.schedePG.auth.payload.RegisterDto;

public interface AuthService {
    
	String login(LoginDto loginDto);
    String register(RegisterDto registerDto);
    
}
