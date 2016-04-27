package group16.antgame.world;

/**
 * The Position class denotes an (x, y) coordinate within a generated world.
 * @author Group 16
 * @version 24/03/2016
 */
public class Position {
    
    /**
     * The x-coordinate of this position.
     */
    private int x;
    
    /**
     * The y-coordinate of this position.
     */
    private int y;
    
    /**
     * Creates a new position.
     * @param x The x-coordinate of the position.
     * @param y The y-coordinate of the position.
     */
    public Position(int x, int y) {
        this.x = x;
        this.y = y;
    }
    
    /**
     * Sets the position to have new x and y values.
     * @param x The new x-coordinate of this position.
     * @param y The new y-coordinate of this position.
     */
    public void setPosition(int x, int y) {
        this.x = x;
        this.y = y;
    }
    
    /**
     * Gets the x-coordinate of this position.
     * @return The x-coordinate of this position.
     */
    public int getPositionX() {
        return x;
    }
    
    
    /**
     * Gets the y-coordinate of this position.
     * @return The y-coordinate of this position.
     */
    public int getPositionY() {
        return y;
    }
    
}
