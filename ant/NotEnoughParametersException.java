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
public class NotEnoughParametersException extends AntBrainParseException {
    
    public NotEnoughParametersException(int lineNo) {
        super(lineNo, "There were not enough parameters given for the instruction on line "+lineNo+".");
    }
    
}
