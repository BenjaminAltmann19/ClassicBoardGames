package GameController;

import java.awt.Point;

import AnimationController.AnimationController;
import Boards.Board;
import Display.GridUI;
import Inputs.Input;
import Player.Player;
import pieces.EmptyPiece;
import pieces.Piece;
import pieces.CheckersPieces.CheckersPiece;

public abstract class GameController {

	Board board;
	Player playerOne;
	Player playerTwo;
	Input input;
	GridUI gridUI;
	public AnimationController animationController;
	
	public static final int PLAYER_ONE = 1;
	public static final int PLAYER_TWO = 2;
	
	enum PlayersTurn{PLAYER_ONE_TURN, PLAYER_TWO_TURN};
	PlayersTurn playersTurn;
	
	public GameController() {
		input = new Input();
		playersTurn = PlayersTurn.PLAYER_ONE_TURN;
	}
	/*
	 * This method prepares the board to start
	 */
	protected void initialize() {
		
	}
	
	protected void initializePlayer(Player player) {
		if(player.getPlayerOrder() == 1) {
			initializePlayer(player, 0, 0);
		}else {
			initializePlayer(player, board.BOARD_SIZE - 3, 0);
		}
	}
	
	protected abstract void initializePlayer(Player player, int startingRow, int startingColumn);
	
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
	public abstract void doOneTurn();
	
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
	
	
	public Player getPlayer(int num) {
		if(num == 1) {
			return playerOne;
		}else{
			return playerTwo;
		}
	}
	
	/*
	 * This method is adding the piece to the players "hand" and placing it on the board
	 */
	protected void createPiece(Player player, int row, int column) {
		CheckersPiece piece = new CheckersPiece(new Point(row,column));
		player.addPiece(piece);
		board.getBoard()[row][column] = piece;
	}
	
	public Point parsePoints(String stringPoint) {
		String[] parts = stringPoint.split(",");
		int x = Integer.parseInt(parts[0].trim());
		int y = Integer.parseInt(parts[1].trim());
		return new Point(x,y);
	}
	
	
	protected void changePlayerTurn() {
		if(playersTurn == PlayersTurn.PLAYER_ONE_TURN) {
			playersTurn = PlayersTurn.PLAYER_TWO_TURN;
		}else {
			playersTurn = PlayersTurn.PLAYER_ONE_TURN;
		}
	}
	
	public Player getPlayerForTurn() {
		if(playersTurn == PlayersTurn.PLAYER_ONE_TURN) {
			return playerOne;
		}else {
			return playerTwo;
		}
	}
	
	public abstract void promotePiece(Piece piece);

}
