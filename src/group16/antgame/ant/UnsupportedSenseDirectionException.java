package group16.antgame.ant;

/**
 * The UndefinedStateException is thrown when the user specifies a state integer that has not yet been defined.
 * @author Dan
 */
public class UnsupportedSenseDirectionException extends AntBrainParseException {
    
    /**
     * The constructor creates a new UndefinedStateException with a predefined message.
     */
    public UnsupportedSenseDirectionException(int lineNo) {
        super(lineNo, "The sense direction parameter on line "+lineNo+" is not a valid sense direction.");
    }
    
}
