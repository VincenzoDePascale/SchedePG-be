package com.VincenzoDePascale.schedePG.payload;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Setter
@Getter
@NoArgsConstructor
@AllArgsConstructor
public class updateNotePgDto {
	
	private Long idPg;
	private String background;
	private String tratti_caratteriali;
	private String ideali;
	private String legami;
	private String difetti;

}
