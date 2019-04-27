package g52196.stratego.model.pieces;

import static g52196.stratego.model.PlayerColor.*;
import org.junit.Test;
import static org.junit.Assert.*;

public class SpyTest {

    @Test
    public void testIsStrongerWhenMarshal() {
        System.out.println("testIsStrongerWhenMarshal");
        Spy instance = new Spy(RED);
        Marshal marshal = new Marshal(BLUE);
        assertTrue(instance.isStronger(marshal));
    }

    @Test
    public void testIsStrongerWhenTrue() {
        System.out.println("testIsStrongerWhenTrue");
        Spy instance = new Spy(RED);
        Flag flag = new Flag(BLUE);
        assertTrue(instance.isStronger(flag));
    }

    @Test
    public void testIsStrongerWhenFalse() {
        System.out.println("testIsStrongerWhenFalse");
        Spy instance = new Spy(RED);
        General general = new General(BLUE);
        assertFalse(instance.isStronger(general));
    }
}
