/*
 * #%L
 * GwtMaterial
 * %%
 * Copyright (C) 2015 - 2018 GwtMaterialDesign
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
package pt.isep.nsheets.client.application;

import com.gwtplatform.mvp.client.gin.AbstractPresenterModule;

import pt.isep.nsheets.client.application.Contacts.ContactsModule;
import pt.isep.nsheets.client.application.Requests.RequestsModule;
import pt.isep.nsheets.client.lapr4.blue.s2.s1150585.Tasks.TasksModule;
import pt.isep.nsheets.client.application.about.AboutModule;
import pt.isep.nsheets.client.lapr4.blue.s3.s1161248.PrivateChat.PrivateChatModule;
import pt.isep.nsheets.client.lapr4.green.s2.s1160570.application.exchange.ExchangeModule;
import pt.isep.nsheets.client.application.home.HomeModule;
import pt.isep.nsheets.client.lapr4.blue.s2.s1161248.Agenda.AgendaModule;
import pt.isep.nsheets.client.lapr4.green.s1.s1160570.application.login.LoginModule;
import pt.isep.nsheets.client.application.menu.MenuModule;
import pt.isep.nsheets.client.lapr4.green.s1.s1150575.application.settings.SettingsModule;
import pt.isep.nsheets.client.application.workbook.WorkbookModule;
import pt.isep.nsheets.client.lapr4.green.s3.s1151136.application.extension.ExtensionModule;
import pt.isep.nsheets.client.lapr4.red.s2.s1161109.application.register.RegisterModule;
import pt.isep.nsheets.client.lapr4.red.s2.s1161110.application.xmlupload.XmlUploadModule;
import pt.isep.nsheets.client.lapr4.red.s2.s1161569.ChatModule;
import pt.isep.nsheets.client.lpar4.green.s3.s1160570.notes.NoteModule;

public class ApplicationModule extends AbstractPresenterModule {

    @Override
    protected void configure() {

        install(new HomeModule());
        install(new MenuModule());
        install(new ContactsModule());
        install(new TasksModule());
        install(new RequestsModule());
        install(new AboutModule());
        install(new AgendaModule());
        install(new WorkbookModule());
        install(new SettingsModule());
        install(new LoginModule());
        install(new XmlUploadModule());
        install(new RegisterModule());
        install(new ChatModule());
        install(new ExchangeModule());
        install(new PrivateChatModule());
        install(new ExtensionModule());
        install(new NoteModule());

        bindPresenter(ApplicationPresenter.class, ApplicationPresenter.MyView.class, ApplicationView.class, ApplicationPresenter.MyProxy.class);
    }
}
