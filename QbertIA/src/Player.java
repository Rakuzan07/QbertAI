

public class Player {
	
	public enum Status{U_RIGHT,D_RIGHT,U_LEFT,D_LEFT}
	
	private int life;
	private boolean enemy;
	private Status state=Status.D_LEFT;
	private static int CONT=0;
	private int id;
	
	public Player() {
		id=CONT;
		CONT++;
		life=3;
		enemy=false;
	}
	
	public Player(int life) {
		id=CONT;
		CONT++;
		this.life=life;
		enemy=false;
	}
	
	public Player(boolean enemy) {
		id=CONT;
		CONT++;
		this.enemy=enemy;
		life=1;
	}
	
	public Player(int life , boolean enemy) {
		id=CONT;
		CONT++;
		this.life=life;
		this.enemy=enemy;
	}
	
	public boolean isEnemy() {
		return enemy;
	}
	
	public int getLife() {
		return life;
	}
	
	public void setLife(int life) {
		this.life=life;
	}
	
	public int decrementLife() {
		life--;
		return life;
	}
	
	public int incrementLife() {
		life++;
		return life;
	}
	
	public Status getState() {
		return state;
	}
	
	public void setState(Status state) {
		this.state=state;
	}
	
	@Override
	public int hashCode() {
		return id;
	}

}
