package info.gridworld.critters;

import java.lang.reflect.Array;
import java.util.ArrayList;

import info.gridworld.actor.Actor;
import info.gridworld.actor.Critter;
import info.gridworld.actor.Rock;
import info.gridworld.grid.Location;

public class HoarderCritter extends Critter {
	
	private Location homeLoc;
	private Actor pickedUp;
	private ArrayList<Actor> allPickedUp;
	
	public HoarderCritter(Location homeLoc) {
		this.homeLoc = homeLoc;
		this.pickedUp = null;
		this.allPickedUp = new ArrayList<Actor>();
	}
	
	public void processActors(ArrayList<Actor> actors)
    {
		int i = (int)((actors.size()) * Math.random());
		if ((pickedUp == null) && (actors.size() > 0)) {
			if (allPickedUp.size() != 0) {
				while (allPickedUp.contains(actors.get(i))) {
					actors.remove(i);
					i = (int)((actors.size()) * Math.random());
					if (actors.size() == 0) {
						break;
					}
				}
			}
			
			if (actors.size() > 0) {
				pickedUp = actors.get(i);
				allPickedUp.add(actors.get(i));
				actors.get(i).removeSelfFromGrid();
			}
			
		}
		
    }
	
	public ArrayList<Location> getMoveLocations()
    {		
		if (pickedUp == null) {
			return getGrid().getEmptyAdjacentLocations(getLocation());
		} 
		else {
			ArrayList<Location> locs = new ArrayList<Location>();
	
			int r = getLocation().getRow();
			int c = getLocation().getCol();
			
			if (homeLoc.getRow() == r) {
				locs.add(new Location(r, c - this.compareCol(homeLoc)));
			} else if (homeLoc.getCol() == c) {
				locs.add(new Location(r - this.compareRow(homeLoc), c));
			} else {
				locs.add(new Location (r, c - this.compareCol(homeLoc)));
				locs.add(new Location(r - this.compareRow(homeLoc), c));
				locs.add(new Location(r - this.compareRow(homeLoc), c - this.compareCol(homeLoc)));
			}
			
			for (int i = 0; i < locs.size(); i++) {
				Location loc = locs.get(i);
				if ((getGrid().get(loc) != null) || !(getGrid().isValid(loc))) {
					locs.remove(i);
					i--;
				}
			}
			return locs;
		}
	}
	
	public int compareCol(Location otherLoc) {
		if (this.getLocation().getCol() < otherLoc.getCol())
            return -1;
        if (this.getLocation().getCol() > otherLoc.getCol())
            return 1;
        return 0;
	}
	
	public int compareRow(Location otherLoc) {
		if (this.getLocation().getRow() < otherLoc.getRow())
            return -1;
        if (this.getLocation().getRow() > otherLoc.getRow())
            return 1;
        return 0;
	}
	
	public void makeMove(Location loc)
    {
		ArrayList<Location> possibleMoveLoc = this.getGrid().getEmptyAdjacentLocations(this.getLocation());
		int index = (int)(possibleMoveLoc.size()*Math.random());
		Location temp = this.getLocation();
		this.moveTo(loc);
		
		if (loc.equals(temp) && (pickedUp != null)) {
			Actor tempPickedUp = pickedUp;
			pickedUp = null;
			
			if (possibleMoveLoc.size() != 0) {
				makeMove(possibleMoveLoc.get(index));
			} else {
				removeSelfFromGrid();
			}
			
			tempPickedUp.putSelfInGrid(getGrid(), temp);
			
		}
		
    }
}
