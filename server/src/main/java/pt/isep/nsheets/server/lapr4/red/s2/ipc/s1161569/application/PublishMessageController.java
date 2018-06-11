package pt.isep.nsheets.server.lapr4.red.s2.ipc.s1161569.application;

import eapli.framework.persistence.DataConcurrencyException;
import eapli.framework.persistence.DataIntegrityViolationException;
import pt.isep.nsheets.server.lapr4.red.s2.ipc.s1161569.domain.Message;
import pt.isep.nsheets.server.lapr4.white.s1.core.n4567890.workbooks.persistence.MessageRepository;
import pt.isep.nsheets.server.lapr4.white.s1.core.n4567890.workbooks.persistence.PersistenceContext;
import pt.isep.nsheets.shared.services.MessageDTO;

import java.util.ArrayList;

public class PublishMessageController {
    public ArrayList<MessageDTO> getMessages() {
        final MessageRepository messageRepository = PersistenceContext.repositories().messages();
        Iterable<Message> messageList=messageRepository.findAll();
        ArrayList<MessageDTO> dtoList=new ArrayList<>();
        for(Message message:messageList){
            dtoList.add(message.toDTO());
        }
        return dtoList;
    }

    public MessageDTO addMessage(MessageDTO mDto) throws DataConcurrencyException, DataIntegrityViolationException{
        final MessageRepository messageRepository = PersistenceContext.repositories().messages();
        Message message=Message.fromDTO(mDto);
        messageRepository.save(message);
        return message.toDTO();
    }
}
