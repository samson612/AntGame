package group16.antgame.world;

import group16.antgame.ant.Ant;
import group16.antgame.ant.Colour;
import group16.antgame.ant.Condition;
import group16.antgame.ant.SenseDirection;

/**
 * The Cell class is used to model a single part of the World. This class provides methods to distinguish what is held on each cell.
 * @author Group 16
 * @version 24/03/2016
 */
public class Cell {
    
    /**
     * Char used to instantiate a cell that will be Rocky.
     */
    public static final char ROCKY = '#';
    
    /**
     * Char used to instantiate an empty cell.
     */
    public static final char CLEAR = '.';
    
    /**
     * Char used to instantiate a cell that's part of a Red Anthill.
     */
    public static final char RED_ANTHILL = '+';
    
    /**
     * Char used to instantiate a cell that's part of a Black Anthill.
     */
    public static final char BLACK_ANTHILL = '-';
    
    /**
     * Instantiate a new Cell with a specifier (Rocky, Clear, Anthill etc.)
     * @param specifier The char specifier for the new cell.
     */
    public Cell(char specifier) {
        throw new UnsupportedOperationException("Need to implement this!");
    }
    
    /**
     * Generate a regular cell with the specified number of food particles.
     * @param numOfFood 
     */
    public Cell(int numOfFood) {
        throw new UnsupportedOperationException("Need to implement this!");
    }

    /**
     * Checks whether the condition holds true in the current cell.
     * @param condition The condition that is to be checked.
     * @param colour The colour of the ant that is checking the condition.
     * @return True if the condition holds true, false otherwise.
     */
    public boolean matches(Condition condition, Colour colour) {
        throw new UnsupportedOperationException("Need to implement this!");
    }
    
    /**
     * Returns the adjacent cell in the specified direction.
     * @param direction The direction to get the adjacent cell from.
     * @return The adjacent cell in the direction specified.
     */
    public Cell adjacentCell(int direction) {
        throw new UnsupportedOperationException("Need to implement this!");
    }
    
    /**
     * Returns the cell that an ant can sense given the direction it is facing and the sense direction it has.
     * @param direction The direction the ant is facing.
     * @param senseDir The sense direction the ant is paying attention to.
     * @return The cell an ant can sense given the direction it is facing and the sense direction. 
     */
    public Cell sensedCell(int direction, SenseDirection senseDir) {
        throw new UnsupportedOperationException("Need to implement this!");
    }
    
    /**
     * Determines whether the current cell is rocky.
     * @return True if the current cell is rocky, false otherwise.
     */
    public boolean isRocky() {
        throw new UnsupportedOperationException("Need to implement this!");
    }
    
    
    /**
     * Determines whether the current cell has an ant in it.
     * @return True if there is an ant in the cell, false otherwise.
     */
    public boolean occupiesAnt() {
        throw new UnsupportedOperationException("Need to implement this!");
    }
    
    /**
     * Returns the ant that is in the current cell.
     * @return The ant that is in the current cell.
     */
    public Ant occupyingAnt() {
        throw new UnsupportedOperationException("Need to implement this!");
    }
    
    /**
     * Returns the number of food particles in the current cell.
     * @return The number of food particles in the current cell.
     */
    public int numOfFood() {
        throw new UnsupportedOperationException("Need to implement this!");
    }
    
    /**
     * Determines whether the current cell is an anthill.
     * @param c The colour that the possible anthill could be.
     * @return True if there is an anthill of colour c in the current cell, false otherwise.
     */
    public boolean isAnthill(Colour c) {
        throw new UnsupportedOperationException("Need to implement this!");
    }
    
    /**
     * Places an Ant in the current cell.
     * @param a The Ant to be placed in the current cell.
     */
    public void setAnt(Ant a) {
        throw new UnsupportedOperationException("Need to implement this!");
    }
    
    /**
     * Clears the Ant in the current cell.
     */
    public void clearAnt() {
        throw new UnsupportedOperationException("Need to implement this!");
    }
    
    /**
     * Kills the Ant in the current cell, turning it into food.
     */
    public void killAnt() {
        throw new UnsupportedOperationException("Need to implement this!");
    }
    
    /**
     * Set the number of food particles in the current cell.
     * @param food The desired number of food particles to go in the current cell.
     */
    public void setFood(int food) {
        throw new UnsupportedOperationException("Need to implement this!");
    }

    /**
     * Finds the number of ants of a certain colour that are adjacent to the current cell.
     * @param c The colour of ants to count.
     * @return The number of ants of colour c that are adjacent to the current cell.
     */
    public int adjacentAnts(Colour c) {
        throw new UnsupportedOperationException("Need to implement this!");
    }
    
    /**
     * Checks if there is an ant at position p that is surrounded. If there is a surrounded ant there, then it dies and turns into food.
     */
    public void checkForSurroundedAnt() {
        throw new UnsupportedOperationException("Need to implement this!");
    }
    
    /**
     * Checks for surrounded ants in the current cell and all adjacent cells, and kills them if they exist.
     */
    public void checkForSurroundedAnts() {
        throw new UnsupportedOperationException("Need to implement this!");
    }
    
}
