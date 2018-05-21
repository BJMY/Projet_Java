package dominion.card;
import java.util.*;
import dominion.*;

/**
 * Les cartes Action
 */
public abstract class ActionCard extends Card {
	
		public ActionCard(String name, int cost) {
	
			super(name,cost);
		
		}
	
		public List<CardType> getTypes() {
		
			List<CardType> list=super.getTypes();
			list.add(CardType.Action);
			return list;
	}
	
		public String toString() {
		
	return super.toString() + " (Action Card) \n";
		
	}
	
	
	
}
