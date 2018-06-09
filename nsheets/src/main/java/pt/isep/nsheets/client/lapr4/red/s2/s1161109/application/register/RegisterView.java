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

    @UiField
    MaterialFileUploader uploader;

    @UiField
    MaterialImage image;

    @UiField
    MaterialTextBox textEmail, textUserName, textFirst, textLast, textPassword;

    @UiField
    MaterialButton btnRegister;

    @Inject
    RegisterView(RegisterView.Binder uiBinder) {
        initWidget(uiBinder.createAndBindUi(this));

        uploader.addAddedFileHandler(new AddedFileEvent.AddedFileHandler<UploadFile>() {
            @Override
            public void onAddedFile(AddedFileEvent<UploadFile> event) {
                MaterialToast.fireToast("Event : Added File (" + event.getTarget().getName() + ")");
                MaterialToast.fireToast(GWT.getHostPageBaseURL());
                image.setUrl(GWT.getHostPageBaseURL() + "uploadServlet/" + event.getTarget().getName());
            }
        });

        

    }

    @Override
    public void addClickHandler(ClickHandler ch) {
        btnRegister.addClickHandler(ch);
    }

    public MaterialFileUploader getUploader() {
        return uploader;
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

}
