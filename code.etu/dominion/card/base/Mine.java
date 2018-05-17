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


		System.out.println("Entree playMine");
		boolean termine=false;
		System.out.println("entree boucle");
		while(!termine){
			
			
			if(p.getGame().availableSupplyCards().get(0).getName().equals("Gold") || p.getGame().availableSupplyCards().get(0).getName().equals("Silver") || p.getGame().availableSupplyCards().get(0).getName().equals("Copper") && p.getGame().availableSupplyCards().get(0).getCost()<=p.getTreasureCards().get(0).getCost()){
				
				p.addInHand(p.getGame().availableSupplyCards().get(0));
				termine=true;
				
			}
			
			
			
		}
		System.out.println("Fin boucle");
		
		p.getGame().addToTrash(p.getTreasureCards().get(0));
		p.removeFromHand(p.getTreasureCards().get(0));
		System.out.println("Sortie playMine");
		
	}
}
