package gui;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Image;
import java.awt.Toolkit;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.util.ArrayList;
import java.util.concurrent.TimeUnit;

import javax.swing.JPanel;
import logic.GameManager;
import logic.Player;
import logic.Position;

public class QbertPanel extends JPanel implements KeyListener {

	private static final int DEMO_SCREEN = 0, PLAY_SCREEN = 1 , SITTED=0 , LIFTED_UP=1;
	private int screenStatus;
	private boolean first=true;
	private Toolkit tk = Toolkit.getDefaultToolkit();
	private Image demoScreenBackground;
	private ArrayList<Image> pressAnyKey = new ArrayList<Image>();
	private int indexPAK = 0 , animationRow=0;
	private Image block, blockc, changeto, level, round, row1, row2, life, change , nlevel , nround , logo;
	private ArrayList<Image> d_right , d_left , u_right , u_left ;
	private GameManager gm;
	private int initialQbertIndex;
	private ArrayList<Position> blockPosition = new ArrayList<Position>();

	public QbertPanel() {
		screenStatus = DEMO_SCREEN;
		demoScreenBackground = tk.getImage(this.getClass().getResource("resources//demo//QbertRebooted.jpg"));
		d_right=new ArrayList<Image>();
		d_left=new ArrayList<Image>();
		u_right=new ArrayList<Image>();
		u_left=new ArrayList<Image>();
		for (int i = 0; i < 7; i++)
			pressAnyKey.add(tk.getImage(this.getClass().getResource("resources//demo//pak" + (i + 1) + ".png")));
		gm = new GameManager();
		initialQbertIndex=gm.posQbert();
		Sketcher sk = new Sketcher();
		new Thread(sk).start();
	}

	public void paintComponent(Graphics g) {
		super.paintComponent(g);
		if (screenStatus == DEMO_SCREEN) {
			paintDemoScreen(g);
		}
		if (screenStatus == PLAY_SCREEN) {
			paintPlayScreen(g);
		}
	}

	private void paintDemoScreen(Graphics g) {
		g.drawImage(demoScreenBackground, 0, 0, this);
		g.drawImage(pressAnyKey.get(indexPAK), 480, 700, this);
		indexPAK = (indexPAK + 1) % pressAnyKey.size();
	}

	private void paintPlayScreen(Graphics g) {
		g.setColor(Color.BLACK);
		g.fillRect(0, 0, this.getWidth(), this.getHeight());
		g.drawImage(logo, 50, 50, this);
		g.drawImage(changeto, 50, 100, this);
		if(animationRow>3) {
		g.drawImage(row2, 50, 110, this);
		g.drawImage(row1, 89, 110, this);
		}
		if(animationRow>6) {
		g.drawImage(row2, 58, 110, this);
		g.drawImage(row1, 81, 110, this);
		}
		g.drawImage(change, 66, 110, this);
		animationRow=(animationRow+1)%10;
		g.drawImage(level, 1000, 150, this);
		g.drawImage(round, 1000, 160, this);
		g.drawImage(nlevel, 1040, 150, this);
		g.drawImage(nround, 1040, 160, this);
		for (int i = 0; i < gm.getQbertLife(); i++)
			g.drawImage(life, 50, 150 + (i * 22), this);
		int originx = 600;
		int originy = 250;
		int numBlock = 1;
		for (int i = 0; i < gm.getNumLevel(); i++) {
			for (int j = 0; j < numBlock; j++) {
				if (numBlock == 1) {
					g.drawImage(block, originx, originy, this);
					if(first)blockPosition.add(new Position(originx, originy));
				} else {
					if (j == 0) {
						originx = originx - 16;
						originy = originy + 24;
					}
					g.drawImage(block, originx + (j * 32), originy, this);
					if(first)blockPosition.add(new Position(originx + (j * 32), originy));
				}
			}
			first=false;
			numBlock = numBlock + 1;
		}
		drawPlayer(g);
	}

	// ****************//
	// EVENTI DEL MOUSE//
	// ****************//

	public void keyPressed(KeyEvent arg0) {
		block = tk.getImage(this.getClass().getResource("resources//play//block4.png"));
		changeto = tk.getImage(this.getClass().getResource("resources//play//changeto.png"));
		row1 = tk.getImage(this.getClass().getResource("resources//play//row1.png"));
		row2 = tk.getImage(this.getClass().getResource("resources//play//row2.png"));
		change = tk.getImage(this.getClass().getResource("resources//play//block3.png"));
		life = tk.getImage(this.getClass().getResource("resources//play//q8.png"));
		level= tk.getImage(this.getClass().getResource("resources//play//level.png"));
	    round= tk.getImage(this.getClass().getResource("resources//play//round.png"));
	    nround= tk.getImage(this.getClass().getResource("resources//play//"+gm.getLevel()+".png"));
	    nlevel= tk.getImage(this.getClass().getResource("resources//play//"+gm.getRound()+".png"));
	    logo=tk.getImage(this.getClass().getResource("resources//play//qbert_logo.png"));
	    d_left.add(tk.getImage(this.getClass().getResource("resources//play//q7.png")));
	    d_left.add(tk.getImage(this.getClass().getResource("resources//play//q8.png")));
	    d_right.add(tk.getImage(this.getClass().getResource("resources//play//q5.png")));
	    d_right.add(tk.getImage(this.getClass().getResource("resources//play//q6.png")));
	    u_left.add(tk.getImage(this.getClass().getResource("resources//play//q3.png")));
	    u_left.add(tk.getImage(this.getClass().getResource("resources//play//q4.png")));
	    u_right.add(tk.getImage(this.getClass().getResource("resources//play//q1.png")));
	    u_right.add(tk.getImage(this.getClass().getResource("resources//play//q2.png")));
	    screenStatus = PLAY_SCREEN;

	}
	
	private void drawPlayer(Graphics g) {
		if(initialQbertIndex==gm.posQbert()) {
			g.drawImage(getQbertImage(SITTED),blockPosition.get(initialQbertIndex).getX()+8 , blockPosition.get(initialQbertIndex).getY()-4,this);
		}
		
		
	}
	
	private Image getQbertImage(int index) {
		if(gm.getPlayerStatus()==Player.Status.D_LEFT) {
			return d_left.get(index);
		}
		if(gm.getPlayerStatus()==Player.Status.U_LEFT) {
			return u_left.get(index);
		}
		if(gm.getPlayerStatus()==Player.Status.D_RIGHT) {
			return d_right.get(index);
		}
		return u_right.get(index);
	}

	public void keyReleased(KeyEvent arg0) {

	}

	public void keyTyped(KeyEvent arg0) {

	}

	// ****************//
	// EVENTI DEL MOUSE//
	// ****************//

	private class Sketcher implements Runnable {

		private static final int FPS = 60;

		public void run() {
			while (true) {
				try {
					TimeUnit.MILLISECONDS.sleep(FPS);
					QbertPanel.this.repaint();
				} catch (InterruptedException e) {
				}
			}
		}

	}

}
