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
		List<String> choices = Arrays.asList("y", "n");
		if(p.searchReactionCard() == false) {
		
			for(int i = 0; i < p.getGame().numberOfPlayers(); i++) { 
					
				Player l = p.getGame().getPlayer(i);
				Card c = l.drawCard();
				String choix = p.choose("Veux-tu defausser la carte dévoilé? (y/n)", choices, true);
				
				if (choix.equals("y")) {
					l.gain(c);
				}
				
				else {
					
					l.addToDraw(c);
				}
			}
		}
	}
	
}
