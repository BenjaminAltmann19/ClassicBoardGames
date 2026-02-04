package Player;

import java.awt.Point;

import Boards.Board;
import pieces.ChessPieces.KnightChessPiece;
import pieces.ChessPieces.PawnChessPiece;

public class ChessPlayer extends Player {
	
	public ChessPlayer(int playerOrder, Board board) {
		super(playerOrder, board);
		initializePieces(board);
	}
	
	public boolean lossCondition() {
		return checkIfCheckMated();
	}
	
	public boolean checkIfCheckMated() {
		return false;	//Temporary
	}
	
	private void initializePieces(Board board) {
		initializePawns(board);
		initializeKnights(board);
		initializeBishops(board);
		initializeRooks(board);
		initializeQueen(board);
		initializeKing(board);
		
	}
	
	
	/*
	 * Add pawns to players "hand" for start of game
	 */
	private void initializePawns(Board board){
		if(playerOrder == 0) {
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
		if(playerOrder == 0) {
			pieces.add(new KnightChessPiece(new Point(0,1), playerOrder));
			pieces.add(new KnightChessPiece(new Point(0, board.BOARD_SIZE - 2), playerOrder));
		}else {
			pieces.add(new KnightChessPiece(new Point(board.BOARD_SIZE - 1, 1), playerOrder));
			pieces.add(new KnightChessPiece(new Point(board.BOARD_SIZE - 1, board.BOARD_SIZE - 2), playerOrder));
		}
	}
	
	private void initializeBishops(Board board) {
		
	}
	
	private void initializeRooks(Board board) {
		
	}
	
	private void initializeQueen(Board board) {
		
	}
	
	private void initializeKing(Board board) {
		
	}
	
	

}
