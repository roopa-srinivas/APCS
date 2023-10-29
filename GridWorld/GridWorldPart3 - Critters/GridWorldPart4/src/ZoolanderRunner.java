import java.awt.Color;

import info.gridworld.actor.ActorWorld;
import info.gridworld.actor.Bug;
import info.gridworld.actor.Rock;
import info.gridworld.critters.ChameleonKid;
import info.gridworld.critters.ZoolanderCritter;
import info.gridworld.grid.Location;

public class ZoolanderRunner {
	public static void main(String[] args)
    {
        ActorWorld world = new ActorWorld();
        world.add(new Location(1, 4), new Bug(Color.RED));
        world.add(new Location(2, 3), new Bug(Color.RED));
        world.add(new Location(2, 5), new Bug(Color.RED));
        world.add(new Location(2, 4), new ZoolanderCritter());
        world.show();
    }
}
