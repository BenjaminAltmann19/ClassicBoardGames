package pieces;

import java.awt.Point;
import java.util.HashSet;

public class CheckersPiece extends Piece{
	
	public CheckersPiece(Point startPosition) {
		super(startPosition);
		identifier = 1;
	}

	
	/*
	 * This method finds all moves that are valid for the piece to make and returns them in a HashSet<Point>
	 * For CheckersPieces that is either forward diagonal if they are open squares
	 */
	public HashSet<Point> findPotentialMoves(int boardSize){
		HashSet<Point> potentialMoves = new HashSet<Point>();
		potentialMoves.add(new Point((int)position.getX() - 1, (int)position.getY() + 1));
		potentialMoves.add(new Point((int)position.getX() + 1, (int)position.getY() + 1));
		potentialMoves.removeIf(point -> !isMoveValid(point, boardSize));
		return potentialMoves;
	}
	
//	public boolean hasPieceToTake() {
//		
//	}
}
