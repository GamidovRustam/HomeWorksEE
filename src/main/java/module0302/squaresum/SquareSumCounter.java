package module0302.squaresum;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.*;
import java.util.concurrent.atomic.AtomicLong;

public class SquareSumCounter implements SquareSum {

    private int numberOfThreads;
    private final int DEFAULT_NUMBER_OF_THREADS = 1;
    private final Phaser phaser = new Phaser(numberOfThreads);
    private List<Callable<AtomicLong>> counters = new ArrayList<>();
    private AtomicLong squareSum = new AtomicLong();

    public SquareSumCounter(){
        this.numberOfThreads = DEFAULT_NUMBER_OF_THREADS;
    }

    @Override
    public long getSquareSum(int[] values, int numberOfThreads) {
        if (numberOfThreads > values.length) {
            numberOfThreads = values.length;
        }
        this.numberOfThreads = numberOfThreads;
        ExecutorService executor = Executors.newFixedThreadPool(this.numberOfThreads);

        int eachPartLength = values.length / this.numberOfThreads;
        int startIndex;
        int stopIndex;

        for (int i = 0; i < numberOfThreads; i++) {
            startIndex = i * eachPartLength;
            if (i == numberOfThreads - 1) {
                stopIndex = values.length - 1;
            } else {
                stopIndex = startIndex + eachPartLength - 1;
            }
            counters.add(new SquareSumCountThread(phaser, values, startIndex, stopIndex, squareSum));
            phaser.register();
        }
        try {
            executor.invokeAny(counters);
        } catch (InterruptedException | ExecutionException e) {
            e.printStackTrace();
        }
        executor.shutdown();
        return squareSum.get();
    }

    public int getNumberOfThreads() {
        return numberOfThreads;
    }
}
