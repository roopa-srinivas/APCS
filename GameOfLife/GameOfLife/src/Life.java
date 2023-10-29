import java.awt.Color;
import java.awt.Point;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.Scanner;

import processing.core.PApplet;

/**

	Represents a Game Of Life grid.

	Coded by: roopa srinivas
	Modified on:

*/

public class Life {

	// Add a 2D array field to represent the Game Of Life grid.
	boolean[][] grid;
	
	
	
	
	/**
	 * Initialized the Game of Life grid to an empty 20x20 grid.
	 */
	public Life() {
		grid = new boolean[20][20];
	}

	
	
	/**
	 * Initializes the Game of Life grid to a 20x20 grid and fills it with data from the file given.
	 * 
	 * @param filename The path to the text file.
	 */
	public Life(String filename) {
		grid = new boolean[20][20];
		readData(filename, grid);
		System.out.println(this);
	}

	
	
	/**
	 * Runs a single step within the Game of Life by applying the Game of Life rules on
	 * the grid.
	 */
	public void step() {
		this.step(1);
	}

	
	
	/**
	 * Runs n steps within the Game of Life.
	 * @param n The number of steps to run.
	 */
	public void step(int n) {
		boolean[][] newValues = new boolean[grid.length][grid[0].length];
		
		for (int k = 0; k < n; k++) {
			for (int i = 0; i < grid.length; i++) {
				for (int j = 0; j < grid[0].length; j++) {
					newValues[i][j] = grid[i][j];
					int cellNeighbors = countNeighbors(i, j);
					if (grid[i][j] == false && cellNeighbors == 3) {
						newValues[i][j] = true;
					} else if (cellNeighbors <= 1 || cellNeighbors >= 4) {
						newValues[i][j] = false;
					} 
				}
			}
			
			for (int i = 0; i < newValues.length; i++) {
				for (int j = 0; j < newValues[0].length; j++) {
					grid[i][j] = newValues[i][j];
				}
			}
			
			
		}
	}
	
	public int countNeighbors(int i, int j) {
		int numRows = grid.length;
		int numCols = grid[0].length;
		int numNeighbors = 0;
		
		//checking the position of the cell and finding number of neighbors accordingly
		if (i < numRows-1) {
			if (grid[i+1][j] == true) numNeighbors++;
		}
		
		if (j < numCols-1) {
			if (grid[i][j+1] == true) numNeighbors++;
		}
		
		if (i < numRows-1 && j < numCols-1) {
			if (grid[i+1][j+1] == true) numNeighbors++;
		}
		
		if (i > 0) {
			if (grid[i-1][j] == true) numNeighbors++;
		}
		
		if (j > 0) {
			if (grid[i][j-1] == true) numNeighbors++;
		}
		
		if (i > 0 && j > 0) {
			if (grid[i-1][j-1] == true) numNeighbors++;
		}
		
		if (i < numRows-1 && j > 0) {
			if (grid[i+1][j-1] == true) numNeighbors++;
		}
		
		if (i > 0 && j < numCols-1) {
			if (grid[i-1][j+1] == true) numNeighbors++;
		}
		
		
		return numNeighbors;
	}
	
	
	
	/**
	 * Formats this Life grid as a String to be printed (one call to this method returns the whole multi-line grid)
	 * 
	 * @return The grid formatted as a String.
	 */
	public String toString() {
		String output = "";
		for (int i = 0; i < grid.length; i++) {
			for (int j = 0; j < grid[0].length; j++) {
				if (grid[i][j]) {
					output += "*";
				} else {
					output +=" ";
				}
			}
			output += "\n";
		}
		
		return output;
	}
	
	
	
	/**
	 * (Graphical UI)
	 * Draws the grid on a PApplet.
	 * The specific way the grid is depicted is up to the coder.
	 * 
	 * @param marker The PApplet used for drawing.
	 * @param x The x pixel coordinate of the upper left corner of the grid drawing. 
	 * @param y The y pixel coordinate of the upper left corner of the grid drawing.
	 * @param width The pixel width of the grid drawing.
	 * @param height The pixel height of the grid drawing.
	 */
	public void draw(PApplet marker, float x, float y, float width, float height) {
		
		marker.noFill();
		
		float rectWidth = width/grid[0].length;
		float rectHeight = height/grid.length;
		
		for (int i = 0; i < grid.length; i++) {
			for (int j = 0; j < grid[0].length; j++) {
				
				if (grid[j][i]) {
					marker.fill(143, 177, 235);
				} else {
					marker.noFill();
				}
				
				float rectX = x + j*rectWidth;
				float rectY = y + i*rectHeight;				
				marker.rect(rectX, rectY, rectWidth, rectHeight);
				
			}
		}
		
	}
	
	
	
	/**
	 * (Graphical UI)
	 * Determines which element of the grid matches with a particular pixel coordinate.
	 * This supports interaction with the grid using mouse clicks in the window.
	 * 
	 * @param p A Point object containing a graphical pixel coordinate.
	 * @param x The x pixel coordinate of the upper left corner of the grid drawing. 
	 * @param y The y pixel coordinate of the upper left corner of the grid drawing.
	 * @param width The pixel width of the grid drawing.
	 * @param height The pixel height of the grid drawing.
	 * @return A Point object representing a coordinate within the game of life grid.
	 */
	public Point clickToIndex(Point p, float x, float y, float width, float height) {
		
		Point coordinate = new Point();
		
		float boxWidth = width/grid.length;
		float boxHeight = height/grid[0].length;
		
		int boxX = (int) ((p.getX() - x) / boxWidth);
		int boxY = (int) ((p.getY() - y) / boxHeight);
		
		if (boxX >= 0 && boxX < grid.length && boxY >= 0 && boxY < grid[0].length) {
			coordinate = new Point(boxX, boxY);
			return coordinate;	
		}
		return null;
	}
	
	/**
	 * (Graphical UI)
	 * Toggles a cell in the game of life grid between alive and dead.
	 * This allows the user to modify the grid.
	 * 
	 * @param i The x coordinate of the cell in the grid.
	 * @param j The y coordinate of the cell in the grid.
	 */
	public void toggleCell(int i, int j) {
		grid[i][j] = !grid[i][j]; //switches the cell's value
	}

	

	// Reads in array data from a simple text file containing asterisks (*)
	public void readData (String filename, boolean[][] gameData) {
		File dataFile = new File(filename);

		if (dataFile.exists()) {
			int count = 0;

			FileReader reader = null;
			Scanner in = null;
			try {
				reader = new FileReader(dataFile);
				in = new Scanner(reader);

				while (in.hasNext()) {
					String line = in.nextLine();
					for(int i = 0; i < line.length(); i++)
						if (count < gameData.length && i < gameData[count].length && line.charAt(i)=='*')
							gameData[count][i] = true;

					count++;
				}
			} catch (IOException ex) {
				throw new IllegalArgumentException("Data file " + filename + " cannot be read.");
			} finally {
				if (in != null)
					in.close();
			}

		} else {
			throw new IllegalArgumentException("Data file " + filename + " does not exist.");
		}
	}
	
	
	public int getNumRows() {
		return grid.length;
	}
	
	public int getNumCols() {
		return grid[0].length;
	}



	
	
}