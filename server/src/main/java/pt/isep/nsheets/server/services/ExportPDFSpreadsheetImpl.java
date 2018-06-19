package pt.isep.nsheets.server.services;

import com.google.gwt.user.server.rpc.RemoteServiceServlet;
import com.itextpdf.kernel.pdf.PdfDocument;
import com.itextpdf.kernel.pdf.PdfWriter;
import com.itextpdf.layout.Document;
import com.itextpdf.layout.element.Paragraph;
import com.itextpdf.layout.element.Table;
import pt.isep.nsheets.shared.services.ExportPDFSpreadsheetService;
import pt.isep.nsheets.shared.services.SpreadsheetDTO;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.FileNotFoundException;
import java.io.IOException;

public class ExportPDFSpreadsheetImpl extends RemoteServiceServlet implements ExportPDFSpreadsheetService {
    private SpreadsheetDTO toExport;

    /*@Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
        this.doGet(request, response);
    }*/

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) {
        String fileName = request.getParameter("filename");

        try {
            //1st, generate a local PDF file
            generatePDFFromSpreadsheet (toExport, fileName);
            //2nd, send it through
            DownloadUtility.sendFileAsByteStream(response, fileName);
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static Table spreadsheetToPDFTable(SpreadsheetDTO spreadsheet){
        return ExportPDFCellRangeImpl.cellRangeToPDFTable(spreadsheet.getContent());
    }

    public void generatePDFFromSpreadsheet(SpreadsheetDTO spreadsheetDTO, String filename) throws FileNotFoundException {
        Table table = spreadsheetToPDFTable(spreadsheetDTO);

        PdfDocument lowLevelDoc = new PdfDocument(new PdfWriter(filename));
        Document document = new Document(lowLevelDoc);

        document.add(new Paragraph("Spreadsheet Export"));
        document.add(new Paragraph(""));
        document.add(table);
        document.close();
    }

    @Override
    public SpreadsheetDTO exportToDownload(SpreadsheetDTO toExport) {
        this.toExport = toExport;
        return toExport;
    }
}
