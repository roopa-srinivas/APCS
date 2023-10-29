package RoopaS4242.shapes;
import processing.core.PApplet;
/**
 * Draws a circle at specified x and y values
 * @author roopa
 * 
 */
public class Circle extends Shape{
	
	private static final double PI = 3.14;
	private double radius;
	/**
	 * Draws a circle with x, y, and radius values as 0
	 */
	public Circle() {
		super(0,0);
		this.radius = 0;
	}
	/**
	 * Draws a Circle with specified x, y, and radius values
	 * @param x X-value of rectangle the circle is in
	 * @param y Y-value of rectangle the circle is in
	 * @param radius Radius of circle
	 */
	public Circle(double x, double y, double radius) {
		super(x, y);
		this.radius = radius;
	}
	/**
	 * Draws a circle at specified coordinates
	 * @param drawer The PApplet drawing surface that is used to draw the circle
	 * @pre The Circle will be drawn with attributes previously set on the given PApplet.
	 */
	public void draw(PApplet drawer) {
		drawer.noFill();
		drawer.strokeWeight(3);
		drawer.stroke(0);
		drawer.circle((float)x, (float)y, (float)radius);
	}
	/**
	 * Returns the circumference of the circle
	 * @return Circumference of the circle
	 */
	public double getPerimeter() {
		return 2*radius*PI;

	}
	/**
	 * Returns the area of the circle
	 * @return Area of the circle
	 */
	public double getArea() {
		return PI*Math.pow(radius, 2);
	}
	/**
	 * Moves the circle to specified x and y coordinates
	 * @param x X-coordinate of top left corner of rectangle
	 * @param y Y-coordinate of top left corner of rectangle
	 */
	public void move(int x, int y) {
		this.x = x;
		this.y = y;
	}
	/**
	 * changes size of rectangle
	 * @param size number to add to x, y, radius of circle
	 */
	public void scale(double size) {
		this.radius += size;
		this.x += size;
		this.y += size;
	}
	@Override
	public Rectangle getBoundingRectangle() {
		// TODO Auto-generated method stub
		return null;
	}
	@Override
	public boolean isPointInside(double x, double y) {
		if (((x-radius) - x) *((x-radius -x) + (y-radius) - y) * ((y-radius)-y) <= radius*radius){
			return true;
		}
		return false;
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
