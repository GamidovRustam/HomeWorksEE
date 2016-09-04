package module02.executor;

import module02.task.Task;
import module02.validator.Validator;

import java.util.ArrayList;
import java.util.List;

public class NumberExecutor implements Executor<Number> {
    private boolean isExecuted = false;
    private Validator validator;
    private List<Task> tasks = new ArrayList<>();
    private List<Task> validResults = new ArrayList<>();
    private List<Task> invalidResults = new ArrayList<>();

    public NumberExecutor() {
        this.validator = new DefaultValidator();
    }

    public NumberExecutor(Validator validator) {
        this.validator = validator;
    }

    @Override
    public void addTask(Task task) throws IllegalStateException {
        checkIfNotExecuted();
        tasks.add(task);
    }

    @Override
    public void addTask(Task task, Validator validator) throws IllegalStateException {
        this.validator = validator;
        checkIfNotExecuted();
        try{
            tasks.add(task);
        } catch (IllegalStateException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void execute() {
        checkIfNotExecuted();
        if (tasks.isEmpty()) {
            throw new NullPointerException("The task list is empty");
        }

        for (Task t : tasks) {
            t.execute();
            if (validator.isValid(t)) {
                validResults.add(t);
            } else {
                invalidResults.add(t);
            }
        }
        isExecuted = true;
    }

    @Override
    public List getValidResults() {
        checkIfExecuted();
        return validResults;
    }

    @Override
    public List getInvalidResults() {
        checkIfExecuted();
        return invalidResults;
    }

    private void checkIfNotExecuted() {
        if (isExecuted) {
            throw new IllegalStateException("All tasks are already executed!");
        }
    }

    private void checkIfExecuted() {
        if (!isExecuted) {
            throw new IllegalStateException("The task are not executed yet!");
        }
    }

    private class DefaultValidator implements Validator<Number> {

        //checking for even numbers
        @Override
        public boolean isValid(Task<? extends Number> task) {
            return task.getResult().longValue() % 2 == 0;
        }
    }

}
