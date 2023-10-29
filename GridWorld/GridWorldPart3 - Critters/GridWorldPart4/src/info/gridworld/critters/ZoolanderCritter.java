package info.gridworld.critters;

import java.util.ArrayList;

import info.gridworld.actor.Actor;
import info.gridworld.actor.Critter;
import info.gridworld.actor.Flower;
import info.gridworld.actor.Rock;
import info.gridworld.grid.Location;

public class ZoolanderCritter extends Critter {
	Location frontLocation;
	public void processActors(ArrayList<Actor> actors) {
        for (Actor a : actors)
        {
            if (a instanceof Flower)
                a.removeSelfFromGrid();
        }
    }
	
	public ArrayList<Location> getMoveLocations()
    {
        ArrayList<Location> openSpots = getGrid().getEmptyAdjacentLocations(getLocation());
        ArrayList<Location> possibleLocations = new ArrayList<Location>();
        if (this.getDirection() == (Location.NORTH)) {
        	frontLocation = new Location(this.getLocation().getRow()-1, this.getLocation().getCol());
        } else if (this.getDirection() == (Location.SOUTH)) {
        	frontLocation = new Location(this.getLocation().getRow()+1, this.getLocation().getCol());
        } else if (this.getDirection() == (Location.EAST)) {
        	frontLocation = new Location(this.getLocation().getRow(), this.getLocation().getCol()+1);
        } else if (this.getDirection() == (Location.WEST)) {
        	frontLocation = new Location(this.getLocation().getRow(), this.getLocation().getCol()-1);
        }
        
        
        
        
        for (int i = 0; i < openSpots.size(); i++) {
        	if (getGrid().isValid(openSpots.get(i))) {
        		if (frontLocation.equals(openSpots.get(i))) {
        			possibleLocations.add(frontLocation);
        		}
        	}
        	
        }
		return possibleLocations;
        
    }
	
	public void makeMove(Location loc)
    {
		if (getMoveLocations().size() == 0) {
	        setDirection(getDirection() + Location.RIGHT);
		}
		else {
	        super.makeMove(loc);
		}
    }
	
	
	
}
