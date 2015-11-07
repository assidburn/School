package life;

import java.awt.BorderLayout;

import javax.swing.JFrame;

public class Life {

	private boolean[][] grid;
	private int maxcolumns;
	private int maxrows;	

	public static void main(String[] args) {
		Life x =  new Life(10,10);
		for(int i = 0; i <5; ++i) {
			x.step();	
			x.display();
		}

	}
	
	private void display() {
		for(int i = 0; i <maxcolumns; ++i) {
			for(int j = 0; j <maxrows; ++j) {
				System.out.println(grid[i][j]);
			}
		}
		
		
	}

	/**
	 * method will compute and display next generation of cells
	 */
	private void step() {
	}

	public Life (int maxcolumns, int maxrows) {
		this.maxcolumns = maxcolumns;
		this.maxrows = maxrows;
		grid = new boolean [maxcolumns][maxrows];	
	
//		System.out.println(maxrows);
//		System.out.println(maxcolumns);
		
		// initalize some set of cells
		//step through 5 generations
		//print each generation

	}
	
	
}
