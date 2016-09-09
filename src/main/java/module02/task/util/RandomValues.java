package module02.task.util;

import static java.lang.Math.random;

public class RandomValues {
    private int multiplier;
    private final int DEFAULT_MULTIPLIER = 100;

    public RandomValues() {
        this.multiplier = DEFAULT_MULTIPLIER;
    }

    public RandomValues(int multiplier) {
        this.multiplier = multiplier;
    }

    public int getIntValue() {
        return (int) (multiplier * random());
    }

    public long getLongValue() {
        return (long) (multiplier * random());
    }

    public int getMultiplier() {
        return multiplier;
    }

    public void setMultiplier(int multiplier) {
        this.multiplier = multiplier;
    }
}


