package pt.isep.nsheets.server.services;

import org.apache.commons.fileupload.FileItemIterator;
import org.apache.commons.fileupload.FileItemStream;
import org.apache.commons.fileupload.servlet.ServletFileUpload;
import org.w3c.dom.DOMException;
import org.xml.sax.SAXException;
import pt.isep.nsheets.server.lapr4.red.s2.ipc.s1161110.workbooks.application.XmlReadingService;
import pt.isep.nsheets.shared.core.Workbook;
import pt.isep.nsheets.shared.core.formula.compiler.FormulaCompilationException;
import pt.isep.nsheets.shared.services.UploadService;

import javax.servlet.ServletOutputStream;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.xml.parsers.ParserConfigurationException;
import java.io.*;

public class FileUploadServlet extends HttpServlet implements UploadService {

    private static final long serialVersionUID = 843739498430L;

    private static final String TEST_PATH = "C:\\Users\\David\\Documents\\Repositorios\\lapr4\\lapr4-18-2dl\\uploaded\\file.xml";

    private String path;

    @Override
    protected void doPost(HttpServletRequest request,
                          HttpServletResponse response) throws IOException {

        if (! ServletFileUpload.isMultipartContent(request)) {
            response.sendError(HttpServletResponse.SC_BAD_REQUEST,
                    "Not a multipart request");
            return;
        }

        ServletFileUpload upload = new ServletFileUpload(); // from Commons

        try {
            FileItemIterator iter = upload.getItemIterator(request);

            if (iter.hasNext()) {
                FileItemStream fileItem = iter.next();

                ServletOutputStream out = response.getOutputStream();
                response.setBufferSize(32768);

                InputStream in = fileItem.openStream();
                // The destination of your uploaded files.
                path = "C:\\Users\\David\\Documents\\Repositorios\\lapr4\\lapr4-18-2dl\\uploaded\\" + fileItem.getName();
                File file = new File(path);
                OutputStream outputStream = new FileOutputStream(file);

                int length = 0;
                byte[] bytes = new byte[1024];

                while ((length = in.read(bytes)) != -1) {
                    outputStream.write(bytes, 0, length);
                }

                response.setContentType("text/xml");
                response.setContentLength(
                        (length > 0 && length <= Integer.MAX_VALUE) ? (int) length : 0);

                outputStream.close();
                in.close();
                out.flush();
                out.close();
            }
        } catch(Exception caught) {
            throw new RuntimeException(caught);
        }
    }

    @Override
    public Workbook importToWorkbook(Workbook wb) throws IOException, NumberFormatException, DOMException, FormulaCompilationException {

        if (wb != null) {
            try {
                return XmlReadingService.loadXml(path);
            } catch (ParserConfigurationException e) {
                e.printStackTrace();
            } catch (SAXException e) {
                e.printStackTrace();
            }
        } else {
            try{
                return XmlReadingService.loadXml(TEST_PATH);
            } catch (ParserConfigurationException e) {
                e.printStackTrace();
            } catch (SAXException e) {
                e.printStackTrace();
            }
        }
        return null;
    }

}
