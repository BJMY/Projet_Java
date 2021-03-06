package dominion.card.base;
import java.util.*;
import dominion.*;
import dominion.card.*;

/**
 * Carte Chambre du conseil (Council Room)
 * 
 * +4 Cartes.
 * +1 Achat.
 * Tous vos adversaires piochent 1 carte.
 */
public class CouncilRoom extends ActionCard {
	
	public CouncilRoom(){
	
		super("Council Room",5);
		
		
	}
	
	public void play(Player p){
		
			p.addInHand(p.drawCard());
			p.addInHand(p.drawCard());
			p.addInHand(p.drawCard());
			p.addInHand(p.drawCard());
			p.incrementBuys(1);
			
			for(Player adv : p.otherPlayers()){
				
				adv.addInHand(adv.drawCard());
				
			}
		
	}
	
	
}
