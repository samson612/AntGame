package group16.antgame.ant;

/**
 * The Direction class provides 6 public static final integers that denote the directions that an an can take to an adjacent cell on the board. This class makes it easier to work with the hexagonal directions and prevents InvalidDirectionExcpetions being thrown elsewhere.
 * @author Group 16
 * @version 14/04/2016
 */
public class Direction {
    
    /**
     * This integer represents the East direction.
     */
    public static final int EAST = 0;
    
    /**
     * This integer represents the Southeast direction.
     */
    public static final int SOUTHEAST = 1;
    
    /**
     * This integer represents the Southwest direction.
     */
    public static final int SOUTHWEST = 2;
    
    /**
     * This integer represents the West direction.
     */
    public static final int WEST = 3;
    
    /**
     * This integer represents the Northwest direction.
     */
    public static final int NORTHWEST = 4;

    /**
     * This integer represents the Northeast direction.
     */
    public static final int NORTHEAST = 5;
    
    /**
     * Returns the new direction if an ant is facing in a certain direction and turns left or right.
     * @param lr Left or Right - the direction that the ant turns.
     * @param direction The initial direction that the ant is facing.
     * @return The new direction the ant would be facing if it turned left or right.
     */
    public static int turn(LinearDirection lr, int direction) {
        switch (lr) {
            case Left:
                return (direction+5) % 6;
            case Right:
                return (direction+1) % 6;
            default:
                return -1;
        }
    }
    
}
