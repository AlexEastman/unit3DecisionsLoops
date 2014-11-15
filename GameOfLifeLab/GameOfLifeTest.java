
import static org.junit.Assert.*;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import info.gridworld.actor.Actor;

/**
 * The test class GameOfLifeTest.
 *
 * @author  @gcschmit
 * @version 19 July 2014
 */
public class GameOfLifeTest
{
    /**
     * Default constructor for test class GameOfLifeTest
     */
    public GameOfLifeTest()
    {
    }

    /**
     * Sets up the test fixture.
     *
     * Called before every test case method.
     */
    @Before
    public void setUp()
    {
        
    }

    /**
     * Tears down the test fixture.
     *
     * Called after every test case method.
     */
    @After
    public void tearDown()
    {
    }

    @Test
    public void testInitialState()
        throws InterruptedException    
    {
        /* expected pattern for initial state
         *  (X: alive; -: dead)
         * 
         *    5 6 7 8 
         *  10 - - - - 
         *  11 - - X - 
         *  12 - X X - 
         *  13 - - - - 
         *  
         *  
         */
        
        GameOfLife game = new GameOfLife(1);
        final int ROWS = game.getNumRows();
        final int COLS = game.getNumCols();

        for(int row = 10; row < 14; row++)
        {
            for(int col = 5; col < 9; col++)
            {
                // in this example, an alive cell has a non-null actor and a dead cell has a null actor
                Actor cell = game.getActor(row, col);

                // if the cell at the current row and col should be alive, assert that the actor is not null
                if(     (row == 11 && col == 7) ||
                        (row == 12 && col == 7) ||
                        (row == 12 && col == 6))
                {
                    assertNotNull("expected alive cell at (" + row + ", " + col + ")", cell);
                }
                else // else, the cell should be dead; assert that the actor is null
                {
                    assertNull("expected dead cell at (" + row + ", " + col + ")", cell);
                }
            }
        }
    }

    @Test
    public void testFinalState()
        throws InterruptedException    
    {
        /* expected pattern for initial state
         *  (X: alive; -: dead)
         * 
         *    5 6 7 8 
         *  10 - - - - 
         *  11 - X X - 
         *  12 - X X - 
         *  13 - - - - 
         *  
         *  
         */
        
        GameOfLife game = new GameOfLife();
        final int ROWS = game.getNumRows();
        final int COLS = game.getNumCols();

        for(int row = 10; row < 14; row++)
        {
            for(int col = 5; col < 9; col++)
            {
                // in this example, an alive cell has a non-null actor and a dead cell has a null actor
                Actor cell = game.getActor(row, col);

                // if the cell at the current row and col should be alive, assert that the actor is not null
                if(     (row == 11 && col == 7) ||
                        (row == 12 && col == 7) ||
                        (row == 12 && col == 6) ||
                        (row == 11 && col == 6))
                {
                    assertNotNull("expected alive cell at (" + row + ", " + col + ")", cell);
                }
                else // else, the cell should be dead; assert that the actor is null
                {
                    assertNull("expected dead cell at (" + row + ", " + col + ")", cell);
                }
            }
        }
    }
   
}

