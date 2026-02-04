package GameController;

import java.awt.Point;
import java.util.LinkedList;

import AnimationController.AnimationController;
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
	public AnimationController animationController;
	
	public static final int PLAYER_ONE = 1;
	public static final int PLAYER_TWO = 2;
	
	enum PlayersTurn{PLAYER_ONE_TURN, PLAYER_TWO_TURN};
	PlayersTurn playersTurn;
	
	public GameController() {
		input = new Input();
		playersTurn = PlayersTurn.PLAYER_ONE_TURN;
	}

	
	public Board getBoard() {
		return board;
	}
	
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
	
	protected void updateBoard() {
		//get all pieces from each player
		LinkedList<Piece> allPieces = new LinkedList<>();
		allPieces.addAll(playerOne.getPieces());
		allPieces.addAll(playerTwo.getPieces());
		//clear board
		board.emptyBoard();
		//for each piece, look at its position and place it there on the board
		for(Piece piece : allPieces) {
			board.setLocation(piece.getPosition(), piece);
		}
	}

}
