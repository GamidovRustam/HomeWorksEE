package module0302.squaresum;

import org.junit.Assert;
import org.junit.Test;

import static org.junit.Assert.*;

public class SquareSumCounterTest {

    @Test
    public void getSquareSumTest() {
        int[] arr = {1, 2, 3, 4, 5, 6, 7, 8, 9};
        SquareSumCounter counter = new SquareSumCounter();
        long res = counter.getSquareSum(arr, 4);
        Assert.assertEquals(285L, res);
    }

    @Test(expected = IllegalArgumentException.class)
    public void getSquareSumEmptyArrayTest() {
        int[] arr = {};
        SquareSumCounter counter = new SquareSumCounter();
        counter.getSquareSum(arr, 4);
    }

}