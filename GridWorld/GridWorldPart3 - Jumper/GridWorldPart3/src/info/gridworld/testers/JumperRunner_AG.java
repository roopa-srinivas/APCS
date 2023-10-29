/*
 * Author: Anuva Gajjar (Group 2)
 * Date: 1-14-2021
 * What will a jumper do if another actor (not a flower or a rock) is in the
 * cell that is two cells in front of the jumper?
 * It will move forwards one space or turn if something is in that cell. 
 */

package info.gridworld.testers;

import java.awt.Color;

import info.gridworld.actor.*;
import info.gridworld.grid.Location;

public class JumperRunner_AG {

	public JumperRunner_AG() {
		
	}

	public static void main(String[] args) {
		ActorWorld world = new ActorWorld();
		Jumper b = new Jumper();
		world.add(new Location(7,2), b);
		b.setDirection(90);
		Jumper a = new Jumper();
		a.setColor(Color.CYAN);
		world.add(new Location(7,5), a);
		a.setDirection(90);
		world.show();

	}

}