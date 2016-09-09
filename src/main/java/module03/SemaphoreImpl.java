package module03;

public class SemaphoreImpl implements Semaphore {

    private int availablePermits;
    private Object lock = new Object();


    public SemaphoreImpl(){

    }

    @Override
    public void acquire() throws InterruptedException {
        while (true) {
            synchronized (lock) {
                while (availablePermits <= 0) {
                    availablePermits++;
                    wait();
                    System.out.println(Thread.currentThread().getName() + " waiting");
                }
            }
            release();
        }

    }

    @Override
    public void acquire(int permits) {

    }

    @Override
    public void release() throws InterruptedException {
        while (true) {
            synchronized (lock) {
                while (availablePermits > 0) {
                    availablePermits--;
                    notify();
                    System.out.println(Thread.currentThread().getName() + " notify");
                }
            }
            acquire();
        }
    }

    @Override
    public void release(int permits) {

    }

    @Override
    public int getAvailablePermits() {
        return availablePermits;
    }
}
