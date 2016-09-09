package module02.executor;

import module02.task.Task;
import module02.validator.Validator;

import java.util.List;

public interface Executor <T> {
    // Добавить таск на выполнение. Результат таска будет доступен через метод printValidResults().
    // Бросает Эксепшн если уже был вызван метод execute()
    void addTask(Task<? extends T> task) throws IllegalStateException;

    // Добавить таск на выполнение и валидатор результата. Результат таска будет записан в ValidResults если validator.isValid вернет true для этого результата
    // Результат таска будет записан в InvalidResults если validator.isValid вернет false для этого результата
    // Бросает Эксепшн если уже был вызван метод execute()
    void addTask(Task<? extends T> task, Validator<T> validator) throws IllegalStateException;

    // Выполнить все добавленые таски
    void execute();

    // Получить валидные результаты. Бросает Эксепшн если не был вызван метод execute()
    List<? extends T> getValidResults();

    // Получить невалидные результаты. Бросает Эксепшн если не был вызван метод execute()
    List<? extends T> getInvalidResults();

}
