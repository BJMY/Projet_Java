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
		
		System.out.println("Entrée Milice");
	
		p.incrementMoney(2);
		
		for(Player adv : p.otherPlayers()){
			
			int cpt=adv.cardsInHand().size();
			
			while(cpt>3){
				
				adv.addToDiscard(adv.cardsInHand().get(0));
				adv.removeFromHand(adv.cardsInHand().get(0));
				cpt--;
				
			}
			
			
			
		}
		
		System.out.println("Sortie Milice");
		
	}
	
	
}
