package group16.antgame.ant;

/**
 * The UndefinedStateException is thrown when the user specifies a state integer that has not yet been defined.
 * @author Dan
 */
public class UndefinedStateException extends AntBrainParseException {

    /**
     * The constructor creates a new UndefinedStateException with a predefined message.
     */
    public UndefinedStateException(int lineNo) {
        super(lineNo, "The state integer supplied on line "+lineNo+" is not a valid state that has been inputted by the user's Finite State Machine.");
    }
    
}
