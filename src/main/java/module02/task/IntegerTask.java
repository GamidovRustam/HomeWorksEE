package module02.task;

public class IntegerTask implements Task<Integer> {
    private int a;
    private int b;
    private int result;

    public IntegerTask(int a, int b) {
        this.a = a;
        this.b = b;
    }

    @Override
    public void execute() {
        result = a * b;
    }

    @Override
    public Integer getResult() {
        return result;
    }

    @Override
    public String toString() {
        return getResult().toString();
    }
}
