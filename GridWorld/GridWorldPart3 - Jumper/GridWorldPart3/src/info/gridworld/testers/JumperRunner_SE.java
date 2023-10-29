/*
 * Author: Savio Esmailzadeh (Group 2)
 * Date: 1-14-2021
 * Prompt c, Tests that the jumper turns when at the edge of the grid
 */

package info.gridworld.testers;

import info.gridworld.actor.*;
import info.gridworld.grid.Location;

public class JumperRunner_SE {

	public JumperRunner_SE() {
		
	}

	public static void main(String[] args) {
		ActorWorld world = new ActorWorld();
		world.add(new Location(0, 0), new Jumper());
		world.show();
	}

}