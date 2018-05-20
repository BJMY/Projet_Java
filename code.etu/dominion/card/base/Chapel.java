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
	
	public void play(Player p ){
		
		List<String> choices= new ArrayList<String>();
		
		for(Card c : p.cardsInHand()){
			
			choices.add(c.getName());
			
		}
		
		boolean termine=false;
		int cpt=0;
		
		while(termine==false && cpt<=4){
			


			String choix= p.choose("Saisissez le nom d'une carte à défausser (vide pour passer)",choices,true);
		
			
		
			if(choix.equals("")){
				
				termine=true;
				
			}else{
		
			boolean trouve=false;
		    
			for (Card c : p.cardsInHand()){
			
				if(!trouve){
				
					if(c.getName().equals(choix)){
					
					   p.getGame().addToTrash(c);

			           p.removeFromHand(c);
			           trouve=true;
					
					}
				
				}
			
			}
		
			
			
		}
		
		
			
		}
		
	}
	
}
