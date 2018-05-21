package dominion.card.base;
import java.util.*;
import dominion.*;
import dominion.card.*;

/**
 * Carte Aventurier (Adventurer)
 * 
 * Dévoilez des cartes de votre deck jusqu'à ce que 2 cartes Trésor soient dévoilées.
 *  Ajoutez ces cartes Trésor à votre main et défaussez les autres cartes dévoilées.
 */
public class Adventurer extends ActionCard {
	
	public Adventurer(){
		
		super("Adventurer",6);
		
	}
	
	public void play(Player p){
		
		int cpt = 0;
		
		while (p.getDraw().size()!=0 && cpt != 2) {
			
			Card c=p.getDraw().get(0);
			
			if (p.getDraw().get(0).getTypes().contains(CardType.Treasure)) {
				p.addInHand(p.getDraw().remove(c.getName()));
	
				cpt++;
				
			}else{
			
				p.addToDiscard(p.getDraw().remove(c.getName()));
			
				
			}
			
		
			
			
		}
	}
	
}
