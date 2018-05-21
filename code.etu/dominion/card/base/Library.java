package dominion.card.base;
import java.util.*;
import dominion.*;
import dominion.card.*;

/**
 * Carte Bibliothèque (Library)
 * 
 * Piochez jusqu'à ce que vous ayez 7 cartes en main. Chaque carte Action piochée peut être mise de côté. Défaussez les cartes mises de côté lorsque vous avez terminé de piocher.
 */
public class Library extends ActionCard {
	
	public Library(){
		
		super("Library",5);
		
	}
	
	public void play(Player p){
	
		CardList deCote=new CardList();
			
		while(p.cardsInHand().size()<7){
			
			Card c=p.drawCard();
			
			if(c.getTypes().contains(CardType.Action)){
				
					List<String> choices = Arrays.asList("y", "n");
					String choix = p.choose("Veux-tu mettre cette carte de côté ?", choices, false);
					
					if(choix.equals("y")){
						
						deCote.add(c);
						
					}else{
						
						p.addInHand(c);
						
					}
				
				
			}else{
				
				p.addInHand(c);
				
			}
			
			
		}
		
		if(deCote.size()!=0){
			
			for(Card c : deCote){
				
				p.addToDiscard(c);
				
			}
			
		}
		
	}
	
}
