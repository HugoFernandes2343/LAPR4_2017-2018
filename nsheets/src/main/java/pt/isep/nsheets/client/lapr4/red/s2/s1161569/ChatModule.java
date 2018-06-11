package pt.isep.nsheets.client.lapr4.red.s2.s1161569;



import com.gwtplatform.mvp.client.gin.AbstractPresenterModule;



public class ChatModule extends AbstractPresenterModule {
    @Override
    protected void configure() {
        bindPresenter(ChatPresenter.class, ChatPresenter.MyView.class, ChatView.class, ChatPresenter.MyProxy.class);
    }
}