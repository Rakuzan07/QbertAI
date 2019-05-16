
public class IsometricBlock extends Element {
	
	IsometricBlock[] adiacent=new IsometricBlock[4];
	
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
	
	public void addAdiacentUpRight(IsometricBlock ib) {
		/*LA POSIZIONE 0 DELL'ARRAY DELLE ADIACENZE 
		RAPPRESENTA PER CONVEZIONE L'ISOMETRIC BLOCK IN ALTO A DESTRA*/
		adiacent[0]=ib;
	}
	
	public void addAdiacentUpLeft(IsometricBlock ib) {
		/*LA POSIZIONE 1 DELL'ARRAY DELLE ADIACENZE 
		RAPPRESENTA PER CONVEZIONE L'ISOMETRIC BLOCK IN ALTO A SINISTRA*/
		adiacent[1]=ib;
	}
	public void addAdiacentDownRight(IsometricBlock ib) {
		/*LA POSIZIONE 2 DELL'ARRAY DELLE ADIACENZE 
		RAPPRESENTA PER CONVEZIONE L'ISOMETRIC BLOCK IN BASSO A DESTRA*/
		adiacent[2]=ib;
	}
	
	public void addAdiacentDownLeft(IsometricBlock ib) {
		/*LA POSIZIONE 0 DELL'ARRAY DELLE ADIACENZE 
		RAPPRESENTA PER CONVEZIONE L'ISOMETRIC BLOCK IN BASSO A SINISTRA*/
		adiacent[3]=ib;
	}
	

}
