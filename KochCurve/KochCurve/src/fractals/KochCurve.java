package fractals;
import processing.core.PApplet;


/**
  @(#)KochCurve.java


  @author
  @version
*/
public class KochCurve {

	private int level, length;
	private double curveAngle, x, y;

    public KochCurve(int level, int length) {
    	this(level, length, 0, 0, 0);
    }
    
    public KochCurve(int level, int length, double x, double y) {
    	this(level, length, 0, x, y);
    }
    
    public KochCurve(int level, int length, double curveAngle, double x, double y) {
    	this.level = level;
    	this.length = length;
    	this.curveAngle = curveAngle;
    	this.x = x;
    	this.y = y;
    }
    
    public void draw(PApplet marker) {
    	drawKochCurve(marker, this.level, this.length, this.curveAngle, this.x, this.y);
    }

    private void drawKochCurve(PApplet marker, int level, double length, double angle, double x, double y) {
    	if (level < 1) {
//    		Draw a straight line of the current length
    		float newX = (float) (x + Math.cos(angle)*length);
    		float newY = (float) (y + Math.sin(angle)*length);
    		marker.line((float)x, (float)y, (float)newX, (float)newY);
    	} else {
//    		Draw a k-1 level Koch curve of 1/3 the current length
    		length /= 3;
    		drawKochCurve(marker, level-1, length, angle, x, y);
//    		Starting where the previous left off, draw a k-1 level Koch curve of 1/3 the
//    		current length, at an angle of 60 degrees with respect to the current angle
    		float newX = (float) (x + Math.cos(angle)*length);
    		float newY = (float) (y + Math.sin(angle)*length);
    		angle -= Math.PI/3;
    		drawKochCurve(marker, level-1, length, angle, newX, newY);
//    		Starting where the previous left off, draw a k-1 level Koch curve of 1/3 the
//    		current length, at an angle of -60 degrees with respect to the current angle
    		newX = (float) (newX + Math.cos(angle)*length);
    		newY = (float) (newY + Math.sin(angle)*length);
    		angle += 2*Math.PI/3;
    		drawKochCurve(marker, level-1, length, angle, newX, newY);
//    		Starting where the previous left off, draw a k-1 level Koch curve of 1/3 the
//    		current length
    		newX = (float) (newX + Math.cos(angle)*length);
    		newY = (float) (newY + Math.sin(angle)*length);
    		angle -= Math.PI/3;
    		drawKochCurve(marker, level-1, length, angle, newX, newY);
    	}
    }

}
