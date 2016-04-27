package group16.antgame.ant.instructions;

import group16.antgame.ant.Condition;
import group16.antgame.ant.SenseDirection;

/**
 * The Sense Instruction allows an ant to sense if food or anything else is in a nearby cell and moves into another state accordingly.
 * @author Group 16
 * @version 24/03/2016
 */
public class Sense extends Instruction {

    /**
     * The direction in which the ant Senses.
     * @see SenseDirection
     */
    private SenseDirection dir;
    
    /**
     * The state the ant moves to if it senses the condition.
     */
    private int st1;
    
    /**
     * The state the ant moves to if it cannot sense the condition.
     */
    private int st2;
    
    /**
     * The condition that the ant is sensing for.
     * @see Condition
     */
    private Condition cond;
    
    /**
     * Creates a new Sense Instruction and stores the formal parameters ready for execution.
     * @param dir The SenseDirection that the ant is sensing in.
     * @param st1 The state to move to if the ant senses the condition.
     * @param st2 The state to move to if the ant cannot sense the condition.
     * @param cond The condition the ant is sensing for.
     */
    public Sense(SenseDirection dir, int st1, int st2, Condition cond) {
        this.dir = dir;
        this.st1 = st1;
        this.st2 = st2;
        this.cond = cond;
    }
    
    /**
     * Executes the Sense Instruction. Go to state st1 if cond holds in dir, and to state st2 otherwise.
     * @return The integer representing the next state to go to when this instruction has executed.
     */
    @Override
    public int execute() {
        // Go to state st1 if cond holds in dir
        // and to st2 otherwise
        throw new UnsupportedOperationException("Not supported yet.");
    }
    
}
