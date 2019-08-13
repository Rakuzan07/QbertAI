package gui;

import java.awt.Graphics;
import java.awt.Image;
import java.awt.Toolkit;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

import javax.swing.JPanel;

public class QbertPanel extends JPanel implements KeyListener {

	
	private static final int DEMO_SCREEN=0 , PLAY_SCREEN=1;
	private int screenStatus;
	private Toolkit tk=Toolkit.getDefaultToolkit();
	private Image demoScreenBackground;
	
	public QbertPanel() {
		screenStatus=DEMO_SCREEN;
		demoScreenBackground= tk.getImage(this.getClass().getResource("resources//demo//QbertRebooted.jpg"));
	}
	
	public void paintComponent(Graphics g) {
		super.paintComponent(g);
		if (screenStatus == DEMO_SCREEN) {
			paintDemoScreen(g);
		}
		}
	
	
	private void paintDemoScreen(Graphics g) {
		g.drawImage(demoScreenBackground, 0 , 0 , this);
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

}
