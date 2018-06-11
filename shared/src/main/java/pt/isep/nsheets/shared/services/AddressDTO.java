/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pt.isep.nsheets.shared.services;

import java.io.Serializable;

/**
 *
 * @author João Santiago <1160696@isep.ipp.pt>
 */
public class AddressDTO implements Serializable, Comparable<AddressDTO> {

    public int column;
    public int row;
    public String string;

    private AddressDTO() {
    }

    ;
    
    public AddressDTO(int column, int row, String string) {
        this.column = column;
        this.row = row;
        this.string = string;
    }

    @Override
    public int hashCode() {
        int hash = 7;
        hash = 53 * hash + this.column;
        hash = 53 * hash + this.row;
        return hash;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }

        if (o == null || o.getClass() != getClass()) {
            return false;
        }

        AddressDTO other = (AddressDTO) o;

        return (column == other.column && row == other.row);
    }

    @Override
    public int compareTo(AddressDTO t) {
        if (t.row == row && t.column > column) {
            return 1;
        } else if (t.row == row && t.column < column) {
            return -1;
        } else if (t.column == column && t.row > row) {
            return 1;
        } else if (t.column == column && t.row < row) {
            return -1;
        } else {
            return 0;
        }
    }

}
