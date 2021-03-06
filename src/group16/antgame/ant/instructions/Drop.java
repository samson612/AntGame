package group16.antgame.ant.instructions;

import group16.antgame.ant.Ant;
import group16.antgame.world.Cell;
import group16.antgame.world.Position;
import group16.antgame.world.World;

/**
 * The Drop Instruction allows an ant to drop food in the current cell and go to a new state.
 * @author Group 16
 * @version 24/03/2016
 */
public class Drop extends Instruction {
    
    /**
     * The state to go to once the food is dropped.
     */
    private int st;
    
    /**
     * Creates a new Drop Instruction and stores the formal parameters ready for execution.
     * @param st The integer of the state to go to once food has been dropped.
     */
    public Drop(int st) {
        this.st = st;
    }

    /**
     * Executes the Drop Instruction. Drops food in the current cell and moves to state st.
     * @return The integer of the next state to be executed.
     */
    @Override
    public int execute(World w, Position p, Cell c, Ant a) {
        if(a.hasFood()) {
            a.setHasFood(false);
            c.setFood(c.getNumOfFood()+1);
        }
        return st;
    }

    public int getSt() {
        return st;
    }
    
}
