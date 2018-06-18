package pt.isep.nsheets.server.services;

import com.google.gwt.user.server.rpc.RemoteServiceServlet;
import com.itextpdf.kernel.pdf.PdfWriter;
import com.itextpdf.layout.Document;
import com.itextpdf.kernel.pdf.PdfDocument;
import com.itextpdf.layout.element.Table;
import pt.isep.nsheets.shared.services.ExportPDFWorkbookService;
import pt.isep.nsheets.shared.services.SpreadsheetDTO;
import pt.isep.nsheets.shared.services.WorkbookDTO;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class ExportPDFWorkbookImpl extends RemoteServiceServlet implements ExportPDFWorkbookService {
    private WorkbookDTO toExport;

    /*@Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
        this.doGet(request, response);
    }*/

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) {
        String fileName = request.getParameter("filename");

        try {
            //1st, generate a local PDF file
            generatePDFFromWorkbook (toExport, fileName);
            //2nd, send it through
            DownloadUtility.sendFileAsByteStream(response, fileName);
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public PdfDocument generatePDFFromWorkbook (WorkbookDTO workbookDTO, String filename) throws FileNotFoundException {
        List<Table> result = workbookToPDF(workbookDTO);


        PdfDocument lowLevelDoc = new PdfDocument(new PdfWriter(filename));
        Document document = new Document(lowLevelDoc);

        for (Table table : result) {
            document.add(table);
        }
        document.close();

        return lowLevelDoc;
    }

    public List<Table> workbookToPDF(WorkbookDTO workbookDTO){
        List<Table> result = new ArrayList<Table>();
        for (SpreadsheetDTO spreadsheet : workbookDTO.getSpreadsheets()) {
            result.add(ExportPDFSpreadsheetImpl.spreadsheetToPDFTable(spreadsheet));
        }
        return result;
    }

    @Override
    public WorkbookDTO exportToDownload(WorkbookDTO toExport) {
        this.toExport = toExport;
        return toExport;
    }
}
