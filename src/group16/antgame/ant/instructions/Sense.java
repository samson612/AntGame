package group16.antgame.ant.instructions;

import group16.antgame.ant.Ant;
import group16.antgame.ant.Colour;
import group16.antgame.ant.Condition;
import group16.antgame.ant.SenseDirection;
import group16.antgame.world.Cell;
import group16.antgame.world.Position;
import group16.antgame.world.World;

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
    public int execute(World w, Position p, Cell c, Ant a) {
        Cell sensedCell = w.getCellAt(w.sensedCell(p, a.getDirection(), dir));
        boolean conditionMet = false;
        if(cond == Condition.Friend) {
            if(sensedCell.occupiesAnt() && sensedCell.occupyingAnt().getColour() == a.getColour()) {
                conditionMet = true;
            }
            else {
                conditionMet = false;
            }
        }
        else if(cond == Condition.Foe) {
            if(sensedCell.occupiesAnt() && sensedCell.occupyingAnt().getColour() != a.getColour()) {
                conditionMet = true;
            }
            else {
                conditionMet = false;
            }
        }
        else if(cond == Condition.FriendWithFood) {
            if(sensedCell.occupiesAnt() && sensedCell.occupyingAnt().getColour() == a.getColour() && sensedCell.occupyingAnt().hasFood()) {
                conditionMet = true;
            }
            else {
                conditionMet = false;
            }
        }
        else if(cond == Condition.FoeWithFood) {
            if(sensedCell.occupiesAnt() && sensedCell.occupyingAnt().getColour() != a.getColour() && sensedCell.occupyingAnt().hasFood()) {
                conditionMet = true;
            }
            else {
                conditionMet = false;
            }
        }
        else if(cond == Condition.Food) {
            if(sensedCell.getNumOfFood() > 0) {
                conditionMet = true;
            }
            else {
                conditionMet = false;
            }
        }
        else if(cond == Condition.Rock) {
            if(sensedCell.isRocky()) {
                conditionMet = true;
            }
            else {
                conditionMet = false;
            }
        }
        else if(cond == Condition.Marker) {
            if(sensedCell.check_any_marker(a.getColour())) {
                conditionMet = true;
            }
            else {
                conditionMet = false;
            }
        }
        else if(cond == Condition.FoeMarker) {
            if(sensedCell.check_any_marker(Colour.oppositeColour(a.getColour()))) {
                conditionMet = true;
            }
            else {
                conditionMet = false;
            }
        }
        else if(cond == Condition.Home) {
            if(sensedCell.isAnthill(a.getColour())) {
                conditionMet = true;
            }
            else {
                conditionMet = false;
            }
        }
        else if(cond == Condition.FoeHome) {
            if(sensedCell.isAnthill(Colour.oppositeColour(a.getColour()))) {
                conditionMet = true;
            }
            else {
                conditionMet = false;
            }
        }
        
        if(conditionMet) {
            return st1;
        }
        else {
            return st2;
        }
        
    }

    public SenseDirection getDir() {
        return dir;
    }

    public int getSt1() {
        return st1;
    }

    public int getSt2() {
        return st2;
    }

    public Condition getCond() {
        return cond;
    }
    
    
    
}
