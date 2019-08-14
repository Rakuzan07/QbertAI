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
import logic.Position;

public class QbertPanel extends JPanel implements KeyListener {

	private static final int DEMO_SCREEN = 0, PLAY_SCREEN = 1;
	private int screenStatus;
	private Toolkit tk = Toolkit.getDefaultToolkit();
	private Image demoScreenBackground;
	private ArrayList<Image> pressAnyKey = new ArrayList<Image>();
	private int indexPAK = 0;
	private Image block, blockc, changeto, level, round, row1, row2, life, qberti, change , nlevel , nround;
	private GameManager gm;
	private ArrayList<Position> blockPosition = new ArrayList<Position>();

	public QbertPanel() {
		screenStatus = DEMO_SCREEN;
		demoScreenBackground = tk.getImage(this.getClass().getResource("resources//demo//QbertRebooted.jpg"));
		for (int i = 0; i < 7; i++)
			pressAnyKey.add(tk.getImage(this.getClass().getResource("resources//demo//pak" + (i + 1) + ".png")));
		gm = new GameManager();
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
		g.drawImage(changeto, 50, 100, this);
		g.drawImage(row2, 50, 110, this);
		g.drawImage(row2, 58, 110, this);
		g.drawImage(change, 66, 110, this);
		g.drawImage(row1, 81, 110, this);
		g.drawImage(row1, 89, 110, this);
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
					blockPosition.add(new Position(originx, originy));
				} else {
					if (j == 0) {
						originx = originx - 16;
						originy = originy + 24;
					}
					g.drawImage(block, originx + (j * 32), originy, this);
					blockPosition.add(new Position(originx + (j * 32), originy));
				}
			}
			numBlock = numBlock + 1;
		}
	}

	// ****************//
	// EVENTI DEL MOUSE//
	// ****************//

	public void keyPressed(KeyEvent arg0) {
		block = tk.getImage(this.getClass().getResource("resources//play//block1.png"));
		changeto = tk.getImage(this.getClass().getResource("resources//play//changeto.png"));
		row1 = tk.getImage(this.getClass().getResource("resources//play//row1.png"));
		row2 = tk.getImage(this.getClass().getResource("resources//play//row2.png"));
		change = tk.getImage(this.getClass().getResource("resources//play//block3.png"));
		life = tk.getImage(this.getClass().getResource("resources//play//q8.png"));
		level= tk.getImage(this.getClass().getResource("resources//play//level.png"));
	    round= tk.getImage(this.getClass().getResource("resources//play//round.png"));
	    nround= tk.getImage(this.getClass().getResource("resources//play//"+gm.getLevel()+".png"));
	    nlevel= tk.getImage(this.getClass().getResource("resources//play//"+gm.getRound()+".png"));
	    screenStatus = PLAY_SCREEN;

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
