package Player;

public class CheckersPlayer extends Player {
	
	public CheckersPlayer(int playerOrder){
		super(playerOrder);
	}
	
	public boolean hasNoPieces() {
		return pieces.size() == 0;
	}
	
	
}
