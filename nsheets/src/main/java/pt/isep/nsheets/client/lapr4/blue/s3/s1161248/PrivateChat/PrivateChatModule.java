package pt.isep.nsheets.client.lapr4.blue.s3.s1161248.PrivateChat;

import com.gwtplatform.mvp.client.gin.AbstractPresenterModule;
import pt.isep.nsheets.client.lapr4.blue.s2.s1161248.Agenda.AgendaPresenter;
import pt.isep.nsheets.client.lapr4.blue.s2.s1161248.Agenda.AgendaView;

public class PrivateChatModule extends AbstractPresenterModule {
    @Override
    protected void configure() {
        bindPresenter(PrivateChatPresenter.class, PrivateChatPresenter.MyView.class, PrivateChatView.class, PrivateChatPresenter.MyProxy.class);
    }
}
