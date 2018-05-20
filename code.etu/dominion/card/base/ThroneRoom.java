package dominion.card.base;
import java.util.*;
import dominion.*;
import dominion.card.*;

/**
 * Carte Salle du trône (Throne Room)
 * 
 * Choisissez 1 carte Action de votre main.
 * Jouez-la deux fois.
 */
public class ThroneRoom extends ActionCard {
	
	public ThroneRoom(){
		
		super("Throne Room",4);
		
	}
	
	public void play(Player p){
		
		List<String> choices=new ArrayList();
		
		for(Card c: p.cardsInHand()){
			
			if(c.getTypes().contains(CardType.Action)){
				
				choices.add(c.getName());
			}
			
			
		}
		
		if(choices.size()!=0){
			
			String choix= p.choose("Saisissez le nom de la carte Action que vous souhaitez jouer 2 fois",choices,false);
			
			for(Card c: p.cardsInHand()){
				
				if(c.getName().equals(choix)){
					
					c.play(p);
					System.out.println("La carte a été jouée une fois");
					
					c.play(p);
					System.out.println("La carte a été jouée deux fois");
					
					p.addInPlay(c);
					p.removeFromHand(c);
					
				}
				
			}
			
		}
		
		
		
		
	}
	
}
