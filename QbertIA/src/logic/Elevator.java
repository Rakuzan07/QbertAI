package logic;

public class Elevator extends Element{
	
	IsometricBlock adjacent ;
	
	public Elevator(IsometricBlock adjacent) {
		visited=false;
		this.adjacent=adjacent;
	}
	
	
	
	public void setVisited(boolean visited) {
		this.visited=visited;
	}
	
	public boolean isVisited() {
		return visited;
	}
	
	


}
