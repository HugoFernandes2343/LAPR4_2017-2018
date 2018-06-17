package pt.isep.nsheets.client.lapr4.blue.s1161248.BaseJavascriptLanguage;

import com.google.gwt.core.client.GWT;
import com.google.gwt.uibinder.client.UiBinder;
import com.google.gwt.uibinder.client.UiField;
import com.google.gwt.user.client.ui.Composite;
import com.google.gwt.user.client.ui.Widget;
import gwt.material.design.addins.client.combobox.MaterialComboBox;
import gwt.material.design.addins.client.popupmenu.MaterialPopupMenu;
import gwt.material.design.addins.client.window.MaterialWindow;
import gwt.material.design.client.constants.Color;
import gwt.material.design.client.constants.IconPosition;
import gwt.material.design.client.constants.IconType;
import gwt.material.design.client.constants.TextAlign;
import gwt.material.design.client.ui.*;
import pt.isep.nsheets.client.application.CurrentUser;
import pt.isep.nsheets.client.application.workbook.CurrentWorkbook;
import pt.isep.nsheets.shared.lapr4.blue.s1.lang.s1150371.macros.Macro;

import java.util.ArrayList;
import java.util.List;


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
    @UiField
    MaterialPanel macroCards;

    Macro macro;

    private static MacrosUiBinder uiBinder = GWT.create(MacrosUiBinder.class);

    interface MacrosUiBinder extends UiBinder<Widget, MacrosView> {
    }

    public MacrosView() {


        initWidget(uiBinder.createAndBindUi(this));

        MaterialWindow window = new MaterialWindow();
        window.setPadding(32);
        window.setHeight("600px");
        window.setTextAlign(TextAlign.LEFT);
        window.setTitle("Create a Macro");
        MaterialWindow.setOverlay(true);
        MaterialPanel p0 = new MaterialPanel();
        MaterialLabel label = new MaterialLabel("Type of Macro");
        this.macroType.addItem("Simple macro");
        this.macroType.addItem("JavaScript");
        p0.add(label);
        p0.add(this.macroType);
        window.add(p0);
        MaterialPanel p1 = new MaterialPanel();
        MaterialLabel macroNameL = new MaterialLabel("Insert Macro's name");
        p1.add(macroNameL);
        p1.add(this.macroName);
        window.add(p1);
        MaterialPanel p2 = new MaterialPanel();
        MaterialLabel label2 = new MaterialLabel("Insert Macro");
        p2.add(label2);
        p2.add(this.macroCode);
        window.add(p2);
        MaterialPanel p3 = new MaterialPanel();
        p3.add(this.runButton);
        p3.add(this.cancelButton);
        window.add(p3);

        setContents(CurrentWorkbook.getCurrentWorkbook().macros());
        window.add(macroCards);

        window.open();

        cancelButton.addClickHandler(clickEvent -> {
            window.close();
        });

        runButton.addClickHandler(clickEvent -> {
            if ((macroType.getSelectedValue().toString()).compareTo("[Simple macro]") == 0) {
                if(checkName(macroName.getText())) {
                    macro = new Macro(macroName.getText(), macroCode.getText(), macroType.getSelectedValue().toString());
                    MaterialToast.fireToast("Macro name: " + macro.getName());
                    MaterialToast.fireToast("input: " + macro.getInput());
                    MaterialToast.fireToast("Result: " + macro.runMacro());
                    CurrentWorkbook.getCurrentWorkbook().addMacro(macro);
                    setContents(CurrentWorkbook.getCurrentWorkbook().macros());
                } else {
                    MaterialToast.fireToast("Name of macro already in use!");
                }
            } else {
                MaterialToast.fireToast("Error, not implemented");
            }
        });
    }

    public boolean checkName(String nm){
        for(Macro m : CurrentWorkbook.getCurrentWorkbook().macros()){
            if(m.getName().equals(nm)){
                return false;
            }
        }
        return true;
    }


    public void setContents(List<Macro> contents) {
        int colCount = 1;

        MaterialRow row = null;

        macroCards.clear();

        for (Macro m : contents) {


            MaterialCard card = createCard(m);

            if (colCount == 1) {
                row = new MaterialRow();
                macroCards.add(row);
                ++colCount;
                if (colCount >= 4) {
                    colCount = 1;
                }
            }

            MaterialColumn col = new MaterialColumn();
            col.setGrid("l4");
            row.add(col);

            col.add(card);
        }
    }

    public MaterialCard createCard(Macro m) {
        MaterialCard card = new MaterialCard();
        MaterialCardContent cardContent = new MaterialCardContent();
        MaterialCardTitle cardTitle = new MaterialCardTitle();
        MaterialLabel label = new MaterialLabel();
        MaterialCardAction cardAction = new MaterialCardAction();

        MaterialLink openLink = new MaterialLink();
        MaterialLink deleteLink = new MaterialLink();

        card.setBackgroundColor(Color.BLUE_DARKEN_1);
        cardTitle.setIconType(IconType.STAR);

        cardContent.setTextColor(Color.WHITE);
        cardTitle.setText(m.getName());
        cardTitle.setIconPosition(IconPosition.RIGHT);
        label.setText(m.getInput());

        openLink.setText("Use");
        openLink.setIconType(IconType.INPUT);
        openLink.setIconColor(Color.INDIGO);
        openLink.setTextColor(Color.WHITE);
        openLink.addClickHandler(event -> {
//            String text = m.getInput();
//            String temp[] = text.split("=");
//            text = temp[temp.length-1].replace(" ", "");
            macroCode.setValue(macroCode.getValue() + "@" + m.getName());
            macroCode.setFocus(true);
        });


        deleteLink.setText("Delete");
        deleteLink.setIconType(IconType.DELETE);
        deleteLink.setIconColor(Color.GREY);
        deleteLink.setTextColor(Color.WHITE);
        deleteLink.addClickHandler(event -> {
            deleteMacro(m);
            card.setVisible(false);
        });

        cardContent.add(cardTitle);
        cardContent.add(label);

        cardAction.add(openLink);
        cardAction.add(deleteLink);

        card.add(cardContent);
        card.add(cardAction);

        return card;
    }

    public void deleteMacro(Macro m) {
//        List<Macro> list = CurrentWorkbook.getCurrentWorkbook().macros();
//        for(Macro temp : list){
//            if(m.equals(temp)){
//                list.remove(m);
//            }
//        }
        CurrentWorkbook.getCurrentWorkbook().macros().remove(m);
    }


    public MaterialComboBox getMacroType() {
        return this.macroType;
    }

    public MaterialTextBox getMacroName() {
        return this.macroName;
    }

    public MaterialTextArea getMacroCode() {
        return this.macroCode;
    }

    public MaterialButton getCancelButton() {
        return this.cancelButton;
    }

    public MaterialButton getRunButton() {
        return this.runButton;
    }

}
