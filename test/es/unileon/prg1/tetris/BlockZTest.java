package es.unileon.prg1.tetris;

import static org.junit.Assert.assertEquals;

import org.junit.Before;
import org.junit.Test;

public class BlockZTest {

    private BlockZ blockZ;

    @Before
    public void setUp() throws Exception {
        this.blockZ = new BlockZ();
    }

    @Test
    public void BlockZ(){
        assertEquals(
            " Z Z   \n" + //
            "   Z Z ", this.blockZ.toString()
        );
    }

    @Test
    public void BlockZClock() {
        this.blockZ.spinRight();
        assertEquals(
            "   Z \n" + //
            " Z Z \n" + //
            " Z   " + //
            "", this.blockZ.toString()
        );
    }

    @Test
    public void BlockZCClock() {
        this.blockZ.spinLeft();
        assertEquals(
            "   Z \n" + //
            " Z Z \n" + //
            " Z   " + //
            "", this.blockZ.toString()
        );
    }

    @Test
    public void BlockZRight(){
        this.blockZ.moveRight();
        assertEquals(
            "   Z Z   \n" + //
            "     Z Z ", this.blockZ.toString()
        );
    }

    @Test
    public void BlockZLeft(){
        this.blockZ.moveLeft();
        assertEquals(
            " Z Z   \n" + //
            "   Z Z ", this.blockZ.toString()
        );
    }

    @Test
    public void ColorBlockZ(){
        Color expectedColor = Color.GREEN;
        Color actualColor = this.blockZ.getColor();
        assertEquals(expectedColor, actualColor);
    }
}
