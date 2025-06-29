package es.unileon.prg1.tetris;

import static org.junit.Assert.*;
import org.junit.Before;
import org.junit.Test;

public class BoardTest {
    
    private BlockI block;
    private Board board;

    @Before
    public void setUp() throws Exception {
        board = new Board(10, 10);
        block = new BlockI();
    }

    @Test
    public void testGetPoints() {
        assertEquals(0, board.getPoints());
    }

    @Test
    public void testToString() {
        assertNotNull(board.toString());
        assertTrue(board.toString().contains("POINTS"));
    }

    @Test
    public void testUpdateBoardInvalidPosition() throws TetrisException {
        int rowToCheck = -1;
        int colToCheck = 3;
        assertFalse(rowToCheck >= 0 && rowToCheck < this.board.getRows() && colToCheck >= 0 && colToCheck < this.board.getColumns());
    }

    @Test
    public void testRows() {
        assertEquals(10, this.board.getRows());
    }

    @Test
    public void testCols() {
        assertEquals(10, this.board.getColumns());
    }

    @Test
    public void cantDrop() throws TetrisException {
        this.board.updateBoard(block);
        this.board.updateBoard(block);
        assertFalse(this.board.candrop(block));
    }

    @Test
    public void canDrop() throws TetrisException {
        assertTrue(this.board.candrop(block));
    }

    @Test
    public void boardString() {
        assertEquals("\n\n"+
                "│                    │\n" + //
                "│                    │\n" + //
                "│                    │\n" + //
                "│                    │\n" + //
                "│                    │\n" + //
                "│                    │\n" + //
                "│                    │\n" + //
                "│                    │\n" + //
                "│                    │\n" + //
                "│                    │\n" + //
                "└────────────────────┘\n" + //
                "POINTS: 0",this.board.toString());
    }

    @Test
    public void backwardsRotate() throws TetrisException {

    }

}