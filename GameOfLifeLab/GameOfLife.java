import info.gridworld.actor.Actor;
import info.gridworld.actor.ActorWorld;
import info.gridworld.actor.Rock;
import info.gridworld.grid.Grid;
import info.gridworld.grid.BoundedGrid;
import info.gridworld.grid.Location;
import java.util.ArrayList;

/**
 * Game of Life starter code. Demonstrates how to create and populate the game using the GridWorld framework.
 * Also demonstrates how to provide accessor methods to make the class testable by unit tests.
 * 
 * @author @gcschmit
 * @version 18 July 2014
 */
public class GameOfLife
{
    // the world comprised of the grid that displays the graphics for the game
    private ActorWorld world;
    
    // the game board will have 30 rows and 30 columns
    private final int ROWS = 30;
    private final int COLS = 30;
    

    

    /**
     * Default constructor for objects of class GameOfLife
     * 
     * @post    the game will be initialized and populated with the initial state of cells
     * 
     */
    public GameOfLife()
        throws InterruptedException
    {
        // create the grid, of the specified size, that contains Actors
        BoundedGrid<Actor> grid = new BoundedGrid<Actor>(ROWS, COLS);
        
        // create a world based on the grid
        world = new ActorWorld(grid);
        
        // populate the game
        populateGame();
        
        // display the newly constructed and populated world
       
        world.show();
        
        for(int i = 0; i<20; i++)
        {
            Thread.sleep(1000);
            createNextGeneration();
            world.show();
        }
        
    }
    
      /**
     * this constructor does everything except for updating to new generation, i.e. this is for initial state
     * 
     * @post    the game will be initialized and populated with the initial state of cells
     * 
     */
    public GameOfLife(int i)
        throws InterruptedException
    {
        // create the grid, of the specified size, that contains Actors
        BoundedGrid<Actor> grid = new BoundedGrid<Actor>(ROWS, COLS);
        
        // create a world based on the grid
        world = new ActorWorld(grid);
        
        // populate the game
        populateGame();
        
        // display the newly constructed and populated world
       
        world.show();
        
        
        
    }
    
    
    /**
     * makes it easier to hardcode in coords for rocks
     * 
     */
    private void addRock(int r, int c)
    {
         // the grid of Actors that maintains the state of the game
        //  (alive cells contains actors; dead cells do not)
        
        Grid<Actor> grid = world.getGrid();
        
        Rock rock = new Rock();
        
        Location loc = new Location(r,c);
        
        grid.put(loc,rock);
        
    }

    /**
     * 
     * uses the addRock method to quickly initialize grid rock positions
     * 
     */
    private void populateGame()
    {
        //hardcodes my starting locations
        addRock(3, 2);
        addRock(3, 3);      
        addRock(3, 4);
        
        addRock(9,18);
        addRock(9,19);
        addRock(9,20);
        addRock(9,24);
        addRock(9,25);
        addRock(9,26);
        
        addRock(11,16);
        addRock(11,21);
        addRock(11,23);
        addRock(11,28);
        
        addRock(12,16);
        addRock(12,21);
        addRock(12,23);
        addRock(12,28);
        
        addRock(13,16);
        addRock(13,21);
        addRock(13,23);
        addRock(13,28);
        
        addRock(14,18);
        addRock(14,19);
        addRock(14,20);
        addRock(14,24);
        addRock(14,25);
        addRock(14,26);
        
        addRock(16,18);
        addRock(16,19);
        addRock(16,20);
        addRock(16,24);
        addRock(16,25);
        addRock(16,26);
       
        addRock(17,16);
        addRock(17,21);
        addRock(17,23);
        addRock(17,28);
        
        addRock(18,16);
        addRock(18,21);
        addRock(18,23);
        addRock(18,28);
        
        addRock(19,16);
        addRock(19,21);
        addRock(19,23);
        addRock(19,28);
        
        addRock(21,18);
        addRock(21,19);
        addRock(21,20);
        addRock(21,24);
        addRock(21,25);
        addRock(21,26);
        
        addRock(11,7); 
        addRock(12,6);
        addRock(12,7);
        
        
    }

    /**
     * Generates the next generation based on the rules of the Game of Life and updates the grid
     * associated with the world
     *
     * @pre     the game has been initialized
     * @post    the world has been re-drawn
     * 
     */
    private void createNextGeneration()
    {
        /** You will need to read the documentation for the World, Grid, and Location classes
         *      in order to implement the Game of Life algorithm and leverage the GridWorld framework.
         */
        
        // create the grid, of the specified size, that contains Actors
        Grid<Actor> grid = world.getGrid();
        
        
        ArrayList<Location> occupied = new ArrayList(900); //initialize and set the size to 900
        ArrayList<Location> neighbors = new ArrayList(900); //initialize and set the size to 900
        ArrayList<Location> allNeighbors = new ArrayList(900); //initialize and set the size to 900
        ArrayList<Location> testSquares = new ArrayList(900); //initialize and set the size to 900
        Location testLocation = new Location(0,0); // initialize location for use in loop
        ArrayList<Location> newOccupied = new ArrayList(900); // this is a list of all locations that should be occupied next generation
         
        occupied = grid.getOccupiedLocations(); // contains all locations where a live cell is present
        testSquares = grid.getOccupiedLocations(); // live cells are valid test locations along with their neighbors (which is found later)
        
        
        for(int k = 0;k<occupied.size();k++)
        {
            neighbors = grid.getValidAdjacentLocations(occupied.get(k)); // contains all locations ajacent to a currently occupied location
            
            if (grid.getOccupiedAdjacentLocations(occupied.get(k)).size() == 2 || grid.getOccupiedAdjacentLocations(occupied.get(k)).size() == 3) // 
            {
                newOccupied.add(occupied.get(k)); // if the currently occupied location has 2 or 3 neighbors it will remain alive
            }
            
            // this loop structure finds an array of only the neighbors of occupied cell not including the occupied cell
            for(int i = 0;i<neighbors.size();i++)
            {
                testLocation = neighbors.get(i); // sets up for iteration through ajacent locations to the test location
                
                if(!(testSquares.contains(testLocation)))//if the location is not in occupied add it to the neighbors and test squares
                {
                    allNeighbors.add(testLocation); // this list contains all the neighbors of occupied locations but not the actual locations these cells need exactly 3 neighbors to be alive
                    testSquares.add(testLocation); // this list already contains all occupied locations and the only other valid test locations are their neighbors which are added here
                    
                    if(grid.getOccupiedAdjacentLocations(testLocation).size() == 3)// if the test location has 3 neighbors
                    {
                         newOccupied.add(testLocation);//add the test location to the newOccupied locations
                    }
                }
            }
        }                                                                                                                                                    
        
        Rock rock = new Rock();
        // iterates through the valid test locations as they are the only ones that could be CHANGED next round, this optimization has a much greater effect the larger a grid becomes
        for(int j = 0; j<testSquares.size(); j++) 
        {
            Location loc = testSquares.get(j);
            if(newOccupied.contains(loc))
            {
                grid.put(loc,rock);
            }
            else
            {
                grid.remove(loc);
            }
        }
        
        
    }
    
    /**
     * Returns the actor at the specified row and column. Intended to be used for unit testing.
     *
     * @param   row the row (zero-based index) of the actor to return
     * @param   col the column (zero-based index) of the actor to return
     * @pre     the grid has been created
     * @return  the actor at the specified row and column
     */
    public Actor getActor(int row, int col)
    {
        Location loc = new Location(row, col);
        Actor actor = world.getGrid().get(loc);
        return actor;
    }
    
       /**
     * Returns the number of rows in the game board
     *
     * @return    the number of rows in the game board
     */
    public int getNumRows()
    {
        return ROWS;
    }
    
    /**
     * Returns the number of columns in the game board
     *
     * @return    the number of columns in the game board
     */
    public int getNumCols()
    {
        return COLS;
    }
    
    
    /**
     * Creates an instance of this class. Provides convenient execution.
     *
     */
    public static void main(String args[])
        throws InterruptedException
    {
        GameOfLife game = new GameOfLife();
    }

}
