package es.unileon.prg1.tetris;

import static org.junit.Assert.assertEquals;

import org.junit.Before;
import org.junit.Test;

public class BlockITest {
    
    private BlockI blockI;

    @Before
    public void setUp() throws Exception {
        this.blockI = new BlockI();
    }

    @Test
    public void BlockI(){
        assertEquals(
            " I \n" + //
            " I \n" + //
            " I \n" + //
            " I ", this.blockI.toString()
        );
    }

    @Test
    public void BlockIClock() {
        this.blockI.spinRight();
        assertEquals(
            " I I I I " + //
            "", this.blockI.toString()
        );
    }

    @Test
    public void BlockICClock() {
        this.blockI.spinLeft();
        assertEquals(
            " I I I I " + //
            "", this.blockI.toString()
        );
    }

    @Test
    public void BlockIRight(){
        this.blockI.moveRight();
        assertEquals(
            "   I \n" + //
            "   I \n" + //
            "   I \n" + //
            "   I ", this.blockI.toString()
        );
    }

    @Test
    public void BlockILeft(){
        this.blockI.moveLeft();
        assertEquals(
            " I \n" + //
            " I \n" + //
            " I \n" + //
            " I ", this.blockI.toString()
        );
    }

    @Test
    public void ColorBlockI(){
        Color expectedColor = Color.CYAN;
        Color actualColor = this.blockI.getColor();
        assertEquals(expectedColor, actualColor);
    }

}
