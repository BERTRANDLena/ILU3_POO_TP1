package jeu;

import cartes.Carte;

import java.util.ConcurrentModificationException;
import java.util.Iterator;
import java.util.NoSuchElementException;

public class Sabot implements Iterable<Carte> {

	private int nbCartes;
	private Carte[] cartes;
	private int nombreOperations = 0;

	public Sabot(Carte[] cartes) {
		this.cartes = cartes;
		this.nbCartes = cartes.length;
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
		nombreOperations++;
	}

	public Carte piocher() {
		if (estVide()) {
			throw new NoSuchElementException("Sabot vide");
		}
		Iterator<Carte> it = iterator();
		Carte carte = it.next();
		it.remove();
		return carte;

	}

	@Override
	public Iterator<Carte> iterator() {

		return new Iterator<Carte>() {

			private int indiceIterateur = 0;
			private boolean nextEffectue = false;
			private int nombreOperationsReference = nombreOperations;

			@Override
			public boolean hasNext() {
				return indiceIterateur < nbCartes;
			}

			@Override
			public Carte next() {
				if (!hasNext()) {
					throw new NoSuchElementException();
				}
				verificationConcurrence();
				nextEffectue = true;
				return cartes[indiceIterateur++];
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

				cartes[nbCartes - 1] = null;
				nbCartes--;
				indiceIterateur--;
				nextEffectue = false;
				nombreOperations++;
				nombreOperationsReference++;
			}
			
			private void verificationConcurrence(){
				if (nombreOperations != nombreOperationsReference)
				throw new ConcurrentModificationException();
				}
		};
	}
}