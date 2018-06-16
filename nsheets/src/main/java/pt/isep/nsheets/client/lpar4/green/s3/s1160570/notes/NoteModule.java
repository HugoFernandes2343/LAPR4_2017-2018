package pt.isep.nsheets.client.lpar4.green.s3.s1160570.notes;

import com.gwtplatform.mvp.client.gin.AbstractPresenterModule;



public class NoteModule extends AbstractPresenterModule {
    @Override
    protected void configure() {
        bindPresenter(NotePresenter.class, NotePresenter.MyView.class, NoteView.class, NotePresenter.MyProxy.class);
    }
}