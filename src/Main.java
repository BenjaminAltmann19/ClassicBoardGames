
import AnimationController.AnimationController;
import GameController.CheckersGameController;
import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.layout.GridPane;
import javafx.stage.Stage;

public class Main extends Application{
	
	AnimationController animationController;
	Stage myStage;
	
	public void start(Stage stage) {
		myStage = stage;
        Scene scene = setupSelectionScene();

        stage.setTitle("Board Games!");
        stage.setScene(scene);
        stage.show();
        stage.centerOnScreen();
	}
	
    // Input: None
    // Output: Scene
    // Purpose: creates the initial selection screen with a button.
    private Scene setupSelectionScene() {
        GridPane root = new GridPane(100,100); 
        root.setStyle("-fx-alignment: center;"); 

        Button checkersButton = new Button("Play Checkers");
        checkersButton.setOnAction(e -> startGame("Checkers"));

        Button chessButton = new Button("Play Chess");
        chessButton.setOnAction(e -> startGame("Chess"));
        
        Button ticTacToeButton = new Button("Play TicTacToe");
        ticTacToeButton.setOnAction(e -> startGame("TicTacToe"));

        root.add(checkersButton, 0, 0);
        root.add(chessButton, 1, 0);
        root.add(ticTacToeButton, 2, 0);

        Scene scene = new Scene(root);
        return scene;
    }
    
    public void startGame(String game) {
    	if(game.equals("Checkers")) {
    		CheckersGameController checkersGameController = new CheckersGameController();
    		myStage.setScene(checkersGameController.animationController.createStartingScreen(checkersGameController.getBoard()));
    		myStage.show();
    		myStage.centerOnScreen();
    	}else if(game.equals("Chess")){
    		
    	}else {
    		
    	}
    }

    public static void main(String[] args){
    	launch(args);
    	//CheckersGameController checkersGameController = new CheckersGameController();
    	//checkersGameController.getBoard().printBoard();
    }
}
