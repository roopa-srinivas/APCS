package RoopaS4242.physicsshapedemo;

import cchoy999.shapes.Rectangle;
import cchoy999.shapes.Shape;
import cchoy999.shapes.Line;
import processing.core.PApplet;

public class PhysicsShape {

	private Shape s;
	private double vx, vy; 
	
	private double gravity, friction, movingAngle, angleChange;
	private double previousX, previousY, currentX, currentY, previousAngle, currentAngle;
	private double radius, l1Angle, l2Angle;
	private double adjustedBallMA, adjustedLineAngle, newBallAngle, speed;
	private Line differenceLine;

	public PhysicsShape(Shape s) {
		this.s = s;
		vx = 0;
		vy = 0;
		previousX = currentX = s.getX();
		previousY = currentY = s.getY();
		gravity = 0.2;
		friction = 0.95;
		movingAngle = 0;
		angleChange = 0;
		previousAngle = currentAngle = 0;
		radius = 10;
		l1Angle = 0;
		l2Angle = 0;
		differenceLine = new Line(0, 0, 0, 0);
		adjustedBallMA = 0;
		adjustedLineAngle = 0;
		newBallAngle = 0;
		speed = 0;
	}
	
	
	
	public void draw(PApplet surface) {
		s.draw(surface);
		previousX = currentX;
		previousY = currentY;
		currentX = s.getX();
		currentY = s.getY();
		movingAngle = Math.toDegrees(Math.atan2(previousY - currentY, currentX - previousX));
		previousAngle = currentAngle;
		currentAngle = movingAngle;
		angleChange = currentAngle - previousAngle;
	}
	
	public void act(Rectangle window, Line l1, Line l2) {
		
		s.moveBy(vx, 0);
		
		if (!window.isPointInside(s.getX(), s.getY())) {
			vx = -vx;
			s.moveBy(vx, 0);
		}
		
		s.moveBy(0, vy);
		
		if (!window.isPointInside(s.getX(), s.getY())) {
			vy = -vy;
			s.moveBy(0, vy);
		}
		
		differenceLine = new Line(getPreviousX(), getPreviousY(), getCurrentX(), getCurrentY());
		l1Angle = Math.toDegrees(Math.atan((l1.getY() - l1.getY2())/(l1.getX2() - l1.getX())));
		l2Angle = Math.toDegrees(Math.atan((l2.getY() - l2.getY2())/(l2.getX2() - l2.getX())));
		double lineDistance1 = Math.sqrt(Math.pow(differenceLine.getIntersectionX(l1) - s.getX(), 2) + Math.pow(differenceLine.getIntersectionY(l1) - s.getY(), 2));
		double lineDistance2 = Math.sqrt(Math.pow(differenceLine.getIntersectionX(l2) - s.getX(), 2) + Math.pow(differenceLine.getIntersectionY(l2) - s.getY(), 2));

		
		if ((lineDistance1 <= radius) && ((getCurrentX()<= Math.max(l1.getX2(), l1.getX()))&&(getCurrentX() >= Math.min(l1.getX2(), l1.getX())))) {
			bounce1();
		}
		if ((lineDistance2 <= radius) && ((getCurrentX()<= Math.max(l2.getX2(), l2.getX()))&&(getCurrentX() >= Math.min(l2.getX2(), l2.getX())))) {
			bounce2();
		}
		
		s.moveBy(vx,  vy);
		
		vy += gravity;
		vx *= friction;
		vy *= friction;
		
	}
	
	public boolean isPointInside(double x, double y) {
		return s.isPointInside(x, y);
	}
	
	public void accelerate(double ax, double ay) {
		vx+=ax;
		vy+=ay;
	}
	
	public double getCurrentX() {
		return currentX;
	}
	
	public double getCurrentY() {
		return currentY;
	}
	
	public double getPreviousX() {
		return previousX;
	}
	
	public double getPreviousY() {
		return previousY;
	}
	
	public double getMovingAngle() {
		return movingAngle;
	}
	
	public double getAngleChange() {
		return angleChange;
	}
	
	public double getVX() {
		return vx;
	}
	
	public double getVY() {
		return vy;
	}
	
	public void setVX(double newVX) {
		vx = newVX;
	}
	
	public void setVY(double newVY) {
		vy = newVY;
	}
	
	public void setX(double newX) {
		currentX = newX;
	}
	
	public void setY(double newY) {
		currentY = newY;
	}
	
	public void bounce1() {
		adjustedBallMA = (getMovingAngle()+(180))%(180);
		adjustedLineAngle = (l1Angle + 180) % 180;
		newBallAngle = (((2*adjustedLineAngle) + 180 - adjustedBallMA)%360);
		speed = Math.sqrt(Math.pow(getVX(), 2) + Math.pow(getVY(), 2));
		setVX(speed*Math.cos(newBallAngle));
		setVY(speed*Math.sin(newBallAngle));
	}
	
	public void bounce2() {
		adjustedBallMA = (getMovingAngle()+(180))%(180);
		adjustedLineAngle = (l2Angle + 180) % 180;
		newBallAngle = (((2*adjustedLineAngle) + 180 - adjustedBallMA)%360);
		speed = Math.sqrt(Math.pow(getVX(), 2) + Math.pow(getVY(), 2));
		setVX(speed*Math.cos(newBallAngle));
		setVY(speed*Math.sin(newBallAngle));
	}
	
	
}
