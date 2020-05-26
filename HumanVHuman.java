import javafx.animation.AnimationTimer;
import javafx.application.Application;
import javafx.event.EventHandler;
import javafx.scene.input.MouseEvent;
import javafx.stage.Stage;

public class HumanVHuman extends Application{

	private int turnCount = 0;
	
	
	
	
	public HumanVHuman() {
		
		
			
	}

	@Override
	public void start(Stage ps) throws Exception {
		
		TicTacToe game = new TicTacToe();
		Board board = new Board(ps,turnCount);
		
		board.getPane().setOnMouseClicked(event -> {
			
				if(game.checkEmpty((int) event.getX()/100, (int) event.getY()/100)) {

					board.draw(board.getPane(),(int) event.getX()/100, (int) event.getY()/100, turnCount);
					game.place((int) event.getX()/100, (int) event.getY()/100, turnCount);
					this.turnCount =  turnCount + 1;
					
					game.display();
					
					
					
				}
			
			
		});
		
 		
		new AnimationTimer() {
	            @Override
	            public void handle(long now) {
	            	if(game.checkTie()||game.checkWin('O')|| game.checkWin('X')) {
	            		board.getPane().setOnMouseClicked(null);

	            	}
	            	
	            	
	            }
	        }.start();
	  }
		
		
		
}