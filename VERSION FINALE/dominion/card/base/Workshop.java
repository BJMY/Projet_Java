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
		
		List<String> choices=new ArrayList<String>();
		
		for(Card c : p.getGame().availableSupplyCards()){
			
			if(c.getCost()<=4){
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
