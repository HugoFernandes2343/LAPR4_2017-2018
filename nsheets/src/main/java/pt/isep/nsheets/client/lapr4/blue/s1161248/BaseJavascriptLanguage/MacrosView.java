package pt.isep.nsheets.client.lapr4.blue.s1161248.BaseJavascriptLanguage;

import com.google.gwt.core.client.GWT;
import com.google.gwt.uibinder.client.UiBinder;
import com.google.gwt.uibinder.client.UiField;
import com.google.gwt.user.client.ui.Composite;
import com.google.gwt.user.client.ui.Widget;
import gwt.material.design.addins.client.combobox.MaterialComboBox;
import gwt.material.design.addins.client.popupmenu.MaterialPopupMenu;
import gwt.material.design.addins.client.window.MaterialWindow;
import gwt.material.design.client.constants.TextAlign;
import gwt.material.design.client.ui.*;
import pt.isep.nsheets.shared.lapr4.blue.s1.lang.s1150371.macros.Macro;


public class MacrosView extends Composite {


    @UiField
    MaterialComboBox macroType = new MaterialComboBox();
    @UiField
    MaterialTextBox macroName = new MaterialTextBox();
    @UiField
    MaterialTextArea macroCode = new MaterialTextArea();
    @UiField
    MaterialButton cancelButton = new MaterialButton("Cancel");
    @UiField
    MaterialButton runButton = new MaterialButton("Run");
    
    Macro macro;    

    private static MacrosUiBinder uiBinder = GWT.create(MacrosUiBinder.class);

    interface MacrosUiBinder extends UiBinder<Widget,MacrosView> {
    }

    public MacrosView(){


        initWidget(uiBinder.createAndBindUi(this));
        MaterialWindow window = new MaterialWindow();
        window.setPadding(32);
        window.setHeight("600px");
        window.setTextAlign(TextAlign.LEFT);
        window.setTitle("Create a Macro");
        MaterialWindow.setOverlay(true);
        MaterialPanel p0= new MaterialPanel();
        MaterialLabel label = new MaterialLabel("Type of Macro");
        this.macroType.addItem("Simple macro");
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
        p3.add(this.cancelButton);  
        window.add(p3);        
        window.open(); 
                     
        cancelButton.addClickHandler(clickEvent -> {
            window.close();
        } );
        
        runButton.addClickHandler(clickEvent -> {
            if((macroType.getSelectedValue().toString()).compareTo("[Simple macro]") == 0) {
                macro = new Macro(macroName.getText(), macroCode.getText(), macroType.getSelectedValue().toString());
                MaterialToast.fireToast("Macro name: " + macro.getName());
                MaterialToast.fireToast("input: " + macro.getInput());
                MaterialToast.fireToast("Result: " + macro.runMacro());
            } else {
                MaterialToast.fireToast("Error, not implemented"); 
            }
        });
    }


    public MaterialComboBox getMacroType() { return this.macroType; }

    public MaterialTextBox getMacroName() { return this.macroName;  }

    public MaterialTextArea getMacroCode() { return this.macroCode; }

    public MaterialButton getCancelButton() { return this.cancelButton; }

    public MaterialButton getRunButton() { return this.runButton; }

}
