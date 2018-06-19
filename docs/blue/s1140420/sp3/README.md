**Rodrigo Fontes Soares** (1140420) - Sprint 3 - IPC03.1
===============================

# 1. General Notes

In this sprint, it took me a very serious amount of time to get familiar with client-server communcation in GWT. 

# 2. Requirements

 It should be possible to export to PDF an entire workbook, a spreadsheet or a range of cells. The contents should include only the values of the cells (and not its formulas, for instance). The user should be able to select the content to be exported and also if the document should have a table of contents with links to the sections or not. If select, sections/chapters should be generated for each spreadsheet of the workbook. The generated PDF should be downloaded to the user local file system.

# 3. Analysis

As it can be seen on the diagram as well, the core of this task were the following modules and its details:

##Client module

	ExportToPDFView class

	- btnExport() method

	On the Client side, there is this specific view, called ExportToPDFView, which is a window that has the users interactions. It has a button called btnExport(), and once it was clicked by the user, it starts the whole process itself.

	The button uses the exportToDownload() method in DownloadToPDFServiceAsync interface, and the Server will actually implement it in the Shared module as well, in the DownloadToPDFService. 

	Both the Server and Client knows that the communication service exist (DownloadToPDFServiceAsync); Those two interfaces were being defined in Shared module.


##Shared module

	DownloadToPDFServiceAsync interface

	- exportToDownload() - this method is being used by the Client side, once the request was sent

	DownloadToPDFService

	- exportToDownload() - this method is being used by the Server when the request was sent from the Client side


##Server module

	DownloadPDFImpl class

	- doGet(HttpServletRequest request, HttpServletResponse, response)

	When the client sends a request to the server, and it gets a response as well. Once the Server gets the request from the Client side, this doGet method will automatically execute. This is basically an HTTP protocol, that all servers needs to do. 

	- generatePDFFromWorkbook(WorkbookDTO workbookDTO, String fileMame)

	This method generates the PDF file, and it will generate it Server side.
	It is important to mention that this method uses Data Transfer Object (DTO), which is a trimmed down version of an entity (so this is the trimmed down version of the Workbook class, in our case, that only has the spreadsheets).

	- sendPDFfile(HttpServletResponse response, String fileName)

 	This method basically opens up the file that already exists on the server, and converts it to array of bytes. Once I have an array of bytes, I just create an OutputStream, and write them. When this thing executes, the client already has the file on their end. 

	- exportToDownload(WorkbookDTO toExport)

	This method is familiar to each side (to the Server and to the Client also). Here, it is being captured what the client sent through. It is going to be saved in a local field. Whenever the exportToDownload is called, this field has to be set in order to define the actual Workbook that has to be downloaded.

	Moreover, as it was mentioned before, the DownloadPFImpl class..:

	- extends RemoteServiceServlet class, which has already existed. The class DonwloadPDFImpl extends it, in order to be able to use it during the work.

	- implements iText, which is an external library.

# 4. Design

## 4.1. Tests

    public void generatePDF() throws FileNotFoundException {
        String fileName = "./"+"generatedPDFTest"+".pdf";

        DownloadPDFImplRod servlet = new DownloadPDFImplRod();

        PdfDocument generatedPDF = servlet.generatePDFFromWorkbook (servlet.dummyWorkbook(), fileName);

        byte[] bytes = servlet.getFile(fileName);

        assertTrue( bytes != null );
    }


    public void spreadsheetToPDFTable() throws FileNotFoundException {
        System.out.println("spreadsheetToPDFTable");

        int columns = 3, rows = 4;
        String[][] content = {{"4","3","2"}, {"s123","--","s"}, {"+sad","+io","-12..12"}, {"bssd","asd","ads"}};
        SpreadsheetDTO spreadsheet = new SpreadsheetDTO("Test Spreadsheet", columns, rows, content);

        Table instance = new DownloadPDFImplRod().spreadsheetToPDFTable(spreadsheet);

        Table expected = new Table(columns);
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

        //Generate test results
        PdfDocument doc = new PdfDocument(new PdfWriter("spreadsheetToPDFTableTest.pdf"));
        Document testResult = new Document(doc);

        testResult.add(new Paragraph("Expected Table:"));
        testResult.add(expected);
        testResult.add(new Paragraph("Generated Table:"));
        testResult.add(instance);
        testResult.close();

        //Compare every single Cell
        for (int i = 0; i < expected.getNumberOfRows(); i++) {
            for (int j = 0; j < expected.getNumberOfColumns(); j++) {
                assertEquals(expected.getCell(i, j).toString(), instance.getCell(i, j).toString());
            }
        }
    }


    public void workbookToPDF() throws FileNotFoundException {
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
        Table table1 = new Table(columns);
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


        Table table2 = new Table(columns);
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

        List<Table> instance = new DownloadPDFImplRod().workbookToPDF(workbook);

        //Generate test results
        PdfDocument doc = new PdfDocument(new PdfWriter("workbookToPDFTest.pdf"));
        Document testResult = new Document(doc);

        testResult.add(new Paragraph("Expected Table 1:"));
        testResult.add(table1);
        testResult.add(new Paragraph("Generated Table 1:"));
        testResult.add(instance.get(0));

        testResult.add(new Paragraph("Expected Table 2:"));
        testResult.add(table2);
        testResult.add(new Paragraph("Generated Table 2:"));
        testResult.add(instance.get(1));

        testResult.close();
        //Compare every single Cell in Table 1
        for (int i = 0; i < table1.getNumberOfRows(); i++) {
            for (int j = 0; j < table1.getNumberOfColumns(); j++) {
                assertEquals(table1.getCell(i, j).toString(), instance.get(0).getCell(i, j).toString());
            }
        }

        //Compare every single Cell in Table 2
        for (int i = 0; i < table2.getNumberOfRows(); i++) {
            for (int j = 0; j < table2.getNumberOfColumns(); j++) {
                assertEquals(table2.getCell(i, j).toString(), instance.get(1).getCell(i, j).toString());
            }
        }
    }

## 4.2. Used and modified classes

	WorkbookView.java class (Client side)

 exportToPdfButton.addClickHandler(event -> {
            new ExportToPDFView(this.getActiveCell().getSpreadsheet().getWorkbook());
        });

 The actual button that shows up on the website. It uses the current workbook (getWorkbook()). 

	ExportTOPDFView.java class (Client side)

 btnExport.addClickHandler(event -> {

            WorkbookDTO dto = workbook.toDTO();

            DownloadToPDFServiceAsync downAsync = GWT.create(DownloadToPDFService.class);

            downAsync.exportToDownload(dto, new AsyncCallback<WorkbookDTO>() {
                @Override
                public void onFailure(Throwable caught) {
                    MaterialToast.fireToast("Error in Export to PDF! " + caught.getMessage());
                }

                @Override
                public void onSuccess(WorkbookDTO result) {
                    String url = GWT.getModuleBaseURL() + "downloadToPDFService?filename=" + "generatedPDF" + ".pdf";//textBox1.getText();
                    Window.open(url, "Download PDF file", "status=0,toolbar=0,menubar=0,location=0");
                }
            });
        });
        window.open();

   After the button was clicked, a dto will be generated (WorkbookDTO dto = workbook.toDTO();). It is important to notice that this class has the whole Workbook as a parameter, but once again, we are only using the trimmed down version - that's why the DTO shows up here.

   Then, an asynchronous service will be done by GWT, based on the "normal" one (DownloadToPDFService.class). From this service, I am going to call the method exportToDownload ( downAsync.exportToDownload(dto, new AsyncCallback<WorkbookDTO>()). 


   It needs the actual Workbook, and a new asynchronous call back to this view, that what should happen. 

   If it manages to reach the server, it is a success (onSuccess(WorkbookDTO result)), so we will get the URL (GWT.getModuleBaseURL()), which is the path of the file located on the server. Then I specify the file name what I want, I give a name, and then a window will open up, telling that the file is downloading. 

	DownloadPDFImplRod.java class (Server side)

    public WorkbookDTO exportToDownload(WorkbookDTO toExport) {
        this.toExport = toExport;
        return toExport;
    }

    This method is familiar to each side (to the Server and to the Client also). Here, it is being captured what the client sent through. It is going to be saved in a local field. Whenever the exportToDownload is called, this field has to be set in order to define the actual Workbook that has to be downloaded. 

    This class extends RemoteServiceServlet, and implements DownloadToPDFService.

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

    Since this is a method that already exists, I used override. It has a request, and a corresponding response as a parameter.

    In the fileName, I'm using a default name ( String fileName = "generatedPDF.pdf";//request.getParameter("filename");). So what the server has to do - as it is written in comments too -, first, to generate a local PDF file, and second, to send it through. 

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

    This method uses things from iText, which is an existing library that can be used to create PDF from Java. Once this method executes, there will be a file wherever on the Client's computer, with the given name, and sendPDFfile method sends it through. 


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

    This method basically opens up the file that already exists on the server, and converts it to array of bytes. Once I have an array of bytes, I just create an OutputStream, and write them. When this thing executes, the client already has the file on their end. 

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

# 5. Implementation

# 6. Integration/Demonstration

# 7. Final Remarks