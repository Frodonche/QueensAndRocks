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
		test4();
		
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
	}
	
	private static void test4(){
		Board b = new Board(new Game(), 9);
		System.out.println("Test 4 - Recherche profondeur + temps éxécution");
		double debut = System.currentTimeMillis();
	
		//System.out.println(b.solutionSteps(b));
		b.solutionSteps(b);
		
		double fin = (System.currentTimeMillis() - debut)/1000;
		System.out.println("Temps éxécution de depthFirstSearch : "+fin+"s");
	}
}
