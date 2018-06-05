package pt.isep.nsheets.client.lapr4.red.s1.s1161109.application.notes;

import com.google.gwt.event.dom.client.ClickHandler;
import javax.inject.Inject;

import com.google.gwt.uibinder.client.UiBinder;
import com.google.gwt.uibinder.client.UiField;
import com.google.gwt.user.client.ui.HTMLPanel;
import com.google.gwt.user.client.ui.Widget;
import com.gwtplatform.mvp.client.ViewImpl;
import gwt.material.design.client.ui.MaterialButton;
import gwt.material.design.client.ui.MaterialTextArea;
import java.util.List;
import pt.isep.nsheets.server.lapr4.red.s1.core.n1161109.notes.domain.Note;


class NotesView extends ViewImpl implements NotesPresenter.MyView {

    
    @UiField
    HTMLPanel htmlPanel;

    @UiField
    MaterialTextArea text;
    
    @UiField
    MaterialButton guardar;

  
    
    interface Binder extends UiBinder<Widget, NotesView> {
    }
   

    @Inject
    NotesView(Binder uiBinder) {
        initWidget(uiBinder.createAndBindUi(this));
        
    }
    
    @Override
     public void addClickHandler(ClickHandler ch) {
        // TODO Auto-generated method stub

        guardar.addClickHandler(ch);
    }

    @Override
    public MaterialTextArea getText() {
        return text;
    }
     
    
   
}

   


