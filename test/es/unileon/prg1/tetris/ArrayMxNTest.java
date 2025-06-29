package es.unileon.prg1.tetris;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;
import static org.junit.Assert.assertFalse;

import org.junit.Before;
import org.junit.Test;

public class ArrayMxNTest {

    private ArrayMxN array3, array4;

    @Before
    public void setUp() throws Exception {
        this.array3 = new ArrayMxN(2, 3);
        array3.set(0, 0, 1);
        array3.set(0, 1, 1);
        array3.set(0, 2, 1);
        array3.set(1, 1, 1);

        this.array4 = new ArrayMxN(4, 1);
        array4.set(0, 0, 1);
        array4.set(1, 0, 1);
        array4.set(2, 0, 1);
        array4.set(3, 0, 1);
    }

    @Test
    public void testArrayIntInt() {
        assertEquals("111\n" + //
                "010\n", this.array3.toString());
        assertEquals("1\n" + //
                "1\n" + //
                "1\n" + //
                "1\n", this.array4.toString());
    }

    @Test
    public void testRows() {
        assertEquals(2, this.array3.rows());
        assertEquals(4, this.array4.rows());
    }

    @Test
    public void testColumns() {
        assertEquals(3, this.array3.columns());
        assertEquals(1, this.array4.columns());
    }

    @Test
    public void testGetOk() {
        assertEquals(1, this.array3.get(0, 0));
        assertEquals(1, this.array3.get(0, 1));
        assertEquals(1, this.array3.get(0, 2));
        assertEquals(0, this.array3.get(1, 0));
        assertEquals(1, this.array3.get(1, 1));
        assertEquals(0, this.array3.get(1, 2));
    }

    @Test
    public void testGetNotOk() {
        assertEquals(Integer.MIN_VALUE, this.array3.get(-1, 0));
        assertEquals(Integer.MIN_VALUE, this.array3.get(3, 0));
        assertEquals(Integer.MIN_VALUE, this.array3.get(0, -1));
        assertEquals(Integer.MIN_VALUE, this.array3.get(0, 3));
    }

    @Test
    public void testSetOK() {
        assertEquals(1, this.array3.get(0, 0));
        assertTrue(this.array3.set(0, 0, 0));
        assertEquals(0, this.array3.get(0, 0));
    }

    @Test
    public void testSetNotOK() {
        assertFalse(this.array3.set(-1, 0, 1));
        assertFalse(this.array3.set(3, 0, 1));
        assertFalse(this.array3.set(0, -1, 1));
        assertFalse(this.array3.set(0, 3, 1));
    }

    @Test
    public void testToString() {
        assertEquals("111\n" + //
                "010\n", this.array3.toString());
        assertEquals("1\n" + //
                "1\n" + //
                "1\n" + //
                "1\n", this.array4.toString());
    }
}
