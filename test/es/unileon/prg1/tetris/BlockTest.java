package es.unileon.prg1.tetris;

import static org.junit.Assert.assertEquals;

import org.junit.Before;
import org.junit.Test;

public class BlockTest {
    
    private Block block;

    @Before
    public void setUp() throws Exception {
        this.block = new Block();
    }

    @Test
    public void Block() {
        assertEquals(
            " O O \n" + //
            " O O ", block.toString()
        );
    }

    @Test
    public void blockClock() {
        this.block.spinRight();
        assertEquals(
            " O O \n" + //
            " O O " + //
            "", block.toString()
        );
    }

    @Test
    public void blockCClock() {
        this.block.spinLeft();
        assertEquals(
            " O O \n" + //
            " O O " + //
            "", block.toString()
        );
    }

    @Test
    public void BlockRight() {
        this.block.moveRight();
        assertEquals(
            "   O O \n" + //
            "   O O ", block.toString()
        );
    }

    @Test
    public void BlockLeft() {
        this.block.moveLeft();
        assertEquals(
            " O O \n" + //
            " O O ", block.toString()
        );
    }

    @Test
    public void ColorBlock(){
        Color expectedColor = Color.YELLOW;
        Color actualColor = block.getColor();
        assertEquals(expectedColor, actualColor);
    }

}