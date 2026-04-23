package jeu;

import java.util.ArrayList;
import java.util.List;

import cartes.Carte;

public class MainJoueur {

	private List<Carte> cartes;

	public MainJoueur() {
		this.cartes = new ArrayList<>();
	}

	public void prendre(Carte carte) {
		cartes.add(carte);
	}

	public void jouer(Carte carte) {
		assert cartes.contains(carte) : "La carte n'est pas dans la main";
		cartes.remove(carte);
	}

	@Override
	public String toString() {
		return "Main du joueur : " + cartes;
	}

}
