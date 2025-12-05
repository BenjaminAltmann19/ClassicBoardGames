package Player;

import java.util.LinkedList;

import pieces.Piece;

public abstract class Player {
	

	protected LinkedList<Piece> pieces = new LinkedList<>();
	
	//Player one or player two
	private int playerOrder;
	
	public Player(int playerOrder) {
		this.playerOrder = playerOrder;
	}
	
	public abstract boolean hasNoPieces();
	
	public void addPiece(Piece piece) {
		pieces.add(piece);
	}
	
	public int getPlayerOrder() {
		return playerOrder;
	}
	
	public LinkedList<Piece> getPieces() {
		return pieces;
	}
	
	
	
}