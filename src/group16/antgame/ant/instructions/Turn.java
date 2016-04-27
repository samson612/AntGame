package group16.antgame.ant.instructions;

import group16.antgame.ant.Ant;
import group16.antgame.ant.LinearDirection;
import group16.antgame.world.Cell;
import group16.antgame.world.Position;
import group16.antgame.world.World;

/**
 * The Turn Instruction allows an ant to turn left or right and move to a new state.
 * @author Group 16
 * @version 24/03/2016
 */
public class Turn extends Instruction {

    /**
     * The direction for which the ant will turn (Left or Right).
     * @see LinearDirection
     */
    LinearDirection dir;
    
    /**
     * The state to move to after turning.
     */
    int st;
    
    /**
     * Creates a new Turn Instruction and stores all formal parameters ready for execution.
     * @param dir The direction for which the ant will turn.
     * @param st The state to move to after turning.
     */
    public Turn(LinearDirection dir, int st) {
        this.dir = dir;
        this.st = st;
    }
    
    /**
     * Executes the Turn Instruction. The ant will turn in the direction specified (Left or Right).
     * @return The next state to be executed.
     */
    @Override
    public int execute(World w, Position p, Cell c, Ant a) {
        switch(dir) {
            case Left: a.setDirection((a.getDirection() - 1) % 6);
                break;
            case Right: a.setDirection((a.getDirection() + 1) % 6);
                break;
        }
        return st;
    }

    public LinearDirection getDir() {
        return dir;
    }

    public int getSt() {
        return st;
    }
    
}
