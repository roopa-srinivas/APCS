import RoopaS4242.shapes.Circle;
import RoopaS4242.shapes.Rectangle;
import RoopaS4242.shapes.Line;
import RoopaS4242.shapes.Shape;
import processing.core.PApplet;
/**
 * 
 * The IllusionDrawing is a ShapeDrawing consisting of shapes to display one of the 4 optical illusions.
 * 
 * @author roopa
 *
 */
public class IllusionDrawing extends ShapeDrawing {
	Line l;
	Line vL;
	int count = 1;
	int vCount = 1;
	double angle = (double) 2*Math.PI/50;
	double VLineY1 = 125;
	double VLineY2 = 475;
	double VLineX = 175;
	/**
	 * Constructs an IllusionDrawing by generating the appropriate shapes.
	 */
	public IllusionDrawing() {
		super();
//		Line l = new Line(100, 100, 100, angle*count, 0, 0, 0, 3, false);
//		super.addShape(l);
//		Line vL = new Line(VLineX, VLineY1, VLineX, VLineY1, 255, 0, 0, 3);
//		super.addShape(vL);
		while (count <= 50){
			
			l = new Line(300, 300, 200, angle*count, 0, 0, 0, 3, false);
			super.addShape(l);
			count++;
			
		}
		count = 1;
		while (count <= 6) {
			
			Line vL = new Line(VLineX, VLineY1, VLineX, VLineY2, 255, 0, 0, 5);
			super.addShape(vL);
			VLineX += 50;
			count++;
		}
		// Use this constructor to:
		// 1) Create shape objects
		// 2) Call methods on them as necessary
		// 3) Add them to the "drawing"
		
		// Example:
		// Rectangle r = new Rectangle(100,100,200,200);
		// r.setFillColor(Color.BLACK);
		// illusion.addShape(r);
		
	}
	
}
