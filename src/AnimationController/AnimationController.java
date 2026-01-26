package AnimationController;

import java.awt.Point;
import java.util.HashMap;

import Boards.Board;
import GameController.GameController;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.StackPane;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;
import javafx.scene.shape.Rectangle;
import javafx.scene.text.Text;
import pieces.Piece;

public abstract class AnimationController {

	HashMap<Integer, Color> colorMapping = new HashMap<Integer, Color>();
	GameController gameController;
	Text playerTurnBox = new Text();
	TextField moveBox = new TextField();
	TextField pieceBox = new TextField();
	BorderPane root = new BorderPane();

	public AnimationController(Board board, GameController gameController) {
		this.gameController = gameController;
		moveBox.setPromptText("Where to?");
		pieceBox.setPromptText("Which Position?");
		playerTurnBox.setText( "Player " + gameController.getPlayerForTurn().getPlayerOrder() + " Turn: ");
	}

	public Scene createStartingScreen(Board board) {
		
		GridPane grid = createBoardVisuals(board);
		
		VBox controls = new VBox();
		Button submitButton = new Button("Submit Move");
		submitButton.setOnAction(e -> {
		    try {
		        gameController.doOneTurn();
		        moveBox.clear();
		        pieceBox.clear();
		        playerTurnBox.setText( "Player " + gameController.getPlayerForTurn().getPlayerOrder() + " Turn: ");
		    } catch (Exception ex) {
		        ex.printStackTrace();
		    }
		});

		controls.getChildren().addAll(playerTurnBox, pieceBox, moveBox, submitButton);
		root.setCenter(grid);
		root.setRight(controls);
		return new Scene(root, 900, 800);
	}
	
	private GridPane createBoardVisuals(Board board) {
		GridPane grid = new GridPane(1,1);
		for(int i = 0; i < board.BOARD_SIZE; i++) {
			for(int j = 0; j < board.BOARD_SIZE; j++) {
				grid.add(createCell(i,j, board.getPieceAt(new Point(i,j))), j, i);
			}
		}
		return grid;
	}
	
	public void updateBoard(Board board) {
		GridPane grid = createBoardVisuals(board);
		
		root.setCenter(grid);
	}
	
	public Point getInput(int numBox) {
		if(numBox == 1) {
			 return gameController.parsePoints(moveBox.getText());
		}else {
			return gameController.parsePoints(pieceBox.getText());
		}
	}

	public Color determineColor(Piece piece) {
		Color pieceColor = colorMapping.get(piece.getIdentifier());
		if(gameController.getPlayer(1).getPieces().contains(piece)) {
			return pieceColor;
		}else{
			return new Color(1 - pieceColor.getRed(), 1 - pieceColor.getBlue(), 1 - pieceColor.getGreen(), pieceColor.getOpacity());
		}
	}

	private StackPane createCell(int row, int col, Piece piece) {
	    StackPane cell = new StackPane();
	    cell.setPrefSize(100, 100);
	    cell.setMinSize(100, 100);
	    cell.setMaxSize(600,600);

	    Rectangle tile = new Rectangle();
	    tile.setFill(determineColor(piece));
	    
	    tile.widthProperty().bind(cell.widthProperty());
	    tile.heightProperty().bind(cell.heightProperty());

	    cell.getChildren().add(tile);
	    return cell;
	}


}
