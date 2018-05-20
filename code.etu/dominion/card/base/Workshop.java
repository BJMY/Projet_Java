package dominion.card.base;
import java.util.*;
import dominion.*;
import dominion.card.*;

/**
 * Carte Atelier (Workshop)
 * 
 * Recevez une carte coûtant jusqu'à 4 Pièces.
 */
public class Workshop extends ActionCard {
	
	public Workshop() {
		super("Workshop", 3);
	}
	
	public void play(Player p) {
		

		boolean trouve = false;
		int i = 0;

		while (!trouve && i<p.getGame().availableSupplyCards().size()) {
			Card c = p.getGame().availableSupplyCards().get(i);
			
			if (c.getCost() <= 4 && c.getCost()>0) {
				
				p.addToDiscard(c);
				p.getGame().availableSupplyCards().remove(i);
				trouve = true;
			}
			i++;
		}
		

	}
}
