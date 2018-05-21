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
		
		return super.toString() + " (Action-Attack Card) \n";
	}
	
	public void play(Player p){
		
		List<Player> list=new ArrayList<Player>();
		
		for(Player adv : p.otherPlayers()){
			
			boolean trouve=false;
			
			for(Card c : adv.cardsInHand()){
				
				if(c.getName().equals("Moat")){
				
							List<String> choices = Arrays.asList("y", "n");
							String choix = p.choose(adv.getName()+", veux-tu utiliser ta carte Moat ? (y/n)", choices, false);
							
							if(choix.equals("n")){
								
								list.add(adv);
								
								
							}
							
							trouve = true;
					
				}
				
			
				
			}
			
				if(!trouve){
							list.add(adv);
								
				}
			
		}
		
		Card c=p.getInPlay().get(p.getInPlay().size()-1);
		System.out.println("TEST *********************************************************" +c.getName());
		c.action(p);
		c.attack(p,list);
		
	}
	

	
	
}
