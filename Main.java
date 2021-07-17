import java.util.Scanner;
public class Main {
	public static void main(String[] args) {
		Main game = new Main();
		Scanner s = new Scanner(System.in);
		boolean won = false;
		String player = "";
		game.start();
		game.print();
		while (!won) {
			player = (game.counter % 2 == 0) ? "Red" : "Yellow";
			System.out.println(player + " please enter the column you want to place your chip: ");
			game.move(s.nextInt());
			game.print();
			won = game.checkWin();
		} //have the game be in a loop, when there's a winner, break out of the loop
		s.close();
		
	}
	String[][] board = new String[6][7];
	public int counter = 0;
	//Start, Print board, player move, check for winner
	public void start() {
		for (int i = 0; i < board.length; i++) {
			for (int j = 0; j < board[i].length; j++) {
				board[i][j] = "O";
			}
		}
	}
	public void print() {
		for (int i = 0; i < board.length; i++) {
			for (int j = 0; j < board[i].length; j++) {
				System.out.print(board[i][j] + " ");
			}
			System.out.print("\n");
		}
	}
	public boolean move(int col) {
		col = col-1;
		//make sure the user doesn't play out of bounds
		if (col >= board[0].length || col < 0) {
			System.out.println("\nColumn out of bounds, try Again!");
			return false;
		}
		//Red move
		if (counter % 2 == 0) {
			for (int row = board.length - 1; row >= 0; row--) {
				if (board[row][col].equals("O")) {
					board[row][col] = "R";
					counter++;
					return true;
				}
			}
		}
		//Yellow move
		else {
			for (int row = board.length - 1; row >= 0; row--) {
				if (board[row][col].equals("O")) {
					board[row][col] = "Y";
					counter++;
					return true;
				}
			}
		}
		System.out.println("\nColumn full, try Again!");
		return false;
	}
	public boolean checkWin() {
		int count = 0;
		//Horizontal
		//red
		for (int i = 0; i < board.length; i++) {
			for (int j = 0; j < board[i].length; j++) {
				if (board[i][j].equals("R")) {
					count++;
				} else {
					count=0;
				}
				if (count == 4)
				{
					System.out.println("Red won");
					return true;
				}
			}
			count = 0;
		}
		//yellow
		for (int i = 0; i < board.length; i++) {
			for (int j = 0; j < board[i].length; j++) {
				if (board[i][j].equals("Y")) {
					count++;
				} else {
					count=0;
				}
				if (count == 4)
				{
					System.out.println("Yellow won");
					return true;
				}
			}
			count = 0;
		}
		//Vertical
			//red
			for (int j = 0; j < board[0].length; j++) {
				for (int i = 0; i < board.length; i++) {
						if (board[i][j].equals("R")) {
							count++;
						} else {
							count=0;
						}
						if (count == 4)
						{
							System.out.println("Red won");
							return true;
						}
					}
					count = 0;
				}
			//yellow
			for (int j = 0; j < board[0].length; j++) {
				for (int i = 0; i < board.length; i++) {
						if (board[i][j].equals("Y")) {
							count++;
						} else {
							count=0;
						}
						if (count == 4)
						{
							System.out.println("Yellow won");
							return true;
						}
					}
					count = 0;
				}
		//Diagonal
			//Red
			for (int i = 0; i < board.length - 3; i++) {
				for (int j = 0; j < board[i].length - 3; j++) {
					if (board[i][j].equals("R") &&
						board[i + 1][j + 1].equals("R") &&
						board[i + 2][j + 2].equals("R") && 
						board[i + 3][j + 3].equals("R")) {
						System.out.println("Red won");
						return true;
					}
				}
			}
			for (int i = 0; i < board.length - 3; i++) {
				for (int j = 3; j < board[i].length; j++) {
					if (board[i][j].equals("R") &&
						board[i + 1][j - 1].equals("R") &&
						board[i + 2][j - 2].equals("R") && 
						board[i + 3][j - 3].equals("R")) {
						System.out.println("Red won");
						return true;
					}
				}
			}
			//Yellow
			for (int i = 0; i < board.length - 3; i++) {
				for (int j = 0; j < board[i].length - 3; j++) {
					if (board[i][j].equals("Y") &&
						board[i + 1][j + 1].equals("Y") &&
						board[i + 2][j + 2].equals("Y") && 
						board[i + 3][j + 3].equals("Y")) {
						System.out.println("Yellow won");
						return true;
					}
				}
			}
			for (int i = 0; i < board.length - 3; i++) {
				for (int j = 3; j < board[i].length; j++) {
					if (board[i][j].equals("Y") &&
						board[i + 1][j - 1].equals("Y") &&
						board[i + 2][j - 2].equals("Y") && 
						board[i + 3][j - 3].equals("Y")) {
						System.out.println("Yellow won");
						return true;
					}
				}
			}
			for (int j = 0; j < board[0].length; j++) {
				for (int i = 0; i < board.length; i++) {
					if (board[i][j].equals("O"))
						return false;
				}
			}
		System.out.println("Game over - no spaces left");
		return true;
	}
}
