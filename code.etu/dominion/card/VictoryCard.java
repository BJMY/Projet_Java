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
		
		return "Nom de la carte: " + super.getName() + "/n Types de la carte: Victory Card" ;
		
	}
	
	public abstract void play(Player p);
	
	
}
