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
private static boolean isGameFinished(char[][] board) {
		
		if (hasContestantWon(board, 'X')) {	
			printBoard(board);
			System.out.println("User wins!");
			return true;
		}
		
		if (hasContestantWon(board, 'O')) {	
			printBoard(board);
			System.out.println("Computer wins!");
			return true;
		}
		
		for (int i = 0; i < board.length; i++) {
			for (int j = 0; j < board[i].length; j++) {
				if (board[i][j] == ' ') {
					return false;
				}
			}
		}
		printBoard(board);
		System.out.println("The game ended in a tie!");
		return true;
	}
private static boolean hasContestantWon(char[][] board, char symbol) {
		if ((board[0][0] == symbol && board [0][1] == symbol && board [0][2] == symbol) ||
			(board[1][0] == symbol && board [1][1] == symbol && board [1][2] == symbol) ||
			(board[2][0] == symbol && board [2][1] == symbol && board [2][2] == symbol) ||
			
			(board[0][0] == symbol && board [1][0] == symbol && board [2][0] == symbol) ||
			(board[0][1] == symbol && board [1][1] == symbol && board [2][1] == symbol) ||
			(board[0][2] == symbol && board [1][2] == symbol && board [2][2] == symbol) ||
			
			(board[0][0] == symbol && board [1][1] == symbol && board [2][2] == symbol) ||
			(board[0][2] == symbol && board [1][1] == symbol && board [2][0] == symbol) ) {
			return true;
		}
		return false;
	}
private static void computerTurn(char[][] board) {
		Random rand = new Random();
		int computerMoveX, computerMoveY;
		while (true) {
			computerMoveX = rand.nextInt(3);
            computerMoveY = rand.nextInt(3);
			if (isValidMove(board, Integer.toString(computerMoveX)+","+Integer.toString(computerMoveY))) {
				break;
			}
		}
		System.out.println("\nComputer chose " + computerMoveX + ","+ computerMoveY);
		placeMove(board, Integer.toString(computerMoveX)+","+Integer.toString(computerMoveY), 'O');
	}
private static boolean isValidMove (char[][] board, String position) {
		switch(position) {
			case "0,0":
				return (board[0][0] == ' ');
			case "0,1":
				return (board[0][1] == ' ');
			case "0,2":
				return (board[0][2] == ' ');
			case "1,0":
				return (board[1][0] == ' ');
			case "1,1":
				return (board[1][1] == ' ');
			case "1,2":
				return (board[1][2] == ' ');
			case "2,0":
				return (board[2][0] == ' ');
			case "2,1":
				return (board[2][1] == ' ');
			case "2,2":
				return (board[2][2] == ' ');
			default:
				return false;
		}
	}
private static void playerTurn(char[][] board, Scanner scanner) {
		String userInput;
        boolean b = true;
		while (b) {
			System.out.println("\n\n\nType\n1. 'quit' to quit\n2. 'move x,y' to place your move on position x,y\n");
			userInput = scanner.nextLine();
            String[] input = userInput.split(" ",0);
			switch(input[0])
            {
                case "quit":
                    System.out.println("You have chosen to Quit...\nComputer wins");
                    System.exit(0);
                    break;
                case "move":
                    if (isValidMove(board, input[1]))
                    {
                        placeMove(board, input[1], 'X');
                        b = false;
                    } 
                    else 
                    {
                        System.out.println(userInput + " " + "Invalid move, place already taken.");
                    }
                    break;
                default:
                    System.out.println(userInput + " Invalid command.");
            }
		}
		
	}
private static void placeMove(char[][] board, String position, char symbol) {
		switch(position) {
			case "0,0":
				board[0][0] = symbol;
				break;
			case "0,1":
				board[0][1] = symbol;
				break;
			case "0,2":
				board[0][2] = symbol;
				break;
			case "1,0":
				board[1][0] = symbol;
				break;
			case "1,1":
				board[1][1] = symbol;
				break;
			case "1,2":
				board[1][2] = symbol;
				break;
			case "2,0":
				board[2][0] = symbol;
				break;
			case "2,1":
				board[2][1] = symbol;
				break;
			case "2,2":
				board[2][2] = symbol;
				break;
			default:
				System.out.println(":(");
		}
	}

	
	


	
	
}