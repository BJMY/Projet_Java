package dominion.card.base;
import java.util.*;
import dominion.*;
import dominion.card.*;

/**
 * Carte Prêteur sur gages (Moneylender)
 * 
 * Écartez une carte Cuivre de votre main.
 * Dans ce cas, +3 Pièces.
 */
public class Moneylender extends ActionCard {
	
	
	public Moneylender(){
		
		super("MoneyLender",4);
		
	}
	
	public void play(Player p){
		
		Card c=p.cardsInHand().remove("Copper");
		
		if(c!=null){
			p.getGame().addToTrash(c);
			p.incrementMoney(3);
		}
		
	}
	
	
	
	
}
