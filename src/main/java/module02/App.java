package module02;

import module02.executor.Executor;
import module02.task.IntegerTask;
import module02.task.LongTask;
import module02.task.util.RandomValues;
import module02.validator.Validator;

import java.util.ArrayList;
import java.util.List;

public class App {
    private List<IntegerTask> intTasks = new ArrayList<>();
    private List<LongTask> longTasks = new ArrayList<>();
    private RandomValues random = new RandomValues();
    private Executor<Number> executor;

    public App(Executor executor) {
        this.executor = executor;
    }

    public void createRandomIntTasks(int numberOfTasks) {
        for (int i = 0; i < numberOfTasks; i++) {
            intTasks.add(new IntegerTask(random.getIntValue(), random.getIntValue()));
        }
    }

    public void createRandomLongTasks(int numberOfTasks) {
        for (int i = 0; i < numberOfTasks; i++) {
            longTasks.add(new LongTask(random.getLongValue(), random.getLongValue()));
        }
    }

    public void addIntTasksToExecutor() {
        for (IntegerTask intTask : intTasks) {
            executor.addTask(intTask);
        }
    }

    public void addIntTasksToExecutor(Validator validator) {
        for (IntegerTask intTask : intTasks) {
            executor.addTask(intTask, validator);
        }
    }

    public void addLongTasksToExecutor() {
        for (LongTask longTask : longTasks) {
            executor.addTask(longTask);
        }
    }

    public void addLongTasksToExecutor(Validator validator) {
        for (LongTask longTask : longTasks) {
            executor.addTask(longTask, validator);
        }
    }

    public void execute(){
        executor.execute();
    }

    public void printValidResults() {
        System.out.println("Valid results: ");
        System.out.println(executor.getValidResults().toString() + "\n");
    }

    public void printInvalidResults() {
        System.out.println("Invalid results: ");
        System.out.println(executor.getInvalidResults().toString());
    }
}
