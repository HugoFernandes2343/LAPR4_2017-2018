/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pt.isep.nsheets.client.lapr4.red.s2.s1161109.application.register;

import com.google.gwt.core.client.GWT;
import com.google.gwt.event.dom.client.ClickEvent;
import com.google.gwt.event.dom.client.ClickHandler;
import com.google.gwt.uibinder.client.UiBinder;
import com.google.gwt.uibinder.client.UiField;
import com.google.gwt.user.client.ui.Widget;
import com.gwtplatform.mvp.client.ViewImpl;
import gwt.material.design.addins.client.fileuploader.MaterialFileUploader;
import gwt.material.design.addins.client.fileuploader.base.UploadFile;
import gwt.material.design.addins.client.fileuploader.events.AddedFileEvent;
import gwt.material.design.client.ui.MaterialButton;
import gwt.material.design.client.ui.MaterialImage;
import gwt.material.design.client.ui.MaterialLabel;
import gwt.material.design.client.ui.MaterialProgress;
import gwt.material.design.client.ui.MaterialTextBox;
import gwt.material.design.client.ui.MaterialToast;
import javax.inject.Inject;
import pt.isep.nsheets.client.application.ApplicationPresenter;
import pt.isep.nsheets.client.application.ApplicationView;

/**
 *
 * @author David Santiago <1161109@isep.ipp.pt>
 */
public class RegisterView extends ViewImpl implements RegisterPresenter.MyView {



    interface Binder extends UiBinder<Widget, RegisterView> {
    }

//    @UiField
//    MaterialFileUploader uploader;

    @UiField
    MaterialImage image;

    @UiField
    MaterialTextBox textEmail, textUserName, textFirst, textLast, textPassword;

    @UiField
    MaterialButton btnRegister;

   
    
    
    
    
    
    @UiField MaterialFileUploader cardUploader;
    @UiField MaterialImage imgPreview;
    @UiField MaterialProgress progress;
    @UiField MaterialLabel lblName, lblSize;

    
    
    
    

    @Inject
    RegisterView(RegisterView.Binder uiBinder) {
        initWidget(uiBinder.createAndBindUi(this));

        

        

    }

    @Override
    public void addClickHandler(ClickHandler ch) {
        btnRegister.addClickHandler(ch);
    }

    

    @Override
    public MaterialTextBox getTextEmail() {
        return textEmail;
    }
     @Override
    public MaterialTextBox getTextUserName() {
        return textUserName;
    }

    @Override
    public MaterialTextBox getTextFirst() {
        return textFirst;
    }

    @Override
    public MaterialTextBox getTextLast() {
        return textLast;
    }
    
        @Override
    public MaterialTextBox getTextPassword() {
        return textPassword;
    }
    
    
     public MaterialImage getImage() {
        return image;
    }


    public MaterialFileUploader getCardUploader() {
        return cardUploader;
    }

    public MaterialImage getImgPreview() {
        return imgPreview;
    }

    public MaterialProgress getProgress() {
        return progress;
    }

    public MaterialLabel getLblName() {
        return lblName;
    }

    public MaterialLabel getLblSize() {
        return lblSize;
    }
    
    
    
    

}
