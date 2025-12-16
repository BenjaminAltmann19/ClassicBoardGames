package GameController;

import java.awt.Point;
import java.util.HashSet;

import Boards.Board;
import Inputs.Input;
import Player.Player;
import pieces.EmptyPiece;
import pieces.Piece;

public abstract class GameController {

	Board board;
	Player playerOne;
	Player playerTwo;
	Input input;
	
	public GameController() {
		input = new Input();
	}
	/*
	 * This method prepares the board to start
	 */
	public void initialize() {
		board.initializeBoard();
	}
	
	public Board getBoard() {
		return board;
	}
	
	/*
	 * This method is the main game loop
	 */
	public abstract void gameLoop();
	
	/*
	 * Ask which piece to move
	 * Ask where to move it
	 */
	public abstract void doOneTurn(Player player);
	
	/*
	 * This method moves a piece to a new point and fills in the gap left behind.
	 */
	public void movePiece(Piece piece, Point point, Player player) {
		int previousX = (int)piece.getPosition().getX();
		int previousY = (int)piece.getPosition().getY();
		piece.move(board, player, point);
		board.getBoard()[(int)point.getX()][(int)point.getY()] = piece;
		piece.setLocation(point);
		board.getBoard()[previousX][previousY] = new EmptyPiece(new Point(previousX, previousY));
	}
	
	
	/*
	 * This method returns the players Opponent
	 */
	protected Player getOpponent(Player player) {
		if(player.getPlayerOrder() == 1) {
			return playerTwo;
		}else {
			return playerOne;
		}
	}

}
