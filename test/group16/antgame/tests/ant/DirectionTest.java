package group16.antgame.tests.ant;

import group16.antgame.ant.Direction;
import group16.antgame.ant.LinearDirection;
import static org.junit.Assert.assertEquals;
import org.junit.Test;


/**
 * The DirectionTest class contains JUnit tests for the Direction class.
 * @author Group 16
 * @version 14/04/2016
 * @see group16.antgame.ant.Direction
 */
public class DirectionTest {
    
    @Test
    public void testTurn() {
        assertEquals(Direction.turn(LinearDirection.Left, 0), 5);
        assertEquals(Direction.turn(LinearDirection.Left, 1), 0);
        assertEquals(Direction.turn(LinearDirection.Left, 2), 1);
        assertEquals(Direction.turn(LinearDirection.Left, 3), 2);
        assertEquals(Direction.turn(LinearDirection.Left, 4), 3);
        assertEquals(Direction.turn(LinearDirection.Left, 5), 4);
        assertEquals(Direction.turn(LinearDirection.Right, 0), 1);
        assertEquals(Direction.turn(LinearDirection.Right, 1), 2);
        assertEquals(Direction.turn(LinearDirection.Right, 2), 3);
        assertEquals(Direction.turn(LinearDirection.Right, 3), 4);
        assertEquals(Direction.turn(LinearDirection.Right, 4), 5);
        assertEquals(Direction.turn(LinearDirection.Right, 5), 0);
    }
    
}
