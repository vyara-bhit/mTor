package nl.bhit.mTor.client;

import java.io.IOException;
import java.rmi.RemoteException;
import java.util.Properties;

import nl.bhit.mTor.client.wsdl.MessageServiceStub;
import nl.bhit.mTor.client.wsdl.MessageServiceStub.SoapMessage;
import nl.bhit.mTor.client.wsdl.MessageServiceStub.Status;

import org.apache.axis2.AxisFault;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

public class MessageServiceSender {

	protected final Log log = LogFactory.getLog(MessageServiceSender.class);
	Properties properties;

	public MessageServiceSender() {
		properties = new Properties();
		try {
			properties.load(this.getClass().getResourceAsStream("/mTor.properties"));
		} catch (IOException e) {
			log.error("Can't start sending messages with this reader either, io exception", e);
		}

		log.trace("props loaded");
	}

	public void addMessage() {
		log.debug("trying to add a message to the soap service");
		MessageServiceStub stub = null;
		try {
			String connectionUrl = properties.getProperty("mTor.server.url");
			log.debug("connecting to: " + connectionUrl);
			stub = new MessageServiceStub(connectionUrl);
		} catch (AxisFault e) {
			log.error("could not create messageServiceStub to send message to mTor!", e);
		}
		MessageServiceStub.SaveSoapMessageE req = new MessageServiceStub.SaveSoapMessageE();
		MessageServiceStub.SaveSoapMessage req1 = new MessageServiceStub.SaveSoapMessage();
		SoapMessage soapMessage = new SoapMessage();
		soapMessage.setContent("i am alive signal");
		soapMessage.setProjectId(getPorjectId());
		soapMessage.setStatus(Status.INFO);
		req1.setArg0(soapMessage);
		req.setSaveSoapMessage(req1);

		MessageServiceStub.SaveSoapMessageResponseE result = null;
		try {
			result = stub.saveSoapMessage(req);
		} catch (RemoteException e) {
			log.error("could not send message to mTor!", e);
		}
		log.trace("found content:" + result);
	}

	protected Long getPorjectId() {
		Long projectId = null;
		try {
			String projectIdStr = properties.getProperty("mTor.project.id");
			projectId = new Long(projectIdStr);
		} catch (Exception e) {
			log.error("could not read the projectId so message can not be send, no monitoring possible!", e);
		}
		log.debug("using projectId:" + projectId);
		return projectId;
	}

}
