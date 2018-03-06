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

import com.google.inject.Inject;
import com.google.web.bindery.event.shared.EventBus;
import com.gwtplatform.mvp.client.Presenter;
import com.gwtplatform.mvp.client.View;
import com.gwtplatform.mvp.client.annotations.ProxyStandard;
import com.gwtplatform.mvp.client.presenter.slots.NestedSlot;
import com.gwtplatform.mvp.client.presenter.slots.PermanentSlot;
import com.gwtplatform.mvp.client.proxy.Proxy;

import pt.isep.nsheets.client.application.menu.MenuPresenter;

public class ApplicationPresenter
        extends Presenter<ApplicationPresenter.MyView, ApplicationPresenter.MyProxy> {
	
    interface MyView extends View {
    }

    public static final PermanentSlot<MenuPresenter> SLOT_MENU = new PermanentSlot<>();
    public static final NestedSlot SLOT_CONTENT = new NestedSlot();

    @ProxyStandard
    interface MyProxy extends Proxy<ApplicationPresenter> {
    }

    private MenuPresenter menuPresenter;

    @Inject
    ApplicationPresenter(
            EventBus eventBus,
            MyView view,
            MyProxy proxy, MenuPresenter menuPresenter) {
        super(eventBus, view, proxy, RevealType.Root);
        
        this.menuPresenter = menuPresenter;
            
    }
    
    @Override
    protected void onReset() {
    		super.onReset();
    }
    
    @Override
    protected void onBind() {
        super.onBind();

        setInSlot(SLOT_MENU, menuPresenter);
    }
}
