package pieces.ChessPieces;

import java.awt.Point;
import java.util.HashSet;

import Boards.Board;
import Player.Player;


public class BishopChessPiece extends ChessPiece {

	public BishopChessPiece(Point startingPoint, int owner) {
		super(startingPoint, owner);
		identifier = 3;
	}
	
	public HashSet<Point> findPotentialMoves(Board board, Player player, Point startingPoint){
		HashSet<Point> potentialMoves = new HashSet<Point>();
		
		return potentialMoves;
	}
}
