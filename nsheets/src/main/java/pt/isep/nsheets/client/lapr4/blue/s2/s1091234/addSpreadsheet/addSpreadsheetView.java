/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pt.isep.nsheets.client.lapr4.blue.s2.s1091234.addSpreadsheet;

import com.google.gwt.core.client.GWT;
import com.google.gwt.uibinder.client.UiBinder;
import com.google.gwt.uibinder.client.UiField;
import com.google.gwt.user.client.Window;
import com.google.gwt.user.client.rpc.AsyncCallback;
import com.google.gwt.user.client.ui.Composite;
import com.google.gwt.user.client.ui.Widget;
import com.gwtplatform.mvp.client.ViewImpl;
import gwt.material.design.addins.client.window.MaterialWindow;
import gwt.material.design.client.ui.MaterialButton;
import gwt.material.design.client.ui.MaterialLabel;
import gwt.material.design.client.ui.MaterialTextBox;
import gwt.material.design.client.ui.MaterialToast;
import pt.isep.nsheets.client.application.workbook.CurrentWorkbook;
import pt.isep.nsheets.shared.core.Workbook;
import pt.isep.nsheets.shared.services.SpreadsheetDTO;
import pt.isep.nsheets.shared.services.WorkbookDTO;
import pt.isep.nsheets.shared.services.WorkbookDescriptionDTO;
import pt.isep.nsheets.shared.services.WorkbooksService;
import pt.isep.nsheets.shared.services.WorkbooksServiceAsync;

/**
 *
 * @author Pedro Tedim
 */
public class addSpreadsheetView extends ViewImpl {

    @UiField
    MaterialWindow windowSpreadsheet;

    private static addSpreadsheetViewUiBinder uiBinder = GWT.create(addSpreadsheetViewUiBinder.class);

    interface addSpreadsheetViewUiBinder extends UiBinder<Widget, addSpreadsheetView> {
    }

    public addSpreadsheetView() {
        initWidget(uiBinder.createAndBindUi(this));
        MaterialLabel lbl = new MaterialLabel("Insert new spreedsheet title");
        MaterialTextBox tb = new MaterialTextBox();
        MaterialButton bt = new MaterialButton("Ok");
        windowSpreadsheet.add(lbl);
        windowSpreadsheet.add(tb);
        windowSpreadsheet.add(bt);

        windowSpreadsheet.open();

        bt.addClickHandler(event -> {
            WorkbooksServiceAsync async = GWT.create(WorkbooksService.class);
            AsyncCallback<Boolean> callback = new AsyncCallback<Boolean>() {
                @Override
                public void onFailure(Throwable caught) {
                    MaterialToast.fireToast("Error creating Spreadsheet...");
                }

                @Override
                public void onSuccess(Boolean result) {
                    MaterialToast.fireToast("Success creating Spreadsheet...");
                }
                
            };
            SpreadsheetDTO ssDTO = new SpreadsheetDTO();
            ssDTO.setTitle(tb.getText());
            WorkbookDTO wb = CurrentWorkbook.getCurrentWorkbook().toDTO();
            wb.spreadsheets.add(ssDTO);
            Workbook newWb = new Workbook(wb);
            WorkbookDTO newWbDTO = new WorkbookDTO(wb.getSpreadsheets(), wb.createdSpreadsheets);

            async.addSpreadsheetToWorkbook(newWbDTO, ssDTO, callback);
            windowSpreadsheet.close();

        });
    }
}
