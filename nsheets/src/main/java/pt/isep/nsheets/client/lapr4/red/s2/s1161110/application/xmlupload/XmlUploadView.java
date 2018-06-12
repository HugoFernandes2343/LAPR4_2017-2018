package pt.isep.nsheets.client.lapr4.red.s2.s1161110.application.xmlupload;
/*
 * #%L
 * GwtMaterial
 * %%
 * Copyright (C) 2015 - 2016 GwtMaterialDesign
 * %%
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *      http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 * #L%
 */


import com.google.gwt.core.client.GWT;
import com.google.gwt.event.dom.client.ClickEvent;
import com.google.gwt.event.logical.shared.ValueChangeEvent;
import com.google.gwt.uibinder.client.UiBinder;
import com.google.gwt.uibinder.client.UiField;
import com.google.gwt.uibinder.client.UiHandler;
import com.google.gwt.user.client.rpc.AsyncCallback;
import com.google.gwt.user.client.ui.Widget;
import com.gwtplatform.mvp.client.ViewImpl;
import gwt.material.design.addins.client.fileuploader.MaterialFileUploader;
import gwt.material.design.addins.client.fileuploader.base.UploadFile;
import gwt.material.design.addins.client.fileuploader.events.*;
import gwt.material.design.client.ui.MaterialToast;
import pt.isep.nsheets.client.application.workbook.CurrentWorkbook;
import pt.isep.nsheets.shared.core.Workbook;
import pt.isep.nsheets.shared.services.UploadService;
import pt.isep.nsheets.shared.services.UploadServiceAsync;

import javax.inject.Inject;


public class XmlUploadView extends ViewImpl implements XmlUploadPresenter.MyView {
    interface Binder extends UiBinder<Widget, XmlUploadView> {
    }

    @UiField
    MaterialFileUploader uploader;

    @Inject
    XmlUploadView(Binder uiBinder) {
        initWidget(uiBinder.createAndBindUi(this));

        uploader.addAddedFileHandler(new AddedFileEvent.AddedFileHandler<UploadFile>() {
            @Override
            public void onAddedFile(AddedFileEvent<UploadFile> event) {
                MaterialToast.fireToast("Event : Added File (" + event.getTarget().getName() + ")");
            }
        });

        uploader.addRemovedFileHandler(new RemovedFileEvent.RemovedFileHandler<UploadFile>() {
            @Override
            public void onRemovedFile(RemovedFileEvent<UploadFile> event) {
                MaterialToast.fireToast("Event : Removed File (" + event.getTarget().getName() + ")");
            }
        });

        uploader.addErrorHandler(new ErrorEvent.ErrorHandler<UploadFile>() {
            @Override
            public void onError(ErrorEvent<UploadFile> event) {
                MaterialToast.fireToast("Event : Error (" + event.getTarget().getName() + ")");
                MaterialToast.fireToast("Response Code : (" + event.getResponse().getCode() + ") - " + event.getResponse().getMessage());
            }
        });

        uploader.addSendingHandler(new SendingEvent.SendingHandler<UploadFile>() {
            @Override
            public void onSending(SendingEvent<UploadFile> event) {
                MaterialToast.fireToast("Event : Sending (" + event.getTarget().getName() + ")");
            }
        });

        uploader.addSuccessHandler(new SuccessEvent.SuccessHandler<UploadFile>() {
            @Override
            public void onSuccess(SuccessEvent<UploadFile> event) {
                MaterialToast.fireToast("Event : Success (" + event.getTarget().getName() + ")");
                UploadServiceAsync uploadASync = GWT.create(UploadService.class);
                Workbook wb = new Workbook();
                uploadASync.importToWorkbook(wb, new AsyncCallback<Workbook>() {
                    @Override
                    public void onFailure(Throwable caught) {
                        MaterialToast.fireToast("Error in Import to XML! " + caught.getMessage());
                    }

                    @Override
                    public void onSuccess(Workbook result) {
                        MaterialToast.fireToast("Success in Import to XML! ");
                    }
                });
                CurrentWorkbook.setCurrentWorkbook(wb);
            }
        });

        uploader.addCompleteHandler(new CompleteEvent.CompleteHandler<UploadFile>() {
            @Override
            public void onComplete(CompleteEvent<UploadFile> event) {
                MaterialToast.fireToast("Event : Complete (" + event.getTarget().getName() + ")");
            }
        });

        uploader.addCancelHandler(new CanceledEvent.CanceledHandler<UploadFile>() {
            @Override
            public void onCanceled(CanceledEvent<UploadFile> event) {
                MaterialToast.fireToast("Event : Cancel (" + event.getTarget().getName() + ")");
            }
        });

        uploader.addMaxFilesExceededHandler(new MaxFilesExceededEvent.MaxFilesExceededHandler<UploadFile>() {
            @Override
            public void onMaxFilesExceeded(MaxFilesExceededEvent<UploadFile> event) {
                MaterialToast.fireToast("Event : Max Files Exceeded (" + event.getTarget().getName() + ")");
            }
        });

        uploader.addMaxFilesReachHandler(new MaxFilesReachedEvent.MaxFilesReachedHandler<UploadFile>() {
            @Override
            public void onMaxFilesReached(MaxFilesReachedEvent<UploadFile> event) {
                MaterialToast.fireToast("Event : Max Files Reached (" + event.getTarget().getName() + ")");
            }
        });
    }

}