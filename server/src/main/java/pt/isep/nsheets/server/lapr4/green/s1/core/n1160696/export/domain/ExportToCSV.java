/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pt.isep.nsheets.server.lapr4.green.s1.core.n1160696.export.domain;

import java.io.FileWriter;
import java.io.IOException;
import java.io.Writer;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import pt.isep.nsheets.server.lapr4.white.s1.core.n4567890.workbooks.persistence.WorkbookDescriptionRepository;
import pt.isep.nsheets.server.services.WorkbooksServiceImpl;
import pt.isep.nsheets.shared.core.Workbook;
import pt.isep.nsheets.shared.services.WorkbookDescriptionDTO;

/**
 *
 * @author João Santiago <1160696@isep.ipp.pt>
 */
public class ExportToCSV {

    private static final char COMMA = ',';
    private static final String NEWLINE = System.getProperty("line.separator");
    
    public static void writeLine(Writer w, List<String> values) throws IOException {
        writeLine(w, values, COMMA, ' ');
    }

    public static void writeLine(Writer w, List<String> values, char separators) throws IOException {
        writeLine(w, values, separators, ' ');
    }

    private static String followCVSformat(String value) {

        String result = value;
        if (result.contains("\"")) {
            result = result.replace("\"", "\"\"");
        }
        return result;

    }

    public static void writeLine(Writer w, List<String> values, char separators, char customQuote) throws IOException {

        boolean first = true;


        if (separators == ' ') {
            separators = COMMA;
        }

        StringBuilder sb = new StringBuilder();
        for (String value : values) {
            if (!first) {
                sb.append(separators);
            }
            if (customQuote == ' ') {
                sb.append(followCVSformat(value));
            } else {
                sb.append(customQuote).append(followCVSformat(value)).append(customQuote);
            }

            first = false;
        }
        sb.append("\n");
        w.append(sb.toString());


    }

    public static void exportCVSFile(String fileName, Workbook w) throws IOException {
        
            FileWriter writer = new FileWriter(fileName + ".csv");
            
            
            
            
            
//            for (List<Workbook> oi : w) {
//                writer.append((char) exp.getRankingPalChaveExp().indexOf(aLS));
//                for (String palavraChave : aLS) {
//                    writer.append(",");
//                    writer.append(palavraChave);
//                }
//                writer.append("\n");
//            }
//            writer.flush();
//            writer.close();
//        } catch (IOException e) {
//            e.printStackTrace();
//        }
//
    }
    
    public static void main(String[] args) throws Exception {
        
        String fileName = "oi";
        FileWriter writer = new FileWriter(fileName + ".csv");
        
        
        List<Workbook> wb = Arrays.asList(
                new Workbook("oi","oi"),
                new Workbook("ola","ola"),
                new Workbook("xau","xau")
        );
        
        writeLine(writer, Arrays.asList("Name", "Description"));
        
        for(Workbook w : wb){
            
            List<String> list = new ArrayList<>();
            list.add(w.getName());
            list.add(w.getDescription());
            
            writeLine(writer, list);
            
            writer.flush();
            writer.close();
            
        }
    }
}
