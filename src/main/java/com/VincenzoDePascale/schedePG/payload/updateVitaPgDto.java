package com.VincenzoDePascale.schedePG.payload;


import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Setter
@Getter
@NoArgsConstructor
@AllArgsConstructor
public class updateVitaPgDto {
	
	private Long idPg;
	public int pfMassimi;
	public int pfAttuali;
	public int pfTemporanei;

}
