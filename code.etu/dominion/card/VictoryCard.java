package dominion.card;
import java.util.*;
import dominion.*;

/**
 * Les cartes Victoire
 */
public abstract class VictoryCard extends Card {
	
	
		public List<CardType> getTypes() {
		
			List<CardType> list=super.getTypes();
			list.add(VictoryCard);
			return list;
	}
	
	public String toString() {
		
		return "Nom de la carte: " + super.name + "/n Types de la carte: Victory Card" ;
		
	}
	
}
