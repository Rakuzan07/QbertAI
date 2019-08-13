import java.util.ArrayList;
import java.util.HashMap;

public class GameManager {
	
	//CLASSE A CUI SI DELEGA LA GESTIONE DELLA PARTE LOGICA E DELL'AI , PERMETTENDO LA COMUNICAZIONE
	// TRA LA CLASSE PLAYER/ENEMY E LA CLASSE WORLD 
	
	private Player qbert;
	private World world;
	HashMap<Player,IsometricBlock> position=new HashMap<Player,IsometricBlock>();
	
	public GameManager() {
		world=new World();
		qbert=new Player();
		position.put(qbert, world.getBlock(0));
	}

}
