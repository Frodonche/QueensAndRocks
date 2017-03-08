package gameElements;

public class Game {
	protected Player player0; 
	protected Queen queen0;
	protected Rock rock0;
	
	protected Player player1; 
	protected Queen queen1;
	protected Rock rock1;
	
	protected Empty empty;
	
	public Game(){
		player0 = new Player(0);
		queen0 = new Queen(player0);
		rock0 = new Rock(player0);
		
		player1 = new Player(1);
		queen1 = new Queen(player1);
		rock1 = new Rock(player1);
		
		empty = new Empty();
	}
	
	public Player getPlayer0(){
		return this.player0;
	}
	
	public Player getPlayer1(){
		return this.player1;
	}
	
	public Queen getQueen0(){
		return this.queen0;
	}
	
	public Queen getQueen1(){
		return this.queen1;
	}
	
	public Rock getRock0(){
		return this.rock0;
	}
	
	public Rock getRock1(){
		return this.rock1;
	}
	
	public Empty getEmpty(){
		return this.empty;
	}
	
	public void setColorMode(String cM){
		this.player0.setColorMode(cM);
		this.player1.setColorMode(cM);
	}
	
	public Player otherPlayer(Player player){
		Player res;
		if (player.getNumber() == player0.getNumber())
			res = player1;
		else
			res = player0;
		return res;
	}
}
