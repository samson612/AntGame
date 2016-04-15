package group16.antgame.ant.instructions;

import group16.antgame.ant.MarkerOutOfBoundsException;

/**
 * The Unmark Instruction allows an ant to unmark the current cell with one of 6 marks (0-5) and move to a state afterward.
 * @author Group 16
 * @version 24/03/2016
 */
public class Unmark extends Instruction {

    /**
     * Integer to unmark the cell with. This must be between 0 and 5 inclusive.
     */
    private int marker;
    
    /**
     * The state to move to after the cell has been unmarked.
     */
    private int st;
    
    /**
     * Creates a new Unmark Instruction and stores the formal parameters ready for execution.
     * @param marker The integer to unmark the cell with (This must be between 0 and 5 inclusive).
     * @param st The state to move to after execution of this instruction.
     * @throws MarkerOutOfBoundsException if the marker integer does not fall within the specified marker range (between 0 and 5 inclusive).
     */
    public Unmark(int marker, int st) throws MarkerOutOfBoundsException {
        if(marker < 0 || marker > 5) {
        }
        else {
            this.marker = marker;
            this.st = st;
        }
    }
    
    /**
     * Executes the Unmark Instruction. Unmarks the current cell with the marker integer and then moves to the state st.
     * @return The integer of the next state (or instruction) to be executed.
     */
    @Override
    public int execute() {
        // Unmark marker in current cell and go to st.
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
}
