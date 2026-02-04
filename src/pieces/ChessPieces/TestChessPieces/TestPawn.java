package pieces.ChessPieces.TestChessPieces;

import static org.junit.jupiter.api.Assertions.*;

import java.awt.Point;
import java.util.HashSet;

import org.junit.jupiter.api.Test;

import Boards.ChessBoard;
import Player.ChessPlayer;
import pieces.ChessPieces.PawnChessPiece;

class TestPawn {

	@Test
	void testGetPotentialMovesAll() {
		ChessBoard board = new ChessBoard();
		ChessPlayer player = new ChessPlayer(1);
		PawnChessPiece chessPiece = new PawnChessPiece(new Point(3,3), player.getPlayerOrder());
		player.addPiece(chessPiece);
		board.setLocation(chessPiece.getPosition(), chessPiece);
		HashSet<Point> correctMoves = new HashSet<Point>();
		correctMoves.add(new Point(4,3));
		correctMoves.add(new Point(5,3));
		assertEquals(correctMoves, chessPiece.findPotentialMoves(board, player, chessPiece.getPosition()));
	}
	
	@Test
	void testGetPotentialMovesWithTake() {
		ChessBoard board = new ChessBoard();
		ChessPlayer playerOne = new ChessPlayer(1);
		PawnChessPiece chessPieceOne = new PawnChessPiece(new Point(3,3), playerOne.getPlayerOrder());
		ChessPlayer playerTwo = new ChessPlayer(2);
		PawnChessPiece chessPieceTwo = new PawnChessPiece(new Point(4,4), playerTwo.getPlayerOrder());
		playerOne.addPiece(chessPieceOne);
		playerTwo.addPiece(chessPieceTwo);
		board.setLocation(chessPieceOne.getPosition(), chessPieceOne);
		board.setLocation(chessPieceTwo.getPosition(), chessPieceTwo);
		HashSet<Point> correctMoves = new HashSet<Point>();
		correctMoves.add(new Point(4,3));
		correctMoves.add(new Point(5,3));
		correctMoves.add(new Point(4,4));
		assertEquals(correctMoves, chessPieceOne.findPotentialMoves(board, playerOne, chessPieceOne.getPosition()));
	}

}
