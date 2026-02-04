package pieces;

import java.awt.Point;
import java.util.HashSet;

import Boards.Board;
import Player.Player;

public abstract class Piece {
	
	protected Point position;
	
	//What type of piece this is (Knight, Pawn, Regular checker, promoted Checker...)
	protected int identifier;
	
	//which player owns this piece.
	protected int owner;
	
	
	public Piece(Point startPosition, int owner) {
		position = startPosition;
		this.owner = owner;
	}
	
	/*
	 * This method makes sure any move is within the bounds of the board.
	 */
	public boolean isMoveValid(Point point, Board board) {
		return isInBounds(point, board);
	}
	
	protected boolean isInBounds(Point point, Board board) {
		return 0 <= point.getX() && point.getX() < board.BOARD_SIZE && point.getY() >= 0 && point.getY() < board.BOARD_SIZE;
	}
	
	/*
	 * This method moves the piece to a valid position.
	 */
	public void move(Board board, Player player, Point destination) {
		if(findPotentialMoves(board, player, getPosition()).contains(destination)) {
			setLocation(destination);
		}
	}
	public void setLocation(Point point) {
		position = point;
	}
	
	public int getIdentifier() {
		return identifier;
	}
	
	
	public Point getPosition() {
		return position;
	}
	
	public abstract HashSet<Point> findPotentialMoves(Board board, Player player, Point currentPosition);
	
	public String getPositionString(Point point) {
		return ("(" + point.x + ", " + point.y + ")");
	}
	
	public String getPositionString() {
		return getPositionString(position);
	}
	
}
