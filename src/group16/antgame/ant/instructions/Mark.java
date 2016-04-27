package group16.antgame.ant.instructions;

import group16.antgame.ant.Ant;
import group16.antgame.world.Cell;
import group16.antgame.world.Position;
import group16.antgame.world.World;

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
    public int execute(World w, Position p, Cell c, Ant a) {
        c.set_marker(a.getColour(), marker);
        return st;
    }

    public int getMarker() {
        return marker;
    }

    public int getSt() {
        return st;
    }
    
    
}
