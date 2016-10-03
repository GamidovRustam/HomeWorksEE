package module0302;

import module0302.squaresum.SquareSumCounter;

import java.util.Arrays;
import java.util.concurrent.ExecutionException;

public class Runner {

    public static void main(String[] args) throws ExecutionException, InterruptedException {

        int[] array = {1, 2, 3, 4, 5, 6, 7, 8, 9};
        final int NUMBER_OF_THREADS = 4;
        SquareSumCounter squareSumCounter = new SquareSumCounter();
        System.out.println("Square sum of array: " + Arrays.toString(array) +
                "\nequal: " + squareSumCounter.getSquareSum(array, NUMBER_OF_THREADS));
    }
}
