package pt.isep.nsheets.client.lapr4.blue.s2.s1140420.basicChartWizard;

import gwt.material.design.client.ui.*;
import com.google.gwt.core.client.GWT;
import com.google.gwt.uibinder.client.UiBinder;
import com.google.gwt.uibinder.client.UiField;
import com.google.gwt.user.client.ui.Composite;
import com.google.gwt.user.client.ui.Widget;
import gwt.material.design.addins.client.window.MaterialWindow;

import pt.isep.nsheets.shared.core.Address;
import pt.isep.nsheets.shared.core.Spreadsheet;

public class BasicChartWizardView extends Composite{

    private final String LINES = "Lines";
    private final String COLUMNS = "Columns";

    @UiField
    MaterialWindow wizardWindowStep1, wizardWindowStep2;

    @UiField
    MaterialTextBox chartName, upperCellInfo, lowerCellInfo;

    @UiField
    MaterialListValueBox<String> linesOrColumnsBox;

    @UiField
    MaterialButton previewChartButton, backToStep1Button;

    @UiField
    MaterialBarChart chart;

    private static BasicChartWizardBinder uiBinder = GWT.create(BasicChartWizardBinder.class);

    interface BasicChartWizardBinder extends UiBinder<Widget, BasicChartWizardView> {
    }

    public BasicChartWizardView(Spreadsheet spreadsheet) {
        initWidget(uiBinder.createAndBindUi(this));

        linesOrColumnsBox.add(LINES);
        linesOrColumnsBox.add(COLUMNS);

        wizardWindowStep1.open();

        previewChartButton.addClickHandler(event -> {
            wizardWindowStep1.close();

            String linesOrColumnsValue = linesOrColumnsBox.getValue();
            String lowerCellString = lowerCellInfo.getText();
            String upperCellString = upperCellInfo.getText();

            Address upperCellAddress = spreadsheet.f

            wizardWindowStep2.open();


        });

        backToStep1Button.addClickHandler(event -> {
            wizardWindowStep2.close();

            wizardWindowStep1.open();


        });
    }


}
