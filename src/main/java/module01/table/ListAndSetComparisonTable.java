package module01.table;

import module01.measurer.CollectionsTimeMeasurer;

import java.util.*;

public class ListAndSetComparisonTable {
    private final String[] COLUMN_NAMES = {" ", ".add", ".get", ".remove", ".contains",
            "\"populate\"", "iterator.add", "iterator.remove"};
    private final int AMOUNT_OF_TABLES = 3;
    private int defaultCapacity = 10000;
    private int collectionsCapacity;
    private int amountOfMeasurements;
    private String[] headOfTable = {"Comparison table of List and Set operations time (in milliseconds). ",
            "capacity of collections = ",
            "number of measurements for each operation  = "};

    public ListAndSetComparisonTable(int numberOfMeasurements) {
        this.amountOfMeasurements = numberOfMeasurements;
        collectionsCapacity = defaultCapacity;
    }

    public String[][] compareCollectionsOperationsTime(Collection<Integer> coll1, Collection<Integer> coll2, Collection<Integer> coll3, Collection<Integer> coll4) throws Exception {
        int amountOfRows = 9;
        String[][] table = new String[amountOfRows * AMOUNT_OF_TABLES][COLUMN_NAMES.length];
        String[] bestResults = new String[COLUMN_NAMES.length];

        table[0][0] = headOfTable[0];
        bestResults[0] = "best result in:";

        for (int i = 0; i < AMOUNT_OF_TABLES; i++) {
            int rowShift = i * amountOfRows;
            table[1 + rowShift][0] = headOfTable[1] + collectionsCapacity;
            table[2 + rowShift][0] = headOfTable[2] + amountOfMeasurements;
            table[3 + rowShift] = COLUMN_NAMES;
            table[4 + rowShift] = timeResultsOfOperations(coll1);
            table[5 + rowShift] = timeResultsOfOperations(coll2);
            table[6 + rowShift] = timeResultsOfOperations(coll3);
            table[7 + rowShift] = timeResultsOfOperations(coll4);

            double timeResult;
            double nextTimeResult;
            double bestTimeResult = 0;
            String item;
            String nextItem;
            String collName;
            String nextCollName;
            String fastestCollName = "";

            for (int j = 1; j < table[j + rowShift].length; j++) {
                for (int k = 4; k < amountOfRows - 1; k++) {
                    item = table[k + rowShift][j];
                    nextItem = table[(k + 1) + rowShift][j];
                    collName = table[k + rowShift][0];
                    nextCollName = table[(k + 1) + rowShift][0];

                    if (isParseToDouble(item) && isParseToDouble(nextItem)) {
                        timeResult = parseToDouble(item);
                        nextTimeResult = parseToDouble(nextItem);
                        if (k == 4) {
                            bestTimeResult = timeResult;
                            fastestCollName = collName;
                        }
                        if (timeResult < bestTimeResult) {
                            bestResults[j] = collName;
                            bestTimeResult = timeResult;
                            fastestCollName = collName;
                        } else if (nextTimeResult < bestTimeResult) {
                            bestResults[j] = nextCollName;
                            bestTimeResult = nextTimeResult;
                            fastestCollName = nextCollName;
                        } else {
                            bestResults[j] = fastestCollName;
                        }
                    }
                }
            }
            table[8 + rowShift] = bestResults;
            collectionsCapacity *= 10;
        }
        return table;
    }

    private String[] timeResultsOfOperations(Collection<Integer> collection) throws Exception {
        CollectionsTimeMeasurer measurer = new CollectionsTimeMeasurer();
        String[] resultArray = new String[8];
        resultArray[0] = collection.getClass().getSimpleName();
        if (collection instanceof List) {
            resultArray[1] = String.format("%.4f", measurer.timeMillisOfAdd((List) collection, collectionsCapacity, amountOfMeasurements));
            resultArray[2] = String.format("%.4f", measurer.timeMillisOfGet((List) collection, collectionsCapacity, amountOfMeasurements));
            resultArray[6] = String.format("%.4f", measurer.timeMillisOfListIteratorAdd((List) collection, collectionsCapacity, amountOfMeasurements));
            resultArray[7] = String.format("%.4f", measurer.timeMillisOfListIteratorRemove((List) collection, collectionsCapacity, amountOfMeasurements));
        } else if (collection instanceof Set) {
            resultArray[1] = String.format("%.4f", measurer.timeMillisOfAdd((Set) collection, collectionsCapacity, amountOfMeasurements));
            resultArray[2] = String.format("%s", "-");
            resultArray[6] = String.format("%s", "-");
            resultArray[7] = String.format("%s", "-");
        } else {
            throw new Exception("Wrong collection type: " + collection.getClass().getSimpleName() + ". Required types: List or/and Set");
        }
        resultArray[3] = String.format("%.4f", measurer.timeMillisOfRemove(collection, collectionsCapacity, amountOfMeasurements));
        resultArray[4] = String.format("%.4f", measurer.timeMillisOfContains(collection, collectionsCapacity, amountOfMeasurements));
        resultArray[5] = String.format("%.4f", measurer.timeMillisOfPopulate(collection, collectionsCapacity, amountOfMeasurements));

        return resultArray;
    }

    private double parseToDouble(String stringWithComa) {
        return Double.parseDouble(stringWithComa.replace(',', '.'));
    }

    private boolean isParseToDouble(String string) {
        if (string == null) {
            return false;
        }

        boolean isDouble = true;
        boolean isNumberChar = false;
        char[] numberChars = {'0', '1', '2', '3', '4', '5', '6', '7', '8', '9', ',', '.'};
        char[] stringToChars = string.toCharArray();
        for (int i = 0; i < stringToChars.length; i++) {
            for (int j = 0; j < numberChars.length; j++) {
                if (stringToChars[i] == numberChars[j]) {
                    isNumberChar = true;
                }
            }
            if (!isNumberChar) {
                isDouble = false;
                break;
            }
        }
        return isDouble;
    }

    public int getCollectionsCapacity() {
        return collectionsCapacity;
    }

    public void setCollectionsCapacity(int collectionsCapacity) {
        this.collectionsCapacity = collectionsCapacity;
    }

    public int getAmountOfMeasurements() {
        return amountOfMeasurements;
    }

    public void setAmountOfMeasurements(int amountOfMeasurements) {
        this.amountOfMeasurements = amountOfMeasurements;
    }

}

