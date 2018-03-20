package pt.isep.nsheets.client.application.home;

import javax.inject.Inject;

import com.google.gwt.uibinder.client.UiBinder;
import com.google.gwt.uibinder.client.UiField;
import com.google.gwt.user.client.ui.HTMLPanel;
import com.google.gwt.user.client.ui.Widget;
import com.gwtplatform.mvp.client.ViewImpl;

import gwt.material.design.client.constants.Color;
import gwt.material.design.client.constants.IconPosition;
import gwt.material.design.client.constants.IconType;
import gwt.material.design.client.ui.MaterialCard;
import gwt.material.design.client.ui.MaterialCardContent;
import gwt.material.design.client.ui.MaterialCardTitle;
import gwt.material.design.client.ui.MaterialColumn;
import gwt.material.design.client.ui.MaterialLabel;
import gwt.material.design.client.ui.MaterialRow;

class HomeView extends ViewImpl implements HomePresenter.MyView {

	interface Binder extends UiBinder<Widget, HomeView> {
	}
	
	@UiField
	HTMLPanel htmlPanel;

	@Inject
	HomeView(Binder uiBinder) {
		initWidget(uiBinder.createAndBindUi(this));
		
		// Try to programmatically add a row, column and card
		MaterialRow row=new MaterialRow();
		
	    MaterialColumn col=new MaterialColumn();
	    col.setGrid("l4");
	    row.add(col);
	    
	    MaterialCard card=new MaterialCard();
	    card.setBackgroundColor(Color.BLUE_DARKEN_1);
	    
        MaterialCardContent cardContent=new MaterialCardContent();
        cardContent.setTextColor(Color.WHITE);
        
        MaterialCardTitle cardTitle=new MaterialCardTitle();
        cardTitle.setTitle("Sample");
        cardTitle.setIconType(IconType.POLYMER);
        cardTitle.setIconPosition(IconPosition.RIGHT);

        MaterialLabel label=new MaterialLabel();
        label.setText("ola");

        card.add(cardContent);
        
        cardContent.add(cardTitle);
        cardContent.add(label);
	    
	    col.add(card);      
	    
		htmlPanel.add(row);
	}
}