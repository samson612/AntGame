package group16.antgame.ant.instructions;

import group16.antgame.ant.Ant;
import group16.antgame.world.Cell;
import group16.antgame.world.Position;
import group16.antgame.world.World;
import java.util.Random;

/**
 * The Flip Instruction generates a random number between 0 and a specified boundary. If the number generated is 0 then go to one state, otherwise go to another state.
 * @author Group 16
 * @version 24/03/2016
 */
public class Flip extends Instruction {

    /**
     * The upper limit from which a random number is generated (a random number between 0 and p inclusive).
     */
    private int x;
    
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
     * @param x The upper limit from which a random number is generated (a random number between 0 and p inclusive).
     * @param st1 The state to go to if the generated random number = 0.
     * @param st2 The state to go to if the generated random number != 0.
     */
    public Flip(int x, int st1, int st2) {
        this.x = x;
        this.st1 = st1;
        this.st2 = st2;
    }
    
    /**
     * Executes the Flip instruction. Generates a random number between 0 and p inclusive and if it equals 0 then go to st1. Go to st2 otherwise.
     * @return The integer of the next state to be executed.
     */
    @Override
    public int execute(World w, Position p, Cell c, Ant a) {
        Random random = new Random();
        int randNo = random.nextInt(x);
        if(randNo == 0) {
            return st1;
        }
        else {
            return st2;
        }
    }

    public int getX() {
        return x;
    }

    public int getSt1() {
        return st1;
    }

    public int getSt2() {
        return st2;
    }
    
    
}
