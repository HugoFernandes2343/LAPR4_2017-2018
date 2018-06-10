package pt.isep.nsheets.shared.services;

import com.google.gwt.user.client.rpc.RemoteService;
import com.google.gwt.user.client.rpc.RemoteServiceRelativePath;

import java.util.ArrayList;

@RemoteServiceRelativePath("chatService")
public interface ChatService extends RemoteService {
    ArrayList<MessageDTO> getMessages();
    MessageDTO addMessage(MessageDTO mDto) throws DataException;
}
