package pt.isep.nsheets.client.lapr4.red.s2.s1160777.application.exportToCLS;

import com.google.gwt.core.client.GWT;
import com.google.gwt.uibinder.client.UiBinder;
import com.google.gwt.uibinder.client.UiField;
import com.google.gwt.user.client.Window;
import com.google.gwt.user.client.ui.Composite;
import com.google.gwt.user.client.ui.Widget;
import gwt.material.design.addins.client.window.MaterialWindow;
import gwt.material.design.client.constants.TextAlign;
import gwt.material.design.client.constants.WavesType;
import gwt.material.design.client.ui.MaterialButton;
import gwt.material.design.client.ui.MaterialTextBox;
import pt.isep.nsheets.server.services.DownloadCLSImpl;
import pt.isep.nsheets.shared.core.Workbook;
import pt.isep.nsheets.shared.services.DataException;
import pt.isep.nsheets.shared.services.WorkbookDTO;

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

        //window.setPadding(32);
        //window.setHeight("400px");
        window.setTextAlign(TextAlign.LEFT);
        MaterialWindow.setOverlay(true);
        btnExport.setWaves(WavesType.LIGHT);
        textBox1.setPlaceholder("Name Of The File");

        btnExport.addClickHandler(event -> {

            WorkbookDTO dto = workbook.toDTO();

            //DownloadToCLSServiceAsync downAsync = GWT.create(DownloadToCLSService.class);
            /*
            downAsync.exportToDownload(dto, new AsyncCallback<WorkbookDTO>() {
                @Override
                public void onFailure(Throwable caught) {
                    MaterialToast.fireToast("Error in Export to CLS! " + caught.getMessage());
                }

                @Override
                public void onSuccess(WorkbookDTO result) {
                    String url = GWT.getModuleBaseURL() + "downloadToCLSService?filename=" + textBox1.getText();
                    Window.open(url, "Download CLS file", "status=0,toolbar=0,menubar=0,location=0");
                }
            });*/
            String url = GWT.getModuleBaseURL() + "downloadToCLSService?filename=" + textBox1.getText() /*+ ".cls"*/;
            Window.open(url, "Download CLS file", "status=0,toolbar=0,menubar=0,location=0,target=_blank");

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
