package pieces.ChessPieces;

import java.awt.Point;
import java.util.HashSet;

import Boards.Board;
import Player.Player;

public class KnightChessPiece extends ChessPiece {

	
	public KnightChessPiece(Point startingPoint){
		super(startingPoint);
		identifier = 2;
	}
	
	/*
	 * The potential moves must:
	 * 		be within bounds
	 * 		be an empty square or a piece from the opponent
	 * 
	 * 		cannot result in the king going into check.
	 * 
	 * 		NEED TO HANDLE TAKING**
	 */
	public HashSet<Point> findPotentialMoves(Board board, Player player, Point currentPosition) {
		HashSet<Point> potentialMoves = new HashSet<Point>();
		potentialMoves.addAll(allPotentialKnightMovements(currentPosition));
		potentialMoves.removeIf(point -> !isInBounds(point, board));
		potentialMoves.removeIf(point -> player.getPieces().contains(board.getPieceAt(point)));	//removes the location if your own piece is already there.
		
		
		return potentialMoves;
	}
	
	
	private Point getKnightMovementPattern(Point currentPosition, int xAxisDirection, int yAxisDirection, boolean isMovingMoreXAxis) {
		int x = currentPosition.x;
		int y = currentPosition.y;
		if(isMovingMoreXAxis) {
			x = x + (2 * xAxisDirection);
			y = y + (1 * yAxisDirection);
		}else {
			x = x + (1 * xAxisDirection);
			y = y + (2 * yAxisDirection);
		}
		return new Point(x,y);
	}
	
	/*
	 * returns all 8 theoretical moves for a knight.
	 * Doesnt care if the location is off the board.
	 */
	private HashSet<Point> allPotentialKnightMovements(Point currentPosition){
		HashSet<Point> potentialMoves = new HashSet<Point>();
		potentialMoves.add(getKnightMovementPattern(currentPosition, 1, 1, true));		//two to the right one up
		potentialMoves.add(getKnightMovementPattern(currentPosition, 1, -1, true));		//two to the right one down
		potentialMoves.add(getKnightMovementPattern(currentPosition, -1, 1, true));		//two to the left one up
		potentialMoves.add(getKnightMovementPattern(currentPosition, -1, -1, true));	//two to the left one down
		potentialMoves.add(getKnightMovementPattern(currentPosition, 1, 1, false));		//one to the right two up
		potentialMoves.add(getKnightMovementPattern(currentPosition, 1, -1, false));	//one to the right two down
		potentialMoves.add(getKnightMovementPattern(currentPosition, -1, 1, false));	//one to the left two up
		potentialMoves.add(getKnightMovementPattern(currentPosition, -1, -1, false));	//one to the left two down
		
		return potentialMoves;
	}
	
}
