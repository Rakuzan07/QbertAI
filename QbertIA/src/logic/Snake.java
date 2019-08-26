package logic;

public class Snake extends Player{

	public boolean egg;
	
	public Snake(int cont) {
		super(cont);
        life=1;
        egg=true;
	}
	
	public void hatch() {
		egg=false;
	}
	
	public boolean getStatusHatch() {
		return egg;
	}

}
