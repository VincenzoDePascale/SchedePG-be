package com.VincenzoDePascale.schedePG.payload;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Setter
@Getter
@NoArgsConstructor
@AllArgsConstructor
public class updateRicchezzaPgDto {
	
	private Long idPg;
	private int moneteRame;
	private int moneteArgento;
	private int moneteOro;
	private int monetePlatino;

}
