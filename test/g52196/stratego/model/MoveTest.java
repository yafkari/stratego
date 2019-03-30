package g52196.stratego.model;

import org.junit.Test;

public class MoveTest {
    
    @Test(expected = NullPointerException.class)
    public void testMoveWhenNull() {
        System.out.println("testMoveWhenNull");
        Move instance = new Move(null, null, null);
    }
}
