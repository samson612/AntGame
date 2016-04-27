package group16.antgame.ant;

import group16.antgame.ant.instructions.Drop;
import group16.antgame.ant.instructions.Flip;
import group16.antgame.ant.instructions.Instruction;
import group16.antgame.ant.instructions.Mark;
import group16.antgame.ant.instructions.Move;
import group16.antgame.ant.instructions.PickUp;
import group16.antgame.ant.instructions.Sense;
import group16.antgame.ant.instructions.Turn;
import group16.antgame.ant.instructions.Unmark;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.io.LineNumberReader;
import java.util.ArrayList;

/**
 *
 * @author Dan
 */
public class AntBrain {
    
    ArrayList<Instruction> states;
    int numStates;
    LineNumberReader lnr;
    
    /**
     * Creates a new AntBrain from a File object.
     * @param finiteStateMachine The File object that represents the file that contains the finite state machine of the ant brain.
     * @throws FileNotFoundException Thrown in the specified file cannot be found.
     * @throws IOException Thrown if an I/O error occurs.
     * @see java.io.File
     */
    public AntBrain(File finiteStateMachine) throws FileNotFoundException, IOException, UndefinedStateException, UnsupportedSenseDirectionException, UnsupportedConditionException, NotEnoughParametersException, MarkerOutOfBoundsException, InvalidIntegerException, UnsupportedLinearDirectionException {
        states = new ArrayList<Instruction>();
        numStates = numOfLines(finiteStateMachine);
        lnr = new LineNumberReader(new FileReader(finiteStateMachine));
        String currentLine = lnr.readLine();
        while(currentLine != null) {
            parseLine(currentLine);
            currentLine = lnr.readLine();
        }
    }
    
    public ArrayList<Instruction> getStates() {
        return states;
    }
    
    private String parseLine(String unparsed) throws UndefinedStateException, UnsupportedSenseDirectionException, UnsupportedConditionException, NotEnoughParametersException, MarkerOutOfBoundsException, InvalidIntegerException, UnsupportedLinearDirectionException {
        String toDoNext;
        if(unparsed.startsWith("Sense")) {
            toDoNext = unparsed.substring(6);
            parseSense(toDoNext);
        }
        else if(unparsed.startsWith("Mark")) {
            toDoNext = unparsed.substring(5);
            parseMark(toDoNext);
        }
        else if(unparsed.startsWith("Unmark")) {
            toDoNext = unparsed.substring(7);
            parseUnmark(toDoNext);
        }
        else if(unparsed.startsWith("PickUp")) {
            toDoNext = unparsed.substring(7);
            parsePickUp(toDoNext);
        }
        else if(unparsed.startsWith("Drop")) {
            toDoNext = unparsed.substring(5);
            parseDrop(toDoNext);
        }
        else if(unparsed.startsWith("Turn")) {
            toDoNext = unparsed.substring(5);
            parseTurn(toDoNext);
        }
        else if(unparsed.startsWith("Move")) {
            toDoNext = unparsed.substring(5);
            parseMove(toDoNext);
        }
        else if(unparsed.startsWith("Flip")) {
            toDoNext = unparsed.substring(5);
            parseFlip(toDoNext);
        }
        else {
            throw new UndefinedStateException(lnr.getLineNumber());
        }
        
        return toDoNext;
    }
    
    private void parseSense(String unparsed) throws UndefinedStateException, UnsupportedSenseDirectionException, UnsupportedConditionException, NotEnoughParametersException, InvalidIntegerException {
        String[] params = unparsed.split("\\s+");
        if(params.length >= 4) {
            SenseDirection senseDir = parseSenseDirection(params[0]);
            int st1 = parseState(params[1]);
            int st2 = parseState(params[2]);
            Condition cond = parseCondition(params[3]);
            Sense instruction = new Sense(senseDir, st1, st2, cond);
            states.add(instruction);
        }
        else {
            throw new NotEnoughParametersException(lnr.getLineNumber());
        }
    }
    
    private void parseMark(String unparsed) throws MarkerOutOfBoundsException, UndefinedStateException, NotEnoughParametersException, InvalidIntegerException {
        String[] params = unparsed.split("\\s+");
        if(params.length >= 2) {
            int marker = parseMarker(params[0]);
            int st = parseState(params[1]);
            Mark instruction = new Mark(marker, st);
            states.add(instruction);
        }
        else {
            throw new NotEnoughParametersException(lnr.getLineNumber());
        }
    }
    
    private void parseUnmark(String unparsed) throws MarkerOutOfBoundsException, UndefinedStateException, NotEnoughParametersException, InvalidIntegerException {
        String[] params = unparsed.split("\\s+");
        if(params.length >= 2) {
            int marker = parseMarker(params[0]);
            int st = parseState(params[1]);
            Unmark instruction = new Unmark(marker, st);
            states.add(instruction);
        }
        else {
            throw new NotEnoughParametersException(lnr.getLineNumber());
        }
    }
    
    private void parsePickUp(String unparsed) throws UndefinedStateException, NotEnoughParametersException, InvalidIntegerException {
        String[] params = unparsed.split("\\s+");
        if(params.length >= 2) {
            int st1 = parseState(params[0]);
            int st2 = parseState(params[1]);
            PickUp instruction = new PickUp(st1, st2);
            states.add(instruction);
        }
        else {
            throw new NotEnoughParametersException(lnr.getLineNumber());
        }
    }
    
    private void parseDrop(String unparsed) throws UndefinedStateException, NotEnoughParametersException, InvalidIntegerException {
        String[] params = unparsed.split("\\s+");
        if(params.length >= 1) {
            int st = parseState(params[0]);
            Drop instruction = new Drop(st);
            states.add(instruction);
        }
        else {
            throw new NotEnoughParametersException(lnr.getLineNumber());
        }
    }
    
    private void parseTurn(String unparsed) throws UnsupportedLinearDirectionException, UndefinedStateException, NotEnoughParametersException, InvalidIntegerException {
        String[] params = unparsed.split("\\s+");
        if(params.length >= 2) {
            LinearDirection lr = parseLinearDirection(params[0]);
            int st = parseState(params[1]);
            Turn instruction = new Turn(lr, st);
            states.add(instruction);
        }
        else {
            throw new NotEnoughParametersException(lnr.getLineNumber());
        }
    }
    
    private void parseMove(String unparsed) throws NotEnoughParametersException, UndefinedStateException, InvalidIntegerException {
        String[] params = unparsed.split("\\s+");
        if(params.length >= 2) {
            int st1 = parseState(params[0]);
            int st2 = parseState(params[1]);
            Move instruction = new Move(st1, st2);
            states.add(instruction);
        }
        else {
            throw new NotEnoughParametersException(lnr.getLineNumber());
        }
    }
    
    private void parseFlip(String unparsed) throws NotEnoughParametersException, InvalidIntegerException, UndefinedStateException {
        String[] params = unparsed.split("\\s+");
        if(params.length >= 3) {
            int p = parseInt(params[0]);
            int st1 = parseState(params[1]);
            int st2 = parseState(params[2]);
            Flip instruction = new Flip(p, st1, st2);
            states.add(instruction);
        }
        else {
            throw new NotEnoughParametersException(lnr.getLineNumber());
        }
    }
    
    private SenseDirection parseSenseDirection(String unparsed) throws UnsupportedSenseDirectionException {
        switch(unparsed) {
            case "Here": return SenseDirection.Here;
            case "Ahead": return SenseDirection.Ahead;
            case "LeftAhead": return SenseDirection.LeftAhead;
            case "RightAhead": return SenseDirection.RightAhead;
            default: throw new UnsupportedSenseDirectionException(lnr.getLineNumber());
        }
    }
    
    private Condition parseCondition(String unparsed) throws UnsupportedConditionException {
        switch(unparsed) {
            case "Friend": return Condition.Friend;
            case "Foe": return Condition.Foe;
            case "FriendWithFood": return Condition.FriendWithFood;
            case "FoeWithFood": return Condition.FoeWithFood;
            case "Food": return Condition.Food;
            case "Rock": return Condition.Rock;
            case "Marker": return Condition.Marker;
            case "FoeMarker": return Condition.FoeMarker;
            case "Home": return Condition.Home;
            case "FoeHome": return Condition.FoeHome;
            default: throw new UnsupportedConditionException(lnr.getLineNumber());
        }
    }
    
    private int parseState(String unparsed) throws UndefinedStateException, InvalidIntegerException {
        int state = parseInt(unparsed);
        if(state >= 0 && state < numStates) {
            return state;
        }
        else {
            throw new UndefinedStateException(lnr.getLineNumber());
        }
    }
    
    private int parseMarker(String unparsed) throws MarkerOutOfBoundsException, InvalidIntegerException {
        int marker = parseInt(unparsed);
        if(marker >= 0 && marker <= 5) {
            return marker;
        }
        else {
            throw new MarkerOutOfBoundsException(lnr.getLineNumber());
        }
    }

    private LinearDirection parseLinearDirection(String unparsed) throws UnsupportedLinearDirectionException {
        switch(unparsed) {
            case "Left": return LinearDirection.Left;
            case "Right": return LinearDirection.Right;
            default: throw new UnsupportedLinearDirectionException(lnr.getLineNumber());
        }
    }
    
    private int parseInt(String unparsed) throws InvalidIntegerException {
        try {
            return Integer.parseInt(unparsed);
        } catch(Exception e) {
            throw new InvalidIntegerException(lnr.getLineNumber());
        }
    }
    
    private int numOfLines(File f) throws FileNotFoundException, IOException {
        LineNumberReader reader = new LineNumberReader(new FileReader(f));
        String currLine = reader.readLine();
        while(currLine != null) {
            currLine = reader.readLine();
        }
        return reader.getLineNumber();
    }
    
}
