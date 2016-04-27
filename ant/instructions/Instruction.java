package group16.antgame.ant.instructions;

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
    public abstract int execute();
    
}
