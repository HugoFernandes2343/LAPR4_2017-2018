package pt.isep.nsheets.server.services;

import javax.servlet.ServletOutputStream;
import javax.servlet.http.HttpServletResponse;
import java.io.FileInputStream;
import java.io.IOException;

public class DownloadUtility {

    //Make this a Utility class
    private DownloadUtility() {
    }

    /**
     * Sends a file through a HttpServletResponse as a byte stream
     * @param response
     * @param fileName
     * @throws IOException
     */
    public static void sendFileAsByteStream(HttpServletResponse response, String fileName) throws IOException {
        int BUFFER = 1024 * 100;//set a reasonable size
        response.setContentType( "application/octet-stream" );
        response.setHeader( "Content-Disposition:", "attachment;filename=" + fileName);
        ServletOutputStream outputStream = response.getOutputStream();
        byte[] bytes = fileToByteArray(fileName);
        response.setContentLength( Long.valueOf( bytes.length ).intValue() );
        response.setBufferSize( BUFFER );
        outputStream.write(bytes);
        outputStream.close();
    }

    private static byte[] fileToByteArray(String filename) {

        byte[] bytes = null;

        try {
            java.io.File file = new java.io.File(filename);
            if (file.exists()){
                FileInputStream fis = new FileInputStream(file);
                bytes = new byte[(int) file.length()];
                fis.read(bytes);
            }
            else{
                System.out.println ("File does not exist");
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return bytes;
    }
}
