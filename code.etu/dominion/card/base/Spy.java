package dominion.card.base;
import java.util.*;
import dominion.*;
import dominion.card.*;

/**
 * Carte Espion (Spy)
 * 
 * +1 Carte.
 * +1 Action.
 * Tous les joueurs (vous aussi) dévoilent la première carte de leur deck. 
 * Vous décidez ensuite si chaque carte dévoilée est défaussée ou replacée sur son deck.
 */
public class Spy extends AttackCard {
	
	public Spy(){
		
		super("Spy",4);
		
	}
	
	public void play(Player p){
		p.addInHand(p.drawCard());
		p.incrementActions(1);
		System.out.println(p.cardsInHand().get(0).toString());
		List<String> choices = Arrays.asList("y", "n");
		for(Player l : p.getGame().otherPlayers(p)) {
			System.out.println(l.cardsInHand().get(0).toString());
			String choix = p.choose("Veux-tu defausser la carte d�voil�? (y/n)", choices, true);
			if (choix.equals("y")) {
				
			}
		}
	}
	
}
