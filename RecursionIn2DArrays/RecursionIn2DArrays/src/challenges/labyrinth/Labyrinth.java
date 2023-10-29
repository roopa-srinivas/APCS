package challenges.labyrinth;

import java.awt.Point;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.Scanner;

import challenges.GridTemplate;
import processing.core.PApplet;

import java.util.ArrayList;

/*

	Coded by: Roopa Srinivas
	Modified on: 05/02/2021

*/

public class Labyrinth extends GridTemplate {
	
	ArrayList<Point> path = null;
	
	// Constructs an empty grid
	public Labyrinth() {
		super();
	}

	// Constructs the grid defined in the file specified
	public Labyrinth(String filename) {
		super(20,20,filename);
	}

	/**
	* Solves the labyrinth in the smallest number of moves.
	* 
	* @param x The x coordinate of the starting point.
	* @param y The y coordinate of the starting point.
	* @return An ArrayList containing the coordinates of all locations on the shortest path to the exit, where the first 
	* element is the location of the starting point and the last element is the location of the exit, or null if no path can be found.
	*/
	public ArrayList<Point> findPath(int x, int y) {
		path = findPath(x, y, false);
		return path;
	}
	
	
	
	
	/**
	 * @param x The current x location of the path-finder
	 * @param y The current y location of the path-finder
	 * @param hasCloak Whether the path-finder has picked up the cloak yet or not
	 * @return An ArrayList of Point objects describing the route that the path-finder has taken.
	 */
	private ArrayList<Point> findPath(int x, int y, boolean hasCloak) {
		ArrayList<Point> pathPoint = new ArrayList<Point>();
		char withCloak = '+';
		char noCloak = '-';
		//breadcrumb character while holding cloak = '+'
		//breadcrumb character while NOT holding cloak = '-'
		
		// BASE CASES (bad stuff)
		// Are you out of the grid bounds?
			// Return a null ArrayList
		if (x < 0 || y < 0 || x >= grid.length || y >= grid[0].length) {
			return null;
		}
		// Are you in a wall?
			// Return a null ArrayList
		if (grid[x][y] == '#') {
			return null;
		}
		// Are you somewhere you have been before, while holding the cloak?
			// Return a null ArrayList
		if (grid[x][y] == withCloak) {
			return null;
		}
		// Are you somewhere you have been before, while not holding the cloak, and you don't current have the cloak?
			// Return a null ArrayList
		if (grid[x][y] == noCloak && hasCloak == false) {
			return null;
		}
		// Are you at a monster, and you don't current have the cloak?
			// Return a null ArrayList
		if (grid[x][y] == 'A' && hasCloak == false) {
			return null;
		}
		
		// BASE CASES (good stuff)
		// Are you at the exit?
			// Create a new ArrayList of Points. 
			// Add this location to the list, then return it.
		if (grid[x][y] == 'X') {
			pathPoint.add(new Point(x,y));
			return pathPoint;
		}
		
		
		// RECURSIVE CASE
		// Save the character at grid location x,y in a local variable for later use
		char originalChar = grid[x][y];
		// If this is the spot with the cloak, switch the hasCloak boolean to true
		if (grid[x][y] == '@') {
			hasCloak = true;
		}
		// Add a "breadcrumb" character to the grid at x,y. Use 2 different breadcrumb characters depending on whether hasCloak is true or not.
		if (hasCloak) {
			grid[x][y] = withCloak;
		} else {
			grid[x][y] = noCloak;
		}
		// Recursively call findPath() 4 times - once in each of the 4 fundamental directions (one space up, down, left, and right). Save the ArrayList that is returned by each.
		ArrayList<Point> up = findPath(x-1, y, hasCloak);
		ArrayList<Point> down = findPath(x+1, y, hasCloak);
		ArrayList<Point> left = findPath(x, y-1, hasCloak);
		ArrayList<Point> right = findPath(x, y+1, hasCloak);
		// Of the 4 ArrayLists that are returned, find the ArrayList that is not null and has the smallest size.
		ArrayList<Point> smallestPath = new ArrayList<Point>();
		int smallestLength = 0;
		if (up != null) {
			smallestLength = up.size();
			smallestPath = up;
		} 
		if (down != null) {
			if (down.size() < smallestLength) {
				smallestLength = down.size();
				smallestPath = down;
			}
		}
		if (left != null) {
			if (left.size() < smallestLength) {
				smallestLength = left.size();
				smallestPath = left;
			}
		}
		if (right != null) {
			if (right.size() < smallestLength) {
				smallestLength = right.size();
				smallestPath = right;
			}
		}
		
		// Put the original saved character back into the grid at x,y (to remove the breadcrumb and prevent any permanent modification to the grid)
		grid[x][y] = originalChar;
		// If all 4 of the ArrayLists returned by the recursive calls are null:
			// Return a null ArrayList
		if (up == null && down == null && left == null && right == null) {
			return null;
		}
		// If you have found the smallest non-null ArrayList:
			// Add this location to the beginning of the list, then return it. 
		if (smallestPath.size() > 0) {
			pathPoint.add(0, new Point(x,y));
		}

		return pathPoint;
		
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
				
				if (grid[i][j] == 'C') {
					marker.fill(143, 235, 146); //green
				} else if (grid[i][j] == '#') {
					marker.fill(245, 108, 108); //red
				} else if (grid[i][j] == 'A') {
					marker.fill(247, 189, 106); //orange
				} else if (grid[i][j] == '@') {
					marker.fill(245, 103, 224); //pink
				} else if (grid[i][j] == 'X') {
					marker.fill(237, 233, 149); //yellow
				} else {
					marker.noFill();
				}
				
				if (path != null && pathContains(i, j)) {
					marker.fill(143, 177, 235); //blue
				}
				float rectX = x + j*rectWidth;
				float rectY = y + i*rectHeight;				
				marker.rect(rectX, rectY, rectWidth, rectHeight);
				
			}
		}
	}
	
	private boolean pathContains(int i, int j) {
		if (path == null) {return false;}
		for (Point a : path) {
			if (a.getX() == i && a.getY() == j) {
				return true;
			}
		}
		return false;
	}
	




}