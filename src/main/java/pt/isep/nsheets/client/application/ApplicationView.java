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

import javax.inject.Inject;

import com.google.gwt.uibinder.client.UiBinder;
import com.google.gwt.uibinder.client.UiField;
import com.google.gwt.user.client.ui.HTMLPanel;
import com.google.gwt.user.client.ui.Widget;
import com.gwtplatform.mvp.client.ViewImpl;

public class ApplicationView extends ViewImpl implements ApplicationPresenter.MyView {

	// @UiField
	// SimplePanel main;

	@UiField
	HTMLPanel menu;
	@UiField
	HTMLPanel main;

	interface Binder extends UiBinder<Widget, ApplicationView> {
	}

	@Inject
	ApplicationView(Binder uiBinder) {
		initWidget(uiBinder.createAndBindUi(this));

		bindSlot(ApplicationPresenter.SLOT_MENU, menu);
		bindSlot(ApplicationPresenter.SLOT_CONTENT, main);
	}

	// @Override
	// public void setInSlot(Object slot, IsWidget content) {
	// if (slot == ApplicationPresenter.SLOT_CONTENT) {
	// main.setWidget(content);
	// } else {
	// super.setInSlot(slot, content);
	// }
	// }

}
