package com.VincenzoDePascale.schedePG.payload;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Setter
@Getter
@NoArgsConstructor
@AllArgsConstructor
public class updateArmaturaPgDto {
	
	private Long idPg;
	private String armatura;
	private String scudo;

}