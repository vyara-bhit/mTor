package nl.bhit.mTor.client;

import java.rmi.RemoteException;

import nl.bhit.mTor.client.wsdl.MessageServiceStub;
import nl.bhit.mTor.client.wsdl.MessageServiceStub.SoapMessage;
import nl.bhit.mTor.client.wsdl.MessageServiceStub.Status;

import org.apache.axis2.AxisFault;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

public class MessageServiceClient {

	protected final Log log = LogFactory.getLog(MessageServiceClient.class);

	public void addMessage() {
		log.debug("trying to add a message to the soap service");
		MessageServiceStub stub = null;
		try {
			stub = new MessageServiceStub();
		} catch (AxisFault e) {
			log.fatal("could not create messageServiceStub to send message to mTor!", e);
		}
		MessageServiceStub.SaveSoapMessageE req = new MessageServiceStub.SaveSoapMessageE();
		MessageServiceStub.SaveSoapMessage req1 = new MessageServiceStub.SaveSoapMessage();
		SoapMessage soapMessage = new SoapMessage();
		soapMessage.setContent("test from soap client");
		soapMessage.setProjectId(-1l);
		soapMessage.setStatus(Status.INFO);
		req1.setArg0(soapMessage);
		req.setSaveSoapMessage(req1);

		MessageServiceStub.SaveSoapMessageResponseE result = null;
		try {
			result = stub.saveSoapMessage(req);
		} catch (RemoteException e) {
			log.fatal("could not send message to mTor!", e);
		}
		log.trace("found content:" + result);
	}

}
