package challenges.maze;

import java.awt.Point;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Scanner;

import challenges.GridTemplate;
import processing.core.PApplet;


/*

	Represents a 2D maze.

	Coded by:
	Modified on:

*/

public class Maze extends GridTemplate {

	// Constructs an empty grid
	public Maze() {
		super();
	}

	// Constructs the grid defined in the file specified
	public Maze(String filename) {
		super(20,20,filename);
	}

	/**
	 * Attempts to find a path through the maze and returns whether a path was found or not. The path that is found
	 * need not be an optimal path, just one possible route.
	 * The maze should be marked with the path that was found, so a print-out of the grid will show the path after this method call.
	 * 
	 * @param x The x coordinate of the starting point.
	 * @param y The y coordinate of the starting point.
	 * @return true if a path to the exit was found, false if no such path exists in the maze.
	 */
	public boolean findPath(int x, int y) {
		if (grid[x][y] == 'X') {
			return true;
		} 
	
		if ((grid[x+1][y] == 'X') || (grid[x-1][y] == 'X') || (grid[x][y+1] == 'X') || (grid[x][y-1] == 'X')) {
			grid[x][y] = '!';
		}
		
		ArrayList<int[]> emptySquares = new ArrayList<int[]>();
		
		try {
			if ((grid[x-1][y] == '.') || (grid[x-1][y] == 'X')) {
				emptySquares.add(new int[] {x-1, y});
			}
		} catch (IndexOutOfBoundsException e) {}
		
		try {
			if ((grid[x][y-1] == '.') || (grid[x][y-1] == 'X')) {
				emptySquares.add(new int[] {x, y-1});
			}
		} catch (IndexOutOfBoundsException e) {}
		
		try {
			if ((grid[x][y+1] == '.') || (grid[x][y+1] == 'X')) {
				emptySquares.add(new int[] {x, y+1});
			}
		} catch (IndexOutOfBoundsException e) {}
		
		try {
			if ((grid[x+1][y] == '.') || (grid[x+1][y] == 'X')) {
				emptySquares.add(new int[] {x+1, y});
			}
		} catch (IndexOutOfBoundsException e) {}
		
		grid[x][y] = '!';
		
		for (int[] a : emptySquares) {
			if (findPath(a[0], a[1])) {
				return true;
			}
		}
		
		grid[x][y] = '.';
		return false;
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
	
	public void draw(PApplet marker, float x, float y, float width, float height) {
		marker.noFill();
		
		float rectWidth = width/grid[0].length;
		float rectHeight = height/grid.length;
		
		for (int i = 0; i < grid.length; i++) {
			for (int j = 0; j < grid[0].length; j++) {
				
				if (grid[i][j]=='C') {
					marker.fill(143, 235, 146); //green
				} else if (grid[i][j]=='#') {
					marker.fill(245, 108, 108); //red
				} else if (grid[i][j]=='!') {
					marker.fill(143, 177, 235); //blue
				} else if (grid[i][j]=='X') {
					marker.fill(237, 233, 149); //yellow
				} else {
					marker.noFill();
				}
				
				float rectX = x + j*rectWidth;
				float rectY = y + i*rectHeight;				
				marker.rect(rectX, rectY, rectWidth, rectHeight);
				
			}
		}
	}
	
//	public int getNumRows() {
//		return grid.length;
//	}
//	
//	public int getNumCols() {
//		return grid[0].length;
//	}
//	
//	public char[][] getGrid() {
//		return grid;
//	}
	
	// Additional private recursive methods


}