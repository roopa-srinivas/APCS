package RoopaS4242.physicsshapedemo;

import java.awt.Dimension;
import java.awt.Toolkit;
import java.awt.event.KeyEvent;
import java.util.Random;
import java.util.concurrent.TimeUnit;

import cchoy999.shapes.Circle;
import cchoy999.shapes.Line;
import cchoy999.shapes.Rectangle;
import processing.core.PApplet;


public class DrawingSurface extends PApplet {
	
	private Line l1, l2;
	private PhysicsShape[] circles;
	private PhysicsShape circle;
	private Rectangle window;
	private int radius;
	
	public DrawingSurface() {
		window = new Rectangle(0,0,this.width-radius, this.height-radius);
		int numCircles = 100;
		circles = new PhysicsShape[numCircles];
		Random rand = new Random();
	    int upperboundX = 450;
	    int lowerboundX = 100;
	    int upperboundY = -300;
	    int lowerboundY = 0;
	    radius = 10;
	    circle = new PhysicsShape(new Circle(rand.nextInt(upperboundX + 1 - lowerboundX) + lowerboundX, rand.nextInt(lowerboundY + 1 - upperboundY) + upperboundY, radius));
		for (int i = 0; i < numCircles; i++) {
			circles[i] = new PhysicsShape(new Circle(rand.nextInt(upperboundX + 1 - lowerboundX) + lowerboundX, rand.nextInt(lowerboundY + 1 - upperboundY) + upperboundY, radius));
		}
		l1 = new Line (100, 100, 250, 250);
		l2 = new Line (450, 300, 300, 450);
	}
	
	public void setup() {
		background(255);
	}
	
	public void draw() {
		window = new Rectangle(radius,-300,this.width-radius*2, this.height-radius+300);
		background(255);
		l1.draw(this);
		l2.draw(this);
		circle.draw(this);
		circle.act(window, l1, l2);
		for (PhysicsShape c : this.circles) {
			c.draw(this);
			c.act(window, l1, l2);
		}
	}
	public void mouseDragged() {
		for (int i = 0; i < circles.length; i++) {
			circles[i].accelerate((mouseX-pmouseX)/15.0, (mouseY-pmouseY)/15.0);
			circles[i].act(window, l1, l2);
		}
	}
	
}


