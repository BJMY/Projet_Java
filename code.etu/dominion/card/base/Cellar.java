package dominion.card.base;
import java.util.*;
import dominion.*;
import dominion.card.*;

/**
 * Carte Cave (Cellar)
 * 
 * +1 Action.
 * Défaussez autant de cartes que vous voulez.
 * +1 Carte par carte défaussée.
 */
public class Cellar extends ActionCard {
	
	public Cellar(){
		super("Cellar",2);
	}
	
	public void play(Player p){
		
		p.incrementActions(1);
		
		List<String> choices= new List<String>();
		
		for(Card c : p.cardsInHand()){
			
			choices.add(c.getName());
			
		}
		
		boolean termine=false;
		
		while(termine==false){
			
			p.incrementActions(1);
			String choix= p.choose("Saisissez le nom d'une carte à défausser (vide pour passer)",choices,true);
		
			Card card;
		
			if(choix==""){
				
				termine=true;
				
			}
		
			boolean trouve=false;
			for (Card c : p.cardsInHand()){
			
				if(trouve!=true && termine!=true){
				
					if(c.getName().equals(choix)){
					
						card=c;
					
					}
				
				}
			
			}
		
			p.addToDiscard(card);
			p.removeFromHand(card);
			
		}
		
	
		
	}
	
}
