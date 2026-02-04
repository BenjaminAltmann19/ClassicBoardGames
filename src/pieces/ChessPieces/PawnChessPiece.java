package pieces.ChessPieces;

import java.awt.Point;
import java.util.HashSet;

import Boards.Board;
import Player.Player;

public class PawnChessPiece extends ChessPiece{

	boolean isFirstMove;

	public PawnChessPiece(Point startingPosition, int owner) {
		super(startingPosition, owner);
		identifier = 1;
		isFirstMove = true;
	}

	
	/*
	 * Potential Moves will:
	 * 		be forward if its a regular move (2 if its first is possible)
	 * 		diagonal if there is an opponents piece to take
	 * 
	 * 		cannot result in king going into check
	 */
	public HashSet<Point> findPotentialMoves(Board board, Player player, Point currentPosition){
		HashSet<Point> potentialMoves = new HashSet<Point>();
		Point oneForward = new Point(currentPosition.x + getForwardDirection(), currentPosition.y);
		Point twoForward = new Point(currentPosition.x + getForwardDirection() * 2, currentPosition.y);
		if(isInBounds(oneForward, board) && board.getPieceAt(oneForward).getIdentifier() == 0) {
			potentialMoves.add(oneForward);
			if(isFirstMove && isInBounds(twoForward, board) && (board.getPieceAt(twoForward).getIdentifier() == 0)) {
				potentialMoves.add(twoForward);
			}
		}
		
		potentialMoves.addAll(findCaptures(board, player, currentPosition));

		return potentialMoves;
	}
	
	private HashSet<Point> findCaptures(Board board, Player player, Point currentPosition){
		HashSet<Point> potentialMoves = new HashSet<Point>();
		Point rightDiagonal = new Point(currentPosition.x + board.getForwardDirection(player), currentPosition.y + 1);
		Point leftDiagonal = new Point(currentPosition.x + board.getForwardDirection(player), currentPosition.y - 1);
		
		
		if(isInBounds(rightDiagonal, board) && board.getPieceAt(rightDiagonal).isOpponentsPiece(player.getPlayerOrder()) ){
			potentialMoves.add(rightDiagonal);
		}
		if(isInBounds(leftDiagonal, board) && board.getPieceAt(leftDiagonal).isOpponentsPiece(player.getPlayerOrder())) {
			potentialMoves.add(leftDiagonal);
		}
		
		return potentialMoves;
	}
	
	@Override
	public void move(Board board, Player player, Point destination) {
		super.move(board, player, destination);
		isFirstMove = false;
	}
	
	private int getForwardDirection() {
		if(owner == 1) {
			return 1;
		}else {
			return -1;
		}
	}
}
