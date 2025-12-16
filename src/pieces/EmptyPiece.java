package pieces;
import java.awt.Point;
import java.util.HashSet;

import Boards.Board;
import Player.Player;

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
	public HashSet<Point> findPotentialMoves(Board board, Player player, Point point){
		HashSet<Point> potentialMovesSet = new HashSet<Point>();
		for(int i = 0; i < board.BOARD_SIZE; i++) {
			for(int j = 0; j < board.BOARD_SIZE; j++) {
				potentialMovesSet.add(new Point(i, j));
			}
		}
		return potentialMovesSet;
	}
}
