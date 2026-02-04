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
}
