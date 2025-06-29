package es.unileon.prg1.tetris;

import static org.junit.Assert.assertEquals;

import org.junit.Before;
import org.junit.Test;

public class BlockTTest {
    
    private BlockT blockT;

    @Before
    public void setUp() throws Exception {
        this.blockT = new BlockT();
    }

    @Test
    public void BlockT(){
        assertEquals(
            " T T T \n" + //
            "   T   ", this.blockT.toString()
        );
    }

    @Test
    public void BlockTClock() {
        this.blockT.spinRight();
        assertEquals(
            "   T \n" + //
            " T T \n" + //
            "   T " + //
            "", this.blockT.toString()
        );
    }

    
    @Test
    public void BlockTClock2() {
        this.blockT.spinRight();
        this.blockT.spinRight();
        assertEquals(
            "   T   \n" + //
            " T T T " + //
            "", this.blockT.toString()
        );
    }

    @Test
    public void BlockTCClock() {
        this.blockT.spinLeft();
        assertEquals(
            " T   \n" + //
            " T T \n" + //
            " T   " + //
            "", this.blockT.toString()
        );
    }

    @Test
    public void BlockTRight(){
        this.blockT.moveRight();
        assertEquals(
            "   T T T \n" + //
            "     T   ", this.blockT.toString()
        );
    }

    @Test
    public void BlockTLeft(){
        this.blockT.moveLeft();
        assertEquals(
            " T T T \n" + //
            "   T   ", this.blockT.toString()
        );
    }

    @Test
    public void ColorBlockS(){
        Color expectedColor = Color.MAGENTA;
        Color actualColor = this.blockT.getColor();
        assertEquals(expectedColor, actualColor);
    }
}
