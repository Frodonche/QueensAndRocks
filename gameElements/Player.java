package gameElements;

public class Player {
	protected int number;
	protected String colorMode = "bw";
	
	public Player(int num){
		this.number = num;
	}
	
	public int getNumber(){
		return this.number;
	}
	
	public void setNumber(int num){
		this.number = num;
	}
	
	public String getColorMode(){
		return this.colorMode;
	}
	
	public void setColorMode(String cM){
		colorMode = cM;
	}
	
	public String toString(){
		String res = "";
		if (number == 0){
			if (colorMode == "og")
				res = "green";
			if (colorMode == "bw")
				res = "white";
		}
		if (number == 1){
			if (colorMode == "og")
				res = "orange";
			if (colorMode == "bw")
				res = "black";
		}
		return res;
	}
}
