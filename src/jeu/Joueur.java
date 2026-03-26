package jeu;

import cartes.Carte;

public class Joueur {
	
	private String nom;
	private ZoneDeJeu zoneDeJeu;
	
	public Joueur(String nom, ZoneDeJeu zoneDeJeu) {
		this.nom = nom;
		this.zoneDeJeu = zoneDeJeu;
	}
	
	public String getNom() {
		return nom;
	}
	public ZoneDeJeu getZoneDeJeu() {
		return zoneDeJeu;
	}
	
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null || getClass() != obj.getClass())
			return false;

		Joueur autre = (Joueur) obj;
		return nom!=null && nom.equals(autre.nom);
	}

	@Override
	public String toString() {
		return nom;
	}
	
	

}
