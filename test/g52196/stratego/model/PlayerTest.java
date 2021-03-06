package g52196.stratego.model;

import g52196.stratego.model.pieces.Flag;
import java.util.ArrayList;
import java.util.List;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;
import org.junit.Test;

public class PlayerTest {

    @Test(expected = NullPointerException.class)
    public void testConstructPlayerColorIsNull() {
        System.out.println("testConstructPlayerColorIsNull");
        new Player(null);
    }

    @Test
    public void testGetPiecesWhenStockEmpty() {
        System.out.println("testGetPiecesWhenStockEmpty");
        Player instance = new Player(PlayerColor.BLUE);
        List<Piece> result = instance.getPieces();
        assertTrue(result.isEmpty());
    }

    @Test
    public void testGetPiecesWhenStockFill() {
        System.out.println("testGetPiecesWhenStockFill");
        Player instance = new Player(PlayerColor.BLUE);
        instance.addPiece(new Piece(0, PlayerColor.BLUE));
        instance.addPiece(new Piece(0, PlayerColor.BLUE));
        List<Piece> result = instance.getPieces();
        assertFalse(result.isEmpty());
    }

    @Test
    public void testAddPiece() {
        System.out.println("addPiece");
        Player instance = new Player(PlayerColor.BLUE);
        instance.addPiece(new Piece(0, PlayerColor.BLUE));
        instance.addPiece(new Piece(0, PlayerColor.BLUE));
        List<Piece> expResult = new ArrayList<>();
        expResult.add(new Piece(0, PlayerColor.BLUE));
        expResult.add(new Piece(0, PlayerColor.BLUE));
        List<Piece> result = instance.getPieces();
        assertEquals(expResult, result);
    }

    @Test
    public void testGetColorBlue() {
        System.out.println("testGetColorBlue");
        Player instance = new Player(PlayerColor.BLUE);
        PlayerColor expResult = PlayerColor.BLUE;
        PlayerColor result = instance.getColor();
        assertEquals(expResult, result);
    }

    @Test
    public void testGetColorRed() {
        System.out.println("testGetColorRed");
        Player instance = new Player(PlayerColor.RED);
        PlayerColor expResult = PlayerColor.RED;
        PlayerColor result = instance.getColor();
        assertEquals(expResult, result);
    }

    @Test
    public void testToString() {
        System.out.println("toString");
        Player instance = new Player(PlayerColor.BLUE);
        String result = instance.toString();
        assertFalse(result.isEmpty());
    }

    @Test
    public void equalsTrueMySelf() {
        System.out.println("equalsTrueMySelf");

        Player player1 = new Player(PlayerColor.BLUE);
        assertTrue(player1.equals(player1));
        assertTrue(player1.hashCode() == player1.hashCode());
    }

    @Test
    public void equalsTrueNoPiece() {
        System.out.println("equalsTrueNoPiece");

        Player player1 = new Player(PlayerColor.BLUE);
        Player player2 = new Player(PlayerColor.BLUE);
        assertTrue(player1.equals(player2));
        assertTrue(player1.hashCode() == player2.hashCode());
    }

    @Test
    public void equalsTrueWithPiece() {
        System.out.println("equalsTrueWithPiece");
        Player player1 = new Player(PlayerColor.BLUE);
        Player player2 = new Player(PlayerColor.BLUE);
        player1.addPiece(new Piece(1, PlayerColor.BLUE));
        player2.addPiece(new Piece(1, PlayerColor.BLUE));
        assertTrue(player1.equals(player2));
        assertTrue(player1.hashCode() == player2.hashCode());
    }

    @Test
    public void equalsFalseDifferentColor() {
        System.out.println("equalsFalseDifferentColor");
        Player player1 = new Player(PlayerColor.BLUE);
        Player player2 = new Player(PlayerColor.RED);
        assertFalse(player1.equals(player2));
    }

    @Test
    public void equalsFalseDifferentPiece() {
        System.out.println("equalsFalseDifferentPiece");
        Player player1 = new Player(PlayerColor.BLUE);
        Player player2 = new Player(PlayerColor.BLUE);
        player1.addPiece(new Piece(1, PlayerColor.BLUE));
        player2.addPiece(new Piece(2, PlayerColor.BLUE));
        assertFalse(player1.equals(player2));
    }

    @Test
    public void equalsFalseOtherObject() {
        System.out.println("equalsFalseOtherObject");
        Player player1 = new Player(PlayerColor.BLUE);
        String player2 = "abcd";
        assertFalse(player1.equals(player2));
    }

    @Test
    public void equalsFalseNull() {
        System.out.println("equalsFalseNull");
        Player player1 = new Player(PlayerColor.BLUE);
        assertFalse(player1.equals(null));
    }

    @Test
    public void testHasFlag() {
        System.out.println("testHasFlag");
        Game instance = new Game();
        instance.initialize();
        Boolean result = instance.getCurrent().hasFlag();
        assertTrue(result);
    }

    @Test
    public void testRemove() {
        System.out.println("testRemove");
        Game instance = new Game();
        instance.initialize();
        instance.getCurrent().remove(new Flag(PlayerColor.RED));
        assertTrue(!instance.getCurrent().getPieces()
                .contains(new Flag(PlayerColor.RED)));
    }
}
