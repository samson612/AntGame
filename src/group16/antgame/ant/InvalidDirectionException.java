package group16.antgame.ant;

/**
 * The InvalidDirectionException is thrown where the user specifies a direction that is not in the range of 0-5 inclusive.
 * @author Group 16
 * @version 24/03/2016
 */
public class InvalidDirectionException extends RuntimeException {
    
    /**
     * The constructor creates a new InvalidDirectionException with a predetermined message.
     */
    public InvalidDirectionException() {
        super("Invalid Direction: Direction must be an int between 0 and 5 inclusive, or derived from the Direction class.");
    }
    
}
