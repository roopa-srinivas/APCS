import processing.core.PApplet;

// Reminder: Do not edit this class - edit the IllusionDrawing class.
public class DrawingSurface extends PApplet {

	
	private IllusionDrawing illusion;
	
	public DrawingSurface() {
		
		illusion = new IllusionDrawing();
		
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
		background(255);
		
		illusion.draw(this);
	}
	
	
	
}










