package group16.antgame.ant.instructions;

import group16.antgame.ant.Ant;
import group16.antgame.world.Cell;
import group16.antgame.world.Position;
import group16.antgame.world.World;

/**
 * All instructions that an ant can execute must extend the Instruction class.
 * @author Group 16
 * @version 24/03/2016
 */
public abstract class Instruction {
    
    /**
     * Executes the current instruction. This must be implemented by all extending classes as it is how every instruction is called.
     * @return The integer of the next state (or next instruction) to be called by the ant brain.
     */
    public abstract int execute(World w, Position p, Cell c, Ant a);
    
}
