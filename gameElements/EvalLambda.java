package gameElements;

public class EvalLambda implements Eval{
	protected float lambda;
	
	public EvalLambda(){
		this.lambda = (float) 0.5; // par défaut
	}
	
	@Override
	public float getEval(Player player, Board b) {
		return lambda * new Eval0().getEval(player, b) + (1-lambda) * new Eval1().getEval(player, b);
	}
	
	public float getLambda(){ return this.lambda; }

	public void setLambda(float lambda){
		this.lambda = lambda;
	}
	
}
