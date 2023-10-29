import info.gridworld.actor.ActorWorld;
import info.gridworld.actor.Bug;
import info.gridworld.actor.Rock;
import info.gridworld.critters.HoarderCritter;
import info.gridworld.grid.Location;

public class HoarderRunner {
	
	
	public static void main(String[] args)
    {
        ActorWorld world = new ActorWorld();
        world.add(new Location(0, 4), new Rock());
        world.add(new Location(1, 4), new Rock());
        world.add(new Location(2, 4), new Rock());
        world.add(new Location(3, 4), new Rock());
        world.add(new Location(4, 4), new Rock());
        world.add(new Location(5, 4), new Rock());
        world.add(new Location(6, 4), new Rock());
        world.add(new Location(7, 4), new Rock());
        world.add(new Location(8, 4), new Rock());
        world.add(new Location(9, 4), new Rock());
        world.add(new Location(6, 1), new Bug());
        world.add(new Location(5, 1), new HoarderCritter(new Location(5, 5)));
        world.show();
    }
}
