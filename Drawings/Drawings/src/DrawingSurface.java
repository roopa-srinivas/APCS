import java.awt.Button;
import java.awt.Dimension;
import java.awt.Toolkit;
import java.awt.event.KeyEvent;
import java.awt.event.MouseEvent;
import java.util.Random;

import javax.swing.JFrame;

import processing.awt.PSurfaceAWT;
import processing.core.PApplet;

public class DrawingSurface extends PApplet {
	
	//fields for new house and person object
	private House h;
	private Person p1, p2;
	public int p1x, p1y, p2x, p2y;
	private float DRAWING_WIDTH, DRAWING_HEIGHT, hsize;
	private Line l1,l2;
	private double intersectionx, intersectiony;
	Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();

	
	public DrawingSurface() {
		//initializing house and person objects
		h = new House(110, 200, 0);
		p1 = new Person(50, 360);
		p2 = new Person(480, 360);
		p1x = p1.getX();
		p1y = p1.getY();
		p2x = p2.getX();
		p2y = p2.getY();
		hsize = h.size;
		DRAWING_WIDTH = (float) screenSize.getWidth();
		DRAWING_HEIGHT = (float) screenSize.getHeight();
		
	}
	
	
	public void draw() {
		//adding house and person to drawing canvas
		background(188, 206, 235);
		
		h.draw(this);	
		p1.draw(this, "left");
		p2.draw(this, "right");
		scale((float)width/DRAWING_WIDTH, (float)height/DRAWING_HEIGHT);
		//if ((l1==null) && (l2 == null)) {
		l1 = p1.getLine();
		l2 = p2.getLine();
		//}
		
		
		//beginning of instructions
		pushStyle();
		
		fill(0);
		textSize(20);
		text("Instructions: \nMouse Click: Move House \nWASD: Move Person 1 \nNumber key 1: scale house up \nNumber key 2: scale house down \nArrow keys: move Person 2", 10, 10);
		
		popStyle();
	}
	
	public void mousePressed() {
		h.move(mouseX, mouseY);
	}
	
	public void keyPressed() {
		intersectionx = l1.getIntersectionX(l2);
		intersectiony = l1.getIntersectionY(l2);
		if (keyCode == KeyEvent.VK_D) {
			p1x+=10;
			p1.move(p1x, p1y);
		} else if (keyCode == KeyEvent.VK_A) {
			p1x-=10;
			p1.move(p1x, p1y);
		} else if (keyCode == KeyEvent.VK_W) {
			p1y-=10;
			p1.move(p1x, p1y);
		} else if (keyCode == KeyEvent.VK_S) {
			p1y+=10;
			p1.move(p1x, p1y);
		} else if (keyCode == KeyEvent.VK_RIGHT) {
			p2x+=10;
			p2.move(p2x, p2y);
		} else if (keyCode == KeyEvent.VK_LEFT) {
			p2x-=10;
			p2.move(p2x, p2y);
		} else if (keyCode == KeyEvent.VK_UP) {
			p2y-=10;
			p2.move(p2x, p2y);
		} else if (keyCode == KeyEvent.VK_DOWN) {
			p2y+=10;
			p2.move(p2x, p2y);
		} else if (keyCode == KeyEvent.VK_1) {
			hsize += 1;
		} else if (keyCode == KeyEvent.VK_2) {
			hsize -= 1;
		}
			h.scale(hsize);
			
		if (l1.intersects(l2)) {
			p1.changeColor(55, 235, 52);
			p2.changeColor(55, 235, 52);
		} else {
			p1.changeColor(0, 0, 0);
			p2.changeColor(0, 0, 0);
		}

	}
		
		   
	}



