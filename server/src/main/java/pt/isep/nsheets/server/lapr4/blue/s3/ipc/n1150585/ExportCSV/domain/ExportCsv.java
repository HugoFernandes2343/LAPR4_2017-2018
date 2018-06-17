/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pt.isep.nsheets.server.lapr4.blue.s3.ipc.n1150585.ExportCSV.domain;

import java.io.FileWriter;
import java.io.IOException;
import java.util.List;

/**
 *
 * @author Daniel Fernandes 1150585
 */
public class ExportCsv {

    private static final String DEFAULT_DELIMITER = ";";
    private static final String NEW_LINE_SEPARATOR = "\n";


    public boolean exportWorkbookToCSV(List<String[][]> sh, String separator, String path) {
        if (sh == null || separator == null || path == null || path.isEmpty() || path.equalsIgnoreCase(".csv")) {
            throw new IllegalArgumentException();
        }

        return expWorkbook(sh, separator, path);
    }
    private boolean expWorkbook(List<String[][]> spreadsheets, String delimiter, String pathToSaveFile) {
        String checkedDelimiter = checkDelimiter(delimiter);
        FileWriter fileWriter = null;

        int qtdSpreadsheetsToExport = spreadsheets.size(), count = 0;

        try {
            fileWriter = createFileWriterWithCheckedFilePath(pathToSaveFile);

            fileWriter.append("SEP=" + checkedDelimiter + "\n"); // informs Microsoft Excel that the file delimiter is the one passed by parameter

            for (String[][] spreadsheet : spreadsheets) { // for every spreadsheet from the workbook
                if (expCells(spreadsheet, fileWriter, checkedDelimiter)) {
                    count++;
                }
            }

        } catch (IOException e) {
            return false;
        } finally {
            try {
                fileWriter.flush();
                fileWriter.close();
            } catch (IOException e) {
                return false;
            }
        }

        return count == qtdSpreadsheetsToExport; // checks if all the spreadsheets where exported
    }

    private boolean expCells(String[][] cells, FileWriter fileWriter, String delimiter) throws IOException {
        int qtdCellsToExport = cells.length * cells[0].length, count = 0;

        for (int row = 0; row < cells.length; row++) {
            for (int column = 0; column < cells[0].length; column++) {

                fileWriter.append(cells[row][column]);
                count++;

                if (column == cells[0].length - 1) { // check if it's time to change the line (if it's the last column of the row)
                    fileWriter.append(NEW_LINE_SEPARATOR);
                } else {
                    fileWriter.append(delimiter);
                }
            }
        }

        return count == qtdCellsToExport;
    }

    private String checkDelimiter(String delimiter) {
        if (delimiter.trim().isEmpty()) {
            return DEFAULT_DELIMITER;
        }

        if (delimiter.trim().length() > 1) { // replace more than 1 delimiter by the first one
            return String.valueOf(delimiter.trim().charAt(0));
        }

        return delimiter.trim();
    }

    private FileWriter createFileWriterWithCheckedFilePath(String pathToSaveFile) throws IOException {
        if (pathToSaveFile.endsWith(".csv")) {
            return new FileWriter(pathToSaveFile);
        }

        if (pathToSaveFile.endsWith(".CSV")) {
            String pathWithCorrectFileExtension = pathToSaveFile.replace(".CSV", ".csv");
            return new FileWriter(pathWithCorrectFileExtension);
        }

        return new FileWriter(pathToSaveFile + ".csv");
    }

}
