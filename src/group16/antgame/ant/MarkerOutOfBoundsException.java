package group16.antgame.ant;

/**
 * The MarkerOutOfBoundsException is thrown when the user tries to specify a marker integer that does not fall within the allowed marker range (0 to 5 inclusive).
 * @author Group 16
 * @version 24/03/2016
 */
public class MarkerOutOfBoundsException extends AntBrainParseException {
    
    /**
     * Creates a new MarkerOutOfBoundsException with a predefined message.
     */
    public MarkerOutOfBoundsException(int lineNo) {
        super(lineNo, "The specified Marker on line "+lineNo+" is Out Of Bounds. Markers must be between 0 and 5 inclusive.");
    }
    
}
