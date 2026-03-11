package testsFonctionnels;

import java.util.Iterator;

import cartes.Carte;
import cartes.JeuDeCartes;
import jeu.Sabot;

public class TestSabot {

	public static void main(String[] args) {
		
		JeuDeCartes jeu = new JeuDeCartes();
		Carte[] cartes = jeu.donnerCartes();
		Sabot sabot = new Sabot(cartes);
		
		//Test on pioche jusqu'à ce que le sabot soit vide
		while (!sabot.estVide()) {
            Carte c = sabot.piocher();
            System.out.println("je pioche " + c);
        }
		
		//Test avec ietrateur et remove
		sabot = new Sabot(cartes);
		Iterator<Carte> it = sabot.iterator();
        while (it.hasNext()) {
            Carte c = it.next();
            System.out.println("je pioche " + c);
            it.remove();
        }
        
        
		
		
	}
	
}
