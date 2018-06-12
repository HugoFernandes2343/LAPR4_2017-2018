/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pt.isep.nsheets.shared.services;

import java.io.Serializable;
import java.util.Map;
import java.util.TreeSet;

/**
 *
 * @author João Santiago <1160696@isep.ipp.pt>
 */
public class SpreadsheetImplDTO implements Serializable{
    
    public Map<AddressDTO, CellImplDTO> cells;
    public String title;
    public int columns;
    public int rows;
    public Long workbookId;
    public Long id;
    
    
    private SpreadsheetImplDTO() {};
    
    public SpreadsheetImplDTO(Long id, Map<AddressDTO, CellImplDTO> cells, String title, int columns, int rows){
        this.id = id;
        this.cells = cells;
        this.title = title;
        this.columns = columns;
        this.rows = rows;
    }
    
    
    public void updateCell(int column, int row, String content)
    {
        AddressDTO address = new AddressDTO(column, row, "");
        if (cells.get(address) == null)
            cells.put(address, new CellImplDTO(null, null, address, content, new TreeSet<>(), new TreeSet<>()));
        else
            cells.get(address).setContent(content);
    }

    public String toString(){
        return title;
    }
    
    
}
