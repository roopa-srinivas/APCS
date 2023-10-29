import info.gridworld.actor.ActorWorld;
import info.gridworld.actor.Critter;
import info.gridworld.actor.Flower;
import info.gridworld.actor.Rock;
import info.gridworld.critters.SuperCritter;
import info.gridworld.grid.Location;

public class SuperCritterRunnerRS {
	public static void main(String args[]) {
		
		ActorWorld world = new ActorWorld();
		world.add(new Location(2, 4), new SuperCritter());
		world.add(new Location(4, 2), new Flower());
        world.add(new Location(3, 4), new Rock());
        world.add(new Location(4, 6), new Rock());
        world.add(new Location(5, 3), new Critter());
        world.show();
		
	}
}
