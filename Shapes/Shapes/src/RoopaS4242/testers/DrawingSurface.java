package RoopaS4242.testers;
import processing.core.PApplet;
import RoopaS4242.shapes.Rectangle;
import RoopaS4242.shapes.RegularPolygon;

import java.awt.event.KeyEvent;

import RoopaS4242.shapes.Circle;

public class DrawingSurface extends PApplet{
	
	private double rX, rY, cX, cY;
	private Rectangle r;
	private Circle c;
	private RegularPolygon poly;
	/**
	 * Initializes the new Rectangle and Circle objects
	 */
	public DrawingSurface() {
		r = new Rectangle(0, 80, 400, 160);
		c = new Circle(40, 40, 30);
		poly = new RegularPolygon(100, 100, 8, 100);
	}
	/**
	 * Draws all the aspects of the program
	 * @param drawer The PApplet drawing surface that is used to draw everything
	 * @pre The drawings will be drawn with attributes previously set on the given PApplet.
	 */
	public void draw() {
		background(255);
		rX = r.getX();
		rY = r.getY();
		cX = c.getX();
		cY = c.getY();
		if (r != null ) {
			stroke(0);
			fill(255);
			//r.draw(this);
			
			fill(0);
			textSize(15);
			textAlign(LEFT);
			
			double perimeter = r.getPerimeter();
			double area = r.getArea();
		}
		
		if (c!= null) {
			stroke(0);
			fill(255);
			//c.draw(this);
			
			fill(0);
			textSize(15);
			textAlign(LEFT);
			
			double circumference = c.getPerimeter();
			double area = c.getArea();
		}
		

		poly.draw(this);
	}
	/**
	 * Moves the rectangle to wherever the mouse is pressed
	 */
	public void mousePressed() {
		r.move(mouseX, mouseY);
	}
	/**
	 * Moves circle when the arrow keys are pressed
	 * Scales rectangle and circle by adding 1 to each dimension
	 */
	public void keyPressed() {
		if (keyCode == KeyEvent.VK_RIGHT) {
			cX+=10;
			c.move((int)cX, (int)cY);
		} else if (keyCode == KeyEvent.VK_LEFT) {
			cX-=10;
			c.move((int)cX, (int)cY);
		} else if (keyCode == KeyEvent.VK_UP) {
			cY-=10;
			c.move((int)cX, (int)cY);
		} else if (keyCode == KeyEvent.VK_DOWN) {
			cY+=10;
			c.move((int)cX, (int)cY);
		} else if (keyCode == KeyEvent.VK_1) {
			r.scale(1);
		} else if (keyCode == KeyEvent.VK_2) {
			r.scale(-1);
		} else if (keyCode == KeyEvent.VK_W) {
			c.scale(1);
		} else if (keyCode == KeyEvent.VK_S) {
			c.scale(-1);
		}
	}
}
