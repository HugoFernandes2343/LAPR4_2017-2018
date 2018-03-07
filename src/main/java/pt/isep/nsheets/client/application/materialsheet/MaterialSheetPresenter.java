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
package pt.isep.nsheets.client.application.materialsheet;

import pt.isep.nsheets.client.application.ApplicationPresenter;
import pt.isep.nsheets.client.place.NameTokens;
import pt.isep.nsheets.shared.core.Address;
import pt.isep.nsheets.shared.core.Cell;
import pt.isep.nsheets.shared.core.IllegalValueTypeException;
import pt.isep.nsheets.shared.core.Spreadsheet;
import pt.isep.nsheets.shared.core.Workbook;
import pt.isep.nsheets.shared.core.formula.Expression;
import pt.isep.nsheets.shared.core.formula.Formula;
import pt.isep.nsheets.shared.core.formula.compiler.FormulaCompilationException;
import pt.isep.nsheets.shared.core.formula.compiler.FormulaCompiler;

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
import com.gwtplatform.mvp.shared.proxy.PlaceRequest;

import gwt.material.design.client.ui.MaterialButton;
import gwt.material.design.client.ui.MaterialLabel;
import gwt.material.design.client.ui.MaterialTextBox;

public class MaterialSheetPresenter extends Presenter<MaterialSheetPresenter.MyView, MaterialSheetPresenter.MyProxy> {

	interface MyView extends View {
		// public Label getSecondLabel();
		// public Label getFirstLabel();
		public MaterialTextBox getFirstBox();

		public MaterialButton getFirstButton();
		
		public MaterialLabel getResultLabel();
	}

	@ProxyStandard
	@NameToken(NameTokens.materialsheet)
	interface MyProxy extends ProxyPlace<MaterialSheetPresenter> {
	}

	@Inject
	MaterialSheetPresenter(EventBus eventBus, MyView view, MyProxy proxy, PlaceManager placeManager) {
		// super(eventBus, view, proxy, ApplicationPresenter.SLOT_MAIN);
		super(eventBus, view, proxy, ApplicationPresenter.SLOT_CONTENT);

		this.placeManager = placeManager;
	}

	// @Override
	// public void prepareFromRequest(PlaceRequest request) {
	// super.prepareFromRequest(request);
	//
	// name=request.getParameter("name", "Default value");
	// }

	// @Inject
	PlaceManager placeManager;

	@Override
	protected void onReset() {
		super.onReset();

		getView().getFirstBox().setText("=2+4-1");

		getView().getFirstButton().addClickHandler(new ClickHandler() {

			@Override
			public void onClick(ClickEvent event) {
				// Let's test formulas...
				String source=getView().getFirstBox().getText();
				
				// Fetches a cell
				Workbook workbook = new Workbook(1);
				Spreadsheet sheet = workbook.getSpreadsheet(0);
				Cell cell = sheet.getCell(new Address(0, 0));

				Formula formula;
				String result="";
				try {
					formula = FormulaCompiler.getInstance().compile(cell, source);
					
					Expression expression = formula.getExpression();
					result="Formula: " + expression + " = " + expression.evaluate();
					
				} catch (FormulaCompilationException e) {
					// TODO Auto-generated catch block
					//e.printStackTrace();
					result=e.getMessage();
				} catch (IllegalValueTypeException e) {
					// TODO Auto-generated catch block
					// e.printStackTrace();
					result=e.getMessage();
				} finally {
					getView().getResultLabel().setText(result);
				}

				// Example on how to jump to another place
//				PlaceRequest request = new PlaceRequest.Builder().nameToken(NameTokens.about)
//						.with("name", result).build();
//
//				placeManager.revealPlace(request);
			}

		});
	}
}
