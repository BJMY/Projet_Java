package dominion.card.base;
import java.util.*;
import dominion.*;
import dominion.card.*;

/**
 * Carte Rénovation (Remodel)
 * 
 * Écartez une carte de votre main.
 * Recevez une carte coûtant jusqu'à 2 Pièces de plus que la carte écartée.
 */
public class Remodel extends ActionCard {
	public Remodel() {
		super("Remodel", 4);
	}
	public void play(Player p) {
		
		

		List<String> choices = new ArrayList<String>();
		for(Card c : p.cardsInHand()) {
			choices.add(c.getName());
		}
		
		String choix = p.choose("Saisissez le nom de la carte a ecarter de votre main", choices, false);
		boolean trouve = false;
		for(Card c : p.cardsInHand()) {
			if (c.getName() == choix && !trouve) {
				p.getGame().addToTrash(c);
				p.removeFromHand(c);

				int i = 0;
				while (!trouve && i<p.getGame().availableSupplyCards().size()) {
					Card d = p.getGame().availableSupplyCards().get(i);
					if (d.getCost() == c.getCost() + 2) {
						p.addToDiscard(d);
						trouve = true;
						p.getGame().removeFromSupply(d.getName());
					}
					i++;
				}
			}
		}
		
	}
}
