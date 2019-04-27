package g52196.stratego.model.pieces;

import static g52196.stratego.model.PlayerColor.*;
import org.junit.Test;
import static org.junit.Assert.*;

public class MarshalTest {

    @Test
    public void testIsStronger() {
        System.out.println("testIsStronger");
        Marshal instance = new Marshal(RED);
        Flag flag = new Flag(BLUE);
        General general = new General(BLUE);
        Bomb bomb = new Bomb(BLUE);
        Miner miner = new Miner(BLUE);
        Spy spy = new Spy(BLUE);
        Pathfinder pathFinder = new Pathfinder(BLUE);

        assertTrue(instance.isStronger(flag));
        assertTrue(instance.isStronger(general));
        assertTrue(instance.isStronger(bomb));
        assertTrue(instance.isStronger(miner));
        assertTrue(instance.isStronger(spy));
        assertTrue(instance.isStronger(pathFinder));

    }
}
