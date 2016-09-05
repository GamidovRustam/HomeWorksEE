package module02.task;

import org.junit.Test;

import static org.junit.Assert.*;

public class LongTaskTest {
    @Test
    public void execute() throws Exception {
        Task<Long> longTask = new LongTask(2L, 8L);
        longTask.execute();
        assertTrue(longTask.getResult() == 16L);
    }

}