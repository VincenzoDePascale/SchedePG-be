package com.VincenzoDePascale.schedePG.payload;

import java.util.List;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Setter
@Getter
@NoArgsConstructor
@AllArgsConstructor
public class updateLinguaggiPgDto {
	
	private Long idPg;
	public List<String> linguaggi;

}