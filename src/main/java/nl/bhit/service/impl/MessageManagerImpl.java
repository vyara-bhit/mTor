package nl.bhit.service.impl;

import javax.jws.WebService;

import nl.bhit.dao.MessageDao;
import nl.bhit.model.Message;
import nl.bhit.model.Project;
import nl.bhit.model.soap.SoapMessage;
import nl.bhit.service.GenericManager;
import nl.bhit.service.MessageManager;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service("messageManager")
@WebService(
		serviceName = "MessageService",
		endpointInterface = "nl.bhit.service.MessageManager")
public class MessageManagerImpl extends GenericManagerImpl<Message, Long> implements MessageManager {
	MessageDao messageDao;
	@Autowired
	private GenericManager<Project, Long> projectManager;

	@Autowired
	public MessageManagerImpl(MessageDao messageDao) {
		super(messageDao);
		this.messageDao = messageDao;
	}

	@Override
	public Message saveMessage(SoapMessage soapMessage) {
		Message message = soapMessageToMessage(soapMessage);
		return messageDao.save(message);
	}

	protected Message soapMessageToMessage(SoapMessage soapMessage) {
		Project project = projectManager.get(soapMessage.getProjectId());
		Message message = new Message();
		BeanUtils.copyProperties(soapMessage, message);
		message.setProject(project);
		return message;
	}

	public void setProjectManager(GenericManager<Project, Long> projectManager) {
		this.projectManager = projectManager;
	}
}