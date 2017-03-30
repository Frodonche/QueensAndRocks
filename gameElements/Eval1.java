package gameElements;

public class Eval1 implements Eval{
	
	public Eval1(){
		
	}
	
	@Override
	public float getEval(Player player, Board b) {
		int res = 0;
		if(player.getNumber() == 0){ // si on a passé le joueur0 en paramètre
			res = b.numberOfAccessible2(player) - b.numberOfAccessible2(b.getGame().getPlayer1())
					+ (b.numberOfQueens2(player)*8) - (b.numberOfQueens2(b.getGame().getPlayer1())*8);
			// correspond à nb cases accessibles - nb cases adverses accessibles + nb cases imprenables - nb cases imprenables adverses
		}
		if(player.getNumber() == 1){ // si on a passé le joueur1 en paramètre
			res = b.numberOfAccessible2(player) - b.numberOfAccessible2(b.getGame().getPlayer1())
					+ (b.numberOfQueens2(player)*8) - (b.numberOfQueens2(b.getGame().getPlayer1())*8);
		}
		return res;
	}
}
