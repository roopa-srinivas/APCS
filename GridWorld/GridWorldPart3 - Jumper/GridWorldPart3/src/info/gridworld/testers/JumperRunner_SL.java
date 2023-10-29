/*
 * Author: Sophie Lin (Group 2) 
 * question a
 * Date: 1-14-2021
 */

package info.gridworld.testers;

import info.gridworld.actor.*;
import info.gridworld.grid.Location;

public class JumperRunner_SL {

	public JumperRunner_SL() {
		
	}

	public static void main(String[] args) {
		ActorWorld world = new ActorWorld();
        world.add(new Location(1, 5), new Rock());
        world.add(new Location(3, 5), new Jumper());
        world.show();

	}

}