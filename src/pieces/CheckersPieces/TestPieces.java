package pieces.CheckersPieces;

import static org.junit.jupiter.api.Assertions.*;

import java.awt.Point;
import java.util.HashSet;

import org.junit.jupiter.api.Test;

import Boards.CheckersBoard;
import Player.CheckersPlayer;

class TestPieces {

	@Test
	void testFindPotentialMoves() {
		CheckersBoard board = new CheckersBoard();
		CheckersPlayer player = new CheckersPlayer(1, board);
		CheckersPiece checkerPiece = new CheckersPiece(new Point(3,3), player.getPlayerOrder());
		player.addPiece(checkerPiece);
		board.setLocation(checkerPiece.getPosition(), checkerPiece);
		HashSet<Point> correctMoves = new HashSet<Point>();
		correctMoves.add(new Point(4,2));
		correctMoves.add(new Point(4,4));
		assertEquals(correctMoves, checkerPiece.findPotentialMoves(board, player, checkerPiece.getPosition()));
	}
	
	@Test
	void testFindPotentialMovesWall() {
		CheckersBoard board = new CheckersBoard();
		CheckersPlayer player = new CheckersPlayer(1, board);
		CheckersPiece checkerPiece = new CheckersPiece(new Point(2,0), player.getPlayerOrder());
		player.addPiece(checkerPiece);
		board.setLocation(checkerPiece.getPosition(), checkerPiece);
		HashSet<Point> correctMoves = new HashSet<Point>();
		correctMoves.add(new Point(3,1));
		assertEquals(correctMoves, checkerPiece.findPotentialMoves(board, player, checkerPiece.getPosition()));
	}
	
	@Test
	void testFindPotentialMovesTake() {
		CheckersBoard board = new CheckersBoard();
		CheckersPlayer playerOne = new CheckersPlayer(1, board);
		CheckersPlayer playerTwo = new CheckersPlayer(2, board);
		CheckersPiece checkerPiece = new CheckersPiece(new Point(0,2), playerOne.getPlayerOrder());
		CheckersPiece enemyPiece = new CheckersPiece(new Point(1,3), playerTwo.getPlayerOrder());
		playerOne.addPiece(checkerPiece);
		playerTwo.addPiece(enemyPiece);
		board.setLocation(checkerPiece.getPosition(), checkerPiece);
		board.setLocation(enemyPiece.getPosition(), enemyPiece);
		HashSet<Point> correctMoves = new HashSet<Point>();
		correctMoves.add(new Point(2,4));
		correctMoves.add(new Point(1,1));
		assertEquals(correctMoves, checkerPiece.findPotentialMoves(board, playerOne, checkerPiece.getPosition()));
	}
	
	@Test
	void testFindPotentialMovesMulitpleTakes() {
		CheckersBoard board = new CheckersBoard();
		CheckersPlayer playerOne = new CheckersPlayer(1, board);
		CheckersPlayer playerTwo = new CheckersPlayer(2, board);
		CheckersPiece checkerPiece = new CheckersPiece(new Point(3,3), playerOne.getPlayerOrder());
		CheckersPiece enemyPiece = new CheckersPiece(new Point(4,4), playerTwo.getPlayerOrder());
		CheckersPiece enemyPieceTwo = new CheckersPiece(new Point(6,6), playerTwo.getPlayerOrder());
		playerOne.addPiece(checkerPiece);
		playerTwo.addPiece(enemyPiece);
		playerTwo.addPiece(enemyPieceTwo);
		board.setLocation(checkerPiece.getPosition(), checkerPiece);
		board.setLocation(enemyPiece.getPosition(), enemyPiece);
		board.setLocation(enemyPieceTwo.getPosition(), enemyPieceTwo);
		HashSet<Point> correctMoves = new HashSet<Point>();
		correctMoves.add(new Point(4,2));
		correctMoves.add(new Point(5,5));
		correctMoves.add(new Point(7,7));
		assertEquals(correctMoves, checkerPiece.findPotentialMoves(board, playerOne, checkerPiece.getPosition()));
	}

}
