/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package group16.antgame.ant;

/**
 *
 * @author Dan
 */
public class InvalidIntegerException extends AntBrainParseException {
    
    public InvalidIntegerException(int lineNo) {
        super(lineNo, "The integer parameter on line "+lineNo+" is not a vlaid integer or was incorrectly formed.");
    }
    
}
