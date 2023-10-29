

import processing.core.PApplet;

public class House {
	
	private float x,y;
	public float size;
	
	
	public House (float x, float y, float size) {
		this.x = x;
		this.y = y;
		this.size = size;
	}
	
	public void draw(PApplet papplet) {
		
		//Drawing the house
		papplet.fill(188, 235, 204);
		papplet.rect(x-size/2, y, 350+size, 200+size);
		papplet.fill(207, 25, 122);
		papplet.triangle(x-size/2, y, x+150, y-100-size, x+350+size/2, y);
		papplet.fill(196, 137, 59);
		papplet.rect(x+150-size/2, y+100, 50+size, 100+size);
		papplet.fill(72, 85, 102);
		papplet.square(x+50-size/2, y+25, 50+size/2);
		papplet.square(x+250, y+25, 50+size/2);
		
	}
	
	public void move(int x, int y) {
		this.x = x;
		this.y = y;
	}
	
	public void scale(float size) {
		this.size = size;
	}
	
	
	

}
