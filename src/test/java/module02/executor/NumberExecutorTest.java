package module02.executor;

import module02.task.IntegerTask;
import module02.task.LongTask;
import module02.task.Task;
import org.junit.Test;

import static org.junit.Assert.*;

public class NumberExecutorTest {
    @Test(expected = IllegalStateException.class)
    public void addTaskAfterExecute() throws Exception {
        Executor<Number> executor = new NumberExecutor();
        Task<Integer> intTask = new IntegerTask(22, 54);
        Task<Long> longTask = new LongTask(21L, 3L);

        executor.addTask(intTask);
        executor.addTask(longTask);
        executor.execute();
        executor.addTask(new LongTask(22L, 3L));
    }

    @Test(expected = IllegalStateException.class)
    public void executeTwoTimes() throws Exception {
        Executor<Number> executor = new NumberExecutor();
        Task<Integer> intTask = new IntegerTask(18, 34);
        Task<Long> longTask = new LongTask(11L, 3L);

        executor.addTask(intTask);
        executor.addTask(longTask);
        executor.execute();
        executor.execute();
    }

    @Test(expected = NullPointerException.class)
    public void executeEmptyTasks() throws Exception {
        Executor<Number> executor = new NumberExecutor();
        executor.execute();
    }

    @Test
    public void executeGetResults() {
        Executor<Number> executor = new NumberExecutor();
        Task<Integer> intTask = new IntegerTask(18, 34);
        Task<Long> longTask = new LongTask(11L, 3L);

        executor.addTask(intTask);
        executor.addTask(longTask);
        executor.execute();

        assertTrue(!executor.getInvalidResults().isEmpty());
        assertTrue(!executor.getValidResults().isEmpty());
    }

    @Test(expected = IllegalStateException.class)
    public void getValidResults() {
        Executor<Number> executor = new NumberExecutor();
        executor.getValidResults();
    }

    @Test(expected = IllegalStateException.class)
    public void getInvalidResults() {
        Executor<Number> executor = new NumberExecutor();
        executor.getInvalidResults();
    }
}
