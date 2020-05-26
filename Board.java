

import javafx.scene.Scene;
import javafx.scene.canvas.Canvas;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.layout.Pane;
import javafx.scene.paint.Color;
import javafx.scene.shape.Circle;
import javafx.scene.shape.Line;
import javafx.scene.shape.Rectangle;
import javafx.stage.Stage;

public class Board {

		
		private Canvas canvas;
		private Pane root;
		
		public Pane getPane() {
			return this.root;
		}
		public Canvas getCanvas() {
			return this.canvas;
		}
	
		public Board(Stage primaryStage, int tCount) {
			
			
			this.root = new Pane();
			TicTacToe game = new TicTacToe();
			
			this.root.setPrefSize( 300, 300);
			
		
			for(int i = 0; i<3; i++) {
				for(int j = 0; j<3; j++) {
					
					Rectangle plots = new Rectangle(100, 100);
					plots.setFill(null);
					plots.setStroke(Color.BLACK);
					this.canvas = new Canvas(100,100);
					plots.setTranslateX(i*100);
					plots.setTranslateY(j*100);
					canvas.setTranslateX(i*100);
					canvas.setTranslateY(j*100);
					canvas.setId("" + i +j);
					this.root.getChildren().addAll(plots,canvas);
					
					
					/*canvas.setOnMouseClicked(event -> {
						if(game.getTcount() % 2 == 0) {
							drawX(canvas, (int) event.getX()/100, (int) event.getY()/100);
							game.incrementTcount();
							System.out.println(game.getTcount());
						} else {
							game.incrementTcount();
							drawO(canvas, (int) event.getX()/100, (int) event.getY()/100);
					
							System.out.println(game.getTcount());
						
						}
					});
					*/
				}
			}
		
			Scene scene =  new Scene(root);
			
			System.out.println("Test3");
			primaryStage.setTitle("TicTacTie");
			primaryStage.setScene(scene);
			primaryStage.show();
			
		}
		
		
		
		
		
		public void draw(Pane pane, int x, int y, int turn) {
		
			
			if(turn % 2 == 1) {
				Circle circle = new Circle(30, Color.RED);
				circle.setCenterX(x*100 + 50);//(x* 100 + 25, y * 100 + 25);
				circle.setCenterY(y*100 + 50);
				Circle circle2 = new Circle(25, Color.WHITE);
				circle2.setCenterX(x*100 + 50);//(x* 100 + 25, y * 100 + 25);
				circle2.setCenterY(y*100 + 50);
				pane.getChildren().addAll(circle,circle2);
			}else {
				Line line1 = new Line();
				line1.setStroke(Color.RED);
				line1.setStrokeWidth(5);
			
				Line line2 = new Line();
				line2.setStroke(Color.RED);
				line2.setStrokeWidth(5);
			
				line1.setStartX(25 + x*100);
				line1.setStartY(25 + y*100);
				line1.setEndX(75 + x*100);
				line1.setEndY(75 + y*100);
			
			
				line2.setStartX(25 + x*100);
				line2.setStartY(75 + y*100);
				line2.setEndX(75 + x*100);
				line2.setEndY(25 + y*100);
				pane.getChildren().addAll(line1,line2);
			
			
			}
		}
		
		public static void drawO(Canvas canvas, int x, int y) {
			
			GraphicsContext gc = canvas.getGraphicsContext2D();
			gc.setStroke(Color.RED);
			gc.setLineWidth(5);
			gc.strokeOval(25, 25, 50, 50);

		}
		
		
		
	}