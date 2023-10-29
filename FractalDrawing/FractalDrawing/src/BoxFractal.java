//Author: Daniel Huber
import processing.core.PApplet;

public class BoxFractal extends FractalDrawing {

	public BoxFractal(int level, float length)
	{
		super(level,length);
	}
	
    public void draw(PApplet marker) {
		marker.noFill();
		drawBoxFractal(marker, (float) length, (float) 200, (float) 200, level);
    }
    
	private void drawBoxFractal(PApplet marker, float length, float x, float y, int level) {
    	if (level < 1) {
    		marker.square(x, y, length);
    	} else {
    		length = length/3;
    		//lower left
    		drawBoxFractal(marker, length, x, y, level-1);
    		//lower right
    		drawBoxFractal(marker, length, x+2*length, y, level-1);
    		//middle
    		drawBoxFractal(marker, length, x+length, y+length, level-1);
    		//upper right
    		drawBoxFractal(marker, length, x+2*length, y+2*length, level-1);
    		//upper left
    		drawBoxFractal(marker, length, x, y+2*length, level-1);
    	}
	}

}
