package dominion.card.base;
import java.util.*;
import dominion.*;
import dominion.card.*;

/**
 * Carte Mine
 * 
 * Écartez une carte Trésor de votre main. Recevez une carte Trésor coûtant jusqu'à 3 Pièces de plus ; ajoutez cette carte à votre main.
 */
public class Mine extends ActionCard {
	
	public Mine(){
		
		super("Mine",5);
		
	}
	
	

	public void play(Player p){
		
		if (p.getTreasureCards().size()!=0){
		
			List<String> choices= new ArrayList<String>();
			
			for(Card c : p.getTreasureCards()){
				
				choices.add(c.getName());
				
			}
			
			String choix= p.choose("Saisissez le nom de la carte à écarter: ",choices,false);
			
			boolean trouve=false;
			int i=0;
			
			while(!trouve){
					
					Card c=p.getTreasureCards().get(i);
					if(c.getName().equals(choix)){
						
						int cost=c.getCost();
				
						i=0;
						
						
			
						List<String> choices2= new ArrayList<String>();
						
						for(Card d: p.getGame().availableSupplyCards()){
							
							
							if(d.getName().equals("Copper") && d.getCost()==cost+3|| d.getName().equals("Silver") && d.getCost()==cost+3|| d.getName().equals("Gold") && d.getCost()==cost+3){
								
								choices2.add(d.getName());
								
							}
							
						}
						
						if(choices2.size()!=0){
							
									p.getGame().addToTrash(c);
									p.removeFromHand(c);
						
						String choix2= p.choose("Saisissez le nom de la carte à gagner: ",choices2,false);
						
						
						while(!trouve && i<p.getGame().availableSupplyCards().size()){
							
							Card d=p.getGame().availableSupplyCards().get(i);
							
							if(d.getName().equals(choix2)){
									
									p.addInHand(d);
									p.getGame().removeFromSupply(d.getName());
									trouve=true;
							
							}
							
							i++;
						
							
						}
						
						
						
					}else{
						
						System.out.println("Pas de meilleur carte trésor à proposer, annulation de l'action");
						
						
					}
						
					}
					
					i++;
				
				
				
			}
		
		}

	}
}
