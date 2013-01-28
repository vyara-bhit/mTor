package nl.bhit.mTor.client;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.stereotype.Component;

@Component
public class Timer {
	protected final Log log = LogFactory.getLog(MessageServiceClient.class);

	/**
	 * is called from the timer.
	 */
	public void process() {
		log.debug("starting up the timed processor.");
		MessageServiceClient client = new MessageServiceClient();
		client.addMessage();
	}
}
