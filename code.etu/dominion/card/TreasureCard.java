package dominion.card;
import java.util.*;
import dominion.*;

/**
 * Les cartes Trésor
 */
public abstract class TreasureCard extends Card {

	
		public List<CardType> getTypes() {
		
			List<CardType> list=super.getTypes();
			list.add(TreasureCard);
			return list;
	}
	
	public String toString() {
		
		return "Nom de la carte: " + super.name + "/n Types de la carte: Treasure Card" ;
		
	}
	

	
	
	
	
	
	
}
