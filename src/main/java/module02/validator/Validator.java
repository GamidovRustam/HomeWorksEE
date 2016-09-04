package module02.validator;

import module02.task.Task;

public interface Validator <T>{
    // Валидирует переданое значение
    boolean isValid(Task<? extends Number> task);
}
