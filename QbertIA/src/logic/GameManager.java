package logic;
import java.io.File;
import java.lang.reflect.InvocationTargetException;
import java.util.HashMap;
import java.util.List;
import java.util.Random;

import it.unical.mat.embasp.languages.IllegalAnnotationException;
import it.unical.mat.embasp.languages.ObjectNotValidException;
import it.unical.mat.embasp.languages.asp.ASPMapper;
import it.unical.mat.embasp.languages.asp.AnswerSet;
import logic.Player.Status;

public class GameManager {
	
	//CLASSE A CUI SI DELEGA LA GESTIONE DELLA PARTE LOGICA E DELL'AI , PERMETTENDO LA COMUNICAZIONE
	// TRA LA CLASSE PLAYER/ENEMY E LA CLASSE WORLD 
	
	
	private GameFactory gf;
	private Player qbert;
	private World world;
	private HashMap<Player,IsometricBlock> position=new HashMap<Player,IsometricBlock>();
	private ASPConnector findTarget;
	private int level , round ;
	
	public GameManager() {
		gf=new GameFactory();
		world=new World();
		qbert=gf.createQbert();
		position.put(qbert, world.getBlock(0));
		level=1;
		round=1;
		findTarget = new ASPConnector("QbertIA" + File.separator + "src" + File.separator +
				"encodings" + File.separator + "computetarget");
		world.setElevatorAdiacent(0, 6);
		world.setElevatorAdiacent(1, 9);
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
	public int moveEnemy(Player p) {
		if (p instanceof Ball || (p instanceof Snake && ((Snake) p).getStatusHatch())) {
			Random r=new Random();
			int random=r.nextInt(100);
			if(random<=50) {
				p.setState(Player.Status.D_LEFT);
				IsometricBlock temp_pos=position.get(p);
				if(temp_pos.getAdiacentDownLeft()!=null){
					position.put(p, temp_pos.getAdiacentDownLeft());
				}
				return world.blockIndex(temp_pos);
			}
			else {
				p.setState(Player.Status.D_RIGHT);
				IsometricBlock temp_pos=position.get(p);
				if(temp_pos.getAdiacentDownRight()!=null){
					position.put(p, temp_pos.getAdiacentDownRight());
				}
				return world.blockIndex(temp_pos);
			}
		} 
		return -1;
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

	public void putFactsToComputeTargets(){

		int blockpos= world.blockIndex(position.get(qbert));
		findTarget.putFact("actualPosition("+blockpos+").");

		for(Player p: position.keySet())  {
			if(p!=qbert) {
				blockpos = world.blockIndex(position.get(p));
				findTarget.putFact("enemy("+blockpos+").");
			}
		}

		findTarget.putFact("painted(0).");

		for (int i = 0; i < World.NUM_ELEVATOR; i++) {
			int elevatorAdiacent = world.getElevatorAdiacent(i);
			if(world.getBlock(elevatorAdiacent).getAdiacentUpRight() == null)
				findTarget.putFact("elevator(" + elevatorAdiacent + ", UR).");
			else
				findTarget.putFact("elevator(" + elevatorAdiacent + ", UL).");
		}

		for (int i = 0; i < world.getIsometricBlockNumber(); i++) {
			if(world.isVisited(i))findTarget.putFact("painted("+i+")");
		}

		for (int i = 0; i < world.getIsometricBlockNumber(); i++) {
			findTarget.putFact(world.getBlock(i));
		}

		for (int i = 0; i < world.getIsometricBlockNumber(); i++) {

			if(world.getBlock(i).getAdiacentDownLeft() != null) {
				findTarget.putFact(new AdjacentBlocks(i, world.getBlock(i).getAdiacentDownLeft().getId(), "DL"));
			}

			if(world.getBlock(i).getAdiacentDownRight() != null) {
				findTarget.putFact(new AdjacentBlocks(i, world.getBlock(i).getAdiacentDownRight().getId(), "DR"));
			}

			if(world.getBlock(i).getAdiacentUpLeft() != null) {
				findTarget.putFact(new AdjacentBlocks(i, world.getBlock(i).getAdiacentUpLeft().getId(), "UL"));
			}

			if(world.getBlock(i).getAdiacentUpRight() != null) {
				findTarget.putFact(new AdjacentBlocks(i, world.getBlock(i).getAdiacentUpRight().getId(), "UR"));
			}
		}
	}

	public void computeBlocksPaths(){

		try {
			ASPMapper.getInstance().registerClass(PositionToTake.class);
		} catch (IllegalAnnotationException | ObjectNotValidException e) {
			e.printStackTrace();
		}

		List<AnswerSet> answerSetList = findTarget.startSync();
		System.out.println(answerSetList.size());
		for (AnswerSet answerSet : answerSetList) {
			try {
				for (Object o : answerSet.getAtoms()) {
					if(o instanceof PositionToTake){
						PositionToTake target = (PositionToTake) o;
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

	public void generateEnemy() {
		int ballprob=50;
		for(Player p : position.keySet()) {
			if(p instanceof Snake) { ballprob=ballprob+10; }
			else if (p instanceof Ball) { ballprob=ballprob-10;}
		}
		Random r=new Random();
		int random=r.nextInt(100);
		if(random<=ballprob) {
			Ball b=gf.createBall();
			if(random%2==0)position.put(b, world.getBlock(1));
			else position.put(b, world.getBlock(2));
		}
		else {
			Snake s=gf.createSnake();
			if(random%2==0)position.put(s, world.getBlock(1));
			else position.put(s, world.getBlock(2));
		}
	}
}
