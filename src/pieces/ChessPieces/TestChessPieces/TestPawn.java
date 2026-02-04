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
	void tesGetPotentialMoves() {
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

}
