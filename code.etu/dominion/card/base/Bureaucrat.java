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
		
		for(Player player : p.otherPlayers()){
			
			System.out.println(player.getName() + " possède une carte " + player.getVictoryCards().get(0).getName() );
			player.addToDraw(player.getVictoryCards().get(0));
			player.removeFromHand(player.getVictoryCards().get(0));
			
			
		}
		
		
	}
}
