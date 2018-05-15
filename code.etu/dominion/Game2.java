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
<<<<<<< HEAD:code.etu/dominion/Game2.java
		Copper cartecopper = new Copper();
		CardList listeCopper = new CardList();
		for (int i = 0; i<60; i++) {
			listeCopper.add(cartecopper);
		}
		for (int i = 0; i<60; i++) {
			this.supplyStacks.add(i,listeCopper);
		}
		Silver cartesilver = new Silver();
		CardList listeSilver = new CardList();
		for (int i = 0; i<40; i++) {
			listeSilver.add(cartesilver);
		}
		for (int i = 0; i<40; i++) {
			this.supplyStacks.add(i,listeSilver);
		}
		Gold cartegold = new Gold();
		CardList listeGold = new CardList();
		for (int i = 0; i<30; i++) {
			listeGold.add(cartegold);
		}
		for (int i = 0; i<30; i++) {
			this.supplyStacks.add(i,listeGold);
		}
		this.scanner = new Scanner (System.in);
		for (int i = 0; i<playerNames.length; i++) {			
			this.players[i] = new Player (playerNames[i], this);
		}
		for (int i = 0; i<kingdomStacks.size(); i++) {
			this.supplyStacks.add(kingdomStacks.get(i));
		}
=======
		
		
		this.scanner = new Scanner (System.in);
		this.players=new Player[playerNames.length]; //Déclaration du tableau de joueurs//
		
		for(int i=0; i<playerNames.length;i++){       
		
			Player p = new Player(playerNames[i],this);   /**Création des joueurs*/
			this.players[i]=p; //Remplissage du tableau//
		
		}
		
		for (CardList cl : kingdomStacks){
			
			this.supplyStacks.add(cl);  //Ajout à la réserve du jeu des piles passées en paramètre//
	
		}
		
		
		CardList treasures = new CardList();   /**Liste de cartes Trésor*/	
		
		for(int i=0; i<60; i++){   //Création des 60 cartes copper et ajout à la liste //
			Copper c= new Copper();
			treasures.add(c);
		}
	

		for(int i=0; i<40; i++){ //Création des 40 silver et ajout à la liste//
			Silver s=new Silver();
			treasures.add(s);
		}

		
		CardList golds=new CardList(); //Liste des cartes gold//
		for(int i=0; i<30; i++){ //Creation de 30 gold//
			Gold g= new Gold();
			treasures.add(g);
		}
		
		treasures.shuffle(); //Mélange des cartes//
		this.supplyStacks.add(treasures); //Ajout de la liste treasures à la réserve//
		
		
		CardList victory=new CardList(); //Liste des cartes victoire//
		if(playerNames.length==2){
			
			for(int i=0; i<8; i++){
				
				Estate e=new Estate();
				Duchy d=new Duchy();
				Province p=new Province();
				
				victory.add(e);
				victory.add(d);		
				victory.add(p);
				
			}
		
		}else{
			
				for(int i=0; i<12; i++){
				
				Estate e=new Estate();
				Duchy d=new Duchy();
				Province p=new Province();
				
				victory.add(e);
				victory.add(d);		
				victory.add(p);
				
			}
			
		}
		
		this.supplyStacks.add(victory);
		
		CardList curse=new CardList(); //Liste des cartes Malédiction//
		for(int i=0; i<(10*(playerNames.length-1));i++){
			
			Curse c=new Curse();
			curse.add(c);
			
		}
		
		this.supplyStacks.add(curse);
		
		
>>>>>>> cac409c7ac7246c9b677d338cb8fc168c96937f6:code.etu/dominion/Game.java
		this.trashedCards = new CardList();
		this.currentPlayerIndex = 0;
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
<<<<<<< HEAD:code.etu/dominion/Game2.java
		for (int i = 0; i<this.players.length; i++) {
			if(this.players[i].getName().equals(p.getName())) {
				return i;
			}
		}
=======

		for (int i = 0; i<this.numberOfPlayers(); i++) {
			if(this.players[i] == p) {
				return i;
			}
			
		}
		
>>>>>>> cac409c7ac7246c9b677d338cb8fc168c96937f6:code.etu/dominion/Game.java
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
<<<<<<< HEAD:code.etu/dominion/Game2.java
		ArrayList<Player> classplayer = new ArrayList<Player>();
		int j = this.indexOfPlayer(p);
		for (int i = j; i<this.players.length; i++) {
			classplayer.add(this.players[i]);
		}
		for (int k = 0; k<j; k++) {
			classplayer.add(this.players[k]);
		}
		return classplayer;
=======
		
		List<Player> list = new ArrayList<Player>();
		
		for (int i=0; i<this.numberOfPlayers(); i++){
			
			if(this.players[i]!=p){
				list.add(players[i]);
			}
		
		}
		
		return list;
		
		
>>>>>>> cac409c7ac7246c9b677d338cb8fc168c96937f6:code.etu/dominion/Game.java
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
			
			list.add(cl.get(0));
			
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
					
					return cl.remove(c.getName());
					
				}
				
			}
			
		}
		
		return null;
		
		
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
		while (! this.isFinished()) {
			// joue le tour du joueur courant
			this.players[this.currentPlayerIndex].playTurn();
			// passe au joueur suivant
			this.currentPlayerIndex += 1;
			if (this.currentPlayerIndex >= this.players.length) {
				this.currentPlayerIndex = 0;
			}
		}
		System.out.println("Game over.");
		// Affiche le score et les cartes de chaque joueur
		for (int i = 0; i < this.players.length; i++) {
			Player p = this.players[i];
			System.out.println(String.format("%s: %d Points.\n%s\n", p.getName(), p.victoryPoints(), p.totalCards().toString()));
		}
	}
}