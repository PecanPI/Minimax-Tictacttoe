
import java.util.Stack;

import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.HPos;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.Pane;
import javafx.scene.layout.StackPane;
import javafx.scene.paint.Color;
import javafx.scene.shape.Circle;
import javafx.scene.shape.Rectangle;
import javafx.scene.shape.Shape;
import javafx.scene.text.Font;
import javafx.scene.text.Text;
import javafx.stage.Stage;
import javafx.stage.StageStyle;


public class MainMenu extends Application {
	
	private static int HEIGHT = 300, WIDTH = 300;
	
	public int getHeight() {
		return this.HEIGHT;
	}
	
	public int getWidth() {
		return this.WIDTH;
	}
	
	
	
	public static void main(String args[]) {
		launch(args);
	}
	
	
	
	
	@Override
	public void start(Stage primaryStage) throws Exception {
		
		GridPane root = new GridPane();
		
		
		root.setAlignment(Pos.TOP_CENTER);
		root.setHgap(10);
		root.setVgap(20);
		root.setPadding(new Insets(25, 25, 25, 25));
		
		
		Button HvH = new Button();
		HvH.setMinSize(120, 10);
		
        HvH.setText("Human vs. Human");
        HvH.setOnAction(new EventHandler<ActionEvent>() {
        	
            @Override
            public void handle(ActionEvent event) {
                HumanVHuman hvh = new HumanVHuman();
                try {
        			hvh.start(primaryStage);
        		} catch (Exception e) {
        			e.printStackTrace();
        		}
               
            }
        });
        
        GridPane.setHalignment(HvH, HPos.CENTER);
        root.add(HvH, 0, 3);
        
        
        Button HvAi = new Button();
       
        
      
        
		HvAi.setMinSize(120, 10);
        HvAi.setText("Human vs AI");
        HvAi.setOnAction(new EventHandler<ActionEvent>() {
 
            @Override
            public void handle(ActionEvent event) {
            	 HumanVAi hvai = new HumanVAi();
                 try {
         			hvai.start(primaryStage);
         		} catch (Exception e) {
         			e.printStackTrace();
         		}
            }
        });
        GridPane.setHalignment(HvAi, HPos.CENTER);
        root.add(HvAi, 0, 4);
        
        Button AivAi = new Button();
       
		AivAi.setMinSize(120, 7);
        AivAi.setText("AI vs AI");
        AivAi.setOnAction(new EventHandler<ActionEvent>() {
 
            @Override
            public void handle(ActionEvent event) {
            	AiVAi aivai = new AiVAi();
                try {
        			aivai.start(primaryStage);
        		} catch (Exception e) {
        			e.printStackTrace();
        		}
            }
        });
        GridPane.setHalignment(AivAi, HPos.CENTER);
        root.add(AivAi, 0,5);
        
        
        root.setStyle("-fx-background-color: #000000;");
        
        Text title = new Text("MiniMax TicTacToe");
        title.setFont(new Font("Arial Black", 20));
       
		title.setFill(Color.WHITE);
        title.setLayoutX(75);
		title.setLayoutY(50);
		GridPane.setHalignment(title, HPos.CENTER);
		root.add(title,0, 1);
		
		//root.setGridLinesVisible(true);
		
		
		//root.getChildren().addAll(HvH, HvAi, AivAi, title);
		primaryStage.setTitle("TicTacToe!");
		primaryStage.setScene(new Scene(root, getHeight(),getWidth()));
		
		primaryStage.initStyle(StageStyle.DECORATED); 
		primaryStage.show();
		
		
	}

	
	
	
	
}
