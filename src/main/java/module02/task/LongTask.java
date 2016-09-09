package module02.task;

public class LongTask implements Task {
    private final long a;
    private final long b;
    private long result;

    public LongTask(long a, long b) {
        this.a = a;
        this.b = b;
    }

    @Override
    public void execute() {
        result = a * b;
    }

    @Override
    public Long getResult() {
        return result;
    }

    @Override
    public String toString() {
        return getResult() + "L";
    }
}
