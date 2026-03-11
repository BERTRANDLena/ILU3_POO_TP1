package jeu;

import cartes.Carte;
import java.util.Iterator;
import java.util.NoSuchElementException;

// Où gerer les execptions pour la 1.c

public class Sabot implements Iterable<Carte> {

	private int nbCartes;
	private Carte[] cartes;

	private int indiceIterateur = 0;
	private boolean nextEffectue = false;

	public Sabot(Carte[] cartes) {
		this.cartes = cartes;
		this.nbCartes = nbCartes;
	}

	public boolean estVide() {
		return nbCartes == 0;
	}

	public void ajouterCarte(Carte carte) {
		if (nbCartes >= cartes.length) {
			throw new IllegalStateException("Capacité dépacée");
		}
		cartes[nbCartes] = carte;
		nbCartes++;
	}

	public Carte piocher() {
		if (estVide()) {
			throw new NoSuchElementException("Sabot vide");
		}
		Iterator<Carte> it = iterator();
		Carte c = it.next();
		it.remove();
		return c;

	}

	@Override
	public Iterator<Carte> iterator() {
		return new Iterator<Carte>() {

			@Override
			public boolean hasNext() {
				// TODO Auto-generated method stub
				return false;
			}

			@Override
			public Carte next() {
				// TODO Auto-generated method stub
				return null;
			}
			
		
			@Override
			public void remove() {
				if (!nextEffectue) {
					throw new IllegalStateException("next() n'a pas été appelé !");
				}
				int removeIndex = indiceIterateur - 1;
				for (int i = removeIndex; i < nbCartes - 1; i++) {
					cartes[i] = cartes[i + 1];
				}

				cartes[nbCartes - 1] = null; // libère la dernière case
				nbCartes--;                  // décrémente le nombre de cartes
				indiceIterateur--;           // recule l’indice pour continuer l’itération
				nextEffectue = false;        // empêche remove() avant le prochain next()
			}
		};
	}
}
