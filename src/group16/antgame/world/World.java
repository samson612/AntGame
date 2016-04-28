package group16.antgame.world;

import group16.antgame.ant.Ant;
import group16.antgame.ant.AntBrain;
import group16.antgame.ant.Colour;
import group16.antgame.ant.Condition;
import group16.antgame.ant.Direction;
import group16.antgame.ant.InvalidDirectionException;
import group16.antgame.ant.LinearDirection;
import group16.antgame.ant.SenseDirection;

import java.util.Random;
import java.util.ArrayList;
/**
 * The World class represents the virtual world within which the ants live. This class provides lots of methods that give detailed information about cells.
 * @author Group 16
 * @version 24/03/2016
 */
public class World {
    
    /**
     * The cells 2 dimensional array holds all of the cells of the World.
     */
    private Cell[][] cells;
    private int MAX_X;
    private int MAX_Y;
    private int BLOB_N;
    private int BLOB_X;
    private int BLOB_Y;
    private int BLOB_F;
    private int ROCK;
    private int ANTHILL_LENGTH;
    /**
     * Creates a new World by passing a String which represents the world and 2 Ant Brains.  The String determines the size of the world and the contents of each cell.
     * @param world The String that represents the World.
     * @param RedAntBrain Ant Brain for Red colour ant
     * @param BlackAntBrain Ant Brain for Black colour ant
     */
    public World(String world,AntBrain RedAntBrain, AntBrain BlackAntBrain)
    {
        String[] cellSpecifiers = world.split("\n");
        this.MAX_X = Integer.parseInt(cellSpecifiers[0]);
        this.MAX_Y = Integer.parseInt(cellSpecifiers[1]);
        this.cells = new Cell[MAX_X][MAX_Y];
        
        for(int y = 2; y < MAX_Y + 2; y++)
        {
            for(int x = 0; x < MAX_X; x++)
            {
                if(Character.getNumericValue(cellSpecifiers[y].charAt((x*2) + y%2)) == -1)
                    this.cells[x][y-2] = new Cell(cellSpecifiers[y].charAt((x*2) + y%2),0);
                else
                    this.cells[x][y-2] = new Cell('.',Character.getNumericValue(cellSpecifiers[y].charAt((x*2) + y%2)));
            }
        }
        //assign ants to it's own colour Anhill
        for(int y = 0; y < MAX_Y; y++)
            for(int x = 0; x < MAX_X; x++)
            {
                if(this.cells[x][y].isAnthill(Colour.Red))
                    this.cells[x][y].setAnt(new Ant(RedAntBrain, Colour.Red));
                else if(this.cells[x][y].isAnthill(Colour.Black))
                    this.cells[x][y].setAnt(new Ant(BlackAntBrain, Colour.Black));
            }
    }
    
    /**
     * Creates a new World using inputting parameter 
     * @param max_x
     * @param max_y
     * @param blob_n
     * @param blob_x
     * @param blob_y
     * @param blob_f
     * @param rock
     * @param anthill_length
     * @param RandomSeed
     * @throws InvalidDirectionException 
     */
    public World(int max_x,int max_y, int blob_n, int blob_x,int blob_y, int blob_f, int rock, int anthill_length,int RandomSeed) throws InvalidDirectionException{
        Random randX = new Random();
        Random randY = new Random(RandomSeed);
        this.MAX_X = max_x;
        this.MAX_Y = max_y;
        this.BLOB_N = blob_n;
        this.BLOB_X = blob_x;
        this.BLOB_Y = blob_y;
        this.BLOB_F = blob_f;
        this.ROCK = rock;
        this.ANTHILL_LENGTH = anthill_length;
        this.cells = new Cell[MAX_X][MAX_Y];
        
        //create Rocky cells on world's perimeter
        for(int i = 0; i < MAX_X; i++)
        {
            this.cells[i][0] = new Cell('#',0);
            this.cells[i][MAX_Y-1] = new Cell('#',0);
        }
        for(int i = 0; i < MAX_Y; i++)
        {
            this.cells[0][i] = new Cell('#',0);
            this.cells[MAX_X-1][i] = new Cell('#',0);
        }
        
        //create clear cells in the world
        for(int i = 1; i < MAX_X-1; i++)
            for(int j = 1; j < MAX_Y-1; j++)
                this.cells[i][j] = new Cell('.',0);
        
        //create  Red Anthill cells (hexagons with sides of length 7)
        int redAntHill_x = randX.nextInt(MAX_X - (ANTHILL_LENGTH + 1) * 2) + ANTHILL_LENGTH + 1;
        int redAntHill_y = randY.nextInt(MAX_Y - (ANTHILL_LENGTH + 1) * 2) + ANTHILL_LENGTH + 1;
        for(Position p : hexagon(ANTHILL_LENGTH,redAntHill_x,redAntHill_y))
            this.cells[p.getPositionX()][p.getPositionY()] = new Cell('+',0); 
        
        //create  Black Anthill cells (hexagons with sides of length 7)
        boolean overlap;
        int blackAntHill_x;
        int blackAntHill_y;
        do{
                overlap = false;
                blackAntHill_x = randX.nextInt(MAX_X - 16) + 8;
                blackAntHill_y = randY.nextInt(MAX_Y - 16) + 8;
                for(Position p : hexagon(ANTHILL_LENGTH*2,redAntHill_x,redAntHill_y))
                    if(p.getPositionX() == blackAntHill_x)
                        if(p.getPositionY() == blackAntHill_y)
                            overlap = true;
        } while (overlap);
        for(Position p : hexagon(ANTHILL_LENGTH,blackAntHill_x,blackAntHill_y))
            this.cells[p.getPositionX()][p.getPositionY()] = new Cell('-',0);
        
        //create BLOB_N(11) blobs of food with 5x5 rectangle
        int blob_X;
        int blob_Y;      
        ArrayList<Position> listOfPosition;
        for(int blob = 0; blob < BLOB_N; blob++)
        {
            do{
                overlap = false;      
                listOfPosition = new ArrayList<>();
                blob_X = randX.nextInt(MAX_X - BLOB_X - 3) + 2;
                blob_Y = randY.nextInt(MAX_Y - BLOB_Y - 3) + 2;
                for(int x = 0; x < BLOB_X; x++)
                    for(int y = 0; y < BLOB_Y; y++)
                        listOfPosition.add(new Position(blob_X + x, blob_Y + y));
                for(Position p : listOfPosition)
                    if(getCellAt(p).isAnthill(Colour.Black) || getCellAt(p).isAnthill(Colour.Red) || getCellAt(p).getNumOfFood() > 0)
                        overlap = true;
                }while(overlap);
                for(Position p : listOfPosition)
                    this.cells[p.getPositionX()][p.getPositionY()].setFood(BLOB_F);
        }
        
        //create ROCK(14) rocky cells
        int rock_X;
        int rock_Y;
        Position rockP;
        Cell[] AdCell;
        for(int r = 0; r < ROCK; r++)
        {
            do{
                overlap = false;
                rock_X = randX.nextInt(MAX_X - 4) + 2;
                rock_Y = randY.nextInt(MAX_Y - 4) + 2;
                rockP = new Position(rock_X,rock_Y);
                AdCell = new Cell[7];
                for(int d = 0; d < 6; d++)
                    AdCell[d] = getCellAt(adjacentCell(rockP,d));
                AdCell[6] = getCellAt(rockP);
                for(int i = 0; i < 7; i++)
                    if(AdCell[i].isRocky() || AdCell[i].isAnthill(Colour.Red) || AdCell[i].isAnthill(Colour.Black) || AdCell[i].getNumOfFood() > 0)
                        overlap = true;
            }while(overlap);
            this.cells[rock_X][rock_Y] = new Cell('#',0);
        }           
    }
    /**
     * Find the area of a hexagon with a given side length
     * @param sideLength
     * @param CenterX x-cood of Center 
     * @param CenterY y-cood of Center
     * @return ArrayList<Position> which represent all position of that hexagon 
     */
    private ArrayList<Position> hexagon(int sideLength, int CenterX, int CenterY)
    {
        ArrayList<Position> listOfPosition = new ArrayList<>();
        listOfPosition.add(new Position(CenterX,CenterY));
        for(int x = 1; x < sideLength; x++)
        {
            listOfPosition.add(new Position(CenterX + x,CenterY));
            listOfPosition.add(new Position(CenterX - x,CenterY));
        }
         for(int y = 1; y < sideLength; y ++)
        {
            listOfPosition.add(new Position(CenterX,CenterY + y));
            listOfPosition.add(new Position(CenterX,CenterY - y));
        }
         int k = 0;
         for(int y = 1; y < sideLength; y++)
         {
            for(int x = 1; x < sideLength - k; x++)
            {
                if(x == (sideLength - k - 1) && y%2 == 1)
                {
                    if(CenterY%2 == 0)
                    {
                        listOfPosition.add(new Position(CenterX - x,CenterY + y));
                        listOfPosition.add(new Position(CenterX - x,CenterY - y));
                    }else
                    { 
                        listOfPosition.add(new Position(CenterX + x,CenterY + y));
                        listOfPosition.add(new Position(CenterX + x,CenterY - y));
                    }
                }else      
                {
                    listOfPosition.add(new Position(CenterX + x,CenterY + y));
                    listOfPosition.add(new Position(CenterX + x,CenterY - y));          
                    listOfPosition.add(new Position(CenterX - x,CenterY + y));
                    listOfPosition.add(new Position(CenterX - x,CenterY - y));                   
                }
            }
            k += y%2;
         }
        return listOfPosition;
    }
    /**
     * Simulates a single step for a given Ant.
     * @param antId The ID of the ant to simulate.
     */
    public void step(int antId) {
        if(isAlive(antId))
        {
            Position p = findAnt(antId);
            Ant a = getCellAt(p).occupyingAnt();
            if(a.getResting() > 0)
                a.setResting(a.getResting() - 1);
            else
                a.getCurrentInstruction().execute(this,p,getCellAt(p), a);
        }
    }
    
    /**
     * Returns the cell at position p.
     * @param p The position of the desired cell.
     * @return The cell at position p.
     */
    public Cell getCellAt(Position p) {
        return cells[p.getPositionX()][p.getPositionY()];
    }
     /**
     * Checks whether the condition holds true in the current cell.
     * @param pos   The position to get the adjacent cell from.
     * @param condition The condition that is to be checked.
     * @param colour The colour of the ant that is checking the condition.
     * @param marker 
     * @return True if the condition holds true, false otherwise.
     */
    public boolean matches(Position pos, Condition condition, Colour colour, int marker) {
        Cell c = getCellAt(pos);
        if(c.isRocky())
            return (condition == Condition.Rock);
        else
            switch(condition)
            {
                case Friend: return (c.occupiesAnt() && c.occupyingAnt().getColour() == colour);
                case Foe: return (c.occupiesAnt() && c.occupyingAnt().getColour() != colour);
                case FriendWithFood: return (c.occupiesAnt() && c.occupyingAnt().getColour() == colour && c.occupyingAnt().hasFood());
                case FoeWithFood: return (c.occupiesAnt() && c.occupyingAnt().getColour() != colour && c.occupyingAnt().hasFood());
                case Food: return (c.getNumOfFood() > 0);
                case Rock: return false;
                case Marker: return c.check_marker(colour,marker);
                case FoeMarker: return c.check_any_marker(c.other_color(colour));
                case Home: return c.isAnthill(colour);
                case FoeHome: return c.isAnthill(c.other_color(colour));
                default: throw new RuntimeException("Undefined condition");
            }
    }
    /**
     * Returns the adjacent cell in the specified direction.
     * @param pos The position to get the adjacent cell from.
     * @param direction The direction to get the adjacent cell from.
     * @return The adjacent cells position in the direction specified.
     * @throws group16.antgame.ant.InvalidDirectionException
     */
    public Position adjacentCell(Position pos, int direction) throws InvalidDirectionException {
        int x = pos.getPositionX();
        int y = pos.getPositionY();
        switch(direction){
            case 0: return new Position(x+1,y);
            case 1: if(y%2 == 0)
                            return new Position(x,y+1);
                        else
                            return new Position(x+1,y+1);
            case 2: if(y%2 == 0)
                            return new Position(x-1, y+1);
                        else
                            return new Position(x, y+1);
            case 3: return new Position(x-1, y);
            case 4: if(y%2 == 0)
                            return new Position(x-1, y-1);
                        else
                            return new Position(x, y-1);
            case 5:  if(y%2 == 0)
                            return new Position(x, y-1);
                        else
                            return new Position(x+1, y-1);       
            default: throw new InvalidDirectionException();
        }       
    }
    
    /**
     * Returns the cell that an ant can sense given the direction it is facing and the sense direction it has.
     * @param pos The position of this cell
     * @param direction The direction the ant is facing.
     * @param senseDir The sense direction the ant is paying attention to.
     * @return The position of the cell an ant can sense given the direction it is facing and the sense direction. 
     */
    public Position sensedCell(Position pos, int direction, SenseDirection senseDir) throws InvalidDirectionException {
        switch(senseDir){
            case Here: return pos;
            case Ahead: return adjacentCell(pos, direction);
            case LeftAhead: return adjacentCell(pos, Direction.turn(LinearDirection.Left,direction));
            case RightAhead: return adjacentCell(pos, Direction.turn(LinearDirection.Right,direction));
            default: throw new RuntimeException("Undefined SenseDirection");
        }
    }
    /**
     * Given an ant id, returns a boolean showing if the ant is alive or not.
     * @param antId The ant that may or may not be alive.
     * @return True if the ant is alive, false otherwise.
     */
    public boolean isAlive(int antId) {
        for(int i = 0; i < MAX_X; i++)
            for(int j = 0; j < MAX_Y; j++)
            {
                Cell c = getCellAt(new Position(i,j));
                if(c.occupiesAnt())
                    if(c.occupyingAnt().getId() == antId)
                        return true;
            }
        return false;
    }
    
    /**
     * Finds the position of an ant with the ID antID.
     * @param antId The ID of the ant that is to be found.
     * @return The Position of the ant.
     */
    public Position findAnt(int antId) {
        for(int i = 0; i < MAX_X; i++)
            for(int j = 0; j < MAX_Y; j++)
            {
                Cell c = getCellAt(new Position(i,j));
                if(c.occupiesAnt())
                    if(c.occupyingAnt().getId() == antId)
                        return new Position(i,j);
            }
        throw new RuntimeException("Ant not found");
    }
        /**
     * Finds the number of ants of a certain colour that are adjacent to the current cell.
     * @param p The position of an ant.
     * @param c The colour of ants to count.
     * @return The number of ants of colour c that are adjacent to the current cell.
     * @throws group16.antgame.ant.InvalidDirectionException
     */
    public int adjacentAnts(Position p, Colour c) throws InvalidDirectionException {
        int n = 0;
        for(int d = 0; d <= 5; d++)
        {
            Cell cel = getCellAt(adjacentCell(p,d));
            if(cel.occupiesAnt() && cel.occupyingAnt().getColour() == c)
                n++;
        }
        return n;
    }
    
    /**
     * Checks if there is an ant at position p that is surrounded. If there is a surrounded ant there, then it dies and turns into food.
     * @param p The position of an ant.
     * @throws group16.antgame.ant.InvalidDirectionException
     */
    public void checkForSurroundedAntAt(Position p) throws InvalidDirectionException {
         Cell cel = getCellAt(p);
         if(cel.occupiesAnt())
         {
             Ant a = cel.occupyingAnt();
             if(adjacentAnts(p, cel.other_color(a.getColour())) >= 5)
             {
                 cel.killAnt();
                 int food = cel.getNumOfFood() + 3;
                 if (a.hasFood())
                     food += 1;
                 cel.setFood(food);
             }
         }
    }
    
    /**
     * Checks for surrounded ants in the current cell and all adjacent cells, and kills them if they exist.
     * @param p The position of an ant.
     * @throws group16.antgame.ant.InvalidDirectionException
     */
    public void checkForSurroundedAnts(Position p) throws InvalidDirectionException {
       checkForSurroundedAntAt(p);
        for(int d = 0; d <=5; d++)
            checkForSurroundedAntAt(adjacentCell(p,d));
    }
    /**
     * Override the toString method to store the cell in the world as String
     * @return String StringWorld Present the world as String
     */
    @Override
    public String toString()
    {
        String StringWorld = "";
        StringWorld += MAX_X + "\r\n" + MAX_Y + "\r\n";
        for(int y = 0; y < MAX_Y; y++)
        {
            if(y%2 != 0)
                StringWorld += " ";
            for(int x = 0; x < MAX_X; x++)
                StringWorld += cells[x][y].toString() + " ";
            StringWorld += "\r\n"; 
        }
        return StringWorld;
    }
    /* testing only
    public static void main(String[] arg) throws InvalidDirectionException
    {
        World world1 = new World();
        String worldMap = world1.toString();
        System.out.println(worldMap);
        World world2 = new World(worldMap);
        String worldMap2 = world2.toString();
        System.out.println(worldMap2);
        System.out.println(worldMap.compareTo(worldMap2));
    }
    */
}
    