package utils;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.ListIterator;

public class GestionCartes {

	public static <T> T extraire(List<T> liste) {
		int i =(int)(Math.random() * liste.size());
		return liste.remove(i);
	}
	
	public static <T> T extraireAvecIterator(List<T> liste) {
		int i =(int)(Math.random() * liste.size());
		ListIterator<T> iterator = liste.listIterator();
		T element = null;
		for (int j = 0; j <= i; j++) {
			element = iterator.next();
		}
		iterator.remove();
		return element;
	}
	
	public static <T> List<T> melanger(List<T> liste) {
		List<T> copie = new ArrayList<>(liste);
		List<T> resultat = new ArrayList<>();
		while(!copie.isEmpty()) {
			resultat.add(extraire(copie));
		}
		return resultat;
	}
	
	public static <T> boolean verifierMelange(List<T> liste1,List<T> liste2) {
		if (liste1.size()!=liste2.size()) {
			return false;
		}
		for (T element : liste1) {
			if (Collections.frequency(liste1, element) != Collections.frequency(liste2, element)) {
				return false;
			}
		}
		return true;
	}
	
	public static <T> List<T> rassembler(List<T> liste){
		List<T> copie = new ArrayList<>();
		
		for(T element : liste) {
			if (!copie.contains(element)) {
				for (T e :liste) {
					if (e.equals(element)) {
						copie.add(e);
					}
				}
			}
		}
		return copie;
	}
	
	public static <T> boolean verifierRassemblement (List<T> liste) {
		//pour parcourir toute la liste
		ListIterator<T> iterator1 = liste.listIterator();
		
		//tant qu'il reste des trucs dans la liste
		while (iterator1.hasNext()) {
			//elem a comparer
			T element1 = iterator1.next();
			//pour creer iterateur 2 qui va parcours le reste de la liste
			int indexSuivant = iterator1.nextIndex();
			
			//on recup l'elem d'apres s'il y en a un
			if (iterator1.hasNext()) {
				T suivant = iterator1.next();
				
				//si on quitte le bloc d'elem on verif s'il y en a un apres
				if(!element1.equals(suivant)) {
					ListIterator<T> iterator2 = liste.listIterator(indexSuivant);
					
					//on parcours la suite de la liste en recuperant chaque elem pour le comparer
					while (iterator2.hasNext()) {
						T element2 = iterator2.next();
						if (element1.equals(element2)) {
							return false;
						}
					}
					//On annule le next pour voir tout les elems
					iterator1.previous();
				}
			}
		}
		return true;
	}
	
	
}
