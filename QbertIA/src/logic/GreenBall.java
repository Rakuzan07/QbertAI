package logic;

public class GreenBall extends Player{
	
	private static final int BONUS=100;
	
	public GreenBall(int cont) {
		super(cont);
	    life=1;
	}
	
	public int getBonus() {
		return BONUS;
	}

}
