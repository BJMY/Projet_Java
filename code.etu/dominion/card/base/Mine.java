package dominion.card.base;
import java.util.*;
import dominion.*;
import dominion.card.*;

/**
 * Carte Mine
 * 
 * Écartez une carte Trésor de votre main. Recevez une carte Trésor coûtant jusqu'à 3 Pièces de plus ; ajoutez cette carte à votre main.
 */
public class Mine extends ActionCard {
	
	public Mine(){
		
		super("Mine",5);
		
	}
	
	

	public void play(Player p){


		
		boolean termine=false;

		while(!termine){
			
			
			if(p.getGame().availableSupplyCards().get(0).getName()=="Treasure" && p.getGame().availableSupplyCards().get(0).getCost()<=p.getTreasureCards().get(0).getCost()){
				
				p.addInHand(availableSupplyCards().get(0))
				termine=true;
				
			}
			
			
			
		}
		
		p.getGame().addToTrash(p.getTreasureCards().get(0));
		p.removeFromHand(p.getTreasureCards().get(0));
	
		
	}
}
