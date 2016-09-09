package module02;

import module02.executor.Executor;
import module02.executor.NumberExecutor;
import module02.validator.EvenNumberValidator;
import module02.validator.Validator;

public class Runner {
    public static void main(String[] args) {

        Executor<Number> executor = new NumberExecutor();
        Validator validator = new EvenNumberValidator();

        App app = new App(executor);
        app.createRandomIntTasks(10);
        app.createRandomLongTasks(10);
        app.addIntTasksToExecutor();
        app.addLongTasksToExecutor(validator);
        app.execute();
        app.printValidResults();
        app.printInvalidResults();
    }
}
