package tictactoe;

import java.util.Scanner;

public class tictactoe {

	int[][] board = new int[3][3];
	final int BLANK = 0;
	final int X_MOVE =1;
	final int O_MOVE = 2;
	Scanner scanner;
	String input = "";
	
	
	public tictactoe() {
		printBoard();
		scanner = new Scanner(System.in);
		input = scanner.nextLine();
		if (input.length() != 2) {
			System.out.println("Enter a letter followed by a number");
	}
	}
	public static void main(String[] args) {
		new tictactoe();
	
	}
	
	public void printBoard() {
		board[1][2] = X_MOVE;
		board[0][0] = O_MOVE;
		System.out.println(" \t1\t2\t3");
		for (int row = 0; row < board.length; row++) {
			String output = (char)('a'+row) + "\t";
			for (int column = 0; column < board[0].length; column++) {
				if (board[row][column] == BLANK) {
					output += " \t";

				}
				
				else if (board[row][column] == X_MOVE) {
					output += "X\t";
					
				}
				else if (board[row][column] == O_MOVE) {
					output += "O\t";
			}
			
			
			
				System.out.println(output);
			}	
		}
	}
	
}