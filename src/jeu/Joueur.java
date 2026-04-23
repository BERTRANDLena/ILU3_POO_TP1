package jeu;

import cartes.Bataille;
import cartes.Borne;
import cartes.Carte;
import cartes.FinLimite;
import cartes.Limite;

public class Joueur {

	private String nom;
	private ZoneDeJeu zoneDeJeu;
	private MainJoueur main;

	public Joueur(String nom, ZoneDeJeu zoneDeJeu, MainJoueur main) {
		this.nom = nom;
		this.zoneDeJeu = zoneDeJeu;
		this.main = main;
	}

	public String getNom() {
		return nom;
	}

	public ZoneDeJeu getZoneDeJeu() {
		return zoneDeJeu;
	}

	public MainJoueur getMainJoueur() {
		return main;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null || getClass() != obj.getClass())
			return false;

		Joueur autre = (Joueur) obj;
		return nom != null && nom.equals(autre.nom);
	}

	@Override
	public String toString() {
		return nom;
	}

	public void donner(Sabot sabot, MainJoueur main) {
		Carte carte = sabot.piocher();
		main.prendre(carte);
	}

	public Carte prendreCarte(Sabot sabot) {
		Carte carte = sabot.piocher();
		if (carte != null) {
			main.prendre(carte);
		}
		return carte;
	}

	public int donnerKmParcourus() {
		return zoneDeJeu.donnerKmParcourus();
	}
	
	public void deposer(Carte carte) {
		if (carte == null) {
	        return;
	    }
		zoneDeJeu.deposer(carte);    
	}
}
