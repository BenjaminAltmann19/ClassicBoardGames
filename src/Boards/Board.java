package Boards;

import java.awt.Point;

import pieces.EmptyPiece;
import pieces.Piece;

public abstract class Board {

	public static final int BOARD_SIZE = 8;
	Piece[][] board = new Piece[BOARD_SIZE][BOARD_SIZE];
	
	public Board() {
		initializeBoard();
	}
	
	/*
	 * This method returns the Piece at a given position
	 */
	public Piece getPieceAt(Point point) {
		return board[(int)point.getX()][(int)point.getY()];
	}
	
	public Piece[][] getBoard(){
		return board;
	}
	
	/*
	 * This method starts the board with all empty pieces
	 */
	public void initializeBoard() {
		for(int i = 0; i < BOARD_SIZE; i++) {
			for(int j = 0; j < BOARD_SIZE; j++) {
				board[i][j] = new EmptyPiece(new Point(i, j));
				}
		}
	}
	
	/*
	 * This method allows me to print what the board looks like according to the pieces identifier number.
	 */
	public void printBoard() {
		for(int i = 0; i < BOARD_SIZE; i++) {
			for(int j = 0; j < BOARD_SIZE; j++) {
				System.out.print(board[i][j].getIdentifier() + " ");
				}
			System.out.println();
		}
	}
	
}
