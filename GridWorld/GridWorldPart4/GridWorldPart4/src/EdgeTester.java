import info.gridworld.critters.*;
import java.util.Scanner;
import info.gridworld.grid.*;
import info.gridworld.actor.*; 

public class EdgeTester {
	public static void main (String args[]) {
		Scanner kboard = new Scanner(System.in);
		System.out.println("press enter to test");
		ActorWorld world = new ActorWorld();
		SuperCritter critter = new SuperCritter();
		while (true) {
			kboard.next();
			world.add(critter);
			critter.moveTo(new Location(0, 0));
			critter.act();
			if (critter.getGrid() != null) System.out.println(true);
			else {
				System.out.println(false);
				break;
			}
		}
	}
}