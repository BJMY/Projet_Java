package dominion.card;
import java.util.*;
import dominion.*;

/**
 * Les cartes Attaque
 * Rmq: les cartes Attaque sont toutes des cartes Action
 */
public abstract class AttackCard extends ActionCard {
	
	
		public AttackCard(String name, int cost) {
		
			super(name,cost);
		
		}
	
		public List<CardType> getTypes() {
		
			List<CardType> list=super.getTypes();
			list.add(CardType.Action);
			list.add(CardType.Attack);
			return list;
	}
	
		public String toString() {
		
		return "Nom de la carte: " + super.getName() + "/n Types de la carte: Action Card & Attack Card" ;
		
	}
		public abstract void play(Player p);
	
	
}
