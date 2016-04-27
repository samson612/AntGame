package group16.antgame.ant.instructions;

/**
 * The Move Instruction allows the ant to move forward one space in the direction it is facing and then proceeds to a new state.
 * @author Group 16
 * @version 24/03/2016
 */
public class Move extends Instruction {

    /**
     * The state to go to if the ant successfully moves forward one space.
     */
    private int st1;
    
    /**
     * The state to go to if the ant cannot move forward one space (if it is blocked).
     */
    private int st2;
    
    /**
     * Creates a new Move Instruction, storing all formal parameters ready for execution.
     * @param st1 The state to go to if the ant successfully moves forward one space.
     * @param st2 The state to go to if the ant cannot move forward one space (if it is blocked). 
     */
    public Move(int st1, int st2) {
        this.st1 = st1;
        this.st2 = st2;
    }
    
    /**
     * Executes the Move Instruction. If the space ahead of the ant is free, move forward and go to state st1. Otherwise, go to state st2.
     * @return The integer of the next state to be executed.
     */
    @Override
    public int execute() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
}
