package es.unileon.prg1.tetris;

import static org.junit.Assert.assertEquals;

import org.junit.Before;
import org.junit.Test;

public class BlockLTest {
    
    private BlockL blockL;

    @Before
    public void setUp() throws Exception {
        this.blockL = new BlockL();
    }

    @Test
    public void BlockL(){
        assertEquals(
            " L   \n" + //
            " L   \n" + //
            " L L ", this.blockL.toString()
        );
    }

    @Test
    public void BlockLClock() {
        this.blockL.spinRight();
        assertEquals(
            " L L L \n" + //
            " L     " + //
            "", this.blockL.toString()
        );
    }

    @Test
    public void BlockCClock() {
        this.blockL.spinLeft();
        assertEquals(
            "     L \n" + //
            " L L L " + //
            "", this.blockL.toString()
        );
    }

    @Test
    public void BlockLRight(){
        this.blockL.moveRight();
        assertEquals(
            "   L   \n" + //
            "   L   \n" + //
            "   L L ", this.blockL.toString()
        );
    }

    @Test
    public void BlockLLeft(){
        this.blockL.moveLeft();
        assertEquals(
            " L   \n" + //
            " L   \n" + //
            " L L ", this.blockL.toString()
        );
    }

    @Test
    public void ColorBlockL(){
        Color expectedColor = Color.WHITE;
        Color actualColor = this.blockL.getColor();
        assertEquals(expectedColor, actualColor);
    }

}
