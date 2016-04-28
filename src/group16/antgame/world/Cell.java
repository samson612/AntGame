package group16.antgame.world;

import group16.antgame.ant.Ant;
import group16.antgame.ant.Colour;
import group16.antgame.ant.Condition;
import group16.antgame.ant.Direction;
import group16.antgame.ant.LinearDirection;
import group16.antgame.ant.SenseDirection;
import group16.antgame.ant.InvalidDirectionException;

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
     * Char to store the  cell specifiers
     */
    private char specifier;
    
    /**
     * Int to store the number of food at this cell
     */
    private int numOfFood;
    
    private boolean[] Red_Marker;
    
    private boolean[] Black_Marker;
    /**
     * Position to store the position of this cell
     */
    private Position pos;
    
    private Ant antAtThisCell;
    /**
     * Instantiate a new Cell with a specifier (Rocky, Clear, Anthill etc.)
     * @param specifier The char specifier for the new cell.
     * @param numOfFood 
     */
    
    public Cell(char specifier,int numOfFood){
        this.specifier = specifier;
        this.numOfFood = numOfFood;
        this.Red_Marker = new boolean[] {false,false,false,false,false,false};
        this.Black_Marker = new boolean[]{false,false,false,false,false,false};
    }
    
    /**
     * Determines whether the current cell is rocky.
     * @return True if the current cell is rocky, false otherwise.
     */
    public boolean isRocky() {
        return (specifier == ROCKY);
    }
    
    
    /**
     * Determines whether the current cell has an ant in it.
     * @return True if there is an ant in the cell, false otherwise.
     */
    public boolean occupiesAnt() {
        return !(antAtThisCell == null);
    }
    
    /**
     * Returns the ant that is in the current cell.
     * @return The ant that is in the current cell.
     */
    public Ant occupyingAnt() {
        return antAtThisCell;
    }
    
    /**
     * Returns the number of food particles in the current cell.
     * @return The number of food particles in the current cell.
     */
    public int getNumOfFood() {
        return numOfFood;
    }
    
    /**
     * Determines whether the current cell is an anthill.
     * @param c The colour that the possible anthill could be.
     * @return True if there is an anthill of colour c in the current cell, false otherwise.
     */
    public boolean isAnthill(Colour c) {
        switch(c){
            case Red:  return (specifier == RED_ANTHILL);
            case Black: return (specifier == BLACK_ANTHILL);
            default: throw new RuntimeException("Undefined Colour");
        }       
    }
    
    /**
     * Places an Ant in the current cell.
     * @param ant The Ant to be placed in the current cell.
     */
    public void setAnt(Ant ant) {
        this.antAtThisCell = ant;
    }
    
    /**
     * Clears the Ant in the current cell.
     */
    public void clearAnt() {
        this.antAtThisCell =null;
    }
    
    /**
     * Kills the Ant in the current cell
     */
    public void killAnt() {
        clearAnt();
    }
    
    /**
     * Set the number of food particles in the current cell.
     * @param food The desired number of food particles to go in the current cell.
     */
    public void setFood(int food) {
        this.numOfFood = food;
    }
    
    public Colour other_color(Colour c)
    {
        if(c == Colour.Red)
            return Colour.Black;
        else
            return Colour.Red;
    }

    public void set_marker(Colour c, int Marker)
    {
        if(c == Colour.Red)
            this.Red_Marker[Marker] = true;
        else 
            this.Black_Marker[Marker] = true;
    }
    
    public void clear_marker(Colour c, int Marker)
    {
        if(c == Colour.Red)
            this.Red_Marker[Marker] = false;
        else 
            this.Black_Marker[Marker] = false;
    }
    
    public boolean check_marker(Colour c, int Marker)
    {
        if(c == Colour.Red)
            return Red_Marker[Marker];
        else 
            return Black_Marker[Marker];
    }
    
    public boolean check_any_marker(Colour c)
    {
        if(c == Colour.Red)
        {
            for(int i = 0; i<6; i++)
                if (Red_Marker[i])
                    return true;
        }
        else 
        {
            for(int i = 0; i<6; i++)
                if (Black_Marker[i])
                    return true;
        }
            return false;
    }
    @Override
     public String toString()
     {
        if(!(isAnthill(Colour.Red)||isAnthill(Colour.Black))&&this.numOfFood > 0)
            return "" + this.numOfFood;
        return "" + specifier;
     }

}
