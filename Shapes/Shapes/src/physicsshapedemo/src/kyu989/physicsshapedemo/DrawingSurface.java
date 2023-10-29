package physicsshapedemo.src.kyu989.physicsshapedemo;
import RoopaS4242.shapes.Rectangle;
import processing.core.PApplet;


public class DrawingSurface extends PApplet {
	private PhysicsShape shape;
	public DrawingSurface() {
		shape = new PhysicsShape(new Rectangle(100,100,50,50));
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
		shape.draw(this);
		shape.act();
	}
	
	public void mouseDragged()
	{
		if (shape.isPointInside(mouseX, mouseY)) 
		{
			shape.accelerate(mouseX-pmouseX/10.0, (mouseY-pmouseY)/10.0);
		}
	}
	
	
}


