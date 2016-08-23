package module01.measurer;

import java.util.*;

public class CollectionsTimeMeasurer {
    private double start;
    private double averageTime;

    public double timeMillisOfAdd(List<Integer> list, int collectionCapacity, int numberOfMeasurements) {
        double totalResultTime = 0;

        populateCollection(list, collectionCapacity);

        for (int i = 0; i < numberOfMeasurements; i++) {
            start = System.nanoTime();
            list.add((list.size() / 2), i);//adding in center of collection
            totalResultTime += System.nanoTime() - start;
        }
        list.clear();
        return averageTime = convertNanoTimeToMillis(countAverageTime(totalResultTime, numberOfMeasurements));
    }

    public double timeMillisOfAdd(Set<Integer> set, int collectionCapacity, int numberOfMeasurements) {
        double totalResultTime = 0;

        populateCollection(set, collectionCapacity);

        for (int i = 0; i < numberOfMeasurements; i++) {
            start = (double) System.nanoTime();
            set.add(i);//adding the new elements
            totalResultTime += (double) System.nanoTime() - start;
        }
        set.clear();
        return averageTime = convertNanoTimeToMillis(countAverageTime(totalResultTime, numberOfMeasurements));
    }

    public double timeMillisOfListIteratorAdd(List<Integer> list, int collectionCapacity, int numberOfMeasurements) {
        double totalResultTime = 0;

        populateCollection(list, collectionCapacity);

        for (int i = 0; i < numberOfMeasurements; i++) {
            start = System.nanoTime();
            list.listIterator().add(i);
            totalResultTime += System.nanoTime() - start;
        }
        list.clear();
        return averageTime = convertNanoTimeToMillis(countAverageTime(totalResultTime, numberOfMeasurements));
    }

    public double timeMillisOfRemove(Collection<Integer> collection, int collectionCapacity, int numberOfMeasurements) {
        double totalResultTime = 0;

        collectionCapacity = ensureExplicitCapacity(collectionCapacity, numberOfMeasurements);
        populateCollection(collection, collectionCapacity);

        for (int i = 0; i < numberOfMeasurements; i++) {
            start = System.nanoTime();
            collection.remove(i);
            totalResultTime += System.nanoTime() - start;
        }
        collection.clear();
        return averageTime = convertNanoTimeToMillis(countAverageTime(totalResultTime, numberOfMeasurements));
    }

    public double timeMillisOfListIteratorRemove(List<Integer> list, int collectionCapacity, int numberOfMeasurements) {
        double totalResultTime = 0;

        collectionCapacity = ensureExplicitCapacity(collectionCapacity, numberOfMeasurements);
        populateCollection(list, collectionCapacity);

        ListIterator<Integer> listIterator = list.listIterator();

        for (int i = 0; i < numberOfMeasurements; i++) {
            start = System.nanoTime();
            listIterator.next();
            listIterator.remove();
            totalResultTime += System.nanoTime() - start;
        }
        return averageTime = convertNanoTimeToMillis(countAverageTime(totalResultTime, numberOfMeasurements));
    }

    public double timeMillisOfPopulate(Collection collection, int collectionCapacity, int numberOfMeasurements) {
        double totalResultTime = 0;

        for (int i = 0; i < numberOfMeasurements; i++) {
            start = System.nanoTime();
            populateCollection(collection, collectionCapacity);
            totalResultTime += System.nanoTime() - start;
            collection.clear();
        }
        return averageTime = convertNanoTimeToMillis(countAverageTime(totalResultTime, numberOfMeasurements));
    }

    public double timeMillisOfContains(Collection<Integer> collection, int collectionCapacity, int numberOfMeasurements) {
        double totalResultTime = 0l;

        collectionCapacity = ensureExplicitCapacity(collectionCapacity, numberOfMeasurements);
        populateCollection(collection, collectionCapacity);

        for (int i = 0; i < numberOfMeasurements; i++) {
            start = System.nanoTime();
            collection.contains(i);
            totalResultTime += System.nanoTime() - start;
        }
        return averageTime = convertNanoTimeToMillis(countAverageTime(totalResultTime, numberOfMeasurements));
    }

    public double timeMillisOfGet(List<Integer> list, int collectionCapacity, int numberOfMeasurements) {
        double totalResultTime = 0l;

        collectionCapacity = ensureExplicitCapacity(collectionCapacity, numberOfMeasurements);
        populateCollection(list, collectionCapacity);

        for (int i = 0; i < numberOfMeasurements; i++) {
            start = System.nanoTime();
            list.get(i);
            totalResultTime += System.nanoTime() - start;
        }
        return averageTime = convertNanoTimeToMillis(countAverageTime(totalResultTime, numberOfMeasurements));
    }

    private void populateCollection(Collection collection, int capacity) {
        for (int i = 0; i < capacity; i++) {
            collection.add(i);
        }
    }

    private int ensureExplicitCapacity(int capacity, int requiredCapacity) {
        if (capacity - requiredCapacity < 0) {
            capacity = requiredCapacity;
        }
        return capacity;
    }

    private double convertNanoTimeToMillis(double nanoTime) {
        return nanoTime / 1000000;
    }

    private double countAverageTime(double totalResult, int numberOfMeasurements) {
        return totalResult / numberOfMeasurements;
    }

}
