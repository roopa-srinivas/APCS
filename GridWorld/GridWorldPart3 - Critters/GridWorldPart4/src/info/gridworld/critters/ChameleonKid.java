package info.gridworld.critters;

import java.awt.Color;
import java.util.ArrayList;
import java.util.Random;

import info.gridworld.actor.Actor;
import info.gridworld.actor.Critter;
import info.gridworld.actor.Rock;
import info.gridworld.grid.Grid;
import info.gridworld.grid.Location;

public class ChameleonKid extends ChameleonCritter {
	
	Random rand = new Random();
	int randX = 0; 
	int randY = 0;
	
	public ArrayList<Actor> getActors() {
		ArrayList<Actor> array = new ArrayList<Actor>();
		Location x = getLocation();
		if (getGrid().isValid(x.getAdjacentLocation(getDirection())) && getGrid().get(x.getAdjacentLocation(getDirection())) != null) {
			array.add(getGrid().get(x.getAdjacentLocation(getDirection())));
		}
		if (getGrid().isValid(x.getAdjacentLocation(getDirection()+180)) && getGrid().get(x.getAdjacentLocation(getDirection()+180)) != null) {
			array.add(getGrid().get(x.getAdjacentLocation(getDirection()+180)));
		}
		return array;
	} 
	
	public void processActors(ArrayList<Actor> actors)
    {
        int n = actors.size();
        if (n == 0) {
        	setColor(this.getColor().darker());
        	return;
        }
        
        for (Actor a : actors)
        {
        	
        	ArrayList<Location> occupiedLocations = getGrid().getOccupiedLocations();
        	
            if (a instanceof Critter) {
            	for (int i = 0; i < occupiedLocations.size(); i++) {
            		if (occupiedLocations.get(i).getCol() == randY) {
                    	randY = rand.nextInt(getGrid().getNumCols()); 
            		}
            		if (occupiedLocations.get(i).getRow() == randX) {
            			randX = rand.nextInt(getGrid().getNumRows());
            		}
            	}
            	Location newLoc = new Location(randX, randY);
            	a.moveTo(newLoc);
            }
            else if (a instanceof Actor)
            	this.setColor(a.getColor());
        }
    }
}
