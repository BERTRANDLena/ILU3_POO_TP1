package utils;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.ListIterator;
import java.util.Random;

public class GestionCartes {

	private static Random random = new Random();
	
	private GestionCartes() {
		throw new IllegalStateException("Utility Class");
	}
	
	public static <T> T extraire(List<T> liste) {
		int i = random.nextInt(liste.size());
		return liste.remove(i);
	}

	public static <T> T extraireAvecIterator(List<T> liste) {
		int i = random.nextInt(liste.size());
		ListIterator<T> iterator = liste.listIterator(i);
		T element = null;
		iterator.remove();
		return element;
	}

	public static <T> List<T> melanger(List<T> liste) {
		List<T> copie = new ArrayList<>(liste);
		List<T> resultat = new ArrayList<>();
		while (!copie.isEmpty()) {
			resultat.add(extraire(copie));
		}
		return resultat;
	}

	public static <T> boolean verifierMelange(List<T> liste1, List<T> liste2) {
		if (liste1.size() != liste2.size()) {
			return false;
		}
		for (T element : liste1) {
			if (Collections.frequency(liste1, element) != Collections.frequency(liste2, element)) {
				return false;
			}
		}
		return true;
	}

	public static <T> List<T> rassembler(List<T> liste) {
		List<T> copie = new ArrayList<>();

		for (T element : liste) {
			while(Collections.frequency(copie, element)<Collections.frequency(liste, element)) {
				copie.add(element);
			}
		}
		return copie;
	}

	public static <T> boolean verifierRassemblement(List<T> liste) {
		ListIterator<T> iterator1 = liste.listIterator();

		while (iterator1.hasNext()) {
			T element1 = iterator1.next();
			int indexSuivant = iterator1.nextIndex();

			ListIterator<T> iterator2 = liste.listIterator(indexSuivant);
			boolean dejaVu = false;
			
			while (iterator2.hasNext()) {
				T element2 = iterator2.next();
				if (element1.equals(element2)) {
					dejaVu = true;
				}else if (dejaVu) {
					return false;
				}
			}
		}
		return true;
	}

}
