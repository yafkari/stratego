package g52196.stratego.model;

import static g52196.stratego.model.PlayerColor.BLUE;
import static g52196.stratego.model.PlayerColor.RED;
import g52196.stratego.model.pieces.Flag;
import g52196.stratego.model.pieces.General;
import java.util.List;
import static org.junit.Assert.assertArrayEquals;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;
import org.junit.Before;
import org.junit.Test;

public class GameTest {

    private final Square[][] defaultBoard = {
        {new Square(), new Square(), new Square(), new Square()},
        {new Square(), new Square(), new Square(), new Square()},
        {new Square(), new Square(), new Square(), new Square()},
        {new Square(), new Square(), new Square(), new Square()},
        {new Square(), new Square(), new Square(), new Square()}};

    @Before
    public void setUp() throws Exception {
        defaultBoard[0][1].put(new Flag(RED));
        defaultBoard[3][2].put(new General(RED));
        defaultBoard[4][2].put(new Flag(BLUE));
        defaultBoard[4][1].put(new General(BLUE));
    }

    @Test
    public void testInitialize() {
        System.out.println("initialize");
        Game instance = new Game();
        instance.initialize();
        Square[][] result = instance.getBoard();
        assertArrayEquals(defaultBoard, result);
    }

    @Test(expected = IllegalStateException.class)
    public void testStartWhenNoBoard() {
        System.out.println("testStartWhenNoBoard");
        Game instance = new Game();
        instance.start();
    }

    @Test
    public void testStartWhenInsitializeDone() {
        System.out.println("testStartWhenInsitializeDone");
        Game instance = new Game();
        instance.initialize();
        instance.start();
        assertFalse(instance.isOver());
    }

    @Test
    public void testIsOverWhenGameBegin() {
        System.out.println("testIsOverWhenGameBegin");
        Game instance = new Game();
        instance.initialize();
        assertFalse(instance.isOver());
    }

    @Test
    public void testGetBoardWhenGameBegin() {
        System.out.println("testGetBoardWhenGameBegin");
        Game instance = new Game();
        instance.initialize();
        Square[][] expResult = defaultBoard;
        Square[][] result = instance.getBoard();
        assertArrayEquals(expResult, result);
    }
    
    @Test
    public void testSelect() {
        System.out.println("testSelect");
        Game instance = new Game();
        instance.initialize();
        instance.select(0, 1);
    }
    
    @Test(expected = IllegalArgumentException.class)
    public void testSelectWhenNotOnBoard() {
        System.out.println("testSelectWhenNotOnBoard");
        Game instance = new Game();
        instance.initialize();
        instance.select(22, 1);
    }
    
    @Test(expected = IllegalArgumentException.class)
    public void testSelectWhenSquareEmpty() {
        System.out.println("testSelectWhenSquareEmpty");
        Game instance = new Game();
        instance.initialize();
        instance.select(1, 1);
    }

    @Test(expected = IllegalArgumentException.class)
    public void testSelectWhenSquareNotMyOwn() {
        System.out.println("testSelectWhenSquareNotMyOwn");
        Game instance = new Game();
        instance.initialize();
        instance.select(4, 2);
    }
    
    @Test
    public void testGetSelected() {
        System.out.println("testGetSelected");
        Game instance = new Game();
        instance.initialize();
        instance.select(0, 1);
        Piece expResult = new Flag(PlayerColor.RED);
        Piece result = instance.getSelected();
        assertEquals(expResult, result);
    }
    
    @Test(expected = NullPointerException.class)
    public void testGetSelectedWhenNull() {
        System.out.println("testGetSelectedWhenNull");
        Game instance = new Game();
        instance.initialize();
        instance.getSelected();
    }
    
    @Test
    public void testGetMoves() {
        System.out.println("testGetMoves");
        Game instance = new Game();
        instance.initialize();
        instance.select(3, 2);
        List<Move> result = instance.getMoves();
        assertEquals(4, result.size());
    }
    
    @Test(expected = NullPointerException.class)
    public void testGetMovesWhenSelectedIsNull() {
        System.out.println("testGetMovesWhenSelectedIsNull");
        Game instance = new Game();
        instance.initialize();
        instance.getMoves();
    }
    
    @Test
    public void testSwapPlayers() {
        System.out.println("testSwapPlayers");
        Game instance = new Game();
        instance.initialize();
        instance.swapPlayers();
        PlayerColor result = instance.getCurrent().getColor();
        PlayerColor expResult = new Player(PlayerColor.BLUE).getColor();
        assertEquals(expResult, result);
    }
    
    @Test
    public void testGetCurrent() {
        System.out.println("testGetCurrent");
        Game instance = new Game();
        Player result = instance.getCurrent();
        Player expResult = new Player(PlayerColor.RED);
        assertEquals(expResult, result);
    }
    
    @Test
    public void testHasMoves() {
        System.out.println("testHasMoves");
        Game instance = new Game();
        instance.initialize();
        Boolean result = instance.hasMoves(new Player(PlayerColor.RED));
        assertTrue(result);
    }
    
    @Test(expected = IllegalStateException.class)
    public void testGetWinnersWhenNotOver() {
        System.out.println("testGetWinnersWhenNotOver");
        Game instance = new Game();
        instance.initialize();
        instance.getWinners();
    }
    
    @Test
    public void testApplyWhenNull() {
        System.out.println("testApplyWhenNull");
        Game instance = new Game();
        instance.initialize();
        instance.select(3, 2);
    }
}
