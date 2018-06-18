package pt.isep.nsheets.server.services;

import com.google.gwt.user.server.rpc.RemoteServiceServlet;
import com.thoughtworks.xstream.XStream;
import pt.isep.nsheets.shared.services.ExportXMLCellRangeService;

import javax.servlet.ServletOutputStream;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.*;

/**
 *
 * @author Barbara Csonka 1171715
 */
public class ExportXMLCellRangeImpl extends RemoteServiceServlet implements ExportXMLCellRangeService {

    String[][] toExport;

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) {
        String fileName = request.getParameter("filename");

        try {
            //1st, generate a local XML file
            generateXMLFromCellRange(toExport, fileName);
            //2nd, send it through
            DownloadUtility.sendFileAsByteStream(response, fileName);
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void generateXMLFromCellRange(String[][] cellRange, String filename) {
        XStream xstream = new XStream();

        FileOutputStream fos = null;
        try{
            String xml = xstream.toXML(cellRange);
            fos = new FileOutputStream(filename);
            fos.write("<?xml version=\"1.0\"?>".getBytes("UTF-8"));
            byte[] bytes = xml.getBytes("UTF-8");
            fos.write(bytes);

        }catch (Exception e){
            System.err.println("Error in XML Write: " + e.getMessage());
        }
        finally{
            if(fos != null){
                try{
                    fos.close();
                }catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
    }

    @Override
    public String[][] exportToDownload(String[][] toExport) {
        this.toExport = toExport;
        return toExport;
    }
}
