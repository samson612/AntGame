package group16.antgame.ant;

/**
 * The UndefinedStateException is thrown when the user specifies a state integer that has not yet been defined.
 * @author Dan
 */
public class UndefinedStateException extends Exception {
    
    /**
     * The constructor creates a new UndefinedStateException with a predefined message.
     */
    public UndefinedStateException() {
        super("The state integer supplied is not a valid state that has been inputted by the user's Finite State Machine.");
    }
    
}
