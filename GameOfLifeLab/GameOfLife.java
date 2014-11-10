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
    
    // the game board will have 5 rows and 5 columns
    private final int ROWS = 5;
    private final int COLS = 5;
    
    
    // constants for the location of the three cells initially alive
    

    /**
     * Default constructor for objects of class GameOfLife
     * 
     * @post    the game will be initialized and populated with the initial state of cells
     * 
     */
    public GameOfLife()
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
     * Creates the actors and inserts them into their initial starting positions in the grid
     *
     * @pre     the grid has been created
     * @post    all actors that comprise the initial state of the game have been added to the grid
     * 
     */
    private void populateGame()
    {
        // the grid of Actors that maintains the state of the game
        //  (alive cells contains actors; dead cells do not)
        Grid<Actor> grid = world.getGrid();
        
        // create and add rocks (a type of Actor) to the three intial locations
        Rock rock1 = new Rock();
        Location loc1 = new Location(1, 1);
        grid.put(loc1, rock1);
        
        Rock rock2 = new Rock();
        Location loc2 = new Location(3, 3);
        grid.put(loc2, rock2);
        
        Rock rock3 = new Rock();
        Location loc3 = new Location(6, 6);
        grid.put(loc3, rock3);
    }

    /**
     * Generates the next generation based on the rules of the Game of Life and updates the grid
     * associated with the world
     *
     * @pre     the game has been initialized
     * @post    the world has been populated with a new grid containing the next generation
     * 
     */
    private void createNextGeneration()
    {
        /** You will need to read the documentation for the World, Grid, and Location classes
         *      in order to implement the Game of Life algorithm and leverage the GridWorld framework.
         */
        
        // create the grid, of the specified size, that contains Actors
        Grid<Actor> grid = world.getGrid();
        
        
        ArrayList<Location> occupied = new ArrayList(25); //initialize andset the size to 25
        ArrayList<Location> neighbors = new ArrayList(25); //initialize and set the size to 25
        ArrayList<Location> allNeighbors = new ArrayList(25); //initialize and set the size to 25
        ArrayList<Location> testSquares = new ArrayList(25); //initialize and set the size to 25
        Location testLocation = new Location(0,0); // initialize location for use in loop
        ArrayList<Location> newOccupied = new ArrayList(25); // this is a list of all locations that should be occupied next generation
         
        occupied = grid.getOccupiedLocations(); // contains all locations where a live cell is present
        testSquares = grid.getOccupiedLocations(); // live cells are valid test locations along with their neighbors (which is found later)
        
        
        for(int k = 0;k<occupied.size();k++)
        {
            neighbors = grid.getValidAdjacentLocations(occupied.get(k)); // contains all locations ajacent to a location
            
            if (neighbors.size() == 2 || neighbors.size() == 3)
            {
                newOccupiedLocations.add(occupied.get(k));
            }
            
            // this loop structure finds an array of only the neighbors of occupied cell not including the occupied cell
            for(int i = 0;i<neighbors.size();i++)
            {
                testLocation = neighbors.get(i); // sets up for iteration through ajacent locations to the test location
                
                if(testSquares.indexOf(testLocation) == -1 || )//if the location is not in occupied add it to the neighbors and test squares
                {
                    allNeighbors.add(testLocation); // this list contains all the neighbors of occupied locations but not the actual locations these cells need exactly 3 neighbors to be alive
                    testSquares.add(testLocation); // this list already contains all occupied locations and the only other valid test locations are their neighbors which are added here
                }
            }
        }                                                                                                                                                    
        
        // iterates through the valid test locations as they are the only ones that could be occupied next round, this optimization has a much greater effect the larger a grid becomes
       
        for(int i = 0; i<allNeighbors.size;i++)
        {
            
        }
        
        
        
        for(int j = 0; j<testSquares.size(); j++) 
        {
            
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
     * An example of a method - replace this comment with your own
     *  that describes the operation of the method
     *
     * @pre     preconditions for the method
     *          (what the method assumes about the method's parameters and class's state)
     * @post    postconditions for the method
     *          (what the method guarantees upon completion)
     * @param   y   description of parameter y
     * @return  description of the return value
     */
    public int numNeighbors(Location coord)
    {
        
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
    public static void main(String[] args)
    {
        GameOfLife game = new GameOfLife();
    }

}
