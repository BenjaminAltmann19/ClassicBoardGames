package Display;

import java.awt.Point;

import GameController.GameController;
import javafx.scene.Group;
import javafx.scene.paint.Color;
import javafx.scene.shape.Rectangle;

public class GridUI {
	
	private static final int TILE_SIZE = 20;

	
	private Rectangle[][] mirrorGrid;
	int numRows;
	int numColumns;
	
	private Group drawing = new Group();

	public GridUI(int rows, int cols) {
		numRows = rows;
		numColumns = cols;
	}
	
	public void setUpGrid(GameController gameController) {
		drawing.getChildren().clear();
		
		mirrorGrid = new Rectangle[numRows][numColumns];
		
		for(int i = 0; i < numRows; i++){
			for(int j =0; j < numColumns; j++){
				Rectangle rect = new Rectangle(j*TILE_SIZE, i*TILE_SIZE, TILE_SIZE, TILE_SIZE);
				Point point = new Point(i ,j);
				//int piece = gameController.getBoard().getPieceAt(point);
				rect.setFill(Color.BLACK);
				mirrorGrid[i][j] = rect;
				drawing.getChildren().add(rect);
			}	
		}
	}
}
