package life;

import java.awt.BorderLayout;

import javax.swing.JFrame;

public class life {

	boolean[][] cells = new boolean[10][10];
	JFrame frame = new JFrame("Life simulation");
	lifepanel panel = new lifepanel(cells);
	
	public life() {
		frame.setSize(600,600);
		frame.setLayout(new BorderLayout());
		frame.add(panel, BorderLayout.CENTER);
		
		//github
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setVisible(true);

		
	}
	
	public static void main(String[] args) {
		new life();
}
}
