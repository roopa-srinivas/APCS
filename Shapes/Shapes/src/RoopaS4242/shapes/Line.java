package RoopaS4242.shapes;
import java.awt.Color;

import processing.core.PApplet;

/**
 * Draws a line at specified x and y values
 * @author roopa
 *
 */
public class Line extends Shape{
	
	public double x2, y2, length, angle, strokeWidth, intersectionx, intersectiony;
	public int r, g, b;
	/**
	 * Draws a Line starting and ending at specified points
	 * @param x1 X-coordinate of the starting point of the line
	 * @param y1 Y-coordinate of the starting point of the line
	 * @param x2 X-coordinate of the ending point of the line
	 * @param y2 Y-coordinate of the ending point of the line
	 * @param r sets red color of the stroke
	 * @param g sets green color of the stroke
	 * @param b sets blue color of the stroke
	 * @param strokeWidth sets width of the stroke
	 */
	public Line(double x, double y, double x2, double y2, int r, int g, int b, double strokeWidth) {
		super(x,y);
		this.x2 = x2;
		this.y2 = y2;
		this.intersectionx = 0;
		this.intersectiony = 0;
		this.r = r;
		this.g = g;
		this.b = b;
		this.strokeWidth = strokeWidth;
	}
	/**
	 * draws line given starting coordinates and length and angle
	 * @param x1 starting x-coordinate
	 * @param y1 starting y-coordiante
	 * @param length length of line
	 * @param angle angle of line
	 * @param r sets red color of the stroke
	 * @param g sets green color of the stroke
	 * @param b sets blue color of the stroke
	 * @param strokeWidth sets width of the stroke
	 * @param placeHolder just there to make two constructors different
	 */
	public Line(double x, double y, double length, double angle, int r, int g, int b, double strokeWidth, boolean placeHolder) {
		super(x,y);
		this.length = length;
		this.angle = angle;
		this.r = r;
		this.g = g;
		this.b = b;
		this.strokeWidth = strokeWidth;
		this.x2 = (Math.cos(angle)*length)+this.x;//cosine of angle
		this.y2 = (Math.sin(angle)*length)+this.y;//sine of angle
	}
	
	/**
	 * Draws a Line at specified coordinates
	 * @param drawer The PApplet drawing surface that is used to draw the line
	 * @pre The Line will be drawn with attributes previously set on the given PApplet.
	 */
	public void draw(PApplet drawer) {
		drawer.stroke(r, g, b);
		drawer.strokeWeight((float) strokeWidth);
		drawer.line((float)x, (float)y, (float)x2, (float)y2);
	}
	/**
	 * Returns x-coordinate point of intersection of the two lines
	 * @param other The other line
	 * @return intersectionx X-Coordinate point of the intersection point
	 */
	public double getIntersectionX(Line other) {
		float x3 = (float) other.x;
		float x4 = (float) other.x2;
		float y3 = (float) other.y;
		float y4 = (float) other.y2;
		intersectionx = (((x*y2 - y*x2)*(x3 - x4)) - ((x - x2)*(x3*y4 - y3*x4))) / (((x - x2)*(y3 - y4)) - ((y - y2)*(x3 - x4)));
		return intersectionx;
	}
	/**
	 * Returns y-coordinate point of intersection of the two lines
	 * @param other The other line
	 * @return intersectiony Y-Coordinate point of the intersection point
	 */
	public double getIntersectionY(Line other) {
		float x3 = (float) other.x;
		float x4 = (float) other.x2;
		float y3 = (float) other.y;
		float y4 = (float) other.y2;
		intersectiony = (((x*y2 - y*x2)*(y3 - y4)) - ((y - y2)*(x3*y4 - y3*x4))) / (((x - x2)*(y3 - y4)) - ((y - y2)*(x3 - x4)));
		return intersectiony;
	}
	/**
	 * Returns whether the two lines intersect or not
	 * @param other The other line
	 * @return doesIntersect Whether the lines intersect or not
	 */
	public boolean intersects(Line other) {
		double l1minx = Math.min(this.x,  this.x2);
		double l1maxx = Math.max(this.x,  this.x2);
		double l1miny = Math.max(this.y,  this.y2);
		double l1maxy = Math.min(this.y,  this.y2);
		double l2minx = Math.min(other.x,  other.x2);
		double l2maxx = Math.max(other.x,  other.x2);
		double l2miny = Math.max(other.y,  other.y2);
		double l2maxy = Math.min(other.y,  other.y2);
		boolean doesIntersect = false;
		
		if ((intersectionx <= l1maxx) && (intersectionx >= l1minx) && (intersectiony <= l1miny) && (intersectiony >= l1maxy)) {
			if (((intersectionx <= l2maxx) && (intersectionx >= l2minx) && (intersectiony <= l2miny) && (intersectiony >= l2maxy))) {
				doesIntersect = true;
			} 
		} else {
			doesIntersect = false;
		}
		return doesIntersect;
	}
	@Override
	public double getArea() {
		// TODO Auto-generated method stub
		return 0;
	}
	@Override
	public double getPerimeter() {
		// TODO Auto-generated method stub
		return 0;
	}
	@Override
	public Rectangle getBoundingRectangle() {
		// TODO Auto-generated method stub
		return null;
	}
	@Override
	public boolean isPointInside(double x, double y) {
		// TODO Auto-generated method stub
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
	
	public void move(int x, int y) {
		super.move(x, y);
		x2 += x;
		y2 += y;
	}

}
