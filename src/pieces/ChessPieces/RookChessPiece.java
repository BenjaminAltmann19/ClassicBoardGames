package pieces.ChessPieces;

import java.awt.Point;
import java.util.HashSet;

import Boards.Board;
import Player.Player;

public class RookChessPiece extends ChessPiece {

	public RookChessPiece(Point startingPoint, int owner) {
		super(startingPoint, owner);
		identifier = 4;
	}

	public HashSet<Point> findPotentialMoves(Board board, Player player, Point startingPoint){
		HashSet<Point> potentialMoves = new HashSet<Point>();

		return potentialMoves;
	}

	private HashSet<Point> findCaptures() {
		HashSet<Point> potentialMoves = new HashSet<Point>();

		return potentialMoves;
	}

	private HashSet<Point> findOneAxisMovement(Board board, boolean isXAxis, int direction){
		HashSet<Point> potentialMoves = new HashSet<Point>();
		Point nextPoint = new Point();
		while(board.getPieceAt(nextPoint).getIdentifier() == 0) {
			if(isXAxis) {
				nextPoint = new Point(position.x + direction, position.y);
				if(board.getPieceAt((nextPoint)).getIdentifier() == 0);
				potentialMoves.add(nextPoint);
			}
		}
		
		return potentialMoves;
	}
}
