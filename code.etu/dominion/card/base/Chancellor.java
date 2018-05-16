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
		String choix = p.choose("Veux-tu defausser ton deck imm�diatement ? (y/n)", choices, false);
		if (choix == "y") {
			for(int i = 0; i<p.cardsInHand().size(); i++) {
				p.addToDiscard(p.cardsInHand().remove(i));
				p.cardsInHand().remove(i);
			}
			p.endTurn();
		}
		else {
			p.endTurn();
		}
	}
}