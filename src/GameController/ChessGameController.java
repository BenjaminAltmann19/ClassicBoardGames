package GameController;

import AnimationController.ChessAnimationController;
import Boards.ChessBoard;
import Player.ChessPlayer;
import Player.Player;
import pieces.Piece;

public class ChessGameController extends GameController{

	public ChessGameController() {
		super();
		board = new ChessBoard();
		playerOne = new ChessPlayer(PLAYER_ONE, board);
		playerTwo = new ChessPlayer(PLAYER_TWO, board);
		initialize();
		animationController = new ChessAnimationController(board, this);
	}
	
	@Override
	public void initialize() {
		super.initialize();
		initializePlayer(playerOne);
		initializePlayer(playerTwo);
	}
	

	
	protected void initializePlayer(Player player, int startingRow, int startingColumn) {
		
	}
	
	public void doOneTurn() {
		
	}
	
	public void gameLoop() {
		
	}
	
	public void promotePiece(Piece piece) {
		
	}
	
	
}
