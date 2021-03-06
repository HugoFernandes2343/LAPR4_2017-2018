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
package pt.isep.nsheets.shared.lapr4.red.s1160777.ext;

import gwt.material.design.client.ui.table.MaterialDataTable;
import java.util.Collection;


/**
 * An interface for extensible classes.
 *
 * @author Einar Pehrson
 */
public interface Extensible<T> {

    /**
     * Returns the extension with the given key.
     *
     * @param name the name of the extension (case-insensitive)
     * @return the appropriate extension, or null if no extension with the given
     * name was found
     */
    public T getExtension(String name);

    /**
     * Adds a color extension to the actual cell.
     *
     * @param name for the extension
     * @param c1 color for negative value
     * @param c2 color for positive value
     * @param table MaterialDataTable from workbook tab
     */
    public void addColorExtension(String name, String c1, String c2, MaterialDataTable<?> table);

    /**
     * returns alls the cell extensions in a given cell
     *
     * @return all cell extensions
     */
    public Collection<CellExtension> getListExtension();
}

