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

import pt.isep.nsheets.client.application.about.AboutModule;
import pt.isep.nsheets.client.application.home.HomeModule;
import pt.isep.nsheets.client.lapr4.green.s1.s1160570.application.login.LoginModule;
import pt.isep.nsheets.client.application.menu.MenuModule;
import pt.isep.nsheets.client.lapr4.green.s1.s1150575.application.settings.SettingsModule;
import pt.isep.nsheets.client.application.workbook.WorkbookModule;

public class ApplicationModule extends AbstractPresenterModule {

    @Override
    protected void configure() {

        install(new HomeModule());
        install(new MenuModule());
        install(new AboutModule());
        install(new WorkbookModule());
        install(new SettingsModule());
        install(new LoginModule());

        bindPresenter(ApplicationPresenter.class, ApplicationPresenter.MyView.class, ApplicationView.class, ApplicationPresenter.MyProxy.class);
    }
}
