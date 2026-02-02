package AnimationController;


import Boards.Board;
import GameController.GameController;
import javafx.scene.paint.Color;

public class ChessAnimationController extends AnimationController{
	
	public ChessAnimationController(Board board, GameController gameController) {
		super(board, gameController);
		
		//Switch with pictures
		colorMapping.put((Integer) 0, Color.WHITE);		//blank
		colorMapping.put((Integer) 1, Color.BLUE);		//Pawn
		colorMapping.put((Integer) 2, Color.GREEN);		//Knight
		colorMapping.put((Integer) 3, Color.PINK);		//Bishop
		colorMapping.put((Integer) 4, Color.BROWN);		//Rook
		colorMapping.put((Integer) 5, Color.PURPLE);	//Queen
		colorMapping.put((Integer) 6, Color.GOLD);		//King
	}

}
