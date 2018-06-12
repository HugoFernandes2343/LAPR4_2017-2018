/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pt.isep.nsheets.client.lapr4.red.s2.s1161109.application.register;

import com.google.gwt.core.client.GWT;
import com.google.gwt.event.dom.client.ClickEvent;
import com.google.gwt.event.dom.client.ClickHandler;
import com.google.gwt.user.client.rpc.AsyncCallback;
import com.google.inject.Inject;
import com.google.web.bindery.event.shared.EventBus;
import com.gwtplatform.mvp.client.Presenter;
import com.gwtplatform.mvp.client.View;
import com.gwtplatform.mvp.client.annotations.NameToken;
import com.gwtplatform.mvp.client.annotations.NoGatekeeper;
import com.gwtplatform.mvp.client.annotations.ProxyStandard;
import com.gwtplatform.mvp.client.proxy.PlaceManager;
import com.gwtplatform.mvp.client.proxy.ProxyPlace;
import gwt.material.design.addins.client.fileuploader.MaterialFileUploader;
import gwt.material.design.addins.client.fileuploader.base.UploadFile;
import gwt.material.design.addins.client.fileuploader.events.ErrorEvent;
import gwt.material.design.addins.client.fileuploader.events.SuccessEvent;
import gwt.material.design.addins.client.fileuploader.events.TotalUploadProgressEvent;
import gwt.material.design.client.events.DragOverEvent;
import gwt.material.design.client.ui.MaterialImage;
import gwt.material.design.client.ui.MaterialLabel;
import gwt.material.design.client.ui.MaterialProgress;
import gwt.material.design.client.ui.MaterialTextBox;
import gwt.material.design.client.ui.MaterialToast;
import gwt.material.design.client.ui.animate.Transition;
import pt.isep.nsheets.client.application.ApplicationPresenter;
import pt.isep.nsheets.client.application.CurrentUser;
import pt.isep.nsheets.client.place.NameTokens;
import pt.isep.nsheets.shared.services.EmailDTO;
import pt.isep.nsheets.shared.services.NameDTO;
import pt.isep.nsheets.shared.services.NicknameDTO;
import pt.isep.nsheets.shared.services.PasswordDTO;
import pt.isep.nsheets.shared.services.UserDTO;
import pt.isep.nsheets.shared.services.UsersService;
import pt.isep.nsheets.shared.services.UsersServiceAsync;

/**
 *
 * @author David Santiago <1161109@isep.ipp.pt>
 */
public class RegisterPresenter extends Presenter<RegisterPresenter.MyView, RegisterPresenter.MyProxy> {

    interface MyView extends View {

        void addClickHandler(ClickHandler ch);

        MaterialTextBox getTextEmail();

        MaterialTextBox getTextPassword();

        MaterialTextBox getTextFirst();

        MaterialTextBox getTextLast();

        MaterialTextBox getTextUserName();


        MaterialFileUploader getCardUploader();

        MaterialImage getImgPreview();

        MaterialProgress getProgress();

        MaterialLabel getLblName();

        MaterialLabel getLblSize();
        

    }

    @NameToken(NameTokens.register)
    @ProxyStandard
    @NoGatekeeper
    interface MyProxy extends ProxyPlace<RegisterPresenter> {

    }

    @Inject
    RegisterPresenter(EventBus eventBus, MyView view, MyProxy proxy, PlaceManager placeManager, CurrentUser currentUser) {
        super(eventBus, view, proxy, ApplicationPresenter.SLOT_CONTENT);

        getView().addClickHandler((ClickEvent event) -> {

            EmailDTO e = new EmailDTO(getView().getTextEmail().getText());
            PasswordDTO p = new PasswordDTO(getView().getTextPassword().getText());
            NicknameDTO n = new NicknameDTO(getView().getTextUserName().getText());
            NameDTO nome = new NameDTO(getView().getTextFirst().getText(), getView().getTextLast().getText());
            UserDTO u = new UserDTO(e, p, nome, n);

            UsersServiceAsync usersSvc = GWT.create(UsersService.class);

            AsyncCallback<UserDTO> callback = new AsyncCallback<UserDTO>() {
                @Override
                public void onFailure(Throwable caught) {
                    MaterialToast.fireToast("ERROR REGISTERING");

                }

                @Override
                public void onSuccess(UserDTO result) {
                    MaterialToast.fireToast("You Have Registered With Sucess");

                }
            };

            usersSvc.saveUser(u, callback);
        });

        getView().getCardUploader().addTotalUploadProgressHandler(new TotalUploadProgressEvent.TotalUploadProgressHandler() {
            @Override

            public void onTotalUploadProgress(TotalUploadProgressEvent event) {
                
                getView().getProgress().setPercent(event.getProgress());
                 
            }
        });

        getView().getCardUploader().addSuccessHandler(new SuccessEvent.SuccessHandler<UploadFile>() {
            @Override

            public void onSuccess(SuccessEvent<UploadFile> event) {
                
                getView().getLblName().setText(event.getTarget().getName());
                
                getView().getLblSize().setText(event.getTarget().getType());
                MaterialToast.fireToast("Photo Uploaded With sucess");
                getView().getImgPreview().setUrl(GWT.getHostPageBaseURL() + "uploadedFiles/" + event.getTarget().getName());     
            }
            
        });
        
        
        getView().getCardUploader().addErrorHandler(new ErrorEvent.ErrorHandler<UploadFile>() {


            @Override
            public void onError(ErrorEvent<UploadFile> event) {
                MaterialToast.fireToast("ERROR");
                getView().getImgPreview().setUrl(GWT.getHostPageBaseURL() + "uploadedFiles/" + event.getTarget().getName()); 
            }
            
        });
        
        
        
        
        

         getView().getCardUploader().addDragOverHandler(new DragOverEvent.DragOverHandler() {
            @Override

            public void onDragOver(DragOverEvent event) {
                
               //getView().MaterialAnimator.animate(Transition.RUBBERBAND, getView().getCardUploader(), 0);
                
            }
        });

    }

    @Override
    protected void onReveal() {
        super.onReveal();
    }

}
