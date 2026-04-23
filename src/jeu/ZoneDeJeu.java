package jeu;

import java.util.LinkedList;
import java.util.List;

import cartes.Bataille;
import cartes.Borne;
import cartes.Carte;
import cartes.FinLimite;
import cartes.Limite;

public class ZoneDeJeu {

	private List<Limite> pileLimite = new LinkedList<Limite>();
	private List<Bataille> pileBataille = new LinkedList<Bataille>();
	private List<Borne> pileBornes = new LinkedList<Borne>();


	public int donnerLimitationVitesse() {
		if (pileLimite.isEmpty() || pileLimite.get(pileLimite.size() - 1) instanceof FinLimite) {
			return 200;
		}
		return 50;
	}

	public int donnerKmParcourus() {
		int total = 0;
		for (Borne borne : pileBornes) {
			total += borne.getKm();
		}
		return total;
	}
	
	public void deposer(Carte carte) {

	    if (carte instanceof Borne) {
	        pileBornes.add((Borne) carte);
	    }
	    else if (carte instanceof Limite || carte instanceof FinLimite) {
	        pileLimite.add((Limite) carte);
	    }
	    else if (carte instanceof Bataille) {
	        pileBataille.add((Bataille) carte);
	    }
	}
	
	public boolean peutAvancer() {
		Bataille sommet = pileBataille.get(0);
		return (!pileBataille.isEmpty() && sommet.equals(Cartes.FEU_VERT));
	
	}
}