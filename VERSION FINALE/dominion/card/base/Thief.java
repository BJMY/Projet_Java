package dominion.card.base;
import java.util.*;
import dominion.*;
import dominion.card.*;

/**
 * Carte Voleur (Thief)
 * 
 * Tous vos adversaires dévoilent les 2 premières cartes de leur deck. S'ils dévoilent des cartes Trésor, ils en écartent 1 de votre choix. Parmi ces cartes Trésor écartées, recevez celles de votre choix. Les autres cartes dévoilées sont défaussées.
 */
public class Thief extends AttackCard {
	
	public Thief(){
		
		super("Thief",4);
		
	}
	
	public void action(Player p){
		
		//Pas d'action pour Thief
		
		
	}
	
	public void attack(Player p , List<Player> list) {
		
		List<String> cartesEcartees=new ArrayList<String>();
		CardList cards=new CardList();
		
		for(Player adv : list){
			
			Card c1=adv.getDraw().get(0);
			Card c2=adv.getDraw().get(1);
			
			System.out.println(adv.getName() + " dévoile sa carte " + c1.getName());
			System.out.println(adv.getName() + " dévoile sa carte " + c2.getName());
			
			List<String> choices=new ArrayList<String>();
			
			if(c1.getTypes().contains(CardType.Treasure)){
				

				choices.add(c1.getName());
				
				
			}
			
			if(c2.getTypes().contains(CardType.Treasure)){

				choices.add(c2.getName());
					
			}
			

			if(choices.size()==2){
		

				String choix= p.choose("Saisissez le nom de la carte que " + adv.getName() + " doit écarter",choices,true);
				
				if(choix.equals("")){
					
						
					System.out.println(adv.getName() + " n'a écarté aucune carte Trésor");
					
				}else{
					
					
				
					for(Card c: adv.getDraw()){
					
						if(c.getName().equals(choix)){
							
							cartesEcartees.add(choix);
							cards.add(c);
							p.getGame().addToTrash(c);
							adv.removeFromHand(c);
							
						}
						
					
					for(Card x : cards){
						
						if(x.getName().equals(c1.getName())){
							
							adv.addToDiscard(c2);
			
							
							
						}
						
						if(x.getName().equals(c2.getName())){
							
							adv.addToDiscard(c1);

							
						}
						
					}
						
						
						
					}
				
				}
			
			}else if (choices.size()==1){
				
					String name=choices.get(0);
					
				
					for(Card c: adv.getDraw()){
					
						if(c.getName().equals(name)){
							
							cartesEcartees.add(name);
							cards.add(c);
							p.getGame().addToTrash(c);
							adv.removeFromHand(c);
							
						}
						
					}
					
					
					for(Card x : cards){
						
						if(x.getName().equals(c1.getName())){
							
							adv.addToDiscard(c2);
				
							
						}
						
						if(x.getName().equals(c2.getName())){
							
							adv.addToDiscard(c1);
					
							
						}
						
					}
			
				
			}else{
				
				System.out.println(adv.getName() + " n'a dévoilé aucune carte Trésor");
				
			}
			
			adv.getDraw().remove(0);
			adv.getDraw().remove(0);
			
			
		}
		
		
		if(cartesEcartees.size()!=0){
			

			
			boolean termine=false;
			
			while(!termine && cartesEcartees.size()!=0){
			
				String choix= p.choose("Saisissez le nom d'une carte que vous souhaitez voler :",cartesEcartees,true);
				
				if(choix.equals("")){
					
					termine=true;
					
				}else{
					
					for(Card c : cards){
						
						if(c.getName().equals(choix)){
							
							p.addToDiscard(c);
							cartesEcartees.remove(c);
						}
					
						
					}
					
					
					
				}
				
			}
			
			if(cards.size()!=0){
				
				
				
			}
			

			
		}
		
		
		
		
	}
	
}
