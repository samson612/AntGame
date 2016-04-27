package group16.antgame.world;

/**
 * The World class represents the virtual world within which the ants live. This class provides lots of methods that give detailed information about cells.
 * @author Group 16
 * @version 24/03/2016
 */
public class World {
    
    /**
     * The cells 2 dimensional array holds all of the cells of the World.
     */
    private Cell[][] cells;
    
    /**
     * Creates a new World given a Finite State Machine passed in by the user. This FSM determines the size of the world and the contents of each cell.
     * @param world The Finite State Machine that determines the World.
     */
    public World(String world) {
        // Parse World Finite State Machine Here
        throw new UnsupportedOperationException("Need to implement this!");
    }
    
    /**
     * Simulates a single step for a given Ant.
     * @param antId The ID of the ant to simulate.
     */
    public void step(int antId) {
        throw new UnsupportedOperationException("Need to implement this!");
    }
    
    /**
     * Returns the cell at position p.
     * @param p The position of the desired cell.
     * @return The cell at position p.
     */
    public Cell getCellAt(Position p) {
        throw new UnsupportedOperationException("This must be implemented!");
    }
    
    /**
     * Given an ant id, returns a boolean showing if the ant is alive or not.
     * @param antId The ant that may or may not be alive.
     * @return True if the ant is alive, false otherwise.
     */
    public boolean isAlive(int antId) {
        throw new UnsupportedOperationException("Need to implement this!");
    }
    
    /**
     * Finds the position of an ant with the ID antID.
     * @param antId The ID of the ant that is to be found.
     * @return The Position of the ant.
     */
    public Position findAnt(int antId) {
        throw new UnsupportedOperationException("Need to implement this!");
    }
    
}
