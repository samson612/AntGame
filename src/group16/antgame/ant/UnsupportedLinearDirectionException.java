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
class UnsupportedLinearDirectionException extends AntBrainParseException {

    public UnsupportedLinearDirectionException(int lineNo) {
        super(lineNo, "The linear direction parameter specified on line "+lineNo+" is not valid. Please use either 'Left' or 'Right'");
    }
    
}
