package dominion.card;
import java.util.*;
import dominion.*;

/**
 * Les cartes Trésor
 */
public abstract class TreasureCard extends Card {
	
	
		public TreasureCard(String name, int cost) {
		
			super(name,cost);
		
		}
	
		public List<CardType> getTypes() {
		
			List<CardType> list=super.getTypes();
			list.add(CardType.Treasure);
			return list;
	}
	
	public String toString() {
		
		return "Nom de la carte: " + super.getName() + "/n Types de la carte: Treasure Card" ;
		
	}
	
}
	
