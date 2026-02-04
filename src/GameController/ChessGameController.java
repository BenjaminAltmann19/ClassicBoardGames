package GameController;


import AnimationController.ChessAnimationController;
import Boards.ChessBoard;
import Player.ChessPlayer;
import pieces.Piece;

public class ChessGameController extends GameController{

	public ChessGameController() {
		super();
		board = new ChessBoard();
		playerOne = new ChessPlayer(PLAYER_ONE, board);
		playerTwo = new ChessPlayer(PLAYER_TWO, board);
		updateBoard();
		animationController = new ChessAnimationController(board, this);
	}
	
	
	public void doOneTurn() {
		
	}
	
	
	public void promotePiece(Piece piece) {
		
	}
	

	
}
