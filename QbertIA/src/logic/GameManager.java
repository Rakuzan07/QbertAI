package logic;
import java.util.ArrayList;
import java.util.HashMap;

public class GameManager {
	
	//CLASSE A CUI SI DELEGA LA GESTIONE DELLA PARTE LOGICA E DELL'AI , PERMETTENDO LA COMUNICAZIONE
	// TRA LA CLASSE PLAYER/ENEMY E LA CLASSE WORLD 
	
	private Player qbert;
	private World world;
	private HashMap<Player,IsometricBlock> position=new HashMap<Player,IsometricBlock>();
	private int level , round ;
	
	public GameManager() {
		world=new World();
		qbert=new Player();
		position.put(qbert, world.getBlock(0));
		level=1;
		round=1;
	}
	
	public int getNumLevel() {
         return world.getNumLevel();
	}
	
	public int getLevel() {
		return level;
	}
	
	public int getRound() {
		return round;
	}

	public int getQbertLife() {
		return qbert.getLife();
	}
}
