package es.unileon.prg1.tetris;

import static org.junit.Assert.assertEquals;

import org.junit.Before;
import org.junit.Test;

public class BlockSTest {
    
    private BlockS blockS;

    @Before
    public void setUp() throws Exception {
        this.blockS = new BlockS();
    }

    @Test
    public void BlockS(){
        assertEquals(
            "   S S \n" + //
            " S S   ", blockS.toString()
        );
    }

    @Test
    public void BlockSClock() {
        this.blockS.spinRight();
        assertEquals(
            " S   \n" + //
            " S S \n" + //
            "   S " + //
            "", blockS.toString()
        );
    }

    @Test
    public void BlockSCClock() {
        this.blockS.spinLeft();
        assertEquals(
            " S   \n" + //
            " S S \n" + //
            "   S " + //
            "", blockS.toString()
        );
    }

    @Test
    public void BlockSRigth(){
        this.blockS.moveRight();
        assertEquals(
            "     S S \n" + //
            "   S S   ", blockS.toString()
        );
    }

    @Test
    public void BlockSLeft(){
        this.blockS.moveLeft();
        assertEquals(
            "   S S \n" + //
            " S S   ", blockS.toString()
        );
    }

    @Test
    public void ColorBlockS(){
        Color expectedColor = Color.RED;
        Color actualColor = blockS.getColor();
        assertEquals(expectedColor, actualColor);
    }

}
