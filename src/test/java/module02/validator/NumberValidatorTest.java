package module02.validator;

import module02.task.IntegerTask;
import module02.task.LongTask;
import module02.task.Task;
import org.junit.Test;

import static org.junit.Assert.*;

public class NumberValidatorTest {
    @Test
    public void isValid() throws Exception {
        Validator validator = new EvenNumberValidator();
        Task<Integer> intTask = new IntegerTask(24, 36);
        Task<Long> longTask = new LongTask(1L, 3L);

        intTask.execute();
        longTask.execute();

        assertTrue(validator.isValid(intTask));
        assertTrue(!validator.isValid(longTask));
    }
}