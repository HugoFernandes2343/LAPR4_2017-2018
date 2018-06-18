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
            sendXMLfile(response, fileName);
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    /**
     * Sends a XML file through a HttpServletResponse as a byte array
     *
     * @param response
     * @param fileName
     * @throws IOException
     */
    private void sendXMLfile(HttpServletResponse response, String fileName) throws IOException {
        int BUFFER = 1024 * 100;//set a reasonable size
        response.setContentType("application/octet-stream");
        response.setHeader("Content-Disposition:", "attachment;filename=" + fileName);
        ServletOutputStream outputStream = response.getOutputStream();
        byte[] bytes = getFile(fileName);
        response.setContentLength(Long.valueOf(bytes.length).intValue());
        response.setBufferSize(BUFFER);
        outputStream.write(bytes);
        outputStream.close();
    }

    public byte[] getFile(String filename) {

        byte[] bytes = null;

        try {
            File file = new File(filename);
            if (file.exists()) {
                FileInputStream fis = new FileInputStream(file);
                bytes = new byte[(int) file.length()];
                fis.read(bytes);
            } else {
                System.out.println("File does not exist");
            }
        } catch (Exception e) {
            e.printStackTrace();
        }

        return bytes;
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
