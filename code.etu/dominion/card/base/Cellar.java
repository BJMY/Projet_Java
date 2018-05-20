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
		
		List<String> choices= new ArrayList<String>();
		
		for(Card c : p.cardsInHand()){
			
			choices.add(c.getName());
			
		}
		
		boolean termine=false;
		
		while(termine==false){
			

			String choix= p.choose("Saisissez le nom d'une carte à défausser (vide pour passer)",choices,true);
		
			
		
			if(choix.equals("")){
				
				termine=true;
				
			}else{
		
				boolean trouve=false;
				int i=0;
		    
				while(!trouve){
				
					Card c=p.cardsInHand().get(i);
				
					if(c.getName().equals(choix)){
					
					   p.addToDiscard(c);
			           p.removeFromHand(c);
			           p.addInHand(p.drawCard());
			           trouve=true;
					
					}
					
					i++;
		
			}
		
			
			
		}
		
	
		
		}
	
	}
}
