package group16.antgame.ant;

import group16.antgame.ant.instructions.Instruction;

/**
 * The Ant class holds all information about a separate ant in the game, including its "brain".
 * @author Group 16
 * @version 24/03/2016
 */
public class Ant {
    
    /**
     * The id of the latest ant to be made. Every time an Ant is created, this is incremented.
     */
    private static int currId = 0;
    
    /**
     * The id of an ant is its unique identifier.
     */
    private int id;
    
    /**
     * The colour of this ant (either Red or Black).
     * @see Colour
     */
    private Colour colour;
    
    /**
     * The current state that the ant is in.
     */
    private int currentState;
    
    /**
     * The set of Instructions that this ant uses to make decisions.
     * @see Instruction
     */
    private Instruction[] states;
    
    /**
     * The resting component that keeps track of how long an ant has to rest after its last move before any other action.
     */
    private int resting;
    
    /**
     * The current direction that the ant is facing in.
     */
    private int direction;
    
    /**
     * A boolean indicating whether the ant is currently carrying a food particle.
     */
    private boolean  hasFood;
    
    /**
     * Construct a new ant given a "brain", with an automatically assigned id.
     * @param antBrain The finite state machine that acts as the Ant "brain" that determines the actions it takes.
     */
    public Ant(String antBrain) {
        this.id = currId;
        // Parse Finite State Machine here
        currId++;
    }
    
    /**
     * Get the current state of the Ant.
     * @return The current state of the Ant.
     */
    public int getState() {
        return currentState;
    }
    
    /**
     * Get the colour of the Ant.
     * @return The colour of the Ant.
     */
    public Colour getColour() {
        return colour;
    }
    
    /**
     * Get the resting time left of the ant.
     * @return The remaining resting time of the ant.
     */
    public int getResting() {
        return resting;
    }
    
    /**
     * Get the direction that the ant is facing.
     * @return The direction in which the ant is facing.
     */
    public int getDirection() {
        return direction;
    }
    
    /**
     * Determines whether the ant is holding food or not.
     * @return true if the ant is holding food, false otherwise.
     */
    public boolean hasFood() {
        return hasFood;
    }
    
    /**
     * Set the current state of the ant.
     * @param state Integer of the desired current state.
     */
    public void setState(int state) {
        currentState = state;
    }
    
    /**
     * Set the resting time for an ant.
     * @param resting The number of rounds the ant must rest.
     */
    public void setResting(int resting) {
        this.resting = resting;
    }
    
    /**
     * Set the direction the ant should be facing.
     * @param direction The direction that the ant should face.
     */
    public void setDirection(int direction) {
        this.direction = direction;
    }
    
    /**
     * Set whether an ant is holding food or not.
     * @param hasFood Boolean to show if the ant should be holding food or not. Set true if holding food, false otherwise.
     */
    public void setHasFood(boolean hasFood) {
        this.hasFood = hasFood;
    }
}
