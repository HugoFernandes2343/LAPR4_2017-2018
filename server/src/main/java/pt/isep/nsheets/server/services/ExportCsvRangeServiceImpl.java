/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pt.isep.nsheets.server.services;

import com.google.gwt.user.server.rpc.RemoteServiceServlet;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Set;
import javax.servlet.ServletOutputStream;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import pt.isep.nsheets.shared.core.Cell;
import pt.isep.nsheets.shared.services.DataException;
import pt.isep.nsheets.shared.services.ExportCsvRangeService;
import pt.isep.nsheets.shared.services.SpreadsheetDTO;

/**
 *
 * @author dftsf
 */
public class ExportCsvRangeServiceImpl extends RemoteServiceServlet implements ExportCsvRangeService {

    ArrayList<String> toExport;

    /*@Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
        this.doGet(request, response);
    }*/
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) {
        String fileName = request.getParameter("filename");

        try {
            //1st, generate a local PDF file
            generateCSVFromWorkbook(toExport, fileName);
            //2nd, send it through
            DownloadUtility.sendFileAsByteStream(response, fileName);
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public FileWriter generateCSVFromWorkbook(ArrayList<String> content, String filename) throws FileNotFoundException, IOException {
        File file = new File(filename);
        FileWriter fileWriter = null;
        try {

            fileWriter = new FileWriter(file);
            fileWriter.append("SEP=" + "," + "\n");

            for (String value : content) {
                fileWriter.append(value);
                fileWriter.append(",");
            }
            //fileWriter.append("\n");
        } catch (Exception e) {

            System.out.println("Error in CsvFileWriter !!!");

            e.printStackTrace();

        } finally {
            try {
                fileWriter.flush();
                fileWriter.close();
            } catch (IOException e) {
                System.out.println("Error while flushing/closing fileWriter !!!");
                e.printStackTrace();
            }
            return fileWriter;
        }
    }

    @Override
    public ArrayList<String> exportToDownload(ArrayList<String> toExport) throws DataException {
        this.toExport = toExport;
        return toExport;

    }

}
