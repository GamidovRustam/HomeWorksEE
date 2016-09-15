package module03.producer;

import module03.semaphore.SemaphoreImpl;

public class Producer extends Thread {
    private final SemaphoreImpl semaphore;
    private final int permits;
    private final String name;
    private final int workSteps = 3;

    public Producer(String name, SemaphoreImpl semaphore) {
        this.name = name;
        this.semaphore = semaphore;
        this.permits = this.semaphore.getPermits();
    }

    @Override
    public void run() {
        acquire();
        System.out.println(name + " acquired");
        try {
            for (int i = workSteps; i > 0; i--) {
                System.out.println("\t\t\t" + name + " -->work step: " + i);
                sleep(300);
            }
            release();
            System.out.println("\t" + name + " released");
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    private void acquire() {
        if (semaphore.isDEFAULT_SEMAPHORE()) {
            semaphore.acquire();
        } else {
            semaphore.acquire(semaphore.getAvailablePermits());
        }
    }

    private void release() {
        if (semaphore.isDEFAULT_SEMAPHORE()) {
            semaphore.release();
        } else {
            semaphore.release(semaphore.getPermits());
        }
    }
}
