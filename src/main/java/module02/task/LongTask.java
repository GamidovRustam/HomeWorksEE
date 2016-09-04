package module02.task;

public class LongTask implements Task {
    private long a;
    private long b;
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
    public Object getResult() {
        return result;
    }

    @Override
    public String toString() {
        return getResult().toString() + "L";
    }
}
