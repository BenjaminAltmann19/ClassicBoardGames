package pieces;

import static org.junit.jupiter.api.Assertions.*;

import java.awt.Point;
import java.util.HashSet;

import org.junit.jupiter.api.Test;

class TestPieces {

	@Test
	void testFindPotentialMoves() {
		CheckersPiece checkerPiece = new CheckersPiece(new Point(3,3));
		HashSet<Point> correctMoves = new HashSet<Point>();
		correctMoves.add(new Point(2,4));
		correctMoves.add(new Point(4,4));
		assertEquals(correctMoves, checkerPiece.findPotentialMoves(5));
	}
	
	@Test
	void testFindPotentialMovesWall() {
		CheckersPiece checkerPiece = new CheckersPiece(new Point(0,3));
		HashSet<Point> correctMoves = new HashSet<Point>();
		correctMoves.add(new Point(1,4));
		assertEquals(correctMoves, checkerPiece.findPotentialMoves(5));
	}

}
