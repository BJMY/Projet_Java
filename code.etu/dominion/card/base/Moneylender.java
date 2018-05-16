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
		
		super("Moneylender",4);
		
	}
	
	public void play(Player p){
		
		System.out.println("Entrée MoneyLender");
		
		Card c=p.cardsInHand().remove("Copper");
		
		if(c!=null){
			p.getGame().addToTrash(c);
			p.incrementMoney(3);
		}
		
		System.out.println("Sortie MoneyLender");
		
	}
	
	
	
	
	
	
	
}
