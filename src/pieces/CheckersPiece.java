package pieces;

import java.awt.Point;
import java.util.HashSet;

import Boards.Board;
import Player.Player;

public class CheckersPiece extends Piece{

	public CheckersPiece(Point startPosition) {
		super(startPosition);
		identifier = 1;
	}

	/*
	 * This method ensures the location you want to move a piece to is both on the board and empty.
	 */
	@Override
	public boolean isMoveValid(Point point, Board board) {
		if(!super.isMoveValid(point, board)) {
			return false;
		}
		return board.getPieceAt(point).getIdentifier() == 0;
	}


	/*
	 * This method finds all moves that are valid for the piece to make and returns them in a HashSet<Point>
	 * For CheckersPieces that is either forward diagonal if they are open squares
	 */
	public HashSet<Point> findPotentialMoves(Board board){
		HashSet<Point> potentialMoves = getBaseMoves();
		potentialMoves.removeIf(point -> !isMoveValid(point, board));
		return potentialMoves;
	}

	protected HashSet<Point> findPotentialTakes(Board board){
		HashSet<Point> potentialTakes = getBaseMoves();
		potentialTakes.removeIf(point -> board.getPieceAt(point).getIdentifier() != 1);
		return potentialTakes;
	}

	/*
	 * This method makes a HashSet of the forward left and forward right potential moves
	 */
	public HashSet<Point> getMoves(Board board, Player player, Point point, HashSet<Point> potentialMoves){
		Point testPoint = new Point((int)point.getX() + - 1, (int)point.getY() + 1);
		if(board.getPieceAt(testPoint).getIdentifier() == 0) {
			potentialMoves.add(testPoint);
		}else if(!player.getPieces().contains(board.getPieceAt(testPoint))){
			if(board.getPieceAt(new Point(testPoint.x - 1, testPoint.y + 1)).getIdentifier() == 0) {
				potentialMoves.add(new Point(testPoint.x - 1, testPoint.y + 1));
				potentialMoves = getMoves(board, player, point, potentialMoves);
			}
		}
		testPoint = new Point((int)position.getX() + 1, (int)position.getY() + 1);
		if(board.getPieceAt(testPoint).getIdentifier() == 0) {
			potentialMoves.add(testPoint);
		}else if(!player.getPieces().contains(board.getPieceAt(testPoint))){
			if(board.getPieceAt(new Point(testPoint.x + 1, testPoint.y + 1)).getIdentifier() == 0) {
				potentialMoves.add(new Point(testPoint.x + 1, testPoint.y + 1));
				potentialMoves = getMoves(board, player, point, potentialMoves);
			}
		}
		return potentialMoves;
	}
}
