package dominion.card;
import java.util.*;
import dominion.*;

/**
 * Les cartes Malédiction
 */
public abstract class CurseCard extends Card {
	
	
		public CurseCard(String name, int cost) {
		
			super(name,cost);
		
		}
	
		public List<CardType> getTypes() {
		
			List<CardType> list=super.getTypes();
			list.add(CardType.Curse);
			return list;
			
		}
	
	public String toString() {
		
		return super.toString() + " (Curse Card) \n";
		
	}


}
