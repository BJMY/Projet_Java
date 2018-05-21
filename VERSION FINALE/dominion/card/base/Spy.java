package dominion.card.base;
import java.util.*;
import dominion.*;
import dominion.card.*;

/**
 * Carte Espion (Spy)
 * 
 * +1 Carte.
 * +1 Action.
 * Tous les joueurs (vous aussi) dÃ©voilent la premiÃ¨re carte de leur deck. 
 * Vous dÃ©cidez ensuite si chaque carte dÃ©voilÃ©e est dÃ©faussÃ©e ou replacÃ©e sur son deck.
 */
public class Spy extends AttackCard {
	
	public Spy(){
		
		super("Spy",4);
		
	}
	
	public void attack(Player p , List<Player> list) {

		
		List<Player> newlist=new ArrayList<Player>();
		
		newlist.add(p);
		
		for(Player x:list){
		
				newlist.add(x);
		}
		
		
		List<String> choices = Arrays.asList("y", "n");	
		for(int i = 0; i < newlist.size(); i++) { 
				
			Player l = newlist.get(i);
			Card c = l.drawCard();
			String choix = p.choose("Veux-tu defausser la carte dévoilé? (y/n)", choices, true);
			
			if (choix.equals("y")) {
				l.gain(c);
			}
			
			else {
				
				l.addToDraw(c);
			}
		}
	
	
	
	}
	
	public void action(Player p){
		
		p.addInHand(p.drawCard());
		p.incrementActions(1);
	
	}
	
}
