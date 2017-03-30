package gameElements;

public class Eval2 implements Eval{
	
	public Eval2(){
		
	}
	
	@Override
	public float getEval(Player player, Board b) {
		int res = 0;
		int n = 0; // avec n le nombre de victoires du joueur
		// methode de Monte Carlo
		res = 2*n/100-1;
		return res;
	}
}
