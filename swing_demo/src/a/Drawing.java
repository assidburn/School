package a;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.RenderingHints;

import javax.swing.JFrame;
import javax.swing.JPanel;

public class Drawing extends JPanel {

	private int mCellWidth = 20; 	// pixels per cell
	private int mCellHeight = 20;
	
	private int mRows;
	private int mCols;

	public Drawing (int rows, int cols) {
		
		mRows = rows;
		mCols = cols;
		
        //Create and set up the drawing area
        JFrame frame = new JFrame("Drawing");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
 
        //Create and set up the content pane.
        setOpaque(true); //content panes must be opaque
        frame.setContentPane(this);
 
        //Display the window.
        frame.setSize(new Dimension(mCols * mCellWidth, mRows * mCellHeight));
//	        frame.pack();
        frame.setVisible(true);
	}

    public void paint(Graphics g) {
        Graphics2D g2 = (Graphics2D) g;
        g2.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);
        Dimension d = getSize();
        int gridWidth = d.width / 6;
        int gridHeight = d.height / 2;
        
        g2.setColor(Color.blue);
        g2.fillRect(mCellWidth * 2, mCellWidth, mCellHeight, mCellHeight);
    }
}
