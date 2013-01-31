package nl.bhit.mTor.client;

import java.io.IOException;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.rmi.RemoteException;
import java.util.Properties;
import java.util.Set;

import nl.bhit.mTor.client.annotation.MTorMessage;
import nl.bhit.mTor.client.annotation.MTorMessageProvider;
import nl.bhit.mTor.client.wsdl.MessageServiceStub;
import nl.bhit.mTor.client.wsdl.MessageServiceStub.Status;
import nl.bhit.mtor.util.AnnotationUtil;

import org.apache.axis2.AxisFault;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.beans.factory.config.BeanDefinition;

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

	/**
	 * will search for all @MTorMessageProvider classes and invoke the @MTorMessage methods for retrieval of the messages. These messages will be send via soap
	 * to the mTor server.
	 * Possible errors will be logged but will not influence the project (will be kept quiet).
	 */
	public void sendMessages() {
		try {
			final Set<BeanDefinition> candidates = AnnotationUtil.findProviders(MTorMessageProvider.class, "nl.bhit");
			for (BeanDefinition beanDefinition : candidates) {
				sendMessageForThisProvider(beanDefinition);
			}
		} catch (Exception e) {
			log.warn("There is a problem in sending the mTor messages via soap. Monitoring will not work", e);
		}
	}

	protected void sendMessageForThisProvider(BeanDefinition beanDefinition) throws IllegalAccessException, InvocationTargetException {
		log.debug("found bean: " + beanDefinition);

		for (Method method : AnnotationUtil.findMethods(MTorMessage.class, beanDefinition)) {
			nl.bhit.model.soap.SoapMessage soapMessage = (nl.bhit.model.soap.SoapMessage) method.invoke(null, (Object[]) null);
			sendMessage(soapMessage);
		}
	}

	protected void sendMessage(nl.bhit.model.soap.SoapMessage soapMessage) {
		log.debug("trying to add a message to the soap service");
		if (soapMessage == null) {
			log.trace("no message provided");
			return;
		}
		MessageServiceStub stub = createMessageServiceStub();
		MessageServiceStub.SaveSoapMessageE req = addSoapMessageToStub(soapMessage);
		sendSoapMessage(stub, req);
	}

	protected void sendSoapMessage(MessageServiceStub stub, MessageServiceStub.SaveSoapMessageE req) {
		MessageServiceStub.SaveSoapMessageResponseE result = null;
		try {
			result = stub.saveSoapMessage(req);
		} catch (RemoteException e) {
			log.error("could not send message to mTor!", e);
		}
		log.trace("result:" + result);
	}

	protected MessageServiceStub.SaveSoapMessageE addSoapMessageToStub(nl.bhit.model.soap.SoapMessage soapMessage) {
		MessageServiceStub.SaveSoapMessageE req = new MessageServiceStub.SaveSoapMessageE();
		MessageServiceStub.SaveSoapMessage req1 = new MessageServiceStub.SaveSoapMessage();
		req1.setArg0(createWsdlMessage(soapMessage));
		req.setSaveSoapMessage(req1);
		return req;
	}

	protected nl.bhit.mTor.client.wsdl.MessageServiceStub.SoapMessage createWsdlMessage(nl.bhit.model.soap.SoapMessage soapMessage) {
		nl.bhit.mTor.client.wsdl.MessageServiceStub.SoapMessage wsdlMessage = new nl.bhit.mTor.client.wsdl.MessageServiceStub.SoapMessage();
		wsdlMessage.setContent(soapMessage.getContent());
		wsdlMessage.setStatus(getStatus(soapMessage.getStatus()));
		wsdlMessage.setProjectId(getPorjectId());
		return wsdlMessage;
	}

	protected MessageServiceStub createMessageServiceStub() {
		MessageServiceStub stub = null;
		try {
			String connectionUrl = properties.getProperty("mTor.server.url");
			log.debug("connecting to: " + connectionUrl);
			stub = new MessageServiceStub(connectionUrl);
		} catch (AxisFault e) {
			log.error("could not create messageServiceStub to send message to mTor!", e);
		}
		return stub;
	}

	private static Status getStatus(nl.bhit.model.Status status) {
		if (status == nl.bhit.model.Status.INFO) return Status.INFO;
		if (status == nl.bhit.model.Status.WARN) return Status.WARN;
		return Status.ERROR;
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
