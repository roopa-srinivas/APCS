import info.gridworld.actor.Bug;

public class DancingBug extends Bug{
	
	private int[] numTurns;
	private int finishedTurns;
	
	public DancingBug(int[] turns) {
		numTurns = new int[turns.length];
		finishedTurns = 0;
		for (int i = 0; i < turns.length; i++) {
			numTurns[i] = turns[i];
		}
	}

    public void turn() {
    	for(int i = 0; i < numTurns[finishedTurns]; i++) {
    		super.turn();
    	}
    	finishedTurns++;
    	if(finishedTurns >= numTurns.length) {
    		finishedTurns = 0;
    	}
    }
    
    public boolean canMove() {
    	return super.canMove();
    	
    }
    
    public void move() {
    	turn();
    	super.move();
    }
}
