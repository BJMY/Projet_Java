package dominion.card.base;
import java.util.*;
import dominion.*;
import dominion.card.*;

/**
 * Carte Festin (Feast)
 * 
 * Écartez cette carte.
 * Recevez une carte coûtant jusqu'à 5 Pièces.
 */
public class Feast extends ActionCard {
	
	public Feast(){
	
		super("Feast", 4);
		
	}
	
	public void play(Player p){
		
		p.getGame().addToTrash(this);
		p.removeFromHand(this);
		
	boolean trouve = false;
		int i = 0;

		while (!trouve && i<p.getGame().availableSupplyCards().size()) {
			Card c = p.getGame().availableSupplyCards().get(i);
			
			if (c.getCost() == 5) {
				
				p.addToDiscard(c);
				p.getGame().availableSupplyCards().remove(i);
				trouve = true;
			}
			i++;
		}
		

		
	}
	
	
}
