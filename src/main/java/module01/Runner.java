package module01;

import module01.table.ListAndSetComparisonTable;
import module01.printer.ResultPrinter;

import java.util.*;

public class Runner {
    public static void main(String[] args) throws Exception {
        List<Integer> arrayList = new ArrayList();
        List<Integer> linkedList = new LinkedList();
        Set<Integer> set = new HashSet();
        Set<Integer> treeSet = new TreeSet();

        ListAndSetComparisonTable table = new ListAndSetComparisonTable(100);
        System.out.println("This program measure the time of <List> fnd <Set> operations," +
                " and show the \"faster\" collection for each operation." +
                "\n Results will be printed to text file, excel file and to the console.\n");
        System.out.println("The measurements in process. It may take some time....) \n");
        String[][] resultsTable = table.compareCollectionsOperationsTime(arrayList, linkedList, set, treeSet);
        ResultPrinter printer = new ResultPrinter();

        printer.printToConsole(resultsTable);
        printer.printToTextFile(resultsTable, "Comparison table.txt");
        printer.printToXls(resultsTable, "Comparison table.xls");

    }
}






















