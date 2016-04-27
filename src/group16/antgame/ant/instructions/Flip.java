package group16.antgame.ant.instructions;

/**
 * The Flip Instruction generates a random number between 0 and a specified boundary. If the number generated is 0 then go to one state, otherwise go to another state.
 * @author Group 16
 * @version 24/03/2016
 */
public class Flip extends Instruction {

    /**
     * The upper limit from which a random number is generated (a random number between 0 and p inclusive).
     */
    private int p;
    
    /**
     * The state to go to if the generated random number = 0.
     */
    private int st1;
    
    /**
     * The state to go to if the generated random number != 0;
     */
    private int st2;
    
    /**
     * Creates a new Flip Instruction and stores the formal parameters ready for execution.
     * @param p The upper limit from which a random number is generated (a random number between 0 and p inclusive).
     * @param st1 The state to go to if the generated random number = 0.
     * @param st2 The state to go to if the generated random number != 0.
     */
    public Flip(int p, int st1, int st2) {
        this.p = p;
        this.st1 = st1;
        this.st2 = st2;
    }
    
    /**
     * Executes the Flip instruction. Generates a random number between 0 and p inclusive and if it equals 0 then go to st1. Go to st2 otherwise.
     * @return The integer of the next state to be executed.
     */
    @Override
    public int execute() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
}
