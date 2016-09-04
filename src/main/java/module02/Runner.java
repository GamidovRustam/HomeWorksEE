package module02;

import module02.executor.Executor;
import module02.executor.NumberExecutor;
import module02.task.IntegerTask;
import module02.task.LongTask;
import module02.validator.EvenNumberValidator;
import module02.validator.Validator;

import static module02.task.util.RandomValues.getRandomIntValue;
import static module02.task.util.RandomValues.getRandomLongValue;

import java.util.ArrayList;
import java.util.List;

public class Runner {
    public static void main(String[] args) {
        List<IntegerTask> intTasks = new ArrayList<>();
        List<LongTask> longTasks = new ArrayList<>();

        //add random integer values tasks
        for (int i = 0; i < 10; i++) {
            intTasks.add(new IntegerTask(getRandomIntValue(), getRandomIntValue()));
        }

        //add random long values tasks
        for (int i = 0; i < 10; i++) {
            longTasks.add(new LongTask(getRandomLongValue(), getRandomLongValue()));
        }

        Executor<Number> executor = new NumberExecutor();
        Validator validator = new EvenNumberValidator();

        for (IntegerTask intTask : intTasks) {
            executor.addTask(intTask);
        }

        for (LongTask longTask : longTasks) {
            executor.addTask(longTask, validator);
        }

        executor.execute();

        System.out.println("Valid results: ");
        System.out.println(executor.getValidResults().toString() + "\n");

        System.out.println("Invalid results: ");
        System.out.println(executor.getInvalidResults().toString());

    }
}
