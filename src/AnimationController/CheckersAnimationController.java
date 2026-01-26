package AnimationController;

import Boards.Board;
import GameController.GameController;
import javafx.scene.paint.Color;

public class CheckersAnimationController extends AnimationController {

	
	public CheckersAnimationController(Board board, GameController gameController){
		super(board, gameController);
		colorMapping.put((Integer) 0, Color.DARKGREY);		//Blank Square
		colorMapping.put((Integer) 1, Color.SKYBLUE);		//Piece Square
		colorMapping.put((Integer) 2, Color.GOLD);		//PromotedPiece Square
	}
}
