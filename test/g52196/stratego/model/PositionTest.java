package g52196.stratego.model;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;
import org.junit.Test;

public class PositionTest {

    @Test
    public void testGetRow() {
        System.out.println("getRow");
        Position instance = new Position(67, 42);
        int expResult = 67;
        int result = instance.getRow();
        assertEquals(expResult, result);
    }

    @Test
    public void testGetColumn() {
        System.out.println("getColumn");
        Position instance = new Position(34, -5);
        int expResult = -5;
        int result = instance.getColumn();
        assertEquals(expResult, result);
    }

    @Test
    public void testToString() {
        System.out.println("toString");
        Position instance = new Position(-25, 12);
        String result = instance.toString();
        assertFalse(result.isEmpty());
    }

    @Test
    public void equalsTrueMySelf() {
        Position position1 = new Position(-4, 7);
        assertTrue(position1.equals(position1));
        assertTrue(position1.hashCode() == position1.hashCode());
    }

    @Test
    public void equalsTrue() {
        Position position1 = new Position(-4, 7);
        Position position2 = new Position(-4, 7);
        assertTrue(position1.equals(position2));
        assertTrue(position1.hashCode() == position2.hashCode());
    }

    @Test
    public void equalsFalseDifferentRow() {
        Position position1 = new Position(-4, 7);
        Position position2 = new Position(8, 7);
        assertFalse(position1.equals(position2));
    }

    @Test
    public void equalsFalseDifferentColumn() {
        Position position1 = new Position(2, 7);
        Position position2 = new Position(2, 5);
        assertFalse(position1.equals(position2));
    }

    @Test
    public void equalsFalseOtherObject() {
        Position position1 = new Position(2, 96);
        String position2 = "abcd";
        assertFalse(position1.equals(position2));
    }

    @Test
    public void equalsFalseNull() {
        Position position1 = new Position(2, 96);
        assertFalse(position1.equals(null));
    }

}
