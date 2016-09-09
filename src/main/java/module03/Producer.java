package module03;

import java.util.ArrayList;
import java.util.List;

public class Producer extends Thread {

    private List<Thread> threads = new ArrayList<>();
    private int numberOfThreads;

    public Producer(int numberOfThreads) {
        this.numberOfThreads = numberOfThreads;
        createThreads();
    }

    private void createThreads() {
        for (int i = 0; i < numberOfThreads; i++) {
            Thread t = new Thread(this);
            threads.add(t);
            System.out.println(t.getName() + " created");
        }
    }


    @Override
    public void run() {
        for (Thread t : threads) {
            for (int i = 0; i < 1000; i++) {
                System.out.println(t.getName() + " =" + i);
            }
        }

    }
}
