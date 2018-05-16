package dominion.card.base;
import java.util.*;
import dominion.*;
import dominion.card.*;

/**
 * Carte Sorcière (Witch)
 * 
 * +2 Cartes.
 * Tous vos adversaires recoivent une carte Curse.
 */
public class Witch extends AttackCard {
	public Witch() {
		super("Witch", 5);
	}
	public void play(Player p) {
		p.addInHand(p.drawCard());
		p.addInHand(p.drawCard());
		for(int i =0 ;i<p.otherPlayers().size(); i++) {
			p.otherPlayers().get(i).addInHand(p.gain("Curse"));
		}
	}
}