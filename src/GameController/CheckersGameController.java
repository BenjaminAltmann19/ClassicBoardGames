package GameController;

import java.awt.Point;

import AnimationController.CheckersAnimationController;
import Boards.CheckersBoard;
import Player.CheckersPlayer;
import Player.Player;
import pieces.Piece;
import pieces.CheckersPieces.PromotedCheckersPiece;

public class CheckersGameController extends GameController{


	public CheckersGameController() {
		super();
		board = new CheckersBoard();
		playerOne = new CheckersPlayer(PLAYER_ONE, board);
		playerTwo = new CheckersPlayer(PLAYER_TWO, board);
		updateBoard();
		animationController = new CheckersAnimationController(board, this);
	}

	/*
	 * Ask which piece to move
	 * Ask where to move it
	 * 
	 * TO DO: 
	 * 	check if game is over
	 * 	display winner
	 * 	add error messages for invalid moves
	 * 
	 */
	public void doOneTurn() {
		Player player = getPlayerForTurn();
		Piece chosenPiece = board.getPieceAt(animationController.getInput(2));
		Point moveHere = animationController.getInput(1);
		if(!player.getPieces().contains(chosenPiece)) {
			System.out.println("Invalid Move, try again");
			//ADD ERROR MESSAGE
		}else {
			if(!chosenPiece.findPotentialMoves(board, player, chosenPiece.getPosition()).contains(moveHere)) {
				System.out.println("Invalid Location selected, Try again");
				//ADD ERROR MESSAGE
			}else {
				movePiece(chosenPiece, moveHere, player);
				animationController.updateBoard(board);
				changePlayerTurn();
			}
		}
		updateBoard();
	}


	/*
	 * This method returns true if the game has been won by someone
	 */
	public boolean isGameWon() {
		return playerOne.lossCondition() || playerTwo.lossCondition();
	}



	/*
	 * This method moves a piece to a new point and fills in the gap left behind.
	 * If the move involves a "jump" it also will handle that
	 */
	@Override
	public void movePiece(Piece piece, Point nextLocation, Player player) {
		if(isJump(piece.getPosition(), nextLocation)) {
			Point midPoint = findMidPoint(piece.getPosition(), nextLocation);
			Piece captured = board.getPieceAt(midPoint);

			getOpponent(player).removePiece(captured);
		}
		super.movePiece(piece, nextLocation, player);

		if(shouldPromote(player, piece)) {
			promotePiece(piece);
		}
	}

	private boolean isJump(Point currentLocation, Point nextLocation) {
		return (Math.abs(currentLocation.x - nextLocation.x) == 2 && Math.abs(currentLocation.y - nextLocation.y) == 2);
	}

	private Point findMidPoint(Point currentLocation, Point nextLocation) {
		return new Point((currentLocation.x + nextLocation.x) / 2, (currentLocation.y + nextLocation.y) / 2);
	}

	private boolean shouldPromote(Player player, Piece piece) {
		int forwardDirection = board.getForwardDirection(player);
		if(forwardDirection == 1) {
			if(piece.getPosition().getX() == board.BOARD_SIZE - 1) {
				return true;
			}
		}else {
			if(piece.getPosition().getX() == 0) {
				return true;
			}
		}
		return false;
	}

	public void promotePiece(Piece piece) {
		Player player = getPlayerForTurn();
		Point location = piece.getPosition();
		if(player.getPieces().contains(piece)) {
			PromotedCheckersPiece promoted = new PromotedCheckersPiece(location, player.getPlayerOrder());
			player.addPiece(promoted);
			player.removePiece(piece);
			board.setLocation(location, promoted);
		}

	}




}
