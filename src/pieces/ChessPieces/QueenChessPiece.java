package pieces.ChessPieces;

import java.awt.Point;
import java.util.HashSet;

import Boards.Board;
import Player.Player;

public class QueenChessPiece extends ChessPiece{

	
	public QueenChessPiece(Point startingPoint, int owner) {
		super(startingPoint, owner);
		identifier = 5;
	}
	
	public HashSet<Point> findPotentialMoves(Board board, Player player, Point startingPoint){
		HashSet<Point> potentialMoves = new HashSet<Point>();
		
		return potentialMoves;
	}
}
