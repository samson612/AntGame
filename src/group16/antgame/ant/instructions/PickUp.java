package group16.antgame.ant.instructions;

/**
 * The PickUp Instruction allows an ant to pick up food from the current cell and move to a state. If there is no food in that cell then it moves to another state.
 * @author Group 16
 * @version 24/03/2016
 */
public class PickUp extends Instruction {
    
    /**
     * The state to move to if the ant successfully picks up food from the current cell.
     */
    private int st1;
    
    /**
     * The state to move to if the ant can not pick up food from the current cell.
     */
    private int st2;
    
    /**
     * Creates a new PickUp Instruction and stores the formal parameters ready for execution.
     * @param st1 The state to move to if the ant successfully picks up food from the current cell.
     * @param st2 The state to move to if the ant cannot pick up food from the current cell.
     */
    public PickUp(int st1, int st2) {
        this.st1 = st1;
        this.st2 = st2;
    }
    
    /**
     * Executes the PickUp Instruction. Picks up food from the current cell and moves to the state st1. If there is no food available to pick up, move to state st2.
     * @return The integer of the next state to be executed.
     */
    @Override
    public int execute() {
        // Pick up food from current cell and go to st1;
        // go to st2 if there is no food in the current cell.
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
}
