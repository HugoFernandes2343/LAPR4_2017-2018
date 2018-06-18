package pt.isep.nsheets.server.services;

import com.google.gwt.user.server.rpc.RemoteServiceServlet;
import com.thoughtworks.xstream.XStream;
import pt.isep.nsheets.shared.services.ExportXMLSpreadsheetService;
import pt.isep.nsheets.shared.services.SpreadsheetDTO;
import javax.servlet.ServletOutputStream;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.*;

/**
 *
 * @author Barbara Csonka 1171715
 */
public class ExportXMLSpreadsheetImpl extends RemoteServiceServlet implements ExportXMLSpreadsheetService {

    SpreadsheetDTO toExport;

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) {
        String fileName = request.getParameter("filename");

        try {
            //1st, generate a local XML file
            generateXMLFromSpreadsheet(toExport, fileName);
            //2nd, send it through
            DownloadUtility.sendFileAsByteStream(response, fileName);
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void generateXMLFromSpreadsheet(SpreadsheetDTO spreadsheetDTO, String filename) throws FileNotFoundException, IOException {
        XStream xstream = new XStream();
        xstream.alias("spreadsheet", SpreadsheetDTO.class);

        FileOutputStream fos = null;
        try{
            String xml = xstream.toXML(spreadsheetDTO);
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
    public SpreadsheetDTO exportToDownload(SpreadsheetDTO toExport) {
        this.toExport = toExport;
        return toExport;
    }
}
