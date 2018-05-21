package dominion.card.base;
import java.util.*;
import dominion.*;
import dominion.card.*;

/**
 * Carte Aventurier (Adventurer)
 * 
 * Dévoilez des cartes de votre deck jusqu'à ce que 2 cartes Trésor soient dévoilées.
 *  Ajoutez ces cartes Trésor à votre main et défaussez les autres cartes dévoilées.
 */
public class Adventurer extends ActionCard {
	
	public Adventurer(){
		
		super("Adventurer",6);
		
	}
	
	public void play(Player p){
		
		int cpt = 0;
		while (!p.totalCards().isEmpty() || cpt != 2) {
			if (p.totalCards().get(0).getName().equals("Gold") || p.totalCards().get(0).getName().equals("Silver") || p.totalCards().get(0).getName().equals("Copper")) {
				p.addInHand(p.totalCards().get(0));
				cpt++;
			}
			p.getGame().addToTrash(p.totalCards().get(0));
		}
	}
	
}
