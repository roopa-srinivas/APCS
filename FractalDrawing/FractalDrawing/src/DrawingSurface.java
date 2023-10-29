



import java.awt.event.KeyEvent;
import java.awt.geom.Point2D;

import processing.core.PApplet;
import processing.event.MouseEvent;


public class DrawingSurface extends PApplet {

	private FractalDrawing curve;
	
	public DrawingSurface(FractalDrawing curve) {
		this.curve = curve;
		
	}
	
	// The statements in the setup() function 
	// execute once when the program begins
	public void setup() {
		
	}
	
	// The statements in draw() are executed until the 
	// program is stopped. Each statement is executed in 
	// sequence and after the last line is read, the first 
	// line is executed again.
	public void draw() { 
		background(255);   // Clear the screen with a white background
		
		textSize(12);
		fill(0);
		text("Use the mouse wheel to change length, use UP/DOWN keys to change level.",20,15);
		
		stroke(0);
		curve.draw(this);		
	}
	
	
	public void mouseWheel(MouseEvent event) {
		  int num = event.getCount();
		  double length = curve.getLength() - num*10;
		  curve.setLength(length);
	}
	
	public void keyPressed() {
		if (keyCode == KeyEvent.VK_UP) {
			curve.setLevel(curve.getLevel()+1);
		} else if (keyCode == KeyEvent.VK_DOWN) {
			int level = Math.max(curve.getLevel()-1, 1);
			curve.setLevel(level);
		}
	}
	
	
}










