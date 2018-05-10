package dominion.card;
import java.util.*;
import dominion.*;

/**
 * Les cartes Victoire
 */
public abstract class VictoryCard extends Card {
	
	
		public List<CardType> getTypes() {
		
			List<CardType> list=super.getTypes();
			list.add(Victory);
			return list;
	}
	
	public String toString() {
		
		return "Nom de la carte: " + super.getName() + "/n Types de la carte: Victory Card" ;
		
	}
	
}
