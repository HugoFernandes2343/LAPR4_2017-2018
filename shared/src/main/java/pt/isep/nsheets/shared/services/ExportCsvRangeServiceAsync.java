/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pt.isep.nsheets.shared.services;

import com.google.gwt.user.client.rpc.AsyncCallback;
import java.util.ArrayList;
import java.util.Set;
import pt.isep.nsheets.shared.core.Cell;

/**
 *
 * @author Daniel Fernandes 1150585
 */
public interface ExportCsvRangeServiceAsync {
      void exportToDownload( String[][] toExport, AsyncCallback<String[][]>  async);
}
