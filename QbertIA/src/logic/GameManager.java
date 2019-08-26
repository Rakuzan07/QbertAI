package logic;
import java.io.File;
import java.lang.reflect.InvocationTargetException;
import java.util.HashMap;
import java.util.List;

import it.unical.mat.embasp.languages.IllegalAnnotationException;
import it.unical.mat.embasp.languages.ObjectNotValidException;
import it.unical.mat.embasp.languages.asp.ASPMapper;
import it.unical.mat.embasp.languages.asp.AnswerSet;
import logic.Player.Status;

public class GameManager {
	
	//CLASSE A CUI SI DELEGA LA GESTIONE DELLA PARTE LOGICA E DELL'AI , PERMETTENDO LA COMUNICAZIONE
	// TRA LA CLASSE PLAYER/ENEMY E LA CLASSE WORLD 
	
	private Player qbert;
	private World world;
	private HashMap<Player,IsometricBlock> position=new HashMap<Player,IsometricBlock>();
	private ASPConnector findTarget;
	private int level , round ;
	
	public GameManager() {
		world=new World();
		qbert=new Player();
		position.put(qbert, world.getBlock(0));
		level=1;
		round=1;
		findTarget = new ASPConnector("QbertIA" + File.separator + "src" + File.separator +
				"encodings" + File.separator + "computetarget");
	}
	
	public void setBlockVisited(int index) {
		world.setVisited(index);
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

	public void fillAdjacentBlocks(){
        int blockpos= world.blockIndex(position.get(qbert));
		findTarget.putFact("actualPosition("+blockpos+").");
        
		for (int i = 0; i < world.getIsometricBlockNumber(); i++) {
			if(world.isVisited(i))findTarget.putFact("painted("+i+")");
		}
		for (int i = 0; i < world.getIsometricBlockNumber(); i++) {
			findTarget.putFact(world.getBlock(i));
		}
		
		for (int i = 0; i < world.getIsometricBlockNumber(); i++) {
			IsometricBlock[] adjacents = world.getBlock(i).getAdiacent();
			for (int j = 0; j < adjacents.length; j++) {
				if(adjacents[j] != null) {
					findTarget.putFact(new AdjacentBlocks(i, adjacents[j].getId()));
				}
			}
		}
	}

	public void computeBlocksPaths(){

		try {
			ASPMapper.getInstance().registerClass(Target.class);
		} catch (IllegalAnnotationException | ObjectNotValidException e) {
			e.printStackTrace();
		}

		List<AnswerSet> answerSetList = findTarget.startSync();
		System.out.println(answerSetList.size());
		for (AnswerSet answerSet : answerSetList) {
			try {
				for (Object o : answerSet.getAtoms()) {
					if(o instanceof Target){
						Target target = (Target) o;
						System.out.println(target);
					}
				}
			} catch (IllegalAccessException | InvocationTargetException | NoSuchMethodException | InstantiationException e) {
				e.printStackTrace();
			}
		}
	}
	
	
	public boolean isVisited(int index) {
		return world.isVisited(index);
	}

}
