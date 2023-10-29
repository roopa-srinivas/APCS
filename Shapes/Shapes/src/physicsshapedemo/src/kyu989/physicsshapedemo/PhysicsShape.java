package physicsshapedemo.src.kyu989.physicsshapedemo;
import RoopaS4242.shapes.Shape;
import processing.core.PApplet;


public class PhysicsShape {

	private Shape s;
	private double vx,vy;
	
	
	
	public PhysicsShape(Shape s) {
		this.s = s;
		vy = 10;
		vx = 10;
	}
	
	public void act()
	{
		double x = s.getX();
		x+= vx;
		double y = s.getY();
		y+= vy;
	}
	
	public void draw(PApplet surface) {
		s.draw(surface);
	}
	
	public void accelerate(double ax, double ay)
	{
		vx += ax;
		vy += ay;
	}

	public boolean isPointInside(int mouseX, int mouseY) {
		s.isPointInside(mouseX,mouseY);
		return false;
	}
	
}
