package jeu;

import java.util.ArrayList;
import java.util.List;

import cartes.Borne;
import cartes.Carte;

public class ZoneDeJeu {
	
	private List<Carte> pileLimite;
	private List<Carte> pileBataille;
	private List<Borne> bornes;
	
	public ZoneDeJeu(){
		this.pileLimite = new ArrayList<Carte>();
		this.pileLimite = new ArrayList<Carte>();
		this.bornes = new ArrayList<Borne>();
	}
	
	
}
