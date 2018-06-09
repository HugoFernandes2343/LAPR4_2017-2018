package pt.isep.nsheets.server.services;

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
public class DownloadCLSImpl extends HttpServlet {

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        super.doGet(request, response);
        //Cant tell if it needs to be implemented yet
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        int BUFFER = 1024 * 100;

        String fileName = request.getParameter("filename");//get the name

        response.setContentType("text/plain");
        response.setHeader("Content-Disposition", "attachment;fileName=\"" + fileName + "\".cls");//test cls
        response.setContentLength(Long.valueOf(getFile(fileName).length()).intValue());
        response.setBufferSize(BUFFER);

        //Your IO code goes here to create a file and set to outputStream//

        ServletContext ctx = getServletContext();
        InputStream is = ctx.getResourceAsStream("/CLS.txt");

        /*
        FileInputStream is = new FileInputStream(filePath + fileName);

        try{
            //ObjectOutputStream oos = new ObjectOutputStream(stream);
            //oos.writeObject(workbook);
            //oos.flush();
            ServletOutputStream outputStream = response.getOutputStream();
            int bytes;
            while ((bytes = is.read()) != -1) {
                outputStream.write(bytes);
            }
            outputStream.close();
        }catch(Exception e) {
            e.printStackTrace();
            System.err.println("Inside Try/catch");
        }
        */
    }
}