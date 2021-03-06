package dominion;
import java.util.*;
import dominion.card.*;
import dominion.card.common.*;

/**
 * Class représentant une partie de Dominion
 */
public class Game {
	/**
	 * Tableau contenant les joueurs de la partie
	 */
	private Player[] players;
	
	/**
	 * Index du joueur dont c'est actuellement le tour
	 */
	private int currentPlayerIndex;
	
	/**
	 * Liste des piles dans la réserve du jeu.
	 * 
	 * On suppose ici que toutes les listes contiennent des copies de la même
	 * carte.
	 * Ces piles peuvent être vides en cours de partie si toutes les cartes de 
	 * la pile ont été achetées ou gagnées par les joueurs.
	 */
	private List<CardList> supplyStacks;
	
	/**
	 * Liste des cartes qui ont été écartées (trash)
	 */
	private CardList trashedCards;

	private Scanner scanner;
	
	/**
	 * Constructeur
	 * 
	 * @param playerNames liste des noms des joueurs qui participent à la 
	 * partie. Le constructeur doit créer les objets correspondant aux joueurs
	 * @param kingdomStacks liste de piles de réserve à utiliser correspondant 
	 * aux cartes "royaume" à utiliser dans la partie, auxquelles le 
	 * constructeur doit ajouter les piles "communes":
	 * - 60 Copper
	 * - 40 Silver
	 * - 30 Gold
	 * - 8 (si 2 joueurs) ou 12 (si 3 ou 4 joueurs) Estate, Duchy et Province 	 * - 10 * (n-1) Curse où n est le nombre de joueurs dans la partie
	 */
	public Game(String[] playerNames, List<CardList> kingdomStacks) {
		
		
		this.scanner = new Scanner (System.in);
		this.supplyStacks=new ArrayList<CardList>(); //Initialisation réserve//
		this.trashedCards=new CardList(); //Initialisation trash//
		this.players=new Player[playerNames.length]; //Déclaration du tableau de joueurs//
		
		//~ for(int i=0; i<playerNames.length;i++){       
		
			//~ Player p = new Player(playerNames[i],this);   /**Création des joueurs*/
			//~ this.players[i]=p; //Remplissage du tableau//
		
		//~ }
		
		
		for (CardList cl : kingdomStacks){
			
			this.supplyStacks.add(cl);  //Ajout à la réserve du jeu des piles passées en paramètre//
	
		}
		
		
		CardList coppers = new CardList();   /**Liste de cartes Trésor*/	
		
		for(int i=0; i<60; i++){   //Création des 60 cartes copper et ajout à la liste //
			Copper c= new Copper();
			coppers.add(c);
		}
		
		
		
		this.supplyStacks.add(coppers);
	
		CardList silvers= new CardList();
		for(int i=0; i<40; i++){ //Création des 40 silver et ajout à la liste//
			Silver s=new Silver();
			silvers.add(s);
			
		}

		this.supplyStacks.add(silvers);
		
		CardList golds=new CardList(); //Liste des cartes gold//
		for(int i=0; i<30; i++){ //Creation de 30 gold//
			Gold g= new Gold();
			golds.add(g);
		}
		

		this.supplyStacks.add(golds);
		
		CardList estates=new CardList(); //Liste des cartes victoire//
		CardList duchys=new CardList();
		CardList provinces=new CardList();
		if(playerNames.length==2){
			
			for(int i=0; i<8; i++){
			
			
				Duchy d=new Duchy();
				Province p=new Province();
				
			
				duchys.add(d);		
				provinces.add(p);
				
			}
			
			for(int i=0; i<8+3*playerNames.length; i++){
					Estate e=new Estate();
					estates.add(e);
			}
		
		}else{
			
				for(int i=0; i<12; i++){
				
			
				Duchy d=new Duchy();
				Province p=new Province();
				
			
				duchys.add(d);		
				provinces.add(p);
				
			}
			
			for(int i=0; i<12+3*playerNames.length; i++){
					Estate e=new Estate();
					estates.add(e);
			}
			
		}
		
		this.supplyStacks.add(estates);
		this.supplyStacks.add(duchys);
		this.supplyStacks.add(provinces);
		
		CardList curse=new CardList(); //Liste des cartes Malédiction//
		for(int i=0; i<(10*(playerNames.length-1));i++){
			
			Curse c=new Curse();
			curse.add(c);
			
		}
		
		
		this.supplyStacks.add(curse);
		
		
		this.trashedCards = new CardList();
		this.currentPlayerIndex = 0;
		
		
		for(int i=0; i<playerNames.length;i++){       
		
			Player p = new Player(playerNames[i],this);   /**Création des joueurs*/
			this.players[i]=p; //Remplissage du tableau//
		
		}
		
			System.out.println("FIN CONSTUCTEUR GAME");
	}
	
	/**
	 * Renvoie le joueur correspondant à l'indice passé en argument
	 * On suppose {@code index} est un indice valide du tableau 
	 * {@code this.players}
	 * 
	 * @param index indice dans le tableau des joueurs du joueur à renvoyer
	 */
	public Player getPlayer(int index) {
		return this.players[index];
	}
	
	/**
	 * Renvoie le nombre de joueurs participant à la partie
	 */
	public int numberOfPlayers() {
		return this.players.length;
	}
	
	/**
	 * Renvoie l'indice du joueur passé en argument dans le tableau des 
	 * joueurs, ou -1 si le joueur n'est pas dans le tableau.
	 */
	private int indexOfPlayer(Player p) {

		for (int i = 0; i<this.numberOfPlayers(); i++) {
			if(this.players[i] == p) {
				return i;
			}
			
		}
		
		return -1;
	}
	
	/**
	 * Renvoie la liste des adversaires du joueur passé en argument, dans 
	 * l'ordre dans lequel ils apparaissent à partir du joueur {@code p}.
	 * 
	 * @param p joueur dont on veut renvoyer la liste des adversaires. On 
	 * suppose que {@code p} est bien dans le tableau des joueurs.
	 * @return un {@code ArrayList} contenant les autres joueurs de la partie 
	 * en commençant par celui qui se trouve juste après {@code p} et en 
	 * terminant par celui qui se trouve juste avant (le tableau est considéré 
	 * comme cyclique c'est-à-dire qu'après le premier élément on revient au 
	 * premier).
	 */
	public List<Player> otherPlayers(Player p) {
		
		List<Player> list = new ArrayList<Player>();
	
		
		for(int i=this.indexOfPlayer(p)+1;i<players.length;i++){
			
			list.add(players[i]);
			
		}
		
		for(int i=0;i<this.indexOfPlayer(p);i++){
			
			list.add(players[i]);
			
		}
		
		return list;
		
		
	}
	
	/**
	 * Renvoie la liste des cartes qui sont disponibles à l'achat dans la 
	 * réserve.
	 * 
	 * @return une liste de cartes contenant la première carte de chaque pile 
	 * non-vide de la réserve (cartes royaume et cartes communes)
	 */
	public CardList availableSupplyCards() {
		
		CardList list = new CardList();
		
		for (CardList cl : this.supplyStacks){
			
			if(!cl.isEmpty()) {
				list.add(cl.get(0));
			}
			else {
				
			}
			
		}
		
		return list;
		
	}
	
	/**
	 * Renvoie une représentation de l'état de la partie sous forme d'une chaîne
	 * de caractères.
	 * 
	 * Cette représentation comporte
	 * - le nom du joueur dont c'est le tour
	 * - la liste des piles de la réserve en indiquant pour chacune :
	 *   - le nom de la carte
	 *   - le nombre de copies disponibles
	 *   - le prix de la carte
	 *   si la pile n'est pas vide, ou "Empty stack" si la pile est vide
	 */
	public String toString() {
		Player currentPlayer = this.players[this.currentPlayerIndex];
		String r = String.format("     -- %s's Turn --\n", currentPlayer.getName());
		for (List<Card> stack: this.supplyStacks) {
			if (stack.isEmpty()) {
				r += "[Empty stack]   ";
			} else {
				Card c = stack.get(0);
				r += String.format("%s x%d(%d)   ", c.getName(), stack.size(), c.getCost());
			}
		}
		r += "\n";
		return r;
	}
	
	/**
	 * Renvoie une carte de la réserve dont le nom est passé en argument.
	 * 
	 * @param cardName nom de la carte à trouver dans la réserve
	 * @return la carte trouvée dans la réserve ou {@code null} si aucune carte 
	 * ne correspond
	 */
	public Card getFromSupply(String cardName) {
		
		for(CardList cl : this.supplyStacks){
			
		    for(Card c: cl){
				
				if(c.getName()==cardName){
					
					return c;
					
				}
				
			}
			
		}
		
		return null;
		
	}
	
	/**
	 * Retire et renvoie une carte de la réserve
	 * 
	 * @param cardName nom de la carte à retirer de la réserve
	 * @return la carte retirée de la réserve ou {@code null} si aucune carte
	 * ne correspond au nom passé en argument
	 */
	public Card removeFromSupply(String cardName) {
		
			
		for(CardList cl : this.supplyStacks){
			
		    for(Card c: cl){
				
				if(c.getName()==cardName){
					this.trashedCards.add(c);
					return cl.remove(c.getName());
					
			}
		}
		    
				
		}
		
		return null;
		
		
	}
	
	public void addToTrash(Card c){
		
		this.trashedCards.add(c);
		
	}
	
	/**
	 * Teste si la partie est terminée
	 * 
	 * @return un booléen indiquant si la partie est terminée, c'est-à-dire si
	 * au moins l'une des deux conditions de fin suivantes est vraie
	 *  - 3 piles ou plus de la réserve sont vides
	 *  - la pile de Provinces de la réserve est vide
	 * (on suppose que toute partie contient une pile de Provinces, et donc si 
	 * aucune des piles non-vides de la réserve n'est une pile de Provinces, 
	 * c'est que la partie est terminée)
	 */
	 
	 	
	public boolean isFinished() {
		
		int cptPile=0; /**Compteur de piles vides*/
		int cptPro=0; /**Compteur de cartes Province*/
		
		for (CardList cl : this.supplyStacks){   
		
			if(cl.size()==0){  /**Tester si les piles sont vides*/
				cptPile+=1;
			}
			
			for(Card c : cl){
				
				if (c.getName()=="Province"){
					
					cptPro+=1;
					
				}
				
			}
			
		}
		
		return (cptPile==3 || cptPro==0);
		
		
		
	}
	
	
	public String readLine() {
		return scanner.nextLine();
	}

	/**
	 * Boucle d'exécution d'une partie.
	 * 
	 * Cette méthode exécute les tours des joueurs jusqu'à ce que la partie soit
	 * terminée. Lorsque la partie se termine, la méthode affiche le score 
	 * final et les cartes possédées par chacun des joueurs.
	 */
	public void run() {
		while (!this.isFinished()) {
				// joue le tour du joueur courant
				this.players[this.currentPlayerIndex].playTurn();
				// passe au joueur suivant	
				this.currentPlayerIndex += 1;
				if (this.currentPlayerIndex == this.players.length) {
					this.currentPlayerIndex = 0;
				}
		}
		// Affiche le score et les cartes de chaque joueur
		for (int i = 0; i < this.players.length; i++) {
			Player p = this.players[i];
			System.out.println(String.format("%s: %d Points.\n%s\n", p.getName(), p.victoryPoints(), p.totalCards().toString()));
		}
	}
}
