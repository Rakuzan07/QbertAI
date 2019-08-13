

public class Player {
	
	public enum Status{U_RIGHT,D_RIGHT,U_LEFT,D_LEFT}
	
	private int life;
	private boolean enemy;
	private Status state=Status.D_LEFT;
	
	
	public Player() {
		life=3;
		enemy=false;
	}
	
	public Player(int life) {
		this.life=life;
		enemy=false;
	}
	
	public Player(boolean enemy) {
		this.enemy=enemy;
		life=1;
	}
	
	public Player(int life , boolean enemy) {
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

}
