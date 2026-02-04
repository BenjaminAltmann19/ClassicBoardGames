package pieces.ChessPieces;

import java.awt.Point;
import java.util.HashSet;

import Boards.Board;
import Player.Player;
import pieces.Piece;

public abstract class ChessPiece extends Piece {

	
	public ChessPiece(Point startPosition, int owner) {
		super(startPosition, owner);
	}
	
	public abstract HashSet<Point> findPotentialMoves(Board board, Player player, Point currentPosition);
	
}
