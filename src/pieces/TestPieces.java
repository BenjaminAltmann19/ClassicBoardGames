package pieces;

import static org.junit.jupiter.api.Assertions.*;

import java.awt.Point;
import java.util.HashSet;

import org.junit.jupiter.api.Test;

import Boards.CheckersBoard;

class TestPieces {

	@Test
	void testFindPotentialMoves() {
		CheckersBoard board = new CheckersBoard();
		CheckersPiece checkerPiece = new CheckersPiece(new Point(3,3));
		HashSet<Point> correctMoves = new HashSet<Point>();
		correctMoves.add(new Point(2,4));
		correctMoves.add(new Point(4,4));
		assertEquals(correctMoves, checkerPiece.findPotentialMoves(board));
	}
	
	@Test
	void testFindPotentialMovesWall() {
		CheckersBoard board = new CheckersBoard();
		CheckersPiece checkerPiece = new CheckersPiece(new Point(0,3));
		HashSet<Point> correctMoves = new HashSet<Point>();
		correctMoves.add(new Point(1,4));
		assertEquals(correctMoves, checkerPiece.findPotentialMoves(board));
	}

}
