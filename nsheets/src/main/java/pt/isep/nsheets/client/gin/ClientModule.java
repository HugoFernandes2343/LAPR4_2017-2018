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
package pt.isep.nsheets.client.gin;

import pt.isep.nsheets.client.application.ApplicationModule;
import pt.isep.nsheets.client.place.NameTokens;
import pt.isep.nsheets.client.resources.ResourceLoader;

import com.gwtplatform.dispatch.rpc.client.gin.RpcDispatchAsyncModule;
import com.gwtplatform.mvp.client.annotations.DefaultPlace;
import com.gwtplatform.mvp.client.annotations.ErrorPlace;
import com.gwtplatform.mvp.client.annotations.UnauthorizedPlace;
import com.gwtplatform.mvp.client.gin.AbstractPresenterModule;
import com.gwtplatform.mvp.client.gin.DefaultModule;

public class ClientModule extends AbstractPresenterModule {

    @Override
    protected void configure() {
        install(new DefaultModule.Builder().build());

//        install(new DefaultModule.Builder()
//               // .tokenFormatter(RouteTokenFormatter.class)
//                .defaultPlace(NameTokens.home)
//                .errorPlace(NameTokens.home)
//                .unauthorizedPlace(NameTokens.home)
//                .build());
        install(new RpcDispatchAsyncModule.Builder().build());
        install(new ApplicationModule());

        bind(ResourceLoader.class).asEagerSingleton();

        // DefaultPlaceManager Places
        bindConstant().annotatedWith(DefaultPlace.class).to(NameTokens.login);
        bindConstant().annotatedWith(ErrorPlace.class).to(NameTokens.login);
        bindConstant().annotatedWith(UnauthorizedPlace.class).to(NameTokens.login);
    }
}
