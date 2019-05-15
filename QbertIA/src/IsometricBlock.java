
public class IsometricBlock {
	
	private Position position;
	private boolean visited;
	
	public IsometricBlock(Position p) {
		position=new Position(p);
		visited=false;
	}
	
	public IsometricBlock(int cordX , int cordY) {
		position=new Position(cordX,cordY);
		visited=false;
	}
	
	public void setVisited(boolean visited) {
		this.visited=visited;
	}
	
	public boolean isVisited() {
		return visited;
	}
	
	public void setPosition(int cordX , int cordY) {
		position=new Position(cordX , cordY);
	}
	
	public void setPosition(Position p) {
		position=new Position(p);
	}

}
