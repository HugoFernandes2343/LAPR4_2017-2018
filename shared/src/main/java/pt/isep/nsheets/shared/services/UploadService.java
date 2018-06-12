package pt.isep.nsheets.shared.services;

import com.google.gwt.user.client.rpc.RemoteService;
import com.google.gwt.user.client.rpc.RemoteServiceRelativePath;

import pt.isep.nsheets.shared.core.Workbook;
import pt.isep.nsheets.shared.core.formula.compiler.FormulaCompilationException;


import java.io.IOException;

/**
 *  Author David Maia 1161110
 */
@RemoteServiceRelativePath("uploadService")
public interface UploadService extends RemoteService {

    Workbook importToWorkbook(Workbook wb) throws IOException, NumberFormatException, FormulaCompilationException;

}
