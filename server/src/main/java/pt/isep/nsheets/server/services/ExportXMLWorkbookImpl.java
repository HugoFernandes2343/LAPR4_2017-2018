/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pt.isep.nsheets.server.services;

import com.google.gwt.user.server.rpc.RemoteServiceServlet;
import com.thoughtworks.xstream.XStream;
import pt.isep.nsheets.shared.services.ExportXMLWorkbookService;
import pt.isep.nsheets.shared.services.SpreadsheetDTO;
import pt.isep.nsheets.shared.services.WorkbookDTO;

import javax.servlet.ServletOutputStream;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.*;

/**
 *
 * @author Barbara Csonka 1171715
 */
public class ExportXMLWorkbookImpl extends RemoteServiceServlet implements ExportXMLWorkbookService {

    WorkbookDTO toExport;

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) {
        String fileName = request.getParameter("filename");

        try {
            //1st, generate a local XML file
            generateXMLFromWorkbook(toExport, fileName);
            //2nd, send it through
            DownloadUtility.sendFileAsByteStream(response, fileName);
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void generateXMLFromWorkbook(WorkbookDTO workbookDTO, String filename) throws FileNotFoundException, IOException {
        XStream xstream = new XStream();
        xstream.alias("workbook", WorkbookDTO.class);
        xstream.addImplicitCollection(WorkbookDTO.class, "spreadsheets");
        xstream.alias("spreadsheet", SpreadsheetDTO.class);

        FileOutputStream fos = null;
        try{
            String xml = xstream.toXML(workbookDTO);
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
    public WorkbookDTO exportToDownload(WorkbookDTO toExport) {
        this.toExport = toExport;
        return toExport;
    }
}
