package es.unileon.prg1.tetris.strategy;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

import org.junit.Before;
import org.junit.Test;

import es.unileon.prg1.tetris.Color;
import es.unileon.prg1.tetris.Piece;

public class PieceColorTest {

    private Piece none, yellow, white, green, cyan, blue, red, magenta, black;

    @Before
    public void setUp() throws Exception {
        ColorStrategySingleton.getInstance("color");
        this.none = new Piece(Color.NONE, " ");
        this.yellow = new Piece(Color.YELLOW, "Y");
        this.white = new Piece(Color.WHITE, "W");
        this.green = new Piece(Color.GREEN, "G");
        this.cyan = new Piece(Color.CYAN, "C");
        this.blue = new Piece(Color.BLUE, "B");
        this.red = new Piece(Color.RED, "R");
        this.magenta = new Piece(Color.MAGENTA, "M");
        this.black = new Piece(Color.BLACK, "L");
    }

    @Test
    public void testPiece() {
        Piece piece = new Piece();
        assertEquals(ANSIColorStrategy.ANSI_DEFAULT, piece.toString());
    }

    @Test
    public void testPieceColorSign() {
        assertEquals(ANSIColorStrategy.ANSI_DEFAULT, none.toString());
        assertEquals(ANSIColorStrategy.ANSI_YELLOW, yellow.toString());
        assertEquals(ANSIColorStrategy.ANSI_WHITE, white.toString());
        assertEquals(ANSIColorStrategy.ANSI_GREEN, green.toString());
        assertEquals(ANSIColorStrategy.ANSI_CYAN, cyan.toString());
        assertEquals(ANSIColorStrategy.ANSI_BLUE, blue.toString());
        assertEquals(ANSIColorStrategy.ANSI_RED, red.toString());
        assertEquals(ANSIColorStrategy.ANSI_MAGENTA, magenta.toString());
        assertEquals(ANSIColorStrategy.ANSI_BLACK, black.toString());
    }

    @Test
    public void testPiecePiece() {
        Piece piece = new Piece(none);
        assertEquals(ANSIColorStrategy.ANSI_DEFAULT, piece.toString());
    }

    @Test
    public void testGetColor() {
        assertEquals(Color.NONE, none.getColor());
        assertEquals(Color.YELLOW, yellow.getColor());
        assertEquals(Color.WHITE, white.getColor());
        assertEquals(Color.GREEN, green.getColor());
        assertEquals(Color.CYAN, cyan.getColor());
        assertEquals(Color.BLUE, blue.getColor());
        assertEquals(Color.RED, red.getColor());
        assertEquals(Color.MAGENTA, magenta.getColor());
        assertEquals(Color.BLACK, black.getColor());
    }

    @Test
    public void testGetSign() {
        assertEquals("  ", none.getSign());
        assertEquals("Y ", yellow.getSign());
        assertEquals("W ", white.getSign());
        assertEquals("G ", green.getSign());
        assertEquals("C ", cyan.getSign());
        assertEquals("B ", blue.getSign());
        assertEquals("R ", red.getSign());
        assertEquals("M ", magenta.getSign());
        assertEquals("L ", black.getSign());
    }

    @Test
    public void testIsEmpty() {
        assertTrue(this.none.isEmpty());
        assertFalse(this.yellow.isEmpty());
        assertFalse(this.white.isEmpty());
        assertFalse(this.green.isEmpty());
        assertFalse(this.cyan.isEmpty());
        assertFalse(this.blue.isEmpty());
        assertFalse(this.red.isEmpty());
        assertFalse(this.magenta.isEmpty());
        assertFalse(this.black.isEmpty());
    }

    @Test
    public void testToString() {
        assertEquals(ANSIColorStrategy.ANSI_DEFAULT, none.toString());
        assertEquals(ANSIColorStrategy.ANSI_YELLOW, yellow.toString());
        assertEquals(ANSIColorStrategy.ANSI_WHITE, white.toString());
        assertEquals(ANSIColorStrategy.ANSI_GREEN, green.toString());
        assertEquals(ANSIColorStrategy.ANSI_CYAN, cyan.toString());
        assertEquals(ANSIColorStrategy.ANSI_BLUE, blue.toString());
        assertEquals(ANSIColorStrategy.ANSI_RED, red.toString());
        assertEquals(ANSIColorStrategy.ANSI_MAGENTA, magenta.toString());
        assertEquals(ANSIColorStrategy.ANSI_BLACK, black.toString());
    }
}