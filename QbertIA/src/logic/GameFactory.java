package logic;

public class GameFactory {
	
	private static int CONT=0;
	
	public GameFactory() {
		
	}
	
	public Player createQbert() {
	      Player p =new Player(CONT);
	      CONT++;
	      return p;
	}
	
	public Ball createBall() {
		 Ball b =new Ball(CONT);
	      CONT++;
	      return b;
	}
	
	public Snake createSnake() {
		 Snake s = new Snake(CONT);
	      CONT++;
	      return s;
	}
	
	public GreenMan createGreenMan() {
		GreenMan g=new GreenMan(CONT);
		CONT++;
		return g;
	}
	
	public GreenBall createGreenBall() {
		GreenBall b=new GreenBall(CONT);
		CONT++;
		return b;
	}



}
