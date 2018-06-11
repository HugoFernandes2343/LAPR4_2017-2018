package pt.isep.nsheets.client.lapr4.blue.s2.s1140420.basicChartWizard;

import gwt.material.design.client.ui.*;
import com.google.gwt.core.client.GWT;
import com.google.gwt.uibinder.client.UiBinder;
import com.google.gwt.uibinder.client.UiField;
import com.google.gwt.user.client.ui.Composite;
import com.google.gwt.user.client.ui.Widget;
import gwt.material.design.addins.client.window.MaterialWindow;

import pt.isep.nsheets.shared.core.Spreadsheet;

public class BasicChartWizardView extends Composite{

    @UiField
    MaterialWindow wizardWindowStep1;

    @UiField
    MaterialWindow wizardWindowStep2;

    @UiField
    MaterialTextBox chartName;

    @UiField
    MaterialTextBox upperCellInfo;

    @UiField
    MaterialTextBox lowerCellInfo;

    @UiField
    MaterialListValueBox<String> linesOrColumnsBox;

    @UiField
    MaterialButton previewChartButton;

    @UiField
    MaterialBarChart chart;

    private static BasicChartWizardBinder uiBinder = GWT.create(BasicChartWizardBinder.class);

    interface BasicChartWizardBinder extends UiBinder<Widget, BasicChartWizardView> {
    }

    public BasicChartWizardView(Spreadsheet spreadsheet) {
        initWidget(uiBinder.createAndBindUi(this));

        linesOrColumnsBox.add("Lines");
        linesOrColumnsBox.add("Columns");

        wizardWindowStep1.open();

        previewChartButton.addClickHandler(event -> {
            wizardWindowStep1.close();

            String linesOrColumnsValue = linesOrColumnsBox.getValue();
            String lowerCell = lowerCellInfo.getText();
            String upperCell = upperCellInfo.getText();

            wizardWindowStep2.open();
        });
    }


}
