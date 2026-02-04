package Player;

import java.util.LinkedList;

import Boards.Board;
import pieces.Piece;

public abstract class Player {
	

	protected LinkedList<Piece> pieces = new LinkedList<>();
	
	//Player one or player two
	protected int playerOrder;
	
	public Player(int playerOrder, Board board) {
		this.playerOrder = playerOrder;
		initializePieces(board);
	}
	
	/*
	 * This is for testing purposes, wont automatically all the pieces to the player.
	 */
	public Player(int playerOrder) {
		this.playerOrder = playerOrder;
	}
	
	public abstract boolean lossCondition();
	
	public void addPiece(Piece piece) {
		pieces.add(piece);
	}
	
	public int getPlayerOrder() {
		return playerOrder;
	}
	
	public LinkedList<Piece> getPieces() {
		return pieces;
	}
	
	public void removePiece(Piece piece) {
		if(pieces.contains(piece)) {
			pieces.remove(piece);
		}
	}
	
	protected abstract void initializePieces(Board board);
	
	
	
}