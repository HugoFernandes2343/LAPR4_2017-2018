package pt.isep.nsheets.server.services;

import com.google.gwt.user.server.rpc.RemoteServiceServlet;
import com.itextpdf.kernel.pdf.PdfDocument;
import com.itextpdf.kernel.pdf.PdfWriter;
import com.itextpdf.layout.Document;
import com.itextpdf.layout.element.Table;
import pt.isep.nsheets.shared.services.ExportPDFCellRangeService;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.FileNotFoundException;
import java.io.IOException;

public class ExportPDFCellRangeImpl extends RemoteServiceServlet implements ExportPDFCellRangeService {
    private String[][] toExport;

    /*@Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
        this.doGet(request, response);
    }*/

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) {
        String fileName = request.getParameter("filename");

        try {
            //1st, generate a local PDF file
            generatePDFFromCellRange (toExport, fileName);
            //2nd, send it through
            DownloadUtility.sendFileAsByteStream(response, fileName);
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static Table cellRangeToPDFTable(String[][] cellRange){
        Table pdfTable = new Table(cellRange[0].length);

        for (int i = 0; i < cellRange.length; i++) {
            for (int j = 0; j < cellRange[0].length; j++) {
                pdfTable.addCell(cellRange[i][j]);
            }
        }

        return pdfTable;
    }

    public void generatePDFFromCellRange(String[][] cellRange, String filename) throws FileNotFoundException {
        Table table = cellRangeToPDFTable(cellRange);

        PdfDocument lowLevelDoc = new PdfDocument(new PdfWriter(filename));
        Document document = new Document(lowLevelDoc);

        document.add(table);
        document.close();
    }

    @Override
    public String[][] exportToDownload(String[][] toExport) {
        this.toExport = toExport;
        return toExport;
    }
}
