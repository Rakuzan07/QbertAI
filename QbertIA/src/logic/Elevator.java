package logic;

public class Elevator extends Element{
	
	IsometricBlock adjacent ;
	
	public Elevator(IsometricBlock adjacent) {
		visited=1;
		this.adjacent=adjacent;
	}
	
	
	
	public void setVisited(int visited) {
		this.visited=visited;
	}
	
	public boolean isVisited() {
		return visited==0;
	}
	
	public void visit() {
		if(visited>0)visited--;
	}
	
	


}
