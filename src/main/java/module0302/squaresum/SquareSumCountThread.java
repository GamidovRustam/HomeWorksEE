package module0302.squaresum;

import java.util.concurrent.Callable;
import java.util.concurrent.Phaser;
import java.util.concurrent.atomic.AtomicLong;

public class SquareSumCountThread implements Callable{

    private Phaser phaser;
    private final int[] VALUES;
    private final int START_INDEX;
    private final int STOP_INDEX;
    private AtomicLong totalResult = new AtomicLong(0);

    public SquareSumCountThread(Phaser phaser, int[] values, int startIndex, int stopIndex, AtomicLong totalResult) {
        this.phaser = phaser;
        this.VALUES = values;
        this.START_INDEX = startIndex;
        this.STOP_INDEX = stopIndex;
        this.totalResult = totalResult;
    }

    @Override
    public AtomicLong call() throws InterruptedException {
        AtomicLong result = new AtomicLong();

        for (int i = START_INDEX; i <= STOP_INDEX; i++) {
            result.addAndGet(VALUES[i] * VALUES[i]);
        }

        totalResult.addAndGet(result.get());
        phaser.arriveAndAwaitAdvance();
        return totalResult;
    }
}
