


import java.awt.Point;
import challenges.labyrinth.Labyrinth;
import challenges.maze.Maze;
import challenges.paintcan.Image;
import processing.core.PApplet;



public class DrawingSurface extends PApplet {

	// When you progress to a new prompt, modify this field.
	private Image paint;
	private Maze maze;
	private Labyrinth labyrinth;
	
	
	public DrawingSurface() {
		paint = new Image("testfiles/paintcan/digital.txt");
		maze = new Maze("testfiles/maze/test3.txt");
		labyrinth = new Labyrinth("testfiles/labyrinth/test3.txt");
	}
	

	public void draw() { 
		background(255);   
		fill(0);
		textAlign(LEFT);
		textSize(12);
		
//		if (paint != null) {
//			paint.draw(this, 0, 0, height, height);
//		}
//		if (maze != null) {
//			maze.draw(this, 0, 0, height, height);
//		}
		if (labyrinth != null) {
			labyrinth.draw(this, 0, 0, height, height);
		}
	}
	
	
	public void mousePressed() {
		if (mouseButton == LEFT) {
			Point click = new Point(mouseX,mouseY);
			float dimension = height;
			
//			if (paint != null) {
//				Point cellCoord = paint.clickToIndex(click,0,0,dimension,dimension);
//				if (cellCoord != null) {
//					paint.paintCanFill(cellCoord.x, cellCoord.y, '*', ' ');   // When you progress to a new prompt, modify this method call.
//				}
//			}
//			
//			if (maze != null) {
//				Point cellCoord = maze.clickToIndex(click,0,0,dimension,dimension);
//				if (cellCoord != null) {
//					if (maze.findPath(cellCoord.y, cellCoord.x)) {
//						System.out.println("true");
//					} else {
//						System.out.println("false");
//					}
//				}
//			}
			
			if (labyrinth != null) {
				Point cellCoord = labyrinth.clickToIndex(click,0,0,dimension,dimension);
				if (cellCoord != null) {
					if (labyrinth.findPath(cellCoord.y, cellCoord.x) != null) {
						System.out.println("true");
					} else {
						System.out.println("false");
					}
				}
			}
		} 
	}
}










