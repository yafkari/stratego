package g52196.stratego.model;

import static org.junit.Assert.assertArrayEquals;
import static org.junit.Assert.assertEquals;
import org.junit.Before;
import org.junit.Test;

public class BoardTest {

    private final Square[][] defaultBoard = new Square[6][5];
    
    @Before
    public void setUp() throws Exception {
        for (int row = 0; row < defaultBoard.length; row++) {
            for (int column = 0; column < defaultBoard[row].length; column++) {
                if (row == 2 && column == 1 || row == 2 && column == 2
                        || row == 2 && column == 3) {
                    defaultBoard[row][column] = new Square(SquareType.WATER);
                } else {
                    defaultBoard[row][column] = new Square(SquareType.LAND);
                }
            }
        }
    }

    @Test
    public void testGetSquareWhenSquareIsFill() {
        System.out.println("testGetSquareWhenSquareIsFill");
        Position position = new Position(3, 2);
        Board instance = new Board();
        instance.put(new Piece(4, PlayerColor.BLUE), position);
        Square expResult = new Square(SquareType.LAND);
        expResult.put(new Piece(4, PlayerColor.BLUE));
        Square result = instance.getSquare(position);
        assertEquals(expResult, result);
    }

    @Test
    public void testGetSquareWhenSquareIsEmpty() {
        System.out.println("testGetSquareWhenSquareIsEmpty");
        Position position = new Position(0, 1);
        Board instance = new Board();
        Square expResult = new Square(SquareType.LAND);
        Square result = instance.getSquare(position);
        assertEquals(expResult, result);
    }

    @Test(expected = IllegalArgumentException.class)
    public void testGetSquareWhenPositionOutside() {
        System.out.println("testGetSquareWhenPositionOutside");
        Position position = new Position(-1, 2);
        Board instance = new Board();
        instance.getSquare(position);
    }

    @Test
    public void testGetSquaresWhenDefaultBoard() {
        System.out.println("testGetSquaresWhenDefaultBoard");
        Board instance = new Board();
        Square[][] expResult = defaultBoard;
        Square[][] result = instance.getSquares();
        assertArrayEquals(expResult, result);
    }

    @Test
    public void testGetSquaresWhen2PiecesAdded() {
        System.out.println("testGetSquaresWhen2PiecesAdded");
        Board instance = new Board();
        instance.put(new Piece(4, PlayerColor.RED), new Position(1, 2));
        instance.put(new Piece(1, PlayerColor.BLUE), new Position(4, 3));
        Square[][] expResult = defaultBoard;
        defaultBoard[1][2].put(new Piece(4, PlayerColor.RED));
        defaultBoard[4][3].put(new Piece(1, PlayerColor.BLUE));
        Square[][] result = instance.getSquares();
        assertArrayEquals(expResult, result);
    }

    @Test
    public void testPutOnePiece() {
        System.out.println("testPutOnePiece");
        Piece piece = new Piece(2, PlayerColor.BLUE);
        Position position = new Position(0, 0);
        Board instance = new Board();
        instance.put(piece, position);
        Square expResult = new Square(SquareType.LAND);
        expResult.put(piece);
        Square result = instance.getSquare(position);
        assertEquals(expResult, result);
    }

    @Test(expected = NullPointerException.class)
    public void testPutWhenPieceIsNull() {
        System.out.println("testPutWhenPieceIsNull");
        Piece piece = null;
        Position position = new Position(2, 2);
        Board instance = new Board();
        instance.put(piece, position);
    }

    @Test(expected = IllegalArgumentException.class)
    public void testPuWhenPositionIsOutside() {
        System.out.println("testPuWhenPositionIsOutside");
        Piece piece = new Piece(1, PlayerColor.BLUE);
        Position position = new Position(6, 2);
        Board instance = new Board();
        instance.put(piece, position);
    }

    @Test
    public void testIsInsideWhenCornerUpLeft() {
        System.out.println("testIsInsideWhenCornerUpLeft");
        Position position = new Position(0, 0);
        Board instance = new Board();
        boolean expResult = true;
        boolean result = instance.isInside(position);
        assertEquals(expResult, result);
    }

    @Test
    public void testIsInsideWhenCornerUpRight() {
        System.out.println("testIsInsideWhenCornerUpRight");
        Position position = new Position(0, 3);
        Board instance = new Board();
        boolean expResult = true;
        boolean result = instance.isInside(position);
        assertEquals(expResult, result);
    }

    @Test
    public void testIsInsideWhenCornerDownleft() {
        System.out.println("testIsInsideWhenCornerDownleft");
        Position position = new Position(4, 0);
        Board instance = new Board();
        boolean expResult = true;
        boolean result = instance.isInside(position);
        assertEquals(expResult, result);
    }

    @Test
    public void testIsInsideWhenCornerDownRight() {
        System.out.println("testIsInsideWhenCornerDownRight");
        Position position = new Position(4, 3);
        Board instance = new Board();
        boolean expResult = true;
        boolean result = instance.isInside(position);
        assertEquals(expResult, result);
    }

    @Test
    public void testIsInsideWhenBoundaryUp() {
        System.out.println("testIsInsideWhenBoundaryUp");
        Position position = new Position(0, 1);
        Board instance = new Board();
        boolean expResult = true;
        boolean result = instance.isInside(position);
        assertEquals(expResult, result);
    }

    @Test
    public void testIsInsideWhenBoundaryDown() {
        System.out.println("testIsInsideWhenBoundaryDown");
        Position position = new Position(4, 2);
        Board instance = new Board();
        boolean expResult = true;
        boolean result = instance.isInside(position);
        assertEquals(expResult, result);
    }

    @Test
    public void testIsInsideWhenBoundaryLeft() {
        System.out.println("testIsInsideWhenBoundaryLeft");
        Position position = new Position(1, 0);
        Board instance = new Board();
        boolean expResult = true;
        boolean result = instance.isInside(position);
        assertEquals(expResult, result);
    }

    @Test
    public void testIsInsideWhenBoundaryRight() {
        System.out.println("testIsInsideWhenBoundaryRight");
        Position position = new Position(3, 3);
        Board instance = new Board();
        boolean expResult = true;
        boolean result = instance.isInside(position);
        assertEquals(expResult, result);
    }

    @Test
    public void testIsInsideWhenOutsideBoundaryUp() {
        System.out.println("testIsInsideWhenOutsideBoundaryUp");
        Position position = new Position(-1, 1);
        Board instance = new Board();
        boolean expResult = false;
        boolean result = instance.isInside(position);
        assertEquals(expResult, result);
    }

    @Test
    public void testIsInsideWhenOutsideBoundaryDown() {
        System.out.println("testIsInsideWhenOutsideBoundaryDown");
        Position position = new Position(7, 2);
        Board instance = new Board();
        boolean expResult = false;
        boolean result = instance.isInside(position);
        assertEquals(expResult, result);
    }

    @Test
    public void testIsInsideWhenOutsideBoundaryLeft() {
        System.out.println("testIsInsideWhenOutsideBoundaryLeft");
        Position position = new Position(1, -1);
        Board instance = new Board();
        boolean expResult = false;
        boolean result = instance.isInside(position);
        assertEquals(expResult, result);
    }

    @Test
    public void testIsInsideWhenOutsideBoundaryRight() {
        System.out.println("testIsInsideWhenOutsideBoundaryRight");
        Position position = new Position(3, 10);
        Board instance = new Board();
        boolean expResult = false;
        boolean result = instance.isInside(position);
        assertEquals(expResult, result);
    }

    @Test
    public void testIsInsideWhenInside() {
        System.out.println("testIsInsideWhenInside");
        Position position = new Position(2, 1);
        Board instance = new Board();
        boolean expResult = true;
        boolean result = instance.isInside(position);
        assertEquals(expResult, result);
    }

    @Test(expected = NullPointerException.class)
    public void testIsInsideWhenPositionIsNull() {
        System.out.println("testIsInsideWhenPositionIsNull");
        Board instance = new Board();
        instance.isInside(null);
    }

    @Test
    public void testIsFreeTrue() {
        System.out.println("testIsFreeTrue");
        Board instance = new Board();
        boolean expResult = true;
        boolean result = instance.isFree(new Position(2, 1));
        assertEquals(expResult, result);
    }

    @Test
    public void testIsFreeFalse() {
        System.out.println("testIsFreeFalse");
        Board instance = new Board();
        instance.put(new Piece(2, PlayerColor.RED), new Position(2, 1));
        boolean expResult = false;
        boolean result = instance.isFree(new Position(2, 1));
        assertEquals(expResult, result);
    }

    @Test(expected = IllegalArgumentException.class)
    public void testIsFreeWhenIsNotOnBoard() {
        System.out.println("testIsFreeIsNotOnBoard");
        Board instance = new Board();
        instance.isFree(new Position(22, 1));
    }

    @Test
    public void testIsMyOwnTrue() {
        System.out.println("testIsMyOwnTrue");
        Board instance = new Board();
        instance.put(new Piece(1, PlayerColor.BLUE), new Position(2, 1));
        boolean expResult = true;
        boolean result = instance.isMyOwn(new Position(2, 1), PlayerColor.BLUE);
        assertEquals(expResult, result);
    }

    @Test
    public void testIsMyOwnFalse() {
        System.out.println("testIsMyOwnFalse");
        Board instance = new Board();
        instance.put(new Piece(1, PlayerColor.BLUE), new Position(2, 1));
        boolean expResult = false;
        boolean result = instance.isMyOwn(new Position(2, 1), PlayerColor.RED);
        assertEquals(expResult, result);
    }

    @Test
    public void testIsMyOwnEmpty() {
        System.out.println("testIsMyOwnEmpty");
        Board instance = new Board();
        boolean expResult = false;
        boolean result = instance.isMyOwn(new Position(2, 1), PlayerColor.RED);
        assertEquals(expResult, result);
    }

    @Test
    public void testRemoveWhenLand() {
        System.out.println("testRemoveWhenLand");
        Board instance = new Board();
        instance.put(new Piece(1, PlayerColor.RED), new Position(1, 1));
        instance.remove(new Position(1, 1));
        Square result = instance.getSquare(new Position(1, 1));
        
        assertEquals(new Square(SquareType.LAND), result);
    }
    
    @Test
    public void testRemoveWhenWater() {
        System.out.println("testRemoveWhenWater");
        Board instance = new Board();
        instance.put(new Piece(1, PlayerColor.RED), new Position(2, 3));
        instance.remove(new Position(2, 3));
        Square result = instance.getSquare(new Position(2, 3));
        
        assertEquals(new Square(SquareType.WATER), result);
    }

    @Test
    public void testRemoveWhenIsFree() {
        System.out.println("testRemoveWhenIsFree");
        Board instance = new Board();
        instance.remove(new Position(1, 1));
        Square result = instance.getSquare(new Position(1, 1));
        assertEquals(new Square(SquareType.LAND), result);
    }

    @Test(expected = IllegalArgumentException.class)
    public void testRemoveWhenNotInside() {
        System.out.println("testRemoveWhenNotInside");
        Board instance = new Board();
        instance.remove(new Position(-1, 1));
    }

    @Test(expected = IllegalArgumentException.class)
    public void testIsMyOwnWhenNotOnBoard() {
        System.out.println("testIsMyOwnWhenNotOnBoard");
        Board instance = new Board();
        instance.isMyOwn(new Position(22, 1), PlayerColor.RED);
    }

    @Test
    public void testGetTakenSquare() {
        System.out.println("testGetTakenSquare");
        Board instance = new Board();
        instance.put(new Piece(1, PlayerColor.RED), new Position(1, 1));
        int expResult = 1;
        int result = instance.getTakenSquare(new Player(PlayerColor.RED)).size();
        assertEquals(expResult, result);
    }

    @Test
    public void testGetTakenSquareWhenEmpty() {
        System.out.println("testGetTakenSquareWhenEmpty");
        Board instance = new Board();
        int expResult = 0;
        int result = instance.getTakenSquare(new Player(PlayerColor.RED)).size();
        assertEquals(expResult, result);
    }
    
    @Test
    public void testGetPiece() {
        System.out.println("testGetPiece");
        Board instance = new Board();
        instance.put(new Piece(0, PlayerColor.RED), new Position(0,0));
       
        assertEquals(instance.getPiece(new Position(0,0)), new Piece(0, PlayerColor.RED));
    }
    
    @Test(expected = IllegalArgumentException.class)
    public void testGetPieceWhenIllegalArgumentException() {
        System.out.println("testGetPieceWhenIllegalArgumentException");
        Board instance = new Board();
        instance.getPiece(new Position(-1,0));
    }
}
