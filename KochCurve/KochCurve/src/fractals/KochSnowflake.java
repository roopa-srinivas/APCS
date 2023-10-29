package fractals;
import processing.core.PApplet;

import java.util.ArrayList;

import fractals.KochCurve;

public class KochSnowflake {
	private int level, length;
	private double angle, x, y;
	private KochCurve curve1, curve2, curve3;
	private ArrayList<KochCurve> curves;
	
	public KochSnowflake(int sides, int level, int length) {
		this.level = level;
		this.length = length;
		this.x = 500;
		this.y = 200;
		this.angle = 0;
		curves = new ArrayList<KochCurve>();
		for(int i = 0; i < sides; i++) {
			curves.add(new KochCurve(this.level, this.length, this.angle, this.x, this.y));
			this.x = (double)(this.x + Math.cos(angle)*length);
			this.y = (double)(this.y + Math.sin(angle)*length);
			this.angle += (2*Math.PI/sides);
		}
	}
	
	public void draw(PApplet marker) {
		for (int i = 0; i < curves.size(); i++) {
			curves.get(i).draw(marker);
		}
	}
}
