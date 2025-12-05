package pieces;
import java.awt.Point;
import java.util.HashSet;

public class EmptyPiece extends Piece{

	public EmptyPiece(Point startPosition) {
		super(startPosition);
		identifier = 0;
	}
	
	public boolean isMoveValid(Point point) {
		return true;
	}
	
	
	/*
	 * This method returns every position on the board in a Hashset<Point>
	 */
	public HashSet<Point> findPotentialMoves(int boardSize){
		HashSet<Point> potentialMoves = new HashSet<Point>();
		for(int i = 0; i < boardSize; i++) {
			for(int j = 0; j < boardSize; j++) {
				potentialMoves.add(new Point(i, j));
			}
		}
		return potentialMoves;
	}
}
