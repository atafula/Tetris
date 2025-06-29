package es.unileon.prg1.tetris;

import static org.junit.Assert.assertEquals;

import org.junit.Before;
import org.junit.Test;

public class BlockJTest {
    
    private BlockJ blockJ;

    @Before
    public void setUp() throws Exception {
        this.blockJ = new BlockJ();
    }


    @Test
    public void BockJ(){
        assertEquals(
            "   J \n" + //
            "   J \n" + //
            " J J ", this.blockJ.toString()
        );
    }

    @Test
    public void BlockJClock() {
        this.blockJ.spinRight();
        assertEquals(
            " J     \n" + //
            " J J J " + //
            "", this.blockJ.toString()
        );
    }

    @Test
    public void BlockJCClock() {
        this.blockJ.spinLeft();
        assertEquals(
            " J J J \n" + //
            "     J " + //
            "", this.blockJ.toString()
        );
    }

    @Test
    public void BockJRight(){
        this.blockJ.moveRight();
        assertEquals(
            "     J \n" + //
            "     J \n" + //
            "   J J ", this.blockJ.toString()
        );
    }

    @Test
    public void BockJLeft(){
        this.blockJ.moveLeft();
        assertEquals(
            "   J \n" + //
            "   J \n" + //
            " J J ", this.blockJ.toString()
        );
    }

    @Test
    public void ColorBlockJ(){
        Color expectedColor = Color.BLUE;
        Color actualColor = this.blockJ.getColor();
        assertEquals(expectedColor, actualColor);
    }
}
