package gameElements;

public class Empty implements Square{
	protected Player player;
	
	public Empty(){
		this.player = new Player(0);//player par défaut 0
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
		return "--";
	}

}
