package pt.isep.nsheets.server.services;

import pt.isep.nsheets.shared.services.DataException;
import pt.isep.nsheets.shared.services.DownloadToPDFService;
import pt.isep.nsheets.shared.services.WorkbookDTO;

import javax.servlet.ServletException;
import javax.servlet.ServletOutputStream;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.ObjectOutputStream;

public class DownloadPDFImpl /*extends HttpServlet implements DownloadToPDFService*/ {
/*
    private WorkbookDTO toExport;

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        super.doPost(request, response);


    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        int BUFFER = 1024 * 100;

        String fileName = request.getParameter("filename");

        response.setContentType("text/plain");
        response.setHeader("Content-Disposition", "attachment;fileName=\"" + fileName);
        response.setBufferSize(BUFFER);



        try {
            ServletOutputStream outputStream = response.getOutputStream();
            ObjectOutputStream oos = new ObjectOutputStream(outputStream);
            oos.writeObject(this.toExport);
            oos.flush();
            outputStream.close();
        } catch (Exception e) {
            e.printStackTrace();
        }

    }

    @Override
    public WorkbookDTO exportToDownload(WorkbookDTO toExport) throws DataException {
        this.toExport = toExport;
        return toExport;
    }*/
}
