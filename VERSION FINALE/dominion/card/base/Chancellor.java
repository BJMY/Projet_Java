package dominion.card.base;
import java.util.*;
import dominion.*;
import dominion.card.*;

/**
 * Carte Chancellier (Chancellor)
 * 
 * +2 Pièces.
 * Vous pouvez immédiatement défausser votre deck.
 */
public class Chancellor extends ActionCard {
	
	public Chancellor() {
		super("Chancellor", 3);
	}
	
	public void play(Player p) {
		
		p.incrementMoney(2);
		
		List<String> choices = Arrays.asList("y", "n");
		String choix = p.choose("Veux-tu defausser ton deck immediatement ? (y/n)", choices, false);
		
		
		if (choix.equals("y")) {

			while(p.getDraw().size()!=0) {
				Card c=p.getDraw().get(0);
				p.addToDiscard(p.getDraw().remove(c.getName()));
			}
		
	
		}
		
	}
}
