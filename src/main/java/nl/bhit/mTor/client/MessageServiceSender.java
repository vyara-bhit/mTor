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

import org.apache.axis2.AxisFault;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.beans.factory.config.BeanDefinition;
import org.springframework.context.annotation.ClassPathScanningCandidateComponentProvider;
import org.springframework.core.io.support.PathMatchingResourcePatternResolver;
import org.springframework.core.type.filter.AnnotationTypeFilter;

public class MessageServiceSender {

	protected final Log log = LogFactory.getLog(MessageServiceSender.class);
	Properties properties;
	private final static ClassPathScanningCandidateComponentProvider provider = new ClassPathScanningCandidateComponentProvider(false);

	public MessageServiceSender() {
		properties = new Properties();
		try {
			properties.load(this.getClass().getResourceAsStream("/mTor.properties"));
		} catch (IOException e) {
			log.error("Can't start sending messages with this reader either, io exception", e);
		}

		log.trace("props loaded");
	}

	public void addMessage() throws SecurityException, ClassNotFoundException, IllegalArgumentException, IllegalAccessException, InvocationTargetException {
		provider.addIncludeFilter(new AnnotationTypeFilter(MTorMessageProvider.class));
		provider.setResourceLoader(new PathMatchingResourcePatternResolver(this.getClass().getClassLoader()));
		final Set<BeanDefinition> candidates = provider.findCandidateComponents("nl.bhit");
		for (BeanDefinition beanDefinition : candidates) {
			log.debug("found bean: " + beanDefinition);

			for (Method method : Class.forName(beanDefinition.getBeanClassName()).getMethods()) {
				if (method.isAnnotationPresent(MTorMessage.class)) {
					nl.bhit.model.soap.SoapMessage soapMessage = (nl.bhit.model.soap.SoapMessage) method.invoke(null, (Object[]) null);
					sendMessage(soapMessage);
				}
			}
		}

	}

	protected void sendMessage(nl.bhit.model.soap.SoapMessage soapMessage) {
		log.debug("trying to add a message to the soap service");
		if (soapMessage == null) {
			log.trace("no message provided");
			return;
		}
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
		nl.bhit.mTor.client.wsdl.MessageServiceStub.SoapMessage wsdlMessage = new nl.bhit.mTor.client.wsdl.MessageServiceStub.SoapMessage();
		wsdlMessage.setContent(soapMessage.getContent());
		wsdlMessage.setStatus(getStatus(soapMessage.getStatus()));
		wsdlMessage.setProjectId(getPorjectId());
		req1.setArg0(wsdlMessage);
		req.setSaveSoapMessage(req1);

		MessageServiceStub.SaveSoapMessageResponseE result = null;
		try {
			result = stub.saveSoapMessage(req);
		} catch (RemoteException e) {
			log.error("could not send message to mTor!", e);
		}
		log.debug("result:" + result);
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
