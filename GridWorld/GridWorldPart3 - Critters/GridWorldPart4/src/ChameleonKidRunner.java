import java.awt.Color;

import info.gridworld.actor.ActorWorld;
import info.gridworld.actor.Rock;
import info.gridworld.critters.ChameleonCritter;
import info.gridworld.critters.ChameleonKid;
import info.gridworld.grid.Location;

public class ChameleonKidRunner {
	public static void main(String[] args)
    {
        ActorWorld world = new ActorWorld();
        world.add(new Location(3, 4), new Rock(Color.RED));
        world.add(new Location(4, 8), new Rock(Color.YELLOW));
        world.add(new Location(4, 4), new ChameleonKid());
        world.add(new Location(5, 8), new ChameleonKid());
        world.show();
    }

}
