package pieces.CheckersPieces;

import java.awt.Point;
import java.util.HashSet;

import Boards.Board;
import Player.Player;
import pieces.Piece;

public class PromotedCheckersPiece extends CheckersPiece {

	
	public PromotedCheckersPiece(Point startingPoint){
		super(startingPoint);
		identifier = 2;
	}
	
	@Override
	public HashSet<Point> findPotentialMoves(Board board, Player player, Point currentLocation) {
	    HashSet<Point> steps = new HashSet<>();
	    int forwardDirection = board.getForwardDirection(player);
	    addStepIfOpen(board, currentLocation, forwardDirection, -1, steps);
	    addStepIfOpen(board, currentLocation, forwardDirection, +1, steps);
	    addStepIfOpen(board, currentLocation, -forwardDirection, +1, steps);
	    addStepIfOpen(board, currentLocation, -forwardDirection, -1, steps);
	    HashSet<Point> jumps = new HashSet<>();
	    addJumpLandings(board, player, currentLocation, new HashSet<>(), jumps);

	    steps.addAll(jumps);
	    return steps;
	}
	@Override
	protected void addStepIfOpen(Board board, Point currentLocation, int forwardDirection, int directionY, HashSet<Point> steps) {
	    Point nextLocation = new Point(currentLocation.x + forwardDirection, currentLocation.y + directionY);
	    if (isMoveValid(nextLocation, board) && board.getPieceAt(nextLocation).getIdentifier() == 0) {
	        steps.add(nextLocation);
	    }
	}
	@Override
	protected void addJumpLandings(Board board, Player player, Point currentLocation, HashSet<Point> capturedSoFar, HashSet<Point> steps) {

		int forwardDirection = board.getForwardDirection(player);
	    // forward-left and forward-right jump directions
	    tryJump(board, player, currentLocation, forwardDirection, -1, capturedSoFar, steps);
	    tryJump(board, player, currentLocation, forwardDirection, +1, capturedSoFar, steps);
	    tryJump(board, player, currentLocation, -forwardDirection, -1, capturedSoFar, steps);
	    tryJump(board, player, currentLocation, -forwardDirection, +1, capturedSoFar, steps);
	}
	@Override
	protected void tryJump(Board board, Player player, Point currentLocation, int forwardDirection, int directionY, HashSet<Point> capturedSoFar, HashSet<Point> steps) {

	    Point mid = new Point(currentLocation.x + forwardDirection, currentLocation.y + directionY);
	    Point landing = new Point(currentLocation.x + 2 * forwardDirection, currentLocation.y + 2 * directionY);

	    // both mid and landing must be on-board
	    if (!isInBounds(mid, board) || !isInBounds(landing, board)) return;

	    // landing must be empty
	    if (board.getPieceAt(landing).getIdentifier() != 0) return;

	    // mid must contain an enemy piece, and we can’t “capture” the same mid twice in this DFS
	    if (capturedSoFar.contains(mid)) return;

	    Piece midPiece = board.getPieceAt(mid);
	    boolean isEnemy = midPiece.getIdentifier() != 0 && !player.getPieces().contains(midPiece);
	    if (!isEnemy) return;

	    // this landing is reachable by a capture
	    steps.add(landing);

	    // multi-jump: continue from landing, marking this mid as captured
	    HashSet<Point> nextCaptured = new HashSet<>(capturedSoFar);
	    nextCaptured.add(mid);
	    addJumpLandings(board, player, landing, nextCaptured, steps);
	}
}
