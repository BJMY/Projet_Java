package dominion.card.base;
import java.util.*;
import dominion.*;
import dominion.card.*;

/**
 * Carte Espion (Spy)
 * 
 * +1 Carte.
 * +1 Action.
 * Tous les joueurs (vous aussi) dÃ©voilent la premiÃ¨re carte de leur deck. 
 * Vous dÃ©cidez ensuite si chaque carte dÃ©voilÃ©e est dÃ©faussÃ©e ou replacÃ©e sur son deck.
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
			String choix = p.choose("Veux-tu defausser la carte dévoilé? (y/n)", choices, true);
			
			if (choix.equals("y")) {
				
				l.getGame().addToTrash(l.cardsInHand().get(0));
				
			}
			
			else {
				
				l.getGame().addToTrash(l.cardsInHand().get(0));
				l.addInHand(l.drawCard());
				
			}
		}
	}
	
}
