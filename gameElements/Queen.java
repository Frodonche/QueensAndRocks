package gameElements;

public class Queen implements Square{
	protected Player player;
	
	public Queen(Player player){
		this.player = player;
	}
	
	@Override
	public void setPlayer(Player player) {
		this.player = player;
	}

	@Override
	public Player getPlayer() {
		return this.player;
	}
	
	@Override
	public String toString(){
		return "Q"+ player.getNumber();
	}

}
