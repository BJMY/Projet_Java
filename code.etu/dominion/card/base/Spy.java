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
		p.cardsInHand().get(0).toString();
		for(Player l : p.getGame().otherPlayers(p)) {
			l.cardsInHand().get(0);
		}
	}
	
}
