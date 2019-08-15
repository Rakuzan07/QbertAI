package logic;
import java.util.ArrayList;
import java.util.HashMap;

import logic.Player.Status;

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
	
	public int posQbert() {
		return world.blockIndex(position.get(qbert));
	}
	
	public int goDownLeft() {
		qbert.setState(Player.Status.D_LEFT);
		IsometricBlock temp_pos=position.get(qbert);
		if(temp_pos.getAdiacentDownLeft()!=null){
			position.put(qbert, temp_pos.getAdiacentDownLeft());
		}
		return world.blockIndex(temp_pos);
	}
	
	public int goDownRight() {
		qbert.setState(Player.Status.D_RIGHT);
		IsometricBlock temp_pos=position.get(qbert);
		if(temp_pos.getAdiacentDownRight()!=null){
			position.put(qbert, temp_pos.getAdiacentDownRight());
		}
		return world.blockIndex(temp_pos);
	}
	
	public int goUpLeft() {
		qbert.setState(Player.Status.U_LEFT);
		IsometricBlock temp_pos=position.get(qbert);
		if(temp_pos.getAdiacentUpLeft()!=null){
			position.put(qbert, temp_pos.getAdiacentUpLeft());
		}
		return world.blockIndex(temp_pos);
	}
	
	public int goUpRight() {
		qbert.setState(Player.Status.U_RIGHT);
		IsometricBlock temp_pos=position.get(qbert);
		if(temp_pos.getAdiacentUpRight()!=null){
			position.put(qbert, temp_pos.getAdiacentUpRight());
		}
		return world.blockIndex(temp_pos);
	}
	
	public Status getPlayerStatus() {
		return qbert.getState();
	}
}
