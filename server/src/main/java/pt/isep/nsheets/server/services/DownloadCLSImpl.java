package pt.isep.nsheets.server.services;

import org.eclipse.jdt.internal.core.JavaModel;
import pt.isep.nsheets.shared.core.Workbook;
import pt.isep.nsheets.shared.services.DataException;
import pt.isep.nsheets.shared.services.DownloadToCLSService;
import pt.isep.nsheets.shared.services.WorkbookDTO;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.ServletOutputStream;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.*;

import static org.apache.commons.io.FileUtils.getFile;


/**
 * @author <1160777>Marco Carneiro</1160777>
 * <p>
 * Servlet that allows the user to download files from the server
 */
public class DownloadCLSImpl extends HttpServlet implements DownloadToCLSService {

    private WorkbookDTO toExport;

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        super.doPost(request, response);
        /*int BUFFER = 1024 * 100;//set a reasonable size
        String fileName = request.getParameter("filename");
        File f = new File(fileName);
        int length = 0;
        ServletOutputStream op = response.getOutputStream();
        ServletContext context = getServletConfig().getServletContext();

        response.setContentType("application/octet-stream");
        response.setContentLength((int) f.length());
        response.setHeader("Content-Disposition", "attachment; filename*=\"utf-8''" + fileName);
        response.setBufferSize(BUFFER);

        byte[] bbuf = new byte[1024];
        DataInputStream in = new DataInputStream(new FileInputStream(f));

        while ((in != null) && ((length = in.read(bbuf)) != -1)) {
            op.write(bbuf, 0, length);
        }
        in.close();
        op.flush();
        op.close();*/

        /*try{
            ServletOutputStream outputStream = response.getOutputStream();
            ObjectOutputStream oos = new ObjectOutputStream(outputStream);
            oos.writeObject(WTF HOW TO PUT SHIT HERE);//How to put the workbook here, maybe through the Service and the response object
            oos.flush();
            outputStream.close();
        }catch(Exception e) {
            e.printStackTrace();
            System.err.println("Inside Try/catch");
        }*/

    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        //doPost(request, response);

        /*int BUFFER = 1024 * 100;//set a reasonable size

        String fileName = request.getParameter("filename");
        File f = new File(fileName);
        int length = 0;
        ServletOutputStream op = response.getOutputStream();
        ServletContext context = getServletConfig().getServletContext();

        response.setContentType("application/octet-stream");
        response.setContentLength((int) f.length());
        response.setHeader("Content-Disposition", "attachment; filename*=\"utf-8''" + fileName);
        response.setBufferSize(BUFFER);

        byte[] bbuf = new byte[1024];
        DataInputStream in = new DataInputStream(new FileInputStream(f));

        while ((in != null) && ((length = in.read(bbuf)) != -1)) {
            op.write(bbuf, 0, length);
        }
        in.close();
        op.flush();
        op.close();
*/
        int BUFFER = 1024 * 100;//set a reasonable size

        String fileName = request.getParameter("filename");

        response.setContentType("application/octet-stream");
        response.setHeader("Content-Disposition", "attachment;fileName=\"" + fileName + "\".cls");//test cls
        //response.setContentLength(Long.valueOf(getFile(fileName).length()).intValue());
        response.setBufferSize(BUFFER);

        //Your IO code goes here to create a file and set to outputStream//

        //ServletContext ctx = getServletContext();

        try {
            ServletOutputStream outputStream = response.getOutputStream();
            ObjectOutputStream oos = new ObjectOutputStream(outputStream);
            //Workbook wb = new Workbook();
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
    public WorkbookDTO exportToDownload(WorkbookDTO toExport) throws DataException {
        this.toExport = toExport;
        return toExport;
    }
}
