package pt.isep.nsheets.client.lapr4.red.s2.s1160777.application.exportToCLS;

import com.google.gwt.core.client.GWT;
import com.google.gwt.uibinder.client.UiBinder;
import com.google.gwt.uibinder.client.UiField;
import com.google.gwt.user.client.Window;
import com.google.gwt.user.client.rpc.AsyncCallback;
import com.google.gwt.user.client.ui.Composite;
import com.google.gwt.user.client.ui.Widget;
import gwt.material.design.addins.client.window.MaterialWindow;
import gwt.material.design.client.constants.TextAlign;
import gwt.material.design.client.constants.WavesType;
import gwt.material.design.client.ui.MaterialButton;
import gwt.material.design.client.ui.MaterialLabel;
import gwt.material.design.client.ui.MaterialTextBox;
import gwt.material.design.client.ui.MaterialToast;
import pt.isep.nsheets.shared.core.Workbook;
import pt.isep.nsheets.shared.services.DownloadService;
import pt.isep.nsheets.shared.services.DownloadServiceAsync;

public class ExportToCLSView extends Composite {

    @UiField
    MaterialWindow window;

    @UiField
    MaterialButton btnExport;

    @UiField
    MaterialTextBox textBox1;


    private static ExportToCLSBinder uiBinder = GWT.create(ExportToCLSBinder.class);

    interface ExportToCLSBinder extends UiBinder<Widget, ExportToCLSView> {
    }

    public ExportToCLSView(Workbook workbook) {
        initWidget(uiBinder.createAndBindUi(this));

        window.setPadding(32);
        window.setHeight("400px");
        window.setTextAlign(TextAlign.LEFT);
        window.setTitle("Export to CLS");
        MaterialWindow.setOverlay(true);
        window.setWaves(WavesType.LIGHT);
        textBox1.setPlaceholder("Name Of The File");

        /*after having the filename in the prompt*/
        btnExport.addClickHandler(event -> {
            String fileInfo1 = textBox1.getText();
            DownloadServiceAsync downAsync = GWT.create(DownloadService.class);
            // Set up the callback object. WORKBOOK HERE DOESNT LET THE WINDOW OPEN. MUST SEND ANOTHER WAY
            downAsync.exportToDownload(workbook,new AsyncCallback<Workbook>() {
                @Override
                public void onFailure(Throwable caught) {
                    MaterialToast.fireToast("Error! " + caught.getMessage());
                }

                @Override
                public void onSuccess(Workbook result) {
                    MaterialToast.fireToast("Exported successfully!", "rounded");
                }
            });

            String url = GWT.getModuleBaseURL() + fileInfo1;
            Window.open(url,"Download CLS file","status=0,toolbar=0,menubar=0,location=0");
        });
        window.open();
    }

    public MaterialWindow popUpWindow() {
        return this.window;
    }

    public MaterialButton btnExport() {
        return this.btnExport;
    }

    public MaterialTextBox textBox() {
        return this.textBox1;
    }

}
