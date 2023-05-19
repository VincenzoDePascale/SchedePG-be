package com.VincenzoDePascale.schedePG.auth.payload;



import java.util.List;
import java.util.Set;

import com.VincenzoDePascale.schedePG.auth.entity.Role;
import com.VincenzoDePascale.schedePG.auth.entity.User;
import com.VincenzoDePascale.schedePG.model.Pg;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Setter
@Getter
@NoArgsConstructor
@AllArgsConstructor
public class JWTAuthResponse {
	private String username;
	private String email;
    private String accessToken;
    private String tokenType = "Bearer";
    private Set<Role> roles;
    private List<Pg> listaPG;
}
