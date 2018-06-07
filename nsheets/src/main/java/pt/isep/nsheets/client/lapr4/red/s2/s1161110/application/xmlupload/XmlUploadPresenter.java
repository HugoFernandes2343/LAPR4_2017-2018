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


import com.google.inject.Inject;
import com.google.web.bindery.event.shared.EventBus;
import com.gwtplatform.mvp.client.Presenter;
import com.gwtplatform.mvp.client.View;
import com.gwtplatform.mvp.client.annotations.NameToken;
import com.gwtplatform.mvp.client.annotations.NoGatekeeper;
import com.gwtplatform.mvp.client.annotations.ProxyStandard;
import com.gwtplatform.mvp.client.proxy.ProxyPlace;
import pt.isep.nsheets.client.place.NameTokens;
import pt.isep.nsheets.client.event.SetPageTitleEvent;
import pt.isep.nsheets.client.application.ApplicationPresenter;

public class XmlUploadPresenter extends Presenter<XmlUploadPresenter.MyView, XmlUploadPresenter.MyProxy> {
    interface MyView extends View {
    }

    @NameToken(NameTokens.xmlupload)
    @ProxyStandard
    @NoGatekeeper
    interface MyProxy extends ProxyPlace<XmlUploadPresenter> {
    }

    @Inject
    XmlUploadPresenter(EventBus eventBus, MyView view, MyProxy proxy) {
        super(eventBus, view, proxy, ApplicationPresenter.SLOT_CONTENT);

    }

    @Override
    protected void onReveal() {
        super.onReveal();
        SetPageTitleEvent.fire("Xml Spreadsheet Import", "Import your spreadsheets to NSheets", "", "", this);
    }

}
