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
		
		System.out.println("Entrée fEAST");
		
		p.getGame().addToTrash(this);
		
		boolean termine=false;
	
		while(termine!=true){
			
			for(Card c : p.getGame().availableSupplyCards()){
			
				if (c.getCost()<=5){
				
					p.gain(c.getName());
					termine=true;
				
				}
			
			
			
			}
		
		}
		
	
		
		System.out.println("sORTIE fEAST");
		
	}
	
	
}
