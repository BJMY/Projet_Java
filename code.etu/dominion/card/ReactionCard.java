package dominion.card;
import java.util.*;
import dominion.*;

/**
 * Les cartes Réaction
 * Rmq: les cartes Réaction sont toutes des cartes Action
 */
public abstract class ReactionCard extends ActionCard {
	
	
		public ReactionCard(String name, int cost) {
		
			super(name,cost);
		
		}
	
		public List<CardType> getTypes() {
		
			List<CardType> list=super.getTypes();
			list.add(CardType.Action);
			list.add(CardType.Reaction);
			return list;
	}
	
		public String toString() {
		
		return "Nom de la carte: " + super.getName() + "/n Types de la carte: Action Card & Reaction Card" ;
		
	}
		public abstract void play(Player p);
	
	
}