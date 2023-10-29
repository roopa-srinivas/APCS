

import processing.core.PApplet;
import processing.core.PConstants;

/**
 * @author Andy Ding
 * 3/29/21
 */
public class PythagorasTree extends FractalDrawing {

	public PythagorasTree(int level, int length) {
		super(level,length);
	}


	public void draw(PApplet marker) {

		drawPythagorasTree(marker, 0, length, 300, 500, level);
	}

	public void drawPythagorasTree(PApplet surface, double angle, double length, double x, double y, int level) {

		if(level < 1) {
			double x2 = x + length * Math.cos(Math.PI/180 * angle);
			double y2 = y - length * Math.sin(Math.PI/180 * angle);
			surface.quad((float)(x - length * Math.sin(Math.PI/180 * angle)), (float)(y - length * Math.cos(Math.PI/180 * angle)), 
					(float)(x2 - length * Math.sin(Math.PI/180 * angle)), (float)(y2 - length * Math.cos(Math.PI/180 * angle)), 
					(float)x2, (float)y2, 
					(float)x, (float)y);
		}
		
		else {
			drawPythagorasTree(surface, angle + 45, length / 2 * Math.sqrt(2),
                    x + length * Math.cos(Math.PI / 180 * (angle + 90)),
                    y - length * Math.sin(Math.PI / 180 * (angle + 90)), 
                    level-1);
            drawPythagorasTree(surface, angle  - 45, length / 2 * Math.sqrt(2),
                    x + length * Math.cos(Math.PI / 180 * (angle + 90)) + length / 2 * Math.sqrt(2)* Math.cos(Math.PI/180 * (angle + 45)),
                    y - length * Math.sin(Math.PI / 180 * (angle + 90)) - length / 2 * Math.sqrt(2)* Math.sin(Math.PI/180 * (angle + 45)), 
                    level-1);
			drawPythagorasTree(surface, angle, length, x, y, 0);

		}

	}
}
