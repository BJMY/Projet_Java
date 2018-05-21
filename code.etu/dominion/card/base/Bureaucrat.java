package dominion.card.base;
import java.util.*;
import dominion.*;
import dominion.card.*;

/**
 * Carte Bureaucrate (Bureaucrat)
 * 
 * Recevez une carte Argent; placez-la sur votre deck.
 * Tous vos adversaires dévoilent une carte Victoire et la placent sur leur deck (sinon ils dévoilent leur main afin que vous puissiez voir qu'ils n'ont pas de cartes Victoire).
 */
public class Bureaucrat extends AttackCard {
	
	
	public Bureaucrat(){
		
		super("Bureaucrat",4);
		
	}
	
	
	public void play(Player p){
		
		p.addToDraw(p.getGame().removeFromSupply("Silver"));
		
		List<String> choices=new ArrayList<String>();
		
		if(p.searchReactionCard() == false) {
		
			for(Player adv: p.otherPlayers()){
					
				
				if(adv.getVictoryCards().size()!=0){
					
					for(Card c : adv.getVictoryCards()){
							
							choices.add(c.getName());
						
					}
							
					String choix= p.choose("Saisissez le nom de la carte Victoire à réléveler: ",choices,false);
					
					for(Card c : adv.getVictoryCards()){
						
						if(c.getName().equals(choix)){
							
							System.out.println(adv.getName() + " possède une carte " + c.getName());
							adv.addToDraw(c);
							adv.removeFromHand(c);
							
						}
						
					}
					
					
					
				}else{
					
					//Dévoile sa main
					System.out.println(adv.getName() + " n'a aucune carte Victoire et dévoile sa main: ");
					adv.cardsInHand().toString();
					
				}
					
					
			}
	
			
		}

				
		
	}

}
