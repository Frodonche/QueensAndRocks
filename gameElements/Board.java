package gameElements;

import java.util.ArrayList;
import java.util.NoSuchElementException;


public class Board {
	protected Game game;
	protected int size;
	protected int numberOfPieces;
	protected Square[][] board;
	
	public Board(Game game, int size){
		this.game = game;
		this.size = size;
		this.numberOfPieces = 0;
		board = new Square[size][size];
		for (int i = 0; i < size; i++){
			for (int j = 0; j < size; j++){
				this.board[i][j] = game.getEmpty();
			}
		}
		
		
	}
	
	public Board(){
		this.game = new Game();
		this.size = 8;
		this.numberOfPieces = 0;
		board = new Square[size][size];
		for (int i = 0; i < size; i++){
			for (int j = 0; j < size; j++){
				this.board[i][j] = game.getEmpty();
			}
		}
		
	}
	
	public Game getGame(){
		return this.game;
	}
	
	public void setGame(Game game){
		this.game = game;
	}
	
	public int getSize(){
		return this.size;
	}
	
	public void setSize(int size){
		this.size = size;
	}
	
	public int getNumberOfPieces(){
		return this.numberOfPieces;
	}
	
	public void setNumberOfPieces(int nB){
		this.numberOfPieces = nB;
	}
	
	//---------------TP1------------------------
	public Square getPiece(int i, int j) {
		return this.board[i][j];
	}
	
	public void setPiece(int i, int j, Square piece){
		this.board[i][j] = piece;
		this.numberOfPieces ++ ;
	}
	
	public void removePiece(int i, int j){
		this.board[i][j] = this.game.getEmpty();
		this.numberOfPieces -- ;
	}

	public boolean isEmpty(int i, int j){
		return this.board[i][j] == this.game.getEmpty();
	}
	
	public String toString(){
		StringBuilder res = new StringBuilder();
		for (int i = 0; i < this.size; i++){
			res.append("| ");
			for (int j = 0; j < this.size; j++){
				res.append(getPiece(i, j).toString()+" ");
			}
			res.append("|\n");
		}
		return res.toString();
	}
	
	public Board clone(){
		Board res = new Board(new Game(), this.size);
		res.size = this.getSize();
		for (int i = 0; i < this.size; i++){
			for (int j = 0; j < this.size; j++){
				res.setPiece(i, j, this.getPiece(i, j));
			}
		}
		res.game = this.getGame();
		res.numberOfPieces = this.numberOfPieces;
		return res;
	}
	
	public boolean isAccessible(int i, int j) {
		boolean res = true;
		
		//diagonales qui vont à droite
		int k = i;
		int l = j;
		while(k < size && l < size && k>-1 && l>-1){
			if (this.board[k][l] instanceof Queen)
				return false;
			k++;
			l++;
		}
		
		k = i;
		l = j;
		while(k < size && l < size && k>-1 && l>-1){
			if (this.board[k][l] instanceof Queen)
				return false;
			k--;
			l--;
		}
		
		k = i;
		l = j;
		while(k < size && l < size && k>-1 && l>-1){
			if (this.board[k][l] instanceof Queen)
				return false;
			k++;
			l--;
		}
		
		k = i;
		l = j;
		while(k < size && l < size && k>-1 && l>-1){
			if (this.board[k][l] instanceof Queen)
				return false;
			k--;
			l++;
		}
		
		k = i;
		l = j;
		while(k < size && l < size && k>-1 && l>-1){
			if (this.board[k][l] instanceof Queen)
				return false;
			
			l++;
		}
		
		k = i;
		l = j;
		while(k < size && l < size && k>-1 && l>-1){
			if (this.board[k][l] instanceof Queen)
				return false;
			
			l--;
		}
		
		k = i;
		l = j;
		while(k < size && l < size && k>-1 && l>-1){
			if (this.board[k][l] instanceof Queen)
				return false;
			
			k++;
		}
		
		k = i;
		l = j;
		while(k < size && l < size && k>-1 && l>-1){
			if (this.board[k][l] instanceof Queen)
				return false;
			
			k--;
		}
		
		return true;
		
		
	}
	
	public String toStringAccess(){
		StringBuilder sB = new StringBuilder();
		for(int i = 0; i < size; i++){
			for(int j = 0; j < size; j++){
				if(this.isAccessible(i, j))
					sB.append("- ");
				else
					sB.append("X ");
			}
			sB.append("\n");
		}
		return sB.toString();
	}
	

	public int numberOfAccessible() {
		int cpt = 0;
		for(int i = 0; i < size; i++){
			for(int j = 0; j < size; j++){
				if(isAccessible(i, j))
					cpt++;
			}
		}
		return cpt;
	}

	public int numberOfQueens() {
		int cpt = 0;
		for(int i = 0; i < size; i++){
			for(int j = 0; j < size; j++){
				if(board[i][j] instanceof Queen)
					cpt++;
			}
		}
		return cpt;
	}
	
	public boolean placeQueen(int i, int j) {
		if(isAccessible(i, j)){
			this.setPiece(i, j, new Queen(game.getPlayer0()));
			return true;
		}
			
		return false;
	}
	
	//----------TP2-----------------------
	public ArrayList<Board> depthFirstSearch(Board b) {
		ArrayList<Board> sol = new ArrayList<Board>();
		if(b.isSolution()){
			sol.add(b);
			return sol;
		}
		ArrayList<Board> suc = b.getSuccessors();
		for(Board bo : suc){
			try{
				sol = depthFirstSearch(bo);
				sol.add(b);
				return sol;
			}catch (NoSuchElementException e){
				//System.out.println("Echec");
			}
		}
		throw new NoSuchElementException();
	}
	
	public ArrayList<Board> depthFirstSearch(){
		ArrayList<Board> sol = new ArrayList<Board>();
		Board b = new Board();
		try{
			sol = depthFirstSearch(b);
			return sol;
		}catch (NoSuchElementException e){
			//System.out.println("Echec");
		}
		throw new NoSuchElementException();
	}
	
	public boolean isSolution(){
		return this.size == this.numberOfPieces;
	}
	
	public ArrayList<Board> getSuccessors(){
		ArrayList<Board> listeSucc = new ArrayList<Board>();
		for(int ligne = 0; ligne < this.size; ligne ++){
			for(int col = 0; col < this.size; col ++){
				Board b = this.clone();
				if(b.placeQueen(col, ligne)){
					listeSucc.add(b);
				}
			}
		}
		return listeSucc;
	}
	
	public String solutionSteps(Board b){
		ArrayList<Board> temp = depthFirstSearch(b);
		StringBuilder sB = new StringBuilder();
		for(int i = temp.size()-1; i >= 0; i--){
			sB.append(temp.get(i).toString());
			sB.append("\n");
		}
		return sB.toString();
	}
	
	//------------TP3----------------------
	public boolean isAccessible2(int i, int j, Player currentPlayer) {
		// TODO Auto-generated method stub
		return false;
	}
	
	
	public boolean placeQueen2(int i, int j, Player player) {
		// TODO Auto-generated method stub
		return false;
	}

	public boolean placeRock2(int i, int j, Player player) {
		// TODO Auto-generated method stub
		return false;
	}
	
	public int getNumberOfRocksLeft(Player player){
		// TODO Auto-generated method stub
		return 0;  
	}
	
	public int getScore(Player player){
		// TODO Auto-generated method stub
		return 0;
	}



	//----------------------TP4&5--------------------------
	public boolean isFinal() {
		// TODO Auto-generated method stub
		return false;
	}

	public Board minimax(Board b, Player currentPlayer, int minimaxDepth, Eval evaluation) {
		// TODO Auto-generated method stub
		return null;
	}
	
	
	





	
	

}
