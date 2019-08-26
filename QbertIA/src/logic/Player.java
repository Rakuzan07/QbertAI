package logic;


public class Player {
	
	public enum Status{U_RIGHT,D_RIGHT,U_LEFT,D_LEFT}
	
	protected int life;
	private Status state=Status.D_LEFT;
	private int id;
	
	public Player(int cont) {
		id=cont;
		life=3;
	}
	
	public Player(int cont,int life) {
		id=cont;
		this.life=life;
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
