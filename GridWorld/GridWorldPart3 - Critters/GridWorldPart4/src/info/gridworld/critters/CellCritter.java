package info.gridworld.critters;

import java.awt.Color;
import java.util.ArrayList;

import info.gridworld.actor.Actor;
import info.gridworld.actor.Critter;
import info.gridworld.actor.Flower;
import info.gridworld.actor.Rock;
import info.gridworld.grid.Grid;
import info.gridworld.grid.Location;

public class CellCritter extends Critter {
	
	private int count = 0;
	private boolean goingToDie;
	
	public void processActors(ArrayList<Actor> actors)
    {
        for (Actor a : actors)
        {
            if ((a instanceof CellCritter)) {
            	count++;
            }
        }
        
		if (count == 0 || count >= 5) {
			goingToDie = true;
		} else if (count >= 1 && count <= 3) {
			ArrayList<Location> emptySpots = this.getMoveLocations();
			if (emptySpots.size() > 0) {
				int i = (int)((emptySpots.size()) * Math.random());
				Location chosen = emptySpots.get(i);
				CellCritter other = new CellCritter();
				other.putSelfInGrid(getGrid(), chosen);
				
			}
			
		}
		count = 0;
    }
	
	public Location selectMoveLocation(ArrayList<Location> loc) {
		if (goingToDie) {
			return null;
		}
		return getLocation();
	}
	
	
	
}
