package module01.printer;

import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;

import java.io.*;

public class ResultPrinter {
    private final String TABLE_LINE = "\r\n----------------|----------------|----------------|" +
            "----------------|----------------|----------------|----------------|----------------|";
    private int maxStringLength = 15;

    public void printToConsole(String[][] table) {

        for (int i = 0; i < table.length; i++) {
            for (int j = 0; j < table[i].length; j++) {
                if (table[i][j] == null) {
                    table[i][j] = "";
                } else {
                    if (table[i][j].length() <= maxStringLength) {
                        System.out.print(String.format("%15s%2s", table[i][j], "|"));
                        if (j == table[i].length - 1) {
                            System.out.print(TABLE_LINE);
                        }
                    } else {
                        System.out.print(table[i][j]);
                    }
                }
            }
            System.out.println();
        }
        System.out.println("\n");
    }

    public void printToTextFile(String[][] table, String path) throws IOException {
        try (Writer writer = new PrintWriter(new File(path))) {

            for (int i = 0; i < table.length; i++) {
                for (int j = 0; j < table[i].length; j++) {
                    if (table[i][j] == null) {
                        table[i][j] = "";
                    } else {
                        if (table[i][j].length() <= maxStringLength && table[i][j].length() != 0) {
                            writer.write(String.format("%15s%2s", table[i][j], "|"));
                            if (j == table[i].length - 1) {
                                writer.write(TABLE_LINE);
                            }
                        } else {
                            writer.write(table[i][j]);
                        }
                    }
                }
                writer.write("\r\n");
            }
            writer.append("\r\n\r\n");
        }
    }

    public void printToXls(String[][] table, String path) throws IOException {
        Workbook workbook = new HSSFWorkbook();
        Sheet sheet = workbook.createSheet("Comparison Table");

        for (int i = 0; i < table.length; i++) {
            Row row = sheet.createRow(i);

            for (int j = 0; j < table[i].length; j++) {
                Cell cell = row.createCell(j);
                cell.setCellValue(table[i][j]);
            }
        }

        try (OutputStream out = new FileOutputStream(new File(path))) {
            workbook.write(out);
        }
    }

}
