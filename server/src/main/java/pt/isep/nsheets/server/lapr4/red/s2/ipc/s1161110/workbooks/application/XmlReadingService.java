package pt.isep.nsheets.server.lapr4.red.s2.ipc.s1161110.workbooks.application;

import pt.isep.nsheets.shared.core.Address;
import pt.isep.nsheets.shared.core.CellImpl;
import pt.isep.nsheets.shared.core.SpreadsheetImpl;
import pt.isep.nsheets.shared.core.Workbook;


import com.thoughtworks.xstream.XStream;
import com.thoughtworks.xstream.io.xml.DomDriver;
import java.io.Serializable;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import org.w3c.dom.DOMException;
import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;
import org.xml.sax.SAXException;
import pt.isep.nsheets.shared.core.formula.compiler.FormulaCompilationException;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;

public class XmlReadingService implements Serializable {

    /**
     * Variable that defines the serialVersionUID
     */
    static final long serialVersionUID = 111L;


    public static Workbook loadXml(String file) throws IOException, NumberFormatException, ParserConfigurationException, DOMException, SAXException, FormulaCompilationException {


        File inputFile = new File(file);
        DocumentBuilderFactory dbFactory = DocumentBuilderFactory.newInstance();
        DocumentBuilder dBuilder = dbFactory.newDocumentBuilder();
        Document doc = dBuilder.parse(inputFile);
        doc.getDocumentElement().normalize();


        NodeList nList = doc.getElementsByTagName("spreadsheet");//spreadsheet
        Workbook wb = new Workbook(nList.getLength());/**Need to replace the current workbook*/
        for (int i = 0; i < nList.getLength(); i++) {
            if (nList.item(i).getNodeType() == Node.ELEMENT_NODE) {
                Element e = (Element) nList.item(i);//spreadsheet
                SpreadsheetImpl sp = (SpreadsheetImpl) wb.getSpreadsheet(i);

                NodeList nodes = e.getElementsByTagName("cell");//cell
                for (int j = 0; j < nodes.getLength(); j++) {
                    if (nodes.item(j).getNodeType() == Node.ELEMENT_NODE) {
                        Element el = (Element) nodes.item(j);//cell
                        int column = Integer.parseInt(elementValueByTag(e, "column"));
                        int row = Integer.parseInt(elementValueByTag(e, "row"));
                        Address add = new Address(column, row);

                        String value = elementValueByTag(e, "value");

                        sp.getCell(add).setContent(value);

                    }
                }
            }
        }
        return wb;
    }

    private static String elementValueByTag(Element e, String type) {
        String value = "";
        NodeList nodes = e.getElementsByTagName(type);
        for (int j = 0; j < nodes.getLength(); j++) {
            value = nodes.item(j).getTextContent();
        }
        return value;
    }

}
