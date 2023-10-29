import info.gridworld.actor.ActorWorld;
import info.gridworld.actor.Critter;
import info.gridworld.actor.Flower;
import info.gridworld.actor.Rock;
import info.gridworld.critters.SuperCritter;
import info.gridworld.grid.Location;

public class SuperCritterRunnerXZ {
	// this tester is used to test what the superCritter will do when both spaces it
	// moves to are blocked.

	public static void main(String args[]) {

		ActorWorld world = new ActorWorld();
		world.add(new Location(2, 4), new SuperCritter());
		world.add(new Location(0, 3), new Flower());
		world.add(new Location(0, 5), new Rock());
		
		world.show();

	}
}
