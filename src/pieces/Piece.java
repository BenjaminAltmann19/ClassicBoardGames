package pieces;

import java.awt.Point;
import java.util.HashSet;

public abstract class Piece {
	
	protected Point position;
	public int identifier;
	
	
	public Piece(Point startPosition) {
		position = startPosition;
	}
	
	/*
	 * This method makes sure any move is within the bounds of the board.
	 */
	public boolean isMoveValid(Point point, int boardSize) {
		return 0 <= point.getX() && point.getX() < boardSize && point.getY() >= 0 && point.getY() < boardSize;
	}
	
	/*
	 * This method moves the piece to a valid position.
	 */
	public void move(Point point, int boardSize) {
		if(findPotentialMoves(boardSize).contains(point)) {
			setLocation(point);
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
	
	public abstract HashSet<Point> findPotentialMoves(int boardSize);
	
}
