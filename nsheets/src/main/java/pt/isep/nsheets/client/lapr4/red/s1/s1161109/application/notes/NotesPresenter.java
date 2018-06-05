package pt.isep.nsheets.client.lapr4.red.s1.s1161109.application.notes;

import com.google.gwt.core.client.GWT;
import com.google.gwt.event.dom.client.ClickEvent;
import com.google.gwt.event.dom.client.ClickHandler;
import com.google.gwt.user.client.rpc.AsyncCallback;
import com.google.inject.Inject;
import com.google.web.bindery.event.shared.EventBus;
import com.gwtplatform.mvp.client.Presenter;
import com.gwtplatform.mvp.client.View;
import com.gwtplatform.mvp.client.annotations.ProxyStandard;
import com.gwtplatform.mvp.client.proxy.ProxyPlace;
import com.gwtplatform.mvp.client.annotations.NameToken;
import com.gwtplatform.mvp.client.annotations.NoGatekeeper;
import gwt.material.design.client.ui.MaterialTextArea;
import gwt.material.design.client.ui.MaterialToast;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import pt.isep.nsheets.client.application.ApplicationPresenter;
import pt.isep.nsheets.client.application.home.HomePresenter;
import pt.isep.nsheets.client.place.NameTokens;
import pt.isep.nsheets.server.lapr4.red.s1.core.n1161109.notes.domain.Note;
import pt.isep.nsheets.shared.services.DataException;
import pt.isep.nsheets.shared.services.NoteDTO;
import pt.isep.nsheets.shared.services.NoteService;
import pt.isep.nsheets.shared.services.NoteServiceAsync;

public class NotesPresenter extends Presenter<NotesPresenter.MyView, NotesPresenter.MyProxy> {
    
    private MyView view;

    interface MyView extends View {
         
        MaterialTextArea getText();
         void addClickHandler(ClickHandler ch);
          
    }

    @NameToken(NameTokens.notes)
    @ProxyStandard
    @NoGatekeeper
    interface MyProxy extends ProxyPlace<NotesPresenter> {
    }

    @Inject
    NotesPresenter(EventBus eventBus, MyView view, MyProxy proxy) {
        super(eventBus, view, proxy, ApplicationPresenter.SLOT_CONTENT);
        this.view = view;
        
        
        this.view.addClickHandler((ClickEvent event) -> {
           
            NoteServiceAsync NoteSvc = GWT.create(NoteService.class);

            AsyncCallback<NoteDTO> callback = new AsyncCallback<NoteDTO>() {
                
                public void onFailure(Throwable caught) {
//                    MaterialToast.fireToast("Default name already in use! "+ caught.getMessage());
                }

                

                @Override
                public void onSuccess(NoteDTO result) {
//                    throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
                }

                
            };         
            
//            Note nt = new Note(getView().getText().getText());
//            
//            try {
//                NoteSvc.addNote(nt.toDTO());
//            } catch (DataException ex) {
//                Logger.getLogger(NotesPresenter.class.getName()).log(Level.SEVERE, null, ex);
//            }

        });
        

    }

    @Override
    protected void onReveal() {
        super.onReveal();
    }
}
