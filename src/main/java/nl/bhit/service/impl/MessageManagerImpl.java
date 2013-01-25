package nl.bhit.service.impl;

import nl.bhit.dao.MessageDao;
import nl.bhit.model.Message;
import nl.bhit.service.MessageManager;
import nl.bhit.service.impl.GenericManagerImpl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import javax.jws.WebService;

@Service("messageManager")
@WebService(serviceName = "MessageService", endpointInterface = "nl.bhit.service.MessageManager")
public class MessageManagerImpl extends GenericManagerImpl<Message, Long> implements MessageManager {
    MessageDao messageDao;

    @Autowired
    public MessageManagerImpl(MessageDao messageDao) {
        super(messageDao);
        this.messageDao = messageDao;
    }
}