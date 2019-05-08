package g52196.stratego.model;

import static g52196.stratego.model.PlayerColor.BLUE;
import static g52196.stratego.model.PlayerColor.RED;
import g52196.stratego.model.pieces.Bomb;
import g52196.stratego.model.pieces.Flag;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;
import org.junit.Test;

public class PieceTest {

    @Test
    public void testConstructPieceWhenRankIsZero() {
        System.out.println("testConstructPieceWhenRankIsZero");
        Piece instance = new Piece(0, BLUE);
        assertEquals(BLUE, instance.getColor());
        assertEquals(0, instance.getRank());
    }

    @Test(expected = IllegalArgumentException.class)
    public void testConstructPieceWhenRankIsNegative() {
        System.out.println("testConstructPieceWhenRankIsNegative");
        Piece instance = new Piece(-1, BLUE);
    }

    @Test
    public void testConstructPieceWhenRankIsOne() {
        System.out.println("testConstructPieceWhenRankIsOne");
        Piece instance = new Piece(1, BLUE);
        assertEquals(BLUE, instance.getColor());
        assertEquals(1, instance.getRank());
    }

    @Test
    public void testConstructPieceWhenNbStepsIsZero() {
        System.out.println("testConstructPieceWhenNbStepsIsZero");
        Piece instance = new Flag(BLUE);

        assertEquals(0, instance.getNbSteps());
    }

    @Test
    public void testConstructPieceWhenNbStepsIsOne() {
        System.out.println("testConstructPieceWhenNbStepsIsTwo");
        Piece instance = new Piece(1, BLUE);
        assertEquals(1, instance.getNbSteps());
    }

    @Test
    public void testConstructPieceWhenNbStepsIsTwo() {
        System.out.println("testConstructPieceWhenNbStepsIsTwo");
        Piece instance = new Piece(1, 2, BLUE);
        assertEquals(2, instance.getNbSteps());
    }
    
    @Test(expected = IllegalArgumentException.class)
    public void testConstructPieceWhenNbStepsIsNegative() {
        System.out.println("testConstructPieceWhenNbStepsIsNegative");
        Piece instance = new Piece(0, -1, RED);
    }

    @Test
    public void testGetColorBlue() {
        System.out.println("testGetColorBlue");
        Piece instance = new Piece(0, BLUE);
        PlayerColor expResult = BLUE;
        PlayerColor result = instance.getColor();
        assertEquals(expResult, result);
    }

    @Test
    public void testGetColorRed() {
        System.out.println("testGetColorRed");
        Piece instance = new Piece(12, RED);
        PlayerColor expResult = RED;
        PlayerColor result = instance.getColor();
        assertEquals(expResult, result);
    }

    @Test
    public void testToString() {
        System.out.println("toString");
        Piece instance = new Piece(0, PlayerColor.BLUE);
        String result = instance.toString();
        assertFalse(result.isEmpty());

    }

    @Test
    public void equalsTrueMySelf() {
        Piece piece1 = new Piece(10, BLUE);
        assertTrue(piece1.equals(piece1));
        assertTrue(piece1.hashCode() == piece1.hashCode());
    }

    @Test
    public void equalsTrue() {
        Piece piece1 = new Piece(10, BLUE);
        Piece piece2 = new Piece(10, BLUE);
        assertTrue(piece1.equals(piece2));
        assertTrue(piece1.hashCode() == piece2.hashCode());
    }

    @Test
    public void equalsFalseDifferentColor() {
        Piece piece1 = new Piece(10, BLUE);
        Piece piece2 = new Piece(10, RED);
        assertFalse(piece1.equals(piece2));
    }

    @Test
    public void equalsFalseDifferentRank() {
        Piece piece1 = new Piece(10, BLUE);
        Piece piece2 = new Piece(9, BLUE);
        assertFalse(piece1.equals(piece2));
    }

    @Test
    public void equalsFalseOtherObject() {
        Piece piece1 = new Piece(10, BLUE);
        String piece2 = "abcd";
        assertFalse(piece1.equals(piece2));
    }

    @Test
    public void equalsFalseNull() {
        Piece piece1 = new Piece(10, BLUE);
        assertFalse(piece1.equals(null));
    }

    @Test
    public void testIsStrongerTrue() {
        System.out.println("testIsStrongerTrue");
        Piece piece1 = new Piece(2, BLUE);
        Piece piece2 = new Piece(1, BLUE);
        Boolean result = piece1.isStronger(piece2);
        assertTrue(result);
    }

    @Test
    public void testIsStrongerFalse() {
        System.out.println("testIsStrongerFalse");
        Piece piece1 = new Piece(1, BLUE);
        Piece piece2 = new Piece(2, BLUE);
        Boolean result = piece1.isStronger(piece2);
        assertFalse(result);
    }

    @Test
    public void testhasSameRankTrue() {
        System.out.println("testhasSameRankTrue");
        Piece piece1 = new Piece(2, BLUE);
        Piece piece2 = new Piece(2, BLUE);
        Boolean result = piece1.hasSameRank(piece2);
        assertTrue(result);
    }

    @Test
    public void testhasSameRankFalse() {
        System.out.println("testhasSameRankFalse");
        Piece piece1 = new Piece(1, BLUE);
        Piece piece2 = new Piece(2, BLUE);
        Boolean result = piece1.hasSameRank(piece2);
        assertFalse(result);
    }

    @Test
    public void testCanCrossTrue() {
        System.out.println("testCanCrossTrue");
        Piece piece = new Piece(1, BLUE);
        Boolean result = piece.canCross(new Square(SquareType.LAND));
        assertTrue(result);
    }

    @Test
    public void testCanCrossFalse() {
        System.out.println("testCanCrossFalse");
        Piece piece = new Piece(1, BLUE);
        Boolean result = piece.canCross(new Square(SquareType.WATER));
        assertFalse(result);
    }
}
