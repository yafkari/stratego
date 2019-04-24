package g52196.stratego.model;

import static org.junit.Assert.assertEquals;
import org.junit.Test;

public class MoveTest {

    @Test
    public void testGetPiece() {
        System.out.println("testGetPiece");
        Move instance = new Move(new Piece(0, PlayerColor.RED), 
                new Position(0, 0), new Position(0, 0));
        assertEquals(new Piece(0, PlayerColor.RED), instance.getPiece());
    }

    @Test
    public void testGetStart() {
        System.out.println("testGetStart");
        Move instance = new Move(new Piece(0, PlayerColor.RED), 
                new Position(0, 0), new Position(0, 0));
        assertEquals(new Position(0, 0), instance.getStart());
    }

    @Test
    public void testGetEnd() {
        System.out.println("testGetEnd");
        Move instance = new Move(new Piece(0, PlayerColor.RED), 
                new Position(0, 0), new Position(0, 0));
        assertEquals(new Position(0, 0), instance.getEnd());
    }

    @Test(expected = NullPointerException.class)
    public void testMoveWhenNull() {
        System.out.println("testMoveWhenNull");
        Move instance = new Move(null, null, null);
    }
}
