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
	public void attack(Player p , List<Player> list) {
				
		p.addInHand(p.drawCard());
		p.addInHand(p.drawCard());
		
		for(Player adv : list){
			
			boolean termine=false;
			
			for(Card c: p.getGame().availableSupplyCards()){
				

				if(c.getName().equals("Curse") && !termine){
							
					adv.addToDiscard(c);
					p.getGame().removeFromSupply(c.getName());
					termine=true;
							
				}
				
			}
			
		}
		
		
		
	}
	
	public void action(Player p){
		System.out.println("ACTION WITCH °°°°°°°°°");
		p.addInHand(p.drawCard());
		p.addInHand(p.drawCard());
		
		
	}
	

	
	
	
}
