package jeu;

import java.util.LinkedList;
import java.util.List;

import cartes.Bataille;
import cartes.Borne;
import cartes.Limite;

public class ZoneDeJeu {
	
	private List<Limite> pileLimite;
	private List<Bataille> pileBataille;
	private List<Borne> bornes;
	
	public ZoneDeJeu(){
		this.pileLimite = new LinkedList<Limite>();
		this.pileBataille = new LinkedList<Bataille>();
		this.bornes = new LinkedList<Borne>();
	}
	
	
}
