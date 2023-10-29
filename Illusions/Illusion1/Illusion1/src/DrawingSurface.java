import javax.swing.JFrame;

import RoopaS4242.shapes.Circle;
import RoopaS4242.shapes.Rectangle;
import processing.core.PApplet;

/**
 * Drawing surface to draw circles and rectangle
 * @author roopa
 *
 */
public class DrawingSurface extends PApplet {

	private Rectangle r;
	private Circle c1, c2, c3, c4, c5, c6, c7, c8, c9, c10, c11, c12, c13, c14, c15, c16;
	private double centerX, centerY;
	/**
	 * initializes the rectangle and 16 circles with different radii but same center
	 */
	public DrawingSurface() {
		centerX = 300;
		centerY = 225;
		r = new Rectangle(centerX-145, centerY-145, 290, 290);
		c1 = new Circle(centerX, centerY, 50);
		c2 = new Circle(centerX, centerY, 70);
		c3 = new Circle(centerX, centerY, 90);
		c4 = new Circle(centerX, centerY, 110);
		c5 = new Circle(centerX, centerY, 130);
		c6 = new Circle(centerX, centerY, 150);
		c7 = new Circle(centerX, centerY, 170);
		c8 = new Circle(centerX, centerY, 190);
		c9 = new Circle(centerX, centerY, 210);
		c10 = new Circle(centerX, centerY, 230);
		c11 = new Circle(centerX, centerY, 250);
		c12 = new Circle(centerX, centerY, 270);
		c13 = new Circle(centerX, centerY, 290);
		c14 = new Circle(centerX, centerY, 310);
		c15 = new Circle(centerX, centerY, 330);
		c16 = new Circle(centerX, centerY, 350);
	}
	/**
	 * Sets up the drawing surface to make the background white and the pen color black.
	 */
	public void setup() {
		background(255);
		stroke(0);
	}
	/**
	 * draws the circles and rectangle
	 */
	public void draw() { 
		c1.draw(this);
		c2.draw(this);
		c3.draw(this);
		c4.draw(this);
		c5.draw(this);
		c6.draw(this);
		c7.draw(this);
		c8.draw(this);
		c9.draw(this);
		c10.draw(this);
		c11.draw(this);
		c12.draw(this);
		c13.draw(this);
		c14.draw(this);
		c15.draw(this);
		c16.draw(this);
		
		r.draw(this);
	}
	
	
	
}










