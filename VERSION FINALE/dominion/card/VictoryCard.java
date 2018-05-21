package dominion.card;
import java.util.*;
import dominion.*;

/**
 * Les cartes Victoire
 */
public abstract class VictoryCard extends Card {
	
	
		public VictoryCard(String name, int cost) {
		
			super(name,cost);
		
		}

	
	
		public List<CardType> getTypes() {
		
			List<CardType> list=super.getTypes();
			list.add(CardType.Victory);
			return list;
	}
	
	public String toString() {
		
			return super.toString() + " (Victory Card) \n";
		
	}
	
}
