package nl.bhit.mTor.client.provider;

import nl.bhit.mTor.client.annotation.MTorMessage;
import nl.bhit.mTor.client.annotation.MTorMessageProvider;
import nl.bhit.model.Status;
import nl.bhit.model.soap.SoapMessage;

/**
 * This message provider has one method which will send a message with status INFO and content 'i am alive'
 * 
 */

@MTorMessageProvider
public class IAmAliveMTorMessageProvider {
	
	@MTorMessage
	public static SoapMessage sendIAmAliveMessage() {
		SoapMessage message = new SoapMessage();
		message.setContent("I am alive!");
		message.setStatus(Status.INFO);
		return message;
	}
}
