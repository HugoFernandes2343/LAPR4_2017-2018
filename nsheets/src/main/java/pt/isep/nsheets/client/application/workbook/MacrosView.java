package pt.isep.nsheets.client.application.workbook;

import com.google.gwt.uibinder.client.UiBinder;
import com.google.gwt.uibinder.client.UiField;
import com.google.gwt.user.client.ui.Widget;
import com.gwtplatform.mvp.client.ViewImpl;
import gwt.material.design.addins.client.combobox.MaterialComboBox;
import gwt.material.design.addins.client.window.MaterialWindow;
import gwt.material.design.client.constants.TextAlign;
import gwt.material.design.client.ui.*;

import javax.inject.Inject;

public class MacrosView extends ViewImpl {

    @UiField
    private final MaterialComboBox macroType = new MaterialComboBox();
    @UiField
    private final MaterialTextBox macroName = new MaterialTextBox();
    @UiField
    private final MaterialTextArea macroCode = new MaterialTextArea();
    @UiField
    private final MaterialButton saveButton = new MaterialButton("Save");
    @UiField
    private final MaterialButton cancelButton = new MaterialButton("Cancel");
    @UiField
    private final MaterialButton runButton = new MaterialButton("Run");


    public MacrosView(){

        MaterialWindow window = new MaterialWindow();
        window.setPadding(32);
        window.setHeight("600px");
        window.setTextAlign(TextAlign.LEFT);
        window.setTitle("Create a Macro");
        MaterialWindow.setOverlay(true);
        MaterialPanel p0= new MaterialPanel();
        MaterialLabel label = new MaterialLabel("Type of Macro");
        this.macroType.addItem("JavaScript");
        p0.add(label);
        p0.add(this.macroType);
        window.add(p0);
        MaterialPanel p1 = new MaterialPanel();
        MaterialLabel macroNameL= new MaterialLabel("Insert Macro's name");
        p1.add(macroNameL);
        p1.add(this.macroName);
        window.add(p1);
        MaterialPanel p2= new MaterialPanel();
        MaterialLabel label2 = new MaterialLabel("Insert Macro");
        p2.add(label2);
        p2.add(this.macroCode);
        window.add(p2);
        MaterialPanel p3= new MaterialPanel();
        p3.add(this.runButton);
        p3.add(this.saveButton);
        p3.add(this.cancelButton);
        window.add(p3);
        window.open();
    }


    public MaterialComboBox getMacroType() { return this.macroType; }

    public MaterialTextBox getMacroName() { return this.macroName;  }

    public MaterialTextArea getMacroCode() { return this.macroCode; }

    public MaterialButton getSaveButton() { return this.saveButton; }

    public MaterialButton getCancelButton() { return this.cancelButton; }

    public MaterialButton getRunButton() { return this.runButton; }

}
