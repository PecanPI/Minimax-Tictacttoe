
	import java.util.Arrays;
	import java.util.LinkedList;
	import java.util.Queue;

	import javafx.animation.AnimationTimer;
	import javafx.application.Application;
	import javafx.stage.Stage;

	public class AiVAi extends Application {
		
		
		private int turnCount = 0;
		private static int framecount = 0;
		

		@Override
		public void start(Stage ps) throws Exception {
			
			TicTacToe game = new TicTacToe();
			Board board = new Board(ps,turnCount);
			
			Agent maxplayer = new Agent('O');
			Agent minplayer = new Agent('X');
			
			game.display();
		
	 		
			AnimationTimer timer = new AnimationTimer() {
		            @Override
		            public void handle(long now) {
		            	
		            	
		            	
		            	if(turnCount % 2 == 1) {
		            		try {
								Thread.sleep(500);
							} catch (InterruptedException e) {
								
								e.printStackTrace();
							}
		            		int[] move = new int[1];
		            		Integer score;
		            		Queue<int[]> moveQueue = new LinkedList<>();
		            		Queue<Integer> scoreTracker = new LinkedList<>();
		            		
		            		moveQueue = game.moves(game.getGrid());
		    			
		            		int depth = 0;
		            		Queue<int[]> moveQueueCopy = new LinkedList<>(moveQueue);
		            		
		            		TicTacToe game2 = new TicTacToe(game.getGrid());
		    		
		            		//gets scores for every available move
		            		while(!moveQueue.isEmpty()) {
		            			
		            			move = moveQueue.remove();
		    			
		            			game2.neighbour(move, maxplayer.getMark());
		            			
		            			score = maxplayer.maxvalue(game2, minplayer, depth);
		            			
		            			scoreTracker.add(score);
		            			game2 = new TicTacToe(game.getGrid());
		            			
		            		}
		    			
		            		int[] bestMove =  new int[1];
		            		int highScore = -1000;
		    		
		            		while(!scoreTracker.isEmpty()) {
		            			System.out.println("Score test");
		            			score = scoreTracker.remove();
		            			int[] movePh = moveQueueCopy.remove();
		            			System.out.println(Arrays.toString(movePh)); // Testing
		    					System.out.println("Score: " + score);
		    				
		            			//Move the Ai makes is the highest scoring move
		            			if(score > highScore) {
		            				bestMove = movePh;
		            				highScore = score;
		            			}
		    			
		    			
		            		}
		            		System.out.println(Arrays.toString(bestMove));
		            		
		    			
		            		board.draw(board.getPane(), bestMove[0], bestMove[1], turnCount);
		            		game.neighbour(bestMove, maxplayer.getMark());
		    			
		    			game.display();
		    			turnCount = turnCount + 1;
		    		
		    			}

		    	
		            
		            
		            	else{
		            		try {
		            			Thread.sleep(500);
		            		} catch (InterruptedException e) {
							
		            			e.printStackTrace();
		            		}
		            		int[] move = new int[1];
		            		Integer score;
		            		Queue<int[]> moveQueue = new LinkedList<>();
		            		Queue<Integer> scoreTracker = new LinkedList<>();
	            		
		            		moveQueue = game.moves(game.getGrid());
	    			
		            		int depth = 0;
		            		Queue<int[]> moveQueueCopy = new LinkedList<>(moveQueue);
	            		
	            		TicTacToe game2 = new TicTacToe(game.getGrid());
	            		
	            		//gets scores for every available move
	            		while(!moveQueue.isEmpty()) {
	            			
	            			move = moveQueue.remove();
	    			
	            			game2.neighbour(move, minplayer.getMark());
	            			
	            			score = maxplayer.maxvalue(game2, maxplayer, depth);
	            			
	            			scoreTracker.add(score);
	            			game2 = new TicTacToe(game.getGrid());
	            			
	            		}
	    			
	            		int[] bestMove =  new int[1];
	            		int highScore = -1000;
	    		
	            		while(!scoreTracker.isEmpty()) {
	            			
	            			score = scoreTracker.remove();
	            			int[] movePh = moveQueueCopy.remove();
	            			System.out.println(Arrays.toString(movePh)); // Testing
	    					System.out.println("Score: " + score);
	    				
	            			//Move the Ai makes is the highest scoring move
	            			if(score > highScore) {
	            				bestMove = movePh;
	            				highScore = score;
	            			}
	    			
	    			
	            		}
	            		System.out.println(Arrays.toString(bestMove));
	            		
	    		
	    			board.draw(board.getPane(), bestMove[0], bestMove[1], turnCount);
	    			game.neighbour(bestMove, minplayer.getMark());
	    			game.display();
	    			turnCount = turnCount + 1;
	    		
	    			
		            	}
		            	if(game.checkTie()||game.checkWin('O')|| game.checkWin('X')) {
		            		
		            		board.getPane().setOnMouseClicked(null);
		            		
		            		this.stop();
		            	}
		            	
		            	
		            	
		            	framecount++;
		            }
		            	
		            		       
				
		            
		        };
			timer.start();
		  }
			
			
			
	}



