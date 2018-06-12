/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pt.isep.nsheets.shared.services;

import java.io.Serializable;
import java.util.List;
import pt.isep.nsheets.shared.core.Workbook;

/**
 *
 * @author Pedro Tedim
 */
public class WorkbookDTO implements Serializable {
    
    public List<SpreadsheetDTO> spreadsheets;

    public int createdSpreadsheets;

    

    /**
     * for ORM
     */
    public WorkbookDTO() {
    }

    
    public WorkbookDTO(List<SpreadsheetDTO> list, int createdSpreadsheets) {
        this.spreadsheets = list;
        this.createdSpreadsheets = createdSpreadsheets;
    }

    public List<SpreadsheetDTO> getSpreadsheets() {
        return spreadsheets;
    }

    public int getCreatedSpreadsheets() {
        return createdSpreadsheets;
    }
    
    public Workbook fromDTO(Workbook wb){
        
        return new Workbook(this);
        
    }

       
}
