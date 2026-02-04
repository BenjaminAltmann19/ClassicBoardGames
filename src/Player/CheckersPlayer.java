package Player;

import java.awt.Point;

import Boards.Board;
import pieces.CheckersPieces.CheckersPiece;

public class CheckersPlayer extends Player {
	
	public static final int NUM_STARTING_ROWS = 3;
	
	public CheckersPlayer(int playerOrder, Board board){
		super(playerOrder, board);
	}
	
	public boolean lossCondition() {
		return pieces.size() == 0;
	}
	
	@Override
	protected void initializePieces(Board board) {
		if(playerOrder == 1) {
			initializePieces(board, 0, 0);
		}else {
			initializePieces(board, board.BOARD_SIZE - NUM_STARTING_ROWS, 0);
		}
	}
	
	
	/*
	 * Add checkers pieces to players "Hand" for start of game
	 */
	protected void initializePieces(Board board, int startingRow, int startingColumn) {
		for(int i = startingRow; i < startingRow + NUM_STARTING_ROWS; i++) {
			for(int j = startingColumn; j < board.BOARD_SIZE; j++) {
				if(j % 2 == 0) {
					if(i % 2 == 0) {
						pieces.add(new CheckersPiece(new Point(i, j), playerOrder));
					}
				}else {
					if(i % 2 == 1) {
						pieces.add(new CheckersPiece(new Point(i, j), playerOrder));
					}
				}
			}
		}
	}
	
	
}
