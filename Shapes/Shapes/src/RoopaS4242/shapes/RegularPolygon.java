package RoopaS4242.shapes;

import processing.core.PApplet;

public class RegularPolygon extends Shape {
	
	private double	 numSides;
	private double sideLength;
	private double cradius, iradius;
	private double vertexAngle, area, perimeter;
	
	public RegularPolygon() {
		super(0,0);
		this.numSides = 3;
		this.sideLength = 100;
	}
	
	public RegularPolygon(int numSides, double sideLength) {
		super(0,0);
		this.numSides = numSides;
		this.sideLength = sideLength;
	}
	
	public RegularPolygon(double x, double y, int numSides, double sideLength) {
		super(x,y);
		this.numSides = numSides;
		this.sideLength = sideLength;
	}
	
	/**
	 * calculates the radius of inscribed circle of polygon
	 * @return inner circle of polygon
	 */
	
	public double calcr() {
		iradius = (((sideLength/2)*(1/(Math.tan(Math.PI/numSides)))));
		return iradius;
	}
	
	/**
	 * calculates the radius of circumscribed circle of polygon
	 * @return outer circle of polygon
	 */
	
	public double calcR() {
		cradius = ((sideLength/2))*(1/(Math.sin(Math.PI/numSides)));
		return cradius;
	}
	
	/**
	 * calculates the angle of each vertex
	 * @return angle of each vertex
	 */
	
	public double calcVertexAngle() {
		this.vertexAngle = ((numSides-2)/numSides)*180;
		return vertexAngle;
	}
	
	@Override
	public double getArea() {
		area = ((numSides/2))*(Math.pow(cradius, 2) * (Math.sin((2*Math.PI)/numSides)));
		return area;
	}
	
	@Override
	public double getPerimeter() {
		perimeter = numSides*sideLength;
		return perimeter;
	}
	
	/**
	 * gets number of sides of polygon
	 * @return number of sides of polygon
	 */
	
	public double getNumSides() {
		return numSides;
	}
	
	/**
	 * gets the side length of polygon
	 * @return side length of polygon
	 */
	public double getSideLength() {
		return sideLength;
	}
	

	@Override
	public void draw(PApplet drawer) {
		drawer.noFill();
		drawer.beginShape();
		 for (int i = 0; i < numSides; i++) {
		    double x = this.x + calcr() * Math.cos(2*Math.PI * i / numSides);
		    double y = this.y + calcr() * Math.sin(2*Math.PI * i / numSides);
		    drawer.vertex((float) x, (float) y);
		  }
		  drawer.endShape(drawer.CLOSE);
	}
	
	void polygon(float x, float y, float radius, int npoints) {
		  
		}
	
	/**
	 * draws the inner and outer circles of polygon
	 * @param drawer
	 */
	
	public void drawBoundingCircles (PApplet drawer) {
		drawer.noFill();
		drawer.circle((float) x, (float) y, (float) iradius);
		drawer.circle((float) x, (float) y, (float) cradius);
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

}
