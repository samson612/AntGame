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
public class UnsupportedConditionException extends AntBrainParseException {
    
    public UnsupportedConditionException(int lineNo) {
        super(lineNo, "The condition parameter on line "+lineNo+" is not a valid sense direction.");
    }
    
}
