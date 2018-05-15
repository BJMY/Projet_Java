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
		
		return "Nom de la carte: " + super.getName() + "/n Types de la carte: Curse Card" ;
		
	}
	
	public abstract void play(Player p);


}