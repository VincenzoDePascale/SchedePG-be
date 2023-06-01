package com.VincenzoDePascale.schedePG.payload;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Setter
@Getter
@NoArgsConstructor
@AllArgsConstructor
public class updateIspirazionePgDto {
	
	private Long idPg;
	private boolean ispirazione;
	
	public boolean getIspirazione() {
		return ispirazione;
	}

}
