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
public abstract class AntBrainParseException extends Exception {
    
    private int lineNo;
    
    public AntBrainParseException(int lineNo, String message) {
        super(message);
        this.lineNo = lineNo;
    }
    
    public int getLineNo() {
        return lineNo;
    }
    
}
