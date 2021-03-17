import java.util.Random;

import java.util.Scanner;

public class TicTacToe {

	public static void main(String[] args) {
		
		Scanner scanner = new Scanner(System.in);
		
		char[][] board = {{' ', ' ', ' '},
				 	      {' ', ' ', ' '}, 
				 	      {' ', ' ', ' '}};
		
		printBoard(board);
		
		while (true) {
			playerTurn(board, scanner);
			if (isGameFinished(board)){
				break;
			}
			printBoard(board);
			
			computerTurn(board);
			if (isGameFinished(board)){
				break;
			}
			printBoard(board);
		}
		scanner.close();
	}


	
	
}