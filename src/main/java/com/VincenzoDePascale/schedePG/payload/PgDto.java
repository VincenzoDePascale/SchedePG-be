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
public class PgDto {
	
	private String nomeUtente;
	private String nomePersonaggio;
	private String allineamento;
	private int forza;
	private int destrezza;
	private int costituzione;
	private int intelligenza;
	private int saggezza;
	private int carisma;
	private String razza;
	private String classe;
	private List<String> abilitaAttive;
	private int livello;
	private String background;
	private String tratti_caratteriali;
	private String ideali;
	private String legami;
	private String difetti;

}
