package pt.isep.nsheets.client.application.home;

import java.util.ArrayList;

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
import pt.isep.nsheets.shared.services.WorkbookDescriptionDTO;

class HomeView extends ViewImpl implements HomePresenter.MyView {

	interface Binder extends UiBinder<Widget, HomeView> {
	}
	
	@UiField
	HTMLPanel htmlPanel;

	@Inject
	HomeView(Binder uiBinder) {
		initWidget(uiBinder.createAndBindUi(this));
		
//		// Try to programmatically add a row, column and card
//		MaterialRow row=new MaterialRow();
//		
//	    MaterialColumn col=new MaterialColumn();
//	    col.setGrid("l4");
//	    row.add(col);
//	    
//	    MaterialCard card=new MaterialCard();
//	    card.setBackgroundColor(Color.BLUE_DARKEN_1);
//	    
//        MaterialCardContent cardContent=new MaterialCardContent();
//        cardContent.setTextColor(Color.WHITE);
//        
//        MaterialCardTitle cardTitle=new MaterialCardTitle();
//        cardTitle.setText("Sample");
//        cardTitle.setIconType(IconType.POLYMER);
//        cardTitle.setIconPosition(IconPosition.RIGHT);
//
//        MaterialLabel label=new MaterialLabel();
//        label.setText("Era uma vez um texto bastante extenso...");
//
//        cardContent.add(cardTitle);
//        cardContent.add(label);
//        
//        card.add(cardContent);
//	    
//	    col.add(card);      
//	    
//		htmlPanel.add(row);
	}
	
	private MaterialCard createCard(WorkbookDescriptionDTO wb) {
	    MaterialCard card=new MaterialCard();
	    card.setBackgroundColor(Color.BLUE_DARKEN_1);
	    
        MaterialCardContent cardContent=new MaterialCardContent();
        cardContent.setTextColor(Color.WHITE);
        
        MaterialCardTitle cardTitle=new MaterialCardTitle();
        cardTitle.setText(wb.getName());
        cardTitle.setIconType(IconType.POLYMER);
        cardTitle.setIconPosition(IconPosition.RIGHT);

        MaterialLabel label=new MaterialLabel();
        label.setText(wb.getDescription());

        cardContent.add(cardTitle);
        cardContent.add(label);
        
        card.add(cardContent);
		
        return card;
	}

	@Override
	public void setContents(ArrayList<WorkbookDescriptionDTO> contents) {
		// TODO Auto-generated method stub
		
		int colCount=1;
		
		MaterialRow row=null;
		
		for (WorkbookDescriptionDTO wb: contents) {
			MaterialCard card=createCard(wb);
			
			if (colCount==1) {
				row=new MaterialRow();
				htmlPanel.add(row);
				++colCount;
				if (colCount>=4) colCount=1;
			}

			MaterialColumn col=new MaterialColumn();
		    col.setGrid("l4");
		    row.add(col);
	
		    col.add(card); 		    
		}
		
	}
}