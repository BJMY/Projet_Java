package dominion.card.common;
import dominion.*;
import dominion.card.*;

/**
 * Carte Cuivre (Copper)
 * 
 * 1 Pièce
 */
public class Copper extends TreasureCard {
<<<<<<< HEAD
	public Copper() { 
		super("Copper", 0);	
	}
=======
	
	public Copper() { super("Copper", 0);	}
>>>>>>> cac409c7ac7246c9b677d338cb8fc168c96937f6
	
	public int treasureValue() {
		return 1;
	}
	
	public void play(Player p){
		
		p.incrementMoney(this.treasureValue());
		
	}
}
