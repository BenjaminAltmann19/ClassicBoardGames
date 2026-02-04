package GameController;

import java.util.LinkedList;

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
	

	/*
	 * This is what im trying to get rid of
	 */
	protected void initializePlayer(Player player, int startingRow, int startingColumn) {
		
	}
	
	public void doOneTurn() {
		
	}
	
	public void gameLoop() {
		
	}
	
	public void promotePiece(Piece piece) {
		
	}
	
	private void updateBoard() {
		//get all pieces from each player
		LinkedList<Piece> allPieces = new LinkedList<>();
		allPieces.addAll(playerOne.getPieces());
		allPieces.addAll(playerTwo.getPieces());
		//for each piece, look at its position and place it there on the board
		for(Piece piece : allPieces) {
			board.setLocation(piece.getPosition(), piece);
		}
	}
	
}
