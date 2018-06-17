/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pt.isep.nsheets.shared.services;

import com.google.gwt.user.client.rpc.RemoteService;
import com.google.gwt.user.client.rpc.RemoteServiceRelativePath;
import java.util.ArrayList;
import java.util.Set;
import pt.isep.nsheets.shared.core.Cell;

/**
 *
 * @author Daniel Fernandes 1150585
 */
@RemoteServiceRelativePath("exportCsvRangeService")
public interface ExportCsvRangeService extends RemoteService {
    ArrayList <String> exportToDownload( ArrayList<String> toExport) throws DataException;
}
