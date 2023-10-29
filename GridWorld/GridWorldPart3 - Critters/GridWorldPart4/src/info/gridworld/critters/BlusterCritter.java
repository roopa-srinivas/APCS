package info.gridworld.critters;

import java.util.ArrayList;

import info.gridworld.grid.Location;
import info.gridworld.actor.Actor;
import info.gridworld.actor.Critter;
import info.gridworld.actor.Rock;
import info.gridworld.grid.Grid;
import info.gridworld.grid.Location;

public class BlusterCritter extends Critter{
	
	private int courage;
	private int n;

	public BlusterCritter(int c) {
		super();
		this.courage = c;
	}
	
	public void processActors(ArrayList<Actor> actors) {
        n = this.getActors().size();
        if (n >= courage) {
        	setColor(this.getColor().darker());
        }
        else {
        	setColor(this.getColor().brighter());
        }
    }
	
	public ArrayList<Actor> getActors()
    {
        ArrayList<Actor> actors = new ArrayList<Actor>();
        ArrayList<Location> loc = new ArrayList<Location>();
        
        loc.add(getLocation().getAdjacentLocation(getDirection()).getAdjacentLocation(getDirection()+90));
        loc.add(getLocation().getAdjacentLocation(getDirection()).getAdjacentLocation(getDirection()+270));
        loc.add(getLocation().getAdjacentLocation(getDirection()+180).getAdjacentLocation(getDirection()+90));
        loc.add(getLocation().getAdjacentLocation(getDirection()+180).getAdjacentLocation(getDirection()+270));
        
        for (int i = 0; i<loc.size(); i++) {
        	if (!getGrid().isValid(loc.get(i))) {
        		loc.remove(i);
        	}
        }
        
        for (int i = 0; i < loc.size(); i++) {
        	actors.addAll(getGrid().getNeighbors(loc.get(i)));
        	actors.remove(this);
        }
        
        actors.remove(getLocation().getAdjacentLocation(getDirection()));
        actors.remove(getLocation().getAdjacentLocation(getDirection()).getAdjacentLocation(getDirection()));
        actors.remove(getLocation().getAdjacentLocation(getDirection()+90));
        actors.remove(getLocation().getAdjacentLocation(getDirection()+90).getAdjacentLocation(getDirection()+90));
        actors.remove(getLocation().getAdjacentLocation(getDirection()+180));
        actors.remove(getLocation().getAdjacentLocation(getDirection()+180).getAdjacentLocation(getDirection()+180));
        actors.remove(getLocation().getAdjacentLocation(getDirection()+270));
        actors.remove(getLocation().getAdjacentLocation(getDirection()+270).getAdjacentLocation(getDirection()+270));
        
        
        return actors;
    }
}
