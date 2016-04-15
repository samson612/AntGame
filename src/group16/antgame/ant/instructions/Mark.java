package group16.antgame.ant.instructions;

/**
 * The Mark Instruction allows an ant to mark a current cell with one of 6 marks (0-5) and move to a state afterward.
 * @author Group 16
 * @version 24/03/2016
 */
public class Mark extends Instruction {

    /**
     * Integer to mark the cell with. This must be between 0 and 5 inclusive.
     */
    private int marker;
    
    /**
     * The state to move to after the cell has been marked.
     */
    private int st;
    
    /**
     * Creates a new Mark Instruction and stores the formal parameters ready for execution.
     * @param marker The integer to mark the cell with (This must be between 0 and 5 inclusive).
     * @param st The state to move to after execution of this instruction.
     * @throws MarkerOutOfBoundsException if the marker integer does not fall within the specified marker range (between 0 and 5 inclusive).
     */
    public Mark(int marker, int st) {
        if(marker < 0 || marker > 5) {
        }
        else {
            this.marker = marker;
            this.st = st;
        }
    }
    
    /**
     * Executes the Mark Instruction. Marks the current cell with the mark integer and then moves to the state st.
     * @return The integer of the next state (or instruction) to be executed.
     */
    @Override
    public int execute() {
        // Set mark marker in current cell and go to st.
        throw new UnsupportedOperationException("Not supported yet.");
    }
    
}
