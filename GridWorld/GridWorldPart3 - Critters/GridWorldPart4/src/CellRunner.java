import java.awt.Color;

import info.gridworld.actor.ActorWorld;
import info.gridworld.actor.Bug;
import info.gridworld.actor.Rock;
import info.gridworld.critters.CellCritter;
import info.gridworld.critters.ZoolanderCritter;
import info.gridworld.grid.Location;

public class CellRunner {
	public static void main(String[] args)
    {
        ActorWorld world = new ActorWorld();
        world.add(new Location(0, 1), new Rock());
        world.add(new Location(1, 2), new Rock());
        world.add(new Location(2, 2), new Rock());
        world.add(new Location(3, 1), new Rock());
        world.add(new Location(1, 0), new CellCritter());
        world.add(new Location(1, 1), new CellCritter());
        world.add(new Location(2, 1), new CellCritter());
        world.add(new Location(2, 0), new CellCritter());
        world.add(new Location(0, 3), new CellCritter());
        world.show();
    }
}
