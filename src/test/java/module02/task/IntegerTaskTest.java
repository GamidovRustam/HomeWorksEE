package module02.task;

import org.junit.Test;

import static org.junit.Assert.*;

public class IntegerTaskTest {
    @Test
    public void execute() throws Exception {
        Task<Integer> intTask = new IntegerTask(2, 8);
        intTask.execute();
        assertTrue(intTask.getResult() == 16);
    }

}