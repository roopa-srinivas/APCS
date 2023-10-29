package RoopaS4242.shapes;

import java.awt.Color;

import processing.core.PApplet;
/**
 * superclass for all the shapes
 * @author roopa
 *
 */
public abstract class Shape {

	//FIELDS
	
	protected double x, y;
	
	//CONSTRUCTORS
	/**
	 * basic constructor that the other shapes go off of
	 * @param x X-coordinate of the shape
	 * @param y Y-Coordinate of the shape
	 */
	public Shape(double x, double y) {
		this.x = x;
		this.y = y;
	}
	
	//METHODS
	/**
	 * moves the shape to the specified x and y coordinates
	 * @param x new x-coordinate of the shape
	 * @param y new y-coordinate of the shape
	 */
	public void move(double x, double y) {
		this.x += x;
		this.y += y;
	}
	/**
	 * gets the Area of the shape
	 * @return area
	 */
	public abstract double getArea();
	/**
	 * gets the Perimeter of the shape
	 * @return perimieter
	 */
	public abstract double getPerimeter();
	/**
	 * gets the x-coordinate of the center of the shape
	 * @return x x-coordinate of the center
	 */
	public abstract double getCenterX();
	/**
	 * gets the y-coordinate of the center of the shape
	 * @return y y-coordinate of the center
	 */
	public abstract double getCenterY();
	/**
	 * gets the Bounding rectangle that the shapes are inside of
	 * @return the rectangle
	 */
	public abstract Rectangle getBoundingRectangle();
	/**
	 * sets the x value to the value passed in
	 * @param x X-value of the starting point
	 */
	public void setX(double x) {
		this.x = x;
	}
	/**
	 * sets the y-value to the value passed in
	 * @param y Y-value of the starting point
	 */
	public void setY(double y) {
		this.y = y;
	}
	/**
	 * gets the x-value of the shape
	 * @return x x-coordinate of the shape
	 */
	public double getX() {
		return this.x;
	}
	/**
	 * gets the y-value of the shape
	 * @return y y-coordinate of the shape
	 */
	public double getY() {
		return this.y;
	}
	/**
	 * basic draw method
	 * @param drawer the thing used to draw everything
	 */
	public abstract void draw(PApplet drawer);
	/**
	 * checks if the passed in point is inside the shape
	 * @param x x-coordinate of the point
	 * @param y y-coordinate of the point
	 * @return whether the point is inside the shape
	 */
	public abstract boolean isPointInside(double x, double y);
	
	
	
	
}
