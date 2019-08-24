package logic;

import it.unical.mat.embasp.languages.Id;
import it.unical.mat.embasp.languages.Param;

@Id("isometricBlock")
public class IsometricBlock extends Element {

	@Param(0)
	private int id;

	IsometricBlock[] adiacent=new IsometricBlock[4];
	
	public IsometricBlock() {
		visited=false;
	}
	
	public IsometricBlock[] getAdiacent() {
		return adiacent;
	}
	
	public void setVisited(boolean visited) {
		this.visited=visited;
	}
	
	public boolean isVisited() {
		return visited;
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
	
	public IsometricBlock getAdiacentUpRight() {
		return adiacent[0];
	}
	
	public IsometricBlock getAdiacentUpLeft() {
		return adiacent[1];
	}
	
	public IsometricBlock getAdiacentDownRight() {
		return adiacent[2];
	}
	
	public IsometricBlock getAdiacentDownLeft() {
		return adiacent[3];
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}
}
