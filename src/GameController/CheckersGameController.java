package GameController;

import java.awt.Point;
import java.util.Scanner;

import Boards.CheckersBoard;
import Player.CheckersPlayer;
import Player.Player;
import pieces.CheckersPiece;
import pieces.EmptyPiece;
import pieces.Piece;

public class CheckersGameController extends GameController{

	public static final int PLAYER_ONE = 1;
	public static final int PLAYER_TWO = 2;
	public static final int NUM_STARTING_ROWS = 3;
	

	public CheckersGameController() {
		super();
		board = new CheckersBoard();
		playerOne = new CheckersPlayer(PLAYER_ONE);
		playerTwo = new CheckersPlayer(PLAYER_TWO);
		initialize();
		board.printBoard();
		gameLoop();
	}

	/*
	 * set everything to be ready to start
	 */
	public void initialize() {
		super.initialize();
		initializePlayer(playerOne);
		initializePlayer(playerTwo);
	}

	/*
	 * This method adds pieces to the board depending on which player they are.
	 */
	public void initializePlayer(Player player) {
		if(player.getPlayerOrder() == 1) {
			initializePlayer(player, 0, 0);
		}else {
			initializePlayer(player, board.BOARD_SIZE - 3, 0);
		}
	}
	
	/*
	 * This method adds pieces to the board depending on which player they are.
	 */
	private void initializePlayer(Player player, int startingRow, int startingColumn) {
		for(int i = startingRow; i < startingRow + NUM_STARTING_ROWS; i++) {
			for(int j = startingColumn; j < board.BOARD_SIZE; j++) {
				if(j % 2 == 0) {
					if(i % 2 == 0) {
						createPiece(player, i, j);
					}
				}else {
					if(i % 2 == 1) {
						createPiece(player, i, j);
					}
				}
			}
		}
	}
	/*
	 * This method is the main game loop
	 */
	public void gameLoop() {
		while(!isGameWon()) {
			doOneTurn(playerOne);
			doOneTurn(playerTwo);
		}
	}
	
	/*
	 * Ask which piece to move
	 * Ask where to move it
	 */
	public void doOneTurn(Player player) {
		System.out.println("Player: " + player.getPlayerOrder() + " Enter the cordinates of the piece you want to move (ex: 3,3)");
		Piece chosenPiece = board.getPieceAt(input.askForPoint());
		System.out.println("Player: " + player.getPlayerOrder() + " Enter the cordinates of where you want to move the piece to (ex: 3,3)");
		Point moveHere = input.askForPoint();
		if(player.getPieces().contains(chosenPiece)) {
			movePiece(chosenPiece, moveHere);
			board.printBoard();
		}
	}
	
	/*
	 * This method returns true if the game has been won by someone
	 */
	public boolean isGameWon() {
		return playerOne.hasNoPieces() || playerTwo.hasNoPieces();
	}
	
	/*
	 * This method is adding the piece to the players "hand" and placing it on the board
	 */
	public void createPiece(Player player, int row, int column) {
		CheckersPiece piece = new CheckersPiece(new Point(row,column));
		player.addPiece(piece);
		board.getBoard()[row][column] = piece;
	}
	
	public void jumpPiece(Player player, Piece piece) {
		
	}



}
