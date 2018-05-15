package dominion.card.base;
import dominion.*;
import dominion.card.*;

/**
 * Carte Laboratoire (Laboratory)
 * 
 * +2 Cartes.
 * +1 Action.
 */
public class Laboratory extends ActionCard {
	
	public Laboratory() {
		super("Laboratory", 5);
	}
	
	public void play(Player p) {
		p.addInHand(p.drawCard());
		p.addInHand(p.drawCard());
		p.incrementActions(1);
	}
}