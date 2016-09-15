package module03;

import module03.producer.Producer;
import module03.semaphore.SemaphoreImpl;

public class RunnerWithPermits {
    public static void main(String[] args) {

        final int permits = 2;
        SemaphoreImpl semaphore = new SemaphoreImpl(permits);
        final int amountOfProducers = 30;

        for (int i = 0; i < amountOfProducers; i++) {
            Producer p = new Producer("Producer " + i, semaphore);
            p.start();
        }
    }
}
