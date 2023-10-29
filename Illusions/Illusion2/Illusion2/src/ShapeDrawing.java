import java.util.ArrayList;
import RoopaS4242.shapes.Shape;

import processing.core.PApplet;

/**
 * 
 * A ShapeDrawing is a complex drawing consisting of multiple shapes. More complex classes could
 * inherit from ShapeDrawing, then have additional methods to customize their content.
 * 
 * @author Shelby
 * @version 10/6/20
 */
public class ShapeDrawing {

	private ArrayList<Shape> shapes;  // Make sure that you import your Shape class to fix errors here
	
	/**
	 * Constructs a new ShapeDrawing.
	 */
	public ShapeDrawing() {
		shapes = new ArrayList<Shape>();
	}

	/**
	 * Adds a new shape to the drawing, which will be displayed when draw() is called.
	 * 
	 * @param s The shape to add to the drawing. Must not be null.
	 */
	public void addShape(Shape s) {
		shapes.add(s);
	}

	/**
	 * Returns the i-1th shape added to the drawing.
	 * 
	 * @param i The index of the shape to be returned.
	 * @return The i-1th shape added.
	 */
	public Shape getShape(int i) {
		return shapes.get(i);
	}
	
	/**
	 * Returns the number of shapes in this drawing.
	 * 
	 * @return The number of shapes currently in the drawing.
	 */
	public int getNumShapes() {
		return shapes.size();
	}

	/**
	 * Draws the shapes that make up this drawing on to the screen using their own draw()
	 * methods.
	 * 
	 * @param marker The PApplet used to draw this drawing. Should not be null.
	 * @post All shapes added to this object have been drawn to the screen.
	 */
	public void draw(PApplet surface) {
		surface.pushMatrix();
		surface.pushStyle();
		for (int i = 0; i < shapes.size(); i++)
			shapes.get(i).draw(surface);   // If you have a compiler error on this line, ensure that your Shape class has the method: public void draw(PApplet surface)
		surface.popStyle();
		surface.popMatrix();
	}

}

