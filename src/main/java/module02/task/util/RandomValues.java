package module02.task.util;

import static java.lang.Math.random;

public class RandomValues {
    private static final int MULTIPLIER = 100;

    public static int getRandomIntValue() {
        return (int) (MULTIPLIER * random());
    }

    public static long getRandomLongValue() {
        return (long) (MULTIPLIER * random());
    }
}


