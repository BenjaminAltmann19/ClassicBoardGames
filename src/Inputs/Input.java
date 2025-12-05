package Inputs;

import java.awt.Point;
import java.util.Scanner;

public class Input {

	
	public Input() {
		
	}
	
	
	/*
	 * This method takes input from the user and returns a Point.
	 */
	public Point askForPoint() {
		Scanner input = new Scanner(System.in);
		String stringPoint = input.nextLine();
		String[] parts = stringPoint.split(",");
		
		int y = Integer.parseInt(parts[0].trim());
		int x = Integer.parseInt(parts[1].trim());
		
		return new Point(x,y);
		
	}
}
