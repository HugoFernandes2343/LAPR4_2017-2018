/*
 * Copyright (c) 2005 Einar Pehrson <einar@pehrson.nu>.
 *
 * This file is part of
 * CleanSheets - a spreadsheet application for the Java platform.
 *
 * CleanSheets is free software; you can redistribute it and/or modify
 * it under the terms of the GNU General Public License as published by
 * the Free Software Foundation; either version 2 of the License, or
 * (at your option) any later version.
 *
 * CleanSheets is distributed in the hope that it will be useful,
 * but WITHOUT ANY WARRANTY; without even the implied warranty of
 * MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
 * GNU General Public License for more details.
 *
 * You should have received a copy of the GNU General Public License
 * along with CleanSheets; if not, write to the Free Software
 * Foundation, Inc., 59 Temple Place, Suite 330, Boston, MA  02111-1307  USA
 */
package pt.isep.nsheets.shared.core;

// import java.io.ObjectInputStream;		// not supported in GWT
// import java.io.ObjectOutputStream;	// not supported in GWT
import java.util.*;
import javax.persistence.CollectionTable;
import javax.persistence.Column;
import javax.persistence.ElementCollection;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.MapKeyColumn;
import javax.persistence.OneToMany;

import pt.isep.nsheets.shared.core.formula.compiler.FormulaCompilationException;
import pt.isep.nsheets.shared.lapr4.red.s1160777.ext.Extension;
import pt.isep.nsheets.shared.lapr4.red.s1160777.ext.ExtensionManager;
import pt.isep.nsheets.shared.lapr4.red.s1160777.ext.SpreadsheetExtension;
import pt.isep.nsheets.shared.services.SpreadsheetDTO;

/**
 * The implementation of the <code>Spreadsheet</code> interface.
 *
 * @author Einar Pehrson
 */
@Entity
public class SpreadsheetImpl implements Spreadsheet {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    /**
     * The unique version identifier used for serialization
     */
    private static final long serialVersionUID = 7010464744129096272L;

    /**
     * The base of the titles of new spreadsheets
     */
    public static final String BASE_TITLE = "Sheet ";

    /**
     * The workbook to which the spreadsheet belongs
     */
    @ManyToOne
    private Workbook workbook;

    /**
     * The cells that have been instantiated
     */
    @OneToMany(targetEntity = CellImpl.class)
    @ElementCollection
    @CollectionTable(name = "Cell_Adresses")
    @MapKeyColumn(name = "Column_Adresses")
    @Column(name = "Cell_Columns")
    private Map<Address, Cell> cells = new HashMap<Address, Cell>();

    /**
     * The title of the spreadsheet
     */
    private String title;

    /**
     * The number of columns in the spreadsheet
     */
    private int columns = 0;

    /**
     * The number of rows in the spreadsheet
     */
    private int rows = 0;

    /**
     * The cell listeners that have been registered on the cell
     */
    private transient List<CellListener> cellListeners
            = new ArrayList<CellListener>();

    /**
     * The cell listener that forwards events from all cells
     */
    private transient CellListener eventForwarder = new EventForwarder();

    /**
     * The spreadsheet extensions that have been instantiated
     */
    private transient Map<String, SpreadsheetExtension> extensions
            = new HashMap<String, SpreadsheetExtension>();

    
    public SpreadsheetImpl() {
    }

    /**
     * Creates a new spreadsheet.
     *
     * @param workbook the workbook to which the spreadsheet belongs
     * @param title the title of the spreadsheet
     */
    public SpreadsheetImpl(Workbook workbook, String title) {
        this.workbook = workbook;
        this.title = title;
    }

    /**
     * Creates a new spreadsheet, in which cells are initialized with data from
     * the given content matrix.
     *
     * @param workbook the workbook to which the spreadsheet belongs
     * @param title the title of the spreadsheet
     * @param content the contents of the cells in the spreadsheet
     */
    public SpreadsheetImpl(Workbook workbook, String title, String[][] content) {
        this(workbook, title);
        rows = content.length;
        for (int row = 0; row < content.length; row++) {
            int columns = content[row].length;
            if (this.columns < columns) {
                this.columns = columns;
            }
            for (int column = 0; column < columns; column++) {
                try {
                    Address address = new Address(column, row);
                    Cell cell = new CellImpl(this, address, content[row][column]);
                    cell.addCellListener(eventForwarder);
                    cells.put(address, cell);
                } catch (FormulaCompilationException e) {
                }
            }
        }
    }
    /*
 * LOCATION
     */
    public Workbook getWorkbook() {
        return workbook;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
        // fireTitleChanged();
    }

    /*
 * DIMENSIONS
     */
    public int getColumnCount() {
        return columns;
    }

    public int getRowCount() {
        return rows;
    }

    /*
 * CELLS
     */
    public Cell getCell(Address address) {
        // Updates spreadsheet dimensions
        if (address.getRow() > rows) {
            rows = address.getRow();
        }
        if (address.getColumn() > columns) {
            columns = address.getColumn();
        }

        // Looks for a previously used cell with this address
        Cell cell = cells.get(address);

        // If the cell has never been requested, create a new one
        if (cell == null) {
            cell = new CellImpl(this, address);
            cell.addCellListener(eventForwarder);
            cells.put(address, cell);
        }
        return cell;
    }

    public void sortCells(String address1, String address2, String dataType, String sortType) {
        Address add1 = findAddress(address1);
        Address add2 = findAddress(address2);
        if (add1 == null || add2 == null) {
            throw new UnsupportedOperationException();
        }
        SortedSet<Cell> sort = getCells(add1, add2);

        if (sortType.equals("Ascending")) {
            sortAscending(sort);
        }
        if (sortType.equals("Descending")) {
            sortDescending(sort);
        }
    }

    public Address findAddress(String reference) {
        for (Address add : cells.keySet()) {
            if (add.toString().equalsIgnoreCase(reference)) {
                return add;
            }
        }
        return null;
    }

    private void sortAscending(SortedSet<Cell> sort) {
        int i = 0;
        Cell list[] = new Cell[sort.size()];
        for (Cell cell : sort) {
            list[i] = cell;
            i++;
        }
        for (int j = 0; j < sort.size(); j++) {
            for (int k = 1; k < sort.size() - 1; k++) {
                if (list[j].getContent().compareTo(list[k].getContent()) > 0) {
                    Cell temp = list[j];
                    list[j] = list[k];
                    list[k] = temp;
                }
            }
        }
        updateCells(list);
    }

    private void sortDescending(SortedSet<Cell> sort) {
        int i = 0;
        Cell list[] = new Cell[sort.size()];
        for (Cell cell : sort) {
            list[i] = cell;
            i++;
        }
        for (int j = 0; j < sort.size(); j++) {
            for (int k = 1; k < sort.size() - 1; k++) {
                if (list[j].getContent().compareTo(list[k].getContent()) < 0) {
                    Cell temp = list[j];
                    list[j] = list[k];
                    list[k] = temp;
                }
            }
        }
        updateCells(list);
    }

    private void updateCells(Cell list[]) {
        for (int i = 0; i < list.length; i++) {
            cells.replace(list[i].getAddress(), list[i]);
        }
    }

    public Cell getCell(int column, int row) {
        return getCell(new Address(column, row));
    }

    public SortedSet<Cell> getCells(Address address1, Address address2) {
        // Sorts addresses
        if (address1.compareTo(address2) > 0) {
            Address tempAddress = address1;
            address1 = address2;
            address2 = tempAddress;
        }

        // Builds the set
        SortedSet<Cell> cells = new TreeSet<Cell>();
        for (int column = address1.getColumn(); column <= address2.getColumn(); column++) {
            for (int row = address1.getRow(); row <= address2.getRow(); row++) {
                cells.add(getCell(new Address(column, row)));
            }
        }

        return cells;
    }

    public Cell[] getColumn(int index) {
        Cell[] column = new Cell[rows];
        for (int row = 0; row < row; row++) {
            column[row] = getCell(new Address(index, row));
        }
        return column;
    }

    public Cell[] getRow(int index) {
        Cell[] row = new Cell[columns];
        for (int column = 0; column < columns; column++) {
            row[column] = getCell(new Address(column, index));
        }
        return row;
    }

    public Iterator<Cell> iterator() {
        return cells.values().iterator();
    }

    /*
 * EVENT HANDLING
     */
    public void addCellListener(CellListener listener) {
        cellListeners.add(listener);
    }

    public void removeCellListener(CellListener listener) {
        cellListeners.remove(listener);
    }

    public CellListener[] getCellListeners() {
        return cellListeners.toArray(new CellListener[cellListeners.size()]);
    }

    @Override
    public SpreadsheetDTO toDTO() {
        String[][] content = new String[getRowCount()][getColumnCount()];
        for (int i = 0; i < getRowCount(); i++) {
            Cell[] vecCells = getRow(i);
            for (int j = 0; i < vecCells.length; j++) {
                content[i][j] = vecCells[j].getContent();
            }
        }
        return new SpreadsheetDTO(title, columns, rows, content);
    }

    /**
     * A cell listener that forwards events from all cells to registered
     * listeners.
     */
    private class EventForwarder implements CellListener {

        /**
         * Creates a new event forwarder.
         */
        public EventForwarder() {
        }

        public void valueChanged(Cell cell) {
            for (CellListener listener : cellListeners) {
                listener.valueChanged(cell);
            }
        }

        public void contentChanged(Cell cell) {
            for (CellListener listener : cellListeners) {
                listener.contentChanged(cell);
            }
        }

        public void dependentsChanged(Cell cell) {
            for (CellListener listener : cellListeners) {
                listener.dependentsChanged(cell);
            }
        }

        public void cellCleared(Cell cell) {
            for (CellListener listener : cellListeners) {
                listener.cellCleared(cell);
            }
        }

        public void cellCopied(Cell cell, Cell source) {
            for (CellListener listener : cellListeners) {
                listener.cellCopied(cell, source);
            }
        }
    }

    /*
 * EXTENSIONS
     */
    public Spreadsheet getExtension(String name) {
        // Looks for an existing spreadsheet extension
        SpreadsheetExtension extension = extensions.get(name);
        if (extension == null) {
            // Creates a new spreadsheet extension
            Extension x = ExtensionManager.getInstance().getExtension(name);
            if (x != null) {
                extension = x.extend(this);
                if (extension != null) {
                    extensions.put(name, extension);
                }
            }
        }
        return extension;
    }
    
    /*
 * GENERAL
     */
    /**
     * Customizes deserialization by catching exceptions when extensions are not
     * found.
     *
     * @param stream the object input stream from which the object is to be read
     * @throws IOException If any of the usual Input/Output related exceptions
     * occur
     * @throws ClassNotFoundException If the class of a serialized object cannot
     * be found.
     */
    // Not supported in GWT
//	private void readObject(ObjectInputStream stream) throws IOException, ClassNotFoundException {
//	    stream.defaultReadObject();
//
//		// Sets up event forwarder
//		eventForwarder = new EventForwarder();
//		for (Cell cell : cells.values())
//			cell.addCellListener(eventForwarder);
//		cellListeners = new ArrayList<CellListener>();
//
//		// Reads extensions
//		extensions = new HashMap<String, SpreadsheetExtension>();
//		int extCount = stream.readInt();
//		for (int i = 0; i < extCount; i++) {
//			try {
//				SpreadsheetExtension extension = (SpreadsheetExtension)stream.readObject();
//				extensions.put(extension.getName(), extension);
//			} catch (ClassNotFoundException e) {
//				System.err.println(e);
//			}
//		}
//	}
    /**
     * Customizes serialization, by writing extensions separately.
     *
     * @param stream the object output stream to which the object is to be
     * written
     * @throws IOException If any of the usual Input/Output related exceptions
     * occur
     */
    // not supported in GWT
//	private void writeObject(ObjectOutputStream stream) throws IOException {
//		stream.defaultWriteObject();
//
//		// Writes extensions
//		stream.writeInt(extensions.size());
//		for (SpreadsheetExtension extension : extensions.values())
//			stream.writeObject(extension);
//	}
}