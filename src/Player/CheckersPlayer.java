package Player;

import Boards.Board;

public class CheckersPlayer extends Player {
	
	public CheckersPlayer(int playerOrder, Board board){
		super(playerOrder, board);
	}
	
	public boolean lossCondition() {
		return pieces.size() == 0;
	}
	
	
}
