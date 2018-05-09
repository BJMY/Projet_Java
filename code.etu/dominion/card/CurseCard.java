package dominion.card;
import java.util.*;
import dominion.*;

/**
 * Les cartes Malédiction
 */
public abstract class CurseCard extends Card {
	
			public List<CardType> getTypes() {
		
			List<CardType> list=super.getTypes();
			list.add(CurseCard);
			return list;
	}
	
	public String toString() {
		
		return "Nom de la carte: " + super.name + "/n Types de la carte: Curse Card" ;
		
	}


}
