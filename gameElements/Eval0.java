package gameElements;

public class Eval0 implements Eval{

	public Eval0(){
		
	}
	
	@Override
	public float getEval(Player player, Board b) {
		int res = 0;
		if(player.getNumber() == 0){ // si on a passé le joueur0 en paramètre
			res = b.getScore(player) - b.getScore(b.getGame().getPlayer1()); // res = scoreJoueur0 - scoreJoueur1
		}
		if(player.getNumber() == 1){ // si on a passé le joueur1 en paramètre
			res = b.getScore(player) - b.getScore(b.getGame().getPlayer0()); // res = scoreJoueur1 - scoreJoueur0
		}
		return res;
	}

}
