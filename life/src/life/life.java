package life;

public class Life {

	private boolean[][] grid;
	private int maxcolumns;
	private int maxrows;	

	public static void main(String[] args) {
		Life x =  new Life(10,10);
		for(int i = 0; i <1; ++i) {
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
		//for each cell count number of neighbors
		//0 or 1 neighbors - dies of loneliness
		//2 or 3 neighbors - survives to next round
		//4 or more neighbors - dies of overcrowding
		//If dead 3 neighbors - becomes populated
		

	}

	public Life (int maxcolumns, int maxrows) {
		this.maxcolumns = maxcolumns;
		this.maxrows = maxrows;
		grid = new boolean [maxcolumns][maxrows];	
		
		grid[3][5] = true;
		grid[3][6] = true;
		grid[3][7] = true;
//		System.out.println(maxrows);
//		System.out.println(maxcolumns);
		
		// initalize some set of cells
		//step through 5 generations
		//print each generation

	}
	
	
}
