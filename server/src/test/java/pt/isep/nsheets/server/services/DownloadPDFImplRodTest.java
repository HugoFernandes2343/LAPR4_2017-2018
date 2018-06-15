package pt.isep.nsheets.server.services;

import com.itextpdf.text.Document;
import com.itextpdf.text.DocumentException;
import com.itextpdf.text.Paragraph;
import com.itextpdf.text.pdf.PdfPCell;
import com.itextpdf.text.pdf.PdfPRow;
import com.itextpdf.text.pdf.PdfPTable;
import com.itextpdf.text.pdf.PdfWriter;
import org.junit.Test;
import pt.isep.nsheets.shared.services.SpreadsheetDTO;
import pt.isep.nsheets.shared.services.WorkbookDTO;

import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.util.ArrayList;
import java.util.List;

import static org.junit.Assert.*;

public class DownloadPDFImplRodTest {
/*    @Test
    public void ensureSimpleCellToPDFCellConversion() throws FormulaCompilationException {
        System.out.println("ensureSimpleCellToPDFCellConversion");

        Cell testCell = new CellImpl();
        testCell.setContent("42");

        PdfPCell instance = DownloadPDFImplRod.cellToPDFCell(testCell);
        PdfPCell expected = new PdfPCell(new Phrase("42"));
        assertEquals(instance, expected);
    }*/

//    @Test
//    public void cellRangeToPDFCellRange() throws FormulaCompilationException {
//        System.out.println("ensureSimpleCellRangeToPDFCellRangeConversion");
//
//        Cell[][] testCellRange = new Cell[2][3];
//        testCellRange[0][0].setContent("34");
//        testCellRange[0][1].setContent("123");
//        testCellRange[0][2].setContent("-987");
//        testCellRange[1][0].setContent("abc");
//        testCellRange[1][1].setContent("ths te");
//        testCellRange[1][2].setContent("0.234");
//
//
//        PdfPCell[][] instance = DownloadPDFImplRod.cellRangeToPDFCellRange(testCellRange);
//        PdfPCell[][] expected = new PdfPCell[2][3];
//        expected[0][0].setPhrase(new Phrase("34"));
//        expected[0][1].setPhrase(new Phrase("123"));
//        expected[0][2].setPhrase(new Phrase("-987"));
//        expected[1][0].setPhrase(new Phrase("abc"));
//        expected[1][1].setPhrase(new Phrase("ths te"));
//        expected[1][2].setPhrase(new Phrase("0.234"));
//
//        assertEquals(instance, expected);
//    }

    @Test
    public void spreadsheetToPDFTable() throws FileNotFoundException, DocumentException {
        System.out.println("spreadsheetToPDFTable");

        int columns = 3, rows = 4;
        String[][] content = {{"4","3","2"}, {"s123","--","s"}, {"+sad","+io","-12..12"}, {"bssd","asd","ads"}};
        SpreadsheetDTO spreadsheet = new SpreadsheetDTO("Test Spreadsheet", columns, rows, content);

        PdfPTable instance = DownloadPDFImplRod.spreadsheetToPDFTable(spreadsheet);

        PdfPTable expected = new PdfPTable(columns);
        expected.addCell("4");
        expected.addCell("3");
        expected.addCell("2");

        expected.addCell("s123");
        expected.addCell("--");
        expected.addCell("s");

        expected.addCell("+sad");
        expected.addCell("+io");
        expected.addCell("-12..12");

        expected.addCell("bssd");
        expected.addCell("asd");
        expected.addCell("ads");



        //Compare every single Cell
        List<PdfPRow> expectedRows = expected.getRows();
        List<PdfPRow> instanceRows = instance.getRows();

        for (int i = 0; i < expectedRows.size(); i++) {
            PdfPCell[] expectedRow = expectedRows.get(i).getCells();
            PdfPCell[] instanceRow = instanceRows.get(i).getCells();
            for (int j = 0; j < expectedRow.length; j++) {
                assertEquals(expectedRow[j].getPhrase().getContent(), instanceRow[j].getPhrase().getContent());
            }
        }

        Document testResult = new Document();
        PdfWriter.getInstance(testResult, new FileOutputStream("./spreadsheetToPDFTable.pdf"));

        testResult.open();
        testResult.add(new Paragraph("Expected Table:"));
        testResult.add(expected);
        testResult.add(new Paragraph("Generated Table:"));
        testResult.add(instance);
        testResult.close();
    }

    @Test
    public void workbookToPDF() throws DocumentException, FileNotFoundException {
        System.out.println("workbookToPDF");

        //Instance data
        int columns = 3, rows = 4;
        String[][] content1 = {{"4","3","2"},
                {"s123","--","s"},
                {"+sad","+io","-12..12"},
                {"bssd","asd","ads"}};

        SpreadsheetDTO spreadsheet1 = new SpreadsheetDTO("Spreadsheet1", columns, rows, content1);

        columns = 3; rows = 5;
        String[][] content2 = {{"4","3","2"},
                {"s123","--","s"},
                {"+sad","+io","-12..12"},
                {"bssd","asd","ads"},
                {"bssd","asd","ads"}};

        SpreadsheetDTO spreadsheet2 = new SpreadsheetDTO("Spreadsheet2", columns, rows, content2);

        List<SpreadsheetDTO> spreadsheets = new ArrayList<SpreadsheetDTO>();
        spreadsheets.add(spreadsheet1);
        spreadsheets.add(spreadsheet2);
        WorkbookDTO workbook = new WorkbookDTO(spreadsheets, spreadsheets.size());


        //Expected data
        PdfPTable table1 = new PdfPTable(columns);
        table1.addCell("4");
        table1.addCell("3");
        table1.addCell("2");

        table1.addCell("s123");
        table1.addCell("--");
        table1.addCell("s");

        table1.addCell("+sad");
        table1.addCell("+io");
        table1.addCell("-12..12");

        table1.addCell("bssd");
        table1.addCell("asd");
        table1.addCell("ads");


        PdfPTable table2 = new PdfPTable(columns);
        table2.addCell("4");
        table2.addCell("3");
        table2.addCell("2");

        table2.addCell("s123");
        table2.addCell("--");
        table2.addCell("s");

        table2.addCell("+sad");
        table2.addCell("+io");
        table2.addCell("-12..12");

        table2.addCell("bssd");
        table2.addCell("asd");
        table2.addCell("ads");

        table2.addCell("bssd");
        table2.addCell("asd");
        table2.addCell("ads");

        List<PdfPTable> instance = DownloadPDFImplRod.workbookToPDF(workbook);

        //Compare every single Cell in Table 1
        List<PdfPRow> expectedRows = table1.getRows();
        List<PdfPRow> instanceRows = instance.get(0).getRows();
        for (int i = 0; i < expectedRows.size(); i++) {
            PdfPCell[] expectedRow = expectedRows.get(i).getCells();
            PdfPCell[] instanceRow = instanceRows.get(i).getCells();
            for (int j = 0; j < expectedRow.length; j++) {
                assertEquals(expectedRow[j].getPhrase().getContent(), instanceRow[j].getPhrase().getContent());
            }
        }

        //Compare every single Cell in Table 2
        expectedRows = table2.getRows();
        instanceRows = instance.get(1).getRows();
        for (int i = 0; i < expectedRows.size(); i++) {
            PdfPCell[] expectedRow = expectedRows.get(i).getCells();
            PdfPCell[] instanceRow = instanceRows.get(i).getCells();
            for (int j = 0; j < expectedRow.length; j++) {
                assertEquals(expectedRow[j].getPhrase().getContent(), instanceRow[j].getPhrase().getContent());
            }
        }

        Document testResult = new Document();
        PdfWriter.getInstance(testResult, new FileOutputStream("./workbookToPDF.pdf"));


        //Generate test results
        testResult.open();

        testResult.add(new Paragraph("Expected Table 1:"));
        testResult.add(table1);
        testResult.add(new Paragraph("Generated Table 1:"));
        testResult.add(instance.get(0));

        testResult.add(new Paragraph("Expected Table 2:"));
        testResult.add(table2);
        testResult.add(new Paragraph("Generated Table 2:"));
        testResult.add(instance.get(1));

        testResult.close();
    }
}