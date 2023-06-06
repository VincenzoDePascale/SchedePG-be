package com.VincenzoDePascale.schedePG.payload;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Setter
@Getter
@NoArgsConstructor
@AllArgsConstructor
public class updateStatistichePgDto {
	
	private Long idPg;
	private int forza;
	private int destrezza;
	private int costituzione;
	private int intelligenza;
	private int saggezza;
	private int carisma;

}
