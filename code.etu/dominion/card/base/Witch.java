package dominion.card.base;
import java.util.*;
import dominion.*;
import dominion.card.*;

/**
 * Carte SorciÃ¨re (Witch)
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
		
		if(p.searchReactionCard() == false) {
		
			for(Player adv : p.otherPlayers()){
				
				for(Card c: p.getGame().availableSupplyCards()){
					
	
					if(c.getName().equals("Curse")){
								
						adv.addToDiscard(c);
						p.getGame().removeFromSupply(c.getName());
								
					}
					
				}
				
			}
		}
		
	}
}


