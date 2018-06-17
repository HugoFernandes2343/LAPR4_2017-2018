package pt.isep.nsheets.server.services;

import com.google.gwt.user.server.rpc.RemoteServiceServlet;
import com.itextpdf.kernel.pdf.PdfWriter;
import com.itextpdf.layout.Document;
import com.itextpdf.kernel.pdf.PdfDocument;
import com.itextpdf.layout.element.Table;
import pt.isep.nsheets.shared.services.DownloadToPDFService;
import pt.isep.nsheets.shared.services.SpreadsheetDTO;
import pt.isep.nsheets.shared.services.WorkbookDTO;
import javax.servlet.ServletOutputStream;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class DownloadPDFImplRod extends RemoteServiceServlet implements DownloadToPDFService {
    private WorkbookDTO toExport;

    /*@Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
        this.doGet(request, response);
    }*/

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) {
        String fileName = "generatedPDF.pdf";//request.getParameter("filename");

        try {
            //1st, generate a local PDF file
            generatePDFFromWorkbook (toExport, fileName);
            //2nd, send it through
            sendPDFfile(response, fileName);
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    /**
     * Sends a PDF file through a HttpServletResponse as a byte array
     * @param response
     * @param fileName
     * @throws IOException
     */
    private void sendPDFfile(HttpServletResponse response, String fileName) throws IOException {
        int BUFFER = 1024 * 100;//set a reasonable size
        response.setContentType( "application/octet-stream" );
        response.setHeader( "Content-Disposition:", "attachment;filename=" + fileName);
        ServletOutputStream outputStream = response.getOutputStream();
        byte[] bytes = getFile(fileName);
        response.setContentLength( Long.valueOf( bytes.length ).intValue() );
        response.setBufferSize( BUFFER );
        outputStream.write(bytes);
        outputStream.close();
    }

    public byte[] getFile(String filename) {

        byte[] bytes = null;

        try {
            java.io.File file = new java.io.File(filename);
            if (file.exists()){
                FileInputStream fis = new FileInputStream(file);
                bytes = new byte[(int) file.length()];
                fis.read(bytes);
            }
            else{
                System.out.println ("File does not exist");
            }
        } catch (Exception e) {
            e.printStackTrace();
        }

        return bytes;
    }

    public Table spreadsheetToPDFTable(SpreadsheetDTO spreadsheet){
        Table pdfTable = new Table(spreadsheet.getColumnCount());

        String[][] content = spreadsheet.getContent();

        for (int i = 0; i < content.length; i++) {
            for (int j = 0; j < content[0].length; j++) {
                pdfTable.addCell(content[i][j]);
            }
        }

        return pdfTable;
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
            result.add(spreadsheetToPDFTable(spreadsheet));
        }
        return result;
    }

    public WorkbookDTO dummyWorkbook(){
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

        return workbook;
    }

    @Override
    public WorkbookDTO exportToDownload(WorkbookDTO toExport) {
        this.toExport = toExport;
        return toExport;
    }
}
