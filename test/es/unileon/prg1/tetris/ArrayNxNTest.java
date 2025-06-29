package es.unileon.prg1.tetris;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;
import static org.junit.Assert.assertNull;

import org.junit.Before;
import org.junit.Test;

public class ArrayNxNTest {

    private ArrayNxN array2, array3, array4;

    @Before
    public void setUp() throws Exception {
        this.array2 = new ArrayNxN(2);

        this.array3 = new ArrayNxN(3);
        array3.set(0, 0, 1);
        array3.set(0, 1, 1);
        array3.set(0, 2, 1);
        array3.set(1, 1, 1);

        this.array4 = new ArrayNxN(4);
        array4.set(0, 3, 1);
        array4.set(1, 3, 1);
        array4.set(2, 3, 1);
        array4.set(3, 3, 1);
    }

    @Test
    public void testArrayInt() {
        assertEquals("00\n" + //
                "00\n", this.array2.toString());
        assertEquals("111\n" + //
                "010\n" + //
                "000\n" //
                , this.array3.toString());
        assertEquals("0001\n" + //
                "0001\n" + //
                "0001\n" + //
                "0001\n", this.array4.toString());
    }

    @Test
    public void testArrayArray(){
        ArrayMxN newArray = new ArrayMxN(4,1);
        newArray.set(0,0,1);
        newArray.set(1,0,1);
        newArray.set(2,0,1);
        newArray.set(3,0,1);
        assertEquals("1000\n" + //
                     "1000\n" + //
                     "1000\n" + //
                     "1000\n" //
                     , new ArrayNxN(newArray).toString());

    }

    @Test
    public void testGetMinArray() {
        assertNull(this.array2.getMinArray());
        assertEquals("111\n" + //
                "010\n", this.array3.getMinArray().toString());
        assertEquals("01\n11\n01\n"
                , this.array3.spinRight().getMinArray().toString());
        assertEquals("1\n1\n1\n1\n" //
                , this.array4.getMinArray().toString());
        assertEquals("1111\n" //
                , this.array4.spinRight().getMinArray().toString());
    }

    @Test
    public void testGet() {
        assertEquals(1, this.array3.get(0, 0));
        assertEquals(1, this.array3.get(0, 1));
        assertEquals(1, this.array3.get(0, 2));
        assertEquals(0, this.array3.get(1, 0));
        assertEquals(1, this.array3.get(1, 1));
        assertEquals(0, this.array3.get(1, 2));
        assertEquals(0, this.array3.get(2, 0));
        assertEquals(0, this.array3.get(2, 1));
        assertEquals(0, this.array3.get(2, 2));
    }

    @Test
    public void testGetLessThanMinRow() {
        assertEquals(Integer.MIN_VALUE, this.array3.get(-1, 0));
    }

    @Test
    public void testGetMoreThanMaxRow() {
        assertEquals(Integer.MIN_VALUE, this.array3.get(3, 0));
    }

    @Test
    public void testGetLessThanMinColumn() {
        assertEquals(Integer.MIN_VALUE, this.array3.get(0, -1));
    }

    @Test
    public void testGetMoreThanMaxColumn() {
        assertEquals(Integer.MIN_VALUE, this.array3.get(0, 3));
    }

    @Test
    public void testSet() {
        assertEquals(1, this.array3.get(0, 0));
        assertTrue(this.array3.set(0, 0, 0));
        assertEquals(0, this.array3.get(0, 0));
    }

    @Test
    public void testSetLessThanMinRow() {
        assertFalse(this.array3.set(-1, 0, 0));
    }

    @Test
    public void testSetMoreThanMaxRow() {
        assertFalse(this.array3.set(3, 0, 0));
    }

    @Test
    public void testSetLessThanMinColumn() {
        assertFalse(this.array3.set(0, -1, 0));
    }

    @Test
    public void testSetMoreThanMaxColumn() {
        assertFalse(this.array3.set(0, 3, 0));
    }

    @Test
    public void testGetIdentity() {
        assertEquals("10\n" + //
                "01\n" //
                , this.array2.getIdentity().toString());
        assertEquals("100\n" + //
                "010\n" + //
                "001\n" //
                , this.array3.getIdentity().toString());
        assertEquals("1000\n" + //
                "0100\n" + //
                "0010\n" + //
                "0001\n" //
                , this.array4.getIdentity().toString());
    }

    @Test
    public void testMirrorH() {
        ArrayNxN minArray = new ArrayNxN(1);
        minArray.set(0,0,0);
        assertEquals("0\n"
                , minArray.toString());
        assertEquals("00\n" + //
                "00\n" //
                , this.array2.mirrorH().toString());
        assertEquals("000\n" + //
                "010\n" + //
                "111\n" //
                , this.array3.mirrorH().toString());
        assertEquals("0001\n" + //
                "0001\n" + //
                "0001\n" + //
                "0001\n" //
                , this.array4.mirrorH().toString());
    }

    @Test
    public void testMirrorV() {
        assertEquals("00\n" + //
                "00\n" //
                , this.array2.mirrorV().toString());
        assertEquals("111\n" + //
                "010\n" + //
                "000\n" //
                , this.array3.mirrorV().toString());
        assertEquals("1000\n" + //
                "1000\n" + //
                "1000\n" + //
                "1000\n" //
                , this.array4.mirrorV().toString());
    }

    @Test
    public void testTranspose() {
        assertEquals("00\n" + //
                "00\n" //
                , this.array2.transpose().toString());
        assertEquals("100\n" + //
                "110\n" + //
                "100\n" //
                , this.array3.transpose().toString());
        assertEquals("0000\n" + //
                "0000\n" + //
                "0000\n" + //
                "1111\n" //
                , this.array4.transpose().toString());
    }

    @Test
    public void testMultiply() {
        assertEquals("111\n" + //
                "010\n" + //
                "000\n" //
                , this.array3.multiply(this.array3.getIdentity()).toString());
        assertEquals("0001\n" + //
                "0001\n" + //
                "0001\n" + //
                "0001\n" //
                , this.array4.multiply(this.array4.getIdentity()).toString());
    }

    @Test
    public void testMultiplyWrongDimension() {
        assertNull(this.array3.multiply(this.array4.getIdentity()));
        assertNull(this.array4.multiply(this.array3.getIdentity()));
    }

    @Test
    public void testSpinRight() {
        ArrayNxN spinned;
        spinned = this.array3.spinRight();
        assertEquals("001\n" + //
                "011\n" + //
                "001\n" //
                , spinned.toString());
        spinned = spinned.spinRight();
        assertEquals("000\n" + //
                "010\n" + //
                "111\n" //
                , spinned.toString());
        spinned = spinned.spinRight();
        assertEquals("100\n" + //
                "110\n" + //
                "100\n" //
                , spinned.toString());
        spinned = spinned.spinRight();
        assertEquals("111\n" + //
                "010\n" + //
                "000\n" //
                , spinned.toString());
    }

    @Test
    public void testSpinLeft() {
        ArrayNxN spinned;
        spinned = this.array3.spinLeft();
        assertEquals("100\n" + //
                "110\n" + //
                "100\n" //
                , spinned.toString());
        spinned = spinned.spinLeft();
        assertEquals("000\n" + //
                "010\n" + //
                "111\n" //
                , spinned.toString());
        spinned = spinned.spinLeft();
        assertEquals("001\n" + //
                "011\n" + //
                "001\n" //
                , spinned.toString());
        spinned = spinned.spinLeft();
        assertEquals("111\n" + //
                "010\n" + //
                "000\n" //
                , spinned.toString());
    }

    @Test
    public void testToString() {
        assertEquals("111\n" + //
                "010\n" + //
                "000\n" //
                , this.array3.toString());
        assertEquals("0001\n" + //
                "0001\n" + //
                "0001\n" + //
                "0001\n", this.array4.toString());
    }

}