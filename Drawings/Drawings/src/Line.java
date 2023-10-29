import processing.core.PApplet;

public class Line {
	
	public double x1, x2, y1, y2, intersectionx, intersectiony;
	boolean doesIntersect;
	
	public Line(double x1, double y1, double x2, double y2) {
		this.x1 = x1;
		this.x2 = x2;
		this.y1 = y1;
		this.y2 = y2;
		this.intersectionx = 0;
		this.intersectiony = 0;
		doesIntersect = false;
		}
	
	public void setPoint2(double x2, double y2) {
		this.x2 = x2;
		this.y2 = y2;
	}
	
	public void draw(PApplet drawer) {
		drawer.line((float)x1, (float)y1, (float)x2, (float)y2);
	}
	
	public double getIntersectionX(Line other) {
		float x3 = (float) other.x1;
		float x4 = (float) other.x2;
		float y3 = (float) other.y1;
		float y4 = (float) other.y2;
		intersectionx = (((x1*y2 - y1*x2)*(x3 - x4)) - ((x1 - x2)*(x3*y4 - y3*x4))) / (((x1 - x2)*(y3 - y4)) - ((y1 - y2)*(x3 - x4)));
		return intersectionx;
	}
	
	public double getIntersectionY(Line other) {
		float x3 = (float) other.x1;
		float x4 = (float) other.x2;
		float y3 = (float) other.y1;
		float y4 = (float) other.y2;
		intersectiony = (((x1*y2 - y1*x2)*(y3 - y4)) - ((y1 - y2)*(x3*y4 - y3*x4))) / (((x1 - x2)*(y3 - y4)) - ((y1 - y2)*(x3 - x4)));
		return intersectiony;
	}
	
	public boolean intersects(Line other) {
		double l1minx = Math.min(this.x1,  this.x2);
		double l1maxx = Math.max(this.x1,  this.x2);
		double l1miny = Math.max(this.y1,  this.y2);
		double l1maxy = Math.min(this.y1,  this.y2);
		double l2minx = Math.min(other.x1,  other.x2);
		double l2maxx = Math.max(other.x1,  other.x2);
		double l2miny = Math.max(other.y1,  other.y2);
		double l2maxy = Math.min(other.y1,  other.y2);
		
		
		if ((intersectionx <= l1maxx) && (intersectionx >= l1minx) && (intersectiony <= l1miny) && (intersectiony >= l1maxy)) {
			if (((intersectionx <= l2maxx) && (intersectionx >= l2minx) && (intersectiony <= l2miny) && (intersectiony >= l2maxy))) {
				doesIntersect = true;
			} 
		} else {
			doesIntersect = false;
		}
		return doesIntersect;
	}
	
	public boolean getDoesIntersect() {
		return doesIntersect;
	}

}
