package nl.bhit.service.impl;

import javax.jws.WebService;

import nl.bhit.dao.MessageDao;
import nl.bhit.model.Message;
import nl.bhit.service.MessageManager;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service("messageManager")
@WebService(
		serviceName = "MessageService",
		endpointInterface = "nl.bhit.service.MessageManager")
public class MessageManagerImpl extends GenericManagerImpl<Message, Long> implements MessageManager {
	MessageDao messageDao;

	@Autowired
	public MessageManagerImpl(MessageDao messageDao) {
		super(messageDao);
		this.messageDao = messageDao;
	}

	@Override
	public Message saveMessage(Message message) {
		return messageDao.save(message);
	}
}