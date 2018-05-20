package dominion.card.base;
import java.util.*;
import dominion.*;
import dominion.card.*;

/**
 * Carte Prêteur sur gages (Moneylender)
 * 
 * Écartez une carte Cuivre de votre main.
 * Dans ce cas, +3 Pièces.
 */
public class Moneylender extends ActionCard {
	
	

	public Moneylender(){
		
		super("Moneylender",4);
		
	}
	
	public void play(Player p){
		
		for(Card c : p.cardsInHand()){
			
			if(c.getName().equals("Copper")){
				
				p.getGame().addToTrash(c);
				p.removeFromHand(c);
				p.incrementMoney(3);
				
			}
			
			
		}
		
		
		
	}
	
	
	
	
	
	
	
}
