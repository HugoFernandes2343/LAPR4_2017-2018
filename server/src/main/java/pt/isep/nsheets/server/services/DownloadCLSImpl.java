package pt.isep.nsheets.server.services;

import com.google.gwt.user.server.rpc.RemoteServiceServlet;
import pt.isep.nsheets.shared.core.Workbook;
import pt.isep.nsheets.shared.services.DataException;
import pt.isep.nsheets.shared.services.DownloadToCLSService;
import pt.isep.nsheets.shared.services.WorkbookDTO;

import javax.servlet.ServletException;
import javax.servlet.ServletOutputStream;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.ObjectOutputStream;


/**
 * @author <1160777>Marco Carneiro</1160777>
 * <p>
 * Servlet that allows the user to download files from the server
 */
public class DownloadCLSImpl extends RemoteServiceServlet implements DownloadToCLSService{

    private WorkbookDTO toExport;

    /*protected void doPost(HttpServletRequest request, HttpServletResponse response) {
        super.doPost(request, response);
    }*/

    protected void doGet(HttpServletRequest request, HttpServletResponse response) {
        int BUFFER = 1024 * 100;//set a reasonable size

        String fileName = request.getParameter("filename");

        response.setContentType("application/octet-stream");
        response.setHeader("Content-Disposition", "attachment;fileName=\"" + fileName + "\".cls");//test cls
        response.setBufferSize(BUFFER);

        try {
            ServletOutputStream outputStream = response.getOutputStream();
            ObjectOutputStream oos = new ObjectOutputStream(outputStream);
            Workbook wb = new Workbook();
            //Workbook temp = this.toExport.fromDTO(wb);
            oos.writeObject(this.toExport);//How to put the workbook here, maybe through the Service and the response object
            oos.flush();
            outputStream.close();
        } catch (Exception e) {
            e.printStackTrace();
            System.err.println("Inside Try/catch");
        }

    }

    @Override
    public WorkbookDTO exportToDownload(WorkbookDTO toExport) {
        this.toExport = toExport;
        return toExport;
    }
}
