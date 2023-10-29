/*
 * Author: (put your name) (Group 2)
 * Date: 1-14-2021
 * 
 * Spec tested: f) bug is completely surrounded (both 1st and 2nd space away)
 */

package info.gridworld.testers;

import info.gridworld.actor.*;
import info.gridworld.grid.Location;

public class JumperRunner_KT {

	public JumperRunner_KT() {
		
	}

	public static void main(String[] args) {
		ActorWorld world = new ActorWorld();
		int i = 4;
		world.add(new Location(i, i), new Jumper());
		for(int x=-2; x<=2; x++) {
			for(int y=-2; y<=2; y++) {
				if(!(x==0 && y==0))
				world.add(new Location(i+x,i+y), new Rock());
			}		
		}
		world.show();
	}

}