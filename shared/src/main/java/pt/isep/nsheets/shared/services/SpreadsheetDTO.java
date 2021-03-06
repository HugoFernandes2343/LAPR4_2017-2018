/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pt.isep.nsheets.shared.services;

import java.io.Serializable;

/**
 *
 * @author Pedro Tedim
 */
public class SpreadsheetDTO implements Serializable {

    public String[][] content;

    public String title;

    private int columns;

    private int rows;

    public SpreadsheetDTO() {
    }

    public SpreadsheetDTO(String title, int columns, int rows, String[][] content) {
        this.title = title;
        this.columns = columns;
        this.rows = rows;
        this.content = content;
    }

    public String getTitle() {
        return title;
    }

    public int getColumnCount() {
        return columns;
    }

    public int getRowCount() {
        return rows;
    }

    public String[][] getContent() {
        return content;
    }

    public String[][] getCellRange(int upperLeftRow, int upperLeftColumn, int lowerRightRow, int lowerRightColumn) {
        int horizontalLength = lowerRightColumn - upperLeftColumn + 1;
        int verticalLength = lowerRightRow - upperLeftRow + 1;
        String[][] result = new String[verticalLength][horizontalLength];

        for (int i = upperLeftRow; i <= lowerRightRow; i++) {
            for (int j = upperLeftColumn; j <= lowerRightColumn; j++) {
                result[i-upperLeftRow][j-upperLeftColumn] = content[i][j];
            }
        }

        return result;
    }

    public void setContent(String[][] content) {
        this.content = content;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public void setColumns(int columns) {
        this.columns = columns;
    }

    public void setRows(int rows) {
        this.rows = rows;
    }
    
    

}
