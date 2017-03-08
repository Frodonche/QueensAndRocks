package gameElements;

public class Rock implements Square{
	protected Player player;
	
	public Rock(Player player){
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
		return "R"+player.getNumber();
	}

}
