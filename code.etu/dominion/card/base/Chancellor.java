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
		List<String> choices = Arrays.asList("y", "n");
		p.incrementMoney(2);
		String choix = p.choose("Veux-tu defausser ton deck immediatement ? (y/n)", choices, false);
		if (choix.equals("y")) {
			System.out.println("yes go boucle");
		
			for(int i = 0; i<p.cardsInHand().size(); i++) {
				
			
				p.addToDiscard(p.cardsInHand().remove(0));
				
			}
			System.out.println("fin boucle");
			
		}
		
	}
}
