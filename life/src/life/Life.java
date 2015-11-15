package life;

import javax.swing.JFrame;

public class Life {

	
	
	
	private boolean[][] grid;
	private int maxcolumns;
	private int maxrows;	
	
	JFrame frame = new JFrame("life simulation");
	LifefePanel panel = new LifefePanel(grid);

	public static void main(String[] args) {
		Life x =  new Life(10,10);
		for(int i = 0; i <4; ++i) {
			x.step();	
			x.display();
		}

	}
	
	private void display() {
		for(int row = 0; row <maxrows; ++row) {	
			for(int column = 0; column <maxcolumns; ++column)				
			{
//				System.out.print(grid[row][column]);
				
				if(grid[row][column]) 
					System.out.print("X");				
				else
					System.out.print("O");
			}
			System.out.println();
			
		}
		
	}

	/**
	 * method will compute and display next generation of cells
	 */
	private void step() {
		
		boolean[][] newGrid = new boolean [maxcolumns][maxrows];

		//for each cell count number of neighbors
		//0 or 1 neighbors - dies of loneliness
		//2 or 3 neighbors - survives to next round
		//4 or more neighbors - dies of overcrowding
		//If dead and 3 neighbors - becomes populated
		for(int row = 0; row <maxrows; ++row) {	
			for(int column = 0; column <maxcolumns; ++column)				
			{
				if(neighbors(row, column) < 1)				
					newGrid[row][column] = false;//cell = false
				if(grid[row][column] == true && (neighbors(row, column) == 2 || neighbors(row, column) == 3))	
					newGrid[row][column] = true; //cells = true
				if(neighbors(row, column) >= 4 )
					newGrid[row][column] = false;//cells = false
				if(grid[row][column] == false && (neighbors(row, column)  == 3))
					newGrid[row][column] = true;//cells = true
			}
		}
		
		grid = newGrid;
	}

	public Life (int maxcolumns, int maxrows) {
		this.maxcolumns = maxcolumns;
		this.maxrows = maxrows;
		grid = new boolean [maxcolumns][maxrows];	
		
		grid[1][0] = true;
		grid[1][1] = true;
 		grid[1][2] = true;
		grid[2][1] = true;
		grid[2][2] = true;
//		System.out.println(maxrows);
//		System.out.println(maxcolumns);
		
		// initialize some set of cells
		//step through 5 generations
		//print each generation

	}
	
int neighbors(int r, int c){
	int rm = r-1; 
	if(rm < 0)
		rm = maxrows -1;
	int cm = c-1; 
	if(cm <  0)
		cm = maxcolumns -1;
	int rp = r+1; 
	if(rp >= maxrows)
		rp = 0;
	int cp = c+1;
	if(cp >= maxcolumns)
		cp = 0;
	
	int a =  convertToInt(grid[rm][cm])+convertToInt(grid[rm][c])+convertToInt(grid[rm][cp])
			+convertToInt(grid[r][cm])+convertToInt(grid[r][cp])
			+convertToInt(grid[rp][cm])+convertToInt(grid[rp][c])+convertToInt(grid[rp][cp]);
	return a;

}

private int convertToInt(boolean b) {
	if(b) {
		return 1;
	}
	return 0;
	
	
}

}

