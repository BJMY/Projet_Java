package dominion;
import java.util.*;
import dominion.card.*;

/**
 * Un joueur de Dominion
 */
public class Player {
	/**
	 * Nom du joueur
	 */
	private String name;
	
	/**
	 * Nombre d'actions disponibles
	 */
	private int actions;
	
	/**
	 * Nombre de pièces disponibles pour acheter des cartes
	 */
	private int money;
	
	/**
	 * Nombre d'achats disponibles
	 */
	private int buys;
	
	/**
	 * Référence vers la partie en cours
	 */
	private Game game;
	
	/**
	 * Liste des cartes dans la main du joueur
	 */
	private CardList hand;
	
	/**
	 * Liste des cartes dans la défausse du joueur
	 */
	private CardList discard;
	
	/**
	 * Liste des cartes dans la pioche du joueur
	 */
	private CardList draw;
	
	/**
	 * Listes des cartes qui ont été jouées pendant le tour courant
	 */
	private CardList inPlay;
	
	/**
	 * Constructeur
	 * 
	 * Initialise les différentes piles de cartes du joueur, place 3 cartes
	 * Estate et 7 cartes Copper dans la défausse du joueur puis fait piocher 5
	 * cartes en main au joueur.
	 * 
	 * @param name: le nom du joueur
	 * @param game: le jeu en cours
	 * 
	 * Indications: On peut utiliser la méthode {@code this.endTurn()} pour 
	 * préparer la main du joueur après avoir placé les cartes dans la défausse.
	 */
	public Player(String name, Game game) {
		
		
		this.hand=new CardList();
		this.discard=new CardList();      //Initilisation piles//
		this.draw=new CardList();
		this.inPlay=new CardList();
		
		this.name=name;
		this.game=game;
		

		
		for(int i=0; i<3;i++){
			
			this.discard.add(this.game.removeFromSupply("Estate"));

		}
		
		for(int i=0; i<7;i++){
			
			this.discard.add(this.game.removeFromSupply("Copper"));
			
		}
		
			System.out.println(this.discard);
		
		
		for(int i=0; i<5;i++){
			
			this.hand.add(this.drawCard());
			
		}
		
	
	}

	/**
	 * Getters et setters
	 */
	public String getName() {
		
		return this.name;
		
	}
	
	public int getActions() {
		
		return this.actions;
	}
	
	public int getMoney() {
		
		return this.money;
	}
	
	public int getBuys() {
		
		return this.buys;
		
	}
	
	public Game getGame() {
		
		return this.game;
		
	}
	
	public CardList getDraw(){
	
		return this.draw;
		
	}
	
	/**
	 * Incrémente le nombre d'actions du joueur
	 * 
	 * @param n nombre d'actions à ajouter (ce nombre peut être négatif si l'on
	 * souhaite diminuer le nombre d'actions)
	 */
	public void incrementActions(int n) {
		
		this.actions+=n;
		
	}
	
	/**
	 * Incrémente le nombre de pièces du joueur
	 * 
	 * @param n nombre de pièces à ajouter (ce nombre peut être négatif si l'on
	 * souhaite diminuer le nombre de pièces)
	 */
	public void incrementMoney(int n) {
		
		this.money+=n;
	}
	
	/**
	 * Incrémente le nombre d'achats disponibles du joueur
	 * 
	 * @param n nombre d'achats à ajouter (ce nombre peut être négatif si l'on
	 * souhaite diminuer le nombre d'achats)
	 */
	public void incrementBuys(int n) {
		
		
		this.buys+=n;
		
	}

	/**
	 * Renvoie une liste des cartes que le joueur a en main.
	 * La liste renvoyée doit être une nouvelle {@code CardList} dont les 
	 * éléments sont les mêmes que ceux de {@code this.hand}.
	 */
	public CardList cardsInHand() {
		
		CardList list=new CardList();
		
		for(Card c : this.hand){
			
			list.add(c);
			
		}
		return list;
	}
	
	
	/** FONCTION AJOUTEE permet d'ajouter une carte dans la main du joueur*/
	public void addInHand(Card c){
		
		this.hand.add(c);
	
	}
	
	public void addInPlay(Card c){
		
		this.inPlay.add(c);
		
	}
	
	public void removeFromHand(Card c){
		
		this.hand.remove(c);
		
	}
	
	
	/**
	 * Renvoie une liste de toutes les cartes possédées par le joueur
	 * (le deck complet c'est-à-dire toutes les cartes dans la main, la
	 * défausse, la pioche et en jeu)
	 */
	public CardList totalCards() {
		
		CardList l=new CardList();
		
	    for (Card c: this.hand) {
			
			l.add(c);
			
		}
		
		    for (Card c: this.discard) {
			
			l.add(c);
			
		}
		
		    for (Card c: this.draw) {
			
			l.add(c);
			
		}
		
		    for (Card c: this.inPlay) {
			
			l.add(c);
			
		}
		
		return l;
	}
	
	/**
	 * Renvoie le nombre total de points de victoire du joueur
	 * 
	 * Ce total est calculé en ajoutant les valeurs individuelles de toutes les
	 * cartes dans le deck du joueur (en utilisant la méthode
	 * {@code victoryValue()}) des cartes
	 */
	public int victoryPoints() {
		
		int count=0; //Compteur de points//
		
		  for (Card c: this.hand) {
			
			count+=c.victoryValue(this);
			
		}
		
		    for (Card c: this.discard) {
			
			count+=c.victoryValue(this);
			
			
		}
		
		    for (Card c: this.draw) {
			
			count+=c.victoryValue(this);
			
			
		}
		
		    for (Card c: this.inPlay) {
			
			count+=c.victoryValue(this);
			
			
		}
		
		return count;
		
	}
	
	/**
	 * Renvoie une liste des autres joueurs de la partie.
	 * 
	 * Les adversaires sont listés dans l'ordre de jeu, c'est-à-dire que le
	 * premier de la liste est celui qui joue immédiatement après le joueur,
	 * puis le suivant, et ainsi de suite jusqu'au joueur qui joue immédiatement
	 * avant le joueur.
	 * 
	 * Rmq: Cette méthode fait appel à la méthode {@code otherPlayers(Player p)}
	 * de la classe {@code Game}.
	 */
	public List<Player> otherPlayers() {
		
		return this.game.otherPlayers(this);
		
	}
	
	
	/**
	 * Pioche une carte dans la pioche du joueur.
	 * 
	 * Si la pioche du joueur est vide, on commence par mélanger la défausse
	 * et transférer toutes les cartes de la défausse dans la pioche.
	 * On retire et renvoie ensuite la première carte de la pioche si elle n'est
	 * pas vide (sinon la méthode ne fait rien et renvoie {@code null})
	 * 
	 * @return la carte piochée, {@code null} si aucune carte disponible
	 */
	public Card drawCard() {
		
		
		if (this.draw.size()==0){
			
			this.discard.shuffle();

			
			for(Card c: this.discard){
				
				
				
				this.draw.add(c);
				
			}
			
			this.discard.clear();
			
			if(this.draw.size()!=0){
			
				return draw.remove(0);
			}
		}else{
		
				return draw.remove(0);
		}
		
		return null;
		
	}
	

	public void addToDraw(Card c){

			this.draw.add(c);			//Ajouter à la pioche
		
	}
	
	public void addToDiscard(Card c){
		
		this.discard.add(c);
		
	}
	
	
	
	/**
	 * Renvoie une représentation de l'état du joueur sous forme d'une chaîne
	 * de caractères.
	 * 
	 * Cette représentation comporte
	 * - le nom du joueur
	 * - le nombre d'actions, de pièces et d'achats du joueur
	 * - le nombre de cartes dans la pioche et dans la défausse du joueur
	 * - la liste des cartes en jeu du joueur
	 * - la liste des cartes dans la main du joueur
	 */
	public String toString() {
		String r = String.format("     -- %s --\n", this.name);
		r += String.format("Actions: %d     Money: %d     Buys: %d     Draw: %d     Discard: %d\n", this.actions, this.money, this.buys, this.draw.size(), this.discard.size()); 
		r += String.format("In play: %s\n", this.inPlay.toString());
		r += String.format("Hand: %s\n", this.hand.toString());
		return r;
	}
	
	/**
	 * Renvoie la liste de toutes les cartes Trésor dans la main du joueur
	 */
	public CardList getTreasureCards() {
		
		CardList list = new CardList();
		
		int i=0;
		while(this.hand.size()!=0 && i<this.hand.size()){
			
			Card c=this.hand.get(i);
			if(c.getTypes().contains(CardType.Treasure)){
			list.add(c);
			}
			i++;
			
			
		}
		

		return list;
		
	}
	
	/**
	 * Renvoie la liste de toutes les cartes Action dans la main du joueur
	 */
	public CardList getActionCards() {
		
				CardList list = new CardList();
		
		int i=0;
		while(this.hand.size()!=0 && i<this.hand.size()){
			
			Card c=this.hand.get(i);
				if(c.getTypes().contains(CardType.Action)){
				list.add(c);
			}
			i++;
			
			
		}
		

		return list;
		
		
	}
	
	/**
	 * Renvoie la liste de toutes les cartes Victoire dans la main du joueur
	 */
	public CardList getVictoryCards() {
		
				CardList list = new CardList();
		
		int i=0;
		while(this.hand.size()!=0 && i<this.hand.size()){
			
			Card c=this.hand.get(i);
			if(c.getTypes().contains(CardType.Victory)){
			list.add(c);
			}
			i++;
			
			
		}
		

		return list;
		
		
	}
	
	
	public int searchReactionCard() {
		int trouve = 0;
		int j = 0;
		while (j< this.getGame().numberOfPlayers()){
			int i = 0;
			Player p = this.getGame().getPlayer(j);
			List<String> choices = Arrays.asList("y", "n");
			while(i < p.cardsInHand().size() && trouve == 0) {
				if(p.cardsInHand().get(i).getName().equals("Moat")) {
					String choix = p.choose("Voulez-vous utiliser la carte Moat ? (y/n)", choices, false);
					if(choix.equals("y")) {
						trouve += 1;
					}
				}
				i++;
			}
			j++;
		}
		return trouve;
	}
	
	/**
	 * Joue une carte de la main du joueur.
	 * 
	 * @param c carte à jouer
	 * 
	 * Cette méthode ne vérifie pas que le joueur a le droit de jouer la carte,
	 * ni même que la carte se trouve effectivement dans sa main.
	 * La méthode retire la carte de la main du joueur, la place dans la liste
	 * {@code inPlay} et exécute la méthode {@code play(Player p)} de la carte.
	 */
	public void playCard(Card c) {
		
		
		System.out.println(c.getName());

		this.inPlay.add(this.hand.remove(c.getName()));
		c.play(this);
	
		
	}
	
	/**
	 * Joue une carte de la main du joueur.
	 * 
	 * @param cardName nom de la carte à jouer
	 * 
	 * S'il existe une carte dans la main du joueur dont le nom est égal au
	 * paramètre, la carte est jouée à l'aide de la méthode 
	 * {@code playCard(Card c)}. Si aucune carte ne correspond, la méthode ne
	 * fait rien.
	 */
	public void playCard(String cardName) {
	

			
				boolean trouve = false;
				int i = 0;
				while((i<hand.size()) && !trouve){
		
					Card c = hand.get(i);
					
					System.out.println(c.getName());
			
			
			
					if(c.getName().equals(cardName)){
						
						this.playCard(c);
						trouve = true;
					}
					
					i++;
					
				}	
		
	}
	
	/**
	 * Le joueur gagne une carte.
	 * 
	 * @param c carte à gagner (éventuellement {@code null})
	 * 
	 * Si la carte n'est pas {@code null}, elle est placée sur la défausse du
	 * joueur. On suppose que la carte a correctement été retirée de son 
	 * emplacement précédent au préalable.
	 */
	public void gain(Card c) {
		
		if(c!=null){
			
			
		 this.discard.add(c);
		
		}
		
	}
	
	/**
	 * Le joueur gagne une carte de la réserve
	 * 
	 * @param cardName nom de la carte à gagner. S'il existe une carte dans la 
	 * réserve ayant ce nom, cette carte est retirée de la réserve et placée 
	 * sur la défausse du joueur.
	 * @return la carte qui a été ajoutée à la défausse du joueur, ou {@code 
	 * null} si aucune carte n'a été prise dans la réserve.
	 */
	public Card gain(String cardName) {
		
	        /**Parcours des listes de la réserve de this.game**/
			
			for (Card c: this.game.availableSupplyCards()){
				
				if(c.getName()==cardName){                   /**Vérification de la présence de la carte**/
					
					
					this.gain(this.game.removeFromSupply(c.getName()));          /**Suppression de la réserve du jeu et gain de la carte**/
					return c;
					
				}
				
			}
			
		
		
		return null;
		
	}
	
	/**
	 * Le joueur achète une carte de la réserve
	 * 
	 * La méthode cherche une carte dans la réserve dont le nom est égal au
	 * paramètre, puis vérifie que le joueur a assez de pièces pour l'acheter 
	 * et au moins un achat disponible.
	 * Si le joueur peut acheter la carte, le coût de la carte est soustrait à
	 * l'argent du joueur, le nombre d'achats disponibles est décrémenté de 1 
	 * et la carte est gagnée par le joueur.
	 * 
	 * @param cardName nom de la carte à acheter
	 * @return la carte qui a été gagnée ou {@code null} si l'achat n'a pas eu 
	 * lieu
	 */
	public Card buyCard(String cardName) {
		
			
	         /**Parcours des listes la réserve de this.game**/
			
			for (Card c: this.game.availableSupplyCards()){
				
				if(c.getName().equals(cardName)){                   /**Vérification de la présence de la carte**/
					
					if(this.money >= c.getCost() && this.buys!=0){ /**Vérif. possibilité d'achat**/

						this.gain(c.getName());
						this.money-=c.getCost();
					    this.buys-=1;
						
						return c;
						
					}
					
					return null;
						
						
						
						
					}
					
				}
				
			
			
			return null;
			
		}
		
		
	
	
	/**
	 * Attend une entrée de la part du joueur (au clavier) et renvoie le choix
	 *  du joueur.
	 * 
	 * @param instruction message à afficher à l'écran pour indiquer au joueur
	 * la nature du choix qui est attendu
	 * @param choices une liste de chaînes de caractères correspondant aux
	 * choix valides attendus du joueur (la liste sera convertie en ensemble 
	 * par la fonction pour éliminer les doublons, ce qui permet de compter 
	 * correctement le nombre d'options disponibles)
	 * @param canPass booléen indiquant si le joueur a le droit de passer sans
	 * faire de choix. S'il est autorisé à passer, c'est la chaîne de
	 * caractères vide ("") qui signifie qu'il désire passer.
	 * 
	 * @return la méthode lit l'entrée clavier jusqu'à ce qu'un choix valide
	 * soit entré par l'utilisateur (un élément de {@code choices} ou
	 * éventuellement la chaîne vide si l'utilisateur est autorisé à passer).
	 * Lorsqu'un choix valide est obtenu, il est renvoyé.
	 * 
	 * Si l'ensemble {@code choices} ne comporte qu'un seul élément et que
	 * {@code canPass} est faux, l'unique choix valide est automatiquement
	 * renvoyé sans lire l'entrée de l'utilisateur.
	 * 
	 * Si l'ensemble des choix est vide, la chaîne vide ("") est 
	 * automatiquement renvoyée par la méthode (indépendamment de la valeur de 
	 * {@code canPass}).
	 * 
	 * Exemple d'utilisation pour demander à un joueur de répondre à une 
	 * question :
	 * <pre>
	 * {@code
	 * List<String> choices = Arrays.asList("y", "n");
	 * String input = p.choose("Do you want to ...? (y/n)", choices, false);
	 * }
	 * </pre>
	 */
	public String choose(String instruction, List<String> choices, boolean canPass) {
		// La liste de choix est convertie en ensemble pour éviter les doublons
		Set<String> choiceSet = new HashSet<String>();
		for (String c: choices) {
			choiceSet.add(c);
		}
		if (choiceSet.isEmpty()) {
			// Aucun choix disponible
			return "";
		} else if (choiceSet.size() == 1 && !canPass) {
			// Un seul choix possible (renvoyer cet unique élément)
			return choiceSet.iterator().next();
		} else {
			String input;
			// Lit l'entrée de l'utilisateur jusqu'à obtenir un choix valide
			while (true) {
				System.out.print("\n\n");
				// affiche l'état du jeu
				System.out.print(this.game);
				System.out.print("\n");
				// affiche l'état du joueur
				System.out.print(this);
				System.out.print("\n");
				// affiche l'instruction
				System.out.println(">>> " + instruction);
				System.out.print("> ");
				// lit l'entrée de l'utilisateur au clavier
				input = this.game.readLine();
				if (choiceSet.contains(input) || (canPass && input.equals(""))){
					// si une réponse valide est obtenue, elle est renvoyée
					return input;
				}else{
					System.out.println("Votre choix est invalide, merci de taper à nouveau ...");
				}
			}
		}
	}
	
	/**
	 * Attend une entrée de la part du joueur et renvoie le choix du joueur.
	 * Dans cette méthode, la liste des choix est donnée sous la forme d'une 
	 * liste de cartes et le joueur doit choisir le nom d'une de ces cartes.
	 * 
	 * @param instruction message à afficher à l'écran pour indiquer au joueur
	 * la nature du choix qui est attendu
	 * @param choices liste de cartes parmi lesquelles il faut en choisir une
	 * parmi lesquelles l'utilisateur doit choisir
	 * @param canPass booléen indiquant si le joueur a le droit de passer sans
	 * faire de choix. S'il est autorisé à passer, c'est la chaîne de
	 * caractères vide ("") qui signifie qu'il désire passer.
	 * 
	 * La méthode commence par construire une liste de tous les noms des cartes 
	 * dans {@code choices} puis appelle la méthode précédente pour faire 
	 * choisir un nom parmi cette liste à l'utilisateur.
	 * 
	 * Exemple d'utilisation pour faire choisir le nom d'une carte Action de sa
	 * main à un joueur (dans cet exemple le joueur n'a pas le droit de passer 
	 * s'il a au moins une carte Action en main, mais la méthode peut quand 
	 * même renvoyer {@code ""} s'il n'a aucune carte Action en main) :
	 * <pre>
	 * {@code
	 * CardList choices = new CardList();
	 * for (Card c: p.cardsInHand()) {
	 *   if (c.getTypes().contains(CardType.Action)) {
	 *     choices.add(c);
	 *   }
	 * }
	 * String input = p.chooseCard("Choose an Action card.", choices, false);
	 * </pre>
	 */
	public String chooseCard(String instruction, CardList choices, boolean canPass) {
		// liste de noms de cartes
		List<String> stringChoices = new ArrayList<String>();
		for (Card c: choices) {
			// tous les noms sont ajoutés à l'ensemble
			stringChoices.add(c.getName());
		}
		// appel de la méthode précédente en passant l'ensemble de noms
		return this.choose(instruction, stringChoices, canPass);
	}
	
	/**
	 * Démarre le tour du joueur
	 * 
	 * Les compteurs d'actions et achats sont mis à 1
	 */
	public void startTurn() {
		
		this.actions=1;
		this.buys=1;
	}
	
	/**
	 * Termine le tour du joueur
	 * 
	 * - Les compteurs d'actions, argent et achats du joueur sont remis à 0
	 * - Les cartes en main et en jeu sont défaussées
	 * - Le joueur pioche 5 cartes en main
	 */
	public void endTurn() {
		
		this.actions=0;
		this.buys=0;
		
		//~ while(this.hand.size()!=0){
			
			//~ this.discard.add
			
			
		//~ }
		
		for(Card c: this.cardsInHand()){
			
			if(c!=null){
			this.discard.add(this.hand.remove(c.getName()));
			}
		
		}
		
		for(int i=0; i<5;i++){
			
			this.addInHand(this.drawCard());
			
		}
		
		
		
		
	}
	
	/**
	 * Exécute le tour d'un joueur
	 * 
	 * Cette méthode exécute successivement les 5 phases du tour d'un joueur:
	 * 
	 * 1. (Préparation) la méthode {@code startTurn()} est appelée
	 * 
	 * 2. (Action) Tant que le joueur a des actions disponibles, on lui demande 
	 * de choisir le nom d'une carte Action de sa main à jouer. Il peut passer à
	 * tout moment à la phase suivante (soit de manière forcée s'il n'a plus de 
	 * carte Action en main soit volontairement en entrant la chaîne vide). 
	 * Lorsqu'il joue une carte Action, la fonction décrémente son nombre 
	 * d'actions puis joue la carte.
	 * 
	 * 3. (Trésor) Le joueur joue toutes les cartes Trésor de sa main 
	 * automatiquement (dans le jeu de base il n'y a aucune raison de ne pas 
	 * jouer tous les trésors automatiquement).
	 * 
	 * 4. (Achat) Tant que le joueur a au moins un achat disponible, on lui 
	 * demande de choisir le nom d'une carte de la réserve qu'il veut acheter. 
	 * Il ne peut acheter que des cartes dont le prix est inférieur à l'argent 
	 * dont il dispose. Le joueur peut passer (et terminer son tour) à tout 
	 * moment pendant cette phase.
	 * 
	 * 5. (Fin) La méthode {@code endTurn()} est appelée pour terminer le tour 
	 * du joueur
	 */
	public void playTurn() {
	
		this.startTurn(); /**1*/
		
		boolean pass = false; /**Détermine si passage à l'étape suivante sans jouer de carte*/
		while(this.actions !=0 && !pass && this.getActionCards().size()!=0){   /**2*/
			
			CardList choices = new CardList();
			
			for (Card c: this.getActionCards()) {
				
				choices.add(c);
			}
			
			String input = this.chooseCard("Choose an Action card.", choices, true);
			
			if (input==""){
				
				pass=true;
				
			}else{
				this.playCard(input);
				this.actions-=1;
			}
			
		}
	
		System.out.println("Playing all your Treasure cards...");
		//~ for(Card c: this.hand){  /**3*/
			
			//~ System.out.println("TAILLE HAND :" + this.hand.size());
			
			//~ if(c.getTypes().contains(CardType.Treasure)){
				
				//~ this.playCard(c.getName());
				
			//~ }
			
		//~ }javac
		
		while(this.getTreasureCards().size()!=0){
			
			this.playCard(this.getTreasureCards().get(0));
			
		}
		
		pass=false;					/**4*/
		while(this.buys !=0 && !pass){
			
			CardList choices = new CardList();
			
			for (Card c: this.game.availableSupplyCards()){
				
				if(c.getCost()<this.money){
				choices.add(c);
			}
				
			}
			
			String input = this.chooseCard("Choose a card to buy.", choices, true);
			
			if (input.equals("")){
				
				pass=true;
				this.endTurn();
				
			}else{
					
				Card buy=this.buyCard(input);
				
				if (buy!=null){
					
					System.out.println("Card " + input + " successfuly bought.");
					
					
				}else{
					
							System.out.println("Impossible to buy this card");
					
				}
			
			
			}
			
			
		}
		
		this.endTurn(); /**5*/

		
		
		
		
		
	
	}
}
