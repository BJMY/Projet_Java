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
		
		return "Nom de la carte: " + super.getName() + "/n Types de la carte: Action Card" ;
		
	}
	
		public abstract void play(Player p);
			
		
	
	
	
}
