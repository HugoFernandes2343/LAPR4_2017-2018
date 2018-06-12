package pt.isep.nsheets.client.application.menu;

import com.gwtplatform.mvp.client.UiHandlers;

interface MenuUiHandlers extends UiHandlers {
	
	void setContentPush();
        
        void reloadUser();
}