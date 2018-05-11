package dominion.card;
import java.util.*;
import dominion.*;

/**
 * Les cartes Action
 */
public abstract class ActionCard extends Card {
	
		public List<CardType> getTypes() {
		
			List<CardType> list=super.getTypes();
			list.add(Action);
			return list;
	}
	
		public String toString() {
		
		return "Nom de la carte: " + super.getName() + "/n Types de la carte: Action Card" ;
		
	}
	
	
	
}
