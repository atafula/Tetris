package es.unileon.prg1.tetris;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;
import static org.junit.Assert.assertFalse;

import org.junit.Before;
import org.junit.Test;

public class TetrisTest {

    private Tetris tetris;

    @Before
    public void setUp() throws Exception {
        this.tetris = new Tetris(5, 6, "noColor");
        this.tetris.set(new Block());
    }

    @Test
    public void testTetrisIntInt() throws TetrisException {
        assertEquals(" O O \n" + //
                " O O \n\n" + //
                "│            │\n" + //
                "│            │\n" + //
                "│            │\n" + //
                "│            │\n" + //
                "│            │\n" + //
                "└────────────┘\n" + //
                "POINTS: 0", this.tetris.toString());
    }

    @Test(expected = TetrisException.class)
    public void testTetrisTooFewRows() throws TetrisException {
        new Tetris(4, 10, "noColor");
    }

    @Test(expected = TetrisException.class)
    public void testTetrisTooManyRows() throws TetrisException {
        new Tetris(21, 10, "noColor");
    }

    @Test(expected = TetrisException.class)
    public void testTetrisTooFewColumns() throws TetrisException {
        new Tetris(10, 5, "noColor");
    }

    @Test(expected = TetrisException.class)
    public void testTetrisTooManyColumns() throws TetrisException {
        new Tetris(10, 21, "noColor");
    }

    @Test
    public void testSet() {
        this.tetris.set(new BlockI());
        assertEquals(" I \n" + //
                " I \n" + //
                " I \n" + //
                " I \n\n" + //
                "│            │\n" + //
                "│            │\n" + //
                "│            │\n" + //
                "│            │\n" + //
                "│            │\n" + //
                "└────────────┘\n" + //
                "POINTS: 0", this.tetris.toString());
    }

    @Test
    public void testCreate() {
        assertEquals(" O O \n" + //
                " O O ", this.tetris.create(1).toString());
        assertEquals(" I \n" + //
                " I \n" + //
                " I \n" + //
                " I ", this.tetris.create(2).toString());
        assertEquals("   J \n" + //
                "   J \n" + //
                " J J ", this.tetris.create(3).toString());
        assertEquals(" L   \n" + //
                " L   \n" + //
                " L L ", this.tetris.create(4).toString());
        assertEquals(" T T T \n" + //
                "   T   ", this.tetris.create(5).toString());
        assertEquals("   S S \n" + //
                " S S   ", this.tetris.create(6).toString());
        assertEquals(" Z Z   \n" + //
                "   Z Z ", this.tetris.create(7).toString());
        assertEquals(" O O \n" + //
                " O O ", this.tetris.create(0).toString());
    }

    @Test
    public void testGetPoints() throws TetrisException {
        assertEquals(0, this.tetris.getPoints());
        this.tetris.drop();
        this.tetris.set(new Block());
        this.tetris.moveRigth();
        this.tetris.moveRigth();
        this.tetris.drop();
        this.tetris.set(new Block());
        this.tetris.moveRigth();
        this.tetris.moveRigth();
        this.tetris.moveRigth();
        this.tetris.moveRigth();
        this.tetris.drop();
        assertEquals(20, this.tetris.getPoints());
    }

    @Test
    public void testMoveRigth() throws TetrisException {
        assertEquals(" O O \n" + //
                " O O \n\n" + //
                "│            │\n" + //
                "│            │\n" + //
                "│            │\n" + //
                "│            │\n" + //
                "│            │\n" + //
                "└────────────┘\n" + //
                "POINTS: 0", this.tetris.toString());
        this.tetris.moveRigth();
        assertEquals("   O O \n" + //
                "   O O \n\n" + //
                "│            │\n" + //
                "│            │\n" + //
                "│            │\n" + //
                "│            │\n" + //
                "│            │\n" + //
                "└────────────┘\n" + //
                "POINTS: 0", this.tetris.toString());
    }

    @Test(expected = TetrisException.class)
    public void testMoveRightOut() throws TetrisException {
        this.tetris.moveRigth();
        this.tetris.moveRigth();
        this.tetris.moveRigth();
        this.tetris.moveRigth();
        this.tetris.moveRigth();
    }

    @Test
    public void testMoveLeft() throws TetrisException {
        this.tetris.moveRigth();
        assertEquals("   O O \n" + //
                "   O O \n\n" + //
                "│            │\n" + //
                "│            │\n" + //
                "│            │\n" + //
                "│            │\n" + //
                "│            │\n" + //
                "└────────────┘\n" + //
                "POINTS: 0", this.tetris.toString());
        this.tetris.moveLeft();
        assertEquals(" O O \n" + //
                " O O \n\n" + //
                "│            │\n" + //
                "│            │\n" + //
                "│            │\n" + //
                "│            │\n" + //
                "│            │\n" + //
                "└────────────┘\n" + //
                "POINTS: 0", this.tetris.toString());
    }

    @Test(expected = TetrisException.class)
    public void testMoveLeftOut() throws TetrisException {
        this.tetris.moveLeft();
    }

    @Test
    public void testSpinRight() throws TetrisException {
        this.tetris.set(new BlockT());
        assertEquals(" T T T \n" + //
                "   T   \n\n" + //
                "│            │\n" + //
                "│            │\n" + //
                "│            │\n" + //
                "│            │\n" + //
                "│            │\n" + //
                "└────────────┘\n" + //
                "POINTS: 0", this.tetris.toString());
        this.tetris.spinRight();
        assertEquals("   T \n" + //
                " T T \n" + //
                "   T \n\n" + //
                "│            │\n" + //
                "│            │\n" + //
                "│            │\n" + //
                "│            │\n" + //
                "│            │\n" + //
                "└────────────┘\n" + //
                "POINTS: 0", this.tetris.toString());
        this.tetris.spinRight();
        assertEquals("   T   \n" + //
                " T T T \n\n" + //
                "│            │\n" + //
                "│            │\n" + //
                "│            │\n" + //
                "│            │\n" + //
                "│            │\n" + //
                "└────────────┘\n" + //
                "POINTS: 0", this.tetris.toString());
        this.tetris.spinRight();
        assertEquals(" T   \n" + //
                " T T \n" + //
                " T   \n\n" + //
                "│            │\n" + //
                "│            │\n" + //
                "│            │\n" + //
                "│            │\n" + //
                "│            │\n" + //
                "└────────────┘\n" + //
                "POINTS: 0", this.tetris.toString());
        this.tetris.spinRight();
        assertEquals(" T T T \n" + //
                "   T   \n\n" + //
                "│            │\n" + //
                "│            │\n" + //
                "│            │\n" + //
                "│            │\n" + //
                "│            │\n" + //
                "└────────────┘\n" + //
                "POINTS: 0", this.tetris.toString());
    }

    @Test
    public void testSpinLeft() throws TetrisException {
        this.tetris.set(new BlockT());
        assertEquals(" T T T \n" + //
                "   T   \n\n" + //
                "│            │\n" + //
                "│            │\n" + //
                "│            │\n" + //
                "│            │\n" + //
                "│            │\n" + //
                "└────────────┘\n" + //
                "POINTS: 0", this.tetris.toString());
        this.tetris.spinLeft();
        assertEquals(" T   \n" + //
                " T T \n" + //
                " T   \n\n" + //
                "│            │\n" + //
                "│            │\n" + //
                "│            │\n" + //
                "│            │\n" + //
                "│            │\n" + //
                "└────────────┘\n" + //
                "POINTS: 0", this.tetris.toString());
        this.tetris.spinLeft();
        assertEquals("   T   \n" + //
                " T T T \n\n" + //
                "│            │\n" + //
                "│            │\n" + //
                "│            │\n" + //
                "│            │\n" + //
                "│            │\n" + //
                "└────────────┘\n" + //
                "POINTS: 0", this.tetris.toString());
        this.tetris.spinLeft();
        assertEquals("   T \n" + //
                " T T \n" + //
                "   T \n\n" + //
                "│            │\n" + //
                "│            │\n" + //
                "│            │\n" + //
                "│            │\n" + //
                "│            │\n" + //
                "└────────────┘\n" + //
                "POINTS: 0", this.tetris.toString());
        this.tetris.spinLeft();
        assertEquals(" T T T \n" + //
                "   T   \n\n" + //
                "│            │\n" + //
                "│            │\n" + //
                "│            │\n" + //
                "│            │\n" + //
                "│            │\n" + //
                "└────────────┘\n" + //
                "POINTS: 0", this.tetris.toString());
    }

    @Test
    public void testDropOT() throws TetrisException {
        assertTrue(this.tetris.drop());
        this.tetris.set(new BlockT());
        this.tetris.moveRigth();
        assertEquals("   T T T \n" + //
                "     T   \n\n" + //
                "│            │\n" + //
                "│            │\n" + //
                "│            │\n" + //
                "│O O         │\n" + //
                "│O O         │\n" + //
                "└────────────┘\n" + //
                "POINTS: 0", this.tetris.toString());
        assertTrue(this.tetris.drop());
        this.tetris.set(new BlockI());
        assertEquals(" I \n" + //
                " I \n" + //
                " I \n" + //
                " I \n\n" + //
                "│            │\n" + //
                "│            │\n" + //
                "│  T T T     │\n" + //
                "│O O T       │\n" + //
                "│O O         │\n" + //
                "└────────────┘\n" + //
                "POINTS: 0", this.tetris.toString());
        assertFalse(this.tetris.drop());
    }

    @Test
    public void testDropTT() throws TetrisException {
        this.tetris.set(new BlockT());
        this.tetris.spinLeft();
        assertTrue(this.tetris.drop());
        this.tetris.set(new BlockT());
        this.tetris.spinRight();
        assertEquals("   T \n" + //
                " T T \n" + //
                "   T \n\n" + //
                "│            │\n" + //
                "│            │\n" + //
                "│T           │\n" + //
                "│T T         │\n" + //
                "│T           │\n" + //
                "└────────────┘\n" + //
                "POINTS: 0", this.tetris.toString());
        assertTrue(this.tetris.drop());
        this.tetris.set(new Block());
        assertEquals(" O O \n" + //
                " O O \n\n" + //
                "│  T         │\n" + //
                "│T T         │\n" + //
                "│T T         │\n" + //
                "│T T         │\n" + //
                "│T           │\n" + //
                "└────────────┘\n" + //
                "POINTS: 0", this.tetris.toString());
        assertFalse(this.tetris.drop());
    }

    @Test
    public void testDropOTI() throws TetrisException {
        assertTrue(this.tetris.drop());
        this.tetris.set(new BlockT());
        this.tetris.spinLeft();
        this.tetris.spinLeft();
        this.tetris.moveRigth();
        this.tetris.moveRigth();
        assertTrue(this.tetris.drop());
        this.tetris.set(new BlockI());
        this.tetris.spinRight();
        this.tetris.moveRigth();
        this.tetris.moveRigth();
        assertEquals("     I I I I \n\n" + //
                "│            │\n" + //
                "│            │\n" + //
                "│            │\n" + //
                "│O O   T     │\n" + //
                "│O O T T T   │\n" + //
                "└────────────┘\n" + //
                "POINTS: 0", this.tetris.toString());
        assertTrue(this.tetris.drop());
        this.tetris.set(new BlockL());
        this.tetris.moveRigth();
        assertEquals("   L   \n" + //
                "   L   \n" + //
                "   L L \n\n" + //
                "│            │\n" + //
                "│            │\n" + //
                "│    I I I I │\n" + //
                "│O O   T     │\n" + //
                "│O O T T T   │\n" + //
                "└────────────┘\n" + //
                "POINTS: 0", this.tetris.toString());
        assertFalse(this.tetris.drop());
    }

    @Test
    public void testToString() throws TetrisException {
        assertEquals(" O O \n" + //
                " O O \n\n" + //
                "│            │\n" + //
                "│            │\n" + //
                "│            │\n" + //
                "│            │\n" + //
                "│            │\n" + //
                "└────────────┘\n" + //
                "POINTS: 0", this.tetris.toString());
        this.tetris.drop();
        this.tetris.set(new Block());
        assertEquals(" O O \n" + //
                " O O \n\n" + //
                "│            │\n" + //
                "│            │\n" + //
                "│            │\n" + //
                "│O O         │\n" + //
                "│O O         │\n" + //
                "└────────────┘\n" + //
                "POINTS: 0", this.tetris.toString());
    }
}