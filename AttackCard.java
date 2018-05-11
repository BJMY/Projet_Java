package dominion.card;
import java.util.*;
import dominion.*;

/**
 * Les cartes Attaque
 * Rmq: les cartes Attaque sont toutes des cartes Action
 */
public abstract class AttackCard extends ActionCard {
	
	
		public List<CardType> getTypes() {
		
			List<CardType> list=super.getTypes();
			list.add(Action);
			list.add(Attack);
			return list;
	}
	
		public String toString() {
		
		return "Nom de la carte: " + super.getName() + "/n Types de la carte: Action Card & Attack Card" ;
		
	}
	
	
}