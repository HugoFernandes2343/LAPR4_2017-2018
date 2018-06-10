package pt.isep.nsheets.shared.services;

import com.google.gwt.user.client.rpc.AsyncCallback;

import java.util.ArrayList;

public interface ChatServiceAsync {
    void getMessages(AsyncCallback<ArrayList<MessageDTO>> callback);
    void addMessage(MessageDTO mDto, AsyncCallback<MessageDTO> async);
}
