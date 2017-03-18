import java.util.ArrayList;
import java.util.Date;

import javax.swing.JOptionPane;

import gameElements.Board;
import gameElements.Game;
import gameElements.Player;
import gameElements.Queen;
import gameElements.Rock;
import graphics.GameUI;


public class Main {
	public static void main(String[] args) {
		
		//test1();
		//test2();
		//test3();
		//test4();
		//test5();
		//test6();
		//test7();
		//test8();
		//test9();
		//test10();
		//test11();
		test12();
		
		//testGUI();
		
	}
	
	private static void testGUI(){
		Board b = new Board(new Game(), 15);
		GameUI gui = new GameUI(b);		
		gui.launch();
	}
	
	private static void test1(){
		Board b = new Board();
		System.out.println("Test1");
		System.out.println("De base");
		System.out.println(b.toString());
		
		b.setPiece(5, 5, new Queen(b.getGame().getPlayer0()));
		
		System.out.println("Ajout d'une reine et d'un rock piece");
		System.out.println(b.toString());
		
		Board b2 = b.clone();
		b2.setPiece(5, 5, new Rock(b.getGame().getPlayer0()));
		
		System.out.println("Clone et ajout d'un rock sur le clone ");
		System.out.println("Le vrai");
		System.out.println(b.toString());
		System.out.println("Le clone");
		System.out.println(b2.toString());

		System.out.println(b.toStringAccess());
		
		System.out.println("Diagonales");
		System.out.println(b.toString());

	}
	
	private static void test2(){
		Board b = new Board();
		System.out.println("Test2 - Boucle");
		int ligne = 0, colonne = 0;
		String input = "";
		boolean place = false;
		
		while (ligne != -1 && colonne != -1){
			JOptionPane Jo = new JOptionPane();
			input = Jo.showInputDialog("Saisir une ligne (-1 pour quitter)");
			ligne = Integer.parseInt(input);
			if(ligne != -1){
					input = Jo.showInputDialog("Saisir une colonne (-1 pour quitter)");
					colonne = Integer.parseInt(input);
					if(colonne != -1){
					place = b.placeQueen(colonne, ligne);
					if(!place)
						Jo.showMessageDialog(Jo, "Emplacement non disponible !");
					else
						Jo.showMessageDialog(Jo, "Reine plac√©e");
					
					System.out.println("\n Plateau");
					System.out.println(b.toString());
					System.out.println("\n Acc√®s bloques");
					System.out.println(b.toStringAccess());
				}
			}
		}
	}
	
	private static void test3(){
		Board b = new Board();
		System.out.println("Test 3 - Successeurs");
		b.placeQueen(4, 5);
		ArrayList<Board> toast = b.getSuccessors();
		for(Board succ : toast){
			System.out.println(succ.toString()+"\n");
		}
	}
	
	private static void test4(){
		Board b = new Board(new Game(), 9);
		System.out.println("Test 4 - Recherche profondeur + temps execution");
		double debut = System.currentTimeMillis();
	
		//System.out.println(b.solutionSteps(b));
		b.solutionSteps(b);
		
		double fin = (System.currentTimeMillis() - debut)/1000;
		System.out.println("Temps execution de depthFirstSearch : "+fin+"s");
	}
	
	private static void test5(){
		Board b = new Board();
		System.out.println("Test 5 - Successeurs avec getNewSuccessors()");
		b.placeQueen(4, 5);
		ArrayList<Board> toast = b.getNewSuccessors();
		for(Board succ : toast){
			System.out.println(succ.toString()+"\n");
		}
	}
	
	private static void test6(){
		Board b = new Board(new Game(), 9);
		System.out.println("Test 6 - Recherche profondeur2 + temps execution");
		double debut = System.currentTimeMillis();
	
		//System.out.println(b.solutionSteps(b));
		b.solutionSteps(b);
		
		double fin = (System.currentTimeMillis() - debut)/1000;
		System.out.println("Temps execution de depthFirstSearch : "+fin+"s");
	}
	
	private static void test7(){
		Board b = new Board(new Game(), 9);
		System.out.println("Test 7 - boardToArray + arrayToBoard");
		b.placeQueen(4, 5);
		b.placeQueen(1, 3);
		
		ArrayList<Integer> tab = b.boardToArray();
		System.out.println(tab.toString()+"\n");
		
		Board b2 = b.arrayToBoard(tab);
		System.out.println("Original");
		System.out.println(b.toString()+"\n");
		
		System.out.println("arrayToBoard()");
		System.out.println(b2.toString()+"\n");
	}
	
	private static void test8(){
		Board b = new Board(new Game(), 4);
		System.out.println("Test 8 - isSolutionArray");
		b.placeQueen(0, 1);
		b.placeQueen(1, 3);
		b.placeQueen(2, 0);
		b.placeQueen(3, 2);
		ArrayList<Integer> tab = b.boardToArray();
		System.out.println(tab.toString()+"\n");
		System.out.println(b.toString()+"\n");
		
		Board toto = b.arrayToBoard(tab);
		System.out.println(toto.toString());
		if(b.isSolutionArray(tab))
			System.out.println("Est solution");
		else
			System.out.println("N'est pas solution");
	}
	
	private static void test9(){
		ArrayList<Integer> tab = new ArrayList<Integer>();
		tab.add(-1);tab.add(-1);tab.add(-1);tab.add(-1);
		System.out.println(tab.toString());
		
		System.out.println("Test 9 - Recherche profondeurArray + temps execution");
		double debut = System.currentTimeMillis();
	
		Board b = new Board(new Game(), tab.size());
		Board bb = b.arrayToBoard(tab);
		
		String s = bb.solutionStepsArray(tab);
		System.out.println(s);
		
		double fin = (System.currentTimeMillis() - debut)/1000;
		System.out.println("Temps execution de depthFirstSearch : "+fin+"s");
	}
	
	private static void test10(){
		System.out.println("Test 10 - Test getNbrRochers");
		Game g = new Game();
		Board b = new Board(g, 9);
		int nbRocks0 = b.getNumberOfRocksLeft(g.getPlayer0());
		int nbRocks1 = b.getNumberOfRocksLeft(g.getPlayer1());
		System.out.println("Nombre de rocks player0 : "+nbRocks0);
		System.out.println("Nombre de rocks player1 : "+nbRocks1);
		
		System.out.println("\nOn utilise un rocher chez player 1");
		b.useRock(g.getPlayer1());
		
		nbRocks0 = b.getNumberOfRocksLeft(g.getPlayer0());
		nbRocks1 = b.getNumberOfRocksLeft(g.getPlayer1());
		System.out.println("Nombre de rocks player0 : "+nbRocks0);
		System.out.println("Nombre de rocks player1 : "+nbRocks1);
	}
	
	private static void test11(){
		System.out.println("Test 11 - IsAccessible2, toStringAccess2, numberOfAccessible2, placeRock2, placeQueen2");
		Game g = new Game();
		Board b = new Board(g, 9);
		
		System.out.println("isAccessible player 0");
		System.out.println(b.toStringAccess2(g.getPlayer0()));
		
		System.out.println("isAccessible player 1");
		System.out.println(b.toStringAccess2(g.getPlayer1()));
		
		System.out.println("On place un reine qui appartient √† player0 (par defaut dans board)");
		b.placeQueen(4, 5);
		
		System.out.println("isAccessible player 0");
		System.out.println(b.toStringAccess2(g.getPlayer0()));
		
		System.out.println("isAccessible player 1");
		System.out.println(b.toStringAccess2(g.getPlayer1()));
	}
	
	private static void test12(){ // pas termine, mais la boucle est la
		System.out.println("Test 12 - Jeu a 2 joueurs correspondant a la question 9 du TP3");
		Game g = new Game();
		Board b = new Board(g, 5);
		int currentPlayer = 0; // le joueur 0 commencera la partie
		int mov = 0; // un petit compteur de mouvements
		boolean enJeu = true;
		int lig = -1, col = -1;
		
		// initialisation des tableaux pour les JOptionPane
		// celui pour reine / rocher
		ArrayList<String> choixA = new ArrayList<String>();
		choixA.add("Queen");
		choixA.add("Rock");
		choixA.add("Quitter");
		Object[] choix = choixA.toArray();
		boolean ok;
		
		// celui pour les coordonnÈes
		ArrayList<Integer> choixC = new ArrayList<Integer>();
		for(int i = 0; i < b.getSize(); i++){
			choixC.add(i);
		}
		Object[] choix2 = choixC.toArray();
		
		while(enJeu){
			System.out.print("Mouvements : "+mov);
			System.out.println(" - Au tour du joueur "+currentPlayer);
			System.out.println(b.toString());
					
			Object input = JOptionPane.showInputDialog(null, "Choisissez quoi poser", "Choix de l'action", JOptionPane.INFORMATION_MESSAGE, null, choix, choix[0]);
			if(input != null){
				if(input.toString() == "Quitter")
					enJeu = !enJeu;
				else{
					Object input2 = JOptionPane.showInputDialog(null, "Choisissez une colonne", "Choix de la colonne", JOptionPane.INFORMATION_MESSAGE, null, choix2, choix2[0]);
					Object input3 = JOptionPane.showInputDialog(null, "Choisissez une ligne", "Choix de la ligne", JOptionPane.INFORMATION_MESSAGE, null, choix2, choix2[0]);

					if(input2 != null && input3 != null){
						col = Integer.valueOf(input2.toString());
						lig = Integer.valueOf(input3.toString());
						
						if(currentPlayer == 0){
							if(input.toString() == "Queen"){
								b.placeQueen2(col, lig, g.getPlayer0());
								// si on a choisi un mauvais emplacement, tant pis pour nous, tour suivant !
							}
							if(input.toString() == "Rock"){
								b.placeRock2(col, lig, g.getPlayer0());
								// si on a choisi un mauvais emplacement, tant pis pour nous, tour suivant !
							}
							currentPlayer = 1;
						}
						
						if(currentPlayer == 1)
							if(input.toString() == "Queen"){
								b.placeQueen2(col, lig, g.getPlayer1());
								// si on a choisi un mauvais emplacement, tant pis pour nous, tour suivant !
							}
							if(input.toString() == "Rock"){
								b.placeRock2(col, lig, g.getPlayer1());
								// si on a choisi un mauvais emplacement, tant pis pour nous, tour suivant !
							}
							currentPlayer = 0;
						mov ++;
					}
					else{
						System.out.println("Coordonnees non selectionnes");
					}
				}
			}else{
				System.out.println("Action non sÈlectionnee");
			}
			
			
		}
	}
}

/* Reponse aux questions de la partie 2 du TP3
 * 
 * 1) Dans ces cas, le premier joueur ‡ poser une reine a forcÈment gagnÈ.
 * Le role du premier joueur determine forcÈment le vaincqueur (cf ci dessus)
 * Car si on force le premier joueur ‡ poser un rocher, le deuxiËme va forcÈment poser une reine et gagner
 * 
 * 2) Elle semble juste dans le sens o˘ elle permet d'Èquilibrer un peu le jeu en empÍchant le premier joueur de
 * prendre l'avantage en posant une reine ‡ un endroit trop strategique, mais en l'autorisant tout de mÍme ‡ gÍner
 * ce genre de manoeuvre pour le joueur 2 en posant un rocher. Cela pourra peut etre influer sur les points. A voir...
 * 
 * 3) Oui, les symetries sont importantes ici. En effet, sur un plateau de taille impaire, le centre est symbolise par une
 * case, contrairement a un tableau de taille paire.
 * 
 * 4)5) Selon moi, poser un rocher ou une reine ne devrait pas etre sujet a une diffÈrenciation de points. En effet, la stratÈgie
 * de jeu la plus efficace est de poser des reines pour prendre le controle du plateau, temporiser egalement en posant des rochers
 * pour ne pas que l'adversaire aie beaucoup de rochers ‡ poser alors qu'il ne nous reste plus de reine. Cela conduirait l'adversaire
 * a neutraliser la plupart du controle qui nous est octroye sur le plateau par nos reines.
 * 
 * 6) Les cases dÈfinitivement perdues sont celles directement adjacentes ‡ une reine adverse. En effet, celles-ci sont soit sujettes ‡
 * l'action d'une reine, soit occupÈes par un rocher pour neutraliser l'action de la dite reine sur la ligne en question. Toutes les autres
 * sont potentiellement rÈcupÈrables.
*/