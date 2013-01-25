package nl.bhit.service;

import javax.jws.WebMethod;
import javax.jws.WebService;

import nl.bhit.model.Message;
import nl.bhit.model.soap.SoapMessage;
 
@WebService
public interface MessageManager extends GenericManager<Message, Long> {
	Message saveMessage(SoapMessage message);

	@WebMethod(
			exclude = false,
			operationName = "saveSoapMessage",
			action = "saveSoapMessage")
	void saveSoapMessage(SoapMessage message);

}