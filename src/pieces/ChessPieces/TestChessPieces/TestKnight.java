package pieces.ChessPieces.TestChessPieces;

import static org.junit.jupiter.api.Assertions.*;

import java.awt.Point;
import java.util.HashSet;

import org.junit.jupiter.api.Test;

import Boards.ChessBoard;
import Player.ChessPlayer;
import pieces.ChessPieces.KnightChessPiece;

class TestKnight {

	@Test
	void testGetPotentialMovesAll() {
		ChessBoard board = new ChessBoard();
		ChessPlayer player = new ChessPlayer(1);
		KnightChessPiece chessPiece = new KnightChessPiece(new Point(3,3), player.getPlayerOrder());
		player.addPiece(chessPiece);
		board.setLocation(chessPiece.getPosition(), chessPiece);
		HashSet<Point> correctMoves = new HashSet<Point>();
		correctMoves.add(new Point(5,2));
		correctMoves.add(new Point(5,4));
		correctMoves.add(new Point(1,2));
		correctMoves.add(new Point(1,4));
		correctMoves.add(new Point(2,5));
		correctMoves.add(new Point(4,5));
		correctMoves.add(new Point(2,1));
		correctMoves.add(new Point(4,1));
		assertEquals(correctMoves, chessPiece.findPotentialMoves(board, player, chessPiece.getPosition()));
	}
	
	@Test
	void testGetPotentialMovesBlocked() {
		ChessBoard board = new ChessBoard();
		ChessPlayer player = new ChessPlayer(1);
		KnightChessPiece chessPiece = new KnightChessPiece(new Point(3,3), player.getPlayerOrder());
		KnightChessPiece chessPieceTwo = new KnightChessPiece(new Point(5,2), player.getPlayerOrder());
		player.addPiece(chessPiece);
		player.addPiece(chessPieceTwo);
		board.setLocation(chessPiece.getPosition(), chessPiece);
		board.setLocation(chessPieceTwo.getPosition(), chessPieceTwo);
		HashSet<Point> correctMoves = new HashSet<Point>();
		correctMoves.add(new Point(5,4));
		correctMoves.add(new Point(1,2));
		correctMoves.add(new Point(1,4));
		correctMoves.add(new Point(2,5));
		correctMoves.add(new Point(4,5));
		correctMoves.add(new Point(2,1));
		correctMoves.add(new Point(4,1));
		assertEquals(correctMoves, chessPiece.findPotentialMoves(board, player, chessPiece.getPosition()));
	}
	
	@Test
	void testGetPotentialMovesEdgeOfBoard() {
		ChessBoard board = new ChessBoard();
		ChessPlayer player = new ChessPlayer(1);
		KnightChessPiece chessPiece = new KnightChessPiece(new Point(7,7), player.getPlayerOrder());
		player.addPiece(chessPiece);
		board.setLocation(chessPiece.getPosition(), chessPiece);
		HashSet<Point> correctMoves = new HashSet<Point>();
		correctMoves.add(new Point(5,6));
		correctMoves.add(new Point(6,5));
		assertEquals(correctMoves, chessPiece.findPotentialMoves(board, player, chessPiece.getPosition()));
	}

}
