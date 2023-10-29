package challenges.paintcan;

import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.Arrays;
import java.util.Scanner;

import challenges.GridTemplate;

/*

	This program paint can fills objects on a 2D grid. 

	Coded by: 
	Modified on: 

*/

public class Image extends GridTemplate {

	
	// Constructs an empty grid
	public Image () {
		super();
	}

	// Constructs the grid defined in the file specified
	public Image (String filename) {
		super(20,20,filename);
	}
	
	/**
	 * Fills an object beginning at x,y.
	 * 
	 * @param x The x coordinate of the beginning of the paint can fill.
	 * @param y The y coordinate of the beginning of the paint can fill.
	 */
	public void paintCanFill(int x, int y, char initialColor, char colorToFill) {
		if (x < 0 || y < 0 || x >= grid.length || y >= grid[0].length) {return;}
		if (grid[x][y] == colorToFill) {return;}
		if (grid[x][y] == initialColor) {
			grid[x][y] = colorToFill;
			paintCanFill(x-1, y, initialColor, colorToFill);
			paintCanFill(x, y-1, initialColor, colorToFill);
			paintCanFill(x+1, y, initialColor, colorToFill);
			paintCanFill(x, y+1, initialColor, colorToFill);
		}
		
	}
	
	public String toString() {
		String output = "";
		for (int i = 0; i < grid.length; i++) {
			for (int j = 0; j < grid[0].length; j++) {
				output+= grid[i][j];
			}
			output+="\n";
		}
		
		return output;
	}
	
	// Additional private recursive methods


}