package group16.antgame.ant.instructions;

import group16.antgame.ant.Ant;
import group16.antgame.world.Cell;
import group16.antgame.world.Position;
import group16.antgame.world.World;

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
    public int execute(World w, Position p, Cell c, Ant a) {
        if(c.getNumOfFood() > 0) {
            a.setHasFood(true);
            c.setFood(c.getNumOfFood() - 1);
            return st1;
        }
        else {
            return st2;
        }
    }

    public int getSt1() {
        return st1;
    }

    public int getSt2() {
        return st2;
    }
    
}
