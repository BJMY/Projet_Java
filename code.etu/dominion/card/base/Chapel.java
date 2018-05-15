package dominion.card.base;
import java.util.*;
import dominion.*;
import dominion.card.*;

/**
 * Carte Chapelle (Chapel)
 * 
 * Écartez jusqu'à 4 cartes de votre main.
 */
public class Chapel extends ActionCard {
	
	
	public Chapel(){
		
		super("Chapel",2);
		
	}
	
	public void play(Player ){
		
			List<String> choices= new List<String>();
		
		for(Card c : p.cardsInHand()){
			
			choices.add(c.getName());
			
		}
		
		boolean termine=false;
		
		while(termine==false){
			
			p.incrementActions(1);
			String choix= p.choose("Saisissez le nom de cartes à jeter (vide pour passer)",choices,true);
		
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
		
			p.getGame().addToTrash(card);
			p.removeFromHand(card);
			
		}
		
	}
	
}
