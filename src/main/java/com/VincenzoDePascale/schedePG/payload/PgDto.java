package com.VincenzoDePascale.schedePG.payload;

import com.VincenzoDePascale.schedePG.list.Classi;
import com.VincenzoDePascale.schedePG.list.Razze;

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
	private int forza;
	private int destrezza;
	private int costituzione;
	private int intelligenza;
	private int saggezza;
	private int carisma;
	private Razze razza;
	private Classi classe;
	private int livello;

}
