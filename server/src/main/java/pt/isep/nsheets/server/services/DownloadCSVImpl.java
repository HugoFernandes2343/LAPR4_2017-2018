/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pt.isep.nsheets.server.services;

import com.google.gwt.user.server.rpc.RemoteServiceServlet;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.ObjectOutputStream;
import javax.servlet.ServletException;
import javax.servlet.ServletOutputStream;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.swing.JFileChooser;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import pt.isep.nsheets.server.lapr4.blue.s3.ipc.n1150585.ExportCSV.application.ExportCSVController;
import pt.isep.nsheets.shared.core.Workbook;

import pt.isep.nsheets.shared.services.WorkbookDTO;

/**
 *
 * @author Daniel Fernandes 1150585
 */
public class DownloadCSVImpl extends HttpServlet {

    Workbook toExport;

    protected void doGet(HttpServletRequest request, HttpServletResponse response) {
        int BUFFER = 1024 * 100;

        String fileName = request.getParameter("filename");

        response.setContentType("application/octet-stream");
        response.setHeader("Content-Disposition", "attachment;filename=\"" + fileName + "\".csv");//test cls
        response.setBufferSize(BUFFER);

        try {
            ServletOutputStream outputStream = response.getOutputStream();
            ObjectOutputStream oos = new ObjectOutputStream(outputStream);
            oos.writeObject(this.toExport);
            oos.flush();
            outputStream.close();
        } catch (Exception e) {
            e.printStackTrace();
            System.err.println("Inside Try/catch");
        }

    }
}
