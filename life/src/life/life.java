package life;

import java.awt.BorderLayout;

import javax.swing.JFrame;

public class lifepanel {

	boolean[][] cells = new boolean[10][10];
	JFrame frame = new JFrame("Life simulation");
	LifePanel = new LifePanel(cells);
	
	public life() {
		frame.setSize(600,600);
		frame.setLayout(new BorderLayout());
		
		
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setVisible(true);

		
	}
	
	public static void main(String[] args) {
		new life();
}
