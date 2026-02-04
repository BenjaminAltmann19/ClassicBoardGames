package Player;

import java.awt.Point;

import Boards.Board;
import pieces.ChessPieces.BishopChessPiece;
import pieces.ChessPieces.KingChessPiece;
import pieces.ChessPieces.KnightChessPiece;
import pieces.ChessPieces.PawnChessPiece;
import pieces.ChessPieces.QueenChessPiece;
import pieces.ChessPieces.RookChessPiece;

public class ChessPlayer extends Player {
	
	public ChessPlayer(int playerOrder, Board board) {
		super(playerOrder, board);
	}
	
	/*
	 * This is for testing purposes, wont automatically all the pieces to the player.
	 */
	public ChessPlayer(int playerOrder) {
		super(playerOrder);
	}
	
	public boolean lossCondition() {
		return checkIfCheckMated();
	}
	
	public boolean checkIfCheckMated() {
		return false;	//Temporary
	}
	
	protected void initializePieces(Board board) {
		initializePawns(board);
		initializeKnights(board);
		initializeBishops(board);
		initializeRooks(board);
		initializeQueen(board);
		initializeKing(board);
		
	}
	
	/*
	 * TO DO:
	 * Condense all these different piece initializations into a factory pattern
	 * 
	 */
	
	
	
	/*
	 * Add pawns to players "hand" for start of game
	 */
	private void initializePawns(Board board){
		if(playerOrder == 1) {
			for(int i = 0; i < Board.BOARD_SIZE; i++) {
				pieces.add(new PawnChessPiece(new Point(1,i), playerOrder));
			}
		}else{
			for(int i = 0; i < Board.BOARD_SIZE; i++) {
				pieces.add(new PawnChessPiece(new Point(board.BOARD_SIZE - 2,i), playerOrder));
			}
		}
	}
	
	
	/*
	 * Add knights to players "Hand" for start of game
	 */
	private void initializeKnights(Board board) {
		if(playerOrder == 1) {
			pieces.add(new KnightChessPiece(new Point(0,1), playerOrder));
			pieces.add(new KnightChessPiece(new Point(0, board.BOARD_SIZE - 2), playerOrder));
		}else {
			pieces.add(new KnightChessPiece(new Point(board.BOARD_SIZE - 1, 1), playerOrder));
			pieces.add(new KnightChessPiece(new Point(board.BOARD_SIZE - 1, board.BOARD_SIZE - 2), playerOrder));
		}
	}
	
	
	private void initializeBishops(Board board) {
		if(playerOrder == 1) {
			pieces.add(new BishopChessPiece(new Point(0,2), playerOrder));
			pieces.add(new BishopChessPiece(new Point(0, board.BOARD_SIZE - 3), playerOrder));
		}else {
			pieces.add(new BishopChessPiece(new Point(board.BOARD_SIZE - 1, 2), playerOrder));
			pieces.add(new BishopChessPiece(new Point(board.BOARD_SIZE - 1, board.BOARD_SIZE - 3), playerOrder));
		}
	}
	
	private void initializeRooks(Board board) {
		if(playerOrder == 1) {
			pieces.add(new RookChessPiece(new Point(0,0), playerOrder));
			pieces.add(new RookChessPiece(new Point(0, board.BOARD_SIZE - 1), playerOrder));
		}else {
			pieces.add(new RookChessPiece(new Point(board.BOARD_SIZE - 1, 0), playerOrder));
			pieces.add(new RookChessPiece(new Point(board.BOARD_SIZE - 1, board.BOARD_SIZE - 1), playerOrder));
		}
	}
	
	private void initializeQueen(Board board) {
		if(playerOrder == 1) {
			pieces.add(new QueenChessPiece(new Point(0,3), playerOrder));
		}else {
			pieces.add(new QueenChessPiece(new Point(board.BOARD_SIZE - 1, 3), playerOrder));
		}
	}
	
	private void initializeKing(Board board) {
		if(playerOrder == 1) {
			pieces.add(new KingChessPiece(new Point(0,4), playerOrder));
		}else {
			pieces.add(new KingChessPiece(new Point(board.BOARD_SIZE - 1, 4), playerOrder));
		}
	}
	
	

}
