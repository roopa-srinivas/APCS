/*
 * Author: Group 6
 * Date: 1-14-2021
 */

package info.gridworld.actor;

import info.gridworld.grid.Grid;
import info.gridworld.grid.Location;

public class Jumper extends Bug {

	// CONSTRUCTOR
	public Jumper() {
		
	}
	
	
	// METHODS
	
	public void act() {
		if (canMove2() && canMove1()) {
			move();
			move();
		}
		else if (canMove1()) {
			move();
		}
		else {
			turn();
		}
		// if it can move 2 spaces, do that
		// if it can move 1 space, do that
		// otherwise, turn
	}
	
	public void move() {
		Grid<Actor> gr = getGrid();
        if (gr == null)
            return;
        Location loc = getLocation();
        Location next1 = loc.getAdjacentLocation(getDirection());
        if (gr.isValid(next1))
            moveTo(next1);
        else
            removeSelfFromGrid();
        Flower flower = new Flower(getColor());
        flower.putSelfInGrid(gr, loc);
	}
	
	public void turn() {
		setDirection(getDirection() + Location.RIGHT);
	}
	
	public boolean canMove2() {
		Grid<Actor> gr = getGrid();
        if (gr == null)
            return false;
        Location loc = getLocation();
        Location next1 = loc.getAdjacentLocation(getDirection());
        Location next2 = next1.getAdjacentLocation(getDirection());
        if (!gr.isValid(next2))
            return false;
        Actor neighbor = gr.get(next2);
        return (neighbor == null) || (neighbor instanceof Flower);
	}

	public boolean canMove1() {
		Grid<Actor> gr = getGrid();
        if (gr == null)
            return false;
        Location loc = getLocation();
        Location next = loc.getAdjacentLocation(getDirection());
        if (!gr.isValid(next))
            return false;
        Actor neighbor = gr.get(next);
        return (neighbor == null) || (neighbor instanceof Flower);
	}

}