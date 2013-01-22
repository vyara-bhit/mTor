package nl.bhit.service;

import javax.jws.WebMethod;
import javax.jws.WebService;

import nl.bhit.model.Message;

@WebService
public interface MessageManager extends GenericManager<Message, Long> {

	@WebMethod(
			operationName = "test")
	Message saveMessage(Message message);

}