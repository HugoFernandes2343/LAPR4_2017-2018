package pt.isep.nsheets.server.services;

import com.itextpdf.text.*;
import com.itextpdf.text.pdf.PdfPCell;
import com.itextpdf.text.pdf.PdfPTable;
import com.itextpdf.text.pdf.PdfWriter;
import pt.isep.nsheets.shared.core.Cell;
import pt.isep.nsheets.shared.services.SpreadsheetDTO;
import pt.isep.nsheets.shared.services.WorkbookDTO;

import java.io.FileOutputStream;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class DownloadPDFImplRod {

    public static PdfPCell cellToPDFCell (Cell cell){
        return new PdfPCell(new Phrase(cell.getContent()));
    }

    public static PdfPCell[][] cellRangeToPDFCellRange (Cell[][] cellRange){
        PdfPCell[][] result = new PdfPCell[cellRange.length][cellRange[0].length];

        for (int i = 0; i < cellRange.length; i++) {
            for (int j = 0; j < cellRange[0].length; j++) {
                result[i][j] = cellToPDFCell(cellRange[i][j]);
            }
        }
        return result;
    }

    public static PdfPTable spreadsheetToPDFTable(SpreadsheetDTO spreadsheet){
        PdfPTable pdfTable = new PdfPTable(spreadsheet.getColumnCount());

        String[][] content = spreadsheet.getContent();

        for (int i = 0; i < content.length; i++) {
            for (int j = 0; j < content[0].length; j++) {
                pdfTable.addCell(content[i][j]);
            }
        }

        return pdfTable;
    }

    public static List<PdfPTable> workbookToPDF(WorkbookDTO workbookDTO){
        List<PdfPTable> result = new ArrayList<PdfPTable>();
        for (SpreadsheetDTO spreadsheet : workbookDTO.getSpreadsheets()) {
            result.add(spreadsheetToPDFTable(spreadsheet));
        }
        return result;
    }

    // iText allows to add metadata to the PDF which can be viewed in your Adobe
    // Reader
    // under File -> Properties
    private static void addMetaData(Document document) {
        document.addTitle("My first PDF");
        document.addSubject("Using iText");
        document.addKeywords("Java, PDF, iText");
        document.addAuthor("Lars Vogel");
        document.addCreator("Lars Vogel");
    }

    private static void addEmptyLine(Paragraph paragraph, int number) {
        for (int i = 0; i < number; i++) {
            paragraph.add(new Paragraph(" "));
        }
    }
}
