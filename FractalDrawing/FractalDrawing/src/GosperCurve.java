//Author: Roopa Srinivas

import processing.core.PApplet;
import processing.core.PVector;

public class GosperCurve extends FractalDrawing {
	
	public GosperCurve(int level, double length)
	{
		super(level,length);
	}
	
    public void draw(PApplet marker) {
    	boolean isRightHand = true;
    	drawGosperCurve(marker, 500, 300, -Math.PI/2, super.getLevel(), length, isRightHand);
    }
    
    private PVector drawGosperCurve(PApplet marker, float x, float y, double angle, int level, double length, boolean isRightHand) {
    	if (level <= 1) {
			return baseCase(marker, (float)x, (float)y, (double)length, angle, isRightHand);
    	} else {
    		double xDistance =(Math.sqrt(3)/2)*length;
    		double yDistance = (2.5 * length);
    		double totalDistance = Math.sqrt(Math.pow(xDistance, 2) + Math.pow(yDistance, 2));
    		length = Math.pow(length, 2)/totalDistance;
    		if (isRightHand) {
    			PVector end = drawGosperCurve(marker, x, y, angle, level-1, length, isRightHand);
        		angle += Math.PI/3;
        		end = drawGosperCurve(marker, end.x, end.y, angle, level-1, length, !isRightHand);
        		angle += 2*Math.PI/3;
        		end = drawGosperCurve(marker, end.x, end.y, angle, level-1, length, !isRightHand);
        		angle -= Math.PI/3;
        		end = drawGosperCurve(marker, end.x, end.y, angle, level-1, length, isRightHand);
        		angle -= 2*Math.PI/3;
        		end = drawGosperCurve(marker, end.x, end.y, angle, level-1, length, isRightHand);
        		end = drawGosperCurve(marker, end.x, end.y, angle, level-1, length, isRightHand);    		
        		angle -= Math.PI/3;
        		end = drawGosperCurve(marker, end.x, end.y, angle, level-1, length, !isRightHand);    		
        		angle += Math.PI/3;
        		return end;
    		} else {
    			angle -= Math.PI/3;
    			PVector end = drawGosperCurve(marker, x, y, angle, level-1, length, !isRightHand);
    			angle += Math.PI/3;
        		end = drawGosperCurve(marker, end.x, end.y, angle, level-1, length, isRightHand);
        		end = drawGosperCurve(marker, end.x, end.y, angle, level-1, length, isRightHand);
    			angle += 2*Math.PI/3;
        		end = drawGosperCurve(marker, end.x, end.y, angle, level-1, length, isRightHand);
    			angle += Math.PI/3;
        		end = drawGosperCurve(marker, end.x, end.y, angle, level-1, length, !isRightHand);
    			angle -= 2*Math.PI/3;
        		end = drawGosperCurve(marker, end.x, end.y, angle, level-1, length, !isRightHand);
    			angle -= Math.PI/3;
        		end = drawGosperCurve(marker, end.x, end.y, angle, level-1, length, isRightHand);
        		return end;
    		}
    	}
    }
    
    private PVector baseCase(PApplet marker, float x, float y, double length, double angle, boolean isRightHand) {
    	float newX = 0;
    	float newY = 0;
    	
    	if (isRightHand) {
    		newX = (float) (x + Math.cos(angle)*length);
    		newY = (float) (y + Math.sin(angle)*length);
    		marker.line((float)x, (float)y, (float)newX, (float)newY);
    		x = newX;
    		y = newY;
    		angle += Math.PI/3;
    		newX = (float) (x + Math.cos(angle)*length);
    		newY = (float) (y + Math.sin(angle)*length);
    		marker.line((float)x, (float)y, (float)newX, (float)newY);
    		x = newX;
    		y = newY;
    		angle += 2*Math.PI/3;
    		newX = (float) (x + Math.cos(angle)*length);
    		newY = (float) (y + Math.sin(angle)*length);
    		marker.line((float)x, (float)y, (float)newX, (float)newY);
    		x = newX;
    		y = newY;
    		angle -= Math.PI/3;
    		newX = (float) (x + Math.cos(angle)*length);
    		newY = (float) (y + Math.sin(angle)*length);
    		marker.line((float)x, (float)y, (float)newX, (float)newY);
    		x = newX;
    		y = newY;
    		angle -= 2*Math.PI/3;
    		newX = (float) (x + Math.cos(angle)*(length)*2);
    		newY = (float) (y + Math.sin(angle)*(length)*2);
    		marker.line((float)x, (float)y, (float)newX, (float)newY);
    		x = newX;
    		y = newY;
    		angle -= Math.PI/3;
    		newX = (float) (x + Math.cos(angle)*length);
    		newY = (float) (y + Math.sin(angle)*length);
    		marker.line((float)x, (float)y, (float)newX, (float)newY);
    		angle += Math.PI/3;
    	} else {
    		angle -= Math.PI/3;
    		newX = (float) (x + Math.cos(angle)*length);
    		newY = (float) (y + Math.sin(angle)*length);
    		marker.line((float)x, (float)y, (float)newX, (float)newY);
    		x = newX;
    		y = newY;
    		angle += Math.PI/3;
    		newX = (float) (x + Math.cos(angle)*length*2);
    		newY = (float) (y + Math.sin(angle)*length*2);
    		marker.line((float)x, (float)y, (float)newX, (float)newY);
    		x = newX;
    		y = newY;
    		angle += 2*Math.PI/3;
    		newX = (float) (x + Math.cos(angle)*length);
    		newY = (float) (y + Math.sin(angle)*length);
    		marker.line((float)x, (float)y, (float)newX, (float)newY);
    		x = newX;
    		y = newY;
    		angle += Math.PI/3;
    		newX = (float) (x + Math.cos(angle)*length);
    		newY = (float) (y + Math.sin(angle)*length);
    		marker.line((float)x, (float)y, (float)newX, (float)newY);
    		x = newX;
    		y = newY;
    		angle -= 2*Math.PI/3;
    		newX = (float) (x + Math.cos(angle)*length);
    		newY = (float) (y + Math.sin(angle)*length);
    		marker.line((float)x, (float)y, (float)newX, (float)newY);
    		x = newX;
    		y = newY;
    		angle -= Math.PI/3;
    		newX = (float) (x + Math.cos(angle)*length);
    		newY = (float) (y + Math.sin(angle)*length);
    		marker.line((float)x, (float)y, (float)newX, (float)newY);
    	}
    			
		return new PVector(newX, newY);
	}
	
}
