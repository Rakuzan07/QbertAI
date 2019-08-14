package gui;

import java.awt.Graphics;
import java.awt.Image;
import java.awt.Toolkit;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.util.ArrayList;
import java.util.concurrent.TimeUnit;

import javax.swing.JPanel;


public class QbertPanel extends JPanel implements KeyListener {

	
	private static final int DEMO_SCREEN=0 , PLAY_SCREEN=1;
	private int screenStatus;
	private Toolkit tk=Toolkit.getDefaultToolkit();
	private Image demoScreenBackground;
	private ArrayList<Image> pressAnyKey=new ArrayList<Image>();
	private int indexPAK=0;
	
	public QbertPanel() {
		screenStatus=DEMO_SCREEN;
		demoScreenBackground= tk.getImage(this.getClass().getResource("resources//demo//QbertRebooted.jpg"));
		for(int i=0;i<7;i++)pressAnyKey.add(tk.getImage(this.getClass().getResource("resources//demo//pak"+(i+1)+".png")));
		Sketcher sk=new Sketcher();
		new Thread(sk).start();
	}
	
	public void paintComponent(Graphics g) {
		super.paintComponent(g);
		if (screenStatus == DEMO_SCREEN) {
			paintDemoScreen(g);
		}
		}
	
	
	private void paintDemoScreen(Graphics g) {
		g.drawImage(demoScreenBackground, 0 , 0 , this);
		g.drawImage(pressAnyKey.get(indexPAK), 480,700, this);
		indexPAK=(indexPAK+1)%pressAnyKey.size();
	}
	
	
	
	//****************//
	//EVENTI DEL MOUSE//
	//****************//
	
	public void keyPressed(KeyEvent arg0) {
		screenStatus=PLAY_SCREEN;
		
	}

	
	public void keyReleased(KeyEvent arg0) {
		
		
	}

	
	public void keyTyped(KeyEvent arg0) {
		
	}
	
	//****************//
	//EVENTI DEL MOUSE//
	//****************//
	
	private class Sketcher implements Runnable {

		private static final int FPS = 60;

		public void run() {
			while (true) {
				try {
					System.out.println("a");
					TimeUnit.MILLISECONDS.sleep(FPS);
					QbertPanel.this.repaint();
				} catch (InterruptedException e) {
				}
			}
		}

	}

}
