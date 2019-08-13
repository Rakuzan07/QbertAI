package gui;

import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.io.IOException;

import javax.imageio.ImageIO;
import javax.swing.JFrame;


public class QbertFrame  extends JFrame {
	
private static final int HEIGHT = 796, WIDTH = 1334;
	
	private QbertPanel qbertPanel;
	
	
	public QbertFrame() {
		this.setSize(WIDTH,HEIGHT);
		this.setTitle("Q*berAI");
		this.setDefaultCloseOperation(EXIT_ON_CLOSE);
		try {
			this.setIconImage(ImageIO.read(this.getClass().getResource("resources//icon//icon.png")));
		} catch (IOException e) {}
		qbertPanel=new QbertPanel();
		this.setContentPane(qbertPanel);
		this.addKeyListener(qbertPanel);
		this.qbertPanel.setVisible(true);
		this.setVisible(true);
	
	}

}
