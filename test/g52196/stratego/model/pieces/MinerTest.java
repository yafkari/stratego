package g52196.stratego.model.pieces;

import static g52196.stratego.model.PlayerColor.*;
import org.junit.Test;
import static org.junit.Assert.*;

public class MinerTest {

    @Test
    public void testIsStrongerWhenBomb() {
        System.out.println("testIsStrongerWhenBomb");
        Miner miner = new Miner(RED);
        Bomb bomb = new Bomb(BLUE);
        assertTrue(miner.isStronger(bomb));
    }

    @Test
    public void testIsStrongerWhenTrue() {
        System.out.println("testIsStrongerWhenTrue");
        Miner miner = new Miner(RED);
        Flag flag = new Flag(BLUE);
        assertTrue(miner.isStronger(flag));
    }

    @Test
    public void testIsStrongerWhenFalse() {
        System.out.println("testIsStrongerWhenTrue");
        Miner miner = new Miner(RED);
        General general = new General(BLUE);
        assertFalse(miner.isStronger(general));
    }
}
