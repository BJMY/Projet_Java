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
		
		List<String> choices=new ArrayList<String>();
		
		for(Card c : p.getGame().availableSupplyCards()){
			
			if(c.getCost()<=5){
			choices.add(c.getName());
			}
		}
		
		String choix= p.choose("Saisissez le nom de la carte à gagner: ",choices,false);
		
		for(Card c : p.getGame().availableSupplyCards()){
			
			if(c.getName().equals(choix)){
				
				p.addToDiscard(c);
				p.getGame().removeFromSupply(c.getName());
				
			}
			
		}
				

		
	}
	
	
}
