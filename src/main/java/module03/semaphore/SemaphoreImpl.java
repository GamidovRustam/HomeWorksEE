package module03.semaphore;

public class SemaphoreImpl implements Semaphore {
    private int permits;
    private int availablePermits;
    private final int DEFAULT_PERMITS = 1;
    private final boolean DEFAULT_SEMAPHORE;

    public SemaphoreImpl() {
        this.permits = DEFAULT_PERMITS;
        this.DEFAULT_SEMAPHORE = true;
    }

    public SemaphoreImpl(int permits) {
        this.permits = permits;
        this.DEFAULT_SEMAPHORE = false;
    }

    @Override
    public void acquire() {
        while (availablePermits == DEFAULT_PERMITS) {
            synchronized (this) {
                try {
                    wait();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }
        availablePermits++;
    }

    @Override
    public void acquire(int permits) {
        permits = this.permits;
        while (availablePermits == permits) {
            synchronized (this) {
                try {
                    wait();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }
        availablePermits++;
    }

    @Override
    public void release() {
        if (availablePermits == permits) {
            availablePermits--;
            synchronized (this) {
                notify();
            }
        }
    }

    @Override
    public void release(int permits) {
        if (availablePermits == permits) {
            availablePermits = 0;
            synchronized (this) {
                notifyAll();
            }
        }
    }

    @Override
    public int getAvailablePermits() {
        return availablePermits;
    }

    public boolean isDEFAULT_SEMAPHORE() {
        return DEFAULT_SEMAPHORE;
    }

    public int getPermits() {
        return permits;
    }
}
