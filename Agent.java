import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;

public class Agent {

	private char mark; //X for ai player, O for human
	
	public char getMark() {
		return this.mark;
	}
	
	
	public Agent(char mark) {
	
	this.mark = mark;	

	}

	/**Finds a score for tictactoe and returns a score for each move
	 * 
	 * @param game a game state.
	 * @param opponent
	 * @param depth, the depth of recursion
	 * @returns the min value for a move, 10 for a win, -10 for a loss
	 */
	public int maxvalue(TicTacToe game, Agent opponent, int depth ) {
		int[] move = new int[1];
	
		int score = 0;
	
		
		
		Queue<int[]> moveQueue = new LinkedList<>();
		Queue<Integer> scoreTracker = new LinkedList<>();
		
		moveQueue = game.moves(game.getGrid());
		TicTacToe game2 = new TicTacToe(game.getGrid()); //copy list
		
		
		char[][] board = game.getGrid();
		
			
			 if(game.checkWin(board, this.mark) == true) {
				return 10 - depth;
			} else if(game.checkTie(board) == true) {
				System.out.println("test: " + depth);
				return 0;
			}else if(game.checkWin(board, opponent.mark) == true) {
				
				return -10 + depth;
				
			} else {

			
				moveQueue = game.moves(game.getGrid());

				//Cycle through the available moves and get their scores
				while(!moveQueue.isEmpty()) {
					
					move = moveQueue.remove();

					game2.neighbour(move, opponent.getMark());

					score = minvalue(game2, opponent, depth + 1);
					scoreTracker.add(score);
					game2 = new TicTacToe(game.getGrid());
					
				}
				
				int lowScore = 11;
				
				//finds the lowest score and returns it
				while(!scoreTracker.isEmpty()) {
					score = scoreTracker.remove();
					
					if(score < lowScore) {
					
						lowScore = score;
					}
				
				
				}
				
				return lowScore;
		}
				
		
		
		
		
	}
	
	/**finds the a score for each move in tictactoe
	 * 
	 * @param game a game state
	 * @param opponent the human player
	 * @param depth the depth of recursion
	 * @returns the max value for a move, -10 for loss in one move
	 */
	public Integer minvalue(TicTacToe game, Agent opponent, int depth) {
		int[] move = new int[1];
		int score = 0;
		
		
		Queue<int[]> moveQueue = new LinkedList<>();
		Queue<Integer> scoreTracker = new LinkedList<>();
		
		moveQueue = game.moves(game.getGrid());
		TicTacToe game2 = new TicTacToe(game.getGrid()); //copy list
		
		
		char[][] board = game.getGrid();
			 if(game.checkWin(board, opponent.getMark()) == true) { // pass "board" through check win and check tie
				 return  -10 + depth;
			} else if(game.checkTie(board) == true) {
				return 0;
			} else {


				moveQueue = game.moves(game.getGrid());

				//cycles all the available moves and adds their scores to the queue
				while(!moveQueue.isEmpty()) {
					
					move = moveQueue.remove();
					game2.neighbour(move, getMark());
					
					score = maxvalue(game2, opponent, depth + 1 );
					scoreTracker.add(score);
					game2 = new TicTacToe(game.getGrid());
					
				}
				
				
				int highScore = -11;
				
				//finds the highest score and returns it
				while(!scoreTracker.isEmpty()) {
					score = scoreTracker.remove();
					
						if(score > highScore) {
							highScore = score;
						}
						
				}
		
				return highScore;
			}
	}
}
