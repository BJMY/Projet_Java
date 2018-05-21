package dominion.card.base;
import java.util.*;
import dominion.*;
import dominion.card.*;

/**
 * Carte Milice (Militia)
 * 
 * 2 Pièces.
 * Tous vos adversaires défaussent leurs cartes de façon à n'avoir que 3 cartes en main.
 */
public class Militia extends AttackCard {
	
	public Militia (){
		
		super("Militia",4);
		
	}
	
	public void play(Player p){
		

	
		p.incrementMoney(2);
		
		if(p.searchReactionCard() == false) {
		
			for(Player adv : p.otherPlayers()){
				
				while(adv.cardsInHand().size()>3){
					
					List<String> choices=new ArrayList<String>();
					
					for(Card c : adv.cardsInHand()){
						
						choices.add(c.getName());
						
					}
					
					String choix= p.choose("Saisissez le nom de la carte à défausser: ",choices,false);
					
					boolean trouve=false;
					for(Card c : adv.cardsInHand()){
						
						if(c.getName().equals(choix) && !trouve){
							
							adv.addToDiscard(c);
							adv.removeFromHand(c);
							trouve=true;
							
						}
						
					}
			
					
					
				}
				
				
				
			}
		}
		
	
		
	}
	
	
}
