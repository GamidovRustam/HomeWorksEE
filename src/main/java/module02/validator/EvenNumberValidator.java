package module02.validator;

import module02.task.Task;

public class EvenNumberValidator implements Validator<Task<? extends Number>> {

    @Override
    public boolean isValid(Task<? extends Number> task) {
        return task.getResult().longValue() % 2 == 0;
    }
}
