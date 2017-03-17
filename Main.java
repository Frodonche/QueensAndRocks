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
						Jo.showMessageDialog(Jo, "Reine placée");
					
					System.out.println("\n Plateau");
					System.out.println(b.toString());
					System.out.println("\n Accès bloques");
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
		
		System.out.println("On place un reine qui appartient à player0 (par defaut dans board)");
		b.placeQueen(4, 5);
		
		System.out.println("isAccessible player 0");
		System.out.println(b.toStringAccess2(g.getPlayer0()));
		
		System.out.println("isAccessible player 1");
		System.out.println(b.toStringAccess2(g.getPlayer1()));
	}
	
	private static void test12(){ // pas terminé, mais la boucle est là
		System.out.println("Test 12 - Jeu à 2 joueurs correspondant à la question 9 du TP3");
		Game g = new Game();
		Board b = new Board(g, 5);
		int currentPlayer = 0; // le joueur 0 commencera la partie
		int mov = 0; // un petit compteur de mouvements
		boolean enJeu = true;
		
		while(enJeu){
			System.out.print("Mouvements : "+mov);
			System.out.println("Au tour du joueur "+currentPlayer);
			System.out.println(b.toString());
			
			ArrayList<String> choixA = new ArrayList<String>();
			choixA.add("Queen");
			choixA.add("Rock");
			choixA.add("Quitter");
			Object[] choix = choixA.toArray();
			
			Object input = JOptionPane.showInputDialog(null, "Choose one", "Input", JOptionPane.INFORMATION_MESSAGE, null, choix, choix[0]);
			if(input != null)
				if(input.toString() == "Quitter")
					enJeu = !enJeu;
		}
	}
}
