package logic;

public class GreenMan extends Player{
     
	private static final int BONUS=300;
	
	public GreenMan(int cont) {
		super(cont);
	    life=1;
	}
	
	public int getBonus() {
		return BONUS;
	}
	
}
