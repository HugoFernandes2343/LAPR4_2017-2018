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
package pt.isep.nsheets.client.application.workbook;

import pt.isep.nsheets.client.application.ApplicationPresenter;
import pt.isep.nsheets.client.event.SetPageTitleEvent;
import pt.isep.nsheets.client.place.NameTokens;
import com.google.gwt.event.dom.client.ClickEvent;
import com.google.gwt.event.dom.client.ClickHandler;
import com.google.inject.Inject;
import com.google.web.bindery.event.shared.EventBus;
import com.gwtplatform.mvp.client.Presenter;
import com.gwtplatform.mvp.client.View;
import com.gwtplatform.mvp.client.annotations.NameToken;
import com.gwtplatform.mvp.client.annotations.ProxyStandard;
import com.gwtplatform.mvp.client.proxy.PlaceManager;
import com.gwtplatform.mvp.client.proxy.ProxyPlace;
import gwt.material.design.client.ui.MaterialIcon;
import gwt.material.design.client.ui.MaterialTextBox;

public class WorkbookPresenter extends Presenter<WorkbookPresenter.MyView, WorkbookPresenter.MyProxy> {

	interface MyView extends View {
		public MaterialTextBox getFirstBox();

		public MaterialIcon getFirstButton();
	}

	@ProxyStandard
	@NameToken(NameTokens.workbook)
	interface MyProxy extends ProxyPlace<WorkbookPresenter> {
	}

	@Inject
	WorkbookPresenter(EventBus eventBus, MyView view, MyProxy proxy, PlaceManager placeManager) {
		super(eventBus, view, proxy, ApplicationPresenter.SLOT_CONTENT);

		this.placeManager = placeManager;
	}

	PlaceManager placeManager;

	@Override
	protected void onReset() {
		super.onReset();

		getView().getFirstButton().addClickHandler(new ClickHandler() {

			@Override
			public void onClick(ClickEvent event) {
				// Let's test formulas...
//				String source=getView().getFirstBox().getText();
//				
//				// Fetches a cell
//				Workbook workbook = new Workbook(1);
//				Spreadsheet sheet = workbook.getSpreadsheet(0);
//				Cell cell = sheet.getCell(new Address(0, 0));
//
//				Formula formula;
//				String result="";
//				try {
//					formula = FormulaCompiler.getInstance().compile(cell, source);
//					
//					Expression expression = formula.getExpression();
//					result="Formula: " + expression + " = " + expression.evaluate();
//					
//				} catch (FormulaCompilationException e) {
//					// TODO Auto-generated catch block
//					//e.printStackTrace();
//					result=e.getMessage();
//				} catch (IllegalValueTypeException e) {
//					// TODO Auto-generated catch block
//					// e.printStackTrace();
//					result=e.getMessage();
//				} finally {
//					getView().getResultLabel().setText(result);
//				}

				// Example on how to jump to another place
//				PlaceRequest request = new PlaceRequest.Builder().nameToken(NameTokens.about)
//						.with("name", result).build();
//
//				placeManager.revealPlace(request);
			}

		});
	}
	
    @Override
    protected void onReveal() {
        super.onReveal();

        SetPageTitleEvent.fire("Workbook", "The current Workbook", "", "", this);
    }
}
