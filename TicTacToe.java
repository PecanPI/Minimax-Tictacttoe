import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;

public class TicTacToe {

	private char[][] grid = {{'-','-','-'}, 
							 {'-','-','-'},
							 {'-','-','-'}};
	

	
	public char[][] getGrid(){
		
		char[][] board = new char[this.grid.length][this.grid[0].length];
		for(int i =0; i < this.grid.length;i++) {
			board[i] = Arrays.copyOf(this.grid[i], this.grid[i].length);
		}
		
		return board;
	}
	
	public void setGrid(char[][] newBoard){
		this.grid = newBoard;
		
	}
	
	public void display() {
		
		for(int i = 0; i < this.grid.length; i++) {
			for(int j = 0; j < this.grid[i].length;j++) {
				System.out.print(this.grid[j][i]);
			}
			System.out.println();
		}
	}
	
	public void place(int x, int y, int turn) {
		if(turn %2 == 0) {
			this.grid[x][y] = 'X';
		}else {
			this.grid[x][y] = 'O';
		}
		
	}
	
	public TicTacToe(char[][] board) {
		this.grid = new char[board.length][board[0].length];
		for(int i =0; i < board.length;i++) {
			this.grid[i] = Arrays.copyOf(board[i], board[i].length);
		}
	}
	
	public TicTacToe(){
		

	}
	
	
	public Queue<int[]> moves(char[][] b){
		Queue<int[]> moves = new LinkedList<>();

		for(int i = 0; i < 3; i++) {
			for(int j = 0; j < 3; j++) {
				
				if(this.grid[i][j] == '-') {
					int[] move = {i,j};
					moves.add(move);
				}
				
			}
		}

		return moves;		
	}
	

	/**Takes the players choice of move and adds it to the board
	 * 
	 * @param move an int[] of the move a plater has made
	 * @param mark X for ai, O for human
	 * @return a new board state with the move made
	 */
	public char[][] neighbour(int[] move, char mark) {
		
		char[][] nGrid = getGrid();
		nGrid[move[0]][move[1]] = mark;
		setGrid(nGrid);
		
		return nGrid;

	}
	
	public boolean checkEmpty(int x, int y) {
		if(grid[x][y] == '-') {
			return true;
		}
		else {
			return false;
		}
	}
	
	public boolean checkWin( char player ) {
		boolean winner = false;

		//horizontal and vertical wins
		for(int i = 0; i < 3; i++) {	
			if(this.grid[i][0] == player && this.grid[i][1] == player && this.grid[i][2] == player ) {
				winner = true;
			}
			
		}
		for(int i = 0; i < 3; i++) {	
			if(this.grid[0][i] == player && this.grid[1][i] == player && this.grid[2][i] == player ) {
				winner = true;
			}
			
		}
		
		//diagonal wins
		if(this.grid[0][0] == player && this.grid[1][1] == player && this.grid[2][2] == player ) {
			winner = true;
		}
		if(this.grid[0][2] == player && this.grid[1][1] == player && this.grid[2][0] == player)  {
			winner = true;
		}
		
		
		return winner;
	}
	
	
	public boolean checkWin(char[][] board, char player ) {
		boolean winner = false;

		//horizontal and vertical wins
		for(int i = 0; i < 3; i++) {	
			if(board[i][0] == player && board[i][1] == player && board[i][2] == player ) {
				winner = true;
			}
			
		}
		for(int i = 0; i < 3; i++) {	
			if(board[0][i] == player && board[1][i] == player && board[2][i] == player ) {
				winner = true;
			}
			
		}
		
		//diagonal wins
		if(board[0][0] == player && this.grid[1][1] == player && this.grid[2][2] == player ) {
			winner = true;
		}
		if(board[0][2] == player && board[1][1] == player && board[2][0] == player)  {
			winner = true;
		}
		
		
		return winner;
	}
	
	
	
	public boolean checkTie(char[][] board) {
		
		
		for(int i =0; i < 3; i++) {
			for(int j = 0; j < 3; j++) {
				
				if(board[i][j] == '-') {
					
					return false;
				}
				
			}
		}
		
		
		return true;
	}
	
	
	public boolean checkTie() {
		
		
		for(int i =0; i < 3; i++) {
			for(int j = 0; j < 3; j++) {
				
				if(this.grid[i][j] == '-') {
					
					return false;
				}
				
			}
		}
		
		
		return true;
	}
	
	
}
