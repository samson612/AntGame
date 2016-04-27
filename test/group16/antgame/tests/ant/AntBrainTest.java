/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package group16.antgame.tests.ant;

import group16.antgame.ant.AntBrain;
import group16.antgame.ant.AntBrainParseException;
import group16.antgame.ant.Condition;
import group16.antgame.ant.LinearDirection;
import group16.antgame.ant.SenseDirection;
import group16.antgame.ant.instructions.Drop;
import group16.antgame.ant.instructions.Flip;
import group16.antgame.ant.instructions.Instruction;
import group16.antgame.ant.instructions.Move;
import group16.antgame.ant.instructions.Sense;
import group16.antgame.ant.instructions.Turn;
import group16.antgame.ant.instructions.Unmark;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import static org.junit.Assert.assertTrue;
import org.junit.Before;
import org.junit.Test;

/**
 *
 * @author Dan
 */
public class AntBrainTest {
    
    private AntBrain ab;
    
    
    public void setUpTest1() throws IOException, FileNotFoundException, AntBrainParseException {
        File f = new File("samples/ant/sample1.ant");
        ab = new AntBrain(f);
    }
    
    public void setUpTest2() throws IOException, FileNotFoundException, AntBrainParseException {
        File f = new File("samples/ant/sample2.ant");
        ab = new AntBrain(f);
    }
    
    /**
     * Tests the finite state machine in the samples/ant/sample1.ant file.
     */
    @Test
    public void test1() throws IOException, FileNotFoundException, AntBrainParseException {
        setUpTest1();
        assertTrue(ab.getStates().size() == 3);
        Sense state0 = (Sense) ab.getStates().get(0);
        assertTrue(state0.getDir() == SenseDirection.Ahead);
        assertTrue(state0.getSt1() == 1);
        assertTrue(state0.getSt2() == 2);
        assertTrue(state0.getCond() == Condition.Friend);
        Move state1 = (Move) ab.getStates().get(1);
        assertTrue(state1.getSt1() == 0);
        assertTrue(state1.getSt2() == 0);
        Drop state2 = (Drop) ab.getStates().get(2);
        assertTrue(state2.getSt() == 1);
    }
    
    @Test
    public void test2() throws IOException, FileNotFoundException, AntBrainParseException {
        setUpTest2();
        assertTrue(ab.getStates().size() == 401);
        Unmark state65 = (Unmark) ab.getStates().get(65);
        assertTrue(state65.getMarker() == 4);
        assertTrue(state65.getSt() == 0);
        Turn state92 = (Turn) ab.getStates().get(92);
        assertTrue(state92.getDir() == LinearDirection.Right);
        assertTrue(state92.getSt() == 0);
        Flip state336 = (Flip) ab.getStates().get(336);
        assertTrue(state336.getP() == 4);
        assertTrue(state336.getSt1() == 395);
        assertTrue(state336.getSt2() == 337);
    }
    
}
