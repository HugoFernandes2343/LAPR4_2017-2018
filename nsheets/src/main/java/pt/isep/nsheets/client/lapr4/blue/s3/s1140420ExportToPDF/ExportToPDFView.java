package pt.isep.nsheets.client.lapr4.blue.s3.s1140420ExportToPDF;

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
import gwt.material.design.client.ui.MaterialTextBox;
import gwt.material.design.client.ui.MaterialToast;
import pt.isep.nsheets.shared.core.Workbook;
import pt.isep.nsheets.shared.services.*;

public class ExportToPDFView extends Composite {

    @UiField
    MaterialWindow window;

    @UiField
    MaterialButton btnExport;

    @UiField
    MaterialTextBox textBox1;

    private static ExportToPDFBinder uiBinder = GWT.create(ExportToPDFBinder.class);

    interface ExportToPDFBinder extends UiBinder<Widget, ExportToPDFView> {
    }

    public ExportToPDFView(Workbook workbook) {
        initWidget(uiBinder.createAndBindUi(this));

        //window.setPadding(32);
        //window.setHeight("400px");
        window.setTextAlign(TextAlign.LEFT);
        MaterialWindow.setOverlay(true);
        btnExport.setWaves(WavesType.LIGHT);
        textBox1.setPlaceholder("Name Of The File");

        btnExport.addClickHandler(event -> {

            WorkbookDTO dto = workbook.toDTO();

            DownloadToPDFServiceAsync downAsync = GWT.create(DownloadToPDFService.class);

            downAsync.exportToDownload(dto, new AsyncCallback<WorkbookDTO>() {
                @Override
                public void onFailure(Throwable caught) {
                    MaterialToast.fireToast("Error in Export to PDF! " + caught.getMessage());
                }

                @Override
                public void onSuccess(WorkbookDTO result) {
                    String url = GWT.getModuleBaseURL() + "downloadToPDFService?filename=" + textBox1.getText() + ".pdf";
                    Window.open(url, "Download PDF file", "status=0,toolbar=0,menubar=0,location=0");
                }
            });
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
