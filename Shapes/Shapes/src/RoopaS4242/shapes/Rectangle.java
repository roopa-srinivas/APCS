package RoopaS4242.shapes;

import processing.core.PApplet;
/**
 * Draws a rectangle at specified x and y values
 * @author roopa
 *
 */
public class Rectangle extends Shape{
	
	private double height, width;
	/**
	 * Draws a rectangle with x, y, width, and height values as 0
	 */
	public Rectangle() {
		super(0, 0);
		this.height = 0;
		this.width = 0;
	}
	/**
	 * Draws a Rectangle with specified dimensions
	 * @param x X-coordinate of top left corner of rectangle
	 * @param y Y-coordinate of top left corner of rectangle
	 * @param width Width of the rectangle
	 * @param height Height of the rectangle
	 */
	public Rectangle(double x, double y, double width, double height) {
		super(x, y);
		this.width = width;
		this.height = height;
	}
	/**
	 * Draws a Rectangle at specified coordinates
	 * @param drawer The PApplet drawing surface that is used to draw the rectangle
	 * @pre The Rectangle will be drawn with attributes previously set on the given PApplet.
	 */
	public void draw(PApplet drawer) {
		drawer.strokeWeight(3);
		drawer.stroke(0);
		drawer.rect((float)x, (float)y, (float)width, (float)height);
	}
	/**
	 * Returns the perimeter of the Rectangle
	 * @return Perimeter of rectangle
	 */
	public double getPerimeter() {
		return (2*Math.abs(width)) + (2*Math.abs(height));
	}
	/**
	 * Returns area of rectangle
	 * @return area of rectangle
	 */
	public double getArea() {
		return Math.abs(width)*Math.abs(height);
	}
	/**
	 * Moves the rectangle to specified x and y coordinates
	 * @param x X-coordinate of top left corner of rectangle
	 * @param y Y-coordinate of top left corner of rectangle
	 */
	public void move(int x, int y) {
		this.x = x;
		this.y = y;
	}
	/**
	 * changes size of rectangle
	 * @param size number to add to x, y, width and height of rectangle
	 */
	public void scale(double size) {
		this.width += size;
		this.height += size;
		this.x += size;
		this.y += size;
	}
	@Override
	public Rectangle getBoundingRectangle() {
		return this;
	}
	@Override
	public boolean isPointInside(double x, double y) {
		return (x >= this.x && y >= this.y && x <= this.x +width && y <= this.y + height);
	}
	@Override
	public double getCenterX() {
		// TODO Auto-generated method stub
		return 0;
	}
	@Override
	public double getCenterY() {
		// TODO Auto-generated method stub
		return 0;
	}
}
