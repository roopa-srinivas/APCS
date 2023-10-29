import processing.core.PApplet;

public class Person {
	
	public int x,y;
	private Line line;
	private int r,g,b;
	
	public Person(int x, int y) {
		this.x = x;
		this.y = y;
		line = null;
		r = 0;
		g = 0;
		b = 0;
	}
	
	public void draw(PApplet papplet, String side) {
		
		//Drawing the person
		papplet.stroke(r,g,b);
		papplet.line(x, y, x, y+30);
		papplet.line(x, y+30, x+12, y+42);
		papplet.line(x, y+30, x-12, y+42);
		papplet.line(x-12, y+15, x+12, y+15);
		papplet.fill(255,218,185);
		papplet.square(x-10, y-20, 20);
		
		
		if (side == "left") {
			papplet.stroke(50, 90, 168);
			line = new Line(x+12, y+15, x+28, y-1);
			line.draw(papplet);
			line.setPoint2(x+28,y-1);
			papplet.stroke(0);
		} else if (side == "right") {
			papplet.stroke(217, 57, 46);
			line = new Line(x-12, y+15, x-28, y-1);
			line.draw(papplet);
			line.setPoint2(x-28,y-1);
			papplet.stroke(0);
		}
	}
	
	public void move(int x, int y) {
		this.x = x;
		this.y = y;
	}
	
	public int getX() {
		return this.x;
	}
	
	public int getY() {
		return this.y;
	}
	
	public void changeColor(int r, int g, int b) {
		this.r = r;
		this.g = g;
		this.b = b;
	}
	
	public Line getLine() {
		return line;
	}
	

}